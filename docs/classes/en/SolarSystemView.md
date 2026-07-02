# Class Description: SolarSystemView

## 1. General Information
*   **Class Name:** `SolarSystemView`
*   **Type:** Custom View
*   **Purpose:** This is the "heart" of the visualization. The class is responsible for the mathematical calculations of planetary positions and their direct rendering on the screen.
*   **Interaction:** Receives commands from `MainActivity` and reacts to user touches.

---

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `paint` | `Paint` | "Brush" for drawing | In `onDraw` to set colors and styles |
| `isAnimating` | `boolean` | Flag: whether planets are moving now | In `onDraw` to enable calculations |
| `planetX / planetY` | `float[]` | Coordinate arrays (X and Y) for 8 planets | In `onDraw` and `setPlanetsByDate` |
| `orbitRadii` | `float[]` | Orbital radii | In `init` and coordinate calculation |
| `currentAngles` | `double[]` | Current rotation angles in radians | Main variable for animation |
| `orbitalPeriods` | `double[]` | Orbital period of each planet (in days) | To calculate movement speed |
| `planetNames` | `String[]` | Planet names | For on-screen labels |

---

## 3. Class Methods

### Method: `onDraw(Canvas canvas)`
*   **Method Type:** `protected`
*   **Return Value:** `void`
*   **Parameters:** `canvas` (`Canvas`) — the "canvas" we draw on.
*   **Logic:**
    1.  Fills the background with black.
    2.  Draws a yellow Sun in the center.
    3.  If animation is on, calculates the angle planets should move based on elapsed time.
    4.  Converts polar coordinates (radius and angle) to Cartesian (X and Y) using `cos` and `sin` functions.
    5.  Draws planets (green circles) and their names.
    6.  If animation is active, calls `invalidate()`, which forces Android to immediately redraw the screen again. This creates a smooth motion effect.

### Method: `setPlanetsByDate(long dateMillis)`
*   **Method Type:** `public`
*   **Parameters:** `dateMillis` — date in milliseconds format.
*   **Logic:** Calculates the day of the year from the date and sets planet angles to match that day relative to their orbital periods.

---

## 4. Lifecycle
Since this is a `View`, the main stages are:
1.  **Constructor / init:** Object creation and initial calculations.
2.  **onDraw:** Continuous image update loop (during animation).

---

## 5. UI Interaction
*   **`onTouchEvent` method:** Tracks finger touches. If the touch coordinate matches a planet's coordinate, `showPlanetInfo` is called, which opens a dialog box.

---

## 6. Interaction with other components
*   Uses `AlertDialog.Builder` to create popup windows with information.

---

## 7. General Class Logic
The class works as an infinite drawing loop. We know that the Earth orbits the Sun in 365 days. We translate these "days" into "animation milliseconds". In each frame, we slightly increase the angle of each planet and redraw them in new positions.

---

## 8. Simple Explanation
Imagine that `SolarSystemView` is an artist drawing a cartoon in a flipbook. To make the planets "come alive", he must draw one page after another very quickly, moving the planet just a little bit each time. The Sun is the center of the page, and the planets run around it in circles like athletes in a stadium, only each has its own speed.

---
### Notes:
*   **Math:** Remember that `Math.cos` and `Math.sin` work with radians (from 0 to 2π), not degrees.
*   **Optimization:** Calling `invalidate()` inside `onDraw` is a simple way to animate, but for very complex games, it's better to use `SurfaceView`.