package net.mightyegg.pushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnShow, btnClear;
    NotificationManager manager;
    Notification myNotication;
    int notificationId = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
    }

    void showNotification(){
        //SecondActivity = Activity that come when user click on notification
        Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, intent, 0);
        Notification.Builder builder = new Notification.Builder(MainActivity.this);

        builder.setAutoCancel(false);
        builder.setTicker("this is ticker text");
        builder.setContentTitle("WhatsApp Notification");
        builder.setContentText("You have a new message");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(false); //swipe control
        builder.setSubText("This is subtext...");   //API level 16
        builder.setNumber(100);
        builder.build();
        myNotication = builder.getNotification();
        manager.notify(notificationId, myNotication);
    }
    void cancleNotification(){
        manager.cancel(notificationId);
    }

    private void initialise() {
        btnShow = (Button) findViewById(R.id.btnShowNotification);
        btnClear = (Button) findViewById(R.id.btnClearNotification);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showNotification();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                cancleNotification();
            }
        });
    }
}