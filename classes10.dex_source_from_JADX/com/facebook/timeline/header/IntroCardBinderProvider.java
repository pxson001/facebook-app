package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.contextual.TimelineContextualInfoAdapterProvider;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.TimelineIntroCardAdapter.C16544;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;

/* compiled from: friends_nearby_dashboard_ping_cancel */
public class IntroCardBinderProvider extends AbstractAssistedProvider<IntroCardBinder> {
    public final IntroCardBinder m11384a(C16544 c16544, TimelineHeaderUserData timelineHeaderUserData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineUserContext timelineUserContext) {
        return new IntroCardBinder((Context) getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), FavPhotosVsFeaturedContainersController.m12774a(this), ProfileControllerDelegate.m10751a((InjectorLike) this), IdBasedProvider.a(this, 11293), IdBasedSingletonScopeProvider.a(this, 968), IdBasedSingletonScopeProvider.a(this, 616), TimelineHeaderViewController.m11686a((InjectorLike) this), (TimelineContextualInfoAdapterProvider) getOnDemandAssistedProviderForStaticDi(TimelineContextualInfoAdapterProvider.class), TimelinePerformanceLogger.a(this), IntroCardSuggestedPhotosExperimentController.m11801a(this), IntroCardCollapseController.m11666a(this), FeaturedContainersHeaderData.m12779a(this), Boolean_IsWorkBuildMethodAutoProvider.a(this), c16544, timelineHeaderUserData, timelineTaggedMediaSetData, timelineUserContext);
    }
}
