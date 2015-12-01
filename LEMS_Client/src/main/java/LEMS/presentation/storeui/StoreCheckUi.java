package LEMS.presentation.storeui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;

/**
 * 
 * @author 周梦佳 
 * 4库存盘点（盘点的是当天的库存快照，包括当天的各区快递的信息（快递编号、入库日期、目的地、区号、排号、架号、位号） 。
 *         要求可以导出Excel。 盘点时，系统自动根据当前盘点时间生成一个截止点，这个点就是批次（日期）批号（序号），
 *         在这个截点之后做的出入库是不计入盘点的。
 */
public class StoreCheckUi extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int LOCATION_X=440;
	private static final int LOCATION_Y=37;

	private MainFrame mainFrame;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	

	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 19);// 其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);// 按钮字体格式

	public StoreCheckUi(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 设置输入框不可编辑
		// this.setTestState(false);
		// 添加事件监听器
		// this.addListener();

	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("库存盘点");
		exit = new JButton("返回");
		OK = new JButton("开始盘点");
		// ImageIcon icon = new ImageIcon("确认.png");
		// OK.setIcon(icon);

		cancel = new JButton("取消盘点");
	
	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(LOCATION_X, LOCATION_Y, 230, 39);
		OK.setBounds(LOCATION_X-80, LOCATION_Y+65, 120, 40);
		cancel.setBounds(LOCATION_X+65, LOCATION_Y+65, 120, 40);
		exit.setBounds(90, 60, 100, 40);
		
		title.setFont(fnt1);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);

		this.add(title);
		this.add(OK);
		this.add(cancel);
		this.add(exit);
		
		String[] columnNames = { "快递单号", "入库日期", "目的地", "存储区域", "架号", "排号", "位号" };
		int[] list = { 40, 118, 14, 30, 20, 85, 170, 841, 480 };
		// list里面参数分别为需要的列数，每一列的宽度,设置第一行字体大小,设置第一行行宽,
		// * 剩下行的行宽,表格setbounds（list[5],list[6], list[7], list[8]）
		// *
		Table table = new Table();
		add(table.drawTable(columnNames, list));

	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTestState(boolean state) {

		OK.setEnabled(state);
		cancel.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {

	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 返回按钮的具体实现
			}
		});

		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO 确定按钮的具体实现

			}
		});
		cancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 清空输入框
				empty();
				// 设置输入框不可编辑
				setTestState(false);
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		this.repaint();
	}

}
