# Class Description: Start

## 1. General Information
*   **Class Name:** `Start`
*   **Type:** Activity
*   **Purpose:** Acts as the initial screen (Splash Screen) of the application. Its task is to show a welcome window and automatically switch the user to the main screen after a set time.
*   **Interaction:** Launches `MainActivity` using the `Intent` system.

---

## 2. Variables (Class Fields)
There are no global variables (class fields) in this class. Only local objects inside methods are used.

---

## 3. Class Methods

### Method: `onCreate(Bundle savedInstanceState)`
*   **Method Type:** `protected`
*   **Return Value:** `void`
*   **Parameters:**
    *   `savedInstanceState` (`Bundle`): An object containing data to restore the state after a restart.
*   **Detailed Logic:**
    1.  Calls the base constructor `super.onCreate`.
    2.  Sets the visual interface from the `activity_start` file.
    3.  Creates and starts a `CountDownTimer` for 2000 milliseconds (2 seconds).
    4.  In the timer's `onFinish()` method (when time is up), an `Intent` is created—a special "intention" to move from the current screen to `MainActivity`.
    5.  Executes `startActivity(go)`, which effectively opens the new screen.
*   **When called:** Automatically by the Android system when the app is launched.
*   **Important to understand:** The timer runs in the background, so it doesn't "freeze" the UI during these 2 seconds.

---

## 4. Lifecycle (Activity)
*   **`onCreate()`:**
    *   **When called:** At the very beginning of the Activity creation.
    *   **What happens:** UI initialization and starting the transition timer.

---

## 5. UI Interaction
*   **Elements:** Uses the `R.layout.activity_start` layout.
*   **Code connection:** Set via `setContentView`. Usually contains a logo or project name.

---

## 6. Interaction with other components
*   **Transitions:** Uses `Intent` to transition to `MainActivity`. This is the standard way to navigate between screens in Android.

---

## 7. General Class Logic
The class works as a "placeholder" before entering the main part of the application. Scenario: launch -> show image -> wait 2 sec -> transition to main screen.

---

## 8. Simple Explanation
Imagine you are entering a restaurant. `Start` is the hostess at the entrance who says "Welcome!" and after a couple of seconds leads you to the main hall (`MainActivity`). She doesn't cook the food; her job is simply to greet you.

---
### Improvement Tips:
The code uses `CountDownTimer`. While this works, a better practice is to use `Handler` or the modern Splash Screen API, and also call the `finish()` method after starting `MainActivity` so the user cannot return to the splash screen by pressing the "Back" button.