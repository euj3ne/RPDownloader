package ru.euj3ne.rpdownloader;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands
        implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!label.equalsIgnoreCase("resourcepack")) {
            if (!label.equalsIgnoreCase("rp")) return true;
        }
        if (args.length == 0) {
            sender.sendMessage("");
            sender.sendMessage("§f[§eРесурсПак§f] §fДоступные команды:");
            sender.sendMessage("§f[§eРесурсПак§f] §fПерезагрузка плагина - §e/rp reload");
            sender.sendMessage("");
            return true;
        }
        if (!args[0].toLowerCase().equals("reload")) return true;
        Main.instance.reloadConfig();
        sender.sendMessage("");
        sender.sendMessage("§f[§eРесурсПак§f] §fКонфиг успешно перезагружен.");
        sender.sendMessage("");
        return true;
    }
}
