package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.controllers.TimelineBioNuxController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;

/* compiled from: free_fb_invitable_contact_list */
public class TimelineIntroCardAdapterProvider extends AbstractAssistedProvider<TimelineIntroCardAdapter> {
    public final TimelineIntroCardAdapter m11510a(Context context, TimelineHeaderUserData timelineHeaderUserData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineUserContext timelineUserContext, boolean z, TimelineHeaderDataLogger timelineHeaderDataLogger) {
        return new TimelineIntroCardAdapter((IntroCardBinderProvider) getOnDemandAssistedProviderForStaticDi(IntroCardBinderProvider.class), (IntroCardBioBinderProvider) getOnDemandAssistedProviderForStaticDi(IntroCardBioBinderProvider.class), TimelineHeaderViewController.m11686a((InjectorLike) this), TimelineBioNuxController.m11672a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), TimelineIntroMegaphoneViewBinder.m11563a((InjectorLike) this), IdBasedSingletonScopeProvider.b(this, 11285), IntroCardCollapseController.m11666a(this), FeaturedContainersHeaderData.m12779a(this), IdBasedSingletonScopeProvider.b(this, 2436), IdBasedSingletonScopeProvider.b(this, 968), context, timelineHeaderUserData, timelineTaggedMediaSetData, timelineUserContext, z, timelineHeaderDataLogger);
    }
}
