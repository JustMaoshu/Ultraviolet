package LEMS.data.informationdata;

import java.rmi.RemoteException;




import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.dataservice.informationdataservice.InformationFindDataService;
import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.Gender;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.StaffPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;

/**
 * @author 苏琰梓
 * InformationFind包数据
 * 2015年10月26日
 */
@SuppressWarnings("serial")
public class InformationFindData extends UnicastRemoteObject implements InformationFindDataService{
	public InformationFindData() throws RemoteException {
		super();
	}
	
	//查找某一机构所有司机信息
	public ArrayList<DriverPO> findDriver(String businessid) throws RemoteException{
		ArrayList<DriverPO> drivers=new ArrayList<DriverPO>();
		DriverPO d=null;
		Connect co=new Connect();
		String sql="SELECT * FROM driver";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).substring(3,6).equals(businessid)){
					d=new DriverPO(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),Gender.transfer(result.getString(7)));
					drivers.add(d);
				}				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drivers;
	}
	
	//查找指定编号的司机信息
	public DriverPO findTheDriver(String id) throws RemoteException{
		DriverPO driver=null;
		Connect co=new Connect();
		String sql="SELECT * FROM driver";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					driver=new DriverPO(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),Gender.transfer(result.getString(7)));
					break;
				}				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	//查找某一机构所有车辆信息
	public ArrayList<VehiclePO> findVehicle(String businessid) throws RemoteException{
		ArrayList<VehiclePO> vehicles=new ArrayList<VehiclePO>();
		VehiclePO v=null;
		Connect co=new Connect();
		String sql="SELECT * FROM vehicle";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).substring(3,6).equals(businessid)){
					v=new VehiclePO(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
					vehicles.add(v);
				}				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}
	
	//查找指定编号的车辆信息
	public VehiclePO findTheVehicle(String id) throws RemoteException{
		VehiclePO vehicle=null;
		Connect co=new Connect();
		String sql="SELECT * FROM vehicle";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					vehicle=new VehiclePO(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
					break;
				}				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicle;
	}
	//查找所有机构信息
	public ArrayList<InstitutionPO> findInstitution() throws RemoteException{
		ArrayList<InstitutionPO> institutions=new ArrayList<InstitutionPO>();
		InstitutionPO i=null;
		Connect co=new Connect();
		String sql="SELECT * FROM institution";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				i=new InstitutionPO(result.getString(1),result.getString(2));
				institutions.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return institutions;
	}
	
	//查找对应id的人员信息
	public UserPO findStaff(String id) throws RemoteException{
		UserRole role=null;
		UserPO spo=null;
		Connect co=new Connect();
		String sql="SELECT * FROM user";
		ResultSet result=co.getResultSet(sql);
		try {
			while(result.next()){
				if(result.getString(1).equals(id)){
					switch(result.getString(3)){
					case "Manager":
						role=UserRole.Manager;
						break;
					case "GeneralManager":
						role=UserRole.GeneralManager;
						break;
					case "StoreManager":
						role=UserRole.StoreManager;
						break;
					case "BusinessClerk":
						role=UserRole.BusinessClerk;
						break;
					case "TransferClerk":
						role=UserRole.TransferClerk;
						break;
					case "Courier":
						role=UserRole.Courier;
						break;
					case "FinanceClerk":
						role=UserRole.FinanceClerk;
						break;
					default:
						break;
					}
					InstitutionPO ipo=new InstitutionPO(result.getString(5),result.getString(6));
					spo=new UserPO(result.getString(1),result.getString(2),role,result.getString(4),ipo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		co.closeConnection();
		return spo;
	}
}
