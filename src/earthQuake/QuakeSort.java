package earthQuake;
import java.util.*;

public class QuakeSort {
	
	public ArrayList<QuakeEntry>sortByDepth(ArrayList<QuakeEntry> in){
		ArrayList<QuakeEntry> listQuakeOut=new ArrayList<QuakeEntry>();
		//limit count
		int count=70;
		while(!in.isEmpty()&&count-->0){
			QuakeEntry maxQuake=getLargestDepth(in);
			listQuakeOut.add(maxQuake);
			in.remove(maxQuake);
		}
		return listQuakeOut;
	}
	public QuakeEntry getLargestDepth(ArrayList<QuakeEntry>listQuake){
		if(listQuake.isEmpty()){
			return null;
		}
		QuakeEntry max=listQuake.get(0);
		for(QuakeEntry entry:listQuake){
			if(entry.getDepth()>max.getDepth()){
				max=entry;
			}
		}
		return max;
	}
	public ArrayList<QuakeEntry> sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> listQuake){
		//ArrayList<QuakeEntry>out=new ArrayList<QuakeEntry>();
		int index=0;
		QuakeEntry entry=null;
		for(int j=0;j<listQuake.size();j++){
			index=onePassBubbleSort(listQuake,j);
			entry=listQuake.get(index);
			listQuake.set(index, listQuake.get(j));
			listQuake.set(j,entry);
		}
		return listQuake;
	}
	public int onePassBubbleSort(ArrayList<QuakeEntry>listQuake,int num){
		int index=num;
		for(int i=num++;i<listQuake.size();i++){
			if(listQuake.get(i).getMagnitude()<listQuake.get(index).getMagnitude()){
				index=i;
			}
		}
		return index;
	}
    public QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> quakes) {
        QuakeEntry min = quakes.get(0);
        for(QuakeEntry q: quakes) {
            if (q.getMagnitude() < min.getMagnitude()) {
                min = q;
            }
        }
        return min;
    }
    
    public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
        //out starts as empty ArrayList
        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
        //As long as in is not empty
        while(!in.isEmpty()) {
            //Find smallest element in in (minElement)
            QuakeEntry minElement = getSmallestMagnitude(in); 
            //Remove minElement from in
            in.remove(minElement);                            
            //Add minElement to out
            out.add(minElement);
        }
        //out is the answer
        return out;
    }
    /* tester method to use in BlueJ */
    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        list = sortByMagnitude(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }

}
