package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.controllers.TimelineBioNuxController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.externalLinks.IntroCardExternalLinksViewBinderProvider;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;

/* compiled from: frame_ids */
public class TimelineIntroCardExternalLinksAdapterProvider extends AbstractAssistedProvider<TimelineIntroCardExternalLinksAdapter> {
    public final TimelineIntroCardExternalLinksAdapter m11535a(Context context, TimelineHeaderUserData timelineHeaderUserData, TimelineUserContext timelineUserContext, boolean z) {
        return new TimelineIntroCardExternalLinksAdapter((QeAccessor) QeInternalImplMethodAutoProvider.a(this), (IntroCardExternalLinksViewBinderProvider) getOnDemandAssistedProviderForStaticDi(IntroCardExternalLinksViewBinderProvider.class), IdBasedProvider.a(this, 1281), TimelineHeaderViewController.m11686a((InjectorLike) this), TimelineBioNuxController.m11672a(this), IdBasedSingletonScopeProvider.b(this, 11285), IntroCardCollapseController.m11666a(this), FeaturedContainersHeaderData.m12779a(this), ProfileControllerDelegate.m10751a((InjectorLike) this), IdBasedSingletonScopeProvider.a(this, 616), IdBasedProvider.a(this, 11293), context, timelineHeaderUserData, timelineUserContext, z);
    }
}
