package guitar.model;
import java.util.Iterator;
import java.util.List;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);

    GuitarSpec whatErinLikes = 
      new GuitarSpec("FENDER", "��","6","��");
    List<Guitar> matchingGuitars = inventory.search(whatErinLikes);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars:");
      for (Iterator<Guitar> i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("  We have a " +
          spec.getBuilder() + " "  +
          spec.getType() + " :\n     "+
          "color:" +spec.getColor() + "\n     " +
          "NumStrings:" +spec.getNumStrings() + "\n     " 
          +"You can have it for only $" +
          guitar.getPrice() + "!\n  ----");
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  private static void initializeInventory(Inventory inventory) {
    inventory.addGuitar("11277", 3999.95, 
      new GuitarSpec("COLLINGS","�籴˾", "6","����"));
    inventory.addGuitar("V95693", 1499.95, 
      new GuitarSpec("FENDER", "�缪��", "6",
    		  "����"));
    inventory.addGuitar("V9512", 1549.95, 
      new GuitarSpec("FENDER", "�籴˾", "6",
    		  "����"));
    inventory.addGuitar("122784", 5495.95, 
      new GuitarSpec("MARTIN", "��ҥ����", "6",
    		  "����"));
    inventory.addGuitar("76531", 6295.95, 
      new GuitarSpec("MARTIN", "���伪��", "6",
    		  "����"));
    inventory.addGuitar("70108276", 2295.95, 
      new GuitarSpec("GIBSON", "�缪��","6",
                     "��"));
    inventory.addGuitar("82765501", 1890.95, 
      new GuitarSpec("GIBSON", "�籴˾","6",
                    "��"));
    inventory.addGuitar("77023", 6275.95, 
      new GuitarSpec("MARTIN", "�ŵ伪��","6",
                     "��"));
    inventory.addGuitar("1092", 12995.95, 
      new GuitarSpec("OLSON", "�籴˾", "12",
                     "��"));
    inventory.addGuitar("566-62", 8999.95, 
      new GuitarSpec("RYAN", "�缪��", "12",
                     "��"));
    inventory.addGuitar("6 29584", 2100.95, 
      new GuitarSpec("PRS", "�ŵ伪��", 
    		  "6", "��"));
  }
}
