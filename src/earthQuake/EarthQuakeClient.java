package earthQuake;

import java.util.*;

public class EarthQuakeClient {

	public void testSort() {

		QuakeSort sort = new QuakeSort();
		String source = "properties/earthQuakeDataDec6sample1.atom";
		ArrayList<QuakeEntry> list = getQuakeInfo(source);
		list = sort.sortByDepth((list));
		printData(list);

	}

	public void testSortByMagnitudeWithBubbleSort() {
		QuakeSort sort = new QuakeSort();
		String source = "properties/earthQuakeDataSampleSix2.atom";
		ArrayList<QuakeEntry> list = getQuakeInfo(source);
		printData(list);
		list = sort.sortByMagnitudeWithBubbleSort((list));
		printData(list);
	}

	public void testSortByMagnitudeWithCheck() {
		QuakeSort sort = new QuakeSort();
		String source = "properties/earthQuakeDataDec6sample1.atom";
		// String source ="properties/earthQuakeDataSampleSix2.atom";
		ArrayList<QuakeEntry> list = getQuakeInfo(source);
		list = sort.sortByMagnitudeWithCheck(list);
	}

	public void testSortByMagnitudeWithBubbleSortWithCheck() {
		QuakeSort sort = new QuakeSort();
		String source = "properties/earthQuakeDataDec6sample2.atom";
		// String source ="properties/earthQuakeDataSampleSix2.atom";
		ArrayList<QuakeEntry> list = getQuakeInfo(source);
		list = sort.sortByMagnitudeWithBubbleSortWithCheck(list);
	}

	public void testSortByMagnitudeThenDepth() {
		DifferentSorters sort = new DifferentSorters();
		String source = "properties/nov20quakedata.atom";
		ArrayList<QuakeEntry> list = getQuakeInfo(source);
		sort.sortByMagnitudeThenDepth(list);
		printData(list, 10);
	}

	public ArrayList<QuakeEntry> getQuakeInfo(String source) {
		EarthQuakeParser parser = new EarthQuakeParser();

		// String source =
		// "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		return list;
	}

	public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		// TODO
		for (QuakeEntry qe : quakeData) {
			if (qe.getMagnitude() > magMin) {
				answer.add(qe);
			}
		}
		return answer;
	}

	public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		// TODO
		for (QuakeEntry qe : quakeData) {
			if (qe.getLocation().distanceTo(from) < distMax) {
				answer.add(qe);
			}
		}
		return answer;
	}

	public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for (QuakeEntry qe : list) {
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n", qe.getLocation().getLatitude(), qe.getLocation().getLongitude(),
					qe.getMagnitude(), qe.getInfo());
		}

	}

	public void bigQuakes() {
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source =
		// "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		String source = "properties/nov20quakedata.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");

		for (QuakeEntry qe : list) {
			if (qe.getMagnitude() > 5.0) {
				System.out.println(qe);
			}
		}

		ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
		for (QuakeEntry qe : listBig) {
			System.out.println(qe);
		}
	}

	public void createCSV() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "data/nov20quakedata.atom";
		// String source =
		// "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		dumpCSV(list);
		System.out.println("# quakes read: " + list.size());
	}

	public void closeToMe() {
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source = "data/nov20quakedata.atom";
		String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("# quakes read: " + list.size());

		// Durham, NC
		// Location city = new Location(35.988, -78.907);
		// Bridgeport, CA
		Location city = new Location(38.17, -118.82);
		ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000 * 1000, city);
		for (int k = 0; k < close.size(); k++) {
			QuakeEntry entry = close.get(k);
			double distanceInMeters = city.distanceTo(entry.getLocation());
			System.out.println(distanceInMeters / 1000 + " " + entry.getInfo());
		}

	}

	public void printData(ArrayList<QuakeEntry> list) {
		int index = 0;
		for (QuakeEntry qe : list) {
			System.out.println("index" + index + qe);
			index++;
		}
	}

	public void printData(ArrayList<QuakeEntry> list, int num) {
		System.out.println(num + "value" + list.get(num));
	}
}
