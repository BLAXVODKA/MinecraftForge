/*
 * Minecraft Forge
 * Copyright (c) 2016-2018.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.common.extensions;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.tags.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorldReader;

public interface IForgeFluidState
{
    default IFluidState getFluidState()
    {
        return (IFluidState)this;
    }

    /**
     * Called when the entity is inside this block, may be used to determined if the entity can breathing,
     * display material overlays, or if the entity can swim inside a block.
     *
     * @param world that is being tested.
     * @param pos position thats being tested.
     * @param entity that is being tested.
     * @param yToTest, primarily for testingHead, which sends the the eye level of the entity, other wise it sends a y that can be tested vs liquid height.
     * @param material to test for.
     * @param testingHead when true, its testing the entities head for vision, breathing ect... otherwise its testing the body, for swimming and movement adjustment.
     */
    @Nullable
    default boolean isEntityInside(IWorldReader world, BlockPos pos, Entity entity, double yToTest, Tag<Fluid> tag, boolean testingHead)
    {
        return getFluidState().func_206886_c().isEntityInside(getFluidState(), world, pos, entity, yToTest, tag, testingHead);
    }



    /**
     * Location sensitive version of getExplosionResistance
     *
     * @param world The current world
     * @param pos Block position in world
     * @param exploder The entity that caused the explosion, can be null
     * @param explosion The explosion
     * @return The amount of the explosion absorbed.
     */
    default float getExplosionResistance(IWorldReader world, BlockPos pos, @Nullable Entity exploder, Explosion explosion)
    {
        return getFluidState().func_206886_c().getExplosionResistance(getFluidState(), world, pos, exploder, explosion);
    }
}