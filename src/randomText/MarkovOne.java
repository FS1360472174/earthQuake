package randomText;

import java.util.ArrayList;
import java.util.List;

public class MarkovOne extends AbstractMarkov {

	@Override
	public String getRandomText(int numChars) {
		if (text == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = random.nextInt(text.length()-1);
		String key = text.substring(index,index+1);
		sb.append(key);
		for (int i = 0; i < numChars; i++) {
			List<String> follows = getFollows(key);
			if (follows.size() == 0) {
				break;
			}
			index = random.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key = next;
		}
		return sb.toString();
	}

	/**
	 * get the following character of key in text
	 * 
	 * @param key
	 * @return
	 */
	public List<String> getFollows(String key) {
		ArrayList<String> followString = new ArrayList<String>();
		String str = null;
		int index = key.length();
		for (int i = 0; i <= text.length() - index; i++) {
			str = text.substring(i, i + index);
			if (str.equals(key) && i < text.length() - index) {
				followString.add(text.substring(i + index, i + index + 1));
			}
		}
		return followString;
	}
}
