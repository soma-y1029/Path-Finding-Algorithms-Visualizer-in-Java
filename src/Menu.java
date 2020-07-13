import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    public Menu(Maze maze) {
        this.maze = maze;
        this.panel = new JPanel();
        this.panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 30));
        this.panel.setLayout(new GridLayout(2, 5));

        this.startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        this.resetButton = new JButton("Reset");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.panel.add(this.startButton);
        this.panel.add(this.resetButton);
    }

    private void start() {
        String selected_alg = "DFS";
        algs = new Algs(this.maze);
        this.maze.pathFound(algs.run_alg(selected_alg));
    }
    private Maze maze;
    private Algs algs;
    private JButton startButton;
    private JButton resetButton;
    public JPanel panel;
}
