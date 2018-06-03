package com.team.utils;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {

	// 解析XML
	public static Object createObject(String name) {
		try {
			// 通过传递过来的name，获取application.xml中对应的calss值
			// 获取Document对象
			SAXReader reader = new SAXReader();
			// 如何获取文件的输入流,前提条件必须位于src下
			InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("application.xml");
			Document doc = reader.read(is);
			// 获取到文档中的根节点beans
			Element root = doc.getRootElement();
			List<Element> elements = root.elements();
			// 遍历集合，判断每个元素的id和当前的name是否一致
			for (Element element : elements) {
				// element相当与beans节点下的每个bean
				// 获取到当前节点id属性值
				String id = element.attributeValue("id");
				if (id.equals(name)) {
					String str = element.attributeValue("class");
					// 利用反射创建对象
					Class clazz = Class.forName(str);
					return clazz.newInstance();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
