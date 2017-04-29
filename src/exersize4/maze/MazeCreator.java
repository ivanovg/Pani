package exersize4.maze;

import exersize4.disjointset.DisjointSet;

import java.util.Random;

public class MazeCreator {

    private Random r = new Random();
    private Maze maze;
    private Wall[] walls;
    private int wallsDone = 0;

    DisjointSet disjointSet;

    /**
     * Konstruktor
     * @param maze
     */
    public MazeCreator(Maze maze) {
        this.maze = maze;
        walls = maze.getWalls();
        disjointSet = new DisjointSet(maze.getColumns()*maze.getRows());
    }

    /* (non-Javadoc)
     * @see hm.edu.cs.algdat17.maze.creation.Steppable#step()
     */
    public void step() {
        if (!hasMoreSteps()) {
            Wall wallToRemove = pickNextWallAtRandom();

            int cellNumber = cellNumber(wallToRemove.getRow(), wallToRemove.getColumn());
            int neighborCellNumber;

            switch (wallToRemove.getDirection()) {
                case UP: if (wallToRemove.getRow() > 0)
                            neighborCellNumber = cellNumber(wallToRemove.getRow() - 1, wallToRemove.getColumn());
                        else
                            neighborCellNumber = cellNumber;
                    break;
                case RIGHT: if (wallToRemove.getColumn() < maze.getColumns() - 1)
                            neighborCellNumber = cellNumber(wallToRemove.getRow(), wallToRemove.getColumn() + 1);
                        else
                            neighborCellNumber = cellNumber;
                    break;
                case DOWN: if (wallToRemove.getRow() < maze.getRows() - 1)
                            neighborCellNumber = cellNumber(wallToRemove.getRow() + 1, wallToRemove.getColumn());
                        else
                            neighborCellNumber = cellNumber;
                    break;
                case LEFT: if (wallToRemove.getColumn() > 0)
                            neighborCellNumber = cellNumber(wallToRemove.getRow(), wallToRemove.getColumn() - 1);
                        else
                            neighborCellNumber = cellNumber;
                    break;
                default: neighborCellNumber = cellNumber;
            }


            if (!disjointSet.areTheSameGroup(cellNumber, neighborCellNumber)) {
                maze.remove(wallToRemove);
                disjointSet.union(cellNumber, neighborCellNumber);
            }
        }
    }

    /**
     * Wählt unter den noch nicht betrachteten Wänden eine zufällig aus.
     * Sortiert sie dann auf den Index wallsDone und zählt den Index hoch.
     *
     * @return
     */
    private Wall pickNextWallAtRandom() {
        int randomIndex = wallsDone + r.nextInt(walls.length - wallsDone);
        Wall wallToRemove = walls[randomIndex];
        walls[randomIndex] = walls[wallsDone];
        walls[wallsDone] = wallToRemove;
        wallsDone++;
        return wallToRemove;
    }

    /* (non-Javadoc)
     * @see hm.edu.cs.algdat17.maze.creation.Steppable#hasMoreSteps()
     */
    public boolean hasMoreSteps() {
        return wallsDone == walls.length;
    }

    /**
     * Hilfsmethode. Berechnet einen eindeutigen Index für die Felder.
     * @param row
     * @param column
     * @return
     */
    private int cellNumber(int row, int column) {
        return row * maze.getColumns() + column;
    }
}
