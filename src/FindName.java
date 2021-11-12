import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FindName {

	public void findAuthors(ArrayList<String> topic, ArrayList<String> quote, ArrayList<String> author) throws IOException {

		System.out.println("---------------");
		
		BufferedReader reader = new BufferedReader(new FileReader("Scientific Quotations Database.txt"));
		
		//Removes the array and updates it
		topic.clear();
		quote.clear();
		author.clear();
		
		do {

			topic.add(reader.readLine());
			
			quote.add(reader.readLine());
			
			author.add(reader.readLine());
			
		} while(reader.readLine()!=null); 
		reader.close();
		
		System.out.println("---------------");
		System.out.println("Authors listed in the database:");
		
		//For-loop prints out all the authors in the database
		for(int i=0; i<author.size(); i++) {
			
			System.out.println(author.get(i).substring(7));
			
		}
		
		
		
	}
	
}
