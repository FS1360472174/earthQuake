package earthQuake;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DifferentSorters {
	// Collection.sort method1:QuakeEntry class implements
	// Comparable<QuakeEntry> interface
	public void sortByMagnitudeThenDepth(ArrayList<QuakeEntry> quakes) {
		Collections.sort(quakes);
	}

	public void sortByTitleThenDepth(ArrayList<QuakeEntry> quakes) {
		// if you want to use it in other place,you can create a class
		// implements Comparator interface
		Comparator<QuakeEntry> compartor = new Comparator<QuakeEntry>() {
			public int compare(QuakeEntry quake1, QuakeEntry quake2) {
				if (quake1.getInfo().equals(quake2.getInfo())) {
					return Double.compare(quake1.getDepth(), quake2.getDepth());
				}
				return quake1.getInfo().compareTo(quake2.getInfo());
			}
		};
		Collections.sort(quakes, compartor);
	}

	public void sortByTitleLastThenMagnitude(ArrayList<QuakeEntry> quakes) {
		Comparator<QuakeEntry> compartor = new Comparator<QuakeEntry>() {
			public int compare(QuakeEntry quake1, QuakeEntry quake2) {
				String title1 = quake1.getInfo();
				String title2 = quake2.getInfo();
				// last word not mean last character
				String str1 = title1.substring(title1.lastIndexOf(" "), title1.length() - 1);
				String str2 = title2.substring(title2.lastIndexOf(" "), title2.length() - 1);
				if (str1.equals(str2)) {
					return Double.compare(quake1.getMagnitude(), quake2.getMagnitude());
				}
				return str1.compareTo(str2);
			}
		};
		Collections.sort(quakes, compartor);
	}
}
