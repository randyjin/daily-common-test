/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Test.java
 * Author:   奕超
 * Date:    2017/2/10 下午2:30
 * Description:
 */
package org.trlove.http;

import com.alibaba.fastjson.JSON;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.trlove.common.test.util.guava.Person;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Test
 *
 * @author 奕超
 * @date 2017/2/10
 */
public class Test {

    public static void main(String[] args) throws IOException {
        testHttpGet();
    }

    private static void testHttpGet() throws IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            response = httpClient.execute(buildHttpGet());
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                System.out.println("get 200");
            }
            HttpEntity entity = response.getEntity();
            HttpEntity bufferEntity = new BufferedHttpEntity(entity); //entity的流已经被关闭,把数据读取到BufferedHttpEntity的byte[] buffer,这样就可以重复读取
            System.out.println(EntityUtils.toString(bufferEntity));
            System.out.println(EntityUtils.toString(bufferEntity));
//        System.out.println(EntityUtils.toString(entity, "UTF-8")); //用EntityUtils读取,用这个比较好,会自动关闭流(如果响应实体源自可靠的HTTP服务器和已知的长度限制,比较推荐)
//        System.out.println(IOUtils.toString(entity.getContent(), "UTF-8")); //用IOUtils读取,需要手动关闭流
//        EntityUtils.consume(entity); //消费流,其实现就是关闭流,当请求以后不需要处理内容,可以用这种方式把流关闭,把连接释放出来
        } finally {
            if(httpClient != null) {
                httpClient.close();
            }
            if(response != null) {
                response.close();
            }
        }
    }

    private static void testHttpManager() throws IOException, ExecutionException, InterruptedException {
        HttpClientContext context = HttpClientContext.create();
        HttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager();
        HttpRoute route = new HttpRoute(new HttpHost("localhost", 80));
        ConnectionRequest connRequest = connectionManager.requestConnection(route, null);
        HttpClientConnection conn = connRequest.get(10, TimeUnit.SECONDS);
        try {
            if (!conn.isOpen()) {
                connectionManager.connect(conn, route, 1000, context);
                connectionManager.routeComplete(conn, route, context);
            }
        } finally {
            connectionManager.releaseConnection(conn, null, 1, TimeUnit.MINUTES);
        }
    }

    private static void testHttpContext() throws IOException {
        HttpClientContext context = HttpClientContext.create();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://www.baidu.com/");
        ResponseHandler<Person> responseHandler = new ResponseHandler<Person>() {
            @Override
            public Person handleResponse(
                    final HttpResponse response) throws IOException {
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
                return JSON.parseObject(EntityUtils.toString(entity, contentType.getCharset()), Person.class);
            }
        };
        Person person = httpClient.execute(httpget, responseHandler, context); //将会关闭流和response
        httpClient.close(); //只需关闭httpclient
    }

    private static void testResponseHandler() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://www.baidu.com/");
        ResponseHandler<Person> responseHandler = new ResponseHandler<Person>() {
            @Override
            public Person handleResponse(
                    final HttpResponse response) throws IOException {
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
                return JSON.parseObject(EntityUtils.toString(entity, contentType.getCharset()), Person.class);
            }
        };
        Person person = httpClient.execute(httpget, responseHandler); //将会关闭流和response
        httpClient.close(); //只需关闭httpclient
    }

    private static HttpGet buildHttpGet() {
        HttpGet httpGet = new HttpGet("https://www.baidu.com/");
        return httpGet;
    }

    private static HttpGet buildHttpGetWithUri() throws URISyntaxException {
        URI uri = new URIBuilder().setScheme("https").setHost("www.baidu.com").setPath("/s").setParameter("wd", "java URI")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        return httpGet;
    }
}
