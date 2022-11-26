package maybeFlappyBird;

import java.awt.Color; 
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import edu.princeton.cs.introcs.*;


/*
 * methods:
 * 	- draw initial
 * - wait for key input
 * - jump
 * - move game
 *  - is alive
 */


public class Game {
	private static final double RADIUS = 0.01;
	private static final double REASONABLE_DISTANCE = 0.4;
	private static Color birdColor = new Color((int) (Math.random() * 255),(int) (Math.random() * 255), (int) (Math.random() * 255));
	private static LinkedList<Obstacles> obs = new LinkedList<Obstacles>();
	private static double xBird = 0.2;
	private static double yBird = 0.5;
	private static final int SPACE = KeyEvent.VK_SPACE;

	//	returns the x coordinate of the previous obstacle in the list
	public static double getLastXCoord(LinkedList<Obstacles> a, int count) {
		if(count == 0) {
			return 0.3;
		}
		return a.get(count - 1).getXCoord();
	}

	// creates amt of obstacles in the obs list
	public static LinkedList<Obstacles> createObstacles(int amt) {
		System.out.println(obs.size());
		int count = obs.size();
		while(count < amt) {
			double xCoordLast = getLastXCoord(obs, count);
			double xCoord =  (Math.random()) / 2;
			while(xCoord - xCoordLast < REASONABLE_DISTANCE) {
				xCoord += Math.random() / 2;
			}
			double gapHeight = Math.random() + 0.1;
			double gapWidth = Math.random() + 0.09;
			while(gapHeight > 0.9) {
				gapHeight = Math.random() + 0.1;
			}
			while (gapWidth > 0.15) {
				gapWidth = Math.random() + 0.09;
			}
			Obstacles temp = new Obstacles(xCoord, gapHeight, gapWidth);
			obs.addLast(temp);
			count++;
		}
		return obs;
	}
	public static void offScreen() {
		if(obs.get(obs.size()-1).getXCoord() < REASONABLE_DISTANCE) {
			Obstacles temp = obs.get(obs.size()-1);
			obs.clear();
			obs.addFirst(temp);
			createObstacles(3);
		}
	}

	public static void drawInitial() {
		createObstacles(5);
		draw();
	}

	public static void draw() {
		StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
		
		for(Obstacles o : obs) {
			o.draw();
		}
		StdDraw.setPenColor(birdColor);
		StdDraw.filledCircle(xBird, yBird, RADIUS);
		StdDraw.show();
	}

	public static void moveGame(double deltaTime) {
		for(Obstacles o : obs) {
			o.moveXCoord(deltaTime * 0.07);
		}
		offScreen();
		draw();
	}

	public static boolean waitKeyInput() {
		return StdDraw.isKeyPressed(SPACE);
	}
	public static void moveBird(boolean pressed) {
		yBird  = pressed ? yBird + 0.004 : yBird - 0.007;
	}
	
	public static boolean gameAlive() {
		if(yBird >= 1 || yBird <= 0) {
			return false;
		}
		for(Obstacles o : obs) {
			double[] yCoords = o.getYCoords();
			double bottomLimit = yCoords[0];
			double topLimit = yCoords[1];
			double xCoord = o.getXCoord();
			if((Math.abs(xBird - xCoord) <= o.getWidth()) && (yBird < bottomLimit || yBird >= topLimit)) {
				return false;
			}
		}
		return true;
	}
	
	public static void flapTheBird() {
		StdDraw.enableDoubleBuffering();
		drawInitial();
		boolean pressed = false;
		int frameCount = 0;
		int frameUp = -2;
		while(gameAlive()) {
			moveGame(0.07);
			if(waitKeyInput() && !pressed) {
				pressed = true;
				frameUp = frameCount;
			}
			int temp = frameCount;
			while(frameUp >= 0 && temp - frameUp < 5) {
				moveBird(true);
				temp++;
			}
			if(!waitKeyInput() && pressed)  {
				pressed = false;
			}
			moveBird(pressed);
			draw();
			frameCount++;
		}
		StdDraw.setPenColor();
		StdDraw.text(0.5, 0.5,  "game over you suck :(");
		StdDraw.show();
	}

	public static void main(String[] args) {
		flapTheBird();
	}
		
}
