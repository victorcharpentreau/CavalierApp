package Model;
	
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Cavalier{
	
	private static volatile Cavalier instance = null;
	
	private BufferedImage image;
	private int tailleImage;
	private Case caseCourante;
	private ArrayList<Case> casePossible = new ArrayList<Case>();
	private ArrayList<Case> caseVistitees = new ArrayList<Case>();
	private final int MOVEX[] = {100, 200, 200, 100, -100, -200, -200, -100};
	private final int MOVEY[] = {-200, -100, 100, 200, 200, 100, -100, -200};
	
	Echiquier echiquier = Echiquier.getInstance();
	
	private Cavalier(){
		initCavalier();
		findPossibleCases(this.getCaseCourante());
	}
	
	public static Cavalier getInstance(){
		if (instance == null){
			instance = new Cavalier();	
		}
		return instance;
	}
	
	public void initCavalier(){
		int lower = 0;
	    int higher = echiquier.getListeCases().size();
	    int random = (int)(Math.random() * (higher-lower)) + lower;
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("res/Cavalier.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setImage(image);
		this.setTailleImage(100);
		this.setCaseCourante(echiquier.getListeCases().get(random));
		this.getCaseVistitees().add(this.getCaseCourante());
		this.getCaseCourante().setCouleur(Color.green);
	}
	
	//Recherche des prochaines cases possibles pour le déplacement du cavalier
	public void findPossibleCases(Case caseCourante){
		this.setCasePossible(new ArrayList<Case>());
		//ici, à partir de la case sur lequel le cavalier est placé, on ajoute tous les déplacements possibles 
		for (int i = 0; i < 8; i++) {
			int newX = caseCourante.getPosX() + MOVEX[i];
			int newY = caseCourante.getPosY() + MOVEY[i];
			//Si la case possible est bien dans le périmètre de l'échiquier
			if ((newX >= 0) && (newX < Echiquier.getInstance().getNbCasesColonne()*100) && (newY >= 0) && (newY < Echiquier.getInstance().getNbCasesLigne()*100)){
				Case possibilite  = this.findCaseByPos(newX, newY);
				if (!this.getCaseVistitees().contains(possibilite) ) {
					this.getCasePossible().add(possibilite);
				}
			}
		}
	}
	
	//Rechercher une case en fonction de ses coordonnées
	public Case findCaseByPos(int posX, int posY){
		Echiquier echiquier = Echiquier.getInstance();
		Case possibilite = new Case();
		for (Case key : echiquier.getListeCases())
		{
			if (key.getPosX() == posX && key.getPosY() == posY){
				possibilite = key;
			}
		}
		return possibilite;
	}
	
	//Déplacer le cavalier
	public void moveKnight(){		
		//Choisie une case au hasard parmis ces cases là
		int lower = 0;
	    int higher = this.getCasePossible().size();
	    int random = (int)(Math.random() * (higher-lower)) + lower;
	    Case choisie = this.getCasePossible().get(random);
	    
	    //Case courante = this.getCaseCourante();
	    //this.getCasePossible().add(courante);
	    this.getCaseVistitees().add(choisie);
	    this.getCasePossible().remove(choisie);
	    this.setCaseCourante(choisie);
	    this.getCaseCourante().setCouleur(Color.green);
	    
		//cherche les cases possibles
		findPossibleCases(this.getCaseCourante());
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public ArrayList<Case> getCasePossible() {
		return casePossible;
	}

	public void setCasePossible(ArrayList<Case> casePossible) {
		this.casePossible = casePossible;
	}

	public ArrayList<Case> getCaseVistitees() {
		return caseVistitees;
	}

	public void setCaseVistitees(ArrayList<Case> caseVistitees) {
		this.caseVistitees = caseVistitees;
	}

	public Case getCaseCourante() {
		return caseCourante;
	}

	public void setCaseCourante(Case caseCourante) {
		this.caseCourante = caseCourante;
	}

	public int getTailleImage() {
		return tailleImage;
	}

	public void setTailleImage(int tailleImage) {
		this.tailleImage = tailleImage;
	}
	
}
