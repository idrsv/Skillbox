import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    private static final String url = "https://lenta.ru/";
    private static final Path destinationDirectory = Path.of("D:/test.img");

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("img");
        elements.forEach(element -> {
            String imgRef = element.attr("abs:src");
            if (imgRef.contains("https")) {
                System.out.println(imgRef);
                try {
                    URL urlImg = new URL(imgRef);
                    InputStream inputStream = urlImg.openStream();
                    Path destination = Paths.get(String.valueOf(destinationDirectory));
                    Files.copy(inputStream, Paths.get(String.valueOf(destination)), StandardCopyOption.REPLACE_EXISTING);
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No image link");
            }
        });
    }
}
