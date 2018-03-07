package com.facebook.timeline.header;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import java.util.List;

/* compiled from: frame_count */
public class TimelineIntroCardMultiAdapterProvider extends AbstractAssistedProvider<TimelineIntroCardMultiAdapter> {
    public final TimelineIntroCardMultiAdapter m11537a(List<TimelineHeaderCachedBindAdapter> list, TimelineHeaderDataLogger timelineHeaderDataLogger, TimelineHeaderUserData timelineHeaderUserData, TimelineContext timelineContext) {
        return new TimelineIntroCardMultiAdapter(list, timelineHeaderDataLogger, timelineHeaderUserData, timelineContext, TimelineHeaderViewController.m11687b((InjectorLike) this), FeaturedContainersHeaderData.m12779a(this));
    }
}
