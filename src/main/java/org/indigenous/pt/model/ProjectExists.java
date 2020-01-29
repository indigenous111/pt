package org.indigenous.pt.model;

import java.io.Serializable;

public class ProjectExists implements Serializable {

	/**
	 * Generated Serial Version UId.
	 */
	private static final long serialVersionUID = -1440062981421227777L;
	
	private boolean exists;

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

}
