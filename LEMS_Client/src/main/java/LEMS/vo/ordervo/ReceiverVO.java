package LEMS.vo.ordervo;

/**
 * @author 宋益明
 *
 * 收件人值对象
 */
public class ReceiverVO {
	/**
	 * 收件人姓名
	 */
	private String name;
	/**
	 * 收件人电话
	 */
	private String phone;
	/**
	 * 收件人地址
	 */
	private String address;
	
	public ReceiverVO(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
}
