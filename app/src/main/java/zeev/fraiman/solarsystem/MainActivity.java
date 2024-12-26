package zeev.fraiman.solarsystem;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// MainActivity.java
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private SolarSystemView solarSystemView;
    private Button bStart, bStop, bDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solarSystemView = findViewById(R.id.solarSystemView);
        bStart = findViewById(R.id.bStart);
        bStop = findViewById(R.id.bStop);
        bDate = findViewById(R.id.bDate);

        bStart.setOnClickListener(v -> solarSystemView.startAnimation());
        bStop.setOnClickListener(v -> solarSystemView.stopAnimation());

        bDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (view, year, month, dayOfMonth) -> {
                        calendar.set(year, month, dayOfMonth);
                        solarSystemView.setPlanetsByDate(calendar.getTimeInMillis());
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        });
    }
}
