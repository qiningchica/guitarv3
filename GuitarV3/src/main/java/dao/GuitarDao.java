package dao;

import java.util.List;


import model.Guitar;
import model.GuitarSpec;

public interface GuitarDao {
	 public Guitar getGuitar(String serialNumber);
	 public List<Guitar> guitarList();
	 public void addGuitar(String serialNumber, double price,GuitarSpec spec,int id);
	 public void deleteGuitar(int spec);
}
