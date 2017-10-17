
package cardtracker;

import forohfor.scryfall.api.Card;
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


public class CardTrackerTest {
    
    public CardTrackerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //create a database or refer the existing one.
        //probably create a dummy database or a copy of a real one, pull cards from it. not really sure how to confirm testing.
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of displayCards method, of class CardTracker.
     */
    @Test
    public void testDisplayCards() {
        System.out.println("displayCards");
        ArrayList<Card> cards = null;
        CardTracker instance = new CardTracker();
        instance.displayCards(cards);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayOwnedCards method, of class CardTracker.
     */
    @Test
    public void testDisplayOwnedCards() {
        System.out.println("displayOwnedCards");
        User currentUser = null;
        CardTracker instance = new CardTracker();
        instance.displayOwnedCards(currentUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayBorrowedCards method, of class CardTracker.
     */
    @Test
    public void testDisplayBorrowedCards() {
        System.out.println("displayBorrowedCards");
        User currentUser = null;
        CardTracker instance = new CardTracker();
        instance.displayBorrowedCards(currentUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllCards method, of class CardTracker.
     */
    @Test
    public void testDisplayAllCards() {
        System.out.println("displayAllCards");
        User currentUser = null;
        CardTracker instance = new CardTracker();
        instance.displayAllCards(currentUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class CardTracker.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card card = null;
        int numCopies = 0;
        String originalOwnerName = "";
        String currentOwnerName = "";
        CardTracker instance = new CardTracker();
        instance.addCard(card, numCopies, originalOwnerName, currentOwnerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cardFinder method, of class CardTracker.
     */
    @Test
    public void testCardFinder() {
        System.out.println("cardFinder");
        CardTracker instance = new CardTracker();
        instance.cardFinder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookup method, of class CardTracker.
     */
    @Test
    public void testLookup() {
        System.out.println("lookup");
        String name = "";
        CardTracker instance = new CardTracker();
        User expResult = null;
        User result = instance.lookup(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class CardTracker.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        String name = "";
        CardTracker instance = new CardTracker();
        User expResult = null;
        User result = instance.createUser(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveDatabase method, of class CardTracker.
     */
    @Test
    public void testSaveDatabase() {
        System.out.println("saveDatabase");
        CardTracker instance = new CardTracker();
        instance.saveDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadDatabase method, of class CardTracker.
     */
    @Test
    public void testLoadDatabase() {
        System.out.println("loadDatabase");
        CardTracker instance = new CardTracker();
        instance.loadDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayUsers method, of class CardTracker.
     */
    @Test
    public void testDisplayUsers() {
        System.out.println("displayUsers");
        CardTracker instance = new CardTracker();
        instance.displayUsers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetDatabase method, of class CardTracker.
     */
    @Test
    public void testResetDatabase() {
        System.out.println("resetDatabase");
        CardTracker instance = new CardTracker();
        instance.resetDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
