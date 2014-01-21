package com.malsolo.springframework.samples;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestMain {
	
	public static void main(String... args) {
		int[] array = {1, 2, 3, 4, 5};
		int[] newArray = Arrays.copyOf(array, array.length+1);
		for (int i : newArray) {
			System.out.println(i);
		}
		newArray[newArray.length-1] = 6;
		for (int i : newArray) {
			System.out.println(i);
		}
		BigDecimal bd = new BigDecimal("0.010");
		System.out.println(bd);
		BigDecimal bd2 = new BigDecimal(0.010D);
		System.out.println(bd2);
	}

}
