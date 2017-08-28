
package cardtracker;

import java.io.*;
import java.util.ArrayList;

public class CardTracker {
    //this class handles database stuff and manages between cards and users
    userDatabase users;
    public CardTracker(){
        loadDatabase();
    }
    void displayCards(ArrayList<Card> cards){
        for(Card temp: cards){
            System.out.println(temp.getName());
        }
    }
    
    void displayOwnedCards(User currentUser){ //these are the cards you own personally
        //parameters: current user
        //query database based on cards with original owner current user
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    void displayBorrowedCards(User currentUser){//cards you have in your collection, not necessarily yours
        //parameters: current user
        //query database based on cards in current user's collection 
        displayCards(currentUser.getBorrowedCards());
        
    }

    void displayAllCards(User currentUser) {//cards in your current collection and cards being loaned out
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void addCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*Handle User loading/creation/lookup*/
    User lookup(String name){
        for(User temp: users.getUsers()){
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
            users = (userDatabase) objectIn.readObject();
            objectIn.close();
            System.out.println("successfully loaded database.");
        }catch(FileNotFoundException e){
            //no preexisting database, so make one.
            users = new userDatabase();
            System.out.println("no database found, creating new one.");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
}
