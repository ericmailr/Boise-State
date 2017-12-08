import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TicTacToe extends JPanel implements ActionListener {
	private final int GRID_DIM = 3;
	private JButton[][] buttons;
	private JButton newGameButton, winner;
	private boolean yourTurn, gameOver;
	private int wins, losses, ties, turns;
	private JLabel winsLabel;

	private TicTacToe() {

		JPanel gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(GRID_DIM, GRID_DIM));
		gameBoard.setPreferredSize(new Dimension(200, 200));

		buttons = new JButton[GRID_DIM][GRID_DIM];
		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons.length; col++) {
				buttons[row][col] = new JButton("");
				buttons[row][col].setFont(new Font("Arial", 0, 32));
				buttons[row][col].addActionListener(this);
				gameBoard.add(buttons[row][col]);
			}
		}

		JPanel menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(120, 200));
		menuPanel.setLayout(new GridLayout(3, 1));
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);
		winsLabel = new JLabel("Wins:      " + " Losses: ");
		this.add(menuPanel);
		menuPanel.add(newGameButton);
		menuPanel.add(winsLabel);
		this.add(gameBoard);

	}

	public boolean isGameOver() {
		for (int row = 0; row < buttons.length; row++) {

			for (int col = 0; col < buttons.length; col++) {
				// rows
				if (buttons[col][0].getText() != ""
						&& buttons[col][0].getText() == buttons[col][1]
								.getText()
						&& buttons[col][0].getText() == buttons[col][2]
								.getText()) {
					gameOver = true;
					winner = buttons[col][0];

				}
				// columns
				else if (buttons[0][row].getText() != ""
						&& buttons[0][row].getText() == buttons[1][row]
								.getText()
						&& buttons[0][row].getText() == buttons[2][row]
								.getText()) {
					gameOver = true;
					winner = buttons[0][row];

				}
				// diagonal
				else if (buttons[0][0].getText() != ""
						&& buttons[0][0].getText() == buttons[1][1].getText()
						&& buttons[0][0].getText() == buttons[2][2].getText()) {
					gameOver = true;
					winner = buttons[0][0];

				}
				// diagonal
				else if (buttons[2][0].getText() != ""
						&& buttons[2][0].getText() == buttons[1][1].getText()
						&& buttons[2][0].getText() == buttons[0][2].getText()) {
					gameOver = true;
					winner = buttons[2][0];

				}

				else if (turns == buttons.length * buttons.length) {
					gameOver = true;
				} else {
					gameOver = false;
				}
			}
		}

		return gameOver;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == newGameButton) {
			for (int row = 0; row < buttons.length; row++) {
				for (int col = 0; col < buttons.length; col++) {
					buttons[row][col].setText("");
				}
			}
			gameOver = false;

		}

		yourTurn = true;
		if (!gameOver) {
			for (int row = 0; row < buttons.length; row++) {

				for (int col = 0; col < buttons.length; col++) {

					if (e.getSource() == buttons[row][col]) {
						if (buttons[row][col].getText() == "") {
							buttons[row][col].setText("X");
							turns++;
							yourTurn = false;
							for (int i = 0; i < buttons.length; i++) {
								for (int j = 0; j < buttons.length; j++) {
									if (buttons[i][j].getText() == "") {
										buttons[i][j].setText("O");
										turns++;
										yourTurn = true;
										break;
									}
								}
								if (yourTurn) {
									break;
								}
							}
						}
					}

				}
			}
		}
		if (!gameOver) {
			for (int row = 0; row < buttons.length; row++) {

				for (int col = 0; col < buttons.length; col++) {
					// rows
					if (buttons[col][0].getText() != ""
							&& buttons[col][0].getText() == buttons[col][1]
									.getText()
							&& buttons[col][0].getText() == buttons[col][2]
									.getText()) {
						gameOver = true;
						winner = buttons[col][0];

					}
					// columns
					else if (buttons[0][row].getText() != ""
							&& buttons[0][row].getText() == buttons[1][row]
									.getText()
							&& buttons[0][row].getText() == buttons[2][row]
									.getText()) {
						gameOver = true;
						winner = buttons[0][row];

					}
					// diagonal
					else if (buttons[0][0].getText() != ""
							&& buttons[0][0].getText() == buttons[1][1]
									.getText()
							&& buttons[0][0].getText() == buttons[2][2]
									.getText()) {
						gameOver = true;
						winner = buttons[0][0];

					}
					// diagonal
					else if (buttons[2][0].getText() != ""
							&& buttons[2][0].getText() == buttons[1][1]
									.getText()
							&& buttons[2][0].getText() == buttons[0][2]
									.getText()) {
						gameOver = true;
						winner = buttons[2][0];

					}

					else if (turns == buttons.length * buttons.length) {
						gameOver = true;
					}
				}
			}
		}

		if (gameOver) {

			if (winner.getText().equals("X")) {
				wins++;
			} else if (winner.getText().equals("O")) {
				losses++;
			} else if (turns == buttons.length * buttons.length) {
				ties++;
			}

			turns = 0;
			winner = new JButton("");
		}
		winsLabel.setText("Wins: " + wins + " Losses: " + losses);

	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Tic-Tac-Toe");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().add(new TicTacToe());
		f.pack();
		f.setVisible(true);

	}
}
