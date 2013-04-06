/* file 	: 	DemoApplication.java
 * created 	:	Dec 29, 2005
 * modified :	
 */

package com.neodem.sandbox.common.command;

import com.neodem.common.command.ApplicationException;
import com.neodem.common.command.BaseApplication;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class DemoApplication extends BaseApplication {

	public static void main(String[] args) {
		run(new DemoApplication(), args);
	}
	
	/**
	 * 
	 */
	public DemoApplication() {
		super();
		setShowHelpOnNoArgs(true);
		setShowTimer(true);
	}


	/* (non-Javadoc)
	 * @see com.neodem.common.command.BaseApplication#execute()
	 */
	protected void execute() throws ApplicationException {
		System.out.println("hello");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			throw new ApplicationException(e);
		}
	}

}
