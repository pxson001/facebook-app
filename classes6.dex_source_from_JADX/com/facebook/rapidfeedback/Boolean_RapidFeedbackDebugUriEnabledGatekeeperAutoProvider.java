package com.facebook.rapidfeedback;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: familyTagTypeahead */
public class Boolean_RapidFeedbackDebugUriEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1081, false));
    }
}
