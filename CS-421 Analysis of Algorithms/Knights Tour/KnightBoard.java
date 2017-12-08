
import java.util.ArrayList;

/**
 * KnightBoard - 2d array of Positions
 * 
 * @author eric miller
 *
 */
public class KnightBoard {
	private Position[][] board;
	private int size, solutionMovesCount, totalMovesChecked;

	public KnightBoard(int size, int startRow, int startCol) {
		this.size = size;
		this.solutionMovesCount = 1;
		this.totalMovesChecked = 0;
		board = new Position[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = new Position(i, j);
				if (i == startRow && j == startCol) {
					board[i][j].setAsStart();
				}
			}
		}
	}

	public Position getPosition(int row, int col) {
		return board[row][col];
	}

	private ArrayList<Position> getValidMoves(Position curr) {
		ArrayList<Position> moves = new ArrayList<Position>();
		int row = curr.getRow();
		int col = curr.getCol();
		// up 2
		if (row - 2 >= 0) {
			// right 1
			if (col + 1 <= this.size - 1 && !board[row - 2][col + 1].hasBeenVisited()) {
				moves.add(board[row - 2][col + 1]);
			}
		}
		// up 1
		if (row - 1 >= 0) {
			// right 2
			if (col + 2 <= this.size - 1 && !board[row - 1][col + 2].hasBeenVisited()) {
				moves.add(board[row - 1][col + 2]);
			}
		}
		// down 1
		if (row + 1 <= this.size - 1) {
			// right 2
			if (col + 2 <= this.size - 1 && !board[row + 1][col + 2].hasBeenVisited()) {
				moves.add(board[row + 1][col + 2]);
			}
		}
		// down 2
		if (row + 2 <= this.size - 1) {
			// right 1
			if (col + 1 <= this.size - 1 && !board[row + 2][col + 1].hasBeenVisited()) {
				moves.add(board[row + 2][col + 1]);
			}
			// left 1
			if (col - 1 >= 0 && !board[row + 2][col - 1].hasBeenVisited()) {
				moves.add(board[row + 2][col - 1]);
			}
		}
		// down 1
		if (row + 1 <= this.size - 1) {
			// left 2
			if (col - 2 >= 0 && !board[row + 1][col - 2].hasBeenVisited()) {
				moves.add(board[row + 1][col - 2]);
			}
		}
		// up 1
		if (row - 1 >= 0) {
			// left 2
			if (col - 2 >= 0 && !board[row - 1][col - 2].hasBeenVisited()) {
				moves.add(board[row - 1][col - 2]);
			}
		}
		// up 2
		if (row - 2 >= 0) {
			// left 1
			if (col - 1 >= 0 && !board[row - 2][col - 1].hasBeenVisited()) {
				moves.add(board[row - 2][col - 1]);
			}
		}
		return moves;
	}

	public int getTotalMovesChecked() {
		return this.totalMovesChecked;
	}

	public boolean basicSearch(Position curr) {
		if (this.solutionMovesCount == size * size) {
			return true;
		}
		this.totalMovesChecked++;
		getPosition(curr.getRow(), curr.getCol()).setAsVisited();
		ArrayList<Position> validMoves = getValidMoves(curr);
		for (Position p : validMoves) {
			getPosition(p.getRow(), p.getCol()).setAsVisited();
			this.solutionMovesCount++;
			getPosition(p.getRow(), p.getCol()).setMoveNumber(solutionMovesCount);
			basicSearch(getPosition(p.getRow(), p.getCol()));
			if (this.solutionMovesCount == size * size) {
				return true;
			}
			this.solutionMovesCount--;
			getPosition(p.getRow(), p.getCol()).setAsNotVisited();
		}
		return false;
	}

	public ArrayList<Position> reorderMoves_h1(ArrayList<Position> moves) {
		Position tempPosition;
		for (int i = 1; i < moves.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (moves.get(j).getShortestDistanceToBorder() < moves.get(j - 1).getShortestDistanceToBorder()) {
					tempPosition = moves.get(j);
					moves.set(j, moves.get(j - 1));
					moves.set(j - 1, tempPosition);
				}
			}
		}
		return moves;
	}

	public boolean heuristicOneSearch(Position curr) {
		if (this.solutionMovesCount == size * size) {
			return true;
		}
		this.totalMovesChecked++;
		getPosition(curr.getRow(), curr.getCol()).setAsVisited();
		ArrayList<Position> validMoves = getValidMoves(curr);
		validMoves = reorderMoves_h1(validMoves);
		for (Position p : validMoves) {
			getPosition(p.getRow(), p.getCol()).setAsVisited();
			this.solutionMovesCount++;
			getPosition(p.getRow(), p.getCol()).setMoveNumber(solutionMovesCount);
			heuristicOneSearch(getPosition(p.getRow(), p.getCol()));
			if (this.solutionMovesCount == size * size) {
				return true;
			}
			this.solutionMovesCount--;
			getPosition(p.getRow(), p.getCol()).setAsNotVisited();
		}
		return false;
	}

	public ArrayList<Position> reorderMoves_h2(ArrayList<Position> moves) {
		Position tempPosition;
		for (int i = 1; i < moves.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (getValidMoves(moves.get(j)).size() < getValidMoves(moves.get(j - 1)).size()) {
					tempPosition = moves.get(j);
					moves.set(j, moves.get(j - 1));
					moves.set(j - 1, tempPosition);
				}
			}
		}
		return moves;
	}

	public boolean heuristicTwoSearch(Position curr) {
		if (this.solutionMovesCount == size * size) {
			return true;
		}
		this.totalMovesChecked++;
		getPosition(curr.getRow(), curr.getCol()).setAsVisited();
		ArrayList<Position> validMoves = getValidMoves(curr);
		validMoves = reorderMoves_h2(validMoves);
		for (Position p : validMoves) {
			getPosition(p.getRow(), p.getCol()).setAsVisited();
			this.solutionMovesCount++;
			getPosition(p.getRow(), p.getCol()).setMoveNumber(solutionMovesCount);
			heuristicTwoSearch(getPosition(p.getRow(), p.getCol()));
			if (this.solutionMovesCount == size * size) {
				return true;
			}
			this.solutionMovesCount--;
			if (!getPosition(curr.getRow(), curr.getCol()).isStart()) {
				getPosition(p.getRow(), p.getCol()).setAsNotVisited();
			}
		}
		return false;
	}

	public String toString() {
		String ret = "";
		int tempMoveNum;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tempMoveNum = board[i][j].getMoveNumber();
				if (tempMoveNum < 10) {
					ret += " ";
				}
				ret += tempMoveNum + " ";
			}
			ret += "\n";
		}
		return ret;
	}
}
