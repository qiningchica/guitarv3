package action;

import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Builder;
import model.Guitar;
import model.GuitarSpec;
import model.Type;
import model.Wood;
import service.Inventory;

public class searchGuitar extends ActionSupport {
	private String serialNumber, builder, model, type, backWood, topWood;
	private double price;
	private int numStrings;

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

	public String search() {
		Inventory inventory = new Inventory();
		GuitarSpec searchSpec = new GuitarSpec(Builder.valueOf(builder.toUpperCase()), model,
				Type.valueOf(type.toUpperCase()), Wood.valueOf(backWood.toUpperCase()),
				Wood.valueOf(topWood.toUpperCase()), numStrings);
		List<Guitar> guitar = inventory.search(searchSpec);
		if (guitar.size() != 0) {
			System.out.println(guitar);
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("List", guitar);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
