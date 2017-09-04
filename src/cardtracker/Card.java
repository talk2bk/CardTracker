
package cardtracker;

import java.io.Serializable;

public class Card implements Comparable, Serializable{
    private String cardName;
    private int numCopies;
    private User originalOwner;
    private User currentOwner;
    
    public Card(String name, User originalOwner, User currentOwner){
        cardName = name;
        numCopies = 1;
        this.originalOwner = originalOwner;//original owner is whoever created the card?
        this.currentOwner = currentOwner;//current owner is probably the original owner?
    }
    public Card(String name,int numCopies, User originalOwner, User currentOwner){
        cardName = name;
        this.numCopies = numCopies;
        this.originalOwner = originalOwner;//original owner is whoever created the card?
        this.currentOwner = currentOwner;//current owner is probably the original owner?
    }
    
    public int getNumCopies(){
        return numCopies;
    }
    
    public void setCopies(int num){
        numCopies = num;
    }
    
    public void rename(String newName){
        cardName = newName;
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
    public String getName(){
        return cardName;
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
        if(cardName.equalsIgnoreCase(temp.getName())){
            return originalOwner.compareTo(temp.originalOwner);
        }
        return cardName.compareTo(temp.cardName);
    }
    
    @Override
    public boolean equals(Object t){
        Card temp = (Card) t;
        if(cardName.equalsIgnoreCase(temp.getName())){
            if(originalOwner.equals(temp.originalOwner)){
                return true;
            }
        }
        return false;
    }
}
