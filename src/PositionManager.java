import java.util.ArrayList;
import java.util.List;

public class PositionManager {
    private String[] positions = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private List<Row> winnerRows;

    public PositionManager() {
        this.winnerRows = new ArrayList<>();
        winnerRows.add(new Row(1, 2, 3));
        winnerRows.add(new Row(4, 5, 6));
        winnerRows.add(new Row(7, 8, 9));

        winnerRows.add(new Row(1, 4, 7));
        winnerRows.add(new Row(2, 5, 8));
        winnerRows.add(new Row(3, 6, 9));

        winnerRows.add(new Row(3, 5, 7));
        winnerRows.add(new Row(1, 5, 9));
    }

    private boolean isMatchingRow(Row row, String symbol) {
        return this.positions[row.column1 - 1].equals(symbol) &&
                this.positions[row.column1 - 1].equals(symbol) &&
                this.positions[row.column3 - 1].equals(symbol);
    }

    public Row getWinnerRow(String playerSymbolChoice) {
        for (Row winnerRow : this.winnerRows) {
            if (this.isMatchingRow(winnerRow, playerSymbolChoice)) {
                return winnerRow;
            }
        }
        return null;
    }

    public boolean didWinGame(String playerSymbolChoice) {
        return this.getWinnerRow(playerSymbolChoice) != null;
    }

    public void setPosition(int index, String symbol) {
        this.positions[index - 1] = symbol;
    }
}
