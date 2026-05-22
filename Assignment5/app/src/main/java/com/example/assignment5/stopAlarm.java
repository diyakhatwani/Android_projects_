package com.example.assignment5;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class stopAlarm  extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(AlarmService.mediaPlayer!=null){
            AlarmService.mediaPlayer.stop();
            AlarmService.mediaPlayer.release();
            AlarmService.mediaPlayer=null;
        }
        NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        manager.cancel(1);
    }
}
