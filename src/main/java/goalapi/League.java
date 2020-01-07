/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goalapi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filippofinke
 */
public class League {

    private String name;
    
    private List<Match> matches;

    public String getName() {
        return this.name;
    }

    public List<Match> getMatches() {
        return matches;
    }
    
    public void add(Match match) {
        matches.add(match);
    }

    public League(String name) {
        this.matches = new ArrayList();
        this.name = name;
    }

}
