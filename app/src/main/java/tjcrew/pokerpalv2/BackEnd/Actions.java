/*
Actions.java

'Actions' is a public static helper class designed to
simplify the class declaration of Game and Players in 
the app. There are no 'Actions' objects. Rather,
'Actions' contains member functions that act
on 'Game' and/or 'Players' objects in ways that correspond
to actions taken by players during betting rounds of
poker games.

### Example usage

public static void main(String[] args) {
    //Game declared
    Game newGame = new Game();
    
    //A player named "PlayerX" folds, so we ovewrwrite our old game with a new game
    where PlayerX is folded.
    newGame = Actions.fold(newGame, "PlayerX");
    //A player named "PlayerY" checks
    newGame = Actions.check(newGame, "PlayerY");

} 

*/

import tjcrew.pokerpalv2.BackEnd.Players;
import tjcrew.pokerpalv2.BackEnd.Players.java;

public static class Actions {
    

    /*
        fold is a function that affects both Game and Players objects. 
        It will change the status of aPlayer in aGame to FOLDED 
        provided that aPlayer is in aGame. If aPlayer is not in a game,
        we will throw an exception.

        @param aGame: A valid Game object with players. fold should not
        be called if there are no players in the game, so fold throws
        an exception in that case. 

        @param aPlayer: A valid Players object who wishes to perform a
        fold action during their turn on the current betting round. 
        aPlayer should be a Players within the Game object, and fold
        throws an exception if this case is not met. 

        @return aGame: Provided that aGame and aPlayer meet all the
        required conditions, fold returns aGame with aPlayer that has
        the status FOLDED.
    */
    public Game fold(Game aGame, Players aPlayer) {
        
        //Make sure aGame is not empty
        if (aGame.numPlayers() <= 0)
            throw new IndexOutOfBoundsException("ERROR: Tried to do action with"
                                                 + "no Players in game.");

        boolean foundPlayer = false;
        int masterListIndexOfPlayer = -1;
        //Check aGame to make sure that aPlayer is actually in aGame
        for (int i = 0; i < aGame.numPlayers(); i++) {
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

        //Set aPlayer to folded then replace them in the masterList
        aPlayer.setStatus(Player.Status.FOLDED);
        Players.masterList[masterListIndexOfPlayer] = aPlayer;

        return aGame;
    }
}