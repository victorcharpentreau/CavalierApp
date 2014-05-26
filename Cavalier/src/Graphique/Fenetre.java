package Graphique;

import javax.swing.JFrame;
import Controller.Echiquier;

public class Fenetre extends JFrame{

private Echiquier echiquier = Echiquier.getInstance();
	
	public Fenetre()
	{             
		this.setTitle("Le cavalier d'Euler");
		this.setSize(echiquier.getNbCasesLigne()*100+10, echiquier.getNbCasesColonne()*100+35);
		//Affiche la fenetre au centre de l'écran
		this.setLocationRelativeTo(null);   
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.getContentPane().add(echiquier);
	    this.setVisible(true);
	} 
}
