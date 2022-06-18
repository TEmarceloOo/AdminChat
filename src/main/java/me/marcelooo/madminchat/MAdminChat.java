package me.marcelooo.madminchat;

import me.marcelooo.madminchat.cmds.AdminChat;
import org.bukkit.plugin.java.JavaPlugin;

public final class MAdminChat extends JavaPlugin {

    public static MAdminChat main;



    @Override
    public void onEnable() {
        // Plugin startup logic

        main = this;

        new AdminChat(this);

    }

    public static MAdminChat getMain() {
        return main;
    }

}
