package marumasa.unload_entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.EntitiesUnloadEvent;

import java.util.logging.Logger;

public class eventListener implements Listener {

    private final Config con;
    private final Logger logger;

    public eventListener(Config config, minecraft minecraft) {
        con = config;
        logger = minecraft.getLogger();
    }

    @EventHandler
    public void onEntity(EntitiesUnloadEvent event) {
        for (Entity entity : event.getEntities()) {
            final String entity_name = entity.getName();
            for (String config_name : con.removeList) {
                // もしアンロードしたエンティティの名前がconfigに書いてあるエンティティと一致したら
                if (entity_name.equalsIgnoreCase(config_name)) {
                    //エンティティをremoveする
                    final Location loc = entity.getLocation();
                    // ログ出力
                    logger.info(String.format("Remove %s x:%d y:%d z:%d",
                            entity_name,
                            loc.getBlockX(),
                            loc.getBlockY(),
                            loc.getBlockZ()
                    ));
                    entity.remove();
                    break;
                }
            }
        }
    }
}