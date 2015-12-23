package LEMS.dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.po.orderpo.IncomeBillPO;

public interface ReceiptRecordDataService extends Remote {
	public IncomeBillPO find(String id) throws RemoteException;
	
	public void insert(IncomeBillPO incomeBillPO) throws RemoteException;
	
	public void update(IncomeBillPO incomeBillPO) throws RemoteException;
	
	public void delete(String id) throws RemoteException;
	
	/**
	 * 在数据库中查找指定机构最新的记录，并直接生成ID
	 * @param date 日期
	 * @param institution 机构
	 * 
	 * @return 记录ID
	 */
	public String createID(String institution, String date) throws RemoteException;
	
	/**
	 * 根据揽件员及日期获得所有订单
	 * 
	 * @param collector 揽件员ID
	 * @param date 日期
	 * @return 所有订单编号（String）
	 * @throws RemoteException 连接异常，发现异常后，抛出到逻辑层
	 */
	public ArrayList<String> getOrders(String collector, String date) throws RemoteException;
}
