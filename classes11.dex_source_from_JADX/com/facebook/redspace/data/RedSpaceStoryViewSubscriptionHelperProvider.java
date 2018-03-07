package com.facebook.redspace.data;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.adapter.RedSpaceUserMultiAdapter;
import com.google.common.collect.ImmutableList;

/* compiled from: Please override onBackPress from the activity. */
public class RedSpaceStoryViewSubscriptionHelperProvider extends AbstractAssistedProvider<RedSpaceStoryViewSubscriptionHelper> {
    public final RedSpaceStoryViewSubscriptionHelper m12322a(ImmutableList<RedSpaceFriendsCollection> immutableList, RedSpaceUserMultiAdapter redSpaceUserMultiAdapter) {
        return new RedSpaceStoryViewSubscriptionHelper(RedSpaceMutationsExecutor.m12282a((InjectorLike) this), immutableList, redSpaceUserMultiAdapter);
    }
}
