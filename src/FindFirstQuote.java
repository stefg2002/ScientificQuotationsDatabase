import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FindFirstQuote {
	
	public void findAuthorQuote(ArrayList<String> topic, ArrayList<String> quote, ArrayList<String> author) throws IOException{
		
		System.out.println("---------------");
		
		BufferedReader reader = new BufferedReader(new FileReader("Scientific Quotations Database.txt"));
		
		//Clears arrays and updates them with new quotes
		topic.clear();
		quote.clear();
		author.clear();
		
		do {
			topic.add(reader.readLine());
			
			quote.add(reader.readLine());
			
			author.add(reader.readLine());
			
		} while(reader.readLine()!=null); 
		reader.close();
		
		String findAuthor;
		
		//User enters the authors full name, will exit loop if the name is in the database
		do {
		 
			findAuthor = JOptionPane.showInputDialog(null, "Enter the authors full name");
	
		} while(!checkForAuthor(findAuthor, author));
		
		System.out.println("Here is the first quote by " + findAuthor);
		
		//For loop searches for the first quote in the database by that author
		for(int i=0; i<author.size(); i++) {
			
			if(findAuthor.equalsIgnoreCase(author.get(i).substring(7))) {
				
				System.out.println(quote.get(i).substring(6));
				
			}
			
			
		}
		
	}
	
	//Method checks if the user inputted author exists in the database
	public boolean checkForAuthor(String findAuthor, ArrayList<String> author) {
		
		for(int i=0; i<author.size(); i++){
			
			if((author.get(i).substring(7)).equalsIgnoreCase(findAuthor)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}	
}


