package com.facebook.messaging.forcemessenger;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: javax.xml. */
public class Boolean_IsUserInDiodeMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return ForceMessengerModule.m10160a((FbSharedPreferences) FbSharedPreferencesImpl.a(this), GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
