import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Buttons extends JPanel implements ActionListener{ //Extends the JPanel class which enables painting, and implements 
															   //the ActionListener methods to give each button a function
	private static final long serialVersionUID = 1L;
	
	public Buttons(){

		//Gives  each JButton an action
		add.addActionListener(this);
		del.addActionListener(this);
		display.addActionListener(this);
		findName.addActionListener(this);
		findFirst.addActionListener(this);
		sortAuthor.addActionListener(this);
		exit.addActionListener(this);
		
		
	}
	
	//Arrays hold the topic, quote, and author respectively, uses ArrayList so they are resizable
	public ArrayList<String> topic = new ArrayList<String>(); 
	public ArrayList<String> quote = new ArrayList<String>();
	public ArrayList<String> author = new ArrayList<String>(); 
	
	//Buttons
	JButton add = new JButton("Add");
	JButton del = new JButton("Remove");
	JButton display = new JButton("Display Quotes");
	JButton findName = new JButton("Search for Author");
	JButton findFirst = new JButton("Find First Quote by Author");
	JButton sortAuthor = new JButton("Sort by Author");
	JButton exit = new JButton("Exit");
	
	//Method paints the buttons onto the screen
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);	
		this.setBackground(Color.WHITE);
		
		//Location of the JButtons
		add.setBounds(50,50,250,50);
		del.setBounds(350,50,250,50);
		display.setBounds(50,150,250,50);
		findName.setBounds(350,150,250,50);
		findFirst.setBounds(50,250,250,50);
		sortAuthor.setBounds(350,250,250,50);
		exit.setBounds(50,350,550,50);
		
		//adds the buttons onto the screen
		add(add);
		add(del);
		add(display);
		add(findName);
		add(findFirst);
		add(sortAuthor);
		add(exit);
		
		
		
	}
	//The actionPerformed method is overridden, and gives the buttons a function after they are pressed
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == add) {	
			add.setText("Check console...");
			
			try {
				
				new AddingQuote().add(topic, quote, author);
				
			} catch (IOException e1) {
	
				e1.printStackTrace();
			}										//Each button will send the user to the corresponding program(e.g. 'Add' button sends the user to the 'Add Quote' Program)
			
			add.setText("Add");
		}
		
		else if(e.getSource() == del) {
			
			del.setText("Check console...");
			
			try {
				
				new DeletingQuote().delete(topic, quote, author);;
			
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			del.setText("Remove");
			
		}
		
		else if(e.getSource() == display) {
			
			display.setText("Check Console...");
			
			try {
				
				new DisplayingQuote().display(topic, quote, author);
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}		
			
			display.setText("Display Quotes");
			
		}
		
		else if(e.getSource() == findName) {
			
			findName.setText("Check Console...");
			
			try {
				new FindName().findAuthors(topic, quote, author);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			findName.setText("Search for Authors");
			
		}
		
		else if(e.getSource() == findFirst) {
			
			findFirst.setText("Check Console...");
			
			try {
				new FindFirstQuote().findAuthorQuote(topic, quote, author);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			findFirst.setText("Find First Quote by Author");
		}
		
		else if(e.getSource() == sortAuthor) {
			
			sortAuthor.setText("Check Console");
			
			try {
				new SortByAuthor().sortAuthor(topic, quote, author);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			
			sortAuthor.setText("Sort by Author");
		}
		
		//User can choose to exit the program
		else if(e.getSource() == exit) {
			
			System.out.println("Thanks for using the Scientific Quotations Database");
			System.exit(0);
			
			
		}
		
		
	}
	
	
}


