package maybeFlappyBird;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import java.awt.Font;
import edu.princeton.cs.introcs.StdDraw;

public class GapDebugApp {
	private static final double RADIUS = 0.01;
	private static final double REASONABLE_DISTANCE = 0.4;
	private static Color birdColor = new Color((int) (Math.random() * 255),(int) (Math.random() * 255), (int) (Math.random() * 255));
	private static LinkedList<Obstacles> obs = new LinkedList<Obstacles>();
	private static double xBird = 0.2;
	private static double yBird = 0.5;
	public static Obstacles test = new Obstacles(0.3, 0.4, 0.05);

	private static final int SPACE = KeyEvent.VK_SPACE;

	//	 0 - up
	//	 1 - left
	//	 2 - down
	//	 3 - right
	public static void move(int direction) {
		if(direction == KeyEvent.VK_UP) {
			yBird += 0.01;
		}
		else if(direction == KeyEvent.VK_LEFT) {
			xBird -= 0.01;
		}
		else if(direction == KeyEvent.VK_DOWN) {
			yBird -= 0.01;
		}
		else if(direction == KeyEvent.VK_RIGHT) {
			xBird += 0.01;
		}

		StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
		test.draw();
		StdDraw.setPenColor(birdColor);
		StdDraw.filledCircle(xBird, yBird, RADIUS);

		StdDraw.show();
	}  

	public static void testBird() {
		StdDraw.setPenColor(birdColor);
		StdDraw.filledCircle(xBird, yBird, RADIUS);
		StdDraw.show();
		while(true) {
			if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
				move(KeyEvent.VK_LEFT);
			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
				move(KeyEvent.VK_RIGHT);

			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				move(KeyEvent.VK_UP);

			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				move(KeyEvent.VK_DOWN);
			}
			drawAlive();
		}
	}
	public static void drawAlive() {
		boolean alive = Game.gameAlive();
		String errorMessage = "all good!";
//		if(yBird >= 1 || yBird <= 0) {
//			alive = false;
//		}
//		double[] yCoords = test.getYCoords();
//		double bottomLimit = yCoords[0];
//		double topLimit = yCoords[1];
//		double xCoord = test.getXCoord();
//		if(Math.abs(xBird - xCoord) <= test.getWidth()) {
//			if(yBird < bottomLimit) {
//				errorMessage = "The bird crashed into the bottom bar";
//			}
//			if(yBird >= topLimit) {
//				errorMessage = "The bird crashed into the top bar";
//			}
//			alive = false;
//		}
		if(alive) {
			StdDraw.setPenColor(StdDraw.GREEN);
		}
		else {
			StdDraw.setPenColor(StdDraw.RED);
		}
		StdDraw.filledRectangle(0.75, 0.75, 0.2, 0.05);
		StdDraw.setPenColor();
		Font font = new Font("Arial", Font.PLAIN, 10);
		StdDraw.setFont(font);
		StdDraw.setFont(font);
		StdDraw.text(0.75, 0.75, errorMessage);
		StdDraw.show();
	}

	public static void main(String[] args) {
		obs.add(test);
		StdDraw.enableDoubleBuffering();
		Game.draw();
		testBird();
	}
}
