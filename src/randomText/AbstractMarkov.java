package randomText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractMarkov implements IMarkov {
	protected Random random;
	protected String text;
	public AbstractMarkov(){
		random=new Random();
	}
	public void setRandom(int seed){
		random = new Random(seed);
	}
	
	public void setTraining(String s){
		text = s.trim();
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
