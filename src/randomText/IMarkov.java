package randomText;

public interface IMarkov{
	String getRandomText(int numChars);
	 void setRandom(int seed);
	 void setTraining(String s);
}
