package com.yourname.feurshadowelytra.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class ClientHandler {

    // 렌더러 인스턴스 필드
    private ICurioRenderer renderer;

    // 렌더러 등록 메서드 예시
    public void registerRenderers(Minecraft minecraft) {
        ModelPart elytraModelPart = minecraft.getEntityModels().bakeLayer(ElytraModel.LAYER_LOCATION);
        renderer = new CurioElytraRenderer(
            new ResourceLocation("feur_shadow_elytra:textures/entity/elytra/angel_elytra.png"),
            elytraModelPart
        );
        // 필요하면 여러 Elytra별로 renderer 생성 및 등록
    }

    public ICurioRenderer getRenderer() {
        return renderer;
    }
}
