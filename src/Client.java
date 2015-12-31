import earthQuake.EarthQuakeClient;

public class Client {
	/**
	 * @param argv
	 */
	public static void main(String[] argv) {

		EarthQuakeClient earthClient = new EarthQuakeClient();
		earthClient.bigQuakes();
		earthClient.testSortByLargestDepth();

		earthClient.testSortByMagnitudeWithBubbleSort();

		earthClient.testSortByMagnitudeWithCheck();

		earthClient.testSortByMagnitudeWithBubbleSortWithCheck();

		earthClient.testSortByMagnitudeThenDepth();

		earthClient.testSortByTitleThenDepth();

		earthClient.testSortByTitleLastThenMagnitude();
		System.out.println("double" + (Double.compare(-0.00, 0.00)));
	}

}
