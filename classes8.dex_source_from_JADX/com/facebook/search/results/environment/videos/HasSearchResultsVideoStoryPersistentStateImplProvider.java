package com.facebook.search.results.environment.videos;

import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: SYSTEM_VIDEO_PAUSE */
public class HasSearchResultsVideoStoryPersistentStateImplProvider extends AbstractAssistedProvider<HasSearchResultsVideoStoryPersistentStateImpl> {
    public final HasSearchResultsVideoStoryPersistentStateImpl m26269a(HasPersistentState hasPersistentState) {
        return new HasSearchResultsVideoStoryPersistentStateImpl(hasPersistentState, (AutoplayStateManagerProvider) getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class));
    }
}
