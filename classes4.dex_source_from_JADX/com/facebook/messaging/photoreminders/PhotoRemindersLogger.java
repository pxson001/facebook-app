package com.facebook.messaging.photoreminders;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mQuickPromotionDefinitions */
public class PhotoRemindersLogger {
    private static final String f8585a = PhotoRemindersLogger.class.getSimpleName();
    public final AnalyticsLogger f8586b;

    public static PhotoRemindersLogger m8838b(InjectorLike injectorLike) {
        return new PhotoRemindersLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static PhotoRemindersLogger m8836a(InjectorLike injectorLike) {
        return m8838b(injectorLike);
    }

    @Inject
    public PhotoRemindersLogger(AnalyticsLogger analyticsLogger) {
        this.f8586b = analyticsLogger;
    }

    public final void m8839a(int i, @Nullable ThreadKey threadKey) {
        Integer.valueOf(i);
        HoneyClientEvent a = m8835a("media_tray_nux_exposed").a("num_exposures", i);
        if (threadKey != null) {
            a.a(m8837a(threadKey), threadKey.i());
        }
        this.f8586b.a(a);
    }

    public static String m8837a(ThreadKey threadKey) {
        return threadKey.a == Type.ONE_TO_ONE ? "thread_id_canonical" : "thread_id_group";
    }

    public static HoneyClientEvent m8835a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "messenger_photo_reminders";
        return honeyClientEvent;
    }
}
