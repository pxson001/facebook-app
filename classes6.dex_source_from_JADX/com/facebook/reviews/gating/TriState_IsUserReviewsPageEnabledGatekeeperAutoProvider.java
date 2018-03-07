package com.facebook.reviews.gating;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: f13e85acffb61c61d4f1822a77d1ae74 */
public class TriState_IsUserReviewsPageEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(1020);
    }
}
