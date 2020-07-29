# Path-Finding-Algorithms-Visualizer-Java
Path Finding Algorithms Visualizer with TkInter<br>
Currently, DFS, BFS, A* are supported.<br>
Basic for algorithm implementation are the same as Python version.
[Python version is also available.](https://github.com/soma-y1029/Path-Finding-Algorithms-Visualizer-in-Java)


## Preparation
So far, as default, this program read a maze file called 'no_wall.txt'.<br>
This text file is available.


## Buttons
* Option Menu "Choose Algorithm":
Choose any algorithm you like. Current options are DFS, BFS, A*.

* Button "Start":
Start program based on chosen algorithm and maze. 

* Button "Reset":
Reset maze board.

* Slider "Time Interval":
Time interval from 0 to 1000 ms (1 sec).
You can change the speed while program is running.



## Algorithm Explanation
For all algorithms, order of neighbor searching is clockwise (top, right, bottom, left).

### DFS
Stack is used for DFS algorithm.
Keep looking for same direction while the direction is available. 
If there is no path for current state, back up and look for different path using backtracking.
![](https://i.imgur.com/E9vzKFi.gif)


### BFS
Queue is used for BFS algorithm.
Look for the neighbors in circular motion until algorithm find goal state. 
![](https://i.imgur.com/XzTnVfa.gif)


### A*
Priority queue is used for A* algorithm. This PQ is based on a sum of greedy function that represents cost from start to current and heuristic fuction that represents cost from current and goal state.
![](https://i.imgur.com/a3fFhUB.gif)






