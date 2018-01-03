package memoirs;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class EnterFrame extends JFrame
{	//用户名标签
	//密码标签
	private JLabel userName;
	private JLabel passWord;
	//用户名和密码的输入框
	private JTextField uN_Text;
	private JPasswordField pw_Text;
	//登陆按钮
	//注册用户按钮
	private JButton enterButton;
	private JButton registerButton;
	//两个可以载入图片的面板
	private enterPane panel1;
	private enterPane panel2;
	//图片
	private Image image1;
	private Image image2;
	//注册账号的对话框
	private registerDialog  dialog;
	//
	private MainFrame mainFrame;
	public EnterFrame()
	{
		userName=new JLabel("用户名:",JLabel.CENTER);
		passWord=new JLabel("密码:",JLabel.CENTER);
		uN_Text=new JTextField();
		pw_Text=new JPasswordField();
		enterButton=new JButton("登陆");
		enterButton.setBackground(Color.blue);
		registerButton=new JButton("注册账号");
		registerButton.setBackground(new Color(237,237,237));
		registerButton.setBorderPainted(false);
		Toolkit tool=Toolkit.getDefaultToolkit();
		image1=tool.createImage("E:"+File.separator+"back.jpg");
		panel1=new enterPane(image1,0,0,500,175);
		image2=tool.createImage("E:\\jj.png");
		panel2=new enterPane(image2,20,20,70,70);
		//panel2=new JPanel();
		//设置窗口的大小500x400
		//窗口大小不可改变
		setTitle("回忆录");
		setSize(500,350);
		setResizable(false);
		setLayout(new GridLayout(2,1));
		setLocation(700,400);
		//
		add(panel1);
		add(panel2);
		//
		panel2.setLayout(null);
		panel2.add(userName);
		panel2.add(passWord);
		panel2.add(uN_Text);
		panel2.add(pw_Text);
		panel2.add(enterButton);
		panel2.add(registerButton);
		//
		userName.setBounds(75,20,100,30);
		uN_Text.setBounds(175, 20, 200, 30);
		passWord.setBounds(75,50,100,30);
		pw_Text.setBounds(175,50,200,30);
		enterButton.setBounds(175,100,200,30);
		registerButton.setBounds(380, 20, 100, 30);
		//
		
		//dialog
	registerButton.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent e)
		{
			if(dialog==null)
				dialog=new registerDialog(EnterFrame.this);
			dialog.setVisible(true);
		}
			});
	//登陆按钮的事件处理
	enterButton.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent event)
		{
			//得到用户名
			String user=uN_Text.getText();
			//用户名的格式是否正确
			boolean b_user=user.matches("\\d{8,10}");
			//得到用户的密码，并将字符数组转化成字符串
			char[] pass=pw_Text.getPassword();
			String p_word=new String(pass);
			//判断用户名和密码框任意一个是否为空；
			if(user.equals("")||(b_user==false))
			{
				JOptionPane.showMessageDialog(null, "请输入账号或者账号的格式不对");
			}
			if(p_word.equals("")==true)
			{
				JOptionPane.showMessageDialog(null, "请输入密码");
			}
			
			if(user.equals("")!=true&&p_word.equals("")!=true&&(b_user==true))
			{
			if(isTrue(user,p_word))
			{
				enterButton.setText("登陆中。。。");
				setVisible(false);
				mainFrame=new MainFrame();
				mainFrame.setVisible(true);
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"账号和密码有误");
			}
			}
		}
			});
	
		
		
	}
	// 判断用户名和密码是否匹配
	public boolean isTrue(String userName,String password) 
	{
		File fileName=new File("E:"+File.separator+"UserName.hy");
		if(fileName.exists())
		{
		try
		{
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(fileName);
		while(scanner.hasNext())
		{
			String u_Name=scanner.nextLine();
			String p_Name=scanner.nextLine();
			if(u_Name.equals(userName)==true&&p_Name.equals(password)==true)
			{
				
				return true;
			}
		}
		}catch(Exception exc)
		{
			exc.printStackTrace();
		}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"请注册账号！");
			uN_Text.setText("");
			pw_Text.setText("");
			return false;
		}
		return false;
	}
	public static void main(String[] args)
	{
		EnterFrame f=new EnterFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
