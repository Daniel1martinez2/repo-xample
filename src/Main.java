
import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {

	private ArrayList<Cuadrado> listaCuadrados;
	private Cuadrado cuadradito;

	public Main() {
	}

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		listaCuadrados = new ArrayList<Cuadrado>();
		// cuadradito = new Cuadrado(200, 100, 50, 50, this);
		rectMode(CENTER);
		frameRate(60);
	}

	public void draw() {
		background(255);
		initRects();
		drawRects();
		imOut(); 
		deleteMe(); 
		// cuadradito.drawRect();
	}

	public void mousePressed() {
		clickRects();
	}

	private void initRects() {
		if (frameCount == 60) {
			int tam = (int) random(30, 60);
			int posX = (int) random(50, 750);
			listaCuadrados.add(new Cuadrado(posX, -50, tam, tam, this));
			System.out.println(listaCuadrados.size());
			frameCount = 0;
		}
	}

	private void drawRects() {
		for (int i = 0; i < listaCuadrados.size(); i++) {
			listaCuadrados.get(i).drawRect();
		}
	}

	private void clickRects() {
		for (int i = 0; i < listaCuadrados.size(); i++) {
			if (mouseX > (listaCuadrados.get(i).getPosX() - (listaCuadrados.get(i).getTamX() / 2))
					&& mouseX < (listaCuadrados.get(i).getPosX() + (listaCuadrados.get(i).getTamX() / 2))
					&& mouseY > (listaCuadrados.get(i).getPosY() - (listaCuadrados.get(i).getTamY() / 2))
					&& mouseY < (listaCuadrados.get(i).getPosY() + (listaCuadrados.get(i).getTamY() / 2))) {
				listaCuadrados.get(i).setMov(!listaCuadrados.get(i).isMov());
			}
		}
	}
	private void imOut() {
		
		listaCuadrados.forEach(c->{
			if(c.getPosY()+(c.getTamY()/2)>=800) {
				c.setDirY(c.getDirY()*-1);
			}; 
		});
	}
	private void deleteMe() {
		for (int i = 0; i < listaCuadrados.size(); i++) {
			if(listaCuadrados.get(i).getPosY()<=0 && listaCuadrados.get(i).getDirY()==-1) {
				listaCuadrados.remove(i); 	
			}
		}
	}
}
