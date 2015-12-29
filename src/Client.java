import earthQuake.EarthQuakeClient;

public class Client {
	/**
	 * @param argv
	 */
	public static void main(String[] argv) {

		EarthQuakeClient earthClient = new EarthQuakeClient();
		// earthClient.bigQuakes();
		earthClient.testSort();
		// earthClient.testSortByMagnitudeWithBubbleSort();

		earthClient.testSortByMagnitudeWithCheck();

		earthClient.testSortByMagnitudeWithBubbleSortWithCheck();
	}

}
