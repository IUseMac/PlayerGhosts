package IUseMac;

import IUseMac.listener.deathhandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        super.onEnable();
        new commands.revive(this);
        new deathhandler(this);
        getServer().getConsoleSender().sendMessage("[PlayerGhosts] by IUseMac has been Enabled!");
    }
    @Override
    public void onDisable() {
        super.onDisable();
        getServer().getConsoleSender().sendMessage("[PlayerGhosts] by IUseMac has been Disabled!");
    }
}