package asad.irteza.notifiaction;

import android.app.AlarmManager;
import java.util.Calendar;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,53);
        calendar.set(Calendar.SECOND,3);

        setupAlarm(calendar);
    }

    public void setupAlarm(Calendar calendar){
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Intent intent = new Intent("asad.irteza.action.DISPLAY_NOTIFICATION");
        PendingIntent broadcast = PendingIntent.getBroadcast(this,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),broadcast);
    }
}
