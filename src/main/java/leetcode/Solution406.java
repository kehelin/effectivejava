package leetcode;

import javafx.collections.transformation.SortedList;
import javafx.util.Pair;

import java.util.*;

public class Solution406 {
	public int[][] reconstructQueue(int[][] people) {
		Map<Integer,ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		for(int i = 0;i<people.length;i++) {
			if(map.containsKey(people[i][0])) {
				map.get(people[i][0]).add(people[i][1]);
			}else {
				list.add(people[i][1]);
				map.put(people[i][0],list);
			}
		}
		LinkedList<Map.Entry<Integer,Integer>> result = new LinkedList();
		for(Integer i : map.keySet()) {
			ArrayList<Integer> list = Arrays.sort(map.get(i));
			for(Integer j : list) {

			}
		}

	}
}
