/*
 * Copyright (c) IntellectualCrafters - 2014. You are not allowed to distribute
 * and/or monetize any of our intellectual property. IntellectualCrafters is not
 * affiliated with Mojang AB. Minecraft is a trademark of Mojang AB.
 *
 * >> File = Settings.java >> Generated by: Citymonstret at 2014-08-09 01:44
 */

package com.intellectualcrafters.plot;

/**
 * Updater and DB settings
 *
 * @author Citymonstret
 * @author Empire92
 */
public class Settings {
    
    public static boolean MOB_CAP_ENABLED = false;
    public static int MOB_CAP = 20;
    
    public static boolean TITLES                      = true;
    /**
     * Schematic Save Path
     */
    public static String  SCHEMATIC_SAVE_PATH         = "/var/www/schematics";
    /**
     * Max allowed plots
     */
    public static int     MAX_PLOTS                   = 20;
    /**
     * WorldGuard region on claimed plots
     */
    public static boolean WORLDGUARD                  = false;
    /**
     * metrics
     */
    public static boolean METRICS                     = true;
    /**
     * plot specific resource pack
     */
    public static String  PLOT_SPECIFIC_RESOURCE_PACK = "";
    /**
     * Kill road mobs?
     */
    public static boolean KILL_ROAD_MOBS;
    /**
     * Default kill road mobs: true
     */
    public static boolean KILL_ROAD_MOBS_DEFAULT      = true;
    /**
     * mob pathfinding?
     */
    public static boolean MOB_PATHFINDING;
    /**
     * Default mob pathfinding: true
     */
    public static boolean MOB_PATHFINDING_DEFAULT     = true;
    /**
     * Delete plots on ban?
     */
    public static boolean DELETE_PLOTS_ON_BAN         = false;
    /**
     * Verbose?
     */
    public static boolean DEBUG                       = true;
    /**
     * Auto clear enabled
     */
    public static boolean AUTO_CLEAR                  = false;
    /**
     * Days until a plot gets cleared
     */
    public static int     AUTO_CLEAR_DAYS             = 365;
    /**
     * API Location
     */
    public static String  API_URL                     = "http://www.intellectualsites.com/minecraft.php";
    /**
     * Use the custom API
     */
    public static boolean CUSTOM_API                  = true;

    /**
     * Database settings
     *
     * @author Citymonstret
     */
    public static class DB {
        /**
         * MongoDB enabled?
         */
        public static boolean USE_MONGO  = false;      /*
         * TODO: Implement Mongo
         * @Brandon
         */
        /**
         * SQLite enabled?
         */
        public static boolean USE_SQLITE = false;
        /**
         * MySQL Enabled?
         */
        public static boolean USE_MYSQL  = true;       /* NOTE: Fixed connector */
        /**
         * SQLite Database name
         */
        public static String  SQLITE_DB  = "storage";
        /**
         * MySQL Host name
         */
        public static String  HOST_NAME  = "localhost";
        /**
         * MySQL Port
         */
        public static String  PORT       = "3306";
        /**
         * MySQL DB
         */
        public static String  DATABASE   = "plot_db";
        /**
         * MySQL User
         */
        public static String  USER       = "root";
        /**
         * MySQL Password
         */
        public static String  PASSWORD   = "password";
        /**
         * MySQL Prefix
         */
        public static String  PREFIX     = "";
    }
}
