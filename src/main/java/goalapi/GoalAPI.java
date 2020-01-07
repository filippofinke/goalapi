package goalapi;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author filsippofinke
 */
public class GoalAPI {

    private final static String url = "https://www.goal.com/en/live-scores";

    public Document getHtml() throws IOException {
        return Jsoup.connect(this.url).get();
    }

    public League[] getLeagues() throws IOException {
        Document html = this.getHtml();
        Elements matches = html.getElementsByClass("competition-matches");
        League[] leagues = new League[matches.size()];
        Date now = new Date();
        for (int i = 0; i < leagues.length; i++) {

            Element league = matches.get(i);
            List<Element> leagueMatches = league.getElementsByClass("match-row");
            String name = league.getElementsByClass("competition-name").get(0).text();
            League l = new League(name);

            for (Element leagueMatch : leagueMatches) {
                Date date = new Date(Long.parseLong(leagueMatch.getElementsByTag("time").get(0).attr("data-utc")));
                if(date.before(now) || date.getDate() != now.getDate()) continue;
                Element homeTeam = leagueMatch.getElementsByClass("team-home").get(0);
                String homeTeamName = homeTeam.getElementsByClass("team-name").get(0).text();
                int homeGoals = 0;
                try {
                    homeGoals = Integer.parseInt(homeTeam.getElementsByClass("goals").get(0).text());
                } catch (NumberFormatException nfe) {
                }
                
                Element awayTeam = leagueMatch.getElementsByClass("team-away").get(0);
                String awayTeamName = awayTeam.getElementsByClass("team-name").get(0).text();
                int awayGoals = 0;
                try {
                    awayGoals = Integer.parseInt(awayTeam.getElementsByClass("goals").get(0).text());
                } catch (NumberFormatException nfe) {
                }
                Match m = new Match(homeGoals, awayGoals, homeTeamName, awayTeamName, date);
                l.add(m);
            }
            leagues[i] = l;
        }
        return leagues;
    }

}
