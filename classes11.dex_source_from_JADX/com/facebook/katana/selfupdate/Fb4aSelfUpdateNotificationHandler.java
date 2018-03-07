package com.facebook.katana.selfupdate;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.logging.NotificationsLogger.Component;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.model.SystemTrayNotificationBuilder;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import com.facebook.selfupdate.SelfUpdateNotificationHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unrecognized view type */
public class Fb4aSelfUpdateNotificationHandler implements SelfUpdateNotificationHandler {
    private final Context f10411a;
    private final SystemTrayNotificationManager f10412b;
    private final Provider<SystemTrayNotificationBuilder> f10413c;
    private final Provider<Boolean> f10414d;

    @Inject
    public Fb4aSelfUpdateNotificationHandler(Context context, SystemTrayNotificationManager systemTrayNotificationManager, Provider<Boolean> provider, Provider<SystemTrayNotificationBuilder> provider2) {
        this.f10411a = context;
        this.f10412b = systemTrayNotificationManager;
        this.f10414d = provider;
        this.f10413c = provider2;
    }

    public final void m10820a(Intent intent) {
        String stringExtra = intent.getStringExtra("app_name");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String string = this.f10411a.getString(2131236757);
        if (string == null) {
            string = "";
        }
        CharSequence a = StringFormatUtil.a(string, new Object[]{stringExtra});
        string = this.f10411a.getString(2131236758);
        if (string == null) {
            string = "";
        }
        CharSequence a2 = StringFormatUtil.a(string, new Object[0]);
        string = this.f10411a.getString(2131236759);
        if (string == null) {
            string = "";
        }
        SystemTrayNotificationBuilder a3 = ((SystemTrayNotificationBuilder) this.f10413c.get()).a(System.currentTimeMillis()).d(a).a(a2).c(StringFormatUtil.a(string, new Object[]{stringExtra})).a(2130843529);
        if (!((Boolean) this.f10414d.get()).booleanValue()) {
            a3.a().c().b();
        }
        Intent intent2 = intent;
        this.f10412b.a(NotificationType.AUTO_UPDATE_AVAILABLE, a3, intent2, Component.ACTIVITY, new NotificationLogObject());
    }

    public final void m10819a() {
        this.f10412b.a(NotificationType.AUTO_UPDATE_AVAILABLE);
    }
}
