package ru.euj3ne.rpdownloader;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
extends JavaPlugin
implements Listener {
    public static JavaPlugin instance;
    public static Logger log;
    public void onEnable() {
        instance = this;
        log = this.getLogger();
        log.info("Загрузка плагина " + this.getName());
        if (Bukkit.getServer().getPluginManager().getPlugin("ProtocolSupport") != null) {
            log.info("Найден плагин ProtocolSupport, используем его для получения версий.");
            Bukkit.getPluginManager().registerEvents((Listener)new ProtocolSupport(), (Plugin)instance);
        } else if (Bukkit.getServer().getPluginManager().getPlugin("ViaVersion") != null) {
            log.info("Найден плагин ViaVersion, используем его для получения версий.");
            Bukkit.getPluginManager().registerEvents((Listener)new ViaVersion(), (Plugin)instance);
        } else {
            log.warning("В сборке вашего сервера не обнаружены необходимые плагины. (ProtocolSupport или ViaVersion)");
            Bukkit.getPluginManager().disablePlugin((Plugin)this);
        }
        this.getCommand("resourcepack").setExecutor((CommandExecutor)new Commands());
        log.info("Плагин " + this.getName() + " успешно загружен.");
        this.saveDefaultConfig();
    }
}
