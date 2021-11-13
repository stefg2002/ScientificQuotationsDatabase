import javax.swing.*;
import java.util.*;

public class Main extends JFrame{ //Extends JFrame class, used for creating a window
	
	private static final long serialVersionUID = 1L;

	public Main() {
		
		//Creates a window and adds the Buttons class
		add(new Buttons());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650,500);
		setVisible(true);
		setTitle("Scientific Quotations Database");
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String enter;
		
		
		System.out.println("Welcome to the Scientific Quotation Database");
		System.out.println("Press enter to continue");
		
		enter = in.nextLine();//User presses enter to load the main menu
		
		System.out.println("Loading main menu...");
		
		Thread.sleep(2500);
		
		new Main();//runs the class constructor
		
		
	}
		

}
