package com.facebook.api.ufiservices;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;

/* compiled from: post_insights */
public class FeedbackPrefetchPolicyProvider extends AbstractAssistedProvider<FeedbackPrefetchPolicy> {
    public final FeedbackPrefetchPolicy m14350a(Boolean bool, Boolean bool2) {
        return new FeedbackPrefetchPolicy(FetchFeedbackMethod.m10191b((InjectorLike) this), XConfigReader.m2681a(this), bool, bool2, SystemClockMethodAutoProvider.m1498a(this), AppStateManager.m2245a((InjectorLike) this));
    }
}
