package org.trlove.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.trlove.common.test.util.guava.Person;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * Test
 *
 * @author 奕超
 * @date 2017/2/10
 */
public class TestHttpClient {

	@Test
	public void test1() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// HttpGet httpGet = new HttpGet("http://paper.seebug.org/135/");
		HttpGet httpGet = new HttpGet(
		        "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=a&rsv_pq=df15efd50003312d&rsv_t=e113qgo6LNRvrUHAHSdr1PYLfH4G4w1gYx4PsrBO1rkquxV9A8J%2FuGtIqRc&rqlang=cn&rsv_enter=1&rsv_sug3=2&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&inputT=625&rsv_sug4=2024");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		try {
			// BufferedHttpEntity实际是将流数据读取到byte[] buffer中,
			// 而response.getEntity()返回DecompressingEntity,实际存储的还是InputStream
			HttpEntity entity = new BufferedHttpEntity(response.getEntity());
			System.out.println(EntityUtils.toString(entity, "UTF-8"));
			// System.out.println("second");
			// System.out.println(EntityUtils.toString(entity, "UTF-8"));
			System.out.println(response.getProtocolVersion());
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().getReasonPhrase());
			System.out.println(response.getStatusLine().toString());
			System.out.println(entity.getContentType().toString());
			List<Header> headerList = Lists.newArrayList(response.getAllHeaders());
			headerList.forEach(header -> System.out.println(header.getName() + ":" + header.getValue()));
			EntityUtils.consume(entity);
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
			        Lists.newArrayList(new BasicNameValuePair("a", "1"), new BasicNameValuePair("b", "2")),
			        Consts.UTF_8);
			HttpPost httpPost = new HttpPost("http://localhost/handler.do");
			httpPost.setEntity(formEntity);
		} finally {
			response.close();
			httpClient.close();
		}
	}

	@Test
	public void testResponseHandler() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet("http://paper.seebug.org/135/");
			ResponseHandler<Person> responseHandler = new ResponseHandler<Person>() {
				@Override
				public Person handleResponse(HttpResponse response) throws IOException {
					StatusLine statusLine = response.getStatusLine();
					HttpEntity entity = response.getEntity();
					if (statusLine.getStatusCode() >= 300) {
						throw new HttpResponseException(
			                    statusLine.getStatusCode(),
			                    statusLine.getReasonPhrase());
					}
					if (entity == null) {
						throw new ClientProtocolException("Response contains no content");
					}
					ContentType contentType = ContentType.getOrDefault(entity);
					Charset charset = contentType.getCharset();
					return JSON.parseObject(entity.getContent(), charset, Person.class);
				}
			};
			Person person = httpClient.execute(httpGet, responseHandler);
		} finally {
			httpClient.close();
		}
	}

	@Test
	public void testLoginNdsm() throws IOException, URISyntaxException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/ndsm/login/do");
		StringEntity entity = new StringEntity(
		        JSONObject.toJSONString(
		                ImmutableMap.of("password", "e10adc3949ba59abbe56e057f20f883e", "phone", "10112349805")),
		        Consts.UTF_8);

		httpPost.setEntity(entity);
		httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
		HttpResponse response = httpClient.execute(httpPost);
		List<Header> headerList = Lists.newArrayList(response.getAllHeaders());
		entity = new StringEntity(JSONObject.toJSONString(ImmutableMap.of("page",1, "pageSize",10)));
		httpPost.setURI(new URIBuilder()
				.setScheme("http")
				.setHost("localhost").setPort(8080)
				.setPath("/ndsm/member/list")
				.build());
		response = httpClient.execute(httpPost);
		httpPost.setEntity(entity);
		HttpEntity responseEntity = response.getEntity();
		System.out.println(EntityUtils.toString(responseEntity));
	}

}
