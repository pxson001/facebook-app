package com.facebook.notifications.util;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.notifications.widget.DefaultNotificationsRenderer$3;

/* compiled from: minutiae_disk_storage_get_activities_not_found */
class NotificationsInlineActionsHelper$3 implements OnMenuItemClickListener {
    final /* synthetic */ DefaultNotificationsRenderer$3 f8877a;
    final /* synthetic */ NotificationsInlineActionsHelper f8878b;

    NotificationsInlineActionsHelper$3(NotificationsInlineActionsHelper notificationsInlineActionsHelper, DefaultNotificationsRenderer$3 defaultNotificationsRenderer$3) {
        this.f8878b = notificationsInlineActionsHelper;
        this.f8877a = defaultNotificationsRenderer$3;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f8877a.m10858a(null);
        return true;
    }
}
