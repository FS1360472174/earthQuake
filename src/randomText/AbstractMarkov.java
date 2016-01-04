package randomText;

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
}
