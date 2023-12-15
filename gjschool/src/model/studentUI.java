package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.studentDaoImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;

public class studentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField name;
	private JTextField chi;
	private JTextField eng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentUI frame = new studentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public studentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(217, 10, 185, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("管理系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel.setBounds(32, 0, 143, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(54, 58, 552, 96);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("名字:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(23, 20, 54, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(203, 20, 62, 24);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("英文:");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(385, 20, 54, 24);
		panel_1.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setFont(new Font("新細明體", Font.BOLD, 20));
		name.setBounds(77, 20, 96, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setFont(new Font("新細明體", Font.BOLD, 20));
		chi.setColumns(10);
		chi.setBounds(252, 21, 96, 21);
		panel_1.add(chi);
		
		eng = new JTextField();
		eng.setFont(new Font("新細明體", Font.BOLD, 20));
		eng.setColumns(10);
		eng.setBounds(432, 20, 96, 21);
		panel_1.add(eng);
		
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(54, 183, 552, 214);
		contentPane.add(panel_1_1);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 532, 159);
		panel_1_1.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JButton QueryNewButton = new JButton("查詢 string");
		QueryNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.queryAll2()--->List
				 * 2.String show="";
				 */
				output.setText(new studentDaoImpl().queryAll1() );
			}
		});
		QueryNewButton.setFont(new Font("新細明體", Font.BOLD, 25));
		QueryNewButton.setBounds(39, 10, 199, 29);
		panel_1_1.add(QueryNewButton);
		
		
		JButton QueryNewButton_1 = new JButton("查詢 <List>");
		QueryNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.List-->queryAll2();
				 * 2.show:String;
				 */
				List<student> l=new studentDaoImpl().queryAll2();
				String show="";
				int sum=0;
				int i=0;
				for(student o:l)
				{
					i++;
					sum=sum+(o.getChi()+o.getEng());
					
					show=show+"id:"+o.getId()+
							"\t名:"+o.getName()+
							"\t國文:"+o.getChi()+
							"\t英文:"+o.getEng()+
							"\t總分:"+(o.getChi()+o.getEng())+"\n";
				}				
				show=show+"\n總分合計="+sum+"\t平均="+(sum/i);
				output.setText(show);
			}
		});
		QueryNewButton_1.setFont(new Font("新細明體", Font.BOLD, 25));
		QueryNewButton_1.setBounds(317, 10, 199, 29);
		panel_1_1.add(QueryNewButton_1);
		
		
		
		JButton AddNewButton = new JButton("送出");
		AddNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取 name,chi,eng getText()
				 * 2.name,chi-->轉整數
				 * 3.new student(name,chi,eng);
				 * 4.add(s);
				 */
				String Name=name.getText();
				int CHI=Integer.parseInt (chi.getText());
				int ENG=Integer.parseInt(eng.getText());
				
				student s=new student(Name,CHI,ENG);
				
				try {
					new studentDaoImpl().add(s);
					JOptionPane.showMessageDialog(contentPane,"新增成功","學生成績新增",1, null);
				}
				catch (Exception err)
				{}
				
				
			}
		});
		AddNewButton.setFont(new Font("新細明體", Font.BOLD, 25));
		AddNewButton.setBounds(213, 54, 97, 29);
		panel_1.add(AddNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(429, 59, 99, 23);
		panel_1.add(comboBox);
	}
}
