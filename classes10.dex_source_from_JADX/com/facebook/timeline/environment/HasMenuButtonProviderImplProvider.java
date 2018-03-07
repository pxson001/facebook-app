package com.facebook.timeline.environment;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.timeline.rows.TimelineMenuProvider;
import com.facebook.timeline.units.storymenu.NonSelfTimelineFeedStoryMenuHelperProvider;
import com.facebook.timeline.units.storymenu.SelfTimelineFeedStoryMenuHelperProvider;

/* compiled from: gdpv4_nux_content */
public class HasMenuButtonProviderImplProvider extends AbstractAssistedProvider<HasMenuButtonProviderImpl> {
    public final HasMenuButtonProviderImpl m11105a(FeedEnvironment feedEnvironment) {
        return new HasMenuButtonProviderImpl(feedEnvironment, new TimelineMenuProvider((SelfTimelineFeedStoryMenuHelperProvider) getOnDemandAssistedProviderForStaticDi(SelfTimelineFeedStoryMenuHelperProvider.class), (NonSelfTimelineFeedStoryMenuHelperProvider) getOnDemandAssistedProviderForStaticDi(NonSelfTimelineFeedStoryMenuHelperProvider.class)));
    }
}
