import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import core.Line;
import core.Metro;
import core.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static final String URL = "https://www.moscowmap.ru/metro.html#lines";
    private static final String PATH = "C:\\Users\\ksit\\java_basics\\09_FilesAndNetwork\\homework_9.5\\src\\main\\resources\\mosMetro.json";


    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect(URL).maxBodySize(0).get();
            Elements elementsOfLines = document.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
            List<Line> listOfLines = new ArrayList<>();

            Map<String, String> namesOfLines = elementsOfLines.stream()
                    .collect(Collectors.toMap((k) -> k.attr("data-line"), Element::text));
            namesOfLines.forEach((k, v) -> listOfLines.add(new Line(k, v)));

            Elements elementsOfStations = document.getElementsByClass("js-metro-stations");
            Map<String, List<Station>> listOfStations = new HashMap<>();

            elementsOfStations.forEach(el -> {
                el.children().forEach(element -> {
                    if (!listOfStations.containsKey(el.attr("data-line"))) {
                        listOfStations.put((el.attr("data-line")), new ArrayList<>());
                    }
                    listOfStations.get(el.attr("data-line")).add(new Station(element.getElementsByClass("name").text()));
                });
            });
            System.out.println(listOfStations);
            Metro metro = new Metro(listOfLines, listOfStations);
            ObjectMapper mapper = new ObjectMapper();

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(PATH), metro);

            BufferedReader bf = new BufferedReader(new FileReader(PATH));
            ObjectNode root = (ObjectNode)new ObjectMapper().readTree(bf);
            int count = 0;
            for (Iterator<JsonNode> i = root.get("stations").iterator(); i.hasNext();){
                if( i.next().hasNonNull(""))
                count++;
            }
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}