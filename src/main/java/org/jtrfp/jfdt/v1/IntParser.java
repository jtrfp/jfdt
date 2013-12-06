package org.jtrfp.jfdt.v1;

public class IntParser implements StringParser
	{
	@Override
	public Object parseRead(String stringThatWasRead)
		{
		return Integer.parseInt(stringThatWasRead);
		}

	@Override
	public String parseWrite(Object toWrite)
		{
		return toWrite.toString();
		}
	}
