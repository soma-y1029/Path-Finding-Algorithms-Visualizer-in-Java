import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Maze extends JPanel{

    public Maze(JFrame root) {
        this.mazeContent = getMazeContent(NO_WALL);
        this.root = root;
        this.height = mazeContent.length;
        this.width = mazeContent[0].length();

        this.pixels = new JLabel[this.height][this.width];
        this.timeInterval = 0;


        setMaze();
        initializeMaze();
    }

    public int[] getStarting_point() {
        return starting_point;
    }

    public int[] getGoal_point() {
        return goal_point;
    }

    public boolean isStart(int[] point){
        return this.starting_point[0] == point[0] && this.starting_point[1] == point[1];
    }

    public boolean isGoal(int[] point){
        return this.goal_point[0] == point[0] && this.goal_point[1] == point[1];
    }

    public void changeColor(int[] point) {
        if (!isStart(point))
            this.pixels[point[1]][point[0]].setBackground(Color.CYAN);

//        addPixels();
    }

    public void pathFound(int[][] soln) {
        // reverse as soln contains from goal to start (soln path in reverse order)
        for (int i = soln.length-2; i > 0; i--) {
            int pixels_x = soln[i][0];
            int pixels_y = soln[i][1];
            String arrow = "";
            if (soln[i-1][0] < pixels_x) // left
                arrow = "\u2190";
            else if (soln[i-1][0] > pixels_x) // right
                arrow = "\u2192";
            else if (soln[i-1][1] < pixels_y) // up
                arrow = "\u2191";
            else if (soln[i-1][1] > pixels_y) // down
                arrow = "\u2193";
            this.pixels[pixels_y][pixels_x].setText(arrow);
        }
//        addPixels();
    }

    public ArrayList<int[]> neighbor(int[] point) {
        int x = point[0];
        int y = point[1];
        ArrayList<int[]> neighbor = new ArrayList<>();

        // up
        if (y != 0 && !isWall(x, y-1))
            neighbor.add(0, new int[]{x, y-1});
        // right
        if (x != this.width-1 && !isWall(x+1, y))
            neighbor.add(0, new  int[]{x+1, y});
        // down
        if (y != this.height-1 && !isWall(x, y+1))
            neighbor.add(0, new int[]{x, y+1});
        // left
        if (x != 0 && !isWall(x-1, y))
            neighbor.add(0, new int[]{x-1, y});

        return neighbor;
    }

    public void reset() {
        this.root.remove(mazePanel);
        setMaze();
        initializeMaze();
        root.add(this.mazePanel, BorderLayout.CENTER);
        root.pack();
    }

    private void setMaze() {
        this.mazePanel = new JPanel();
        this.mazePanel.setPreferredSize(new Dimension(this.width*40, this.height*40));
        this.mazePanel.setLayout(new GridLayout(this.height, this.width));
        this.mazePanel.setBackground(Color.GRAY);
        this.mazePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private boolean isWall(int x, int y) {
        return this.mazeContent[y].charAt(x) == 'W';
    }

    private String[] getMazeContent(String fileName) {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> mazeContent = new ArrayList<>();
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
                mazeContent.add(line);
            }
            reader.close();
            return mazeContent.toArray(new String[mazeContent.size()]);
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", fileName);
            e.printStackTrace();
            return null;
        }
    }

    private void initializeMaze() {
        int y=0;
        for (String line : this.mazeContent) {
            for (int x = 0; x < line.length(); x++) {
                JLabel pixel = new JLabel();
                pixel.setHorizontalAlignment(JLabel.CENTER);
                pixel.setPreferredSize(new Dimension(this.width*2, this.height*2));
                pixel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                pixel.setOpaque(true);

                char letter = line.charAt(x);

                if (letter == 'W')
                    pixel.setBackground(Color.BLACK);

                else if (letter == 'S') {
                    this.starting_point = new int[]{x, y};
                    pixel.setBackground(Color.YELLOW);
                } else if (letter == 'G') {
                    this.goal_point = new int[]{x, y};
                    pixel.setBackground(Color.GREEN);
                } else
                    pixel.setBackground(Color.WHITE);

                this.pixels[y][x] = pixel;
            }
            y++;
        }
        addPixels();
    }

    private void addPixels() {
        for (JLabel pixelLine[] : pixels)
            for (JLabel pixel : pixelLine)
                this.mazePanel.add(pixel);
    }

    public JPanel mazePanel;
    private JLabel[][] pixels;

    private static String NO_WALL = "/Users/somayoshida/Program/Java Projects/Path Finding Algorithms Visualizer/src/no_wall.txt";
    private String[] mazeContent;
    private JFrame root;

    private int timeInterval;
    private int[] starting_point, goal_point;
    private int width, height;


    }
