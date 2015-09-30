package org.lukedowell.exampleapp.shared.entities;

/**
 * Describes a single sql entity
 * @author Luke Dowell	
 *
 */
public abstract class Entity {

	/** This entity's id */
	protected int id;
	
	public Entity() {
		// TODO Auto-generated constructor stub
	}
	
	public Entity(int id) {
		this.id = id;
	}

	/**
	 * Grabs the entity's key 
	 * @return 
	 * 	The id
	 */
	public int getId() {
		return id;
	}
}
