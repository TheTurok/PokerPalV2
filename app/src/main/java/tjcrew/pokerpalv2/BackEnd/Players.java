package tjcrew.pokerpalv2.BackEnd;

import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

import tjcrew.pokerpalv2.FrontEnd.PlayerInformation;
import tjcrew.pokerpalv2.FrontEnd.PokerTable;

/**
 * Created by TheTurok on 10/13/2016.
 */

/*
    Players

    'Players' is a class designed to hold player information during the course of a 
    game session. A 'Players' object contains a static reference to all players in 
    the form of an array. It also contains information about each player, including
    their name, how much money they have, how much they last bet, and their current
    state in the game.

    The master list of players and the index of the last player who made a raise in that
    array are in public scope.

    ### Example usage

    public static void main(String[] args) {
        //make a new Player
        Players firstPlayer = new Players(5,"FirstPlayer");
    }

    Implementation started October 14, 2016 by
    jalbatross 
*/
public class Players {
    public static enum Status {
        ACTIONABLE, ALLIN, FOLD, SITOUT; 
    }

    public static ArrayList<Players> masterList;
    public static int indexOfLastRaiser;

    private boolean masterListInitialized;
    private double money;
    private String name;

    /*
    Players default constructor
    @param: none

    @return: A Players object with money 0, lastBet 0, and name noName.

    */
    public Players() {
        if (!masterListInitialized)
        {
            masterList = new ArrayList<Players>();
            masterListInitialized = true;
        }

        money = 0;
        name = "noName";

        masterList.push_back(this);
    }

    /*
    Players constructor with all parameters. Used to construct a Players object
    with a specified name and amount of starting money. If the Players object
    to be created is vaid it is pushed to the back of the masterList of Players.

    @param money_: A positive double value used to initialize the starting chip
    amount of the Players object. A negative value throws an exception.

    @param name_: String used to initialize the displayed name of the Players
    object. 

    @return: A Players object initialized with money_ worth of chips and a 
    displayed name of name_.
    */
    public Players(double money_, String name_) {
        if (!masterListInitialized)
        {
            masterList = new ArrayList<Players>();
            masterListInitialized = true;
        }

        if (money_ <= 0)
            throw new IndexOutOfBoundsException("Must start with valid money value.");
        
        //Check for valid names
        //Fix name or throw exception if name is invalid

        name = name_;

        masterList.push_back(this);
    }

    
    //You will implement the class of players, and more
    //make sure it has all the information
    // also if you can possible keep the array of all nine players in here, it would be great
    //if there's a better place let me know

/*main three files to complete*/
    //Players - plyer Object
    //Actions - the things playrs can do when buttons are presssed (should extned Game Logic)
    //GameLogic - the turn base logic, and this would do all-in-logic, big blind small blind, etc.
                //game should take care of small blind big blind
                //we should extend many files for this Game Logic to make things look simpler
/*etc files to do*/
    //wifi
    //lobby
    //undo

    //General Tree = would be Game -> choose next player info -> player can do an -> action

    //Note player doesn't call action class, we just keep the functions in that class for simplicity

    //Please keep everything simple, long good names are fine, i rather not have to deal with "m_" work etiquette ahah
}
