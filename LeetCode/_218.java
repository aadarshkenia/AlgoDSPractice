import java.util.*;
class _218 {
	public static void main(String args[]) {
		int[][] input  = {{2,2,11},{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		new _218().getSkyline(input).forEach(e -> System.out.println(e[0]+ "," + e[1]));
	}

	public List<int[]> getSkyline(int[][] buildings) {
    	int n = buildings.length;
    	TreeMap<Integer, List<Building>> map = new TreeMap<>();
    	PriorityQueue<Building> pq = new PriorityQueue<>(n, (b1, b2) -> {
    		if(b2.height > b1.height) {
    			return -1;
    		} else if(b2.height == b1.height) {
    			int b2_width = b2.right - b2.left;
    			int b1_width = b1.right - b1.left;
    			return Integer.valueOf(b2_width).compareTo(b1_width);
    		} else {
    			return 1;
    		}	
    	});
    	List<int[]> output = new ArrayList<>();
    	for(int i=0; i < n; i++) {
    		Building building = new Building(buildings[i][0], buildings[i][1], buildings[i][2]);
    		addToMap(map, building.left, building);
    		addToMap(map, building.right, building);    		
    	}

    	System.out.println("map="+map);
    	Building active = null;
    	for(Integer i : map.keySet()) {    		
    		List<Building> buildingsLst = map.get(i);
    		//Process buildings with i as their left coordinate.
    		for(Building b : buildingsLst) {
    			if(b.left == i.intValue()) {
    				pq.add(b);
    			}
    		}
    		System.out.println("After processing left elems:" + pq);
    		//Set active building
    		if(active == null) {
    			if(pq.size() > 0) {
    				active = pq.peek();
    				output.add(getSkylinePoint(active));
    			}
    		}

    		//Process buildings with i as their right coordinate.
			for(Building b : buildingsLst) {
    			if(b.right == i.intValue()) {
    				pq.remove(b);
    			}
    			if(b == active) {
    				active = null;
    			}
    		}

    		//If active null
    		if(active == null) {
    			if(pq.size() > 0) {
    				active = pq.peek();
    				output.add(getSkylinePoint(active));
    			} else {
    				int arr[] = new int[2];
    				arr[0] = i;
    				arr[1] = 0;
    				output.add(arr); 
    			}
    		}
    		System.out.println("For key:" + i + " : pq: " + pq);
    	}
    	return output;
    }

    private int[] getSkylinePoint(Building b) {
    	int[] out = new int[2];
		out[0] = b.left; 
		out[1] = b.height;
		return out;
    }

    private void addToMap(Map<Integer, List<Building>> map, int key, Building b) {
    	if(map.containsKey(key)) {
    		map.get(key).add(b);
    	} else {
    		List<Building> list = new ArrayList<>();
    		list.add(b);
    		map.put(key, list);
    	}
    }

    class Building {
    	int left, right, height;
    	Building(int l, int r, int h) {
    		left = l;
    		right = r;
    		height = h;
    	}

    	@Override
    	public String toString() {
    		return String.format("[%d, %d, %d]", left, right, height);
    	}
    }
}