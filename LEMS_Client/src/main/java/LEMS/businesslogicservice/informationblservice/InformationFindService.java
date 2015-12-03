package LEMS.businesslogicservice.informationblservice;

import java.util.ArrayList;

import LEMS.vo.informationvo.StaffVO;
import LEMS.vo.uservo.UserVO;



/**
 * @author 苏琰梓
 * 查找InformationVO接口
 * 2015年10月25日
 */
public interface InformationFindService {
	/**
	 * 查找司机信息
	 */
	public void findDriverVO(long id);
	/**
	 * 查找车辆信息
	 */
	public void findVehicleVO(long id);
	/**
	 * 查找机构信息
	 */
	public void findInstitutionVO(String id);
	/**
	 * 查找人员信息
	 */
	public ArrayList<UserVO> findStaff();
}
