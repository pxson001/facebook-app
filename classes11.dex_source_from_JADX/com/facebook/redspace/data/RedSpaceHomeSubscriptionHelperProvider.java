package com.facebook.redspace.data;

import android.support.v7.widget.RecyclerView.Adapter;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.adapter.RedSpaceFriendsAdapter;
import com.facebook.redspace.adapter.RedSpaceHomeMultiAdapter;
import com.facebook.redspace.event.RedSpaceEventBus;

/* compiled from: PrivacyCheckupAppsViewCreation */
public class RedSpaceHomeSubscriptionHelperProvider extends AbstractAssistedProvider<RedSpaceHomeSubscriptionHelper> {
    public final RedSpaceHomeSubscriptionHelper m12277a(RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceFriendsAdapter redSpaceFriendsAdapter, RedSpaceFriendsCollection redSpaceFriendsCollection2, RedSpaceFriendsAdapter redSpaceFriendsAdapter2, RedSpaceHomeMultiAdapter redSpaceHomeMultiAdapter, Adapter adapter) {
        RedSpaceHomeSubscriptionHelper redSpaceHomeSubscriptionHelper = new RedSpaceHomeSubscriptionHelper(RedSpaceMutationsExecutor.m12282a((InjectorLike) this), RedSpaceEventBus.m12371a(this), redSpaceFriendsCollection, redSpaceFriendsAdapter, redSpaceFriendsCollection2, redSpaceFriendsAdapter2, redSpaceHomeMultiAdapter, adapter);
        redSpaceHomeSubscriptionHelper.f11818a = IdBasedLazy.a(this, 10168);
        return redSpaceHomeSubscriptionHelper;
    }
}
