package memoirs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class AboutDialog extends JDialog
{
	public AboutDialog(JFrame ower)
	{
		super(ower,"帮助",true);
		StringBuilder builder=new StringBuilder();
		builder.append("   这是一款可以记录回忆的软件。");
		builder.append("\n");
		builder.append("   这款软件可以把你感觉值得回忆的照片和对这照片的感想记录下来，解决了只有照片不能记录文字的问题.");
		builder.append("\n");
		builder.append("    使用说明:");
		builder.append("\n");
		builder.append("   双击十字架弹出对话框即可加载图片，把文字和日期写完即可打开File总的Save,如果想要查看就打开Open。");
		JTextArea area=new JTextArea();
		area.setLineWrap(true);
		area.setText(builder.toString());
		area.setEditable(false);
		//area.setOpaque(false);
		//area.setWrapStyleWord(true);
		//改变文本域的字体
				area.setFont(new Font("SansSerif",Font.BOLD,18));
		JButton okButton=new JButton("确定");
		okButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
				});
		
		setSize(600,400);
		setResizable(false);
		setLayout(null);
		setLocation(500,200);
		area.setBounds(0,100,600,150);
		okButton.setBounds(250,330,100,30);
		add(area);
		add(okButton);
	}
}
