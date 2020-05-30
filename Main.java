import java.util.ArrayList;
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class Main implements de.hamster.model.HamsterProgram {public void main() {
    ArrayList<Kachel> weg = new ArrayList<Kachel>();
    ArrayList<Kachel> Knoten = new ArrayList<Kachel>();
    Hamster h = new Hamster(0,0,0,0);
    //h.schreib("Hallo");
    Controller c = new Controller(h);
    while(!h.kornDa()){
    	c.scan();
    }
}
}