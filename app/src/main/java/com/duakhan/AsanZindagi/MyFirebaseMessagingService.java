package com.duakhan.AsanZindagi;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull  RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        getFirebaseMessages(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }
    public void getFirebaseMessages(String title, String msg){
        NotificationCompat.Builder builder =new NotificationCompat.Builder(this,"myservicechannel")
                .setSmallIcon(R.drawable.my_logo)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true);

        NotificationManagerCompat manager=NotificationManagerCompat.from(this);
        manager.notify(101,builder.build());



    }
}
