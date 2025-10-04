# Feur Shadow Elytra - Curios Compatible

A Minecraft Forge mod that adds 16 beautifully themed custom Elytra with full Curios API integration.

## 🎮 Features

### 16 Unique Custom Elytra
Each with its own unique wing texture and theme:

| Elytra | Theme | Elytra | Theme |
|--------|-------|--------|-------|
| 👑 Princess | Royal/Pink | 🔥 Phoenix | Fire Bird |
| 😇 Angel | Holy/White | 🐉 Black Dragon | Dark Dragon |
| 🐲 White Dragon | Light Dragon | ⚙️ Steam | Steampunk |
| 🍃 Leaf | Nature/Green | 🧚 Fairy | Magical |
| 🦜 Parrot | Colorful Bird | 🦉 Owl | Brown Bird |
| 🌊 River | Water/Blue | ✨ Light | Glowing |
| 🔥 Fire | Flames | 🐉 Western | Western Dragon |
| 🌈 Rainbow | Multi-color | 🌸 Flowering | Floral |

### 🎯 Full Curios Integration
- ✅ Equip in Curios Elytra slot
- ✅ Works alongside vanilla chest armor slot
- ✅ Custom wing textures render correctly in Curios slot
- ✅ Flight mechanics work from Curios slot
- ✅ Compatible with Mine & Slash and other Curios-aware mods

### 🌟 Vanilla Compatibility
- ✅ Maintains all vanilla Elytra properties
- ✅ Durability system preserved (432 durability per Elytra)
- ✅ Repairable with Phantom Membranes
- ✅ Enchantable (Unbreaking, Mending, etc.)
- ✅ Works with dispensers for auto-equipping
- ✅ Enchantment glint renders correctly

## 📋 Requirements

### Required
- **Minecraft:** 1.20.1
- **Forge:** 47.2.0 or higher
- **Java:** 17

### Optional (for Curios features)
- **Curios API:** 5.4.5+1.20.1

## 🔧 Installation

1. Install Minecraft Forge 1.20.1-47.2.0 or higher
2. Download and install Curios API (optional but recommended)
3. Download this mod
4. Place the mod JAR file in your `mods` folder
5. Launch Minecraft

## 🎮 How to Use

### Vanilla Armor Slot
1. Equip any custom Elytra in your chest armor slot
2. Jump off a height and press jump while falling to activate flight
3. Enjoy your custom wings!

### Curios Elytra Slot (with Curios API installed)
1. Press the Curios hotkey (default: C)
2. Place any custom Elytra in the Elytra slot
3. Close the inventory
4. Your custom wings will appear on your back!
5. Flight works the same as vanilla

## 📦 Building from Source

```bash
# Clone the repository
git clone https://github.com/jenga-sudo/elytra-feur-v1.git
cd elytra-feur-v1

# Build the mod
./gradlew build

# The JAR will be in build/libs/
```

## 📚 Documentation

- **[CURIOS_IMPLEMENTATION.md](CURIOS_IMPLEMENTATION.md)** - Detailed technical documentation of the Curios integration
- **[TESTING_GUIDE.md](TESTING_GUIDE.md)** - Comprehensive testing procedures with 11 test cases
- **[QUICK_REFERENCE.md](QUICK_REFERENCE.md)** - Quick reference guide for developers and users

## 🏗️ Technical Details

### Implementation Highlights
- Custom `CurioElytraItem` class extends `ElytraItem` and implements `ICurioItem`
- Dedicated `CurioElytraRenderer` for proper wing rendering in Curios slot
- Uses vanilla `ElytraModel` for accurate animations
- Dynamic texture loading based on equipped item
- Client-side event handling for renderer registration

### File Structure
```
src/main/java/com/yourname/feurshadowelytra/
├── FeurShadowElytra.java           # Main mod class
├── ModItems.java                   # Item registration
├── ModCreative.java                # Creative tab integration
├── item/
│   └── CurioElytraItem.java       # Custom Elytra item with Curios support
└── client/
    ├── ClientHandler.java         # Client-side event handling
    └── CurioElytraRenderer.java   # Curios renderer

src/main/resources/
├── META-INF/mods.toml             # Mod metadata
├── data/
│   ├── curios/
│   │   ├── slots/elytra.json      # Curios slot definition
│   │   └── tags/items/elytra.json # Curios item tags
│   ├── forge/tags/items/elytra.json
│   └── minecraft/tags/items/elytra.json
└── assets/feur_shadow_elytra/
    ├── textures/
    │   ├── entity/wings/          # Wing textures for Curios rendering
    │   ├── wings/                 # Original wing textures
    │   └── item/                  # Item icons
    ├── models/item/               # Item models
    └── lang/                      # Translations (en_us, ko_kr)
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for bugs and feature requests.

## 📄 License

All Rights Reserved

## 🙏 Credits

- **Mod Author:** yourname
- **Curios API:** TheIllusiveC4
- **Minecraft Forge:** Forge Development Team

## 📞 Support

For issues or questions:
1. Check the [TESTING_GUIDE.md](TESTING_GUIDE.md)
2. Review the [CURIOS_IMPLEMENTATION.md](CURIOS_IMPLEMENTATION.md)
3. Open an issue on GitHub

## 🔄 Version History

### v1.0.0
- Initial release
- Added 16 custom Elytra items
- Full Curios API integration
- Compatible with Minecraft 1.20.1

## 🎯 Future Plans

- Additional Elytra designs
- More customization options
- Texture variants
- Special effects for certain Elytra

---

**Made with ❤️ for the Minecraft community**
