import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Arma {

	private PImage heroe;

	int  x, y;
	
	int xspeed;

	public Arma(PApplet app, int X, int Y) {

		heroe = app.loadImage("data/heroe.PNG");
		
		this.x = X;
		this.y = Y;
		
		xspeed = (int)(app.random(3,5));
		
	}
	
	public void pintarArma(PApplet app) {
		
		app.imageMode(PConstants.CENTER);
		app.image(heroe, x, y, 150, 150);
		app.imageMode(PConstants.CORNER);
				
	}
	
	public void movAlien(PApplet app) {

	x = app.mouseX;

	if (x < 0) {
		
		x = 20;
		
	} else if (x > 1200) {
		
		x = 1200;
		
	}
	
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
	
	
	

}
