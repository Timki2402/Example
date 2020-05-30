import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Kachel {
	//Attribute
   	private int spalte;
   	private int reihe;
   
   	//Konstruktor
   	Kachel(int spalte, int reihe){
   		this.spalte = spalte;
   		this.reihe = reihe;
   	}
   	// get- und setMethoden
   	public int getSpalte(){
   		return this.spalte;
   	}
   	public int getReihe(){
   		return this.reihe;
   	}
   	/*	Die Methode gibt true zurück, falls die parameter spalte und zeile mit  
   	*	dem Objekt übereinstimmen.
   	*
   	*/
   	public boolean vergleicheKoordinaten(int spalte, int reihe){
   		if(this.spalte == spalte && this.reihe==reihe){
   			return true;
   		}
   		return false;
   	}
	public String toString(){
		String s = Integer.toString(spalte);
		s=s.concat(Integer.toString(reihe));
		return s;
	}
}
