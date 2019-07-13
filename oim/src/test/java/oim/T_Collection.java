package oim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class T_Collection
{

	public static void main(String[] args)
	{
		ArrayList<String> arrayList = new ArrayList<String>(3);

		HashSet<String> hashSet = new HashSet<String>(3);

		LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>(3);

		Hashtable<String, Object> hashtable = new Hashtable<String, Object>(3);

		for (int i = 0; i < 3; i++)
		{
			arrayList.add(String.valueOf(i));
			hashSet.add(String.valueOf(i));
		}

		System.out.println(arrayList);
		System.out.println(hashSet);
	}

}
