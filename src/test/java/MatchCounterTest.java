import org.testng.annotations.Test;
import pageobjects.MatchMainPage;

import java.util.*;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static pageobjects.MatchMainPage.*;

public class MatchCounterTest extends SeleniumTestCase {

    @Test
    public void MatchCounterTest() throws Exception {
        ArrayList<String> championshipList = new ArrayList<String>();
        ArrayList<Match> matchList = new ArrayList<Match>();

        MatchMainPage
                .gotoMatchMainPage();

        System.out.println("Количество матчей по каждому из чемпионатов:");

        int championshipCounter = 1;
        while ($(byXpath(String.format(getChampionshipElement(), championshipCounter))).isDisplayed()) {
            championshipList.add($(byXpath(String.format(getChampionshipElementTitle(), championshipCounter))).getAttribute("title"));
            int matchCounter = 1;
            while ($(byXpath(String.format(getMatchNameElement(), championshipCounter, matchCounter))).exists()) {
                matchList.add(new Match($(byXpath(String.format(getMatchNameElement(), championshipCounter, matchCounter))).getAttribute("title").trim(), $(byXpath(String.format(getMatchTimeElement(), championshipCounter, matchCounter))).innerHtml()));
                matchCounter++;
            }
            System.out.println(championshipList.get(championshipCounter - 1) + ": " + (matchCounter - 1));
            championshipCounter++;
        }

        System.out.println();

        Collections.sort(matchList, new Comparator<Match>() {
            @Override
            public int compare(Match m1, Match m2) {
                return Comparator.comparing(Match::getMatchTime)
                        .compare(m1, m2);
            }
        });
        System.out.println("Сортировка матчей:");
        for (int i = 0; i < matchList.size(); i++) {
            System.out.println(matchList.get(i).getMatchTime() + " " + matchList.get(i).getMatchName());
        }

    }

}
