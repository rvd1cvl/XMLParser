import java.util.List;

public class test {

    public static void main(String[] args) {

        String filePath = "/Users/mihailzilcov/Desktop/ideaProjects/XMLParser/src/main/resources/getData_CNSI_norm.xml";
        // Вызываем парсер и получаем данные из XML
        ParsedData parsedData = XmlParser.parseXmlFile(filePath);

        // Получаем списки IGWORK и IWORK из ParsedData
        List<IGWORK> igWorksList = parsedData.getIgWorksList();
        List<IWORK> iWorksList = parsedData.getIWorksList();

        // Теперь можно использовать списки igWorksList и iWorksList по мере необходимости
        System.out.println("Список элементов IGWORK:");
        for (IGWORK igWork : igWorksList) {
            System.out.println(igWork.toString());
        }

        System.out.println("\nСписок элементов IWORK:");
        for (IWORK iWork : iWorksList) {
            System.out.println(iWork.toString());
        }
    }
}
