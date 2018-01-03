package memoirs;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class EnterFrame extends JFrame
{	//�û�����ǩ
	//�����ǩ
	private JLabel userName;
	private JLabel passWord;
	//�û���������������
	private JTextField uN_Text;
	private JPasswordField pw_Text;
	//��½��ť
	//ע���û���ť
	private JButton enterButton;
	private JButton registerButton;
	//������������ͼƬ�����
	private enterPane panel1;
	private enterPane panel2;
	//ͼƬ
	private Image image1;
	private Image image2;
	//ע���˺ŵĶԻ���
	private registerDialog  dialog;
	//
	private MainFrame mainFrame;
	public EnterFrame()
	{
		userName=new JLabel("�û���:",JLabel.CENTER);
		passWord=new JLabel("����:",JLabel.CENTER);
		uN_Text=new JTextField();
		pw_Text=new JPasswordField();
		enterButton=new JButton("��½");
		enterButton.setBackground(Color.blue);
		registerButton=new JButton("ע���˺�");
		registerButton.setBackground(new Color(237,237,237));
		registerButton.setBorderPainted(false);
		Toolkit tool=Toolkit.getDefaultToolkit();
		image1=tool.createImage("E:"+File.separator+"back.jpg");
		panel1=new enterPane(image1,0,0,500,175);
		image2=tool.createImage("E:\\jj.png");
		panel2=new enterPane(image2,20,20,70,70);
		//panel2=new JPanel();
		//���ô��ڵĴ�С500x400
		//���ڴ�С���ɸı�
		setTitle("����¼");
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
	//��½��ť���¼�����
	enterButton.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent event)
		{
			//�õ��û���
			String user=uN_Text.getText();
			//�û����ĸ�ʽ�Ƿ���ȷ
			boolean b_user=user.matches("\\d{8,10}");
			//�õ��û������룬�����ַ�����ת�����ַ���
			char[] pass=pw_Text.getPassword();
			String p_word=new String(pass);
			//�ж��û��������������һ���Ƿ�Ϊ�գ�
			if(user.equals("")||(b_user==false))
			{
				JOptionPane.showMessageDialog(null, "�������˺Ż����˺ŵĸ�ʽ����");
			}
			if(p_word.equals("")==true)
			{
				JOptionPane.showMessageDialog(null, "����������");
			}
			
			if(user.equals("")!=true&&p_word.equals("")!=true&&(b_user==true))
			{
			if(isTrue(user,p_word))
			{
				enterButton.setText("��½�С�����");
				setVisible(false);
				mainFrame=new MainFrame();
				mainFrame.setVisible(true);
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"�˺ź���������");
			}
			}
		}
			});
	
		
		
	}
	// �ж��û����������Ƿ�ƥ��
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
			JOptionPane.showMessageDialog(null,"��ע���˺ţ�");
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
