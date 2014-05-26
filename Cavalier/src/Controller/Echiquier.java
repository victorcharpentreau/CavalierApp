package Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public final class Echiquier extends JPanel{
	
	private static volatile Echiquier instance = null;
	private int nbCasesLigne = 8;
	private int nbCasesColonne = 8;
	private ArrayList<Case> listeCases = new ArrayList<Case>();
	
	private Echiquier(){
		super();
	}
	
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    creerEchiquier(g);
	}
	
	public void creerCase(Color couleur, int x, int y, int taille, Graphics g){
		g.setColor(couleur);
	    g.fillRect(x, y, taille, taille);
	}
	
	public void creerCavalier(int x, int y, Graphics g){
		Cavalier cavalier = Cavalier.getInstance();
        g.drawImage(cavalier.getImage(),x,y,60,60, this);
	}
	
	public void creerEchiquier(Graphics g) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < nbCasesLigne; i++) {
			for (int j = 0; j < nbCasesColonne; j++) {
				if ((i+j) % 2 == 0) {
					Color couleurNoire = new Color(136,66,29);
					Case noire = new Case();
					noire.setPosX(x);
					noire.setPosY(y);
					noire.setCouleur(couleurNoire);
					
					this.getListeCases().add(noire);
					
					x = (i+1)*noire.getTaille()-noire.getTaille();
					y = (j+1)*noire.getTaille()-noire.getTaille();
					
					//Création d'une case noire
					this.creerCase(couleurNoire, x, y, noire.getTaille(), g);
				}else{
					Color couleurBlanche = new Color(250,234,115);
					Case blanche = new Case();
					blanche.setPosX(x);
					blanche.setPosY(y);
					blanche.setCouleur(couleurBlanche);
					
					this.getListeCases().add(blanche);
					
					x = (i+1)*blanche.getTaille()-blanche.getTaille();
					y = (j+1)*blanche.getTaille()-blanche.getTaille();
					
					//Création d'une case blanche
					this.creerCase(couleurBlanche, x, y, blanche.getTaille(), g);
				}
			}
		}
	}

	public final static Echiquier getInstance(){
		if (Echiquier.instance == null) {
			Echiquier.instance = new Echiquier();
		}
        return Echiquier.instance;
	}

	public ArrayList<Case> getListeCases() {
		return listeCases;
	}

	public void setListeCases(ArrayList<Case> listeCases) {
		this.listeCases= listeCases;
	}

	public int getNbCasesLigne() {
		return nbCasesLigne;
	}

	public void setNbCasesLigne(int nbCasesLigne) {
		this.nbCasesLigne = nbCasesLigne;
	}

	public int getNbCasesColonne() {
		return nbCasesColonne;
	}

	public void setNbCasesColonne(int nbCasesColonne) {
		this.nbCasesColonne = nbCasesColonne;
	}
	
	
}
