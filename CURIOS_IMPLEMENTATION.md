# Curios Compatibility Implementation

This document describes the Curios compatibility implementation for all 16 custom Elytra items in the Feur Shadow Elytra mod.

## Overview

All 16 custom Elytra items now support:
- Equipping in the Curios Elytra slot
- Proper wing rendering when equipped via Curios
- Full flight mechanics from the Curios slot
- Recognition by Curios and Mine & Slash mods
- Preservation of all vanilla Elytra properties

## Implementation Details

### 1. Custom Elytra Item Class

**File:** `src/main/java/com/yourname/feurshadowelytra/item/CurioElytraItem.java`

- Extends `ElytraItem` to maintain all vanilla Elytra functionality
- Implements `ICurioItem` interface from Curios API
- Each item stores its texture name for rendering
- Implements required Curios methods:
  - `canEquip()` - allows equipping in Curios slot
  - `canUnequip()` - allows unequipping from Curios slot
  - `canEquipFromUse()` - allows equipping via right-click
  - `curioTick()` - handles per-tick logic (defers to vanilla)
  - `getAttributeModifiers()` - provides attribute modifiers (none needed)

### 2. Curios Renderer

**File:** `src/main/java/com/yourname/feurshadowelytra/client/CurioElytraRenderer.java`

- Implements `ICurioRenderer` from Curios API
- Uses vanilla `ElytraModel` for correct wing rendering
- Dynamically loads textures based on the equipped item
- Handles foil/enchantment glint rendering
- Properly syncs with entity animations

### 3. Client Handler

**File:** `src/main/java/com/yourname/feurshadowelytra/client/ClientHandler.java`

- Registers the Curios renderer for all 16 Elytra items
- Initializes the Elytra model using vanilla ModelLayers
- Handles client-side setup events

### 4. Item Registration

**File:** `src/main/java/com/yourname/feurshadowelytra/ModItems.java`

All 16 items are now registered with `CurioElytraItem` instead of vanilla `ElytraItem`:
- princess_elytra
- phoenix_elytra
- angel_elytra
- black_dragon_elytra
- white_dragon_elytra
- steam_elytra
- leaf_elytra
- fairy_elytra
- parrot_elytra
- owl_elytra
- river_elytra
- light_elytra
- fire_elytra
- western_elytra
- rainbow_elytra
- flowering_elytra

### 5. Resource Files

**Slot Definition:** `src/main/resources/data/curios/slots/elytra.json`
- Defines the Curios Elytra slot with size 1
- Configured for single-slot usage
- Enables render toggle

**Item Tags:** `src/main/resources/data/curios/tags/items/elytra.json`
- Already present, tags all 16 items for Curios Elytra slot

**Wing Textures:** `src/main/resources/assets/feur_shadow_elytra/textures/entity/wings/`
- All 16 wing textures copied from wings/ directory
- Used by Curios renderer for proper 3D wing display

### 6. Dependencies

**Build Configuration:** `build.gradle`
- Added Curios maven repository
- Added Curios API dependency: `top.theillusivec4.curios:curios-forge:5.4.5+1.20.1`

**Mod Metadata:** `src/main/resources/META-INF/mods.toml`
- Declared Curios as optional dependency
- Ensures proper load ordering

## How It Works

1. **Vanilla Armor Slot**: Items continue to work normally in the chest armor slot, inheriting all vanilla Elytra behavior.

2. **Curios Elytra Slot**: 
   - Items can be equipped in the Curios Elytra slot via right-click or by dragging
   - The custom renderer ensures the wings appear correctly on the player's back
   - Flight mechanics work identically to vanilla (triggered by jumping while falling)
   - Durability decreases normally when flying

3. **Rendering**:
   - When equipped in Curios slot, the renderer uses the vanilla Elytra model
   - Texture is dynamically loaded based on the item's texture name
   - Animations sync with player movement and flight state

4. **Compatibility**:
   - Works with Mine & Slash and other mods that check for Curios slots
   - Items are tagged in Curios item tags for automatic recognition
   - No conflicts with vanilla Elytra behavior

## Testing Notes

To verify the implementation works correctly:

1. Install Curios API mod alongside this mod
2. Open the Curios inventory (default: C key)
3. Place any custom Elytra in the Elytra slot
4. Verify the wings render on the player's back
5. Jump off a height and activate flight (press jump while falling)
6. Confirm flight works and durability decreases
7. Try all 16 different Elytra types to verify textures load correctly

## Compatibility

- **Forge Version**: 1.20.1-47.2.0+
- **Curios API Version**: 5.4.5+1.20.1
- **Java Version**: 17

## Files Modified/Created

### Java Files (Code)
- `src/main/java/com/yourname/feurshadowelytra/item/CurioElytraItem.java` (NEW)
- `src/main/java/com/yourname/feurshadowelytra/client/CurioElytraRenderer.java` (NEW)
- `src/main/java/com/yourname/feurshadowelytra/client/ClientHandler.java` (NEW)
- `src/main/java/com/yourname/feurshadowelytra/ModItems.java` (MODIFIED)

### Resource Files
- `build.gradle` (MODIFIED - added Curios dependency)
- `src/main/resources/META-INF/mods.toml` (MODIFIED - added Curios as optional dependency)
- `src/main/resources/data/curios/slots/elytra.json` (NEW)
- `src/main/resources/data/curios/tags/items/elytra.json` (EXISTING - already had all items)
- `src/main/resources/assets/feur_shadow_elytra/textures/entity/wings/*.png` (NEW - 16 textures)

### Configuration
- `.gitignore` (NEW - excludes build artifacts)
