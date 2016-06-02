package guitar.DAO;

//import java.util.List;
import guitar.model.Inventory;

public class SearchService {
	private IGuitarDAO guitarDAO;
	
	
	public SearchService(String WORKS,IGuitarDAO guitarDAO) {
        this(guitarDAO);
    }
    public SearchService(IGuitarDAO guitarDAO) {
		this.guitarDAO=guitarDAO;
		
		
	}
    
    
    public Inventory getGuitars(){
    	return guitarDAO.getGuitars();
	}
    
    
    
    
	
}
