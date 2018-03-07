package com.facebook.notifications.util;

import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;

/* compiled from: minf */
public class NotificationsUtils$4 implements Runnable {
    final /* synthetic */ String f8921a;
    final /* synthetic */ boolean f8922b;
    final /* synthetic */ NotificationsUtils f8923c;

    public NotificationsUtils$4(NotificationsUtils notificationsUtils, String str, boolean z) {
        this.f8923c = notificationsUtils;
        this.f8921a = str;
        this.f8922b = z;
    }

    public void run() {
        ((GraphQLNotificationsContentProviderHelper) this.f8923c.c.get()).a(this.f8921a, this.f8922b);
    }
}
