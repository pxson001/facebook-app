package com.facebook.saved.gating;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: setAttachedStory */
public class TriState_IsSavedOfflineToastEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(395);
    }
}
