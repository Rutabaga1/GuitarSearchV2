package guitar.model;
import java.util.Iterator;
import java.util.List;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);

    GuitarSpec whatErinLikes = 
      new GuitarSpec("FENDER", "电","6","蓝");
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
      new GuitarSpec("COLLINGS","电贝司", "6","蓝白"));
    inventory.addGuitar("V95693", 1499.95, 
      new GuitarSpec("FENDER", "电吉他", "6",
    		  "蓝白"));
    inventory.addGuitar("V9512", 1549.95, 
      new GuitarSpec("FENDER", "电贝司", "6",
    		  "蓝白"));
    inventory.addGuitar("122784", 5495.95, 
      new GuitarSpec("MARTIN", "民谣吉他", "6",
    		  "蓝白"));
    inventory.addGuitar("76531", 6295.95, 
      new GuitarSpec("MARTIN", "电箱吉他", "6",
    		  "蓝白"));
    inventory.addGuitar("70108276", 2295.95, 
      new GuitarSpec("GIBSON", "电吉他","6",
                     "黑"));
    inventory.addGuitar("82765501", 1890.95, 
      new GuitarSpec("GIBSON", "电贝司","6",
                    "棕"));
    inventory.addGuitar("77023", 6275.95, 
      new GuitarSpec("MARTIN", "古典吉他","6",
                     "红"));
    inventory.addGuitar("1092", 12995.95, 
      new GuitarSpec("OLSON", "电贝司", "12",
                     "红"));
    inventory.addGuitar("566-62", 8999.95, 
      new GuitarSpec("RYAN", "电吉他", "12",
                     "黑"));
    inventory.addGuitar("6 29584", 2100.95, 
      new GuitarSpec("PRS", "古典吉他", 
    		  "6", "黄"));
  }
}
