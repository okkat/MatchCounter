package pageobjects;

import static com.codeborne.selenide.Selenide.open;

public class MatchMainPage {

    private static final String championshipElement = "(//div[@data-name = 'dashboard-champ-content'])[%s]";
    private static final String championshipElementTitle = "(//div[@data-name = 'dashboard-champ-content'])[%s]/.//a[@class = 'c-events__liga']";
    private static final String matchNameElement = "(//div[@data-name = 'dashboard-champ-content'][%s]/.//a[@class = 'c-events__name'])[%s]/span";
    private static final String matchTimeElement = "(//div[@data-name = 'dashboard-champ-content'][%s]/.//div[@class = 'c-events__time min'])[%s]/span";

    public static String getChampionshipElement() {
        return championshipElement;
    }

    public static String getChampionshipElementTitle() {
        return championshipElementTitle;
    }

    public static String getMatchNameElement() {
        return matchNameElement;
    }

    public static String getMatchTimeElement() {
        return matchTimeElement;
    }

    public static MatchMainPage gotoMatchMainPage() throws Exception {
        open("https://1xstavka.ru/line/Football/");
        return null;
    }

}
