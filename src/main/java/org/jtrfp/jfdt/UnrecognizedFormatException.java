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


public class UnrecognizedFormatException extends RuntimeException{
    /**
     * Thrown whenever a parser has difficulty parsing (understanding) the source data or constructing it.
     * This may have a cause related to some internal operation i.e. a NumberFormatException, or originally created by this framework.
     * In cases where multiple candidates for parsing are used and none are successful, all of the exceptions thrown
     * in the candidate process are stored as suppressed Throwables and will be included in printStackTrace().
     */
    private static final long serialVersionUID = -7718925826063941291L;
    public UnrecognizedFormatException(){super();}
    public UnrecognizedFormatException(String string)
    {super(string);}
    public UnrecognizedFormatException(String msg, Throwable cause)
    {super(msg,cause);}

    public UnrecognizedFormatException(Throwable cause) {
	super(cause);
    }
    @Override
    public void printStackTrace() {
	super.printStackTrace();
	final Throwable [] suppressed = getSuppressed();
	if(suppressed.length != 0) {
	    System.err.println("Suppressed stack traces: ");
	    for(Throwable t : suppressed)
		t.printStackTrace();
	}//end if(suppressed present)
    }//end printStackTrace()
}//end UnrecognizedFormatException
