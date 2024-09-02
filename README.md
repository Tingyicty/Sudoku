# Sudoku

- This project involves two parts:
  1. A sodoku solver
  2. A sudoku generator of three different levels of difficulties
 
- To use the program, see the samples in Main class

- GUI is in progress, which will include the playing sudoku function, as well as solving


# A bit about the algorithm

- Solving
  Solving sudoku in this project involves backtracking, meaning that it is trying out one blank following by another. It is a very inefficient way if it is done by hand, but okay if applied on a machine.

- Generating
  The first step to generate a sudoku with blanks is to generate a fully filled one. My approach is to fill the very first row randomly, and then use my sudoku solver to solve the problem. Afterwards, certain numbers are replaced by 0 (blank) each row depending on the difficulty. 
