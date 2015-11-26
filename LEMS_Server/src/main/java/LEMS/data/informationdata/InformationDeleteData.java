package LEMS.data.informationdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LEMS.data.Connect;
import LEMS.dataservice.informationdataservice.InformationDeleteDataService;

/**
 * @author 苏琰梓
 * InformationDelete包数据
 * 2015年10月26日
 */
@SuppressWarnings("serial")
public class InformationDeleteData extends UnicastRemoteObject implements InformationDeleteDataService{
	public InformationDeleteData() throws RemoteException {
		super();
	}
	public void deleteDriverPO(long id) throws RemoteException{
		
	}
	public void deleteVehiclePO(long id) throws RemoteException{
		
	}
	public void deleteInstitutionPO(String id) throws RemoteException{
		
	}
	public void deleteStaff(String id) throws RemoteException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="DELETE FROM user WHERE id = ?";
		try {
			Class.forName(Connect.DBDRIVER);
			conn = DriverManager.getConnection(Connect.DBURL, Connect.DBUSER, Connect.DBPASS);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteAccountPO(String name) throws RemoteException{
		
	}	
}
