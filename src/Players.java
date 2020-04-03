public class Players {
    private String player1SymbolChoice = "X";
    private String player2SymbolChoice = "O";

    private String currentPlayerSymbolChoice = "";

    public String getCurrentPlayer() {
        return this.currentPlayerSymbolChoice;
    }

    public boolean containsPlayer(String text) {
        return text.equals(this.player1SymbolChoice) || text.equals(this.player2SymbolChoice);
    }

    public void changePlayer() {
        this.currentPlayerSymbolChoice = this.currentPlayerSymbolChoice.equals(this.player2SymbolChoice) ?
                this.player1SymbolChoice :
                this.player2SymbolChoice;
    }

    public String getNextPlayer() {
        return this.currentPlayerSymbolChoice.equals(this.player2SymbolChoice) ?
                this.player1SymbolChoice :
                this.player2SymbolChoice;
    }


    public String getStatusText(GameStatus status) {
        switch (status) {
            case DRAW:
                return "This is a draw";
            case WIN:
                return "Player " + this.getCurrentPlayer() + " wins";
            default:
            case NEXT:
                return "Player " + this.getNextPlayer() + " your turn";
        }
    }

    public void reset() {
        this.currentPlayerSymbolChoice = "";
    }

    public void setFirstRandomPlayer() {
        this.currentPlayerSymbolChoice = Util.coinFlip() ? this.player1SymbolChoice : this.player2SymbolChoice;
    }
}
