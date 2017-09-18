import java.util.HashSet;

public class NYC_TTP_Question_1 {

	public static boolean sumOfTwo(int[] a, int[] b, int v) {

		HashSet<Integer> helperSet = new HashSet<Integer>();

		int target = 0;

		for (int i = 0; i < b.length; i++) {
			helperSet.add(b[i]);
		}

		for (int i = 0; i < a.length; i++) {
			target = v - a[i];
			if (helperSet.contains(target))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 5 };

		int[] b = { 1, 20, 9, 3, 2 };

		int v = 7;

		boolean result = false;

		result = sumOfTwo(a, b, v);

		System.out.println(result);

	}

}