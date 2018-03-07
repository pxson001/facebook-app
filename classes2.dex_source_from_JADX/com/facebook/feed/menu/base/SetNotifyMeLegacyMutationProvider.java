package com.facebook.feed.menu.base;

import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: network_info_non_interact_req */
public class SetNotifyMeLegacyMutationProvider extends AbstractAssistedProvider<SetNotifyMeLegacyMutation> {
    public final SetNotifyMeLegacyMutation m18626a(GraphQLStory graphQLStory, boolean z) {
        return new SetNotifyMeLegacyMutation(IdBasedSingletonScopeProvider.m1810b(this, 4828), IdBasedSingletonScopeProvider.m1809a(this, 2289), SystemClockMethodAutoProvider.m1498a(this), graphQLStory, z);
    }
}
