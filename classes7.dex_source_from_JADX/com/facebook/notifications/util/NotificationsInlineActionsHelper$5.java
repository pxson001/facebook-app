package com.facebook.notifications.util;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationOptionRowModel;

/* compiled from: minutiae_disk_storage_get_activities_not_found */
class NotificationsInlineActionsHelper$5 implements OnMenuItemClickListener {
    final /* synthetic */ NotificationsEdgeFields f8880a;
    final /* synthetic */ NotificationOptionRowModel f8881b;
    final /* synthetic */ PopoverMenu f8882c;
    final /* synthetic */ NotificationsRowWithActionHelper$3 f8883d;
    final /* synthetic */ String f8884e;
    final /* synthetic */ int f8885f;
    final /* synthetic */ NotificationsInlineActionsHelper f8886g;

    NotificationsInlineActionsHelper$5(NotificationsInlineActionsHelper notificationsInlineActionsHelper, NotificationsEdgeFields notificationsEdgeFields, NotificationOptionRowModel notificationOptionRowModel, PopoverMenu popoverMenu, NotificationsRowWithActionHelper$3 notificationsRowWithActionHelper$3, String str, int i) {
        this.f8886g = notificationsInlineActionsHelper;
        this.f8880a = notificationsEdgeFields;
        this.f8881b = notificationOptionRowModel;
        this.f8882c = popoverMenu;
        this.f8883d = notificationsRowWithActionHelper$3;
        this.f8884e = str;
        this.f8885f = i;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f8886g.a.a(this.f8880a, this.f8881b, this.f8882c.c, this.f8883d, this.f8884e, this.f8885f);
        return true;
    }
}
