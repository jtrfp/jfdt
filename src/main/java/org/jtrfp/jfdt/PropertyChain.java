/*******************************************************************************
 * This file is part of the JAVA FILE DESCRIPTION TOOLKIT (JFDT)
 * A library for parsing files and mapping their data to/from java Beans.
 * Copyright (c) 2012 Chuck Ritola
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
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.jtrfp.jfdt;

import java.util.LinkedList;

/**
 * Experimental class. Not relevant to jfdt1
 * @author Chuck Ritola
 *
 */
public class PropertyChain
	{
	LinkedList<PropertyChainElement> chain = new LinkedList<PropertyChainElement>();
	
	public PropertyChainElement getPrecedingElement(PropertyChainElement elm)
		{
		int index=chain.indexOf(elm);
		if(index!=0)return chain.get(index-1);
		return null;
		}
	public PropertyChainElement getNextElement(PropertyChainElement elm)
		{
		int index=chain.indexOf(elm);
		if(index!=chain.size()-1)return chain.get(index+1);
		return null;
		}
	
	public class PropertyChainElement
		{
		public PropertyChain getParent(){return PropertyChain.this;}
		String propertyName;
		StartPointDeterminator spd=	new DefaultStartPointDeterminator();
		LengthDeterminator lnd;
		}//end PropertyChainElement
	
	public static abstract class StartPointDeterminator
		{
		PropertyChainElement parent;
		public void setParent(PropertyChainElement p){parent=p;}
		public abstract long getStartPointInBytes();
		}//end StartPointDeterminator
	
	public static abstract class LengthDeterminator
		{
		PropertyChainElement parent;
		public void setParent(PropertyChainElement p){parent=p;}
		public abstract long getLengthInBytes();
		}//end SizeDeterminator
	
	public static class DefaultStartPointDeterminator extends StartPointDeterminator
		{

		@Override
		public long getStartPointInBytes()
			{
			PropertyChainElement elm = parent.getParent().getPrecedingElement(parent);
			return elm.spd.getStartPointInBytes()+elm.lnd.getLengthInBytes();
			}//end getStartPointInBytes()
		}//end DefaultStartPointDeterminator
	
	}//end PropertyChain
