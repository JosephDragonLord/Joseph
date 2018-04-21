Skip to content
This repository
Search
Pull requests
Issues
Marketplace
Explore
 @JosephDragonLord
Sign out
0
0 0 JosephDragonLord/Joseph
 Code  Issues 0  Pull requests 0  Projects 0  Wiki  Insights  Settings
Joseph/.gitignore/.gitignore
680b8f5  2 minutes ago
@JosephDragonLord JosephDragonLord Update .gitignore
     
134 lines (119 sloc)  2.96 KB
 2






 
Message List
1 new message since 3:00 PM on April 21stMark as read

Josh [3:03 PM]
added this Java snippet: TextCenterer.java 
import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
​
import javax.swing.JFrame;
import javax.swing.WindowConstants;
​
public class TextCenterer {
	public static void main(String[] args) {
		Test test = new Test();
		test.setPreferredSize(new Dimension(Test.WIDTH, Test.HEIGHT));
		test.init();
​
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("TextCenter");
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
​
		mainFrame.getContentPane().add(test);
		mainFrame.pack();
		mainFrame.setVisible(true);
​
		test.start();
	}
}
​
class Test extends Applet implements Runnable {
​
	public static int WIDTH = 800, HEIGHT = 800;
​
	private TextField textField1;
​
	public void init() {
		setFocusable(true);
		Label label = new Label("Text:");
		textField1 = new TextField("{Resolution=(800,800)}{Font=(\"Arial\", 0, 72)}{Text=(\"\")}{Location=(HEIGHT-2,0)}");
		textField1.setColumns(70);
		Thread t = new Thread(this);
		t.start();
​
		add(label);
		add(textField1);
	}
​
	@Override
	public void run() {
		for (;;) {
			try {
				updateText();
				repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	 public void paint(Graphics g){
​
	 }
​
	  private Image i;
​
	  public void update(Graphics g) {
	    if ( i == null ) {
	      i = createImage(getHeight(), getHeight());
	    }
	    Graphics g2 = i.getGraphics();
​
	    g2.setColor(getBackground());
	    g2.fillRect(0, 0, getWidth(), getHeight());
​
	    g2.setColor(getForeground());
	    paint(g2);
	    g.drawImage(i, 0, 0, null);
	  }
​
​
​
	  private StringBuilder output = new StringBuilder();
	  
	  class Data{
	  	Dimension d;
	  	Font f; 
	  	String t;
	  	Dimension loc;
	  	public Data(String s) {
	  		for(String str : s.split("}")) {
	  			if(str.contains("Resolution")) {
	  				d = new Dimension(Integer.parseInt(str.substring(str.indexOf("(")+1, str.indexOf(","))), Integer.parseInt(str.substring(str.indexOf(",")+1, str.indexOf(")"))));
	  			}
	  			if(str.contains("Font")) {
	  				f = new Font(str.substring(str.indexOf("(")+2, str.indexOf(",")-1),
	  						Integer.parseInt(str.substring(str.indexOf(",")+2, str.indexOf(",", str.indexOf(",")+1))),
	  						Integer.parseInt(str.substring(str.indexOf(",", str.indexOf(",", str.indexOf(",")+1)+1), str.indexOf(")"))));
	  				System.out.println(str.indexOf(",", str.indexOf(",")+1));
	  				System.out.println(str);
	  			}
​
	  		}
	  	}
	  }
​
	  private void updateText(){
	    String text = textField1.getText();//format = {Resolution=(800,800)}{Font=("Arial", 0, 72)}{Text=("")}{Location=(HEIGHT-2,0)}
	    Data d = new Data(text);
	    	    
	    repaint();
	  }
​
}
Collapse 

Message Input


Message bestgroup
© 2018 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
API
Training
Shop
Blog
About
Press h to open a hovercard with more details.
