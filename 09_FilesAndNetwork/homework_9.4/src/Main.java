import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.jsoup.select.Elements;
        import java.io.*;
        import java.net.MalformedURLException;
        import java.net.URL;

public class Main {
    private static final String url = "https://www.lenta.ru/";
    private static final String destinationDirectory = "C:\\Users\\maksi\\Desktop\\test";

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("img");
        for (Element el : elements) {
            String src = el.absUrl("src");
            System.out.println(src);
            getImages(src);
        }
    }

    private static void getImages(String src) {
        try {
            String name = src.substring(src.lastIndexOf("/"));
            URL url = new URL(src);
            InputStream inputStream = url.openStream();
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream( destinationDirectory + name));
            for (int i; (i = inputStream.read()) != -1;) {
                outputStream.write(i); }
            outputStream.close();
            inputStream.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}