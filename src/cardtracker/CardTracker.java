
package cardtracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase; 
import com.mongodb.MongoClient; 
import org.bson.Document; 

public class CardTracker {
    //this class handles database stuff and manages between cards and users
    ArrayList<User> users;
    public CardTracker(){
        loadDatabase();
        loadCollection();
    }
    //**to convert
    void displayCards(ArrayList<Card> cards){
        System.out.println("\nCards: ");
        System.out.println("Name : Copies : Original Owner : Current Owner");
        for(Card temp: cards){
            System.out.println(temp.getCard().getName()+ " : "+ temp.getNumCopies() + " : "+ temp.getOriginalOwner().getName() + " : "+ temp.getCurrentOwner().getName());
        }
        System.out.println("End Cards.\n");
    }
    //**to convert
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
    //**to convert
    void displayBorrowedCards(User currentUser){//cards you have in your collection, not necessarily yours
        //parameters: current user
        //query database based on cards in current user's collection 
        displayCards(currentUser.getBorrowedCards());
        
    }
    //**to convert
    void displayAllCards(User currentUser) {//cards in your current collection and cards being loaned out
        displayCards(currentUser.getCards());
    }
    //**to convert
    void addCard(String scryfallUUID,int numCopies, String originalOwnerName, String currentOwnerName) {
        User currentOwner = lookup(currentOwnerName);
        //lookup the user. currently works based on the assumption that the user exists.
        int index = users.indexOf(currentOwner);
        currentOwner.addACard(new Card(scryfallUUID,numCopies, lookup(originalOwnerName), currentOwner));
        users.set(index, currentOwner);
        saveDatabase();
    }
    
    void cardFinder(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please input: cardName");
        String name = "";
        /*start card search loop*/
        ArrayList<forohfor.scryfall.api.Card> searchResults = forohfor.scryfall.api.MTGCardQuery.search("++! "+input.nextLine());
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
        addCard(searchResults.get(choice).getScryfallUUID(),numCopies,originalOwner,currentOwner);
    }
    
    /*Handle User loading/creation/lookup*/
    //**to convert
    User lookup(String name){
        for(User temp: users){
            if(temp.getName().equalsIgnoreCase(name)){
                return temp;
            }
        }
        return null;
    }
    //**to convert
    User createUser(String name){
        User temp = new User(name);
        users.add(temp);
        saveDatabase();
        return temp;
    }
    /*end Handle User loading/creation/lookup*/
    //**to convert
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
    //**to convert
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
    //**to finish
    public void loadCollection(){
        System.out.println("Loading Collection Start");
        MongoClient mongoClient = new MongoClient();
        for(String temp : mongoClient.listDatabaseNames()){
        System.out.println(temp);}
        MongoDatabase db = mongoClient.getDatabase("userDatabase");
        MongoCollection<Document> collection = db.getCollection("users");
        System.out.println("Loading Collection End");
    }
    
    //testing methods
    //**to convert
    public void displayUsers(){
        for(User temp : users){
            System.out.println(temp.getName());
        }
    }
    //**to convert
    public void resetDatabase(){
        users = new ArrayList<User>();
        saveDatabase();
    }
    
    
}
