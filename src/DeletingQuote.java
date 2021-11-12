import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

//This class allows the user to delete a quote by letting them search by topic, and choosing what quote to delete through a list

public class DeletingQuote {
	
	
	
	public void delete(ArrayList<String> topic, ArrayList<String> quote, ArrayList<String> author) throws IOException{
		Scanner in = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new FileReader("Scientific Quotations Database.txt"));

		System.out.println("---------------");
		
		topic.clear();
		quote.clear();		//Clears the array and updates it with the new quotes
		author.clear();
		
		ArrayList<String> delOptions = new ArrayList<String>(); //Quotes that the user wants to delete are put here
		
		// Do-while loop adds the new quotes into the array and rereads the old quotes as well
		do {
			topic.add(reader.readLine());
			
			quote.add(reader.readLine());
			
			author.add(reader.readLine());
			
		} while(reader.readLine()!=null); 
		
		reader.close();
		
		String delTop; 
		
		//User chooses a topic to delete from
		do {
			
			delTop = JOptionPane.showInputDialog(null, "Enter the topic of choice");

			
		} while (!delTop.equalsIgnoreCase("Chemistry") && !delTop.equalsIgnoreCase("Physics") && !delTop.equalsIgnoreCase("Biology") && !delTop.equalsIgnoreCase("Math") && !delTop.equalsIgnoreCase("Computer Science"));
		
		
		//Console prints out the quotes for deleting
		System.out.println("---------------------");
		System.out.println("Here are the quotes under " + delTop.toUpperCase());
		System.out.println("");
		
		for(int i=0; i<topic.size(); i++) {
			
			if(topic.get(i).contains(delTop)) {
				
				delOptions.add(quote.get(i).substring(6)); //Adds quotes if they are equal to the users topic of choice
				
			}
			
		}
	
		
		for(int i = 0; i<delOptions.size(); i++) {
			
			System.out.println(i+1 + ":" + delOptions.get(i));
			
			
		}
		
		System.out.println();
		
		System.out.println("Review your options, then press ENTER to continue");
		
		String enter = in.nextLine();
		
		System.out.println("");
		System.out.println("Choose a quote to delete");
		int choice = in.nextInt();
		
		String delQuote = delOptions.get(choice-1);
		
		//Users quote of choice gets removed
		for(int i=0; i<quote.size(); i++) {
			
			if(quote.get(i).contains(delQuote)){
				
				quote.remove(i);
				author.remove(i);
				topic.remove(i);
			}
		
		}
	
		BufferedWriter writer = new BufferedWriter(new FileWriter("Scientific Quotations Database.txt"));
		
		//The .txt file gets rewritten  without the deleted quote
		for(int i = 0; i<author.size(); i++) {
			
			writer.write(topic.get(i));
			writer.newLine();
			writer.write(quote.get(i));
			writer.newLine();
			writer.write(author.get(i));
			
			if(i != author.size()-1) {
				writer.newLine();
				writer.newLine();
			}
		}
		writer.close();
		in.close();
		System.out.println("---------------------");		
		System.out.println("SUCCESS - Please return to the main menu...");
		
		
		
		
		
	}
	
	
}
