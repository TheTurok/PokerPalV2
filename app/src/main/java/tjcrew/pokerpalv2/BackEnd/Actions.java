/*
Actions.java

'Actions' is a public static helper class designed to
simplify the class declaration of GameLogic and Players in 
the app. There are no 'Actions' objects. Rather,
'Actions' contains member functions that act
on 'GameLogic' and/or 'Players' objects in ways that correspond
to actions taken by players during betting rounds of
poker games. Most of the functionality achieved by Actions
is done so by acting directly on the MasterList of Players
for simplicity.

### Example usage

public static void main(String[] args) {
    
    //A player named "PlayerX" folds, so we ovewrwrite our old game with a new game
    where PlayerX is folded.
    Actions.fold("PlayerX");
    //A player named "PlayerY" checks
    Actions.check("PlayerY");

} 

*/

import tjcrew.pokerpalv2.BackEnd.Players;
import tjcrew.pokerpalv2.BackEnd.Players.java;

public static class Actions {
    

    /*
        fold is a function that affects Players objects. 
        It will change the status of aPlayer to FOLDED 
        provided that aPlayer is in the Players MasterList
        and the Player can actually FOLD. If aPlayer is not in a game,
        we will throw an exception.

        @param aPlayer: A valid Players object who wishes to perform a
        fold action during their turn on the current betting round. 
        aPlayer should be a Players within the MasterList of Players, and fold
        throws an exception if this case is not met. 

        @return: No return. Provided aPlayer is in the MasterList and is currently
        in the Poker game being played, aPlayer has its status set to FOLDED.
    */
    public void fold(Players aPlayer) {
        
        //Make sure aGame is not empty
        if(Players.MasterList.size() <= 0)
            throw new IndexOutOfBoundsException("ERROR: Tried to do action with"
                                                 + "no Players in game.");

        boolean foundPlayer = false;
        int masterListIndexOfPlayer = -1;
        //Check aGame to make sure that aPlayer is actually in aGame
        for (int i = 0; i < Players.MasterList.size(); i++) {
            if (Players.masterList[i] == aPlayer) {
                foundPlayer = true;
                masterListIndexOfPlayer = i;
                break;
            }
        }

        //Silent error if the player is not in the game.
        if (!foundPlayer) {
            System.out.println("ERROR: The player that needed to be folded was " 
                                + "not found in the game.");
            return;
        }

        //A player can only fold if it is legally their move to make
        //i.e, they are ACTIONABLE. This is another silent error.
        if (aPlayer.getStatus() != ACTIONABLE)
            return;

        //Set aPlayer to folded then replace them in the masterList
        aPlayer.setStatus(Player.Status.FOLDED);
        Players.masterList[masterListIndexOfPlayer] = aPlayer;
    }
}