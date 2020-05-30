import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Knoten {
    private Kachel kachel;
    private Knoten vorgaenger;
    private Knoten[] nachfolger;
    boolean deadEnd;
    
    Knoten(boolean kachelFrei, int spalte, int zeile){
    	this.kachel = new Kachel(kachelFrei, spalte, zeile);
    	nachfolger = new Knoten[4];
    	deadEnd = false;
    }
    public Kachel getKachel(){
    	return this.kachel;
    }
    public Knoten getVorgaenger(){
    	return this.vorgaenger;
    }
    public void setVorgaenger(Knoten vorgaenger){
    	this.vorgaenger = vorgaenger;
 	}
    public Knoten getNachfolger(int i){
    	if(i >-1 && i< 5){
    		return nachfolger[i];
    	}
    	return null;
    }
    public void setDeadEnd(){
    	this.deadEnd = true;
    }
    public boolean getDeadEnd(){
    	return this.deadEnd;
    }
    public Knoten findeKnoten(int spalte, int zeile){
		if(this.getKachel().vergleicheKoordinaten(spalte,zeile)){
			return this;
		}
   		for(int i =0; i<4; i++){
   			if(nachfolger[i] != null){
   				if(nachfolger[i].getKachel().vergleicheKoordinaten(spalte,zeile)){
   					return nachfolger[i];
   				}
   			}
   		}
   		Knoten gefunden =null;
   		for(int i =0; i<4; i++){
   			if(nachfolger[i] != null){
   				gefunden = nachfolger[i].findeKnoten(spalte,zeile);
   			}
   		}
    	return gefunden;
    }
    public boolean addKnoten(Knoten knoten){
    	for(int i=0;i<4;i++){
    		if(nachfolger[i] ==null){
    			nachfolger[i] = knoten;
    			knoten.setVorgaenger(this);
    			return true;
    		}
    	}
    	return false;
    }
    public String toString(){		
		String s = kachel.toString();
     	return s;
    }
}
