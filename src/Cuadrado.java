import processing.core.PApplet;

public class Cuadrado {

	private int posX, posY, tamX, tamY, dirY;
	private boolean isMov;
	private PApplet app;

	public Cuadrado(int posX, int posY, int tamX, int tamY,PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.tamX = tamX;
		this.tamY = tamY;
		isMov = true;
		dirY = 1; 
		this.app = app;
	}
	
	public void drawRect(){
		app.rect(posX,posY,tamX,tamY);
		mov();
	}

	private void mov() {
		if (isMov) {
			posY += 2*dirY;
		}
	}

	public void setMov(boolean isMov) {
		this.isMov = isMov;
	}
	
	public boolean isMov() {
		return isMov;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getTamX() {
		return tamX;
	}

	public int getTamY() {
		return tamY;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}
	


}
