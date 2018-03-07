package com.facebook.notifications.action;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel;
import com.facebook.notifications.util.NotificationsRowWithActionHelper$3;

/* compiled from: no_context_card */
class NotificationsInlineActionsHelperV2$1 implements OnMenuItemClickListener {
    final /* synthetic */ Context f8128a;
    final /* synthetic */ NotificationsEdgeFields f8129b;
    final /* synthetic */ NotifInlineActionOptionFragmentModel f8130c;
    final /* synthetic */ NotificationsRowWithActionHelper$3 f8131d;
    final /* synthetic */ String f8132e;
    final /* synthetic */ int f8133f;
    final /* synthetic */ NotificationsInlineActionsHelperV2 f8134g;

    NotificationsInlineActionsHelperV2$1(NotificationsInlineActionsHelperV2 notificationsInlineActionsHelperV2, Context context, NotificationsEdgeFields notificationsEdgeFields, NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel, NotificationsRowWithActionHelper$3 notificationsRowWithActionHelper$3, String str, int i) {
        this.f8134g = notificationsInlineActionsHelperV2;
        this.f8128a = context;
        this.f8129b = notificationsEdgeFields;
        this.f8130c = notifInlineActionOptionFragmentModel;
        this.f8131d = notificationsRowWithActionHelper$3;
        this.f8132e = str;
        this.f8133f = i;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f8134g.c.a(this.f8128a, this.f8129b, this.f8130c, this.f8131d, this.f8132e, this.f8133f);
        return true;
    }
}
