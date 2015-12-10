package LEMS.presentation.informationui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LEMS.businesslogic.informationbl.InformationAdd;
import LEMS.businesslogic.informationbl.InformationDelete;
import LEMS.businesslogic.informationbl.InformationFind;
import LEMS.presentation.LoginUi;
import LEMS.presentation.MainFrame;
import LEMS.presentation.Table;
import LEMS.presentation.storeui.DateChooser;
import LEMS.presentation.userui.ManagerUi;
import LEMS.vo.informationvo.VehicleVO;
import LEMS.vo.uservo.UserVO;

/**
 * @author 周梦佳 车辆信息管理界面
 */
public class VehicleManageUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int LOCATION_LABEL_X = 100;
	private static final int LOCATION_LABEL_Y = 130;
	private static final int LOCATION_TEXT_X = 200;
	private static final int LOCATION_TEXT_Y = 135;
	private static final int BOUND_X = 130;
	private static final int BOUND_Y = 30;

	private MainFrame mainFrame;
	private Table table;
	private JLabel title;
	private JButton exit;
	private JButton OK;
	private JButton cancel;
	private JButton add;
	private JButton delete;
	private JButton update;
	private JButton inquire;
	private JButton look;
	private JLabel labelId;
	private JLabel labelNum;
	private JLabel labelTime;
	private JLabel picture;
	private JLabel type;
	private JTextField textId;
	private JTextField textNum;
	private JTextField textTime;
	private JComboBox<String> comboBox;
	
	private Font fnt1 = new Font("Courier", Font.BOLD, 26);// 标题字体格式
	private Font fnt = new Font("Courier", Font.PLAIN, 15);// 其余字体格式
	private Font fnt2 = new Font("宋体", Font.BOLD, 16);// 按钮字体格式
	private ImageIcon image;
	private boolean isAdd;
	private boolean isUpdate;
	private UserVO uvo;
	public VehicleManageUi(final MainFrame mainFrame, UserVO userVO) {
		this.mainFrame = mainFrame;
		uvo=userVO;
		this.setLayout(null);
		this.setBounds(0, 0, MainFrame.JFRAME_WIDTH, MainFrame.JFRAME_HEIGHT);
		// 初始化
		this.init();
		// 初始化组件
		this.initComponents();
		// 设置输入框不可编辑
		this.setTestState(false);
		// 添加事件监听器
		this.addListener();

	}

	/**
	 * 初始化
	 */
	private void init() {
		title = new JLabel("车辆信息管理");
		exit = new JButton("返回");
		OK = new JButton("确定");
		cancel = new JButton("取消");
		look=new JButton("查看");
		look.setLocation(289, 384);
		look.setSize(69, 50);
		add=new JButton("新增");
		delete=new JButton("删除");
		update=new JButton("修改");
		inquire=new JButton("查找");
		labelId = new JLabel("车辆代号:");
		labelNum = new JLabel("车牌号:");
		labelTime = new JLabel("服役状态：");
		type=new JLabel("车辆型号: ");			
		
		textId = new JTextField();
		textNum = new JTextField();
		textTime = new JTextField();
		comboBox=new JComboBox<String>();
		comboBox.addItem("type1");
		comboBox.addItem("type2");
		comboBox.setSelectedItem(null);
		image = new ImageIcon("init.jpg");
		picture = new JLabel(image);
		

	}

	/**
	 * 初始化各组件
	 */
	private void initComponents() {

		title.setBounds(420, 27, 230, 39);
		labelId.setBounds(LOCATION_LABEL_X, LOCATION_LABEL_Y, BOUND_X, BOUND_Y);
		labelNum.setBounds(107, 188, BOUND_X, BOUND_Y);
		labelTime.setBounds(100, 244, BOUND_X, BOUND_Y);
		textId.setBounds(LOCATION_TEXT_X, LOCATION_TEXT_Y, BOUND_X, BOUND_Y - 6);
		textNum.setBounds(200, 193, BOUND_X, BOUND_Y - 6);
		textTime.setBounds(200, 249, BOUND_X, BOUND_Y - 6);
		OK.setBounds(LOCATION_LABEL_X + 5, LOCATION_LABEL_Y + 355, BOUND_X - 40, BOUND_Y + 10);
		cancel.setBounds(LOCATION_LABEL_X + 125, LOCATION_LABEL_Y + 355, BOUND_X - 40, BOUND_Y + 10);
		exit.setBounds(80, 50, 100, 40);
		add.setBounds(150, 590, 120, 40);
		delete.setBounds(350, 590, 120,40);
		update.setBounds(550, 590, 120, 40);
		inquire.setBounds(750, 590, 120, 40);
		comboBox.setLocation(200, 299);
		comboBox.setSize(130, 24);		
		type.setLocation(100, 298);
		type.setSize(90, 30);
		picture.setLocation(100, 338);
		picture.setSize(182, 132);


		title.setFont(fnt1);
		labelId.setFont(fnt);
		labelNum.setFont(fnt);
		labelTime.setFont(fnt);
		cancel.setFont(fnt2);
		OK.setFont(fnt2);
		exit.setFont(fnt2);
		textId.setFont(fnt);
		textNum.setFont(fnt);
		textTime.setFont(fnt);
		type.setFont(fnt);
		add.setFont(fnt2);
		delete.setFont(fnt2);
		update.setFont(fnt2);
		inquire.setFont(fnt2);
		
		this.add(title);
		this.add(labelId);
		this.add(labelNum);
		this.add(labelTime);
		this.add(picture);
		this.add(textId);
		this.add(textNum);
		this.add(textTime);
		this.add(OK);
		this.add(cancel);
		this.add(look);
		this.add(exit);
		this.add(add);
		this.add(delete);
		this.add(update);
		this.add(inquire);
		this.add(comboBox);
		this.add(type);
		
		String[] columnNames = { "车辆代号", "车牌号", "服役时间" };
		int[] list = { 40, 170, 14, 30, 20, 400, 110, 528, 450 };

		table = new Table();
		add(table.drawTable(columnNames, list));
		
		InformationFind find=new InformationFind();
		ArrayList<VehicleVO> vehicles=find.findVehicle(uvo.getId().substring(6, 9));
		for(int i=0;i<vehicles.size();i++){
			table.setValueAt(i, 0, vehicles.get(i).getId());
			table.setValueAt(i, 1, vehicles.get(i).getPlateNumber());
			table.setValueAt(i, 2, vehicles.get(i).getWorkTime());
		}
	}

	/**
	 * 设置输入框状态
	 * 
	 * @param state
	 *            输入框状态（是否可编辑）
	 */
	private void setTestState(boolean state) {
		comboBox.setEnabled(state);
		textId.setEditable(state);
		textNum.setEditable(state);
		textTime.setEditable(state);
		OK.setEnabled(state);
		cancel.setEnabled(state);
		look.setEnabled(state);
	}

	/**
	 * 清空输入框
	 */
	private void empty() {
		textId.setText(null);
		textNum.setText(null);
		textTime.setText(null);
		comboBox.setSelectedItem(null);
		image = new ImageIcon("init.jpg");
		picture.setIcon(image);
	}

	/**
	 * 为按钮添加事件监听器
	 */
	private void addListener() {
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				isAdd=true;
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {				
				int currentLine = table.table.getSelectedRow();
				//未选中任何一行
				if (currentLine == -1) {
					JOptionPane.showMessageDialog(VehicleManageUi.this, "请选择要删除的行!");
				}
				else {
					int i = table.numOfEmpty();	
					table.remove(i);
				}				
			}
		});
		
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setTestState(true);
				isUpdate=true;
				
				//将被选中车辆的详细信息显示出来
				int currentLine=table.table.getSelectedRow();
				InformationFind find=new InformationFind();
				VehicleVO vehicle=find.findTheVehicle(table.getValueAt(currentLine).get(0));
				//TODO 方法太传奇……
				textId.setText(vehicle.getId());
				textNum.setText(vehicle.getPlateNumber());
				textTime.setText(vehicle.getWorkTime());
				comboBox.setSelectedItem(vehicle.getImage());
				image=new ImageIcon(vehicle.getImage()+".jpg");
				picture.setIcon(image);
			}
		});
		
		inquire.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String inputValue=JOptionPane.showInputDialog(VehicleManageUi.this,"请输入车辆代号：");
				int i = table.numOfEmpty();
				for(i=i-1;i>=0;i--){
					if(table.table.getValueAt(i, 0).equals(inputValue)){
						break;
					}
				}
				if(i>=0){
					table.table.setRowSelectionInterval(i, i);
				}
				else{
					if(inputValue!=null){
						JOptionPane.showMessageDialog(VehicleManageUi.this, "未找到该车辆");
					}
				}
			}
		});
		
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginUi loginUi=new LoginUi(mainFrame);
				mainFrame.setContentPane(loginUi);
			}
		});

		OK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(isAdd){
					// 获得第几行为空
					int i = table.numOfEmpty();
					// 确定按钮的具体实现
					table.setValueAt(i, 0, textId.getText());
					table.setValueAt(i, 1, textNum.getText());
					table.setValueAt(i, 2, textTime.getText());
					
					//存进数据库中
					VehicleVO vvo=new VehicleVO(textId.getText(),textNum.getText(),textTime.getText(),(String)comboBox.getSelectedItem());
					InformationAdd add=new InformationAdd();
					add.addVehicle(vvo);
					
					// 清空输入框
					empty();
					picture=new JLabel();
					// 使输入框不可编辑
					setTestState(false);
					isAdd=false;
				}
				
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
		
		look.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				image = new ImageIcon((String)comboBox.getSelectedItem()+".jpg");
				picture.setIcon(image);				
			}
		});
	}
	
	
	public void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background, 0, 0, this.getWidth(), this.getHeight(), null);
		g.draw3DRect(80, 110, 280, 450, false); // 输入框外框
		this.repaint();
	}

}
