import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String URL = "https://www.moscowmap.ru/metro.html#lines";
    private static final String PATH = "C:\\Users\\ksit\\java_basics\\09_FilesAndNetwork\\homework_9.5\\src\\main\\resources\\mosMetro.json";
    private static final Pattern numberOfLine = Pattern.compile("(?<=ln-)\\w+");
    private static final Pattern nameOfLine = Pattern.compile("(?<=>).+(?=<)");

    private static JSONObject jsonObject = new JSONObject();
    private static JSONObject lineObject;
    private static JSONObject stationObject;
    private static JSONArray linesArray;
    private static JSONArray stationsArray;

    private static List<String> lineList = new ArrayList<>();
    private static int countLines;

    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter(PATH)) {
            addLinesAndStations();
            fileWriter.write(String.valueOf(jsonObject));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addLinesAndStations() throws IOException {
        Document document = Jsoup.connect(URL).maxBodySize(0).get();
        Elements elementsOfLines = document.select("div.js-toggle-depend");
        Elements elementsOfStations = document.select("span.num, span.name");

        Matcher matcherNumber = numberOfLine.matcher(elementsOfLines.html());
        Matcher matcherName = nameOfLine.matcher(elementsOfLines.html());

        linesArray = new JSONArray();
        while (matcherName.find() && matcherNumber.find()) {
            lineObject = new JSONObject();
            lineList.add(countLines, matcherNumber.group());
            lineObject.put("Number", matcherNumber.group());
            lineObject.put("Name", matcherName.group());
            linesArray.add(lineObject);
            countLines++;
        }

        String[] nameOfStation = elementsOfStations.text().split(" 1\\.");
        stationObject = new JSONObject();
        for (int i = 0; i < countLines; i++) {
            stationsArray = new JSONArray();
            Collections.addAll(stationsArray, nameOfStation[i].replaceAll("[0-9]+\\.", "").trim().split(" {2}"));
            stationObject.put(lineList.get(i), stationsArray);
        }

        jsonObject.put("Line", linesArray);
        jsonObject.put("Station", stationObject);
    }
}
