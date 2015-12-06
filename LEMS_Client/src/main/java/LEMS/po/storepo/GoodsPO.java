package LEMS.po.storepo;
//更新过
import java.io.Serializable;

import LEMS.po.orderpo.TransportType;
/**
 * @author 周梦佳
 * 货物持久化对象
 */

@SuppressWarnings("serial")
public class GoodsPO implements Serializable {
	/**
	 * 快递单号
	 */
	String id;
/**
 * 入库日期
 */
	String inDate;
	/**
	 * 出库日期
	 */
	String outDate;
	/**
	 * 目的地
	 */
	Destination destination;
		/**
	 * 存放区域
	 */
	Area area;
	/**
	 * 排
	 */
	int row;		
	/**
	 * 架
	 */
	int stand;	
	/**
	 * 位
	 */
	int position;	
	/**
	 * 装运形式
	 */
	TransportType transportType;
	/**
	 * 中转单或汽运编号
	 */
	String transferNum;
	public GoodsPO(String i,String iDate,String oDate,Destination des,Area ar,int r,int s,int p,TransportType tt,String tn){
		id=i;
		inDate=iDate;
		outDate=oDate;
		destination=des;
		area=ar;
		row=r;
		stand=s;
		position=p;
		transportType=tt;
		transferNum=tn;
	}
	
	public GoodsPO(String i,Area ar,int r,int s,int p){
		id=i;
		area=ar;
		row=r;
		stand=s;
		position=p;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getStand() {
		return stand;
	}

	public void setStand(int stand) {
		this.stand = stand;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public TransportType getTransportType() {
		return transportType;
	}

	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}

	public String getTransferNum() {
		return transferNum;
	}

	public void setTransferNum(String transferNum) {
		this.transferNum = transferNum;
	}
	
	
}
