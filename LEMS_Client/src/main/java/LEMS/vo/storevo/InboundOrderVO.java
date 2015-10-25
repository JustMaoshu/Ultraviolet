package LEMS.vo.storevo;

import java.util.ArrayList;

import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.vo.financevo.PayBillVO;
import LEMS.vo.ordervo.IncomeBillVO;

public class InboundOrderVO {
	long id;
	String inDate;
	Destination destination;
	Area area;
	int row;		//排
	int stand;		//架
	int position;	//位
	
	public InboundOrderVO(long identity,String d,Destination des,Area ar,int r,int s,int pos){
		id=identity;
		inDate=d;
		destination=des;
		area=ar;
		row=r;
		stand=s;
		position=pos;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
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
	
	
}
