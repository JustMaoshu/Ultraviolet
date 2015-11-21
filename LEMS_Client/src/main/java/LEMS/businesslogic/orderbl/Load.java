package LEMS.businesslogic.orderbl;

import java.rmi.Naming;
import java.util.ArrayList;

import LEMS.businesslogicservice.orderblservice.LoadService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.ordervo.LoadVO;

/**
 * @author 宋益明
 * 
 * 装运管理任务
 */
public class Load implements LoadService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	public Load() {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
	}
	
	public void addOrder(String id) {
		//TODO 根据ID获取订单持久化对象
		orders.add(new OrderPO(id));
	}

	public void createLoadNote(LoadVO loadInfo) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}
}
