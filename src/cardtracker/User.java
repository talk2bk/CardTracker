
package cardtracker;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User implements Serializable, Comparable{
    private String name;
    private ArrayList<Card> cards;
    private String uniqueID; //to implement
    
    //new user
    public User(String name){
        this.name = name;
        this.cards = new ArrayList<Card>();
    }
    //for transfering user accounts?
    public User(String name, ArrayList<Card> cards){
        this.name = name;
        this.cards = cards;
    }
    
    public User(BasicDBObject user){
        this.name = user.getString("name");
        this.cards = new ArrayList<Card>();
        List<BasicDBObject> convertedCards = (List) user.get("cards");
        for(BasicDBObject card : convertedCards){
            cards.add(new Card(card));
        }
        
    }
    
    String getName() {
        return name;
    }
    DBObject createDBObject(){
        BasicDBObject userDBObject = new BasicDBObject("name", name);
        ArrayList<BasicDBObject> convertedCards = new ArrayList<BasicDBObject>();
        for(Card temp : cards){convertedCards.add(temp.convertCard());}//convert to basicdbobject and shove it in
        userDBObject.append("cards", Arrays.asList(convertedCards));
        
        return userDBObject;
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
    public void addACard(Card toAdd){ //definitely need to update in the future
        //check if the card is already in inventory
        if(cards.contains(toAdd)){
            Card temp = cards.get(cards.indexOf(toAdd));
            temp.setCopies(temp.getNumCopies()+toAdd.getNumCopies());
            cards.set(cards.indexOf(toAdd), temp);
            //if you already have the card, increment it instead of adding a new one.
        }
            //we'll do version cehcking when i implement the magic api
        else{cards.add(toAdd);}
        
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
