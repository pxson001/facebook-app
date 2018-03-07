package com.facebook.notifications.util;

import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: minutiae_configuration */
public class NotificationsRowWithActionHelper$3 {
    public final /* synthetic */ String f8899a;
    public final /* synthetic */ String f8900b;
    public final /* synthetic */ NotificationsRowWithActionHelper f8901c;

    NotificationsRowWithActionHelper$3(NotificationsRowWithActionHelper notificationsRowWithActionHelper, String str, String str2) {
        this.f8901c = notificationsRowWithActionHelper;
        this.f8899a = str;
        this.f8900b = str2;
    }

    public final void m10814a(NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel) {
        NotificationsRowWithActionHelper$RowWithActionTaken notificationsRowWithActionHelper$RowWithActionTaken = new NotificationsRowWithActionHelper$RowWithActionTaken(this.f8899a, this.f8900b, notifInlineActionOptionFragmentModel);
        if ("inline_notification_id".equals(this.f8900b)) {
            this.f8901c.c.edit().putBoolean(NotificationsPreferenceConstants.J, true).commit();
        }
        this.f8901c.a(notificationsRowWithActionHelper$RowWithActionTaken);
        HandlerDetour.a(this.f8901c.h, this.f8901c.g);
        HandlerDetour.b(this.f8901c.h, this.f8901c.g, ((long) this.f8901c.d.a.a(ExperimentsForNotificationsAbtestModule.o, 5)) * 1000, 1040294689);
    }
}
