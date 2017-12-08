//
//BouncyBall.java
//
//Example using Random and conditional statements
//CS 121
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Animated program with a ball bouncing off the program boundaries
 * 
 * @author mvail
 */
public class BouncyBall extends JPanel {
	private final int INIT_WIDTH = 600;
	private final int INIT_HEIGHT = 400;
	private final int DELAY = 50; // milliseconds between Timer events
	private Random rand; // random number generator
	private int x, y; // anchor point coordinates
	private int xDelta, yDelta; // change in x and y from one step to the next
	private int rDelta, gDelta, bDelta;
	private int radDelta;
	private final int DELTA_RANGE = 20; // range for xDelta and yDelta
	private int RADIUS; // circle radius

	private int redRand, blueRand, greenRand;

	/**
	 * Draws a filled oval with random color and dimensions.
	 * 
	 * @param g
	 *            Graphics context
	 * @return none
	 */
	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		// clear canvas
		g.setColor(getBackground());
		//g.fillRect(0, 0, width, height);

		RADIUS += radDelta;
		if (RADIUS > 95 || RADIUS < 20) {
			radDelta = -radDelta;
		}

		// CALCULATE NEW X
		x += xDelta;

		if ((x + RADIUS) >= width) {
			if (rand.nextInt(2) > 0) {
				xDelta = -xDelta + 1;
				x = width - RADIUS;
			} else {
				xDelta = -xDelta - 1;
				x = width - RADIUS;
			}
		}
		if ((x - RADIUS) <= 0) {
			if (rand.nextInt(2) > 0) {
				xDelta = -xDelta + 1;
				x = RADIUS;
			} else {
				xDelta = -xDelta - 1;
				x = RADIUS;
			}

		}

		// CALCULATE NEW Y
		y += yDelta;

		if ((y + RADIUS) >= height) {
			if (rand.nextInt(2) > 0) {
				yDelta = -yDelta + 1;
				y = height - RADIUS;
			} else {
				yDelta = -yDelta - 1;
				y = height - RADIUS;
			}
		}
		if ((y - RADIUS) <= 0) {
			if (rand.nextInt(2) > 0) {
				yDelta = -yDelta + 1;
				y = RADIUS;
			} else {
				yDelta = -yDelta - 1;
				y = RADIUS;
			}
		}
		// NOW PAINT THE OVAL
		redRand += rDelta;
		if (redRand > 251 || redRand < 4) {
			rDelta = -rDelta;
		}
		greenRand += gDelta;
		if (greenRand > 249 || greenRand < 6) {
			gDelta = -gDelta;
		}
		blueRand += bDelta;
		if (blueRand > 253 || blueRand < 2) {
			bDelta = -bDelta;
		}

		Color randColor = new Color(redRand, greenRand, blueRand);
		g.setColor(randColor);
		g.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
	}

	/**
	 * Constructor for the display panel initializes necessary variables. Only
	 * called once, when the program first begins. This method also sets up a
	 * Timer that will call paint() with frequency specified by the DELAY
	 * constant.
	 */
	public BouncyBall() {
		setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
		this.setDoubleBuffered(true);
		setBackground(Color.black);

		rand = new Random(); // instance variable for reuse in paint()

		redRand = rand.nextInt(251);
		blueRand = rand.nextInt(249);
		greenRand = rand.nextInt(253);

		// initial ball RADIUS
		RADIUS = rand.nextInt(75) + 20;
		radDelta = 1;

		// initial ball location within panel bounds
		x = rand.nextInt(INIT_WIDTH - 2 * RADIUS) + RADIUS;
		y = rand.nextInt(INIT_HEIGHT - 2 * RADIUS) + RADIUS;

		// deltas for x and y
		xDelta = rand.nextInt(DELTA_RANGE) - DELTA_RANGE / 2;
		yDelta = rand.nextInt(DELTA_RANGE) - DELTA_RANGE / 2;

		rDelta = 4;
		gDelta = 6;
		bDelta = 2;
		// Start the animation - DO NOT REMOVE
		startAnimation();

	}

	/**
	 * Create an animation thread that runs periodically DO NOT MODIFY
	 */
	private void startAnimation() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		};
		new Timer(DELAY, taskPerformer).start();
	}

	/**
	 * Starting point for the BouncyBall program DO NOT MODIFY
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bouncy Ball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BouncyBall());
		frame.pack();
		frame.setVisible(true);
	}

}
