package com.facebook.photos.upload.progresspage;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: getWebsiteUri */
public class CompostNotificationManager {
    public final Context f13857a;
    private final NotificationManager f13858b;

    public static CompostNotificationManager m21626b(InjectorLike injectorLike) {
        return new CompostNotificationManager((Context) injectorLike.getInstance(Context.class), NotificationManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public CompostNotificationManager(Context context, NotificationManager notificationManager) {
        this.f13857a = context;
        this.f13858b = notificationManager;
    }

    public final void m21627a() {
        PendingIntent a = SecurePendingIntent.a(this.f13857a, 9430, CompostActivity.m21601a(this.f13857a, CompostSourceType.DRAFT_NOTIFICATION), 134217728);
        Builder b = new Builder(this.f13857a).a(this.f13857a.getString(2131236106)).a(2130843529).b(this.f13857a.getString(2131236107));
        b.d = a;
        this.f13858b.notify("CompostNotificationManager", 0, b.c(true).a(false).c());
    }
}
