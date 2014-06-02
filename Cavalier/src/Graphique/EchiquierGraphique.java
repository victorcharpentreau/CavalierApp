package Graphique;

import java.awt.Graphics;
import javax.swing.JPanel;

import Model.*;

public class EchiquierGraphique extends JPanel{
	
	Echiquier echiquier = Echiquier.getInstance();
	Cavalier cavalier = Cavalier.getInstance();
	
	//Visuel de l'échiquier
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    //On créer toutes les cases de l'échiquier
	    for (Case key : echiquier.getListeCases()) {
			this.creerCase(key, g);
		}
	    //On place le cavalier au hasard sur l'échiquier
	    this.creerCavalier(cavalier.getCaseCourante(), g);
	    //this.jouer();
	}
	
	public void jouer(){
		//Tantque le cavalier n'a pas parcouru toutes les cases du damier, on le fait se déplacer
	    while(cavalier.getCaseVistitees().size() != echiquier.getListeCases().size()){
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cavalier.moveKnight();
	    	this.repaint();
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
	
	public void creerLigne(Case depart, Case arrivee, Graphics g){
		int x1 = depart.getPosX();
		int y1 = depart.getPosY();
		int x2 = arrivee.getPosX();
		int y2 = arrivee.getPosX();
		g.drawLine(x1, y1, x2, y2);
	}
	
}
