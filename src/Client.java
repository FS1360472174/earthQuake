import earthQuake.EarthQuakeClient;

public class Client {
	/**
	 * @param argv
	 */
	public static void main(String[] argv) {

		EarthQuakeClient earthClient = new EarthQuakeClient();
		earthClient.bigQuakes();
		earthClient.testSortByDepth();
		// earthClient.testSortByMagnitudeWithBubbleSort();

		earthClient.testSortByMagnitudeWithCheck();

		earthClient.testSortByMagnitudeWithBubbleSortWithCheck();

		earthClient.testSortByMagnitudeThenDepth();

		earthClient.testSortByTitleThenDepth();

		earthClient.testSortByTitleLastThenMagnitude();
	}

}
