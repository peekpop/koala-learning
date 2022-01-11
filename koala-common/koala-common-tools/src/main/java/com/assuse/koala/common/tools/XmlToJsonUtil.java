package com.assuse.koala.common.tools;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * XML转jsong工具类
 */
public class XmlToJsonUtil {

    /**
     * 根据文件路径获取xml转为json字符串
     *
     * @param path 文件路径
     * @return
     */
    public static String xmlToJsonByPath(String path) {
        File file = new File(path);
        JSONObject jsonObject = XML.toJSONObject(file.toString());
        return jsonObject.toString();
    }

    /**
     * 以流的方式将xml转为json字符串
     *
     * @param inputStream xml文件输入流
     * @return
     */
    public static String xmlToJsonByInputStream(InputStream inputStream) {
        String str = null;
        try {
            str = IOUtils.toString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = XML.toJSONObject(str);
        return jsonObject.toString();
    }
}
