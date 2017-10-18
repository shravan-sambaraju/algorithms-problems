package algorithms.sorting;

public class SortedArrayMerge {


		/** Merges array
		 * @param a first array
		 * @param b second array
		 * @param lastA number of "real" elements in a
		 * @param lastB number of "real" elements in b
		 */
		public static void merge(int[] a, int[] b, int lastA, int lastB) {
			int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
			int indexA = lastA - 1; /* Index of last element in array b */
			int indexB = lastB - 1; /* Index of last element in array a */
		
			/* Merge a and b, starting from the last element in each */
			while (indexB >= 0) {
				if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
					a[indexMerged] = a[indexA]; // copy element
					indexA--; 
				} else {
					a[indexMerged] = b[indexB]; // copy element
					indexB--;
				}
				indexMerged--; // move indices			
			}
		}
		
		public static void main(String[] args) {
			int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
			int[] b = {1, 4, 7, 6, 7, 7};
			merge(a, b, 8, 6);
			System.out.println(arrayToString(a));
		}
		
		public static String arrayToString(int[] array) {
			if (array == null) return "";
			return arrayToString(array, 0, array.length - 1);
		}
		
		public static String arrayToString(int[] array, int start, int end) {
			StringBuilder sb = new StringBuilder();
			for (int i = start; i <= end; i++) {
				int v = array[i];
				sb.append(v + ", ");
			}
			return sb.toString();
		}	

	}