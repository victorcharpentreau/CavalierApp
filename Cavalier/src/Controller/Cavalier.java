package Controller;
	
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public final class Cavalier {
	
	private static volatile Cavalier instance = null;
	private BufferedImage image;
	private Case caseCourante;
	private ArrayList<Case> casePossible;
	private ArrayList<Case> caseVistitees;
	
	private Cavalier(){
		super();
		try {
			this.image = ImageIO.read(new File("res/Cavalier.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public final static Cavalier getInstance(){
		if (Cavalier.instance == null) {
			Cavalier.instance = new Cavalier();
			
		}
        return Cavalier.instance;
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
	
}
