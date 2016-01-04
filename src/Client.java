import earthQuake.EarthQuakeClient;
import randomText.RandomClient;

public class Client {
	/**
	 * @param argv
	 */
	public static void main(String[] argv) {
		//testEarthQuake();
		testRandomText();
	}

	public static void testEarthQuake(){
		EarthQuakeClient earthClient = new EarthQuakeClient();
		earthClient.bigQuakes();
		earthClient.testSortByLargestDepth();

		earthClient.testSortByMagnitudeWithBubbleSort();

		earthClient.testSortByMagnitudeWithCheck();

		earthClient.testSortByMagnitudeWithBubbleSortWithCheck();

		earthClient.testSortByMagnitudeThenDepth();

		earthClient.testSortByTitleThenDepth();

		earthClient.testSortByTitleLastThenMagnitude();
	}
	
	public static void testRandomText(){
		RandomClient randomClient=new RandomClient();
		randomClient.testMarkovZero();
		randomClient.testGetFolow();
	}
}
