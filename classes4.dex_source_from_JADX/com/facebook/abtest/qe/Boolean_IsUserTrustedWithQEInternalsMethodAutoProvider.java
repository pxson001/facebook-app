package com.facebook.abtest.qe;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: threadkeystring */
public class Boolean_IsUserTrustedWithQEInternalsMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return QuickExperimentClientModule.a(IdBasedProvider.a(this, 640), IdBasedProvider.a(this, 642));
    }
}
