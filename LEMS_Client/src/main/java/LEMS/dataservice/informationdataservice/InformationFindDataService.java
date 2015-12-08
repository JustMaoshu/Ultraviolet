package LEMS.dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;







import java.util.ArrayList;

import LEMS.po.informationpo.DriverPO;
import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.informationpo.VehiclePO;
import LEMS.po.userpo.UserPO;
import LEMS.po.userpo.UserRole;
import LEMS.vo.informationvo.DriverVO;


/**
 * @author 苏琰梓
 * 查找Information信息数据层接口
 * 2015年10月26日
 */
public interface InformationFindDataService extends Remote{
	public ArrayList<DriverPO> findDriver(String businessid) throws RemoteException;
	public DriverPO findTheDriver(String id) throws RemoteException;
	public ArrayList<VehiclePO> findVehicle(String businessid) throws RemoteException;
	public ArrayList<InstitutionPO> findInstitution() throws RemoteException;
	public UserPO findStaff(String i) throws RemoteException;
}
