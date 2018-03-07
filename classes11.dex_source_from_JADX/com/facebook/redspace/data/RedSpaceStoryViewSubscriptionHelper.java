package com.facebook.redspace.data;

import com.facebook.inject.Assisted;
import com.facebook.redspace.adapter.RedSpaceUserMultiAdapter;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.SimpleFriendChangedSubscriber;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.ultralight.Inject;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: PostSurveyActions is garbage collected. Double-check the caller to strongly reference the passed in callback. */
public class RedSpaceStoryViewSubscriptionHelper extends SimpleFriendChangedSubscriber {
    public final RedSpaceMutationsExecutor f11875a;
    public final RedSpaceUserMultiAdapter f11876b;
    private final ImmutableList<RedSpaceFriendsCollection> f11877c;

    @Inject
    public RedSpaceStoryViewSubscriptionHelper(RedSpaceMutationsExecutor redSpaceMutationsExecutor, @Assisted ImmutableList<RedSpaceFriendsCollection> immutableList, @Assisted RedSpaceUserMultiAdapter redSpaceUserMultiAdapter) {
        this.f11875a = redSpaceMutationsExecutor;
        this.f11877c = (ImmutableList) Preconditions.checkNotNull(immutableList);
        this.f11876b = redSpaceUserMultiAdapter;
        this.f11875a.m12288a((SimpleFriendChangedSubscriber) this);
    }

    public final void mo335a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        int size = this.f11877c.size();
        for (int i = 0; i < size; i++) {
            ((RedSpaceFriendsCollection) this.f11877c.get(i)).m12217a(redSpaceFeedProfileFragmentModel);
        }
        this.f11876b.kR_();
    }
}
