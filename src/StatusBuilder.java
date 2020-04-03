public class StatusBuilder {
    public static String getGameStatus(int numberOfTurns, PositionManager positionManager, Players players) {
        if (numberOfTurns >= 5 && numberOfTurns < 9) {
            if (positionManager.didWinGame(players.getCurrentPlayer())) {
                return "Congratulations, player " + players.getCurrentPlayer() + " wins!";
            }
        } else if (numberOfTurns == 9){
            return "That's a draw";
        }

        return players.getNextPlayer() + " your turn";
    }
}
