package Model;

import java.awt.Color;

import javax.swing.JPanel;

public class Case extends JPanel{
	private int posX;
	private int posY;
	private int taille;
	private Color couleur;
	private Boolean estDisponible;

	public Case(){
		this.taille = 100;
		this.estDisponible = true;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public Boolean getEstDisponible() {
		return estDisponible;
	}

	public void setEstDisponible(Boolean estDisponible) {
		this.estDisponible = estDisponible;
	}
}
