package ctn.ctntemplate.events.entity.player;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * 玩家相关事件
 */
@EventBusSubscriber()
public class PlayerEvents {
    /**
     * 保存玩家属性
     */
    @SubscribeEvent
    public static void save(PlayerEvent.SaveToFile event) {
        Player player = event.getEntity();
    }

    /**
     * 加载玩家-此时客户端玩家未创建
     */
    @SubscribeEvent
    public static void loading(PlayerEvent.LoadFromFile event) {
        Player player = event.getEntity();
    }


    /**
     * 登录到世界-此时客户端玩家已创建
     */
    @SubscribeEvent
    public static void loggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (player instanceof ServerPlayer serverPlayer) {
        }
    }

    /**
     * 玩家重生或维度切换后
     */
    @SubscribeEvent
    public static void reset(PlayerEvent.Clone event) {
        Player player = event.getEntity();
        // 如果玩家是因为死亡...
        if (event.isWasDeath()) {
        }
    }

    @SubscribeEvent
    public static void tick(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        CompoundTag nbt = player.getPersistentData();
        if (player instanceof ServerPlayer serverPlayer) {

        }
    }
}
