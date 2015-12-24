package LEMS.po.financepo;

import java.io.Serializable;
import java.util.HashMap;

import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;

/**
 * @author 宋益明
 *
 * 价格持久化对象
 * 使用前必须初始化
 */
public class PricePO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用于记录不同快递类型价格
	 */
	private HashMap<Express, Double> expressPrice;
	/**
	 * 用于记录不同包装类型价格
	 */
	private HashMap<Packing, Double> packagePrice;

	public PricePO() {
		expressPrice = new HashMap<Express, Double>();
		packagePrice = new HashMap<Packing, Double>();
	}
	
//	static {
//		//TODO 测试用初始化
//		pricePO = new PricePO();
//		expressPrice.put(Express.economy, 0.0);
//		expressPrice.put(Express.standard, 23.0);
//		expressPrice.put(Express.special, 25.0);
//		
//		packagePrice.put(Packing.Carton, 5.0);
//		packagePrice.put(Packing.Wooden, 10.0);
//		packagePrice.put(Packing.Bag, 1.0);
//		packagePrice.put(Packing.Other, 0.0);
//	}
	
	public void pricing(Express type, double price) {
		expressPrice.put(type, price);
		
	}

	public void pricing(Packing type, double price) {
		packagePrice.put(type, price);
	}
	
	public double getPrice(Express type) {
		return expressPrice.get(type);
	}
	
	public double getPrice(Packing type) {
		return packagePrice.get(type);
	}

	public void setExpressPrice(HashMap<Express, Double> expressPrice) {
		this.expressPrice = expressPrice;
	}

	public void setPackagePrice(HashMap<Packing, Double> packagePrice) {
		this.packagePrice = packagePrice;
	}
	
	public HashMap<Express, Double> getExpressPrice() {
		return expressPrice;
	}
	
	public HashMap<Packing, Double> getPackagePrice() {
		return packagePrice;
	}
}
