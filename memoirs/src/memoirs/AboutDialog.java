package memoirs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class AboutDialog extends JDialog
{
	public AboutDialog(JFrame ower)
	{
		super(ower,"����",true);
		StringBuilder builder=new StringBuilder();
		builder.append("   ����һ����Լ�¼����������");
		builder.append("\n");
		builder.append("   ���������԰���о�ֵ�û������Ƭ�Ͷ�����Ƭ�ĸ����¼�����������ֻ����Ƭ���ܼ�¼���ֵ�����.");
		builder.append("\n");
		builder.append("    ʹ��˵��:");
		builder.append("\n");
		builder.append("   ˫��ʮ�ּܵ����Ի��򼴿ɼ���ͼƬ�������ֺ�����д�꼴�ɴ�File�ܵ�Save,�����Ҫ�鿴�ʹ�Open��");
		JTextArea area=new JTextArea();
		area.setLineWrap(true);
		area.setText(builder.toString());
		area.setEditable(false);
		//area.setOpaque(false);
		//area.setWrapStyleWord(true);
		//�ı��ı��������
				area.setFont(new Font("SansSerif",Font.BOLD,18));
		JButton okButton=new JButton("ȷ��");
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
