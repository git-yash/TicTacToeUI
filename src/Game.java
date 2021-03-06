import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class Game {
    private JLabel status = new JLabel();
    JFrame window = ComponentBuilder.createWindow();
    JButton resetButton = new JButton("Reset Game");

    private int numberOfTurns = 0;
    private PositionManager positionManager = new PositionManager();
    private Players players = new Players();

    public void startGame() {
        this.players.reset();
        this.numberOfTurns = 0;
        this.positionManager = new PositionManager();

        window.getContentPane().removeAll();
        this.addResetButton();
        this.addBoardButtons();
        this.addStatus();
        window.pack();
        window.setVisible(true);

        this.askFirstPlayer();
    }

    private void askFirstPlayer() {
        this.players.setFirstRandomPlayer();
        this.status.setText(this.players.getCurrentPlayer() + " your turn");
    }

    private void addResetButton() {
        resetButton.addActionListener(this.createResetActionListener());
        resetButton.setPreferredSize(new Dimension(190, 30));
        window.getContentPane().add(resetButton);
    }

    private void addStatus() {
        window.getContentPane().add(status);
    }

    private void addBoardButtons() {
        JButton[] buttons = ComponentBuilder.createBoardButtons(this.createActionListener());
        for (JButton button : buttons) {
            window.getContentPane().add(button);
        }
    }

    private ActionListener createResetActionListener() {
        return e -> this.startGame();
    }

    private void highlightWiningRow() {
        Row winningRow = positionManager.getWinnerRow(this.players.getCurrentPlayer());
        if (winningRow != null) {
            Component[] components = window.getContentPane().getComponents();
            for (Component component : components) {
                if (component.getClass().getName().contains("JButton")) {
                    JButton button = (JButton) component;
                    if (button.getText().equals(players.getCurrentPlayer())) {
                        button.setBackground(Color.green);
                    }
                }
            }
        }
    }

    private ActionListener createActionListener() {
        return e -> {
            JButton button = (JButton) e.getSource();
            String text = button.getText();
            if (this.players.containsPlayer(text)) {
                status.setText("This choice is taken");
                return;
            }

            this.numberOfTurns++;

            this.positionManager.setPosition(Integer.parseInt(button.getText()), this.players.getCurrentPlayer());
            button.setText(this.players.getCurrentPlayer());

            GameStatus gameStatus = GameStatus.getGameStatus(numberOfTurns, positionManager, players);
            String statusText = this.players.getStatusText(gameStatus);
            if (GameStatus.shouldEndGame(gameStatus)) {
                if (gameStatus == GameStatus.WIN) {
                    this.highlightWiningRow();
                }
                showMessageDialog(window, statusText);
                this.startGame();
            } else {
                this.status.setText(statusText);
                this.players.changePlayer();
            }
        };
    }
}
