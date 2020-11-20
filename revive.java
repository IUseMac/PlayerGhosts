package commands;

import IUseMac.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class revive implements CommandExecutor {

    private Main plugin;

    public revive(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("revive").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only Players can execute this Command!");
            return true;
        }
        Player p = (Player) sender;

        if (p.hasPermission("playerghosts.revive")) {
            if (args.length == 1) {
                String playerName = args[0];
                Player player = Bukkit.getServer().getPlayer(playerName);
                if (player == null) {
                    p.sendMessage(playerName + " is not Online!");
                    return true;
                } else {
                    player.setGameMode(GameMode.SURVIVAL);
                    p.setCanPickupItems(true);
                    p.setFlying(false);
                    Location location  = player.getLocation();
                    location.setX(0);
                    location.setY(70);
                    location.setZ(0);
                    player.teleport(location);
                    for (Player toHide : Bukkit.getServer().getOnlinePlayers()) {
                        for (Player playere : Bukkit.getOnlinePlayers()) {
                            playere.showPlayer(plugin, playere);
                        }
                    }
                    p.sendMessage("Revived " + playerName);
                }
            } else {
                p.sendMessage("Invalid Command!");
            }
        } else {
            p.sendMessage("You do not have permission to execute this Command!");
        }
        return true;
    }
}
