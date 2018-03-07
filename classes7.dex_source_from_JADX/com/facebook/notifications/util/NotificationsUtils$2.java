package com.facebook.notifications.util;

import com.facebook.common.executors.NamedRunnable;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;

/* compiled from: minf */
class NotificationsUtils$2 extends NamedRunnable {
    final /* synthetic */ Iterable f8915c;
    final /* synthetic */ int f8916d;
    final /* synthetic */ NotificationsUtils f8917e;

    NotificationsUtils$2(NotificationsUtils notificationsUtils, Class cls, String str, Iterable iterable, int i) {
        this.f8917e = notificationsUtils;
        this.f8915c = iterable;
        this.f8916d = i;
        super(cls, str);
    }

    public void run() {
        ((GraphQLNotificationsContentProviderHelper) this.f8917e.c.get()).a(this.f8915c, this.f8916d);
    }
}
