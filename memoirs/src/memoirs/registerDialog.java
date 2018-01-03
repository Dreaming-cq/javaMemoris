package memoirs;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

@SuppressWarnings("serial")
public class registerDialog extends JDialog
{
	//ע���ʺ�ʱ������˺�����
	private JLabel userName;
	private JLabel password;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPanel panel;
	private JButton okButton;
	private JButton cancelButton;
	public registerDialog(JFrame frame)
	{
		super(frame,"ע���˺�",true);
		userName=new JLabel("�˺ţ�",JLabel.CENTER);
		password=new JLabel("���룺",JLabel.CENTER);
		nameField=new JTextField();
		passwordField=new JPasswordField();
		okButton=new JButton("ȷ��");
		cancelButton=new JButton("ȡ��");
		panel=new JPanel();
		//���������ӵ������
		panel.add(userName);
		panel.add(password);
		panel.add(nameField);
		panel.add(passwordField);
		panel.add(okButton);
		panel.add(cancelButton);
		//�������ӵ��Ի��򴰿�
		add(panel);
		//�������Ĳ���Ϊ���Բ���
		panel.setLayout(null);
		//���öԻ���Ĵ�С
		setSize(400,200);
		//������ʾ��λ��
		setLocation(700,400);
		//���������λ��
		userName.setBounds(30,20,100,30);
		nameField.setBounds(130, 20, 150,30);
		password.setBounds(30,50,100,30);
		passwordField.setBounds(130,50,150,30);
		okButton.setBounds(80,120,100,30);
		cancelButton.setBounds(250,120,100,30);
		//ȷ����ť���¼�����
		okButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				//�õ��û���
				String user=nameField.getText();
				//�û����ĸ�ʽ�Ƿ���ȷ
				boolean b_user=user.matches("\\d{8,10}");
				//�õ��û������룬�����ַ�����ת�����ַ���
				char[] pass=passwordField.getPassword();
				String p_word=new String(pass);
				//�ж��û��������������һ���Ƿ�Ϊ�գ�
				if(user.equals(""))
				{
					JOptionPane.showMessageDialog(null, "�������˺�");
				}
				if(b_user==false)
				{
					JOptionPane.showMessageDialog(null, "�˺Ÿ�ʽ����");
				}
				else
				{
				if(p_word.equals("")==true)
				{
					JOptionPane.showMessageDialog(null, "����������");
				}
				}
			
				//���˺ź����붼��Ϊ�յ�����£��洢�˺����룻
				if(user.equals("")!=true&&p_word.equals("")!=true&&b_user==true)
				{
				StringBuilder str_Builder=new StringBuilder();
				str_Builder.append(user);
				//��ӻ��з���
				str_Builder.append("\r\n");
				str_Builder.append(p_word);
				str_Builder.append("\r\n");
				//�ж��û����Ƿ��Ѵ���
				if(isTrue(user,p_word)==false)
				{
				try
				{
					//�洢��Ϣ
				saveMessage(str_Builder.toString());
				}catch(IOException io)
				{
					io.printStackTrace();
				}
				
				
				File file=new File("E:"+File.separator+"UserName.hy");
				if(file.isFile()==true)
				{
				JOptionPane.showMessageDialog(null, "ע��ɹ�");
				//�����е���������
				nameField.setText("");
				passwordField.setText("");
				}
				//�رնԻ���
				
				setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "�˺���ע��");
					//�����е���������
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
	//�����˺ź�������ĵ���
	public void saveMessage (String message)throws IOException
	{
		File fileName=new File("E:"+File.separator+"UserName.hy");
		
		Writer save=new FileWriter(fileName,true);
		save.write(message);
		save.close();
	}
	//����ע����˺ź����Ƿ��ظ�(����ܺ�ʱ�䣩
	
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