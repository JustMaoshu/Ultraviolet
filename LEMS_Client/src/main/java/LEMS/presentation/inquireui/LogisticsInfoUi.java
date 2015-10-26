package LEMS.presentation.inquireui;

import javax.swing.JPanel;

import java.awt.Rectangle;

import javax.swing.JButton;

import LEMS.presentation.mainUi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 章承尧
 * 查询物流信息界面
 */
public class LogisticsInfoUi extends JPanel {
	/**
	 * Create the panel.
	 */
	public LogisticsInfoUi() {
		setBounds(new Rectangle(0, 0, mainUi.WIDTH, mainUi.HEIGHT));
		setLayout(null);
		
		JButton button = new JButton("退出");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogisticsInfoUi.this.setVisible(false);
				mainUi.frame.setContentPane(mainUi.contentPane);
				
			}
		});
		button.setBounds(832, 26, 153, 60);
		add(button);

	}

}
