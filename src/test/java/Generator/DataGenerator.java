package Generator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DataGenerator {

    // Метод для генерации тестовых данных и сохранения их в XML
    public void generateData(String name, String password) {
        // Сохраняем переданные данные в XML
        saveToXml(name, password);
    }

    // Метод для сохранения данных в XML файл
    private void saveToXml(String name, String password) {
        try {
            // Создаем фабрику для создания объекта DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Создаем новый документ XML
            Document document = builder.newDocument();

            // Создаем корневой элемент
            Element rootElement = document.createElement("testdata");
            document.appendChild(rootElement);

            // Добавляем элементы с переданными данными
            Element nameElement = document.createElement("username");
            nameElement.appendChild(document.createTextNode(name));
            rootElement.appendChild(nameElement);

            Element passwordElement = document.createElement("password");
            passwordElement.appendChild(document.createTextNode(password));
            rootElement.appendChild(passwordElement);

            // Создаем трансформер для сохранения XML в файл
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            // Сохраняем XML-файл
            transformer.transform(new DOMSource(document), new StreamResult(new File("testdata.xml")));

            System.out.println("Test data generated successfully and saved to testdata.xml.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
