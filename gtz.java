import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
/**
 * Create a application"JungleParty" to practice counting skills
 * @author Guo Tianze
 * Create a all the component of interface.
 */
public class gtz extends JFrame {
	JFrame jp=new JFrame("Welcome to the Jungle Party!");//Create a frame
	
	JLabel lab=new JLabel("How many animals have come to the party?");//Show the question text
	
	JTextField txt=new JTextField(2);//Give the field to type
	
	JLabel pic[]=new JLabel[10];//Create label to put picture in
	
	JPanel animals=new JPanel(new GridLayout(0,5));
	JPanel P1=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel text=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel P2=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel check=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel P3=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel all=new JPanel(new FlowLayout(FlowLayout.CENTER));//Create and layout all the panels
	
	JButton b=new JButton("Check!");//Create a button to click for check
	
	int pn ;//The random number of pictures
	int p = 1; 
	
	public static void main(String[] args) {
		gtz mf=new gtz();
		mf.gui();// Create a main function to run the application
	}
	/**
	 * Make a graphical user interface
	 */
	public void gui(){
		jp.getContentPane().setLayout(new BorderLayout(0,0)); //Layout all parts

		pn =10;//For the first time to display
		setPic();
	    P1.add(animals);//Put all pictures' panel into a container
		
        text.add(lab);
        text.add(txt);
        lab.setFont(new Font("Calibri",Font.PLAIN,48));//Set the size of word
        txt.setFont(new Font("Calibri",Font.PLAIN,48));
        P2.add(text);//Put the words' and textfield's panel into one container
        
    	check.add(b);
    	b.setFont(new Font("Calibri",Font.PLAIN,48));
        P3.add(check);//Put button's panel into a container

        all.add(P1);
        all.add(P2);
        all.add(P3);
        
		jp.add(P1, BorderLayout.NORTH);       
        jp.add(P2, BorderLayout.CENTER);
        jp.add(P3, BorderLayout.SOUTH);//Layout the container
        
        /**
         * Create a listener for check
         */
        b.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent c) {
                String type=txt.getText();
     
                if(!type.equals("")){
        	 	int input=Integer.parseInt(type); // Collect the number from textfield
        	 	if(pn==input){
                	animals.removeAll();
            		java.util.Random r=new java.util.Random();
            		pn = r.nextInt(10) + 1;//Get the random number; 
                	setPic();
                    lab.setText("Correct, How many animals are in the party now?");
                    txt.setText("");
            		jp.getContentPane().setVisible(false);
            		jp.getContentPane().setVisible(true);
                    jp.pack();// Refresh the pictures
                   
               		}
                else{
                    lab.setText("Wrong!Try again!");
                    txt.setText("");
                	}
                }

            }
        });         
        jp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp.setVisible(true);
        jp.pack();
        // Set the features of the frame
	}
	
	/**
	 * A method to show pictures on the screen
	 */
	public void setPic(){
		
		if (p ==1){
			int i=0;
			while(i<10){			
				String picPath="a"+(i+1)+".png";
	            URL url=gtz.class.getResource(picPath);
	            ImageIcon icon=new ImageIcon(url);
	            icon.setImage(icon.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT));
	            //Create hyperlinks for picture so that can out into icon
	            pic[i]=new JLabel(icon);
	            animals.add(pic[i]);
	            P1.add(animals);
	            i++;
	            // When first launched, exactly 10 animal images will be displayed. 
			}
			p=0;
		}
		else{
			int i=0;
			while(i<pn){			
				String picPath="a"+(i+1)+".png";
	            URL url=gtz.class.getResource(picPath);
	            ImageIcon icon=new ImageIcon(url);
	            icon.setImage(icon.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT));
	            //Create hyperlinks for picture so that can out into icon

	            pic[i]=new JLabel(icon);
	            animals.add(pic[i]);
	            P1.add(animals);
	            i++;
	            // Put pictures into the image icon
			}
		}

	}
	   
}