# 🎯 Guess The Number Game

A fun and interactive **Number Guessing Game** developed using **Core Java** and **Java Swing GUI**.

The player has to guess the secret number with the help of hints provided by the game.

---

## 🚀 Features

- 🎮 GUI Based Game
- 🔢 Random Number Generation
- 📈 Higher / Lower Hint System
- 🎯 Multiple Difficulty Levels
- ⚙ Custom Difficulty Option
- 🔁 Play Again Functionality
- ❌ Cancel Game Support
- ⚠ Input Validation & Error Handling

---

## 🛠 Technologies Used

- Core Java
- Java Swing
- AWT
- Event Handling

---

## 📂 Project Structure

```bash
GuessNumber/
│
├── src/
│   └── GuessNumber.java
│
└── README.md

## 🎮 Difficulty Levels
Difficulty	Range
Very Easy	0 - 3
Easy	0 - 50
Medium	0 - 100
Hard	0 - 500
Very Hard	0 - 1000
Custom	User Defined
🧠 Main Game Logic
Random Number Generation
Secret = (int)((Math.random()) * (diff + 1));
Guess Checking Logic
if(Guess > Secret)
    Guess Lower...
else if(Guess < Secret)
    Guess Higher...
▶️ How To Run
Compile
javac GuessNumber.java
Run
java GuessNumber
🖥 GUI Screens
Main Menu
Difficulty Selection Window
Guess Input Dialog
Winner Popup
Instructions Window
About Window
🎯 How To Play
Click New Game
Choose a difficulty level
Guess the secret number
Follow hints:
📈 Guess Higher
📉 Guess Lower
Win the game 🎉
🔄 Version History
v2.3 → Fixed win message bug
v2.2 → Improved instruction message
v2.1 → Updated winner message
v2.0 → Added difficulty change feature
v1.8 → Cancel button support added
v1.7 → Added About section
v1.6 → Added Play Again feature
v1.5 → Added Instructions button
v1.2 → Added tries counter
v1.1 → Added Exit button
v1.0 → GUI version released
v0.5 → Basic guessing logic added
📌 Advantages

✔ Beginner Friendly Java Project
✔ Interactive Swing GUI
✔ Easy to Understand Logic
✔ Good Practice for Event Handling
✔ Improves Java GUI Concepts

📌 Resume Description
Short Description

Developed a GUI-based Guess The Number Game using Core Java and Java Swing with multiple difficulty levels and interactive gameplay.

Professional Description

Designed and developed a desktop-based Guess The Number Game using Core Java, Java Swing, and Event Handling concepts. Implemented random number generation, difficulty management, input validation, and interactive GUI components.

💡 Future Enhancements
🏆 Score System
⏱ Timer Feature
🔊 Sound Effects
🌙 Dark Mode
👥 Multiplayer Mode
📊 Leaderboard
👩‍💻 Author

Vijaylaxmi Hatte

⭐ Support

If you like this project, give it a ⭐ on GitHub.
