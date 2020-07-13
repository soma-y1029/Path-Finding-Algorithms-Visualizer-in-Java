# Path-Finding-Algorithms-Visualizer-Java
Path Finding Algorithms Visualizer with TkInter<br>
Currently, DFS, BFS are supported.<br>
Basic for algorithm implementation are the same as Python version.
[Python version is also available.](https://github.com/soma-y1029/Path-Finding-Algorithms-Visualizer-in-Java)


## Preparation
So far, as default, this program read a maze file called 'no_wall.txt'.<br>
This text file is available.
To make it work, DIRECTORY in maze.java has to be specified (default is "\\"). 


## Buttons
* Option Menu "Choose Algorithm":
Choose any algorithm you like. Current options are DFS, BFS. (more are coming!)

* Button "Start":
Start program based on chosen algorithm and maze. 

* Button "Reset":
Reset maze board.

## Algorithm Explanation
For all algorithms, order of neighbor searching is clockwise (top, right, bottom, left).

### DFS
Stack is used for DFS data structure.
Keep looking for same direction while the direction is available. 
If there is no path for current state, back up and look for different path using backtracking.


### BFS
Queue is used for BFS data structure.
Look for the neighbors in circular motion until algorithm find goal state. 





