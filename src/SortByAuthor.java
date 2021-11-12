import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SortByAuthor {

	public void sortAuthor(ArrayList<String> topic, ArrayList<String> quote, ArrayList<String> author) throws IOException, InterruptedException {
		
		System.out.println("---------------");
		
		String authorTemp;
		String topicTemp;
		String quoteTemp;
	
		BufferedReader reader = new BufferedReader(new FileReader("Scientific Quotations Database.txt"));

		//Clears the arrays
		topic.clear();
		quote.clear();
		author.clear();
		
		
		System.out.println("Sorting database...");
		
		Thread.sleep(2500);
		
		//Arrays get updated with new quotes(if any)
		do {

			topic.add(reader.readLine());
			
			quote.add(reader.readLine());
			
			author.add(reader.readLine());
			
		} while(reader.readLine()!=null); 
		
		reader.close();
		
		//For-loop runs to sort each quote and topic by authors name
		for (int i = 0; i < author.size(); i++) { 
			
			for (int j = i + 1; j < author.size(); j++) {
                			
				//Runs if the first letter in the authors name comes before the first letter in the next one
            	if (author.get(i).compareTo(author.get(j))>0) {
                    
            		authorTemp = author.get(i);
                    author.set(i, author.get(j));
                    author.set(j, authorTemp);
                    
                    topicTemp = topic.get(i);
                    topic.set(i, topic.get(j));
                    topic.set(j, topicTemp);
                    
                    quoteTemp = quote.get(i);
                    quote.set(i, quote.get(j));
                    quote.set(j, quoteTemp);
                
            	}
            }
        }
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("Scientific Quotations Database.txt"));
		
		//Rewites the sorted arrays in the .txt file
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
		
		System.out.println("---------------");
		System.out.println("SUCCESS");

	}
	
}
