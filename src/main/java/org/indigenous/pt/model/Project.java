package org.indigenous.pt.model;

import java.io.Serializable;

public class Project implements Serializable {

	/**
	 * Generated Serial Version UId.
	 */
	private static final long serialVersionUID = 3174131247692503396L;

	private long id;

	private String name;

	private String shortName;

	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
