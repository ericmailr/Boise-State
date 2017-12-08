/**
 * Position on KnightBoard. Attributes for row, column, boolean for whether the
 * position has been visited yet, boolean for whether it is the starting
 * position, place in number of moves in solution path
 * 
 * @author eric miller
 *
 */
public class Position {
	private int row, col, moveNumber;
	private boolean beenVisited, start;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
		this.beenVisited = false;
		this.moveNumber = -1;
		this.start = false;
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	public boolean hasBeenVisited() {
		return this.beenVisited;
	}

	public void setAsVisited() {
		this.beenVisited = true;
	}

	public void setAsNotVisited() {
		this.beenVisited = false;
	}

	public int getMoveNumber() {
		return this.moveNumber;
	}

	public int getShortestDistanceToBorder() {
		if (this.col < this.row) {
			return this.col;
		} else {
			return this.row;
		}
	}

	public void setMoveNumber(int moveNumber) {
		this.moveNumber = moveNumber;
	}

	public void setAsStart() {
		this.start = true;
	}

	public boolean isStart() {
		return this.start;
	}

	public String toString() {
		return this.row + " " + this.col + "\n";
	}
}
