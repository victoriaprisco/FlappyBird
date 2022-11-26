package maybeFlappyBird;

import java.awt.Color;
import java.util.LinkedList;

public class ObstaclesStubs {
	
	private double xCoord;
	private double gapHeight; 
	private double gapSize;
	private final double width = 0.02;
	private final double yCoord = 0.0;
	private final double height = 1.0;
	private final Color obsColor = StdDraw.GRAY;
	private final Color bgColor = StdDraw.BOOK_LIGHT_BLUE;
	
	/**
	 *  Obstacle object constructor
	 * @param xCoord - the x coordinate of the center of the obstacle
	 * @param gapHeight - the height at which the gap will begin (see assignment page)
	 * @param gapSize - the half height of the gap
	 */
	public ObstaclesStubs(double xCoord, double gapHeight, double gapSize) {
		this.xCoord = xCoord;
		this.gapHeight = gapHeight;
		this.gapSize = gapSize;
	}
	
	/**
	 *  Setter method for the x coordinate of the obstacle object, will move obstacle amount to the left
	 * @param amount
	 */
	public void moveXCoord(double amount) {
		// FIXME
	}
	
	/**
	 * Getter method for the x coordinate
	 * @return double x coordinate
	 */
	public double getXCoord() {
		return 0.0; // FIXME
	}
	
	/**
	 *  Getter method for the width of the object
	 * @return double width
	 */
	public double getWidth() {
		return 0.0; // FIXME 
	}
	
	/**
	 *  Getter method for the two important y coordinates
	 * @return double array, where first index is the bottom bound of the gap, second is the top bound.
	 */
	public double[] getYCoords() {
		return new double[2];// FIXME
	}
	
	/**
	 *  Draw the obstacle
	 */
	public void draw() {
		// FIXME
	}

}
