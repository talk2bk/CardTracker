
package cardtracker;

import java.io.Serializable;

public class Card implements Comparable, Serializable {
    private forohfor.scryfall.api.Card card;
    private int numCopies;
    private User originalOwner;
    private User currentOwner;
    
    public Card(forohfor.scryfall.api.Card card, User originalOwner, User currentOwner){
        this.card = card;
        numCopies = 1;
        this.originalOwner = originalOwner;//original owner is whoever created the card?
        this.currentOwner = currentOwner;//current owner is probably the original owner?
    }
    public Card(forohfor.scryfall.api.Card card,int numCopies, User originalOwner, User currentOwner){
        this.card = card;
        this.numCopies = numCopies;
        this.originalOwner = originalOwner;//original owner is whoever created the card?
        this.currentOwner = currentOwner;//current owner is probably the original owner?
    }
    
    public forohfor.scryfall.api.Card getCard(){
        return card;
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
        if(card.getName().equalsIgnoreCase(temp.card.getName())){
            return originalOwner.compareTo(temp.originalOwner);
        }
        return card.getName().compareTo(temp.card.getName());
    }
    
    @Override
    public boolean equals(Object t){
        Card temp = (Card) t;
        if(card.getName().equalsIgnoreCase(temp.card.getName())){
            if(originalOwner.equals(temp.originalOwner)){
                return true;
            }
        }
        return false;
    }
}
