package model;

public class Guitar {
	private String serialNumber;
	private double price;
	GuitarSpec spec;
	private int id;

	public Guitar(String serialNumber, double price, GuitarSpec spec, int id) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float newPrice) {
		this.price = newPrice;
	}

	public GuitarSpec getSpec() {
		return spec;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSpec(GuitarSpec spec) {
		this.spec = spec;
	}
}
