package mrc.dev;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CordHideAchievements extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        this.getLogger().warning("Сделано для CordWorld.ru");
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    private void hideAdvancementsFor(World world) {
        world.setGameRuleValue("announceAdvancements", "false");
        this.getLogger().info("Достижения теперь скрыты для мира '" + world.getName() + "'.");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onWorldLoad(WorldLoadEvent event) {
        hideAdvancementsFor(event.getWorld());
    }
}
