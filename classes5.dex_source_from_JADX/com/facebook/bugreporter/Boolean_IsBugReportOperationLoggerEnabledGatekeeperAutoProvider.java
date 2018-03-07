package com.facebook.bugreporter;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: android.speech.extra.RESULTS_PENDINGINTENT */
public class Boolean_IsBugReportOperationLoggerEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(523, false));
    }
}
