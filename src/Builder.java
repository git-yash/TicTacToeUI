import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Builder {
    private String player1SymbolChoice = "X";
    private String player2SymbolChoice = "O";
    private String currentPlayerSymbolChoice = "";
    private Positions positions = new Positions();
    private JLabel status = new JLabel("test");
    private int numberOfTurns = 0;
    JFrame f = new JFrame("TicTacToe");
    JButton resetButton = new JButton("Reset Game");

    public void startGame() {
        f.getContentPane().removeAll();
        f.setPreferredSize(new Dimension(220, 350));
        f.getContentPane().setLayout(new FlowLayout());

        resetButton.addActionListener(this.createResetActionListener());
        resetButton.setPreferredSize(new Dimension(200, 30));
        f.getContentPane().add(resetButton);

        JButton[] buttons = this.createButtons();
        for (JButton button : buttons) {
            f.getContentPane().add(button);
        }
        f.getContentPane().add(status);

        f.pack();
        f.setVisible(true);

        this.currentPlayerSymbolChoice = this.coinFlip() ? this.player1SymbolChoice : this.player2SymbolChoice;
        this.status.setText(this.currentPlayerSymbolChoice + " your turn");
    }

    private ActionListener createResetActionListener() { return e -> this.startGame(); }

    private ActionListener createActionListener() {
        return e -> {
            JButton button = (JButton) e.getSource();
            String text = button.getText();
            if (text.equals(this.player1SymbolChoice) || text.equals(this.player2SymbolChoice)) {
                status.setText("This choice is taken");
                return;
            }

            this.numberOfTurns++;
            this.positions.setPosition(Integer.parseInt(button.getText()), this.currentPlayerSymbolChoice);
            button.setText(this.currentPlayerSymbolChoice);
            String gameStatus = this.getGameStatus();
            this.status.setText(gameStatus);
            this.currentPlayerSymbolChoice = this.currentPlayerSymbolChoice.equals(this.player2SymbolChoice) ? this.player1SymbolChoice : this.player2SymbolChoice;
        };
    }

    private JButton[] createButtons() {
        JButton[] jButtons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            JButton b = new JButton(String.valueOf(i + 1));
            b.setPreferredSize(new Dimension(60, 60));
            b.addActionListener(this.createActionListener());
            jButtons[i] = b;
        }
        return jButtons;
    }

    private String getGameStatus() {
        if (this.numberOfTurns >= 5 && this.numberOfTurns < 9) {
            if (this.positions.didWinGame(this.currentPlayerSymbolChoice)) {
                return "Congratulations, player " + this.currentPlayerSymbolChoice + " wins!";
            }
        } else if (this.numberOfTurns == 9) {
            return "That's a draw";
        }
        return this.currentPlayerSymbolChoice + " your turn";
    }

    private boolean coinFlip() {
        double value = Math.round(Math.random());
        return value % 2 == 0;
    }
}
