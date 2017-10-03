
package cardtracker;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CuTs
 */


public class UserTest {
    
    public UserTest() {
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
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBorrowedCards method, of class User.
     */
    @Test
    public void testGetBorrowedCards() {
        System.out.println("getBorrowedCards");
        User instance = null;
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getBorrowedCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCards method, of class User.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        User instance = null;
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addACard method, of class User.
     */
    @Test
    public void testAddACard() {
        System.out.println("addACard");
        Card toAdd = null;
        User instance = null;
        instance.addACard(toAdd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class User.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object t = null;
        User instance = null;
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object t = null;
        User instance = null;
        boolean expResult = false;
        boolean result = instance.equals(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
