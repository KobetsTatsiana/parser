package by.http.parser.job;

import by.http.parser.entity.Money;
import by.http.parser.service.MoneyService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MoneyParserJob {
    @Autowired
    MoneyService moneyService;
    private String moneyName;

    @EventListener(ApplicationReadyEvent.class)
    public void parseMoney() {
        String url = "https://select.by/kurs/";
        try {
            Document document = Jsoup.parse(new URL(url), 3000);
            Element tableExchanger = document.select("table[class=table table-sm table-borderless mb-1]").first();
            Elements lines = tableExchanger.select("tr[class=text-center h4]"); // в одной строке вся информация

            int index = 0;// начало с которого нужно делать печать
            int itertionMoney = 4;
            for (int i = 0; i < itertionMoney; i++) {
                Element valuelines = lines.get(index + i);//каждая строка со всеми значениями

                List<String> vlintokens = Arrays.asList(valuelines.text().split("\\s"));//каждая строка массив со всеми значениями
                System.out.println(vlintokens);
                List<String> money = new ArrayList<String>();//разделенный
                for (String part : vlintokens) {
                    // this.moneyName = part;

                    money.add(part);
                }

                String moneyName = vlintokens.get(1);
                if (!moneyService.isExist(moneyName)) {
                    Money obj = new Money();
                    obj.moneyCount = money.get(0);
                    obj.moneyName = money.get(1);
                    obj.price = money.get(money.size()-1);

                    moneyService.save(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

