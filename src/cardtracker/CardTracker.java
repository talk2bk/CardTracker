
package cardtracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CardTracker {
    //this class handles database stuff and manages between cards and users
    ArrayList<User> users;
    public CardTracker(){
        loadDatabase();
    }
    void displayCards(ArrayList<Card> cards){
        System.out.println("\nCards: ");
        for(Card temp: cards){
            System.out.println(temp.getCard().getName()+ " : "+ temp.getNumCopies() + " : "+ temp.getOriginalOwner().getName() + " : "+ temp.getCurrentOwner().getName());
        }
        System.out.println("End Cards.\n");
    }
    
    void displayOwnedCards(User currentUser){ //these are the cards you own personally
        //parameters: current user
        //query database based on cards with original owner current user
        ArrayList<Card> results = new ArrayList<Card>();
        for(User temp : users){
            for(Card tempCard : temp.getCards()){
                if(tempCard.getOriginalOwner().equals(currentUser)){
                    results.add(tempCard);
                }
            }
        }
        displayCards(results); 
    }
    void displayBorrowedCards(User currentUser){//cards you have in your collection, not necessarily yours
        //parameters: current user
        //query database based on cards in current user's collection 
        displayCards(currentUser.getBorrowedCards());
        
    }

    void displayAllCards(User currentUser) {//cards in your current collection and cards being loaned out
        displayCards(currentUser.getCards());
    }

    void addCard(forohfor.scryfall.api.Card card,int numCopies, String originalOwnerName, String currentOwnerName) {
        User currentOwner = lookup(currentOwnerName);
        //lookup the user. currently works based on the assumption that the user exists.
        int index = users.indexOf(currentOwner);
        currentOwner.addACard(new Card(card,numCopies, lookup(originalOwnerName), currentOwner));
        users.set(index, currentOwner);
        saveDatabase();
    }
    
    void cardFinder(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please input: cardName");
        String name = "";
        /*start card search loop*/
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(input.nextLine());
        ArrayList<forohfor.scryfall.api.Card> searchResults = forohfor.scryfall.api.MTGCardQuery.toCardList(temp,true);
        int i = 0;
        for(forohfor.scryfall.api.Card card : searchResults){
            System.out.println(""+ i++ +". "+ card.getName()+", Set: "+card.getSetName());
        }
        System.out.println("Please enter the number of the card: ");
        int choice = input.nextInt(); input.nextLine();
        
        /*end card search loop*/
        System.out.println("Please input: number of Copies");
        int numCopies = input.nextInt(); input.nextLine();
        System.out.println("Please Input: originalowner");
        String originalOwner = input.nextLine();
        System.out.println("Please Input: Current Owner");
        String currentOwner = input.nextLine();
        addCard(searchResults.get(choice),numCopies,originalOwner,currentOwner);
    }
    
    /*Handle User loading/creation/lookup*/
    
    User lookup(String name){
        for(User temp: users){
            if(temp.getName().equalsIgnoreCase(name)){
                return temp;
            }
        }
        return null;
    }
    
    User createUser(String name){
        User temp = new User(name);
        users.add(temp);
        saveDatabase();
        return temp;
    }
    /*end Handle User loading/creation/lookup*/
    
    public void saveDatabase(){
        try{
            FileOutputStream output = new FileOutputStream("users.db");
            ObjectOutputStream objectOut = new ObjectOutputStream(output);
            objectOut.writeObject(users);
            objectOut.close();
            System.out.println("Successfully saved database.");
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    public void loadDatabase(){
        try{
            FileInputStream input = new FileInputStream("users.db");
            ObjectInputStream objectIn = new ObjectInputStream(input);
            users = (ArrayList<User>) objectIn.readObject();
            objectIn.close();
            System.out.println("successfully loaded database.");
        }catch(FileNotFoundException e){
            //no preexisting database, so make one.
            users = new ArrayList<User>();
            System.out.println("no database found, creating new one.");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    //testing methods
    public void displayUsers(){
        for(User temp : users){
            System.out.println(temp.getName());
        }
    }
    
    public void resetDatabase(){
        users = new ArrayList<User>();
        saveDatabase();
    }
    
    
}
