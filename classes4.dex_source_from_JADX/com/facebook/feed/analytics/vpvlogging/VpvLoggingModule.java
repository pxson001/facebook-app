package com.facebook.feed.analytics.vpvlogging;

import com.facebook.feed.analytics.vpvlogging.debugger.VpvLoggingDebugger;
import com.facebook.feed.analytics.vpvlogging.debugger.VpvLoggingNoOpDebugger;
import com.facebook.feed.analytics.vpvlogging.debugger.VpvLoggingToastDebugger;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;

@InjectorModule
/* compiled from: promotion */
public class VpvLoggingModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static VpvLoggingDebugger m4625a(FbSharedPreferences fbSharedPreferences, Lazy<VpvLoggingToastDebugger> lazy, Lazy<VpvLoggingNoOpDebugger> lazy2) {
        return fbSharedPreferences.a(FeedPrefKeys.i, false) ? (VpvLoggingDebugger) lazy.get() : (VpvLoggingDebugger) lazy2.get();
    }
}
