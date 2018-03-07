package com.facebook.video.chromecast.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat.Builder;

/* compiled from: login_from_msite */
public class NotificationHelper {
    public static final Class<?> f9704b = NotificationHelper.class;
    public NotificationManager f9705a;
    private final int f9706c = 1;
    public Builder f9707d;
    public boolean f9708e;

    public NotificationHelper(Context context) {
        this.f9707d = new Builder(context);
        this.f9708e = false;
        this.f9705a = (NotificationManager) context.getSystemService("notification");
    }
}
