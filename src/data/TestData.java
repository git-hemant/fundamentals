package data;
//
// $Id: $
//
// Copyright (1997-2011),Fair Isaac Corporation. All Rights Reserved.
//

public class TestData
{
	private TestData(){}
	
	public static int[] intArray(int size) {
		int[] randomInt = new int[size];
		for (int i = 0; i < size; i++) {
			randomInt [i] = getRandom(999);
		}
		return randomInt;
	}

	
	private static int getRandom(int max) {
		int random = (int) (Math.random() * 7777);
		int seed = (random << 5); 
		return seed & max;
	}
}
