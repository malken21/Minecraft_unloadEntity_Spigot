package marumasa.unload_entity;

import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);
        getServer().getPluginManager().registerEvents(new eventListener(config, this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
