package com.facebook.http.prefs.delaybasedqp;

import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.init.INeedInitForSharedPrefsListenerRegistration;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: titlebar */
public class DelayBasedQPViewController$OnInitSharedPrefsListenerRegistration extends INeedInitForSharedPrefsListenerRegistration<DelayBasedQPViewController> {
    public final void mo667a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey, Object obj) {
        ((DelayBasedQPViewController) obj).a(fbSharedPreferences.mo286a(prefKey, false));
    }

    @Inject
    public DelayBasedQPViewController$OnInitSharedPrefsListenerRegistration(Lazy<DelayBasedQPViewController> lazy) {
        super((Lazy) lazy, ImmutableSet.of(InternalHttpPrefKeys.f2518m));
    }
}
