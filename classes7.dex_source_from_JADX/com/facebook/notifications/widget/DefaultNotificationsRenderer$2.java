package com.facebook.notifications.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.util.NotificationsRowWithActionHelper$3;

/* compiled from: methods */
class DefaultNotificationsRenderer$2 implements OnClickListener {
    final /* synthetic */ NotificationsEdgeFields f8994a;
    final /* synthetic */ NotificationsRowWithActionHelper$3 f8995b;
    final /* synthetic */ CaspianNotificationsView f8996c;
    final /* synthetic */ int f8997d;
    final /* synthetic */ DefaultNotificationsRenderer f8998e;

    DefaultNotificationsRenderer$2(DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsEdgeFields notificationsEdgeFields, NotificationsRowWithActionHelper$3 notificationsRowWithActionHelper$3, CaspianNotificationsView caspianNotificationsView, int i) {
        this.f8998e = defaultNotificationsRenderer;
        this.f8994a = notificationsEdgeFields;
        this.f8995b = notificationsRowWithActionHelper$3;
        this.f8996c = caspianNotificationsView;
        this.f8997d = i;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 24461126);
        this.f8998e.d.e.edit().putBoolean(NotificationsPreferenceConstants.H, true).commit();
        this.f8998e.d.a(this.f8994a, view.getContext(), this.f8995b, this.f8996c, this.f8997d);
        Logger.a(2, EntryType.UI_INPUT_END, -1453433316, a);
    }
}
