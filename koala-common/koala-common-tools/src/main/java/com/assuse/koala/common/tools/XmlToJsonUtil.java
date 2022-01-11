package com.assuse.koala.common.tools;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

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
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return xmlToJsonByInputStream(inputStream);
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
