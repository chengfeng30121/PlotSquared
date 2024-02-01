package com.plotsquared.bukkit;

import com.plotsquared.bukkit.util.BukkitUtil;
import com.plotsquared.core.command.MainCommand;
import com.plotsquared.core.configuration.Settings;
import com.plotsquared.core.player.ConsolePlayer;
import com.plotsquared.core.player.PlotPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.ProxiedCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BukkitCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(
            CommandSender commandSender, Command command, String commandLabel,
            String[] args
    ) {
        if (commandSender instanceof Player) {
            return MainCommand.onCommand(BukkitUtil.adapt((Player) commandSender), args);
        }
        if (commandSender instanceof ConsoleCommandSender
                || commandSender instanceof ProxiedCommandSender
                || commandSender instanceof RemoteConsoleCommandSender) {
            return MainCommand.onCommand(ConsolePlayer.getConsole(), args);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(
            CommandSender commandSender, Command command, String label,
            String[] args
    ) {
        if (!(commandSender instanceof Player)) {
            return null;
        }
        PlotPlayer<?> player = BukkitUtil.adapt((Player) commandSender);
        if (args.length == 0) {
            return Collections.singletonList("plots");
        }
        if (!Settings.Enabled_Components.TAB_COMPLETED_ALIASES.contains(label.toLowerCase(Locale.ENGLISH))) {
            return List.of();
        }
        Collection<com.plotsquared.core.command.Command> objects =
                MainCommand.getInstance().tab(player, args, label.endsWith(" "));
        if (objects == null) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (com.plotsquared.core.command.Command o : objects) {
            result.add(o.toString());
        }
        return result;
    }

}
