import java.util.HashMap;

public class NYC_TTP_Question_A {

	public static String sortByString(String s, String t) {

		HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
		Integer count;
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < s.length(); j++) {

			count = frequency.get(s.charAt(j));

			if (count == null) {
				count = 1;
				frequency.put(s.charAt(j), count);
			} else {
				frequency.put(s.charAt(j), count + 1);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			if (frequency.containsKey(t.charAt(i))) {
				for (int j = 0; j < frequency.get(t.charAt(i)); j++) {
					sb.append(t.charAt(i));
				}
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {

		String test_Out = sortByString("weather", "therapyw");

		System.out.print(test_Out);

		/*
		 * sortByStrings(s,t): Sort the letters in the string s by the order
		 * they occur in the string t. You can assume t will not have repetitive
		 * characters. For s = "weather" and t = "therapyw", the output should
		 * be sortByString(s, t) = "theeraw". For s = "good" and t = "odg", the
		 * output should be sortByString(s, t) = "oodg".
		 */

	}

}
