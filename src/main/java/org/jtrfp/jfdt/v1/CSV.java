package org.jtrfp.jfdt.v1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CSV implements ArrayParser
	{
	StringParser subParser;
	public CSV(StringParser subParser)
		{this.subParser=subParser;}
	
	@Override
	public Object parseRead(String s)
		{
		ArrayList<Object> result = new ArrayList<Object>();
		Scanner scanner = new Scanner(s).useDelimiter(",");
		while(scanner.hasNext())
			{result.add(subParser.parseRead(scanner.next()));}
		Class elementClass = result.get(0).getClass();
		Object rA = Array.newInstance(elementClass, result.size());
		final int size=result.size();
		for(int i=0; i<size;i++)
			{Array.set(rA, i, result.get(i));}
		return rA;
		}//end parseRead(...)

	@Override
	public String parseWrite(Object o)
		{
		Object [] objects = (Object [])o;
		StringBuilder result = new StringBuilder();
		for(Object obj:objects)
			{result.append(subParser.parseWrite(obj));result.append(",");}
		//Remove trailing comma
		result.deleteCharAt(result.length()-1);
		return result.toString();
		}
	}
