import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Map{
	private Knoten startKnoten;
	private Knoten aktuellerKnoten;
   
   	public Map(Knoten startKnoten){
    	this.startKnoten = startKnoten;
    	this.aktuellerKnoten = startKnoten;
    }
    public boolean addKnoten(Knoten knoten){
    	if(aktuellerKnoten.addKnoten(knoten)){
    		return true;
    	}
    	return false;
    }
    public void setAktuellerKnoten(Knoten knoten){
    	this.aktuellerKnoten = knoten;
    }
    public Knoten getAktuellerKnoten(){
    	return this.aktuellerKnoten;
    }
    public void knotenZurueck(){
    	if(this.aktuellerKnoten.getVorgaenger() != null){
    		this.aktuellerKnoten = this.aktuellerKnoten.getVorgaenger();
    	}
    }
    public Knoten getStartKnoten(){
    	return this.startKnoten;
    }
}
