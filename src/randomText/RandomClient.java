package randomText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RandomClient {
	public void testMarkovZero() {
		String path = "properties/romeo.txt";
		MarkovZero markZero = new MarkovZero();
		runMarkov(path, markZero);
	}

	public void testGetFolow() {
		String str = "this is a test yes this is a test.";
		//String str=readFile("properties/confucius.txt");
		MarkovOne markOne = new MarkovOne();
		markOne.setTraining(str);
		List<String> listStr = markOne.getFollows("es");
		printListString(listStr);
	}

	public void runMarkov(String path, AbstractMarkov mark) {
		File file = new File(path);
		try {
			FileInputStream input = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String str = "";
			StringBuilder sb = new StringBuilder();
			try {
				while (reader.readLine() != null) {
					sb.append(reader.readLine() + ' ');
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			str = sb.toString();
			mark.setTraining(str);
			mark.setRandom(42);
			for (int i = 0; i < 3; i++) {
				String text = mark.getRandomText(500);
				printOut(text);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	 * read file to string.
	 * replace '/n' of ' '
	 * @param path
	 * @return
	 */
	private String readFile(String path) {
		File file = new File(path);
		String str = null;
		try {
			FileInputStream input = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			StringBuilder sb = new StringBuilder();
			try {
				while (reader.readLine() != null) {
					sb.append(reader.readLine() + ' ');
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			str = sb.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
