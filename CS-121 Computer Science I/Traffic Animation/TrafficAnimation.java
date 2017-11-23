/* 
 * TrafficAnimation.java 
 * CS 121 Project 1: Traffic Animation
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Uses the graphics class to animate Bart Simpson on a skateboard moving right
 * to left and a car moving to the right in a separate lane. Homer Simpson
 * stands and observes.
 * 
 * @author Eric Miller
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel {

	private final int DELAY = 100; // milliseconds
	// anchor coordinates / values for drawing / animating
	private int x = 0;
	private int xCycle = 0;
	private int carx = 0;
	private int carxCycle = 0;
	private double theta1 = 0;
	private double theta2 = Math.PI / 2;
	private double theta3 = Math.PI;
	private double theta4 = 3 * Math.PI / 2;
	// pixels added to x each time paintComponent() is called
	private int stepSize = 10;

	/**
	 * This method draws on the applet's Graphics context. This is where the
	 * majority of my work is.
	 */
	public void paintComponent(Graphics canvas) {
		// clears the previous image
		super.paintComponent(canvas);

		String str = "\"Eat my shorts!\"";

		canvas.setFont(new Font("Verdana", Font.BOLD, 30));

		FontMetrics metrics = canvas.getFontMetrics(); // Get Font's metrics

		Dimension d = getSize(); // Get the frame's size

		setBackground(Color.gray);

		// account for changes to window size
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the canvas with the background color
		canvas.setColor(getBackground());
		canvas.fillRect(0, 0, width, height);

		xCycle = (xCycle + 3 * stepSize / 2) % (17 * width / 10);
		x = 11 * width / 10 - xCycle;
		carxCycle = (carxCycle + 2 * stepSize) % (3 * width / 2);
		carx = -width / 4 + carxCycle;

		// Background Painting
		Color sidewalkGray = new Color(220, 220, 220); // Sidewalk
		canvas.setColor(sidewalkGray);
		canvas.fillRect(0, 17 * height / 32, width, height / 8);
		canvas.fillRect(0, 0, width, height / 16);

		canvas.setColor(Color.black);
		canvas.drawLine(width / 8, 17 * height / 32 + height / 8, width / 8,
				17 * height / 32);
		canvas.drawLine(2 * width / 8, 17 * height / 32 + height / 8,
				2 * width / 8, 17 * height / 32);
		canvas.drawLine(3 * width / 8, 17 * height / 32 + height / 8,
				3 * width / 8, 17 * height / 32);
		canvas.drawLine(4 * width / 8, 17 * height / 32 + height / 8,
				4 * width / 8, 17 * height / 32);
		canvas.drawLine(5 * width / 8, 17 * height / 32 + height / 8,
				5 * width / 8, 17 * height / 32);
		canvas.drawLine(6 * width / 8, 17 * height / 32 + height / 8,
				6 * width / 8, 17 * height / 32);
		canvas.drawLine(7 * width / 8, 17 * height / 32 + height / 8,
				7 * width / 8, 17 * height / 32);

		canvas.drawLine(width / 8, 0, width / 8, height / 16);
		canvas.drawLine(2 * width / 8, 0, 2 * width / 8, height / 16);
		canvas.drawLine(3 * width / 8, 0, 3 * width / 8, height / 16);
		canvas.drawLine(4 * width / 8, 0, 4 * width / 8, height / 16);
		canvas.drawLine(5 * width / 8, 0, 5 * width / 8, height / 16);
		canvas.drawLine(6 * width / 8, 0, 6 * width / 8, height / 16);
		canvas.drawLine(7 * width / 8, 0, 7 * width / 8, height / 16);

		Color grassGreen = new Color(50, 205, 50); // Grass
		canvas.setColor(grassGreen);
		canvas.fillRect(0, 17 * height / 32 + height / 8, width, height);

		int stringx = x + width / 8;
		int stringy = (d.height + metrics.getHeight()) / 3;

		canvas.setColor(Color.black);

		canvas.drawString(str, stringx, stringy);

		// Car Dimensions
		int cary = height / 4;
		int carh = height / 13;
		int carw = 5 * width / 12;
		int carxcoordinates[] = { carx - carw / 3, carx - carw / 8,
				carx + carw / 8, carx + carw / 3 };
		int carycoordinates[] = { cary - carh, cary - 2 * carh,
				cary - 2 * carh, cary - carh };
		int windxcoordinates[] = { carx - carw / 4, carx - carw / 9,
				carx + carw / 9, carx + carw / 4 };
		int windycoordinates[] = { cary - carh, cary - 5 * carh / 3,
				cary - 5 * carh / 3, cary - carh };

		canvas.setColor(Color.red); // Car
		canvas.fillRoundRect(carx - carw / 2, cary - carh, carw, carh,
				width / 45, width / 60);
		canvas.fillPolygon(carxcoordinates, carycoordinates, 4);
		canvas.setColor(Color.black);
		canvas.fillOval(carx - 3 * carw / 8, cary - 7 * carh / 12,
				7 * carh / 6, 7 * carh / 6);
		canvas.fillOval(carx + carw / 5, cary - 7 * carh / 12, 7 * carh / 6,
				7 * carh / 6);
		canvas.fillPolygon(windxcoordinates, windycoordinates, 4);
		canvas.setColor(Color.red);
		canvas.fillRect(carx - carw / 16, cary - 2 * carh, carw / 32, carh);

		double r1 = carh / 3, wheel2x1, wheel2y1, wheel2x2, wheel2y2, wheel2x3, wheel2y3, wheel2x4, wheel2y4; // Car
																												// wheel
																												// animation
		theta1 = theta1 + .4;
		theta2 = theta2 + .4;
		theta3 = theta3 + .4;
		theta4 = theta4 + .4;

		wheel2x1 = carx + carw / 5 + 7 * carh / 12 + r1 * Math.cos(theta1);
		wheel2y1 = cary + r1 * Math.sin(theta1);

		wheel2x2 = carx + carw / 5 + 7 * carh / 12 + r1 * Math.cos(theta2);
		wheel2y2 = cary + r1 * Math.sin(theta2);

		wheel2x3 = carx + carw / 5 + 7 * carh / 12 + r1 * Math.cos(theta3);
		wheel2y3 = cary + r1 * Math.sin(theta3);

		wheel2x4 = carx + carw / 5 + 7 * carh / 12 + r1 * Math.cos(theta4);
		wheel2y4 = cary + r1 * Math.sin(theta4);

		int wheel2x11 = (int) (wheel2x1);
		int wheel2y11 = (int) (wheel2y1);
		int wheel2x21 = (int) (wheel2x2);
		int wheel2y21 = (int) (wheel2y2);
		int wheel2x31 = (int) (wheel2x3);
		int wheel2y31 = (int) (wheel2y3);
		int wheel2x41 = (int) (wheel2x4);
		int wheel2y41 = (int) (wheel2y4);

		canvas.setColor(Color.gray);
		canvas.drawLine(carx + carw / 5 + 7 * carh / 12, cary, wheel2x11,
				wheel2y11);
		canvas.drawLine(carx + carw / 5 + 7 * carh / 12, cary, wheel2x21,
				wheel2y21);
		canvas.drawLine(carx + carw / 5 + 7 * carh / 12, cary, wheel2x31,
				wheel2y31);
		canvas.drawLine(carx + carw / 5 + 7 * carh / 12, cary, wheel2x41,
				wheel2y41);

		double wheel1x1, wheel1y1, wheel1x2, wheel1y2, wheel1x3, wheel1y3, wheel1x4, wheel1y4;

		wheel1x1 = carx - 3 * carw / 8 + 7 * carh / 12 + r1 * Math.cos(theta1);
		wheel1y1 = cary + r1 * Math.sin(theta1);

		wheel1x2 = carx - 3 * carw / 8 + 7 * carh / 12 + r1 * Math.cos(theta2);
		wheel1y2 = cary + r1 * Math.sin(theta2);

		wheel1x3 = carx - 3 * carw / 8 + 7 * carh / 12 + r1 * Math.cos(theta3);
		wheel1y3 = cary + r1 * Math.sin(theta3);

		wheel1x4 = carx - 3 * carw / 8 + 7 * carh / 12 + r1 * Math.cos(theta4);
		wheel1y4 = cary + r1 * Math.sin(theta4);

		int wheel1x11 = (int) (wheel1x1);
		int wheel1y11 = (int) (wheel1y1);
		int wheel1x21 = (int) (wheel1x2);
		int wheel1y21 = (int) (wheel1y2);
		int wheel1x31 = (int) (wheel1x3);
		int wheel1y31 = (int) (wheel1y3);
		int wheel1x41 = (int) (wheel1x4);
		int wheel1y41 = (int) (wheel1y4);

		canvas.setColor(Color.gray);
		canvas.drawLine(carx - 3 * carw / 8 + 7 * carh / 12, cary, wheel1x11,
				wheel1y11);
		canvas.drawLine(carx - 3 * carw / 8 + 7 * carh / 12, cary, wheel1x21,
				wheel1y21);
		canvas.drawLine(carx - 3 * carw / 8 + 7 * carh / 12, cary, wheel1x31,
				wheel1y31);
		canvas.drawLine(carx - 3 * carw / 8 + 7 * carh / 12, cary, wheel1x41,
				wheel1y41);

		// Bart Dimensions
		int boardw = height / 9;
		int boardh = height / 50;
		int y = 18 * height / 32;
		int boardxpoints[] = { x + boardw, x + boardw, x + 10 * boardw / 8,
				x + 10 * boardw / 8 };
		int boardypoints[] = { y + boardh, y, y - boardh, y };
		int shoew = 2 * boardh;
		int legh = shoew;
		int legw = boardh;
		int centerx = x + boardw / 2;
		int shortw = 2 * shoew;
		int shorth = 9 * legh / 8;
		int shirth = 13 * legh / 8;
		int shirtw = 7 * shortw / 9;

		int hairxcoordinates1[] = { centerx - 5 * shortw / 12,
				centerx - 5 * shortw / 12 + shortw / 16,
				centerx - 5 * shortw / 12 + shortw / 8 };
		int hairycoordinates1[] = {
				y - 9 * legh / 2 - 19 * shirth / 16 + shirth / 14,
				y - 9 * legh / 2 - 19 * shirth / 16 - height / 128,
				y - 9 * legh / 2 - 19 * shirth / 16 };
		int hairxcoordinates2[] = { centerx - 5 * shortw / 12 + shortw / 8,
				centerx - 5 * shortw / 12 + 3 * shortw / 16,
				centerx - 5 * shortw / 12 + shortw / 4 };
		int hairycoordinates2[] = {
				y - 9 * legh / 2 - 19 * shirth / 16 + shirth / 22,
				y - 9 * legh / 2 - 19 * shirth / 16 - height / 128,
				y - 9 * legh / 2 - 19 * shirth / 16 };
		int hairxcoordinates3[] = { centerx - 5 * shortw / 12 + shortw / 4,
				centerx - 5 * shortw / 12 + 5 * shortw / 16,
				centerx - 5 * shortw / 12 + 3 * shortw / 8 };
		int hairycoordinates3[] = {
				y - 9 * legh / 2 - 19 * shirth / 16 + shirth / 22,
				y - 9 * legh / 2 - 19 * shirth / 16 - height / 128,
				y - 9 * legh / 2 - 19 * shirth / 16 };
		int hairxcoordinates4[] = { centerx - 5 * shortw / 12 + 3 * shortw / 8,
				centerx - 5 * shortw / 12 + 7 * shortw / 16,
				centerx - 5 * shortw / 12 + 4 * shortw / 8 };
		int hairycoordinates4[] = {
				y - 9 * legh / 2 - 19 * shirth / 16 + shirth / 22,
				y - 9 * legh / 2 - 19 * shirth / 16 - height / 128,
				y - 9 * legh / 2 - 19 * shirth / 16 };
		int hairxcoordinates5[] = { centerx - 5 * shortw / 12 + 4 * shortw / 8,
				centerx - 5 * shortw / 12 + 9 * shortw / 16,
				centerx - 5 * shortw / 12 + 5 * shortw / 8 };
		int hairycoordinates5[] = {
				y - 9 * legh / 2 - 19 * shirth / 16 + shirth / 22,
				y - 9 * legh / 2 - 19 * shirth / 16 - height / 128,
				y - 9 * legh / 2 - 19 * shirth / 16 };
		int hairxcoordinates6[] = { centerx - 5 * shortw / 12 + 5 * shortw / 8,
				centerx - 5 * shortw / 12 + 11 * shortw / 16,
				centerx - 5 * shortw / 12 + 6 * shortw / 8 };
		int hairycoordinates6[] = {
				y - 9 * legh / 2 - 19 * shirth / 16 + shirth / 22,
				y - 9 * legh / 2 - 19 * shirth / 16 - height / 128,
				y - 9 * legh / 2 - 19 * shirth / 16 + shirth / 14 };

		// Bart Drawing
		canvas.setColor(Color.green); // skateboard
		canvas.fillRect(x, y, boardw, boardh);
		canvas.fillPolygon(boardxpoints, boardypoints, 4);
		canvas.fillOval(x - boardh / 2, y, boardh, boardh);

		canvas.setColor(Color.red); // wheels
		canvas.fillOval(x + boardw / 16, y + boardh, boardh, boardh);
		canvas.fillOval(x + 12 * boardw / 16, y + boardh, boardh, boardh);

		canvas.setColor(Color.yellow); // legs
		canvas.fillRect(centerx - 6 * shoew / 8, y - legh, legw, legh);
		canvas.fillRect(centerx + 3 * shoew / 8, y - legh, legw, legh);

		canvas.setColor(Color.blue); // shoes
		canvas.fillArc(x + boardw / 2 - 2 * boardh, y - boardh, 2 * boardh,
				2 * boardh, 0, 180);
		canvas.fillArc(x + boardw / 2 + boardh / 4, y - boardh, 2 * boardh,
				2 * boardh, 0, 180);

		canvas.fillRect(centerx - shortw / 2, y - legh - shorth, shortw, shorth); // shorts
		canvas.fillArc(centerx - 9 * shortw / 16, y - legh - shorth - 17
				* shortw / 16, 17 * shortw / 8, 17 * shortw / 8, 180, 25);

		canvas.setColor(Color.red); // shirt
		canvas.fillArc(centerx - 9 * shortw / 16, y - legh - shorth - 17
				* shortw / 16, 17 * shortw / 8, 17 * shortw / 8, 140, 40);
		canvas.fillRect(centerx - 5 * shirtw / 12, y - legh - shorth - shirth,
				shirtw, shirth);
		canvas.fillArc(centerx + shortw / 5, y - legh - shorth - 23 * shorth
				/ 16, shortw / 2, shortw / 2, 0, 180);

		canvas.setColor(Color.yellow); // arm
		canvas.fillRect(centerx + shortw / 4 + shirth / 5, y - legh - shorth
				- shirth + shortw / 4, shirtw / 4, 3 * shirth / 4);

		canvas.fillRoundRect(centerx - 5 * shortw / 12, y - 9 * legh / 2 - 19 // head
				* shirth / 16, 6 * shortw / 8, 11 * shirth / 8, 5, 5);
		canvas.fillRoundRect(centerx - 6 * shortw / 24, y - 9 * legh / 2 - 19
				* shirth / 16, 2 * shortw / 4, 23 * shirth / 16, 5, 5);
		canvas.fillRect(centerx - shortw / 7, y - 9 * legh / 2 - 9 * shirth
				/ 16, 10 * shirtw / 16, shirth);
		canvas.fillOval(centerx + shortw / 4, y - 5 * legh - shirth / 8,
				shortw / 6, shortw / 8);

		canvas.setColor(Color.white); // eyes
		canvas.fillOval(centerx - 5 * shortw / 10, y - 16 * legh / 4 - shirth,
				shortw / 3, shortw / 3);
		canvas.fillOval(centerx - 3 * shortw / 14, y - 16 * legh / 4 - shirth,
				shortw / 3, shortw / 3);
		canvas.setColor(Color.black);
		canvas.fillOval(centerx - 3 * shortw / 20, y - 15 * legh / 4 - shirth,
				shortw / 13, shortw / 13);
		canvas.fillOval(centerx - 9 * shortw / 20, y - 15 * legh / 4 - shirth,
				shortw / 13, shortw / 13);

		canvas.setColor(Color.yellow); // bart's hair
		canvas.fillRoundRect(centerx - 6 * shortw / 13, y - 3 * legh - 21
				* shirth / 16, shortw / 4, shortw / 8, 5, 5);
		canvas.fillPolygon(hairxcoordinates1, hairycoordinates1, 3);
		canvas.fillPolygon(hairxcoordinates2, hairycoordinates2, 3);
		canvas.fillPolygon(hairxcoordinates3, hairycoordinates3, 3);
		canvas.fillPolygon(hairxcoordinates4, hairycoordinates4, 3);
		canvas.fillPolygon(hairxcoordinates5, hairycoordinates5, 3);
		canvas.fillPolygon(hairxcoordinates6, hairycoordinates6, 3);

		// Homer Dimensions
		int homerx = 2 * width / 3;
		int homery = 33 * height / 32;
		int homerpantw = 6 * shortw / 6;
		int homerpanth = 3 * shoew;
		int homershoeh = 4 * boardh;
		int homershoew = 2 * shoew;
		int homerbelly = 14 * shortw / 8;
		int homerheadw = 63 * shortw / 64;
		int homerheadh = 12 * shortw / 8;

		// Homer's shoes
		canvas.setColor(Color.black);
		canvas.fillArc(homerx - 7 * homershoew / 8, homery - homershoeh,
				homershoew, homershoeh, 0, 180);
		canvas.fillRect(homerx - homershoew / 4, homery - homershoeh,
				2 * homershoew / 3, homershoeh / 2);

		// pants/gut
		canvas.setColor(Color.blue);
		canvas.fillRect(homerx - 9 * homerpantw / 16, homery - homershoeh - 15
				* homerpanth / 16, homerpantw, homerpanth);
		canvas.fillArc(homerx - homerbelly + homerbelly / 2, homery
				- homershoeh - homerpanth - 3 * homerbelly / 5, homerbelly,
				homerbelly, 180, 180);

		canvas.setColor(Color.white); // Homer shirt
		canvas.fillArc(homerx - homerbelly + homerbelly / 2, homery
				- homershoeh - homerpanth - 7 * homerbelly / 10, homerbelly,
				19 * homerbelly / 16, 345, 210);
		canvas.fillRect(homerx - 7 * homerbelly / 16, homery - homershoeh
				- homerpanth - homerbelly / 4, 7 * homerbelly / 8,
				homerbelly / 4);

		canvas.setColor(Color.yellow); // Homer arm
		canvas.fillRoundRect(homerx, homery - homershoeh / 2 - homerpanth
				- homerbelly, 5 * homerbelly / 16, 3 * homerbelly / 4, 15, 15);

		canvas.fillRoundRect(homerx - homerheadw / 2, homery - homerpanth // head
				- homerbelly - homerbelly / 3 - homerheadh, homerheadw,
				homerheadh, 40, 40);

		canvas.setColor(Color.white); // Homer shoulder
		canvas.fillArc(homerx - homershoew / 4, homery - homershoeh
				- homerpanth - 13 * homerbelly / 16, homerbelly / 2,
				homerbelly / 2, 0, 180);
		canvas.fillRect(homerx - homerbelly / 4, homery - 5 * homershoeh / 8
				- homerpanth - homerbelly, 7 * homerpantw / 8, homerbelly / 5);

		canvas.setColor(Color.orange); // Homer mouth
		canvas.fillArc(homerx - 3 * homershoew / 5, homery - 7 * homershoew / 8
				- homerpanth - homerbelly - homerbelly / 4, 6 * homerpantw / 8,
				6 * homerheadh / 12, 0, 180);
		canvas.fillArc(homerx - 11 * homershoew / 20, homery - 7 * homershoew
				/ 8 - homerpanth - homerbelly - homerbelly / 4,
				11 * homerpantw / 16, 5 * homerheadh / 12, 180, 180);
		canvas.setColor(Color.black);
		canvas.drawLine(homerx - 11 * homershoew / 20, homery - 31 * homershoew
				/ 64 - homerpanth - homerbelly - homerbelly / 4, homerx - 5
				* homershoew / 12, homery - 31 * homershoew / 64 - homerpanth
				- homerbelly - homerbelly / 4);

		canvas.setColor(Color.white); // Homer eyes
		canvas.fillOval(homerx - homershoew / 2 + homerheadh / 9, homery - 3
				* homershoew / 4 - homerpanth - homerbelly - homerbelly / 2,
				5 * homerheadh / 20, 5 * homerheadh / 20);
		canvas.fillOval(homerx - homershoew / 2 - homerheadh / 20, homery - 3
				* homershoew / 4 - homerpanth - homerbelly - homerbelly / 2,
				5 * homerheadh / 20, 5 * homerheadh / 20);

		canvas.setColor(Color.yellow); // Homer head finishing touches
		canvas.fillOval(homerx - 17 * homerpantw / 32, homery - 37 * legh / 4,
				shortw / 4, shortw / 8);
		canvas.fillOval(homerx + 15 * homerheadw / 32, homery - 37 * legh / 4,
				shortw / 8, shortw / 6);
		canvas.setColor(Color.black);
		canvas.drawLine(homerx + homerheadw / 3, homery - 37 * legh / 4, homerx
				+ homerheadw / 3 + homerheadw / 16, homery - 38 * legh / 4);
		canvas.drawLine(homerx + homerheadw / 3 + homerheadw / 16, homery - 38
				* legh / 4, homerx + homerheadw / 3 + 2 * homerheadw / 16,
				homery - 37 * legh / 4);
		canvas.drawLine(homerx + homerheadw / 3 + 2 * homerheadw / 16, homery
				- 37 * legh / 4, homerx + homerheadw / 3 + 3 * homerheadw / 16,
				homery - 38 * legh / 4);
		canvas.drawLine(homerx + homerheadw / 3 + 3 * homerheadw / 16, homery
				- 38 * legh / 4, homerx + homerheadw / 3 + 4 * homerheadw / 16,
				homery - 37 * legh / 4);
		canvas.fillOval(homerx - homershoew / 2 + homerheadh / 8, homery - 3
				* homershoew / 4 - homerpanth - homerbelly - homerbelly / 2
				+ homerheadh / 11, homerheadh / 20, homerheadh / 20);
		canvas.fillOval(homerx - homershoew / 2 - homerheadh / 30, homery - 3
				* homershoew / 4 - homerpanth - homerbelly - homerbelly / 2
				+ homerheadh / 11, homerheadh / 20, homerheadh / 20);
		canvas.drawArc(homerx - homerheadw / 16, homery - homershoeh / 2
				- homerpanth - homerbelly - 18 * homerheadh / 16,
				homerheadw / 4, homerheadw / 3, 340, 180);
		canvas.drawArc(homerx - 3 * homerheadw / 16, homery - homershoeh / 2
				- homerpanth - homerbelly - 18 * homerheadh / 16,
				homerheadw / 4, homerheadw / 3, 340, 190);
	}

	/**
	 * Constructor for the display panel initializes necessary variables. Only
	 * called once, when the program first begins. This method also sets up a
	 * Timer that will call paint() with frequency specified by the DELAY
	 * constant.
	 */
	public TrafficAnimation() {
		setBackground(Color.black);
		// Do not initialize larger than 800x600
		int initWidth = 800;
		int initHeight = 600;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		// Start the animation - DO NOT REMOVE
		startAnimation();
	}

	// ///////////////////////////////////////////
	// DO NOT MODIFY main() or startAnimation()
	// ///////////////////////////////////////////

	/**
	 * Starting point for the TrafficAnimation program
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Traffic Animation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Create an animation thread that runs periodically DO NOT MODIFY this
	 * method!
	 */
	private void startAnimation() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				repaint();
			}
		};
		new Timer(DELAY, taskPerformer).start();
	}
}
