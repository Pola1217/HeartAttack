import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;


public class Alien_Fuerte {

	private PImage alien1;

	int  x, y;
	
	int yspeed;
	
	public Alien_Fuerte (PApplet app, int x, int y) {
		
		alien1 = app.loadImage("data/alien1.PNG");
		
		this.x = x;
		this.y = y;
		
		yspeed = (int)(app.random(5,7));		
	}

	

	public void pintarAlienF(PApplet app) {
		
		app.imageMode(PConstants.CENTER);
		app.image(alien1, x, y, 150, 150);
		app.imageMode(PConstants.CORNER);
		
		moverAlien();
				
	}

public void moverAlien() {
	y += yspeed;	
}

public float getX( ) {
	return x;
}

public float setX(int X) {
	return X;
}

public float getY() {
	return y;
}

public float setY(int Y) {
	return Y;
}

public float getYspeed() {
	return yspeed;
}

public float setYspeed(int speedY) {
	return yspeed;
}
	
}
