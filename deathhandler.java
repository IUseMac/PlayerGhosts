package IUseMac.listener;

import IUseMac.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class deathhandler implements Listener {

    private static Main plugin;

    public deathhandler(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();

        if (p.isDead()) {
            p.setGameMode(GameMode.ADVENTURE);
            p.setCanPickupItems(false);
            p.setFlying(true);
            for (Player toHide : Bukkit.getServer().getOnlinePlayers()) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                        player.hidePlayer(plugin, player);
                    }
                }
            }
        }
    }
