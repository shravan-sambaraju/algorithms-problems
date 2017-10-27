package problems.random;

import java.util.ArrayList;
import java.util.Arrays;


class Pair {
	public int first;
	public int second;
	
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}

public class PairInArrayWhoseSumIsK {
	public static ArrayList<Pair> printPairSums(int[] array, int sum) {
		ArrayList<Pair> result = new ArrayList<Pair>();
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				result.add(new Pair(array[first], array[last]));
				++first;
				--last;
			} else {
				if (s < sum) {
					++first;
				} else {
					--last;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] test = {9, 3, 6, 5, 7, 7, -1, 13, 14, -2, 12, 0};
		ArrayList<Pair> pairs = printPairSums(test, 12);
		for (Pair p : pairs) {
			System.out.println(p.toString());
		}
	}
}