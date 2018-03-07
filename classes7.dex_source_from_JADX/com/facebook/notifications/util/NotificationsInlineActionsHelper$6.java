package com.facebook.notifications.util;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationOptionRowModel;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;

/* compiled from: minutiae_disk_storage_get_activities_not_found */
class NotificationsInlineActionsHelper$6 implements OnMenuItemClickListener {
    final /* synthetic */ NotificationsEdgeFields f8887a;
    final /* synthetic */ NotificationOptionRowModel f8888b;
    final /* synthetic */ BottomSheetAdapter f8889c;
    final /* synthetic */ NotificationsRowWithActionHelper$3 f8890d;
    final /* synthetic */ int f8891e;
    final /* synthetic */ NotificationsInlineActionsHelper f8892f;

    NotificationsInlineActionsHelper$6(NotificationsInlineActionsHelper notificationsInlineActionsHelper, NotificationsEdgeFields notificationsEdgeFields, NotificationOptionRowModel notificationOptionRowModel, BottomSheetAdapter bottomSheetAdapter, NotificationsRowWithActionHelper$3 notificationsRowWithActionHelper$3, int i) {
        this.f8892f = notificationsInlineActionsHelper;
        this.f8887a = notificationsEdgeFields;
        this.f8888b = notificationOptionRowModel;
        this.f8889c = bottomSheetAdapter;
        this.f8890d = notificationsRowWithActionHelper$3;
        this.f8891e = i;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f8892f.a.a(this.f8887a, this.f8888b, this.f8889c.c, this.f8890d, "chevron", this.f8891e);
        return true;
    }
}
