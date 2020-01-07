package goalapi;

import java.util.Date;

/**
 *
 * @author filippofinke
 */
public class Match {

    private int homeGoals;

    private int awayGoals;

    private String homeTeam;

    private String awayTeam;
    
    private Date date;

    public int getAwayGoals() {
        return awayGoals;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public Date getDate() {
        return date;
    }
    
    


    public String getWinningSquad() {
        if (homeGoals > awayGoals) {
            return homeTeam;
        } else if (homeGoals == awayGoals) {
            return "";
        } else {
            return awayTeam;
        }
    }

    public Match(int homeGoals, int awayGoals, String homeTeam, String awayTeam, Date date) {
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
    }    

    @Override
    public String toString() {
        return date.toLocaleString() + " " + homeTeam + " " + homeGoals + " - " + awayGoals + " " + awayTeam;
    }
    
    

}
