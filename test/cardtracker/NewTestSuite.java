package cardtracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author CuTs
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({cardtracker.mainTest.class, cardtracker.CardTest.class, cardtracker.UserTest.class, cardtracker.CardTrackerTest.class})
public class NewTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        //create database
        
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
