package randomText;

import java.util.List;

public class MarkovModel extends AbstractMarkov {

	private int Number = 1;

	public MarkovModel(int num) {
		Number = num;
	}

	@Override
	public String getRandomText(int numChars) {
		if (text == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = random.nextInt(text.length() - Number);
		String key = text.substring(index, index + Number);
		sb.append(key);
		for (int i = 0; i < numChars - Number; i++) {
			List<String> follows = getFollows(key);
			if (follows.size() == 0) {
				break;
			}
			index = random.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key = key.substring(1) + next;
		}
		return sb.toString();
	}

}
