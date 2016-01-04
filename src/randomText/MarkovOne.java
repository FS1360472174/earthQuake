package randomText;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.StringUtils;

public class MarkovOne extends AbstractMarkov {

	@Override
	public String getRandomText(int numChars) {
		if (text == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (int i = 0; i < numChars; i++) {
			index = random.nextInt(text.length());
			sb.append(text.charAt(index));
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
