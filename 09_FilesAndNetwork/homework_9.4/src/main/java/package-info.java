//https://ru.stackoverflow.com/questions/912371/%D0%97%D0%B0%D1%87%D0%B5%D0%BC-bufferedinputstream-%D0%B5%D1%81%D0%BB%D0%B8-inputstream-%D0%BF%D1%80%D0%B5%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BB%D1%8F%D0%B5%D1%82-read-%D1%81-%D0%B1%D1%83%D1%84%D0%B5%D1%80%D0%BE%D0%BC

// Напишите программу, которая:
//получает с помощью библиотеки jsoup HTML-код страницы https://lenta.ru;
//находит в HTML-коде теги img и получает абсолютные ссылки
// на изображения из атрибута src;
//скачивает изображения в папку images проекта,
// при этом сохраняя оригинальные названия файлов;
//выводит в консоль список c названиями скачанных файлов.
//Рекомендации
//
//Все варианты подключения библиотеки jsoup в проект
// на странице скачивания библиотеки
//Для получения ссылок воспользуйтесь префиксом abs
// при получении атрибута src у тега img.



/*
private static void downloadImage(String srcUrl, String dstDir) throws IOException {
        //System.out.println("srcUrl = " + srcUrl); // получ имя файла изображения из ссылки на этот файл
        String fileName = srcUrl.replaceAll("(.+)(/.+)$", "$2");
        System.out.println(dstDir + fileName);
        FileUtils.copyURLToFile( new URL(srcUrl),
        new File(dstDir + fileName) );
        }

Elements elements = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
linksToImages.add(link);
ArrayList<String> linksToImages = new ArrayList<>();

        Elements links = doc.getElementsByTag("a");
        for (Element link : links) {
            System.out.println("Href: " + link.attr("Href"));
            //System.out.println("text: " + link.text());
        }
        for (Element link : links) {
            //System.out.println("Href: " + link.attr("Href"));
            System.out.println("text: " + link.text());
        }
        Element link = doc.select("a").first();
        String relHref = link.attr("href"); // == "/"
        System.out.println("relHref = " + relHref);
        String absHref = link.attr("abs:href"); // "http://jsoup.org/"
        System.out.println("absHref = " + absHref);
        doc = Jsoup.connect("http://example.com").get();
        doc.select("p").forEach(System.out::println);
*/
