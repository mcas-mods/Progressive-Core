package de.lellson.progressivecore.integration.jei;

import de.lellson.progressivecore.inv.container.ContainerSmelter;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.minecraft.inventory.Slot;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmelterRecipeTransferInfo implements IRecipeTransferInfo<ContainerSmelter> {

    private int level;

    public SmelterRecipeTransferInfo(int level) {
        this.level = level;
    }

    @Override
    public Class<ContainerSmelter> getContainerClass() {
        return ContainerSmelter.class;
    }

    @Override
    public String getRecipeCategoryUid() {
        return SmelterCategory.getUid(this.level);
    }

    @Override
    public boolean canHandle(ContainerSmelter containerSmelter) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(ContainerSmelter containerSmelter) {
        return IntStream.range(0,6).mapToObj(containerSmelter::getSlot).collect(Collectors.toList());
    }

    @Override
    public List<Slot> getInventorySlots(ContainerSmelter containerSmelter) {
        return IntStream.range(8, containerSmelter.inventorySlots.size()).mapToObj(containerSmelter::getSlot).collect(Collectors.toList());
    }
}
