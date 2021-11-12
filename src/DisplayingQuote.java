import java.util.ArrayList;
import java.io.*;
public class DisplayingQuote {

	public void display(ArrayList<String> topic, ArrayList<String> quote, ArrayList<String> author) throws IOException, InterruptedException{
		
		System.out.println("---------------");
		
		BufferedReader reader = new BufferedReader(new FileReader("Scientific Quotations Database.txt"));
		
		//Clears the arrays to update them
		topic.clear();
		quote.clear();
		author.clear();

		System.out.println("Displaying Quotes...");
		Thread.sleep(2500);
		
		//Adds the quotes from the .txt file to the arrays
		do {

			topic.add(reader.readLine());
			
			quote.add(reader.readLine());
			
			author.add(reader.readLine());
			
		} while(reader.readLine()!=null); 
		
		reader.close();
		
		System.out.println("---------------");
		
		//Arrays get printed in the same format as the .txt file
		for(int i=0; i<topic.size(); i++) {
			
			System.out.println(topic.get(i));
			System.out.println(quote.get(i));
			System.out.println(author.get(i));
			System.out.println("");
			
		}

		System.out.println("---------------");
		System.out.println("SUCCESS");
	}
	
	
}
