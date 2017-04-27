import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLTags {
	final static Pattern pattern = Pattern.compile("<(\\S+?)(.*?)>(.*?)</\\1>");

	public static void main(String[] args) {
		try {

			int fcount=0;
			File dir = new File("C:\\Users\\Reddy\\Desktop\\RA\\go_cc\\");
			for (File file : dir.listFiles()) 
			{
			fcount++;
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			ArrayList<String> tagValues = new ArrayList<String>();

			FileWriter gene = new FileWriter("C:\\Users\\Reddy\\workspace\\GO\\articleontologies.txt");
			BufferedWriter brw = new BufferedWriter(gene);

			while ((line = bufferedReader.readLine()) != null) 
			{
			Matcher m = pattern.matcher(line);
				while (m.find()) 
				{
				int group = m.groupCount();
					if (group == 3) 
					{
						if (m.group(3).contains(">")) 
						{
							int i = m.group(3).lastIndexOf(">");
							tagValues.add(m.group(3).substring(i + 1));
						} else {
							tagValues.add(m.group(3));
							}

					}
				}

			}
			for (String s : tagValues) 
			{
			System.out.println(s);
			brw.write(s+"\n");
			}
			
			System.out.println(fcount);
			System.out.println(file.getName());
			System.out.println("\n  \n");
			brw.write(file.getName());
			brw.write("\n ");
			brw.close();
			
			fileReader.close();
			// System.out.println(tagValues);
			// System.out.println(tagValues.size());
        
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}