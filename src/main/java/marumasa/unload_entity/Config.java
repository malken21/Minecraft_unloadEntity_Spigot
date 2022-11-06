package marumasa.unload_entity;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public final String[] removeList;

    public Config(minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        removeList = config.getStringList("removeList").toArray(new String[0]);
    }
}