package com.facebook.orca.notify;

import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;
import android.telephony.TelephonyManager;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences;
import com.facebook.messages.ipc.MessagingNotificationPreferences;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.wear.NotificationManagerCompatMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: next_eight_am */
public class SmsFallbackNumberNotificationHandler {
    public final Context f6266a;
    public final FbAndroidMessagingNotificationPreferences f6267b;
    public final NotificationManagerCompat f6268c;
    public final FbSharedPreferences f6269d;
    public final Lazy<TelephonyManager> f6270e;
    public final Lazy<SmsTakeoverAnalyticsLogger> f6271f;

    public static SmsFallbackNumberNotificationHandler m5962b(InjectorLike injectorLike) {
        return new SmsFallbackNumberNotificationHandler((Context) injectorLike.getInstance(Context.class), FbAndroidMessagingNotificationPreferences.a(injectorLike), NotificationManagerCompatMethodAutoProvider.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 57), IdBasedLazy.a(injectorLike, 2706));
    }

    @Inject
    public SmsFallbackNumberNotificationHandler(Context context, MessagingNotificationPreferences messagingNotificationPreferences, NotificationManagerCompat notificationManagerCompat, FbSharedPreferences fbSharedPreferences, Lazy<TelephonyManager> lazy, Lazy<SmsTakeoverAnalyticsLogger> lazy2) {
        this.f6266a = context;
        this.f6267b = messagingNotificationPreferences;
        this.f6268c = notificationManagerCompat;
        this.f6269d = fbSharedPreferences;
        this.f6270e = lazy;
        this.f6271f = lazy2;
    }
}
