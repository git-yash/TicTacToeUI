public enum GameStatus {
    DRAW,
    WIN,
    NEXT;

    public static boolean shouldEndGame(GameStatus status) {
        return status == WIN || status == DRAW;
    }

    public static GameStatus getGameStatus(int numberOfTurns, PositionManager positionManager, Players players) {
        if (numberOfTurns >= 5 && numberOfTurns < 9) {
            if (positionManager.didWinGame(players.getCurrentPlayer())) {
                return WIN;
            }
        } else if (numberOfTurns == 9) {
            return DRAW;
        }

        return NEXT;
    }
}
