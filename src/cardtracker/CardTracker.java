
package cardtracker;

public class CardTracker {
    //this class handles database stuff and manages between cards and users
    userDatabase users = new userDatabase();
    public CardTracker(){
        
    }
    
    void displayOwnedCards(){ //these are the cards you own personally
        //parameters: current user
        //query database based on cards with original owner current user
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    void displayBorrowedCards(){//cards you have in your collection, not necessarily yours
        //parameters: current user
        //query database based on cards in current user's collection 
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void displayAllCards() {//cards in your current collection and cards being loaned out
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void addCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean login(String next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
