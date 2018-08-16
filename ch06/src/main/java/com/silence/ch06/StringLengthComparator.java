package com.silence.ch06;

import java.util.Arrays;
import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}

	public static void main(String[] args) {
		String[] names = new String[] {"kk", "silence", "null"};
		Arrays.sort(names, new StringLengthComparator());
		System.out.println(Arrays.toString(names));
		
		Arrays.sort(names, (String o1, String o2) -> (o2.length() - o1.length()));
		System.out.println(Arrays.toString(names));
	}

}
