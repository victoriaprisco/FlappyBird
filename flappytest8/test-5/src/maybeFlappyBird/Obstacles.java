package maybeFlappyBird;

import java.awt.Color;
import java.util.LinkedList;

import edu.princeton.cs.introcs.*;

public class Obstacle {
	
	private double xCoord;
	private double gapHeight;
	private double gapSize;
	private final double width = 0.02;
	private final double yCoord = 0.0;
	private final double height = 1.0;
	private final Color obsColor = StdDraw.GRAY;
	private final Color bgColor = StdDraw.BOOK_LIGHT_BLUE;
	
	
	public Obstacle(double xCoord, double gapHeight, double gapSize) {
		this.xCoord = xCoord;
		this.gapHeight = gapHeight;
		this.gapSize = gapSize;
	}
	public void moveXCoord(double amount) {
		xCoord -= amount;
	}
	public double getXCoord() {
		return this.xCoord;
	}
	public double getWidth() {
		return width;
	}
	public double[] getYCoords() {
		return new double[] {gapHeight - gapSize/2, gapHeight + gapSize};
	}
	public void draw() {
		StdDraw.setPenColor(obsColor);
		StdDraw.filledRectangle(xCoord, yCoord, width, height);
		StdDraw.setPenColor(bgColor);
		StdDraw.filledRectangle(xCoord, yCoord + gapHeight, width + 0.01, gapSize);
	}

}
