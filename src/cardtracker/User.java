
package cardtracker;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Card> borrowedCards = new ArrayList<Card>();
    
    //new user
    public User(String name){
        this.name = name;
    }
    //for transfering user accounts?
    public User(String name, ArrayList<Card> cards){
        this.name = name;
        this.borrowedCards = cards;
    }
    
    //figure out how to prompt them for a card name and user
    public boolean addACard(){
        //prompt for card name and save
        //prompt for user and save
        //add to borrowedCards (createACard with this info)
        //return true if completed
        return false; //otehrwise
    }
    
    private Card createACard(String cardName, User owner){
        return new Card(cardName, owner, owner);//broken
    }
}
