package shawn.c4q.nyc.background_notifications;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by shawnspeaks on 12/4/16.
 */

public class NotificationService extends IntentService {

    private static final String SERVICE_NAME = "service";

    public NotificationService(){
        super(SERVICE_NAME);
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        int NOTIFICATION_ID = 555; // Setting a notification ID allows you to update the notification later on.

        Intent intent_99 = new Intent(this, SecondActivity.class);
        int requestID = (int) System.currentTimeMillis();
        int flags = PendingIntent.FLAG_CANCEL_CURRENT;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent_99, flags);

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification: TITLE")
                .setContentText("I'm a working notification text!")
                .setContentIntent(pendingIntent)
                .setAutoCancel(false)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
