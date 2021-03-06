import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Main {
    private static final String DST_FOLDER      = "images";
    private static final String SOURCE_URL      = "https://lenta.ru";
    private static final String REGEX_URL_IMAGE = ".+\\.(jpe?g|png|gif|svg)";

    public static void main(String[] args) throws IOException {
        createDirectory(DST_FOLDER);

        Document doc = Jsoup.connect(SOURCE_URL).get();
        Elements elements = doc.getElementsByTag("img"); // собрать строки с тегами img

        int i = 1;
        for (Element e : elements) {
            String link = e.attr("abs:src"); // строка с тегом img и атрибутом src
            if(link.matches(REGEX_URL_IMAGE)){         // выделить ссылку на изображение
                System.out.print(i + ": ");
                downloadImage(link, DST_FOLDER);
                i++;
            }
        }
    }

    private static void downloadImage(String srcUrl, String dstDir) throws IOException {
        String fileName = srcUrl.replaceAll("(.+)(/.+)$", "$2");
        System.out.println(dstDir + fileName);

        BufferedInputStream  bis = new BufferedInputStream(
                new URL(srcUrl).openStream());
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(new File(dstDir + fileName)));

        byte[] buffer = new byte[2048];
        int bytes = bis.read(buffer);

        while (bytes != -1) {
            bos.write(buffer, 0, bytes);
            bytes = bis.read(buffer);
        }

        bos.flush();
        bos.close();
        bis.close();
    }

    private static void createDirectory(String dstDir) {
        File path = new File(dstDir);
        if (!path.exists()) {
            if (!path.mkdirs()) {
                System.out.println("Directory creation error...");
            }
        }
    }

}
