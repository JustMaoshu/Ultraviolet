package LEMS.dataservice;

import java.rmi.Remote;


import java.rmi.RemoteException;

import LEMS.dataservice.informationdataservice.InformationInsertDataService;
import LEMS.dataservice.inquiredataservice.CostBenefitListDataService;
import LEMS.dataservice.inquiredataservice.DiaryDataService;
import LEMS.dataservice.userdataservice.UserDataService;

public interface DatabaseFactory extends Remote{
	public DiaryDataService getDiaryData() throws RemoteException;
	public CostBenefitListDataService getCostBenefitList() throws RemoteException;
	public InformationInsertDataService getInformationInsertData() throws RemoteException;
	public UserDataService getUserData() throws RemoteException;
}
