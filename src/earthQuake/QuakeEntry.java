package earthQuake;

public class QuakeEntry implements Comparable<QuakeEntry> {

	private Location myLocation;
	private String title;
	private double depth;
	private double magnitude;

	public QuakeEntry(double lat, double lon, double mag, String t, double d) {
		myLocation = new Location(lat, lon);

		magnitude = mag;
		title = t;
		depth = d;
	}

	public Location getLocation() {
		return myLocation;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public String getInfo() {
		return title;
	}

	public double getDepth() {
		return depth;
	}

	@Override
	public int compareTo(QuakeEntry loc) {
		// if there is Double.compare(magnitude,loc.getMagnitue)==0)
		// something seems different.
		if (magnitude == loc.getMagnitude()) {
			return Double.compare(depth, loc.getDepth());
		}
		return Double.compare(magnitude, loc.getMagnitude());
		// double difflat = myLocation.getLatitude() -
		// loc.myLocation.getLatitude();
		// if (Math.abs(difflat) < 0.001) {
		// double diff = myLocation.getLongitude() -
		// loc.myLocation.getLongitude();
		// if (diff < 0)
		// return -1;
		// if (diff > 0)
		// return 1;
		// return 0;
		// }
		// if (difflat < 0)
		// return -1;
		// if (difflat > 0)
		// return 1;

		// never reached
		// return 0;
	}

	// public int compareTo(QuakeEntry quake1, QuakeEntry quake2) {
	// if (Double.compare(quake1.getMagnitude(), quake2.getMagnitude()) == 0) {
	// return Double.compare(quake1.getDepth(), quake2.getDepth());
	// }
	// return Double.compare(quake1.getMagnitude(), quake2.getMagnitude());
	// }

	public String toString() {
		return String.format("(%3.2f, %3.2f), mag = %3.2f, depth = %3.2f, title = %s", myLocation.getLatitude(),
				myLocation.getLongitude(), magnitude, depth, title);
	}

}