package com.assuse.koala.common.tools;

import java.io.InputStream;

/**
 * xml转json测试类
 */
public class XmlToJsonTest {
    public static void main(String[] args) {
        String path = XmlToJsonTest.class.getClassLoader().getResource("application.xml").getPath();
        String resPath = XmlToJsonUtil.xmlToJsonByPath(path);
        System.out.println(resPath);
        InputStream in = XmlToJsonTest.class.getClassLoader().getResourceAsStream("application.xml");
        String resInput = XmlToJsonUtil.xmlToJsonByInputStream(in);
        System.out.println(resInput);
    }
}
