package app.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

class Result {

	/*
	 * finding substring from string which has most number of vowels.
   * Concept used is regex along with streams.
   * Challange even further told if there are equal lenght string then use earliest string.
	 */
	/*
	 * Complete the 'findSubstring' function below.
	 *
	 * The function is expected to return a STRING. The function accepts following
	 * parameters: 1. STRING s 2. INTEGER k
	 */

	public static String findSubstring(String s, int k) {
		long a=0;
		long b=0;
		String subsequence=null;
			for (int i = 0; i+k<=s.length(); i++) {
				b=s.substring(i, i+k).replaceAll("[aeiou]+?", "1").chars().filter(x->x=='1').count();
				if(b>a) {
					a=b;
					subsequence=s.substring(i, k+i);
				}
			}
			
		 return subsequence;
	}

}

public class SubstringSolution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String s = bufferedReader.readLine();

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		String result = Result.findSubstring(s, k);
		System.out.println(result);

		bufferedReader.close();
	}
}
