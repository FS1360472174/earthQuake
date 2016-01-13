package randomText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.List;

public class RandomClient {
	public void testMarkovZero() {
		String path = "properties/confucius.txt";
		MarkovZero markZero = new MarkovZero();
		runMarkov(path, markZero);
	}

	public void testGetFolow() {
		// String str = "this is a test yes this is a test.";
		String str = readFile("properties/melville.txt");
		MarkovOne markOne = new MarkovOne();
		markOne.setTraining(str);
		List<String> listStr = markOne.getFollows("th");
		printListString(listStr);
	}

	public void testMarkovOne() {
		String path = "properties/confucius.txt";
		MarkovOne markOne = new MarkovOne();
		runMarkov(path, markOne);
	}

	public void testMarkovFour() {
		String path = "properties/confucius.txt";
		MarkovFour markFour = new MarkovFour();
		runMarkov(path, markFour);
	}

	public void testMarkModel() {
		String path = "properties/confucius.txt";
		MarkovModel markModel = new MarkovModel(8);
		runMarkov(path, markModel);
	}

	public void runMarkov(String path, AbstractMarkov mark) {
		String str = readFile(path);
		mark.setTraining(str);
		mark.setRandom(365);
		System.out.println("runMarkov");
		for (int i = 0; i < 3; i++) {
			String text = mark.getRandomText(500);
			printOut(text);
		}

	}

	private void printOut(String s) {
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for (int k = 0; k < words.length; k++) {
			System.out.print(words[k] + " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}

	private void printListString(List<String> list) {
		System.out.println("size:" + list.size() + "\n");
		for (String str : list) {
			System.out.println(str + "\n");
		}

	}

	/**
	 * read file to string. replace '/n' of ' '
	 * 
	 * @param path
	 * @return
	 */
	private String readFile(String path) {
		String str = null;
		try {
			FileInputStream input = new FileInputStream(path);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			StringBuilder sb = new StringBuilder();
			try {
				String line = reader.readLine();
				while (line != null) {

					sb.append(line + ' ');
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {

				try {
					reader.close();
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			str = sb.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
