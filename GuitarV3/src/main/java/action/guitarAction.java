package action;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Builder;
import model.Type;
import model.Wood;
import model.Guitar;
import model.GuitarSpec;
import service.Inventory;
import service.GuitarService;

public class guitarAction extends ActionSupport{
	private String serialNumber, builder, model, type, backWood, topWood;
	private double price;
	private int numStrings;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumStrings() {
		return numStrings;
	}
	public void setNumStrings(int numStrings) {
		this.numStrings = numStrings;
	}
	//获取所有吉他
	public String getGuitarlist(){	 
		GuitarService getGuitarListService = new GuitarService();
		List<Guitar> guitarList = getGuitarListService.getGuitarlist();
		HttpServletRequest request = ServletActionContext.getRequest(); 
		request.setAttribute("List",guitarList);
		return SUCCESS;
	}
	//添加吉他
	public String addGuitar(){
		GuitarSpec Spec = new GuitarSpec(Builder.valueOf(builder.toUpperCase()),model,Type.valueOf(type.toUpperCase()),Wood.valueOf(backWood.toUpperCase()),Wood.valueOf(topWood.toUpperCase()),numStrings);
		System.out.println(builder);
		GuitarService guitarService = new GuitarService();
		guitarService.addGuitar(serialNumber, price, Spec, id);
		return SUCCESS;
	}
	//删除吉他
	public String deleteGuitar(){
		GuitarService guitarService = new GuitarService();
		guitarService.deleteGuitar(id);
		return SUCCESS;
	}
}
