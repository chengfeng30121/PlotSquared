/*
 * Copyright (c) IntellectualCrafters - 2014.
 * You are not allowed to distribute and/or monetize any of our intellectual property.
 * IntellectualCrafters is not affiliated with Mojang AB. Minecraft is a trademark of Mojang AB.
 *
 * >> File = LSetCube.java
 * >> Generated by: Citymonstret at 2014-08-09 01:43
 */

package com.intellectualcrafters.plot;

import org.bukkit.Location;

/**
 * Cube utilities
 *
 * @author Citymonstret
 *
 */
public class LSetCube {

	/**
	 * Base locations
	 */
	private Location l1, l2;

	/**
	 * Constructor
	 * 
	 * @param l1
	 * @param l2
	 */
	public LSetCube(Location l1, Location l2) {
		this.l1 = l1;
		this.l1 = l2;
	}

	/**
	 * Secondary constructor
	 * 
	 * @param l1
	 * @param size
	 */
	public LSetCube(Location l1, int size) {
		this.l1 = l1;
		this.l2 = l1.clone().add(size, size, size);
	}

	/**
	 * Returns the absolute min. of the cube
	 * 
	 * @return abs. min
	 */
	public Location minLoc() {
		int x = Math.min(this.l1.getBlockX(), this.l2.getBlockX());
		int y = Math.min(this.l1.getBlockY(), this.l2.getBlockY());
		int z = Math.min(this.l1.getBlockZ(), this.l2.getBlockZ());
		return new Location(this.l1.getWorld(), x, y, z);
	}

	/**
	 * Returns the absolute max. of the cube
	 * 
	 * @return abs. max
	 */
	public Location maxLoc() {
		int x = Math.max(this.l1.getBlockX(), this.l2.getBlockX());
		int y = Math.max(this.l1.getBlockY(), this.l2.getBlockY());
		int z = Math.max(this.l1.getBlockZ(), this.l2.getBlockZ());
		return new Location(this.l1.getWorld(), x, y, z);
	}

	/**
	 * Creates a LCycler for the cube.
	 * 
	 * @return new lcycler
	 */
	public LCycler getCycler() {
		return new LCycler(this);
	}

	/**
	 * @author Citymonstret
	 */
	protected class LCycler {
		/**
		 *
		 */
		private Location min;
		/**
		 *
		 */
		private Location max;
		/**
		 *
		 */
		private Location current;

		/**
		 * 
		 * @param cube
		 */
		public LCycler(LSetCube cube) {
			this.min = cube.minLoc();
			this.max = cube.maxLoc();
			this.current = this.min;
		}

		/**
		 * 
		 * @return
		 */
		public boolean hasNext() {
			return ((this.current.getBlockX() + 1) <= this.max.getBlockX())
					&& ((this.current.getBlockY() + 1) <= this.max.getBlockY())
					&& ((this.current.getBlockZ() + 1) <= this.max.getBlockZ());
		}

		/**
		 * 
		 * @return
		 */
		public Location getNext() {
			if (!hasNext()) {
				return null;
			}
			this.current = this.current.add(1, 1, 1);
			return this.current;
		}
	}
}
