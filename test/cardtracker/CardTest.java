package cardtracker;

import forohfor.scryfall.api.Card;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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


public class CardTest {
    
    public CardTest() {
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
     * Test of getCard method, of class Card.
     */
    @Test
    public void testGetCard() {
        System.out.println("getCard");
        Card instance = null;
        Card expResult = null;
        Card result = instance.getCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumCopies method, of class Card.
     */
    @Test
    public void testGetNumCopies() {
        System.out.println("getNumCopies");
        cardtracker.Card instance = null;
        int expResult = 0;
        int result = instance.getNumCopies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCopies method, of class Card.
     */
    @Test
    public void testSetCopies() {
        System.out.println("setCopies");
        int num = 0;
        cardtracker.Card instance = null;
        instance.setCopies(num);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeOwner method, of class Card.
     */
    @Test
    public void testChangeOwner() {
        System.out.println("changeOwner");
        User newOwner = null;
        cardtracker.Card instance = null;
        boolean expResult = false;
        boolean result = instance.changeOwner(newOwner);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOriginalOwner method, of class Card.
     */
    @Test
    public void testGetOriginalOwner() {
        System.out.println("getOriginalOwner");
        cardtracker.Card instance = null;
        User expResult = null;
        User result = instance.getOriginalOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentOwner method, of class Card.
     */
    @Test
    public void testGetCurrentOwner() {
        System.out.println("getCurrentOwner");
        cardtracker.Card instance = null;
        User expResult = null;
        User result = instance.getCurrentOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Card.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object t = null;
        cardtracker.Card instance = null;
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Card.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object t = null;
        cardtracker.Card instance = null;
        boolean expResult = false;
        boolean result = instance.equals(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
