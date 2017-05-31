import java.util.Iterator;


import java.util.List;

import model.Builder;
import model.Guitar;
import model.GuitarSpec;
import model.Type;
import model.Wood;
import service.GuitarService;
import service.Inventory;
import sqliteDao.sqliteDao;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
	 sqliteDao sqlitedao = new sqliteDao();
	 Inventory inventory=new Inventory();
	 initializesqliteDao(sqlitedao);

    GuitarSpec whatErinLikes = 
      new GuitarSpec(Builder.FENDER, "Stratocastor", 
                     Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6);
    List matchingGuitars = inventory.search(whatErinLikes);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars:");
      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("  We have a " +
          spec.getBuilder() + " " + spec.getModel() + " " +
          spec.getType() + " guitar:\n     " +
          spec.getBackWood() + " back and sides,\n     " +
          spec.getTopWood() + " top.\n  You can have it for only $" +
          guitar.getPrice() + "!\n  ----");
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }


  private static void initializesqliteDao(sqliteDao sqlitedao) {
	  sqlitedao.addGuitar("11277", 3999.95, 
	      new GuitarSpec(Builder.COLLINGS, "CJ", Type.ACOUSTIC,
	                     Wood.INDIAN_ROSEWOOD, Wood.SITKA, 6),1);
	  sqlitedao.addGuitar("V95693", 1499.95, 
	      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC,
	                     Wood.ALDER, Wood.ALDER, 6),2);
	  sqlitedao.addGuitar("V9512", 1549.95, 
	      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC,
	                     Wood.ALDER, Wood.ALDER, 6),3);
	  sqlitedao.addGuitar("122784", 5495.95, 
	      new GuitarSpec(Builder.MARTIN, "D-18", Type.ACOUSTIC,
	                     Wood.MAHOGANY, Wood.ADIRONDACK, 6),4);
	  sqlitedao.addGuitar("76531", 6295.95, 
	      new GuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC,
	                     Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK, 6),5);
	  sqlitedao.addGuitar("70108276", 2295.95, 
	      new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC,
	                     Wood.MAHOGANY, Wood.MAHOGANY, 6),6);
	  sqlitedao.addGuitar("82765501", 1890.95, 
	      new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", Type.ELECTRIC,
	                     Wood.MAHOGANY, Wood.MAHOGANY, 6),7);
	  sqlitedao.addGuitar("77023", 6275.95, 
	      new GuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC,
	                     Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK, 6),8);
	  sqlitedao.addGuitar("1092", 12995.95, 
	      new GuitarSpec(Builder.OLSON, "SJ", Type.ACOUSTIC,
	                     Wood.INDIAN_ROSEWOOD, Wood.CEDAR, 12),9);
	  sqlitedao.addGuitar("566-62", 8999.95, 
	      new GuitarSpec(Builder.RYAN, "Cathedral", Type.ACOUSTIC, 
	                     Wood.COCOBOLO, Wood.CEDAR, 12),10);
	  sqlitedao.addGuitar("6 29584", 2100.95, 
	      new GuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC, 
	                      Wood.MAHOGANY, Wood.MAPLE, 6),11);
	  }
}
