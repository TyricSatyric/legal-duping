package com.thesatyric.legalduping;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public record DupePacketC2S(ItemStack item) implements CustomPacketPayload {
    public static final Type<DupePacketC2S> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LegalDuping.MODID,
            "dupe_packet"));

    public static final StreamCodec<RegistryFriendlyByteBuf, DupePacketC2S> STREAM_CODEC = StreamCodec.composite(
            ItemStack.STREAM_CODEC,
            DupePacketC2S::item,

            DupePacketC2S::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
