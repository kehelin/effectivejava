package leetcode;

import javafx.collections.transformation.SortedList;
import javafx.util.Pair;

import java.util.*;

public class Solution406 {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o2[0] - o1[0];
				}
			}
		});
		List<int[]> result = new LinkedList<int[]>();
		for(int[] temp : people) {
			result.add(temp[1],temp);
		}
		return result.toArray(new int[people.length][]);

	}
}
