package com.facebook.http.common;

import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.init.INeedInitForSharedPrefsListenerRegistration;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: tls_reused */
public class C0172xe097af95 extends INeedInitForSharedPrefsListenerRegistration<DelayEmpathyManager> {
    protected final void mo667a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey, Object obj) {
        DelayEmpathyManager delayEmpathyManager = (DelayEmpathyManager) obj;
        if (fbSharedPreferences.mo286a(prefKey, false)) {
            int a = delayEmpathyManager.c.mo572a(ExperimentsForHttpQeModule.an, 3600000);
            Integer.valueOf(a);
            delayEmpathyManager.a.a(DelayEmpathyDelayWorker.class, TimeUnit.SECONDS.convert((long) a, TimeUnit.MILLISECONDS));
        }
    }

    @Inject
    public C0172xe097af95(Lazy<DelayEmpathyManager> lazy) {
        super((Lazy) lazy, ImmutableSet.of(InternalHttpPrefKeys.f2518m));
    }
}
