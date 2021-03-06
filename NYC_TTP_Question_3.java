import java.util.Stack;

public class NYC_TTP_Question_3 {

	public static int getClosingParen(String sentence, int openingParenIndex) {

		int openIndex = -1;
		int closingIndex = -1;

		Stack<Integer> indicesStack = new Stack<Integer>(); //this stack will contain the indices of the opening parentheses

		for (int i = 0; i < sentence.length(); i++) {

			char currentchar = sentence.charAt(i);

			if (currentchar == '(') {
				indicesStack.push(i);
			}

			else if (currentchar == ')') {
				if (indicesStack.isEmpty() == false) {
					openIndex = indicesStack.pop();
					if (openIndex == openingParenIndex)
						closingIndex = i;
				} 
				else // if indicesStack is empty, return error value -1
					return -1;
			}
		}// end for loop

		if (indicesStack.isEmpty() == true)
			return closingIndex; // returns closing paren index only if parentheses are balanced
		else
			return -1;
	}

	public static void main(String[] args) {

		String sentence = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";

		int openingParenIndex = 10;

		System.out.println(getClosingParen(sentence, openingParenIndex));

	}
}
