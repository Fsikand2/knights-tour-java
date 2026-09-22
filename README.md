# knights-tour-java
A Java program that solves the Knight’s Tour puzzle on an 8×8 chessboard using recursive backtracking and displays the completed move sequence.


# Knight’s Tour

**Language:** Java
**Focus:** Recursion, backtracking, two-dimensional arrays, and algorithm design

This project solves the Knight’s Tour puzzle: moving a knight around an 8×8 chessboard so that it visits every square exactly once. Starting at position (0, 0), the program explores legal knight moves and backtracks when a path reaches a dead end.

## Key Features

* Explores all eight possible knight moves.
* Checks board boundaries and prevents revisiting squares.
* Uses recursive backtracking to find a complete tour.
* Prints a numbered board showing the order of visited squares.

## How It Works

The board begins with every square marked as unvisited. The starting square is numbered 0, and each subsequent move receives the next number.

If a move leads to a dead end, the program undoes it and tries another path. Once all 64 squares have been visited, it prints the completed board with numbers from 0 through 63.

## How to Run

With a Java Development Kit installed, open a terminal in the folder containing `KnightTour.java` and run:

```bash
javac KnightTour.java
java KnightTour
```

No user input is required. The starting position is set in the source code.

## Notes

This implementation uses a fixed move order without search heuristics, so finding a solution can take time. It finds the first complete tour and does not require the final square to connect back to the starting square.
