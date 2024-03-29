/*******************************************************************************
 * This file is part of the JAVA FILE DESCRIPTION TOOLKIT (JFDT)
 * A library for parsing files and mapping their data to/from java Beans.
 * ...which is now part of the JAVA TERMINAL REALITY FILE PARSERS project.
 * Copyright (c) 2012,2013 Chuck Ritola and any contributors to these files.
 * 
 *     JFDT is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     JDFT is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with jTRFP.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.jtrfp.jfdt;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class ParserRegistry{
	private static HashMap<String,LinkedHashSet<String>> parserRegistry = new HashMap<String,LinkedHashSet<String>>();
	public static void registerParser(String parserTypeKey, String packageName){
		if(!parserRegistry.containsKey(parserTypeKey)){parserRegistry.put(parserTypeKey, new LinkedHashSet<String>());}
		LinkedHashSet<String>list=parserRegistry.get(parserTypeKey);
		list.add(packageName);
		}
	public static Class<?> [] getClassesIn(String parserTypeKey){
		return parserRegistry.get(parserTypeKey).toArray(new Class[]{});
		}
	}//end ParserRegistry
