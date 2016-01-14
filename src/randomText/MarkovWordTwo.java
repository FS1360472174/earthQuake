package randomText;

import java.util.ArrayList;
import java.util.List;

public class MarkovWordTwo extends AbstractMarkovWord{

	@Override
	public String getRandomText(int numChars) {
		StringBuilder sb = new StringBuilder();
		int index = random.nextInt(text.length-2);  // random word to start with
		String key = text[index];
		String key2 = text[index+1];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numChars-1; k++){
		  List<String> follows = getFollows(key,key2);
		    if (follows.size() == 0) {
		        break;
		    }
			index = random.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key=key2;
			key2=next;
		}
		
		return sb.toString().trim();
	}
	/**
	 * get the following word of key in text
	 * 
	 * @param key
	 * @return
	 */
	public List<String> getFollows(String key1,String key2) {
		ArrayList<String> followString = new ArrayList<String>();
		String str1 = null;
		String str2 = null;
		for (int i = 0; i <= text.length - 2; i++) {
			str1 = text[i];
			str2 = text[i+1];
			if (str1.equals(key1) &&str2.equals(key2) &&i < text.length - 2) {
				followString.add(text[i+2]);
			}
		}
		return followString;
	}
}
