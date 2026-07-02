# Class Description: MainActivity

## 1. General Information
*   **Class Name:** `MainActivity`
*   **Type:** Activity
*   **Purpose:** The main control screen of the application. It connects the user interface (buttons) with the planet display logic.
*   **Interaction:** Manages the `SolarSystemView` object by sending commands for animation or date changes.

---

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `solarSystemView` | `SolarSystemView` | Object for rendering the system | In control methods (start/stop/date) |
| `bStart` | `Button` | Button to start animation | In `onCreate` to set click listener |
| `bStop` | `Button` | Button to stop animation | In `onCreate` to set click listener |
| `bDate` | `Button` | Button to select a date | In `onCreate` to set click listener |

---

## 3. Class Methods

### Method: `onCreate(Bundle savedInstanceState)`
*   **Method Type:** `protected`
*   **Return Value:** `void`
*   **Parameters:**
    *   `savedInstanceState` (`Bundle`): State data.
*   **Detailed Logic:**
    1.  Initializes the Activity and sets the `activity_main` layout.
    2.  Finds all UI components (buttons and drawing area) by their ID.
    3.  Sets click listeners (`setOnClickListener`):
        *   Start Button: Tells `solarSystemView` to start moving the planets.
        *   Stop Button: Stops the movement.
        *   Date Button: Creates a calendar popup (`DatePickerDialog`). When a date is selected, the calendar converts it to milliseconds, and this data is passed to `solarSystemView` to redraw the planets.
*   **When called:** When the main application screen is opened.

---

## 4. Lifecycle (Activity)
*   **`onCreate()`:** The main entry point. All connections between buttons and code are configured here.

---

## 5. UI Interaction
*   **Elements:** `Button` (3 units), `SolarSystemView` (custom area).
*   **Code connection:** Uses the `findViewById(R.id...)` method.
*   **Events:** Handles button clicks via lambda expressions `v -> ...`.

---

## 6. Interaction with other components
*   Uses `DatePickerDialog`—a standard system dialog for date selection.

---

## 7. General Class Logic
This class is the "conductor". It doesn't know how to draw planets itself, but it knows when to give the command to "start" or "show positions for April 12th".

---

## 8. Simple Explanation
Imagine that `MainActivity` is a TV remote control. The buttons on the remote are the buttons on the screen, and the TV screen itself is `SolarSystemView`. When you press the "Channel+" button, the remote sends a signal to the TV to switch. Similarly, here: pressing the "Start" button sends a "start animation" signal to the drawing area.

---
### Improvement Tips:
The code uses `findViewById`. In modern Android, it is recommended to switch to `ViewBinding` to avoid errors when searching for elements by ID and to make the code cleaner.