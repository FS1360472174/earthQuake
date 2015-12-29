package earthQuake;

import java.util.ArrayList;
import java.util.Collections;

public class DifferentSorters {
	//Collection.sort method1:QuakeEntry class implements Comparable<QuakeEntry> interface
	public void sortByMagnitudeThenDepth(ArrayList<QuakeEntry> quakes) {
		Collections.sort(quakes);
	}
}
