/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goalapi;

import java.io.IOException;
import java.util.List;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author filippofinke
 */
public class GoalAPITest {

    public GoalAPITest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getHtml method, of class GoalAPI.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetHtml() throws Exception {
        System.out.println("getHtml");
        GoalAPI instance = new GoalAPI();
        try {
            Document result = instance.getHtml();
            System.out.println(result.title());
        } catch (IOException ie) {
            fail(ie.getMessage());
        }

    }

    /**
     * Test of getLeagues method, of class GoalAPI.
     */
    @Test
    public void testGetLeagues() throws Exception {
        System.out.println("getLeagues");
        GoalAPI instance = new GoalAPI();
        try {
            League[] results = instance.getLeagues();

            for (League result : results) {
                System.out.println(result.getName());
                List<Match> matches = result.getMatches();
                for (Match m : matches) {
                    System.out.println(m);
                }
            }
        } catch (IOException ie) {
            fail(ie.getMessage());
        }
    }

}
