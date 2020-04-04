import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ComponentBuilder {
    public static JButton[] createBoardButtons(ActionListener actionListener) {
        JButton[] jButtons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            JButton b = new JButton(String.valueOf(i + 1));
            b.setPreferredSize(new Dimension(60, 60));
            b.addActionListener(actionListener);
            jButtons[i] = b;
        }
        return jButtons;
    }

    public static JFrame createWindow() {
        JFrame f = new JFrame("TicTacToe");

        f.getContentPane().removeAll();
        f.setPreferredSize(new Dimension(220, 350));
        f.getContentPane().setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        return f;
    }
}
