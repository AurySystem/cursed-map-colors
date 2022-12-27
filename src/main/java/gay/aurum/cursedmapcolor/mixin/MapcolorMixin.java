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

//    @ModifyArgs(at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Blocks;register(Ljava/lang/String;Lnet/minecraft/block/Block;)Lnet/minecraft/block/Block;"),method = "<clinit>()V")
//    private static void inject(Args args){
//        if(Objects.equals(args.get(0), "black_concrete")){
//            args.set(0, "black_concrete");
//            args.set(1, new Block(AbstractBlock.Settings.of(Material.STONE, CursedMapColor.TRUEBLACK).requiresTool().strength(1.8F)));
//        }
//        if(Objects.equals(args.get(0), "black_wool")){
//            args.set(0, "black_wool");
//            args.set(1, new Block(AbstractBlock.Settings.of(Material.WOOL, CursedMapColor.OTHERBLACK).strength(0.8F).sounds(BlockSoundGroup.WOOL)));
//        }
//        CursedMapColor.LOGGER.debug("aa");
//    }
//    @Inject(at = @At("RETURN"), method = "<clinit>()V")
//    private static void injecth(CallbackInfo ci){
//
//    }
}
