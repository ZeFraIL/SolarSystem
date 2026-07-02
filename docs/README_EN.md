📱 Android Application Documentation (LEVEL 10/10)
________________________________________
🧾 General Information
Project Name:
SolarSystem
Author(s):
Zeev Fraiman
Date:
July 2026
Language:
Java
Development Environment:
Android Studio
Android Version (minSdk / targetSdk):
28 / 35
________________________________________
🎯 Project Goals
• Goal: Visualization of planetary motion in the Solar System in real-time and for a specific date.
• Importance: Helps to visually understand the principles of orbital motion and relative planet positions.
• Target Audience: Students, pupils, and astronomy enthusiasts.
________________________________________
📌 Application Requirements
Functional Requirements
• Display of the Sun and 8 planets.
• Animation of planetary motion along orbits.
• Setting planet positions based on a selected date.
• Viewing brief information about a planet upon tapping.
• Splash screen at startup.
Non-functional Requirements
• Performance: Smooth graphics rendering (60 FPS).
• Usability: Intuitive interface with three control buttons.
• Reliability: Stable performance on Android versions from Oreo (API 28) to Android 15 (API 35).
________________________________________
🧠 General Architecture
• Approach:
– Simple View-Controller (MVC)

• Why this approach: The project is graphically oriented, and direct interaction between Activity and Custom View ensures minimal latency and simplicity of implementation.

• Main System Components:
– Activity (Start, MainActivity)
– Custom View (SolarSystemView)
________________________________________
🧩 UML Diagram
[Start] --(2 sec)--> [MainActivity]
[MainActivity] <--> [SolarSystemView]
[SolarSystemView] --(drawing)--> [Canvas]
________________________________________
Explanation:
The `zeev.fraiman.solarsystem` package groups all application components. For future scaling, `ui`, `model`, and `view` packages can be introduced.
________________________________________
🧩 Detailed Class Descriptions
📌 Class: Start
Role: Splash Screen.
Responsibility: Creating a welcome interface and transitioning to the main screen after 2 seconds.
Main Methods:
- onCreate() — Screen initialization and starting CountDownTimer.
Interaction with other classes: Launches MainActivity via Intent.
________________________________________
📌 Class: MainActivity
Role: Main UI Controller.
Responsibility: Handling button clicks (Start, Stop, Date) and managing the state of SolarSystemView.
Main Methods:
- onCreate() — Binding UI components and setting event listeners.
Interaction with other classes: Controls SolarSystemView methods.
________________________________________
📌 Class: SolarSystemView
Role: Visualization Core.
Responsibility: Calculating planet coordinates based on time/date and drawing them on Canvas. Handling touch events to show information.
Why it is used: Custom drawing is necessary for dynamic orbital system display.
________________________________________
🔄 Application Workflow Diagram
Scenario:
1. User opens the app (Start Activity).
2. After 2 seconds, MainActivity opens.
3. User taps "START", planets begin to move.
4. User taps on a planet, an information dialog appears.
5. User selects a date via "DATE", planet positions are updated.
________________________________________
🎨 UI/UX Analysis
• Why the interface is designed this way: A minimalist design on a black background simulates outer space.
• Principles used:
– Simplicity: Only three control buttons.
– Logic: Buttons are located at the bottom, not obstructing the graphics.
– Accessibility: Large control elements.
• Improvements: Add pinch-to-zoom and more detailed planet textures.
________________________________________
⚙️ Threading
Description:
- invalidate() loop in the main thread for animation.
• Why this method: For simple 2D animations, the invalidate() method is standard and efficient.
• Prevention of:
– Hangs (ANR): Trigonometry calculations are fast and do not block the thread.
– Memory leaks: Standard Activity lifecycles are used.
________________________________________
💾 Data Management
• Data Storage: Constants in the SolarSystemView class (orbital periods, radii).
• Why this method: Data is static and doesn't require an external database.
• Ensuring:
– Safety: Data is hardcoded.
– Correctness: Astronomically based period ratios are used.
________________________________________
🌐 Networking
• Not used. The application works completely offline.
________________________________________
🔐 Security (Basic Level)
• No sensitive data is involved.
________________________________________
🧪 Testing
• Types of tests:
– Unit tests: Angle calculation logic verification (basic stubs).
– UI tests: MainActivity launch verification via Espresso.
________________________________________
🐞 Error Handling
• Handling of invalid dates is provided.
________________________________________
⚡ Performance
• Optimizations: Direct drawing on Canvas without heavy layout hierarchies.
• Potential bottlenecks: Could occur if hundreds of objects are added.
________________________________________
🚀 Scalability
• Adding moons (satellites).
• Real-scale distances and sizes.
• Integration with APIs for live astronomical data.
________________________________________
📊 Project Self-Assessment
Criterion | Rating (1–10)
---|---
Architecture | 8
Code | 9
UI/UX | 8
Reliability | 10
Overall Level | 9
________________________________________
🏁 Conclusion
• Best features: Smooth animation and accurate position calculations.
• Challenges: Syncing animation time with real orbital periods.
• Skills acquired: Custom View development, working with Canvas and trigonometry in Android.
________________________________________
📎 Appendices
• Repository links: [Link goes here]