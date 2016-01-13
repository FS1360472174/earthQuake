package randomText;

public class MarkovZero extends AbstractMarkov implements IMarkov {

	@Override
	public String getRandomText(int numChars) {
		if(text==null){
			return "";
		}
		StringBuilder sb=new StringBuilder();
		int index=0;
		for(int i=0;i<numChars;i++){
			index=random.nextInt(text.length());
			sb.append(text.charAt(index));
		}
		return sb.toString();
	}
}
