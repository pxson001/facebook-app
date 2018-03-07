package com.facebook.notifications.action;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.widget.SwitchableNotificationView;

/* compiled from: no-hide-descendants */
class NotificationsInlineNotificationNuxManager$2 implements OnLongClickListener {
    final /* synthetic */ NotificationsEdgeFields f8135a;
    final /* synthetic */ ViewGroup f8136b;
    final /* synthetic */ SwitchableNotificationView f8137c;
    final /* synthetic */ int f8138d;
    final /* synthetic */ NotificationsInlineNotificationNuxManager f8139e;

    NotificationsInlineNotificationNuxManager$2(NotificationsInlineNotificationNuxManager notificationsInlineNotificationNuxManager, NotificationsEdgeFields notificationsEdgeFields, ViewGroup viewGroup, SwitchableNotificationView switchableNotificationView, int i) {
        this.f8139e = notificationsInlineNotificationNuxManager;
        this.f8135a = notificationsEdgeFields;
        this.f8136b = viewGroup;
        this.f8137c = switchableNotificationView;
        this.f8138d = i;
    }

    public boolean onLongClick(View view) {
        this.f8139e.f.a(this.f8135a, this.f8136b.getContext(), this.f8137c, this.f8139e.i.a(this.f8135a.k().g(), this.f8135a.k().c()), this.f8138d);
        return true;
    }
}
