package com.facebook.orca.notify;

import com.facebook.datasource.DataSource;
import com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.UserKey;
import com.google.common.util.concurrent.MoreExecutors;

/* compiled from: not_scrolled_to_bottom */
public class CommerceLocalNotificationHelper {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<DefaultMessagingNotificationHandler> f6182a = UltralightRuntime.b;

    public final void m5916a(String str, String str2, String str3) {
        DefaultMessagingNotificationHandler defaultMessagingNotificationHandler = (DefaultMessagingNotificationHandler) this.f6182a.get();
        ThreadKey a = defaultMessagingNotificationHandler.E.a(Long.parseLong(str));
        if (defaultMessagingNotificationHandler.x.a().b() && defaultMessagingNotificationHandler.x.a(a).b()) {
            FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = defaultMessagingNotificationHandler.e;
            int i = 2130843533;
            DataSource a2 = defaultMessagingNotificationHandler.r.a(new ParticipantInfo(UserKey.b(str), null));
            if (a2 != null) {
                a2.a(new DefaultMessagingNotificationHandler$9(defaultMessagingNotificationHandler, a, str2, str3, i), MoreExecutors.a());
            }
        }
    }
}
