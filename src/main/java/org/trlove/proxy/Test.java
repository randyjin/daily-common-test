package org.trlove.proxy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import sun.reflect.CallerSensitive;

/**
 * Test
 *
 * @author 奕超
 * @date 2017/5/11
 */
public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/aguda/Desktop/odysseuslog/kj1.log");
        List<String> lines = FileUtils.readLines(file);
        for(String line : lines) {
            System.out.println(line);
        }

    }

    private static void generate(String templatePath, String replacePath, String destPath) {

    }

    /**
     *
     * @param jsonTemplate
     * @param replacePath
     * @param value
     * @return
     */
    private static String replace(String jsonTemplate, String replacePath, String value) {
        JSONObject jsonObject = JSON.parseObject(jsonTemplate);
        JSONPath.set(jsonObject, replacePath, parseString2Obj(value));
        return jsonObject.toJSONString();
    }

    private static Object parseString2Obj(String value) {
        if(StringUtils.isBlank(value)) {
            value = "";
        }
        try{
            return JSON.parseObject(value);
        } catch (Exception e) {
            return value;
        }
    }



}
