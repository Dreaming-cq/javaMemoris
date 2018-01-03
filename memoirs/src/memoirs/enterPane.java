package memoirs;
import java.awt.*;
import javax.swing.*;
//*******************************
//这个面板是载入图片用的
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

	//定义了有参和无参的构造方法
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
	//给变量赋值
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
	
	//得到照片的路径
	public String getPhotoPath( )
	{
		return imagePath;
	}
	
	

}
