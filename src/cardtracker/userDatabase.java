package cardtracker;

import java.util.ArrayList;

public class userDatabase {
    //list of users to search through
    private ArrayList<User> users = new ArrayList<User>();
    
    public userDatabase(){
        
    }
    public userDatabase(ArrayList<User> preexistingDB){//if you already have a database to use
        users = preexistingDB;
    }
}
