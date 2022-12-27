package gay.aurum.cursedmapcolor.mixin;

import gay.aurum.cursedmapcolor.CursedMapColor;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.Objects;

@Mixin(Blocks.class)
public abstract class MapcolorMixin {

    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=black_concrete"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/Block;*",
                    ordinal = 0
            ),
            method = "<clinit>")
    private static Block concrete(AbstractBlock.Settings settings) {
        return new Block(FabricBlockSettings.copyOf(settings).mapColor(CursedMapColor.TRUEBLACK));
    }
    @Redirect(
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=black_wool"
                            },
                            ordinal = 0
                    )
            ),
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/block/Block;*",
                    ordinal = 0
            ),
            method = "<clinit>")
    private static Block wool(AbstractBlock.Settings settings) {
        return new Block(FabricBlockSettings.copyOf(settings).mapColor(CursedMapColor.OTHERBLACK));
    }

}
