import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import core.Line;
import core.Metro;
import core.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    private static final String URL = "https://www.moscowmap.ru/metro.html#lines";
    private static final String PATH = "C:\\Users\\ksit\\java_basics\\09_FilesAndNetwork\\homework_9.5\\src\\main\\resources\\mosMetro.json";


    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect(URL).maxBodySize(0).get();
            Elements elementsOfLines = document.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
            List<Line> listOfLines = new ArrayList<>();
            Map<String,String> namesOfLines = elementsOfLines.stream()
                    .collect(Collectors.toMap((k) -> k.attr("data-line"), Element::text));
            namesOfLines.forEach((k, v) -> listOfLines.add(new Line(k, v)));

            Elements elementsOfStations = document.select("div.js-metro-stations.t-metrostation-list-table").select("span.name");

            Map<String, List<Station>> listOfStations = elementsOfStations.stream();

            Metro metro = new Metro(listOfLines,listOfStations);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(PATH), metro);
            System.out.println(listOfLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}