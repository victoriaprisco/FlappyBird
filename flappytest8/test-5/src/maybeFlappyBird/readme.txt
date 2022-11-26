Flappy Bird Java Game - Victoria Prisco 11/2022
Game methods:
	public double getLastXCoord(LinkedList<Obstacle> a, int count)
		Using the LinkedList, return the x coordinate of the Obstacle object that comes before the object at index "count".
	
	public LinkedList<Obstacles> createObstacles(int amt) 
		Randomly generate "amt" number of Obstacle objects, returning a LinkedList of the generated objects. The Obstacle constructor takes in 3 doubles:
		the x coordinate of the object, a variable called gapHeight - the height at which the gap will begin, and gapSize - the half height of the gap.
		Depending on scale, tinkering with the ranges of these numbers is inevitable, but the following should be a good starting place for a 0 to 1 scale:
			x coordinate - from 0 to 0.5 (more on this later)
			gapHeight - from 0.1 to 0.9
			gapSize - from 0.09 to 1.0
		The trick with the x coordinate is finding a way to ensure that the new obstacle won't be too close to the previous one! If the two obstacles are
		touching or nearly touching, the game will be far too hard/maybe impossible. Make sure you re-generate a random x coordinate if two obstacles are 
		too close! (A number is provided to you (called REASONABLE_DISTANCE) that will provide a reasonable distance for the two obstacles to be from
		each other.
	
	public void offScreen() 
	
	
	
	public void drawInitial() 
	
	
	public void draw() 
	
	public void moveGame(double deltaTime) 
	
	
	public boolean waitKeyInput() 
	
	public void moveBird(boolean pressed) 
	
	public boolean gameAlive() 
		
	public void flapTheBird() 
