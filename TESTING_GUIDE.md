# Testing Guide for Curios Compatibility

This guide provides step-by-step instructions for testing the Curios compatibility implementation.

## Prerequisites

Before testing, ensure you have:
1. Minecraft 1.20.1
2. Forge 47.2.0 or higher
3. Curios API 5.4.5+1.20.1 or higher
4. This mod built and installed

## Installation

1. Build the mod:
   ```bash
   ./gradlew build
   ```

2. The mod jar will be in `build/libs/`

3. Install the following mods in your Minecraft mods folder:
   - Forge 1.20.1-47.2.0
   - Curios API 5.4.5+1.20.1
   - This mod (feur_shadow_elytra-1.0.0.jar)

## Test Cases

### Test 1: Basic Item Registration
**Objective:** Verify all 16 Elytra items exist and are accessible

**Steps:**
1. Launch Minecraft
2. Open Creative inventory
3. Go to Combat tab
4. Verify all 16 Elytra items are present:
   - Princess Elytra
   - Phoenix Elytra
   - Angel Elytra
   - Black Dragon Elytra
   - White Dragon Elytra
   - Steam Elytra
   - Leaf Elytra
   - Fairy Elytra
   - Parrot Elytra
   - Owl Elytra
   - River Elytra
   - Light Elytra
   - Fire Elytra
   - Western Elytra
   - Rainbow Elytra
   - Flowering Elytra

**Expected Result:** All 16 items appear in the Combat tab

---

### Test 2: Curios Slot Availability
**Objective:** Verify the Curios Elytra slot is available

**Steps:**
1. In-game, press the Curios hotkey (default: C)
2. Check for an Elytra slot in the Curios inventory

**Expected Result:** An Elytra slot is visible in the Curios menu

---

### Test 3: Vanilla Armor Slot Compatibility
**Objective:** Verify items work in the vanilla chest armor slot

**Steps:**
1. Pick any custom Elytra (e.g., Princess Elytra)
2. Equip it in the chest armor slot (vanilla method)
3. Jump off a height and activate flight (press jump while falling)
4. Observe the wings rendering on your back
5. Verify the Elytra takes durability damage while flying

**Expected Result:** 
- Wings render correctly with custom texture
- Flight works normally
- Durability decreases when flying

---

### Test 4: Curios Slot Equipping
**Objective:** Verify items can be equipped in the Curios Elytra slot

**Steps:**
1. Open Curios inventory (C key)
2. Take any custom Elytra
3. Place it in the Curios Elytra slot by:
   - Method A: Dragging and dropping
   - Method B: Right-clicking while holding the item
4. Verify the item appears in the slot

**Expected Result:** Item successfully equips in the Curios slot

---

### Test 5: Curios Slot Rendering
**Objective:** Verify wings render correctly when equipped via Curios

**Steps:**
1. Equip an Elytra in the Curios slot (not armor slot)
2. Close the inventory
3. Press F5 to switch to third-person view
4. Observe your character's back

**Expected Result:** 
- Wings are visible and render with the correct custom texture
- Wings should look identical to when equipped in armor slot

---

### Test 6: Curios Slot Flight Mechanics
**Objective:** Verify flight works from the Curios slot

**Steps:**
1. Equip an Elytra in the Curios slot (ensure armor slot is empty)
2. Jump off a high place
3. While falling, press the jump key to activate flight
4. Fly around for a few seconds
5. Check the Elytra's durability

**Expected Result:**
- Flight activates normally
- You can control flight direction
- Durability decreases while flying
- Flight mechanics are identical to vanilla

---

### Test 7: All 16 Texture Verification
**Objective:** Verify each custom texture renders correctly in Curios slot

**Steps:**
For each of the 16 Elytra items:
1. Equip in Curios slot
2. View in third-person (F5)
3. Verify the texture matches the item name
4. Repeat for all 16 items

**Expected Result:** Each item displays its unique wing texture

**Texture Checklist:**
- [ ] Princess (pink/royal theme)
- [ ] Phoenix (fiery/bird theme)
- [ ] Angel (white/holy theme)
- [ ] Black Dragon (dark/dragon theme)
- [ ] White Dragon (light/dragon theme)
- [ ] Steam (industrial/steampunk theme)
- [ ] Leaf (nature/green theme)
- [ ] Fairy (magical/glittery theme)
- [ ] Parrot (colorful/bird theme)
- [ ] Owl (brown/bird theme)
- [ ] River (water/blue theme)
- [ ] Light (bright/glowing theme)
- [ ] Fire (flame/red theme)
- [ ] Western (dragon/western theme)
- [ ] Rainbow (multi-color theme)
- [ ] Flowering (floral/nature theme)

---

### Test 8: Enchantment Glint
**Objective:** Verify enchantment glint renders correctly

**Steps:**
1. Enchant an Elytra with Unbreaking or Mending
2. Equip in Curios slot
3. View in third-person

**Expected Result:** Wings display the enchantment glint effect

---

### Test 9: Durability Display
**Objective:** Verify durability is displayed correctly

**Steps:**
1. Equip an Elytra in Curios slot
2. Hover over the item in the Curios inventory
3. Check tooltip for durability information
4. Fly to reduce durability
5. Check tooltip again

**Expected Result:** 
- Durability bar is visible
- Durability value updates after flying
- Tooltip shows correct durability numbers

---

### Test 10: Multiple Slot Test
**Objective:** Verify only one Elytra can be equipped at a time

**Steps:**
1. Equip an Elytra in the armor slot
2. Try to equip another Elytra in the Curios slot
3. Check which one takes priority for flight

**Expected Result:** Either:
- Both slots work (allowing redundancy)
- OR only one provides flight (need to verify Curios behavior)

---

### Test 11: Curios Integration with Other Mods
**Objective:** Verify Mine & Slash compatibility (if available)

**Steps:**
1. Install Mine & Slash mod (if compatible version exists)
2. Equip Elytra in Curios slot
3. Check if Mine & Slash recognizes the item

**Expected Result:** Mine & Slash sees the Elytra as equipped gear

---

## Known Limitations

- Build may not compile without proper ForgeGradle setup
- Testing requires in-game verification
- Some textures are placeholders and may need replacement

## Reporting Issues

If any test fails, please report:
1. Which test failed
2. Expected vs actual behavior
3. Game version and mod versions
4. Any error messages in logs
5. Screenshots if applicable

## Log Files

Check these files for errors:
- `logs/latest.log` - Current session log
- `logs/debug.log` - Detailed debug information

Look for errors containing:
- `feur_shadow_elytra`
- `curios`
- `CurioElytraItem`
- `CurioElytraRenderer`
