# feur_shadow_elytra (Independent)

Forge **1.20.1** / Java **17**. Elytra-type wing items that render embedded wing textures (no dependency on other mods).  
All wing items are `ElytraItem`. When equipped, a client render layer draws 2D sprite wings behind the player.

## Build
```bash
# Java 17 required
./gradlew build
```
Jar will be at `build/libs/feur_shadow_elytra-1.0.0.jar`.

## Run in Dev (optional)
```bash
./gradlew runClient
```

## Add/Change Wings
- Register a new item in `ModItems`.
- Add an item model under `assets/feur_shadow_elytra/models/item/<name>.json` (points to `textures/item/*.png`).
- Put the wing texture under `assets/feur_shadow_elytra/textures/wings/`.
- Map the item id to texture file in `assets/feur_shadow_elytra/elytra_textures.json`.

## Notes
- Textures are used with permission from the original author.
- If you want animated/3D wings instead of sprite wings, port the original model class and swap `SpriteWingsLayer` with a custom model-based layer.
