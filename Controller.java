import java.util.ArrayList;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Controller {
	ArrayList<Kachel> way;
	ArrayList<Kachel> node;
	Hamster h;
//Konstruktor
	public Controller(Hamster h){
		way  = new ArrayList<Kachel>();
		node = new ArrayList<Kachel>();
		this.h = h;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////
//											Spalte														 //
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int berechneSpalte(){
	
		int spalte = h.getSpalte();
		int richtung = h.getBlickrichtung();
		
		if (richtung == 1){
			spalte++;
		}
		
		if (richtung == 3){
			spalte--;
		}
	
		return spalte;

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//											Reihe														 //
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int berechneReihe(){

		int reihe = h.getReihe();
		int richtung = h.getBlickrichtung();
	
		if (richtung == 0){
			reihe--;
		}
	
		if (richtung == 2){
			reihe++;
		}
	
		return reihe;

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//											Scan														 //
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//In der Methode Scan, überprüft der Hamster seine Umgebung, indem er sich einmal um 360° dreht und merkt sich wie viele freie Wege existieren.
//Sollte es Freie Wege geben Ruft er die Methode crossing auf, Andern falls ruft er die Methode removeNode und backwards auf.

	public void scan(){
		int freiekachel = 0;
		for(int i=0;i<4;i++){
   
			if (h.vornFrei()){
    			freiekachel ++;
   			}
			linksUm(1);	
		}
		if (freiekachel >0){
			crossing();
		}else{
			removeNode();
			//backwards();
		
		}
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////
//											Move														//
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//In der Methode Move überprüften der Hamster ob sich ein Korn auf seiner aktuellen Position befindet.
//Wenn ja gibt er eine Meldung aus und beendet das Programm. Sollte sich kein Korn an dieser Stelle befinden speichert er seine Possition in Der Arraylist way ein und geht er einen Schritt vor.

	public void move(){
		if (h.kornDa()){
			h.schreib("Das Korn wurde gefunden!");
		}
		way.add(new Kachel(h.getSpalte(),h.getReihe()));
		h.vor();
	} 

///////////////////////////////////////////////////////////////////////////////////////////////////////////
//											crossing													//
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void crossing(){
	
		int row = h.getReihe();
		int column = h.getSpalte();
		node.add(new Kachel(h.getReihe(), h.getSpalte()));
		linksUm(1);
		if(h.vornFrei() && checkWay() == true){
			move();
		}else{

			linksUm(2);
		if(h.vornFrei() && checkWay() == true){
			move();
		}else{
			linksUm(1);
			move();
			}
		}
	}
	// Eine fucking LinksUm Methode!!! von Umut
	public void linksUm(int anzahl){
		for(int i=0; i<anzahl; i++){
			h.linksUm();
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//											removeNode												     //
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void removeNode(){
		if(node.get(node.size()-1).vergleicheKoordinaten(h.getSpalte(),h.getReihe())){
			node.remove(node.size()-1);
		}
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////
//											checkWay												     //
//////////////////////////////////////////////////////////////////////////////////////////////////////////


public boolean checkWay(){

	Kachel k = new Kachel(berechneSpalte(), berechneReihe());
	for(int i = 0; i<way.size(); i++){
		if(way.get(i).equals(k){
			return true;
		}
	}
	return false;
}