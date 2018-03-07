package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.TimelineIntroCardAdapter.C16522;
import com.facebook.timeline.header.bio.IntroCardSuggestedBioExperimentController;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;

/* compiled from: friends_nearby_dashboard_open */
public class IntroCardBioBinderProvider extends AbstractAssistedProvider<IntroCardBioBinder> {
    public final IntroCardBioBinder m11393a(C16522 c16522, TimelineHeaderUserData timelineHeaderUserData, TimelineUserContext timelineUserContext) {
        return new IntroCardBioBinder((Context) getInstance(Context.class), ProfileControllerDelegate.m10751a((InjectorLike) this), IdBasedProvider.a(this, 11293), IdBasedSingletonScopeProvider.a(this, 968), TimelineHeaderViewController.m11687b((InjectorLike) this), TimelinePerformanceLogger.a(this), IntroCardSuggestedBioExperimentController.m11605a(this), IntroCardCollapseController.m11666a(this), FeaturedContainersHeaderData.m12779a(this), c16522, timelineHeaderUserData, timelineUserContext);
    }
}
