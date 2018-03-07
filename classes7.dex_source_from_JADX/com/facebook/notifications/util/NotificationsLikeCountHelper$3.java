package com.facebook.notifications.util;

import com.facebook.notifications.protocol.FetchNotificationsLikeCountGraphQLModels.FetchNotificationsLikeCountModel;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Map;

/* compiled from: minutiae_disk_storage_get_activities_found */
class NotificationsLikeCountHelper$3 implements FutureCallback<Map<String, FetchNotificationsLikeCountModel>> {
    final /* synthetic */ NotificationsLikeCountHelper f8896a;

    NotificationsLikeCountHelper$3(NotificationsLikeCountHelper notificationsLikeCountHelper) {
        this.f8896a = notificationsLikeCountHelper;
    }

    public void onSuccess(Object obj) {
        this.f8896a.d.a((Map) obj);
    }

    public void onFailure(Throwable th) {
        this.f8896a.e.a("NotificationsLikeCountHelper", "Failure while fetching notif like counts", th);
    }
}
