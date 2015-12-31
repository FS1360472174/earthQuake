package earthQuake;

import java.util.*;

public class QuakeSort {

	public ArrayList<QuakeEntry> sortByLargestDepth(ArrayList<QuakeEntry> in) {
		ArrayList<QuakeEntry> listQuakeOut = new ArrayList<QuakeEntry>();
		// limit count
		int count = 0;
		while (!in.isEmpty()) {
			QuakeEntry maxQuake = getLargestDepth(in);
			listQuakeOut.add(maxQuake);
			in.remove(maxQuake);
			count++;
			if (count ==50) {
				System.out.println("sortByDepth/70Pass:" + listQuakeOut.get(listQuakeOut.size() - 1).getDepth());
			}
		}
		return listQuakeOut;
	}

	public QuakeEntry getLargestDepth(ArrayList<QuakeEntry> listQuake) {
		if (listQuake.isEmpty()) {
			return null;
		}
		QuakeEntry max = listQuake.get(0);
		for (QuakeEntry entry : listQuake) {
			if (entry.getDepth() > max.getDepth()) {
				max = entry;
			}
		}
		return max;
	}

	public ArrayList<QuakeEntry> sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> listQuake) {
		// ArrayList<QuakeEntry>out=new ArrayList<QuakeEntry>();
		for (int j = 0; j < listQuake.size(); j++) {
			onePassBubbleSort(listQuake, j);
		}
		return listQuake;
	}

	public ArrayList<QuakeEntry> sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> listQuake) {
		// ArrayList<QuakeEntry>out=new ArrayList<QuakeEntry>();
		int j = 0;
		for (j = 0; j < listQuake.size(); j++) {
			// check in ordered
			if (checkInSortedOrderByMagnitude(listQuake)) {
				break;
			}
			onePassBubbleSort(listQuake, j);

		}
		System.out.println("sortByMagnitudeWithBubbleSort/Pass" + j);
		return listQuake;
	}

	public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
		// out starts as empty ArrayList
		ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
		// As long as in is not empty
		while (!in.isEmpty()) {

			// Find smallest element in in (minElement)
			QuakeEntry minElement = getSmallestMagnitude(in);
			// Remove minElement from in
			in.remove(minElement);
			// Add minElement to out
			out.add(minElement);
		}

		// out is the answer
		return out;
	}

	public ArrayList<QuakeEntry> sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in) {
		// out starts as empty ArrayList
		ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
		QuakeEntry entry = null;
		int i = 0;
		for (i = 0; i < in.size(); i++) {
			if (checkInSortedOrderByMagnitude(in)) {
				break;
			}
			int index = getSmallestMagnitude(in, i);
			entry = in.get(i);
			in.set(i, in.get(index));
			in.set(index, entry);
		}
		System.out.println("sortByMagnitude/Pass:" + i);
		// out is the answer
		return out;
	}

	public void onePassBubbleSort(ArrayList<QuakeEntry> listQuake, int num) {
		QuakeEntry entry = null;
		for (int i = 0; i < listQuake.size() - num - 1; i++) {
			if (listQuake.get(i).getMagnitude() > listQuake.get(i + 1).getMagnitude()) {
				entry = listQuake.get(i + 1);
				listQuake.set(i + 1, listQuake.get(i));
				listQuake.set(i, entry);
			}
		}

	}

	public QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> quakes) {
		QuakeEntry min = quakes.get(0);
		for (QuakeEntry q : quakes) {
			if (q.getMagnitude() < min.getMagnitude()) {
				min = q;
			}
		}
		return min;
	}

	public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int num) {
		int index = num;
		for (int i = num; i < quakes.size(); i++) {
			if (quakes.get(i).getMagnitude() < quakes.get(index).getMagnitude()) {
				index = i;
			}
		}
		return index;
	}

	public boolean checkInSortedOrderByMagnitude(ArrayList<QuakeEntry> quakes) {
		// guide code
		if (quakes.isEmpty()) {
			return true;
		}
		boolean value = false;
		QuakeEntry minEntry = quakes.get(0);
		for (int i = 1; i < quakes.size(); i++) {
			if (quakes.get(i).getMagnitude() < minEntry.getMagnitude()) {
				value = false;
				break;
			}
			minEntry = quakes.get(i);
			value = true;
		}
		return value;
	}
}
