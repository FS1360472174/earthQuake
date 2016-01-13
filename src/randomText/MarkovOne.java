package randomText;

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
		for (int i = 0; i < numChars-1; i++) {
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

}
