package Graphique;

import java.awt.Graphics;
import javax.swing.JPanel;
import Model.*;

public class EchiquierGraphique extends JPanel{
	
	Echiquier echiquier = Echiquier.getInstance();
	Cavalier cavalier = Cavalier.getInstance();
	
	//Visuel de l'�chiquier
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    //On cr�er toutes les cases de l'�chiquier
	    for (Case key : echiquier.getListeCases()) {
			this.creerCase(key, g);
		}
	    //On place le cavalier au hasard sur l'�chiquier
	    this.creerCavalier(cavalier.getCaseCourante(), g);
	    while(cavalier.getCaseVistitees().size() != echiquier.getListeCases().size()){
	    	cavalier.moveKnight();
	    	this.creerCavalier(cavalier.getCaseCourante(), g);
	    }
	}
		
	//Permet de dessiner une case
	public void creerCase(Case key, Graphics g){
		g.setColor(key.getCouleur());
	    g.fillRect(key.getPosX(), key.getPosY(), key.getTaille(), key.getTaille());
	}
		
	//Permet de dessiner le cavalier, on lui assigne une case ou on doit le placer
	public void creerCavalier(Case uneCase, Graphics g){
        g.drawImage(cavalier.getImage(),uneCase.getPosX(),uneCase.getPosY(),cavalier.getTailleImage(),cavalier.getTailleImage(), this);
	}
	
}
