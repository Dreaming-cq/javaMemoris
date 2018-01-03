package memoirs;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;
import java.util.Scanner;
@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	//日期标签
	private JLabel date;
	//图片背景的主面板
	private enterPane mainPanel;
	private String backgroundPath;
	
	//
	@SuppressWarnings("unused")
	private Toolkit tool;
	//
	//载入图片的面板
	private enterPane photoPanel;
	//记录心情的面板
	private JPanel feelingPanel;
	private JLabel feelingLabel;
	private JTextArea feelingArea;
	private JTextField feelingField;
	private JScrollPane scrollpane;
	//menu
	private JMenuBar menuBar;
	public MainFrame()
	{
		
		//
		tool=Toolkit.getDefaultToolkit();
		//主窗口
		setSize(1000,600);
		setTitle("回忆录");
		setResizable(false);
		setLocation(500,150);
		//主窗口添加菜单
		menuBar=new JMenuBar();
		//文件菜单
		JMenu file=new JMenu("File");
		JMenuItem NewItem=new JMenuItem("New");
		JMenuItem OpenItem=new JMenuItem("Open");
		JMenuItem SaveItem=new JMenuItem("Save");
		file.add(NewItem);
		file.add(NewItem);
		file.add(OpenItem);
		file.add(SaveItem);
		//背景
		 JMenu background=new JMenu("Background");
		 JMenuItem change=new JMenuItem("Change");
		 background.add(change);
		 //帮助
		 JMenu Help=new JMenu("Help");
		JMenuItem About=new JMenuItem("About");
		Help.add(About);
		//为菜单添加快捷键
		file.setMnemonic('F');
		OpenItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		SaveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		//
		background.setMnemonic('B');
		change.setMnemonic('C');
		//
		Help.setMnemonic('H');
		About.setMnemonic('A');
		
		 
		 //
		menuBar.add(file);
		menuBar.add(background);
		menuBar.add(Help);
		setJMenuBar(menuBar);
	
		
	
		//****************************************
		//主面板
		//******************************************
		//主面板
		backgroundPath="E:"+File.separator+"background.jpg";
		mainPanel=new enterPane();
		mainPanel.setPath(backgroundPath,0,0,1000,600);
		
		//添加到主窗口
		add(mainPanel);
		//主面板采用绝对布局
		mainPanel.setLayout(null);
		
		//************************************
		//图片的面板
		//************************************
		//载入图片的面板
		String photoPath="E:"+File.separator+"plus.png";
		photoPanel=new enterPane();
		photoPanel.setPath(photoPath,175,150,100,100);
		//面板的边框
		photoPanel.setBorder(BorderFactory.createEtchedBorder());
		photoPanel.setOpaque(false);
		//
		//图片的面板的监听器
		photoPanel.addMouseListener(new MouseListener()
				{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getButton()==1&&e.getClickCount()==2)
				{
					String OpenPath=OpenDialog(photoPath);
					if(OpenPath.equals(photoPath))
					{
						photoPanel.setPath(OpenPath,175,150,100,100);
					}
					else
					{
						photoPanel.setPath(OpenPath,0,0,500,400);
						repaint();
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
				});
		
		//******************************************
		//写入心情的面板
		//*****************************************
		feelingPanel=new JPanel();
		feelingPanel.setBorder(BorderFactory.createEtchedBorder());
		feelingPanel.setOpaque(false);
		date=new JLabel("日期：",JLabel.CENTER);
		date.setForeground(Color.red);
		feelingLabel=new JLabel("内容:",JLabel.CENTER);
		feelingLabel.setForeground(Color.red);
		feelingArea=new JTextArea();
		scrollpane=new JScrollPane(feelingArea);
		feelingField=new JTextField();
		feelingPanel.setLayout(null);
		feelingPanel.add(date);
		feelingPanel.add(feelingLabel);
		feelingPanel.add(scrollpane);
		feelingPanel.add(feelingField);
		
		//
		feelingLabel.setBounds(0,0,100,30);
		scrollpane.setBounds(10,30,480,300);
		date.setBounds(40,340,100,30);
		feelingField.setBounds(300, 340, 150, 30);
		//让文本域透明化
		feelingArea.setOpaque(false);
		scrollpane.setOpaque(false);
		scrollpane.getViewport().setOpaque(false);
		feelingField.setOpaque(false);
		//改变文本域的字体
		feelingArea.setFont(new Font("SansSerif",Font.BOLD,18));
		feelingArea.setLineWrap(true);
		feelingField.setFont(new Font("SansSerif",Font.BOLD,18));
		//
		//*******************************
		//将两面板合并
		//******************************
		
		JPanel sumPanel=new JPanel();
		sumPanel.setLayout(new GridLayout(1,2));
		sumPanel.add(photoPanel);
		sumPanel.add(feelingPanel);
		//*********************
		//主面板中添加两面板合并的面板
		//************************
		mainPanel.add(sumPanel);
		sumPanel.setBounds(0,75,1000,400);
		sumPanel.setOpaque(false);
		//******************************
		//为菜单添加事件处理程序
		//******************************
		NewItem.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				photoPanel.setPath(photoPath,175,150,100,100);
				feelingArea.setText("");
				feelingField.setText("");
				repaint();
			}
				});
		
		OpenItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setDialogTitle("打开文件");
				fileChooser.setCurrentDirectory(new File("."));
				fileChooser.setMultiSelectionEnabled(false);
				FileNameExtensionFilter filter=new FileNameExtensionFilter("Files","mem");
				fileChooser.setFileFilter(filter);
				if(fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION)
				{
					File path=fileChooser.getSelectedFile();
					ShowMessage(path);
					repaint();
				}
			}
		});
		SaveItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setDialogTitle("保存文件");
				fileChooser.setCurrentDirectory(new File("."));
				fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);//设置保存对话框
				fileChooser.setMultiSelectionEnabled(false);
				FileNameExtensionFilter filter=new FileNameExtensionFilter("*.mem","mem");
				fileChooser.setFileFilter(filter);
				if(fileChooser.showSaveDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION)
				{
					 File f = fileChooser.getSelectedFile();
					 String path=photoPanel.getPhotoPath();
					 String Message=feelingArea.getText();
					 String data=feelingField.getText();
					 saveMessage(f,path,Message,data);
				}
		}
		});
		change.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			
				mainPanel.setPath(OpenDialog(backgroundPath), 0, 0,1000,600);
				repaint();
			}
		});
		About.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AboutDialog dialog=new AboutDialog(MainFrame.this);
				dialog.setVisible(true);
			}
		});
		
		//
		addWindowListener(new WindowListener()
				{
			public void windowClosed(WindowEvent event)
			{
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
				});
	}
	//保存文件
	public void saveMessage(File file,String path,String Message,String date)
	{
		StringBuilder builder=new StringBuilder();
		builder.append(path);
		builder.append("\r\n");
		builder.append(Message);
		builder.append("\r\n");
		builder.append(date);
		builder.append("\r\n");
		try
		{
			
	Writer out=new FileWriter(file);
	out.write(builder.toString());
	out.close();
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		
	}
	public void ShowMessage(File f)
	{
		try
		{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(f);
		while(in.hasNext())
		{
			photoPanel.setPath(in.nextLine(), 0,0,500,400);
			feelingArea.setText(in.nextLine());
			feelingField.setText(in.nextLine());
		}
		}
		catch(IOException ioe)
		{
			
		}
	}
	//******************************
	//载入图片的对话框
	//******************************
	public String OpenDialog( String OldName)
	{
		String path=OldName;
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("载入图片");
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setMultiSelectionEnabled(false);
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Image Files","jpg","png","gif");
		fileChooser.setFileFilter(filter);
		if(fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION)
		{
			path=fileChooser.getSelectedFile().getPath();
			
		}
		else
		{
			path=OldName;
		}
		return path;
	}
	
	/*public static void main(String[] args)
	{
	MainFrame f=new MainFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
*/
	

}


