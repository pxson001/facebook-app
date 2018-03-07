package com.facebook.feedplugins.storyset;

import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor;
import com.facebook.feedplugins.storyset.funnel.StorySetFunnelLogger;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: photo_360 */
public class StorySetsViewportEventListener extends BaseViewportEventListener implements ViewportEventListener {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<StorySetFunnelLogger> f10085a = UltralightRuntime.f368b;
    @Inject
    public VideoSetsQeAccessor f10086b;

    public static StorySetsViewportEventListener m15174a(InjectorLike injectorLike) {
        StorySetsViewportEventListener storySetsViewportEventListener = new StorySetsViewportEventListener();
        VideoSetsQeAccessor a = VideoSetsQeAccessor.m15178a(injectorLike);
        storySetsViewportEventListener.f10085a = IdBasedLazy.m1808a(injectorLike, 2034);
        storySetsViewportEventListener.f10086b = a;
        return storySetsViewportEventListener;
    }

    public final void mo1970a(Object obj) {
        if (m15175c(obj)) {
            GraphQLStorySet graphQLStorySet = (GraphQLStorySet) FeedUnitHelper.m21141a(obj);
            ((StorySetFunnelLogger) this.f10085a.get()).a(FunnelRegistry.f21135A, graphQLStorySet);
            ((StorySetFunnelLogger) this.f10085a.get()).b(FunnelRegistry.f21135A, graphQLStorySet);
        }
    }

    public final void mo1973b(Object obj) {
        if (m15175c(obj)) {
            ((StorySetFunnelLogger) this.f10085a.get()).c(FunnelRegistry.f21135A, (GraphQLStorySet) FeedUnitHelper.m21141a(obj));
        }
    }

    private static boolean m15175c(Object obj) {
        FeedUnit a = FeedUnitHelper.m21141a(obj);
        return a != null && (a instanceof GraphQLStorySet) && StorySetHelper.d((GraphQLStorySet) a);
    }
}
