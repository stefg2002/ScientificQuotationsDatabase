import java.io.*;
import javax.swing.*;
import java.util.*;

public class AddingQuote {
	
	public AddingQuote() {

		
	}	
	public void add(ArrayList<String> topic, ArrayList<String> quote, ArrayList<String> author) throws IOException{
		
		System.out.println("---------------");
		
		boolean quoteWritten = false;
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("Scientific Quotations Database.txt",true));
		BufferedReader reader = new BufferedReader(new FileReader ("Scientific Quotations Database.txt"));
	
		String addTopic;
	
		//User chooses the topic of the quote
		do {
			
			addTopic = JOptionPane.showInputDialog(null,"Enter the topic of the quote (Chemistry, Physics, Biology, Math, Computer Science)");
				
		} while (!addTopic.equalsIgnoreCase("Chemistry") && !addTopic.equalsIgnoreCase("Physics") && !addTopic.equalsIgnoreCase("Biology") && !addTopic.equalsIgnoreCase("Math") && !addTopic.equalsIgnoreCase("Computer Science"));
	
		//User enters the quote
		String addQuote = JOptionPane.showInputDialog(null, "Enter the quote");
		//User enters the author of the quote
		String addAuthor = JOptionPane.showInputDialog(null,"Enter the author of the quote");
			
		//Loop runs only if every section was completed
		if(topic != null) {	
			
			//Loop finds an empty line and writes the quote to it
			do {
			
				if(reader.readLine() == null) {
				
					writer.newLine();
					writer.newLine();
					writer.write("Topic:" + addTopic);
					writer.newLine();
					writer.write("Quote:" + addQuote);
					writer.newLine();
					writer.write("Author:" + addAuthor.toUpperCase());
					writer.close();
					quoteWritten = true;
				}
			
			} while(quoteWritten == false);
		}
		reader.close();
		
		System.out.println("---------------");
		System.out.println("SUCCESS");
		
		
	}
	
}
