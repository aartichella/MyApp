## MyApp-Game of Life 
This is an implementation of Conway's Game of Life. 
The screen consists of 12X12 grey coloured cells upon start, symbolizing all dead cells.
The cells turn red when they are alive. This can happen upon clicking or as the game progresses.
The rules for the game to progress are as mentioned below:
  	Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
	Any live cell with two or three live neighbours lives on to the next generation.
	Any live cell with more than three live neighbours dies, as if by overpopulation.
	Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
  	If a neighbor’s position is outside the grid, then we do not consider that neighbor as existent.