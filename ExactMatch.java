import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExactMatch {

	public static void main(String[] args) {

		try {
			
			File dir = new File("C:\\Users\\Reddy\\Desktop\\RA\\output@go_bpmf\\");
			FileWriter gene = new FileWriter("C:\\Users\\Reddy\\Desktop\\RA\\Matchesgo_bpmf\\matches.txt");
			BufferedWriter brw = new BufferedWriter(gene);

			for (File file : dir.listFiles()) 
			{
				
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				int count = 0, found = 0, nfound = 0;

				while ((line = bufferedReader.readLine()) != null) 
				{
					count = 0;
					File file2 = new File("geneonto.txt");
					FileReader fileReader2 = new FileReader(file2);
					BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
					String line2;

					while ((line2 = bufferedReader2.readLine()) != null)
					{
							if (line2.equalsIgnoreCase(line)) 
							{
							count++;
							}
					}

					if (count > 0) 
					{
						System.out.println(line+ " EXCAT MATCH");
						found++;
					} else if (count == 0) {
						System.out.println(line+ " NOT EXACT MATCH");
						nfound++;
					}

					fileReader2.close();
				}

				System.out.println("TOTAL ONTOLOGIES-" + (found + nfound));
				System.out.println("EXACT MATCH-" + found);
				System.out.println("NON EXACT MATCH-" + nfound);
				System.out.println(file.getName());
				System.out.print("\n \n");
				fileReader.close();

				brw.write(file.getName() + "\t" + (found + nfound) + "\t" + found + "\t" + nfound+ "\n\n");
				brw.write("\t" + file.getName()+ "\n");
				brw.write("\n");

			}
			brw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
