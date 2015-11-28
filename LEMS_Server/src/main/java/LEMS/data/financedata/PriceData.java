package LEMS.data.financedata;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import LEMS.data.Connect;
import LEMS.dataservice.financedataservice.PriceDataService;
import LEMS.po.financepo.PricePO;
import LEMS.po.orderpo.Express;
import LEMS.po.orderpo.Packing;

public class PriceData implements PriceDataService {

	private PricePO pricePO;

	private Connect connect;

	public PricePO getPrice() throws RemoteException {
		// 创建并初始化快递类型价格表
		Map<String, Double> expressPrice = new HashMap<String, Double>();
		expressPrice.put("economy", 0.0);
		expressPrice.put("standard", 0.0);
		expressPrice.put("special", 0.0);
		
		//创建并初始化包装类型价格表
		Map<String, Double> packagePrice = new HashMap<String, Double>();
		packagePrice.put("carton", 0.0);
		packagePrice.put("wooden", 0.0);
		packagePrice.put("bag", 0.0);
		packagePrice.put("other", 0.0);
		
		String sql = "SELECT type, price FROM price";

		connect = new Connect();
		ResultSet result = null;
		result = connect.getResultSet(sql);
		
		try {
			//TODO 价格类型判断
			while (result.next()) {
				if (expressPrice.containsKey(result.getString(1))) {
					expressPrice.put(result.getString(1), result.getDouble(2));
				} else if (packagePrice.containsKey(result.getString(1))) {
					packagePrice.put(result.getString(1), result.getDouble(2));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connect.closeConnection();
		return pricePO;
	}

	public void pricing(PricePO price) throws RemoteException {
		
		PreparedStatement pstmt = null;

		connect = new Connect();
		String sql = "INSERT INTO price(type, price) VALUES (?, ?)";
		this.makeEmpty();
		try {
			pstmt = connect.getPreparedStatement(sql);

			// 存储快递类型“经济”的价格
			pstmt.setString(1, "economy");
			pstmt.setDouble(2, PricePO.getPrice(Express.economy));
			pstmt.executeUpdate();
			// 存储快递类型“普通”的价格
			pstmt.setString(1, "standard");
			pstmt.setDouble(2, PricePO.getPrice(Express.standard));
			pstmt.executeUpdate();
			// 存储快递类型“特快”的价格
			pstmt.setString(1, "special");
			pstmt.setDouble(2, PricePO.getPrice(Express.special));
			pstmt.executeUpdate();
			
			//存储包装类型“纸箱”的价格
			pstmt.setString(1, "Carton");
			pstmt.setDouble(2, PricePO.getPrice(Packing.Carton));
			pstmt.executeUpdate();
			//存储包装类型“木箱”的价格
			pstmt.setString(1, "Wooden");
			pstmt.setDouble(2, PricePO.getPrice(Packing.Wooden));
			pstmt.executeUpdate();
			//存储包装类型“快递袋”的价格
			pstmt.setString(1, "Bag");
			pstmt.setDouble(2, PricePO.getPrice(Packing.Bag));
			pstmt.executeUpdate();
			//存储包装类型“其它”的价格
			pstmt.setString(1, "Other");
			pstmt.setDouble(2, PricePO.getPrice(Packing.Other));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		connect.closeConnection();
	}
	public void makeEmpty() throws RemoteException{
		PreparedStatement pstmt = null;

		connect = new Connect();
		String sql = "DELETE FROM price";

		try {
			pstmt = connect.getPreparedStatement(sql);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		connect.closeConnection();
	}
//	public static void main(String[] args) {
//		PriceData priceData = new PriceData();
//		
//		PricePO pricePO=null;
//		try {
//			pricePO = priceData.getPrice();
//		} catch (RemoteException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		System.out.println(pricePO.getPrice(Express.economy));
//		System.out.println(pricePO.getPrice(Express.standard));
//		System.out.println(pricePO.getPrice(Express.special));
//		
//		System.out.println(pricePO.getPrice(Packing.Bag));
//		System.out.println(pricePO.getPrice(Packing.Carton));
//		System.out.println(pricePO.getPrice(Packing.Wooden));
//		System.out.println(pricePO.getPrice(Packing.Other));
//		
//		
//		try {
//			
//			priceData.pricing(pricePO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	}
	
}
