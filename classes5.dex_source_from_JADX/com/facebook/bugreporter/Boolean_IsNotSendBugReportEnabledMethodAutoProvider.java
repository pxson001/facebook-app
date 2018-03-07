package com.facebook.bugreporter;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: android.speech.extra.PROMPT */
public class Boolean_IsNotSendBugReportEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return BugReporterModule.a(GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
