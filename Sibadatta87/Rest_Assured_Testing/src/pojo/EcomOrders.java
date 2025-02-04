package pojo;

import java.util.List;

public class EcomOrders {
	
	public List<EcomOrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<EcomOrderDetails> orders) {
		this.orders = orders;
	}

	List<EcomOrderDetails> orders;
}
