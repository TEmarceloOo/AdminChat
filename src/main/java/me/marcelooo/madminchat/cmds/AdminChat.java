package me.marcelooo.madminchat.cmds;

import me.marcelooo.madminchat.MAdminChat;
import me.marcelooo.madminchat.chatcolors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChat extends chatcolors implements CommandExecutor {

    MAdminChat plugin;

    public AdminChat(MAdminChat m) {
        plugin = m;
        m.getCommand("ac").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        Player p = (Player) sender;

        if (p.hasPermission("m.adminchat")) {
            if (args.length > 0) {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }

                String msg = sb.toString().replace("&", "§");

                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (players.hasPermission("m.adminchat")) {
                        players.sendMessage(color("&8[&4Admin&cChat&8] &7 " + p.getDisplayName() + " &8>> &c " + msg));
                    }
                }

            } else {
                p.sendMessage(color("&8[&4Admin&cChat&8] &8>> &7Correct usage is: &c/ac <message>"));
            }
        } else {
            p.sendMessage(color("&8[&4Admin&cChat&8] &8>> &7You do not have &cpermission &7to execute this command."));
        }

        return false;
    }
}
