# 🎮 Broken Ranks Profession Bot

![PULSEMIND BANNER](https://pulsemind.pl/image/BANNER.png)

[![Discord](https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white)](https://discord.com/)
[![Broken Ranks](https://img.shields.io/badge/Broken%20Ranks-FF4646?style=for-the-badge)](https://brokenranks.com/)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg?style=for-the-badge)](https://www.gnu.org/licenses/gpl-3.0)

A powerful Discord bot that brings your Broken Ranks professions into your Discord server! Automatically adds in-game professions as Discord roles and allows players to manage them with simple commands.

## ✨ Features

- 💬 Easy-to-use `/profession` command for role management
- ⚔️ Supports all Broken Ranks professions
- 🛡️ Secure role management system
- 🇺🇸 Supports English language
- 🇵🇱 Supports Polish language

## 💻 Usage

### Commands

- `/profession` - Assign profession roles to users based on their Broken Ranks character

Example:

```
/profession <in-game profession name>
```

### Available Professions

- <img src="professions/fire_mage.png" alt="Fire Mage" width="20" height="20"> Fire Mage
- <img src="professions/barbarian.png" alt="Barbarian" width="20" height="20"> Barbarian
- <img src="professions/archer.png" alt="Archer" width="20" height="20"> Archer
- <img src="professions/sheed.png" alt="Sheed" width="20" height="20"> Sheed
- <img src="professions/druid.png" alt="Druid" width="20" height="20"> Druid
- <img src="professions/knight.png" alt="Knight" width="20" height="20"> Knight
- <img src="professions/voodoo.png" alt="Voodoo" width="20" height="20"> Voodoo

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Gradle
- Discord Bot Token
- Discord Server with administrator permissions

### Installation

1. Clone the repository

```bash
git clone https://github.com/PulseMind/brokenranks-discord-roles.git
```

2. Go to Discord Bot files

```bash
cd ./discord-bot
```

3. Build the project

```bash
./gradlew build
```

4. Configure your environment variables

```bash
cp .env.example .env
# Edit .env file with your Discord Bot Token and settings.
```

5. Start the bot

```bash
./gradlew run
```

## 🤝 Contributing

Contributions are welcome! Feel free to:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 🗺️ Roadmap (TODO List)

- Full language support for English & Polish (I should add in next commit)
- Setting up the bot on a VPS server
- Creating a public website for the bot
- The first released version of the bot for public use

## 📝 License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details. This means:

- ✅ You can use this code commercially
- ✅ You can modify this code
- ✅ You can distribute this code
- ✅ You can use this code privately
- ✅ You can use patent claims
- ❗ You MUST disclose the source code when distributing
- ❗ You MUST state changes to the code
- ❗ You MUST distribute under the same license
- ❗ You MUST include copyright and license notices

## 🌟 Acknowledgments

- Thanks to the Broken Ranks community
- All contributors who help improve this bot
- JDA (Java Discord API) team for their amazing library

## 📞 Support

If you need help or want to report a bug:

- Create an issue in this repository
- Contact me directly on Discord: `pulsemindpl`

---

Made with ❤️ for the Broken Ranks community
