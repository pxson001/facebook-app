package com.facebook.notifications.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.util.NotificationsInlineActionsHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper$3;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: methods */
class DefaultNotificationsRenderer$4 implements OnClickListener {
    final /* synthetic */ NotificationsEdgeFields f9005a;
    final /* synthetic */ SwitchableNotificationView f9006b;
    final /* synthetic */ NotificationsRowWithActionHelper$3 f9007c;
    final /* synthetic */ int f9008d;
    final /* synthetic */ boolean f9009e;
    final /* synthetic */ DefaultNotificationsRenderer$3 f9010f;
    final /* synthetic */ String f9011g;
    final /* synthetic */ DefaultNotificationsRenderer f9012h;

    DefaultNotificationsRenderer$4(DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsEdgeFields notificationsEdgeFields, SwitchableNotificationView switchableNotificationView, NotificationsRowWithActionHelper$3 notificationsRowWithActionHelper$3, int i, boolean z, DefaultNotificationsRenderer$3 defaultNotificationsRenderer$3, String str) {
        this.f9012h = defaultNotificationsRenderer;
        this.f9005a = notificationsEdgeFields;
        this.f9006b = switchableNotificationView;
        this.f9007c = notificationsRowWithActionHelper$3;
        this.f9008d = i;
        this.f9009e = z;
        this.f9010f = defaultNotificationsRenderer$3;
        this.f9011g = str;
    }

    public void onClick(View view) {
        boolean z;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1470017021);
        NotificationsInlineActionsHelper notificationsInlineActionsHelper = this.f9012h.d;
        NotificationsEdgeFields notificationsEdgeFields = this.f9005a;
        Context context = this.f9006b.getContext();
        CaspianNotificationsView caspianNotificationsView = this.f9006b.f9070a;
        NotificationsRowWithActionHelper$3 notificationsRowWithActionHelper$3 = this.f9007c;
        int i = this.f9008d;
        if (this.f9009e) {
            z = false;
        } else {
            z = true;
        }
        notificationsInlineActionsHelper.a(notificationsEdgeFields, context, caspianNotificationsView, notificationsRowWithActionHelper$3, i, z, this.f9010f, this.f9011g);
        LogUtils.a(539938700, a);
    }
}
