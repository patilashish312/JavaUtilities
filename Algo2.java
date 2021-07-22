package app.comp;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {
	
	//https://www.hackerrank.com/challenges/compare-the-triplets/problem
	/*
	 * Complete the 'compareTriplets' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY a 2. INTEGER_ARRAY b
	 */

	public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {		
		int arr[]=Stream.of(0,1,2).collect(()->new int[2],(x,y)->{
			if(a.get(y)>b.get(y))
				x[0]=x[0]+1;
			else if (a.get(y)<b.get(y)) x[1]=x[1]+1;
		},(x,y)->y=x);		
		return Arrays.asList(arr[0],arr[1]);
	}
}

public class Algo2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		List<Integer> result = Result2.compareTriplets(a, b);

		//bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

		bufferedReader.close();
		//bufferedWriter.close();
	}
}