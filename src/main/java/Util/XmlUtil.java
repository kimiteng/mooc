/**
 * @author: haiqing.teng
 * @since: 2021/5/7 11:50
 */
package Util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



import java.io.File;
import java.util.Iterator;
import java.util.List;

public class XmlUtil {
    /**
     * 获取xml指定字段的value
     * @return
     */
    public static String getXmlNodeValue(String filePath, String nodePath) throws Exception {
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = reader.read(new File("src/main/resources/TestInfo/config.xml"));
        //3.获取根节点
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Element element = (Element) iterator.next();
            System.out.println(element.attribute("name").getValue());
            List<Attribute> attributes = element.attributes();
            System.out.println("======获取属性值======");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        getXmlNodeValue("123","123");
    }
}
