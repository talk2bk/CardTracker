package cardtracker;

import java.util.Scanner;

/**
 *
 * @author CuTs
 */
public class main {

    public static void main(String[] args) {
        //look for an existing "database"
            //if not found, create a new one
                //prompt for information???
        //once database is found, load information
        //temp database for test
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
                            if(database.login(input.next())){
                                //set currentUser ot be the found user.
                            }
                            loggedin = true;
                            System.out.println("login succeeded");
                        }catch(Exception e){
                            System.out.println("login failed");
                            break;
                        }
                        
                    case 2:
                        System.out.println("please enter a name");
                        //look up the name
                            //if it doesnt exist, add it and bam done.
                            //if it does exist: prompt for a new name.
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
               
            System.out.println("999. quitters always win");
            //deal with response
            int choice = input.nextInt();
            switch(choice){
                case 1: database.displayBorrowedCards(); break;
                case 2: database.displayOwnedCards(); break;
                case 3: database.displayAllCards(); break;
                case 5: database.addCard(); break;
                case 999: running = false; break;
                default: System.out.println("invalid choice."); break;
            }
                 
        }
        
    }
    
}
