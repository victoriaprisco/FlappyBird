package maybeFlappyBird;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class GapDebugApp {
	private final static double RADIUS = 0.01;
	private static Color birdColor = StdDraw.BLACK;
	private static double x = 0.2;
	private static double y = 0.5;

	public static void move(Obstacle test, int direction) {
		y = direction == KeyEvent.VK_UP? y + 0.001 : direction == KeyEvent.VK_DOWN ? y - 0.001 : y;
		x = direction == KeyEvent.VK_LEFT? x - 0.001 : direction == KeyEvent.VK_RIGHT ? x + 0.001 : x;
	}  

	public static void testBird(Obstacle test, Game a) {
		StdDraw.setPenColor(birdColor);
		StdDraw.filledCircle(x, y, RADIUS);
		StdDraw.show();
		while(!StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
			if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
				move(test, KeyEvent.VK_LEFT);
			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
				move(test, KeyEvent.VK_RIGHT);

			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				move(test, KeyEvent.VK_UP);

			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				move(test, KeyEvent.VK_DOWN);
			}
			StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
			drawAlive(a);
			test.draw();
			StdDraw.setPenColor(birdColor);
			StdDraw.filledCircle(x, y, RADIUS);
			StdDraw.show();
		}
	}
	public static void drawAlive(Game a) {
		a.xBird = x;
		a.yBird = y;
		boolean alive = a.gameAlive();
		String errorMessage;
		if(alive) {
			errorMessage = "all good!";
			StdDraw.setPenColor(StdDraw.GREEN);
		}
		else {
			errorMessage = "bird died";
			StdDraw.setPenColor(StdDraw.RED);
		}
		StdDraw.filledRectangle(0.75, 0.75, 0.2, 0.05);
		StdDraw.setPenColor();
		Font font = new Font("Arial", Font.PLAIN, 10);
		StdDraw.setFont(font);
		StdDraw.text(0.75, 0.75, errorMessage);
	}

	public static void main(String[] args) {
		Game a = new Game();
		Obstacle test = new Obstacle(0.3, 0.4, 0.2);
		a.obs.add(test);
		StdDraw.enableDoubleBuffering();
//		a.draw();
		testBird(test, a);
	}
}
