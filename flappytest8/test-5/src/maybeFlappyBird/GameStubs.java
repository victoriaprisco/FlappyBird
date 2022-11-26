package maybeFlappyBird;

import java.awt.Color; 
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class GameStubs {
	private final double RADIUS = 0.05;
	private final double REASONABLE_DISTANCE = 0.4;
	private final int SPACE = KeyEvent.VK_SPACE;

	private Color birdColor = null; //TODO, pick a color!
	double xBird = 0; //FIXME
	double yBird = 0; //FIXME

	/** Returns the x coordinate of the previous x coordinate from the object passed in by index
	 * 
	 * @param a, LinkedList of obstacle objects
	 * @param count, the index of the object
	 * @return the x coordinate of the Obstacle object previous to the given object
	 */
	public double getLastXCoord(LinkedList<Obstacle> a, int count) {
//		FIXME
		return 0.0;
	}

	/**Create amt number of obstacles and add them to the list of obstacles
	 * 
	 * @param amt
	 * @return LinkedList of Obstacle objects
	 */
	public LinkedList<Obstacle> createObstacles(int amt) {
//		FIXME
		return new LinkedList<Obstacle>();
	}
	
	/**
	 *  Update the Obstacles based off of what is currently within the screen
	 */
	public void offScreen() {
//		FIXME
	}

	/**
	 *  Draw an initial amount of Obstacle objects
	 */
	public void drawInitial() {
		createObstacles(5);
		draw();
	}

	/**
	 *  Draw the game (all of the Obstacles and bird)
	 */
	public void draw() {
		//	FIXME
	}

	/**
	 *  Update the positions of the Obstacles and redraw
	 * @param deltaTime
	 */
	public void moveGame(double deltaTime) {
		// FIXME
	}

	/**
	 *  Detect whether or not the space bar has been pressed
	 * @return true if it has been pressed, false otherwise
	 */
	public boolean waitKeyInput() {
		return StdDraw.isKeyPressed(SPACE);
	}
	/**
	 *  Move the bird based off of key input
	 * @param pressed
	 */
	public void moveBird(boolean pressed) {
		//FIXME
	}
	
	/**
	 * Detect whether or not the game should continue based off of the game rules (specifications
	 * in the assignment page)
	 * @return true if game should continue, false if game is over
	 */
	public boolean gameAlive() {
		return false; //FIXME
	}
	
	/**
	 * Combine all previous methods and run the main simulation until the game should end
	 */
	public void flapTheBird() {
		// FIXME
	}

	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		Game simulation = new Game();
		simulation.flapTheBird();
	}  
}
