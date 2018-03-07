package com.facebook.messaging.payment.config;

import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: foreground_location/ */
public class Boolean_IsP2pPaymentsSyncProtocolEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return IsP2pPaymentsSyncProtocolEnabledProvider.m11959a(ProductMethodAutoProvider.b(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), Boolean_IsP2pPaymentsSyncProtocolGkEnabledGatekeeperAutoProvider.m11958b(this));
    }
}
