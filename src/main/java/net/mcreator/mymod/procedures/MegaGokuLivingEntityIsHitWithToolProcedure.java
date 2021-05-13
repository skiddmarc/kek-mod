package net.mcreator.mymod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.mymod.MymodModElements;
import net.mcreator.mymod.MymodMod;

import java.util.Map;

@MymodModElements.ModElement.Tag
public class MegaGokuLivingEntityIsHitWithToolProcedure extends MymodModElements.ModElement {
	public MegaGokuLivingEntityIsHitWithToolProcedure(MymodModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MymodMod.LOGGER.warn("Failed to load dependency entity for procedure MegaGokuLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MymodMod.LOGGER.warn("Failed to load dependency world for procedure MegaGokuLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(
					Vector3d.copyCenteredHorizontally(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
	}
}
