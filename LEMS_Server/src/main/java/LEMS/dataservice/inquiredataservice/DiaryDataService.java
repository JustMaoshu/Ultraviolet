package LEMS.dataservice.inquiredataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import LEMS.po.inquirepo.DiaryPO;

/**
 * @author 章承尧
 * 日志数据层接口
 */
public interface DiaryDataService extends Remote{
	public DiaryPO findDiary(String date) throws RemoteException;
}
