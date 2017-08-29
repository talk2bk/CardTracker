
package cardtracker;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable, Comparable{
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private String uniqueID; //to implement
    
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
    
    ArrayList<Card> getCards(){
        return cards;
    }
    
    /* card stuff */
    //figure out how to prompt them for a card name and user
    public void addACard(Card toAdd){
        //check if the card is already in inventory
            //if you already have the card, increment it instead of adding a new one.
            //we'll do version cehcking when i implement the magic api
        cards.add(toAdd);
    }
    
    private Card createACard(String cardName, User owner){
        return new Card(cardName, owner, owner);//broken
    }
    /* end card stuff */

    @Override
    public int compareTo(Object t) {
        User temp = (User) t;
        return name.compareTo(temp.getName());
    }
    @Override
    public boolean equals(Object t){
        User temp = (User) t;
        return name.equalsIgnoreCase(temp.getName());
    }
}
