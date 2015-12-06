package LEMS.businesslogicservice.storeblservice;

import java.util.ArrayList;

import LEMS.po.storepo.InboundOrderPO;
import LEMS.po.storepo.OutboundOrderPO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;

public interface StoreGenerateOrderService {

	public InboundOrderVO generateInboundOrderVO(String id);	//生成单个入库单
	
	public int generateInboundOrderPO(InboundOrderVO inboundOrderVO);
	
	public OutboundOrderVO generateOutboundOrderVO(String id);//生成单个出库单
	
	public int generateOutboundOrderPO(OutboundOrderVO outboundOrderVO);
	
	public InboundOrderVO inquireInboundOrder(String id);//查询
	
	public OutboundOrderVO inquireOutboundOrder(String id);//查询
	
	public ArrayList<InboundOrderVO> totalInboundOrder();//所有入库单
	
	public ArrayList<OutboundOrderVO> totalOutboundOrder();//所有出库单

}
