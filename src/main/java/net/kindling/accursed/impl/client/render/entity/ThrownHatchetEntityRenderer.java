package net.kindling.accursed.impl.client.render.entity;

import net.kindling.accursed.impl.entity.ThrownHatchetEntity;
import net.kindling.accursed.impl.index.AccursedDataComponents;
import net.kindling.accursed.impl.index.AccursedEtchings;
import net.kindling.accursed.impl.index.AccursedItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public class ThrownHatchetEntityRenderer extends EntityRenderer<ThrownHatchetEntity, ThrownHatchetEntityRenderState> {
    protected ThrownHatchetEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public void render(ThrownHatchetEntityRenderState renderState, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        ItemStack stack = new ItemStack(AccursedItems.TWISTED_HATCHET);
        stack.set(AccursedDataComponents.STORED_ETCHING, AccursedEtchings.VANITY);
        ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();


        matrices.push();
//
//        ItemRenderer.renderItem(
//                ItemDisplayContext.THIRD_PERSON_RIGHT_HAND,
//                matrices,
//                MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers(),
//                1,
//                OverlayTexture.DEFAULT_UV,
//                3
//                1,
//                RenderLayers.cutout(),
//                ItemRenderState.Glint.NONE
//        );

        matrices.pop();

        super.render(renderState, matrices, queue, cameraState);
    }

    public ThrownHatchetEntityRenderState createRenderState() {
        return new ThrownHatchetEntityRenderState();
    }
}
