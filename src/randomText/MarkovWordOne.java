package randomText;

import java.util.ArrayList;
import java.util.List;

public class MarkovWordOne extends AbstractMarkovWord {

	@Override
	public String getRandomText(int numChars) {
		StringBuilder sb = new StringBuilder();
		int index = random.nextInt(text.length-1);  // random word to start with
		String key = text[index];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numChars-1; k++){
		  List<String> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = random.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = next;
		}
		
		return sb.toString().trim();
	}
	/**
	 * get the following word of key in text
	 * 
	 * @param key
	 * @return
	 */
	public List<String> getFollows(String key) {
		ArrayList<String> followString = new ArrayList<String>();
		String str = null;
		for (int i = 0; i <= text.length - 1; i++) {
			str = text[i];
			if (str.equals(key) && i < text.length - 1) {
				followString.add(text[i+1]);
			}
		}
		return followString;
	}
}
