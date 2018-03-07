package com.facebook.timeline.viewfeaturedcontainers.ui;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import com.facebook.timeline.viewfeaturedcontainers.nux.FeaturedHeaderNuxController;

/* compiled from: extra_events_discovery_filter_time */
public class FeaturedHeaderAdapterProvider extends AbstractAssistedProvider<FeaturedHeaderAdapter> {
    public final FeaturedHeaderAdapter m12886a(Context context, TimelineHeaderUserData timelineHeaderUserData, TimelineUserContext timelineUserContext, boolean z) {
        return new FeaturedHeaderAdapter((QeAccessor) QeInternalImplMethodAutoProvider.a(this), FeaturedContainersHeaderData.m12779a(this), FeaturedHeaderNuxController.m12785a(this), IntroCardCollapseController.m11666a(this), FeaturedHeaderCollageBinder.m12887b(this), IdBasedSingletonScopeProvider.a(this, 968), context, timelineHeaderUserData, timelineUserContext, z);
    }
}
