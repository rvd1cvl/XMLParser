import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {

    // Метод для парсинга XML-файла и возврата списков IGWORK и IWORK
    public static ParsedData parseXmlFile(String filePath) {
        ParsedData data = new ParsedData();
        try {
            // Открываем XML-файл для парсинга
            File inputFile = new File(filePath);

            // Инициализируем фабрику и построитель для DOM-парсинга
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Получаем объект Document, представляющий XML-документ
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Создаем списки для хранения данных элементов IGWORK и IWORK
            List<IGWORK> igWorksList = new ArrayList<>();
            List<IWORK> iWorksList = new ArrayList<>();

            // Ищем элементы IGWORK в документе
            NodeList igWorkNodes = doc.getElementsByTagName("IGWORK");
            for (int temp = 0; temp < igWorkNodes.getLength(); temp++) {
                // Получаем текущий узел элемента IGWORK
                Node node = igWorkNodes.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Преобразуем узел в элемент, чтобы получить доступ к его дочерним элементам
                    Element element = (Element) node;

                    // Создаем объект IGWORK и заполняем его данными из XML
                    IGWORK igWork = new IGWORK();
                    igWork.setID(element.getElementsByTagName("ID").item(0).getTextContent());
                    igWork.setKODSS(element.getElementsByTagName("KODSS").item(0).getTextContent());
                    igWork.setSHORT_NAME(element.getElementsByTagName("SHORT_NAME").item(0).getTextContent());
                    igWork.setNAME(element.getElementsByTagName("NAME").item(0).getTextContent());

                    // Добавляем объект IGWORK в список
                    igWorksList.add(igWork);
                }
            }

            // Ищем элементы IWORK в документе
            NodeList iWorkNodes = doc.getElementsByTagName("IWORK");
            for (int temp = 0; temp < iWorkNodes.getLength(); temp++) {
                // Получаем текущий узел элемента IWORK
                Node node = iWorkNodes.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Преобразуем узел в элемент, чтобы получить доступ к его дочерним элементам
                    Element element = (Element) node;

                    // Создаем объект IWORK и заполняем его данными из XML
                    IWORK iWork = new IWORK();
                    iWork.setID(element.getElementsByTagName("ID").item(0).getTextContent());
                    iWork.setID_G(element.getElementsByTagName("ID_G").item(0).getTextContent());
                    iWork.setKODSS(element.getElementsByTagName("KODSS").item(0).getTextContent());
                    iWork.setSHORT_NAME(element.getElementsByTagName("SHORT_NAME").item(0).getTextContent());
                    iWork.setNAME(element.getElementsByTagName("NAME").item(0).getTextContent());
                    iWork.setWGN(element.getElementsByTagName("WGN").item(0).getTextContent());

                    // Добавляем объект IWORK в список
                    iWorksList.add(iWork);
                }
            }

            // Сохраняем списки IGWORK и IWORK в объект ParsedData
            data.setIgWorksList(igWorksList);
            data.setIWorksList(iWorksList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}