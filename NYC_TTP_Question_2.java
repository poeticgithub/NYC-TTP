
public class NYC_TTP_Question_2 {

	public static String stringReformatting(String s, int k) {

		StringBuilder sb = new StringBuilder(s);

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '-')
				sb.deleteCharAt(i);
		}

		for (int j = sb.length(); j >= 0; j -= k) {
			if (j != 0 && j != sb.length())
				sb.insert(j, '-');
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		String s = "2-4a0r7-4k";

		int k = 3;

		System.out.println(stringReformatting(s, k));

	}

}
