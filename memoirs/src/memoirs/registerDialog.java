package memoirs;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

@SuppressWarnings("serial")
public class registerDialog extends JDialog
{
	//注册帐号时输入的账号密码
	private JLabel userName;
	private JLabel password;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPanel panel;
	private JButton okButton;
	private JButton cancelButton;
	public registerDialog(JFrame frame)
	{
		super(frame,"注册账号",true);
		userName=new JLabel("账号：",JLabel.CENTER);
		password=new JLabel("密码：",JLabel.CENTER);
		nameField=new JTextField();
		passwordField=new JPasswordField();
		okButton=new JButton("确定");
		cancelButton=new JButton("取消");
		panel=new JPanel();
		//将各组件添加到面板上
		panel.add(userName);
		panel.add(password);
		panel.add(nameField);
		panel.add(passwordField);
		panel.add(okButton);
		panel.add(cancelButton);
		//将面板添加到对话框窗口
		add(panel);
		//设置面板的布局为绝对布局
		panel.setLayout(null);
		//设置对话框的大小
		setSize(400,200);
		//设置显示的位置
		setLocation(700,400);
		//设置组件的位置
		userName.setBounds(30,20,100,30);
		nameField.setBounds(130, 20, 150,30);
		password.setBounds(30,50,100,30);
		passwordField.setBounds(130,50,150,30);
		okButton.setBounds(80,120,100,30);
		cancelButton.setBounds(250,120,100,30);
		//确定按钮的事件处理
		okButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				//得到用户名
				String user=nameField.getText();
				//用户名的格式是否正确
				boolean b_user=user.matches("\\d{8,10}");
				//得到用户的密码，并将字符数组转化成字符串
				char[] pass=passwordField.getPassword();
				String p_word=new String(pass);
				//判断用户名和密码框任意一个是否为空；
				if(user.equals(""))
				{
					JOptionPane.showMessageDialog(null, "请输入账号");
				}
				if(b_user==false)
				{
					JOptionPane.showMessageDialog(null, "账号格式不对");
				}
				else
				{
				if(p_word.equals("")==true)
				{
					JOptionPane.showMessageDialog(null, "请输入密码");
				}
				}
			
				//在账号和密码都不为空的情况下，存储账号密码；
				if(user.equals("")!=true&&p_word.equals("")!=true&&b_user==true)
				{
				StringBuilder str_Builder=new StringBuilder();
				str_Builder.append(user);
				//添加换行符号
				str_Builder.append("\r\n");
				str_Builder.append(p_word);
				str_Builder.append("\r\n");
				//判断用户名是否已存在
				if(isTrue(user,p_word)==false)
				{
				try
				{
					//存储信息
				saveMessage(str_Builder.toString());
				}catch(IOException io)
				{
					io.printStackTrace();
				}
				
				
				File file=new File("E:"+File.separator+"UserName.hy");
				if(file.isFile()==true)
				{
				JOptionPane.showMessageDialog(null, "注册成功");
				//将所有的输入框清空
				nameField.setText("");
				passwordField.setText("");
				}
				//关闭对话框
				
				setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "账号已注册");
					//将所有的输入框清空
					nameField.setText("");
					passwordField.setText("");
				}
				}
				
			}
				});
		cancelButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent event)
			{
				setVisible(false);
			}
				});
		
		}
	//保存账号和密码的文档；
	public void saveMessage (String message)throws IOException
	{
		File fileName=new File("E:"+File.separator+"UserName.hy");
		
		Writer save=new FileWriter(fileName,true);
		save.write(message);
		save.close();
	}
	//查找注册的账号和密是否重复(这个很耗时间）
	
	public boolean isTrue(String userName,String password) 
		{
			File fileName=new File("E:"+File.separator+"UserName.hy");
			
			try
			{
				
			@SuppressWarnings("resource")
			Scanner scanner=new Scanner(fileName);
			while(scanner.hasNext())
			{
				String u_Name=scanner.nextLine();
				scanner.nextLine();
				if(u_Name.equals(userName)==true)
				{
					
					return true;
				}
			}
			}catch(Exception exc)
			{
				exc.printStackTrace();
			}
			
			return false;
		}

}