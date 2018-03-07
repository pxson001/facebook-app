package com.facebook.pages.identity.timeline;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.pages.identity.timeline.storymenu.PagesTimelineFeedStoryMenuHelperProvider;
import com.facebook.pages.identity.timeline.storymenu.PagesTimelineMenuProvider;

/* compiled from: page_identity_suggest_edit_fail */
public class PageIdentityTimelineEnvironmentProvider extends AbstractAssistedProvider<PageIdentityTimelineEnvironment> {
    public final PageIdentityTimelineEnvironment m5195a(Context context, FeedListType feedListType, TimelineContext timelineContext, Runnable runnable, Delegate delegate) {
        return new PageIdentityTimelineEnvironment(context, feedListType, timelineContext, runnable, delegate, new PagesTimelineMenuProvider((PagesTimelineFeedStoryMenuHelperProvider) getOnDemandAssistedProviderForStaticDi(PagesTimelineFeedStoryMenuHelperProvider.class)));
    }
}
