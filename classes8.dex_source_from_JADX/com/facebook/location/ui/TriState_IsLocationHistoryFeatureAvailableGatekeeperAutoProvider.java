package com.facebook.location.ui;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: dismissPromotion */
public class TriState_IsLocationHistoryFeatureAvailableGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(515);
    }
}
