
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
//import processing.event.MouseEvent;

public class Principal extends PApplet{


	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	int score = 0;
	
	//timer
	int sec;
	int min;
	
	//pantallas
	int screen = 0;
	
	//imagenes de pantallas
	PImage inicio, instruccion, game, lost;
	
	//arma
	Arma arma;
	
	//aliens
	private ArrayList<Alien> alien;
	
	private ArrayList<Alien_Fuerte> alien1;
	
	@Override
	public void settings() {
		size (1200,800);
	}
	
	@Override
	public void setup() {
		
	//fondos generales
	inicio = loadImage ("data/Pinicio.PNG");
	instruccion = loadImage ("data/Prules.PNG");
	lost = loadImage ("data/Lost.PNG");
	
	//arma
	arma = new Arma (this, 600, 725);
	
	//fondo juego
	game = loadImage ("data/Pjuego.PNG");
	
	//timer
	sec = 0;
	min = 0;
	
	//puntaje
	score = 0;
	
	//aliens
	alien = new ArrayList <Alien>();
	frameRate(50);
	
	//alien mas fuerte
	alien1 = new ArrayList <Alien_Fuerte>();
	frameRate(60);
	
	}
	
	@Override
	public void draw() {
		//System.out.println(mouseX+","+mouseY);
	
	background (255);
	
	switch (screen) {
	//INCIO
	case 0:
		image(inicio, 0, 0);
	
	break;
	//CONTROLES E INSTRUC
	case 1:
		image(instruccion, 0, 0);
		
	break;
	//GAME
	case 2:
		
		image(game, 0, 0);
		
		//arma
		arma.pintarArma(this);
		arma.movAlien(this);
		
		//aliens
		aliensInit();
		aliensDraw();
		removeAlien();	
		
		timer();
		
		//score
		fill(0);
		textSize(30);
		text (score,143,42);
		
		break;
		
		//resume
		
		case 3:
			image (lost,0,0);
			
			fill(0);
			textSize(25);
			text(score,495, 500);
			
			if (sec <= 9) {
			    fill(0);
			    textSize(25);
			    text(min + ":0" + sec, 892, 500);
			  } else if (sec > 9) {
			    fill(0);
			    textSize(25);
			    text(min + ":" + sec, 892, 500);
			  }
			
		break;
		
		}

	}
	
	public void timer() {

		if (frameCount % 60 == 0 && min >= 0) {
		      sec++;
		  }
		  if (sec == 60) {
		      min++;
		      sec = 0;
		  }
		  if (min < 0) {
		    fill(0);
		    textSize(30);
		    text("0:00", 540, 42);
		  } else if (sec <= 9) {
		    fill(0);
		    textSize(30);
		    text(min + ":0" + sec, 540, 42);
		  } else if (sec > 9) {
		    fill(0);
		    textSize(30);
		    text(min + ":" + sec, 540, 42);
		  }
	}
	
	public void aliensInit () {
		
		if (frameCount == 50 && sec <= 20) {
			
			int posX = (int) random(60,1000);
			int posY = (int) (80);
					
			alien.add(new Alien(this, posX, posY));
			
			System.out.println("HOLA");
			
			frameCount = 0;
			
		}
		
		if (frameCount == 60 && sec >= 21 && sec <= 60) {
			
			int posX1 = (int) random(100,900);
			int posY1 = (int) (80);
					
			alien1.add(new Alien_Fuerte(this, posX1, posY1));
			
			System.out.println("HOLA1");
			
			frameCount = 0;
			
		}
		
	}

	public void aliensDraw () {
		
	if (sec <= 20) {	
		for (int i = 0; i < alien.size() ; i++) {
			
			alien.get(i).pintarAliens(this);
			
			if (alien.get(i).getY() > 700) {
				
				screen = 3;

			}
			
		}
	}
		
	
	if (sec >= 21 && sec <= 60) {
		
		for (int i = 0; i < alien1.size() ; i++) {
			
			alien1.get(i).pintarAlienF(this);
			
			if (alien1.get(i).getY() > 700) {
				
				screen = 3;

			 }
			
		}
		
   }
	
}
	
	public void removeAlien() {
		
		if(sec <= 20) {
		
		for (int i=0 ; i < alien.size(); i++){
			
			if (alien.get(i).getX() < -alien.get(i).getX()) {
				
				alien.remove(i);
				
			}
			
		}
		
	}
		
		if (sec >= 21 && sec <= 60) {	
			
			for (int i=0 ; i < alien1.size(); i++){
				
				if (alien1.get(i).getX() < -alien1.get(i).getX()) {
					
					alien1.remove(i);
					
				}
				
			}
		}
		
	}
	
	@Override
	public void mousePressed() {
		
		switch (screen) {
		
		case 0://play
			if (dist(mouseX, mouseY, 603, 510) < 30) {
				
				screen = 2;
				
			} 
			//instrucciones
			
			else if(dist(mouseX, mouseY, 603, 604) < 30) {
				
				screen = 1;
				
			}
		break;
		
		case 1://back
			if (dist(mouseX, mouseY, 153, 60) < 50) {
				
				screen = 0;
				
			}
		break;
		
		case 2:
		
			clickAlien ();
				
		break;
		
		case 3://play again
		
			if (dist(mouseX, mouseY, 629, 564) < 30) {
				
				screen = 0;
				
				exit();
				
			}
			
		break;
		
		}
	
	}
	
	private void clickAlien () {
		
		for (int i = 0; i < alien.size(); i++) {
			
			if (alien.get(i).getX() >= -alien.get(i).getX()- 80) {
				
			alien.remove(i);	
			
			score+=10;
			
			}
		}
		
		for (int i = 0; i < alien1.size(); i++) {
			
			if (alien1.get(i).getX() >= -alien1.get(i).getX()- 80) {
				
			alien1.remove(i);	
			
			score+=20;
			
			}
			
		}
		
	}
	
}


