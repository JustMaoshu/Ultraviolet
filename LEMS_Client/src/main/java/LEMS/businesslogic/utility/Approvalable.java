package LEMS.businesslogic.utility;

import LEMS.po.financepo.DocumentState;

/**
 * @author 宋益明
 * 
 * 可审批
 * 实现此接口的类生成的单据可以审批
 */
public interface Approvalable {
	
	/**
	 * 审批单据
	 * 
	 * @param id 单据ID
	 * @param state 审批后状态
	 */
	public void approval(String id, DocumentState state);
}
