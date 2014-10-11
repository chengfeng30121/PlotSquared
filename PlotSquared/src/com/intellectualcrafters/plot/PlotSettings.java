/*
 * Copyright (c) IntellectualCrafters - 2014.
 * You are not allowed to distribute and/or monetize any of our intellectual property.
 * IntellectualCrafters is not affiliated with Mojang AB. Minecraft is a trademark of Mojang AB.
 *
 * >> File = PlotSettings.java
 * >> Generated by: Citymonstret at 2014-08-09 01:44
 */

package com.intellectualcrafters.plot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.block.Biome;

/**
 * plot settings
 *
 * @author Citymonstret
 *
 */
public class PlotSettings {
	/**
	 * merged plots
	 */
	private boolean[] merged = new boolean[] { false, false, false, false };
	/**
	 * plot alias
	 */
	private String alias;
	/**
	 * plot biome
	 */
	private Biome biome;
	/**
	 * plot rain
	 */
	private boolean rain;
	/**
	 *
	 */
	private Set<Flag> flags;
	/**
	 * plot time
	 */
	private Long time;
	/**
	 * Change time?
	 */
	private boolean changeTime;
	private PlotHomePosition position;

	/**
	 * Constructor
	 * 
	 * @param plot
	 */
	public PlotSettings(Plot plot) {
		this.alias = "";
	}

	/**
	 * <b>Check if the plot is merged in a direction</b><br>
	 * 0 = North<br>
	 * 1 = East<br>
	 * 2 = South<br>
	 * 3 = West<br>
	 * 
	 * @param direction
	 * @return boolean
	 */
	public boolean getMerged(int direction) {
		return this.merged[direction];
	}

	public boolean isMerged() {
		return (this.merged[0] || this.merged[1] || this.merged[2] || this.merged[3]);
	}

	public boolean[] getMerged() {
		return this.merged;
	}

	public void setMerged(boolean[] merged) {
		this.merged = merged;
	}

	public void setMerged(int direction, boolean merged) {
		this.merged[direction] = merged;
	}

	/**
	 * 
	 * @param b
	 */
	public void setBiome(Biome b) {
		this.biome = b;
	}

	/**
	 * 
	 * @param b
	 */
	public void setTimeChange(boolean b) {
		this.changeTime = b;
	}

	/**
	 * 
	 * @param l
	 */
	public void setTime(long l) {
		this.time = l;
	}

	/**
	 * 
	 * @return
	 * @deprecated
	 */
	@Deprecated
	public Biome getBiome() {
		return this.biome;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getRain() {
		return this.rain;
	}

	public void setRain(boolean b) {
		this.rain = b;
	}

	/**
	 * 
	 * @return
	 */
	public long getTime() {
		return this.time;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getChangeTime() {
		return this.changeTime;
	}

	/**
	 * 
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * 
	 * @param flag
	 */
	public void addFlag(Flag flag) {
		Flag hasFlag = getFlag(flag.getKey());
		if (hasFlag != null) {
			this.flags.remove(hasFlag);
		}
		this.flags.add(flag);
	}

	/**
	 * 
	 * @param flags
	 */
	public void setFlags(Flag[] flags) {
		this.flags = new HashSet<Flag>(Arrays.asList(flags));
	}

	/**
	 * 
	 * @return
	 */
	public Set<Flag> getFlags() {
		return this.flags;
	}

	/**
	 * 
	 * @param flag
	 * @return
	 */
	public Flag getFlag(String flag) {
		for (Flag myflag : this.flags) {
			if (myflag.getKey().equals(flag)) {
				return myflag;
			}
		}
		return null;
	}

	public PlotHomePosition getPosition() {
		return this.position;
	}

	public void setPosition(PlotHomePosition position) {
		this.position = position;
	}

	public String getAlias() {
		return this.alias;
	}

	public String getJoinMessage() {
		return "";
	}

	public String getLeaveMessage() {
		return "";
	}
}
