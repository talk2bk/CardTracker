package cardtracker;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class userDatabase implements Serializable{
    //list of users to search through
    private ArrayList<User> users;
    
    public userDatabase(){
        users = new ArrayList<User>();
    }

    Iterable<User> getUsers() {
        return users;
    }

    void add(User temp) {
        users.add(temp);
    }
    
    
    
}
