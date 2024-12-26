package zeev.fraiman.solarsystem;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Calendar;

public class SolarSystemView extends View {
    private Paint paint;
    private boolean isAnimating = false;
    private long animationStartTime;
    private float[] planetX, planetY;
    private float[] orbitRadii;
    private double[] currentAngles;
    private String[] planetNames = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
    private double[] orbitalPeriods = {88, 225, 365, 687, 4333, 10759, 30689, 60190}; // Дни
    private static final long ANIMATION_YEAR_DURATION = 300*60 * 1000;

    public SolarSystemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        planetX = new float[8];
        planetY = new float[8];
        orbitRadii = new float[8];
        currentAngles = new double[8];
        for (int i = 0; i < orbitRadii.length; i++) {
            orbitRadii[i] = 100 + (i + 1) * 50;
        }
        setPlanetsByDate(System.currentTimeMillis());
    }

    public void startAnimation() {
        isAnimating = true;
        animationStartTime = System.currentTimeMillis();
        invalidate();
    }

    public void stopAnimation() {
        isAnimating = false;
        invalidate();
    }

    public void setPlanetsByDate(long dateMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateMillis);

        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        for (int i = 0; i < planetX.length; i++) {
            double angle = 2 * Math.PI * (dayOfYear % orbitalPeriods[i]) / orbitalPeriods[i];
            currentAngles[i] = angle;
            planetX[i] = (float) (getWidth() / 2 + orbitRadii[i] * Math.cos(angle));
            planetY[i] = (float) (getHeight() / 2 + orbitRadii[i] * Math.sin(angle));
        }
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 50, paint);

        long elapsed = isAnimating ? System.currentTimeMillis() - animationStartTime : 0;

        for (int i = 0; i < planetX.length; i++) {
            if (isAnimating) {
                double angleOffset = 2 * Math.PI * elapsed / (ANIMATION_YEAR_DURATION * orbitalPeriods[i] / 365);
                currentAngles[i] += angleOffset;
            }
            planetX[i] = (float) (getWidth() / 2 + orbitRadii[i] * Math.cos(currentAngles[i]));
            planetY[i] = (float) (getHeight() / 2 + orbitRadii[i] * Math.sin(currentAngles[i]));
        }

        for (int i = 0; i < planetX.length; i++) {
            paint.setColor(Color.GREEN);
            canvas.drawCircle(planetX[i], planetY[i], 20, paint);
            paint.setColor(Color.WHITE);
            canvas.drawText(planetNames[i], planetX[i] - 20, planetY[i] - 30, paint);
        }

        if (isAnimating) {
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (int i = 0; i < planetX.length; i++) {
                if (Math.hypot(event.getX() - planetX[i], event.getY() - planetY[i]) < 20) {
                    showPlanetInfo(i);
                    return true;
                }
            }
        }
        return super.onTouchEvent(event);
    }

    private void showPlanetInfo(int planetIndex) {
        new android.app.AlertDialog.Builder(getContext())
                .setTitle(planetNames[planetIndex])
                .setMessage("Information about " + planetNames[planetIndex])
                .setPositiveButton("OK", null)
                .show();
    }
}
