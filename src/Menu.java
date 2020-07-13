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

        menuList = new JComboBox(algMenu);
        this.menuList.setSelectedIndex(0);
        this.menuList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedAlg = algMenu[menuList.getSelectedIndex()];
            }
        });

        this.panel.add(this.menuList);
        this.panel.add(this.startButton);
        this.panel.add(this.resetButton);
    }

    private void start() {
        algs = new Algs(this.maze);
        this.maze.pathFound(algs.run_alg(selectedAlg));
    }
    private String[] algMenu = {"Choose Algorithm", "DFS", "BFS"};
    private String selectedAlg;

    private Maze maze;
    private Algs algs;
    private JButton startButton;
    private JButton resetButton;
    private JComboBox menuList;
    public JPanel panel;
}
