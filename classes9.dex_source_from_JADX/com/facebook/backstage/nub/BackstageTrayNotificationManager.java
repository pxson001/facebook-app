package com.facebook.backstage.nub;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationManagerCompat;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: requestRouteToHostAddress */
public class BackstageTrayNotificationManager {
    private final Resources f5408a;
    private final NotificationManagerCompat f5409b;

    @Inject
    public BackstageTrayNotificationManager(Context context, Resources resources) {
        this.f5408a = resources;
        this.f5409b = NotificationManagerCompat.a(context);
    }

    public final void m5633a(Service service) {
        Preconditions.checkNotNull(service);
        CharSequence string = this.f5408a.getString(2131239901);
        Builder builder = new Builder(service);
        builder.j = -2;
        builder = builder;
        builder.d = PendingIntent.getService(service, 0, new Intent(service, BackstageService.class), 0);
        builder = builder;
        builder.w = "service";
        builder = builder;
        builder.v = true;
        service.startForeground(20004, builder.a(0).a(string).b(this.f5408a.getString(2131239901)).c());
    }

    public final void m5634b(Service service) {
        this.f5409b.a(20004);
        if (service != null) {
            service.stopForeground(true);
        }
    }
}
