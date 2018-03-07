package com.facebook.notifications.util;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.google.common.collect.ImmutableList;

/* compiled from: minf */
class NotificationsUtils$1 extends NamedRunnable {
    final /* synthetic */ long f8912c;
    final /* synthetic */ ViewerContext f8913d;
    final /* synthetic */ NotificationsUtils f8914e;

    NotificationsUtils$1(NotificationsUtils notificationsUtils, Class cls, String str, long j, ViewerContext viewerContext) {
        this.f8914e = notificationsUtils;
        this.f8912c = j;
        this.f8913d = viewerContext;
        super(cls, str);
    }

    public void run() {
        ImmutableList e = ((GraphQLNotificationsContentProviderHelper) this.f8914e.c.get()).e(this.f8912c);
        if (e != null && !e.isEmpty()) {
            this.f8914e.a(e, GraphQLStorySeenState.SEEN_BUT_UNREAD, this.f8913d);
        }
    }
}
