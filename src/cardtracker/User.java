
package cardtracker;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    //new user
    public User(String name){
        this.name = name;
    }
    //for transfering user accounts?
    public User(String name, ArrayList<Card> cards){
        this.name = name;
        this.cards = cards;
    }
    
    String getName() {
        return name;
    }
    
    ArrayList<Card> getBorrowedCards(){
        ArrayList<Card> results = new ArrayList<Card>();
        for(Card temp : cards){
            if(!temp.getOriginalOwner().equals(this)){
                results.add(temp);
            }
        }
        return results;
    }
    
    /* card stuff */
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
    /* end card stuff */
}
