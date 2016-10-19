package Task3_Market;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String productName;
	private double productPrice;
	
	public Product() {
		
	}
	
	public Product(String productName, double productPrice) {
		this.setProductName(productName);
		this.setProductPrice(productPrice);
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
