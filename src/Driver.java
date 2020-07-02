import javax.swing.*;
import java.awt.*;

public class Driver {
    public static void main(String[] args) {
        root_frame = new JFrame("Path Finding Algorithms");
        // create maze panel
        maze = new Maze(root_frame);

        // create menu panel
        menu = new Menu(maze);




        config();
    }
    private static void config() {
        root_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        root_frame.add(menu.panel, BorderLayout.NORTH);
        root_frame.add(maze.maze_panel, BorderLayout.CENTER);

        root_frame.pack();
        root_frame.setVisible(true);
        root_frame.setLocation(500, 500);
    }

    private static JFrame root_frame;
    private static Menu menu;
    private static Maze maze;
    private static Algs algs;

}
