package shawn.c4q.nyc.background_notifications;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchTestService();




}
    public void launchTestService(){
        Intent i = new Intent(this, NotificationService.class);
        startService(i);
    }


}
