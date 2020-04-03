public class PositionManager {
    private String[] positions = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public boolean isMatchingRow(int position1, int position2, int position3, String symbol) {
        return this.positions[position1 - 1].equals(symbol) &&
                this.positions[position2 - 1].equals(symbol) &&
                this.positions[position3 - 1].equals(symbol);
    }

    public boolean didWinGame(String playerSymbolChoice) {
        return this.isMatchingRow(1, 2, 3, playerSymbolChoice) ||
                this.isMatchingRow(4, 5, 6, playerSymbolChoice) ||
                this.isMatchingRow(7, 8, 9, playerSymbolChoice) ||

                this.isMatchingRow(1, 4, 7, playerSymbolChoice) ||
                this.isMatchingRow(2, 5, 8, playerSymbolChoice) ||
                this.isMatchingRow(3, 6, 9, playerSymbolChoice) ||

                this.isMatchingRow(3, 5, 7, playerSymbolChoice) ||
                this.isMatchingRow(1, 5, 9, playerSymbolChoice);
    }

    public void setPosition(int index, String symbol) {
        this.positions[index - 1] = symbol;
    }
}
