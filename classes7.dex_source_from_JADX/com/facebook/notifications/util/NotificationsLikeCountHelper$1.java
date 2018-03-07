package com.facebook.notifications.util;

import com.google.common.collect.ImmutableList;
import java.util.concurrent.Callable;

/* compiled from: minutiae_disk_storage_get_activities_found */
class NotificationsLikeCountHelper$1 implements Callable<ImmutableList<String>> {
    final /* synthetic */ long f8893a;
    final /* synthetic */ NotificationsLikeCountHelper f8894b;

    NotificationsLikeCountHelper$1(NotificationsLikeCountHelper notificationsLikeCountHelper, long j) {
        this.f8894b = notificationsLikeCountHelper;
        this.f8893a = j;
    }

    public Object call() {
        return this.f8894b.d.a(this.f8893a);
    }
}
