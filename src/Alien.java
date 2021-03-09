import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Alien {
	
	private PImage alien;
	
	int  x, y, yspeed;
	
	public Alien(PApplet app, int X, int Y) {

		alien = app.loadImage("data/alien.PNG");
		
		this.x = X;
		this.y = Y;
		
		yspeed = (int)(app.random(3,5));
		
	}
	
	public void pintarAliens(PApplet app) {
		
		app.imageMode(PConstants.CENTER);
		app.image(alien, x, y, 170, 170);
		app.imageMode(PConstants.CORNER);
		
		moverAlien();
				
	}
	
	public void moverAlien() {
		y += yspeed;	
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getYspeed() {
		return yspeed;
	}

	public void setYspeed(int yspeed) {
		this.yspeed = yspeed;
	}
	
}
