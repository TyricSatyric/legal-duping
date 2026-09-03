package com.thesatyric.legalduping;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ClientPayloadHandler {
    public static void handleDupePacket(DupePacketC2S dupePacketC2S, IPayloadContext context) {
        if(context.player().getInventory().getFreeSlot() >= 0)
        {
            context.player().addItem(dupePacketC2S.item());
        }
        else {
            context.player().drop(dupePacketC2S.item(), true);
        }
    }
}
