/*
 * Copyright (c) IntellectualCrafters - 2014.
 * You are not allowed to distribute and/or monetize any of our intellectual property.
 * IntellectualCrafters is not affiliated with Mojang AB. Minecraft is a trademark of Mojang AB.
 *
 * >> File = plugin.java
 * >> Generated by: Citymonstret at 2014-08-09 01:42
 */

package com.intellectualcrafters.plot.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.intellectualcrafters.plot.PlayerFunctions;
import com.intellectualcrafters.plot.PlotMain;

public class plugin extends SubCommand {

	public plugin() {
		super("plugin", "plots.use", "Show plugin information", "plugin", "pl",
				CommandCategory.INFO);
	}

	@Override
	public boolean execute(final Player plr, String... args) {
		Bukkit.getScheduler().runTaskAsynchronously(
				JavaPlugin.getPlugin(PlotMain.class), new Runnable() {
					@Override
					public void run() {
						ArrayList<String> strings = new ArrayList<String>() {
							{
								String downloads = getInfo("https://intellectualsites.com/spigot_api.php?method=downloads&url=http://www.spigotmc.org/resources/plotsquared.1177/"), version = getInfo("https://intellectualsites.com/spigot_api.php?method=version&resource=1177");
								add(String.format(
										"&c>> &6PlotSquared (Version: %s)",
										PlotMain.getMain().getDescription()
												.getVersion()));
								add(String
										.format("&c>> &6Made by Citymonstret and Empire92"));
								add(String
										.format("&c>> &6Download at &lhttp://i-s.link/ps"));
								add(String.format(
										"&c>> &cNewest Version (Spigot): %s",
										version));
								add(String.format(
										"&c>> &cTotal Downloads (Spigot): %s",
										downloads));
							}
						};
						for (String s : strings) {
							PlayerFunctions.sendMessage(plr, s);
						}
					}
				});
		return true;
	}

	/**
	 *
	 * @param link
	 * @return
	 */
	private String getInfo(String link) {
		try {
			URLConnection connection = new URL(link).openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/4.0");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String document = "", line;
			while ((line = reader.readLine()) != null) {
				document += (line + "\n");
			}
			reader.close();
			return document;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
