package LEMS.businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.businesslogicservice.orderblservice.ReceiptService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.orderdataservice.ReceiptDataService;
import LEMS.po.orderpo.ArrivalNotePO;
import LEMS.po.orderpo.OrderPO;
import LEMS.vo.inquirevo.LogisticsInfoVO;
import LEMS.vo.ordervo.ArrivalVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 宋益明
 * 
 * 接收任务
 */
public class Receipt extends AddOrder implements ReceiptService {

	/**
	 * 订单列表
	 */
	private ArrayList<OrderPO> orders;
	
	/**
	 * 营业厅业务员
	 */
	private UserVO user;
	
	/**
	 * 到达单值对象
	 */
	private ArrivalVO arrivalVO;
	
	public Receipt(UserVO user, ArrivalVO arrivalVO) {
		//新建订单列表
		orders = new ArrayList<OrderPO>();
		
		this.user = user;
		this.arrivalVO = arrivalVO;
	}
	
	public void addOrder(String id) {
		//获得物流信息
		LogisticsInfoVO logistics = getLogistics(id);
		System.out.println(logistics.getId());
		//更新物流信息
		logistics.setTrace("到达" + user.getInstitution().getLocation() + "营业厅");
		logistics.setInstitution(user.getInstitution().getLocation());
		updateLogistics(logistics);
		
		//添加订单到订单列表中
		orders.add(findOrder(id));
		System.out.println(findOrder(id).getAmount());
		System.out.println(orders);
	}

	public void createArrivalNote() {
		// TODO 添加货物状态
		ArrivalNotePO arrivalNotePO = new ArrivalNotePO();
		
		arrivalNotePO.setDate(arrivalVO.getDate());
		arrivalNotePO.setDeparture(arrivalVO.getDepature());
		arrivalNotePO.setOrders(orders);
		arrivalNotePO.setId(createId());
		
		try {
			getDataService().insert(arrivalNotePO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成到达单ID
	 */
	private String createId() {
		//TODO 
		return null;
	}
	
	private ReceiptDataService getDataService() {
		
		ReceiptDataService receiptDataService = null;
		
		try {
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			OrderFactory orderFactory = databaseFactory.getOrderFactory();
			receiptDataService = orderFactory.getReceiptData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return receiptDataService;
	}
}
