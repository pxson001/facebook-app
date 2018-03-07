package com.facebook.notifications.util;

import com.facebook.notifications.protocol.C0694xee63252d;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;

/* compiled from: minf */
public class NotificationsUtils$5 implements Runnable {
    final /* synthetic */ String f8924a;
    final /* synthetic */ C0694xee63252d f8925b;
    final /* synthetic */ NotificationsUtils f8926c;

    public NotificationsUtils$5(NotificationsUtils notificationsUtils, String str, C0694xee63252d c0694xee63252d) {
        this.f8926c = notificationsUtils;
        this.f8924a = str;
        this.f8925b = c0694xee63252d;
    }

    public void run() {
        ((GraphQLNotificationsContentProviderHelper) this.f8926c.c.get()).a(this.f8924a, this.f8925b);
    }
}
