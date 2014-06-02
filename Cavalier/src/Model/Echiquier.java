package Model;

import java.awt.Color;
import java.util.ArrayList;

public class Echiquier{
	
	private static volatile Echiquier instance = null;
	
	private int nbCasesLigne = 8;
	private int nbCasesColonne = 8;
	private ArrayList<Case> listeCases = new ArrayList<Case>();
	
	protected Echiquier(){
		initEchiquier();
	}
	
	public static Echiquier getInstance(){
		if (instance == null) {
			instance = new Echiquier();
		}
        return instance;
	}
	
	//Initialisation des cases de l'échiquier et ajout dans le tableau de cases.
	public void initEchiquier(){
		int x = 0;
		int y = 0;
		for (int i = 0; i < this.getNbCasesLigne(); i++) {
			for (int j = 0; j < this.getNbCasesColonne(); j++) {
				Case caseEchiquier = new Case();
				Color couleur;
				if ((i+j) % 2 == 0) {
					couleur = new Color(136,66,29);
					
				}else{
					couleur = new Color(250,234,115);
				}
				//On déclare la position des cases de l'échiquier en fonction de la taille de chaque case.
				x = (i+1)*caseEchiquier.getTaille()-caseEchiquier.getTaille();
				y = (j+1)*caseEchiquier.getTaille()-caseEchiquier.getTaille();
				caseEchiquier.setCouleur(couleur);
				caseEchiquier.setPosX(x);
				caseEchiquier.setPosY(y);
				this.getListeCases().add(caseEchiquier);
			}
		}
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
