package service;

import java.util.List;


import dao.GuitarDao;
import dao.dataAccess;
import model.Guitar;
import model.GuitarSpec;

public class GuitarService {
	
	private GuitarDao dao = dataAccess.createGuitarDao();
	//��ȡȫ������
	public List<Guitar> getGuitarlist() {
		List<Guitar> guitarList = dao.guitarList();
		return guitarList;
	}
	//��Ӽ���
	public void addGuitar(String serialNumber, double price,
	          GuitarSpec spec,int id){
		dao.addGuitar(serialNumber, price, spec, id);
	}
	//ɾ��
	public void deleteGuitar(int spec){
		dao.deleteGuitar(spec);
	}
}
