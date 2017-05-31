package service;

import java.util.List;


import sqliteDao.sqliteDao;
import dao.GuitarDao;
import dao.dataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import model.Builder;
import model.Type;
import model.Wood;
import model.Guitar;
import model.GuitarSpec;
import util.SqliteJDBC;

public class Inventory {
	
	private GuitarDao dao = dataAccess.createGuitarDao();
	public List search(GuitarSpec searchSpec) {
	    List matchingGuitars = new LinkedList();
	    List<Guitar> guitars = dao.guitarList();
	    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      if (guitar.getSpec().matches(searchSpec))
	        matchingGuitars.add(guitar);
	    }
	    return matchingGuitars;
	  }
}