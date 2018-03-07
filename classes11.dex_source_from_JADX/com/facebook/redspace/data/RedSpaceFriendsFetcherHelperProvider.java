package com.facebook.redspace.data;

import android.util.Pair;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper.Params;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper.RedSpaceFriendsFetchListener;
import com.facebook.redspace.fetcher.RedSpaceBatchFetcher;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests;
import com.facebook.redspace.fetcher.RedSpaceRequests;
import com.google.common.collect.ImmutableList;

/* compiled from: PrivacyCheckupReactModule */
public class RedSpaceFriendsFetcherHelperProvider extends AbstractAssistedProvider<RedSpaceFriendsFetcherHelper> {
    public final RedSpaceFriendsFetcherHelper m12235a(RedSpaceFriendsFetchListener redSpaceFriendsFetchListener, ImmutableList<Pair<RedSpaceFriendsSection, RedSpaceFriendsCollection>> immutableList, Params params) {
        RedSpaceFriendsFetcherHelper redSpaceFriendsFetcherHelper = new RedSpaceFriendsFetcherHelper(redSpaceFriendsFetchListener, immutableList, params);
        redSpaceFriendsFetcherHelper.m12232a(RedSpaceBatchRequests.a(this), RedSpaceRequests.a(this), RedSpaceBatchFetcher.b(this), RedSpaceTabUnseenCountFetcher.a(this), RedSpaceFriendsCacheHelper.m12206a((InjectorLike) this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 494));
        return redSpaceFriendsFetcherHelper;
    }
}
