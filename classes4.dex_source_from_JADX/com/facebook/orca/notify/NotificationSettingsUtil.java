package com.facebook.orca.notify;

import android.content.Context;
import android.text.format.DateFormat;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import java.util.Date;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: logged_out_user */
public class NotificationSettingsUtil {
    private final FbSharedPreferences f8941a;
    private final Provider<Boolean> f8942b;
    private final Context f8943c;
    private final AnalyticsLogger f8944d;
    private final Provider<DataCache> f8945e;

    public static NotificationSettingsUtil m9290b(InjectorLike injectorLike) {
        return new NotificationSettingsUtil((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4064), (Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 2567));
    }

    public static NotificationSettingsUtil m9289a(InjectorLike injectorLike) {
        return m9290b(injectorLike);
    }

    @Inject
    public NotificationSettingsUtil(FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider, Context context, AnalyticsLogger analyticsLogger, Provider<DataCache> provider2) {
        this.f8941a = fbSharedPreferences;
        this.f8942b = provider;
        this.f8943c = context;
        this.f8944d = analyticsLogger;
        this.f8945e = provider2;
    }

    public final NotificationSetting m9291a() {
        if (((Boolean) this.f8942b.get()).booleanValue()) {
            return NotificationSetting.b(this.f8941a.a(MessagingPrefKeys.F, 0));
        }
        return NotificationSetting.b;
    }

    public final NotificationSetting m9292a(ThreadKey threadKey) {
        if (threadKey == null) {
            return NotificationSetting.a;
        }
        PrefKey a = MessagingPrefKeys.a(threadKey);
        if (this.f8941a.a(a)) {
            return NotificationSetting.b(this.f8941a.a(a, 0));
        }
        return NotificationSetting.a;
    }

    public final void m9294b(ThreadKey threadKey) {
        if (threadKey != null) {
            PrefKey a = MessagingPrefKeys.a(threadKey);
            AnalyticsLogger analyticsLogger = this.f8944d;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("set");
            honeyClientEvent.d = "notification_settings";
            honeyClientEvent = honeyClientEvent.a("thread_key", threadKey).b("value", "unmute");
            honeyClientEvent.c = "ConversationsSettingsView";
            analyticsLogger.a(honeyClientEvent);
            this.f8941a.edit().a(a, 0).commit();
        }
    }

    @Nullable
    public final String m9293a(@Nullable NotificationSetting notificationSetting) {
        if (notificationSetting == null) {
            return null;
        }
        switch (1.a[notificationSetting.c().ordinal()]) {
            case 1:
                return this.f8943c.getString(2131231383);
            case 2:
                return this.f8943c.getString(2131231384);
            case 3:
                String format = DateFormat.getTimeFormat(this.f8943c).format(new Date(notificationSetting.d * 1000));
                return this.f8943c.getString(2131231385, new Object[]{format});
            default:
                throw new UnsupportedOperationException();
        }
    }
}
