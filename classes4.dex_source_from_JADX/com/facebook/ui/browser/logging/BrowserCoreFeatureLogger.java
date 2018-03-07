package com.facebook.ui.browser.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.browser.prefs.BrowserPrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: legacy_user_values */
public class BrowserCoreFeatureLogger implements INeedInit {
    private static final String f9403a = BrowserCoreFeatureLogger.class.getSimpleName();
    private final Context f9404b;
    private final Provider<TriState> f9405c;
    private final FbSharedPreferences f9406d;
    private final AnalyticsLogger f9407e;

    public static BrowserCoreFeatureLogger m9793b(InjectorLike injectorLike) {
        return new BrowserCoreFeatureLogger((Context) injectorLike.getInstance(Context.class, ForAppContext.class), IdBasedProvider.a(injectorLike, 783), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BrowserCoreFeatureLogger(@ForAppContext Context context, Provider<TriState> provider, FbSharedPreferences fbSharedPreferences, AnalyticsLogger analyticsLogger) {
        this.f9404b = context;
        this.f9405c = provider;
        this.f9406d = fbSharedPreferences;
        this.f9407e = analyticsLogger;
    }

    public void init() {
        if (((TriState) this.f9405c.get()).asBoolean(false)) {
            boolean a = this.f9406d.a(BrowserPrefKey.a, false);
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb4a_iab_core_feature");
            honeyClientEvent.a("iab_pref_disabled", a);
            this.f9407e.a(honeyClientEvent);
            Boolean.valueOf(a);
        }
    }
}
