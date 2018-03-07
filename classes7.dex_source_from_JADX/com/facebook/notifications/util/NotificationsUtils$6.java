package com.facebook.notifications.util;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import java.util.concurrent.Callable;

/* compiled from: minf */
class NotificationsUtils$6 implements Callable<GraphQLStory> {
    final /* synthetic */ String f8927a;
    final /* synthetic */ String f8928b;
    final /* synthetic */ NotificationsUtils f8929c;

    NotificationsUtils$6(NotificationsUtils notificationsUtils, String str, String str2) {
        this.f8929c = notificationsUtils;
        this.f8927a = str;
        this.f8928b = str2;
    }

    public Object call() {
        return ((GraphQLNotificationsContentProviderHelper) this.f8929c.c.get()).b(this.f8927a, this.f8928b);
    }
}
