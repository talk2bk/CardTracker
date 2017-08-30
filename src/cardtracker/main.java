package cardtracker;

import java.util.Scanner;

/**
 *
 * @author CuTs
 */
public class main {

    public static void main(String[] args) {
        CardTracker database = new CardTracker();
        User currentUser = null;
        //temp database for test
        boolean running = true;
        Scanner input = new Scanner(System.in);
        boolean loggedin = false;
        while(running){
            if(!loggedin){
                System.out.println("1.login/n 2.make a new user.");
                //prompt user for sign in or new account
                int choice = input.nextInt();
                switch(choice){
                    case 1: 
                        System.out.println("please enter a name: ");
                        try{
                            currentUser = database.lookup(input.next());
                            if(currentUser == null){
                                System.out.println("login failed: user not found");
                                break;
                            }
                            loggedin = true;
                            System.out.println("login succeeded");
                            loggedin = true;
                            break;
                        }catch(Exception e){
                            System.out.println("login failed");
                            System.out.println(e.toString());
                            break;
                        }
                        
                    case 2: //currentl broken
                        System.out.println("please enter a name");
                        String name = input.next();
                        if(database.lookup(name) != null){ //look up the name
                            System.out.println("name found, but this function is broken.");
                            //if it does exist: prompt for a new name.
                            
                        }
                        else{
                            currentUser = database.createUser(name);
                            loggedin = true;
                            //if it doesnt exist, add it and bam done.
                        }
                        break;
                    default: System.out.println("invalid choice"); break;
                }
                //if sign in then look up name in database (cardtracker's job)
                    //if found, return true and set that as currentUser.
                    //if not found, prompt for reenter
                //if new user:
                    //ask for username
                    //save username to database.
                    //set currentUser to that person
            } 
            //prompt user:
            System.out.println("wut u want:");
            System.out.println("1. cards im borrowin");
            //cards i am borrowing
                //return list of cards im borrowing in the format "cardname":"owner"
            System.out.println("2. cards am being borrowed");
            //cards i own currently being borrowed
                //return list of cards im borrowing in the format "cardname":"owner"
            System.out.println("3. all cards");
            //card collection (list of both borrowed and being borrowed????)
            System.out.println("4. create a new card");
            //add a card, whether you borrowed it or are going to borrow it. adds it to both users collections.
               //ask for card name, ask for original owner, ask for current owner?
               //lookup other user and "link" it. 
            System.out.println("999. quitters always win");
            //deal with response
            int choice = input.nextInt();
            switch(choice){
                case 1: database.displayBorrowedCards(currentUser); break;
                case 2: database.displayOwnedCards(currentUser); break;
                case 3: database.displayAllCards(currentUser); break;
                case 4: 
                    input.nextLine();
                    System.out.println("Please input: cardName");
                    String name = input.nextLine();
                    System.out.println("Please Input: originalowner");
                    String originalOwner = input.nextLine();
                    //System.out.println("Please Input: Current Owner");
                    //String currentOwner = input.next();
                    database.addCard(name,originalOwner,currentUser); 
                    break;
                case 999: running = false; break;
                default: System.out.println("invalid choice."); break;
            }
                 
        }
        
    }
    
}
