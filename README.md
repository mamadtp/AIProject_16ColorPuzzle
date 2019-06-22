# AIProject_16ColorPuzzle
A* solution for solving 16 Color Puzzle!

## Getting Started
A* (pronounced "A star") is a AI algorithm that is widely used in pathfinding and graph traversal, which is the process of finding a path between multiple points, called "nodes". It enjoys widespread use due to its performance and accuracy. However, in practical travel-routing systems, it is generally outperformed by algorithms which can pre-process the graph to attain better performance

we convert our solution to a graph so we can use A* for sloving it.


### Prerequisites

You only need a Java on your system

```
JAVA
```

### Running

Clone project on your system and compile it with java.
16 color puzzle is matrix game enter your matrix into the app
and A* solve the game for you!
each number is a sign of a color.

* Input

```

4 4 3 4
2 1 3 2 
3 4 2 3
3 0 2 3

```


* Output

```
1 2 3 4
2 3 4 3 
3 4 3 2
4 3 2 0
```
### Heuristic

In computer science, artificial intelligence, and mathematical optimization, a heuristic  is a technique designed for solving a problem more quickly when classic methods are too slow, or for finding an approximate solution when classic methods fail to find any exact solution.
our heuristic in this solution is Manhattan length ,we computing in each step  Manhattan length between our step and the goal.



## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/) - The IDE used
* [JAVA](https://www.java.com/download//) - Dependency 



## Authors

* **Mohamad Taghipour** - *-------->* - [MamadTp](https://github.com/mamadtp)



## Acknowledgments

* JAVA
* AI
* A*
* Heuristic Function


