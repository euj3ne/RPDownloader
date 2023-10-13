package ru.euj3ne.rpdownloader;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import us.myles.ViaVersion.api.Via;
import us.myles.ViaVersion.api.ViaAPI;

public class ViaVersion
implements Listener {
    ViaAPI<?> api = Via.getAPI();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        int i = this.api.getPlayerVersion(e.getPlayer().getUniqueId());
        String version = null;

        if (i > 3 && i <= 5) {
            version = "1.7.x";
        }
        if (i == 47) {
            version = "1.8.x";
        }
        if (i >= 103 && i <= 110) {
            version = "1.9.x";
        }
        if (i == 210) {
            version = "1.10.x";
        }
        if (i == 314 || i == 316) {
            version = "1.11.x";
        }
        if (i > 327 && i <= 340) {
            version = "1.12.x";
        }
        if (i > 340 && i <= 404) {
            version = "1.13.x";
        }
        if (i > 404 && i <= 498) {
            version = "1.14.x";
        }
        if (i > 565 && i <= 578) {
            version = "1.15.x";
        }
        if (i > 721 && i <= 754) {
            version = "1.16.x";
        }
        if (i == 755 || i == 756) {
            version = "1.17.x";
        }
        if (i == 757 || i == 758) {
            version = "1.18.x";
        }
        if (i > 759 && i <= 762) {
            version = "1.19.x";
        }
        if (i == 763 || i == 764) {
            version = "1.20.x";
        }
        if (version == null) {
            version = "0x";
        }
        String data = Main.instance.getConfig().getString(version);
        String[] info = data.split(" : ");
        Bukkit.getScheduler().runTaskLater((Plugin)Main.instance, () -> ((CraftPlayer)e.getPlayer()).getHandle().setResourcePack(info[0], info[1]), (long)Main.instance.getConfig().getInt("delay"));
    }
}
