package randomText;

import java.util.Random;

public abstract class AbstractMarkovWord implements IMarkov {
	protected Random random;
	protected String[] text;

	public AbstractMarkovWord() {
		random = new Random();
	}

	public void setRandom(int seed) {
		random = new Random(seed);
	}

	public void setTraining(String s) {
		text = s.split("\\s+");
	}

	/**
	 * from start index,return the nearlest index target in text
	 * @param text
	 * @param target
	 * @param start
	 * @return
	 */
	protected int indexof(String[] text,String target,int start){
		int pos=-1;
		for(int i=start;i<text.length;i++){
			if(text[i].equals(target)){
				return i;
			}
		}
		return pos;
	}
}
