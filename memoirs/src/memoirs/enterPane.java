package memoirs;
import java.awt.*;
import javax.swing.*;
//*******************************
//������������ͼƬ�õ�
//*******************************
@SuppressWarnings("serial")
public class enterPane extends JComponent
{
	
	private int xOrg;
	private int yOrg;
	private int width;
	private int height;
	private Image image;
	private String imagePath;
	private Toolkit tool;

	//�������вκ��޲εĹ��췽��
	public enterPane(Image image,int axOrg,int ayOrg,int awidth,int aheight)
	{
		this.xOrg=axOrg;
		this.yOrg=ayOrg;
		this.width=awidth;
		this.height=aheight;
	this.image=image;
	}
	public enterPane()
	{
		
	}
	//
	//��������ֵ
	public void setPath(String aPath,int axOrg,int ayOrg,int awidth,int aheight)
	{
		this.xOrg=axOrg;
		this.yOrg=ayOrg;
		this.width=awidth;
		this.height=aheight;
		this.imagePath=aPath;
		tool=Toolkit.getDefaultToolkit();
		image=tool.getImage(imagePath);
	}
	//
	public void paintComponent(Graphics g)
	{
		
		g.drawImage(image, xOrg, yOrg,width,height,this);
		
	}
	
	//�õ���Ƭ��·��
	public String getPhotoPath( )
	{
		return imagePath;
	}
	
	

}
