
package cardtracker;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Card implements Comparable, Serializable {
    private String scryfallUUID;
    private int numCopies;
    private User originalOwner;
    private User currentOwner;
    
    public Card(String scryfallUUID, User originalOwner, User currentOwner){
        this.scryfallUUID = scryfallUUID;
        numCopies = 1;
        this.originalOwner = originalOwner;//original owner is whoever created the card?
        this.currentOwner = currentOwner;//current owner is probably the original owner?
    }
    public Card(String scryfallUUID,int numCopies, User originalOwner, User currentOwner){
        this.scryfallUUID = scryfallUUID;
        this.numCopies = numCopies;
        this.originalOwner = originalOwner;//original owner is whoever created the card?
        this.currentOwner = currentOwner;//current owner is probably the original owner?
    }
    
    public forohfor.scryfall.api.Card getCard(){
        forohfor.scryfall.api.Card result = null; 
        try {
             result = forohfor.scryfall.api.MTGCardQuery.getCardByScryfallId(this.scryfallUUID);
        } catch (IOException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int getNumCopies(){
        return numCopies;
    }
    
    public void setCopies(int num){
        numCopies = num;
    }

    public boolean changeOwner(User newOwner){
        try{
            //check if this user exists (should catch here)
            originalOwner = newOwner;
            return true;
        }catch(Exception e){
            
        }
        return false;
    }

    public User getOriginalOwner(){
        return originalOwner;
    }
    public User getCurrentOwner(){
        return currentOwner;
    }

    @Override
    public int compareTo(Object t) {
        Card temp = (Card) t;
        forohfor.scryfall.api.Card thisCard = this.getCard();
        forohfor.scryfall.api.Card thatCard = temp.getCard();
        if(thisCard.getName().equalsIgnoreCase(thatCard.getName())){
            return originalOwner.compareTo(temp.originalOwner);
        }
        return thisCard.getName().compareTo(thatCard.getName());
    }
    
    @Override
    public boolean equals(Object t){
        Card temp = (Card) t;
        forohfor.scryfall.api.Card thisCard = this.getCard();
        forohfor.scryfall.api.Card thatCard = temp.getCard();
        if(thisCard.getName().equalsIgnoreCase(thatCard.getName())){
            if(originalOwner.equals(temp.originalOwner)){
                return true;
            }
        }
        return false;
    }
}
