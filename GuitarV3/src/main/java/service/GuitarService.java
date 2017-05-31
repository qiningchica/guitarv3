package service;

import java.util.List;


import dao.GuitarDao;
import dao.dataAccess;
import model.Guitar;
import model.GuitarSpec;

public class GuitarService {
	
	private GuitarDao dao = dataAccess.createGuitarDao();
	//获取全部吉他
	public List<Guitar> getGuitarlist() {
		List<Guitar> guitarList = dao.guitarList();
		return guitarList;
	}
	//添加吉他
	public void addGuitar(String serialNumber, double price,
	          GuitarSpec spec,int id){
		dao.addGuitar(serialNumber, price, spec, id);
	}
	//删除
	public void deleteGuitar(int spec){
		dao.deleteGuitar(spec);
	}
}
