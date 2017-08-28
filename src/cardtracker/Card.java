
package cardtracker;

public class Card {
    private String cardName;
    private User originalOwner;
    private User currentOwner;
    
    public Card(String name, User originalOwner, User currentOwner){
        cardName = name;
        this.originalOwner = originalOwner;//original owner is whoever created the card?
        this.currentOwner = currentOwner;//current owner is probably the original owner?
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
}
