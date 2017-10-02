/*
 * Nujoma Halls
 * 
 * NYC_TTP Question B
 * 
 * According to the question, you have a hash set called 'visited' that just stores the entire URL.
 * 
 *   HashSet<String> visited = new HashSet<String>();
          visited.add("www.google.com");
          visited.add("http://www.trustedreviews.com/reviews/nvidia-geforce-gtx-1080");
          visited.add("https://www.theguardian.com/music/musicblog/2011/aug/30/brilliant-corners-thelonious-monk");
          
          
   As the number of URL's added increases, that data structure will eventually balloon in size and take up an enormous amount of memory.
   
   One effective way to decrease memory usage is instead of storing the URL's in a set,  you  store the URL's directly to a database. 
   This way, you will tradeoff increased hard disk usage for decreased memory usage.
   This is a great tradeoff since hard disk space is (usually) much cheaper than RAM, and databases also have built-in memory management features that would further optimize the memory usage.
    
    
    
 
  However, if you insist on using a set called "visited", in order to trim down the space taken up by visited, we could store shorter strings inside the set.
  
  These short strings would then map to the primary key of the database table that contains all the full URL's
  
  E.g.
  
  id               URL  
  
  1221233          "www.google.com"
  2323254          "http://www.trustedreviews.com/reviews/nvidia-geforce-gtx-1080"
  7654909          "https://www.theguardian.com/music/musicblog/2011/aug/30/brilliant-corners-thelonious-monk"
  
  
  
  The function will then take that primary key from the database and turn it into a short string. We then store that short string in a set called "visited."
  
  
  
  When we want the entire URL, we convert the short string back into an integer. This integer (which is the primary key of the table) can be used in an SQL query to find the entire URL.
  
  select URL from URL_TABLE 
  where id = 1221233;
 * 
 */

import java.util.*;

public class NYC_TTP_Question_B {

	public static void url_trim(HashSet<String> visited) {
		StringBuilder sb = new StringBuilder();
		int remainder, current, i;
		char[] possible_chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		/*
		 * I'm hard coding the id numbers below because I don't have an actual database, and
		 * we are not allowed to use outside libraries and frameworks. With a
		 * database I would use an SQL query to get the id numbers of the URL in
		 * the database. 
		 * for (String temp : visited) { 
		 *    number[i] = select id from URL_TABLE where URL = temp; 
		 *    i++; 
		 * }
		 * 
		 */
		 int number[] = { 1221233, 2323254, 7654909 };

		
		visited.clear();

		for (i = 0; i < number.length; i++) {
			current = number[i];

			if (current == 0) {
				visited.add(String.valueOf('a'));
			}

			while (current > 0) {
				remainder = current % 62;
				current = current / 62;
				sb.append(possible_chars[remainder]);
			}
			sb.reverse();
			visited.add(sb.toString());
			sb.delete(0, sb.length());
		}

		for (String temp : visited) {
			System.out.println(temp);
		}

		// To get back the primary keys, us the get_primary_key function while
		// passing in the short URL's from the set called visited as the parameter

		for (String temp : visited) {
			int w = get_primary_key(temp);
			System.out.println(w);
		}
	}

	public static int get_primary_key(String s) {
		String possible_chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int index, power, primary_key = 0;
		
		while (s.length() >= 1) {
			index = possible_chars.indexOf(s.substring(0, 1));
			power = s.length() - 1;
			primary_key += index * (Math.pow(62, power));
			s = s.substring(1);
		}

		return primary_key;

	}

	public static void main(String[] args) {

		HashSet<String> visited_test = new HashSet<String>();
		visited_test.add("www.google.com");
		visited_test.add("http://www.trustedreviews.com/reviews/nvidia-geforce-gtx-1080");
		visited_test.add("https://www.theguardian.com/music/musicblog/2011/aug/30/brilliant-corners-thelonious-monk");

		url_trim(visited_test);

	}
}