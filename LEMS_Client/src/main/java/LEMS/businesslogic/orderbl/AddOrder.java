package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import LEMS.businesslogicservice.orderblservice.AddOrderService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.InquireFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.inquiredataservice.LogisticsInfoDataService;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.po.inquirepo.LogisticsInfoPO;
import LEMS.po.orderpo.OrderPO;

/**
 * @author 宋益明
 *
 * 增加订单
 */
public class AddOrder implements AddOrderService {

	/**
	 * 根据ID获得订单持久化对象
	 * 
	 * @param id 
	 * @return 订单持久化对象
	 */
	public OrderPO findOrder(String id) {
		OrderPO order = null;
		
		try {
			//获得订单信息
			order = this.getDataService().find(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	public void addOrder(String id) {
		// TODO 似乎不需要的方法，但是考虑到需求变更，就暂且放在这里了
		
	}
	
	/**
	 * 根据ID查找物流信息
	 * 
	 * @param id
	 * @return
	 */
	protected LogisticsInfoPO getLogistics(String id) {
		LogisticsInfoPO logisticsInfoPO = null;
		//获得数据库引用
		LogisticsInfoDataService logisticsInfoDataService = this.getLogisticsDataService();
		try {
			logisticsInfoPO = logisticsInfoDataService.findLogisticsInfo(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return logisticsInfoPO;
	}
	
	/**
	 * 更新订单信息
	 * 
	 * @param orderPO 目标单据持久化对象
	 */
	protected void updateOrder(OrderPO orderPO) {
		try {
			//更新信息
			this.getDataService().update(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得一个订单列表中所有订单的总质量
	 * @return 总质量
	 */
	protected double sumWeight(List<OrderPO> orders) {
		double sum = 0.0;
		
		for (OrderPO orderPO : orders) {
			sum += orderPO.getWeight();
		}
		
		return sum;
	}
	
	/**
	 * 获得数据库的引用
	 * 
	 * @return Order数据服务
	 */
	private OrderDataService getDataService() {
		
		OrderDataService orderDataService = null;
		
		try {
			//获得数据库的引用
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup("rmi://localhost:1099/data");
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			orderDataService = orderFactory.getOrderData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return orderDataService;
	}
	
	/**
	 * 获得数据库的引用
	 * 
	 * @return 物流信息数据服务
	 */
	private LogisticsInfoDataService getLogisticsDataService() {
		LogisticsInfoDataService logisticsInfoDataService = null;
		
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup("rmi://localhost:1099/data");
			InquireFactory inquireFactory = databaseFactory.getInquireFactory();
			logisticsInfoDataService = inquireFactory.getLogisticsInfo();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return logisticsInfoDataService;
	}
}
