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
            /*login loop start*/
            while(!loggedin){
                System.out.println("1.login\n2.make a new user.");
                //prompt user for sign in or new account
                int choice = input.nextInt();
                switch(choice){
                    case 1: //login
                        System.out.println("username: ");
                        try{
                            currentUser = database.lookup(input.next());
                            //if sign in then look up name in database (cardtracker's job)
                            if(currentUser == null){
                                System.out.println("login failed: user not found");
                                 //if not found, prompt for reenter
                                break;
                            }
                            loggedin = true;
                            //if found, return true and set that as currentUser.
                            System.out.println("login succeeded");
                            break;
                        }catch(Exception e){
                            System.out.println("exception hit during login");
                            System.out.println(e.toString());
                            break;
                        }
                        
                    case 2: //create account
                        //if new user:
                        System.out.println("please enter a name: ");
                        String name = input.next();
                        //ask for username
                        if(database.lookup(name) != null){ //look up the name
                            System.out.println("name already exists.");
                            //if it does exist: prompt for a new name.
                            
                        }
                        else{
                            currentUser = database.createUser(name);
                            //save username to database.; set currentUser to that person
                            loggedin = true;
                            System.out.println("login succeeded");
                            //if it doesnt exist, add it and bam done.
                        }
                        break;
                    case 3: database.displayUsers(); break;
                    default: System.out.println("invalid choice"); break;
                } 
            }
            /*login loop end*/ 
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
            System.out.println("999. quitters always win \n1000. debug reset");
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
                    System.out.println("Please Input: Current Owner");
                    String currentOwner = input.nextLine();
                    database.addCard(name,originalOwner,currentOwner); 
                    break;
                case 999: running = false; break;
                case 1000: database.resetDatabase(); break;
                default: System.out.println("invalid choice."); break;
            }
                 
        }
        
    }
    
}
