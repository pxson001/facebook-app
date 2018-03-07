package com.facebook.reaction.ui.datafetcher;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.feed.showmore.ReactionShowMoreComponentsItemCollection;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreDataFetcher.FetcherListener;

/* compiled from: Unpin */
public class ReactionShowMoreComponentsDataFetcherProvider extends AbstractAssistedProvider<ReactionShowMoreComponentsDataFetcher> {
    public final ReactionShowMoreComponentsDataFetcher m24731a(String str, FetcherListener fetcherListener, ReactionSession reactionSession, String str2, String str3, String str4) {
        return new ReactionShowMoreComponentsDataFetcher(str, fetcherListener, reactionSession, str2, str3, str4, DefaultAndroidThreadUtil.b(this), ReactionShowMoreComponentsItemCollection.m23448a((InjectorLike) this), ReactionAnalyticsLogger.m22814a((InjectorLike) this), ReactionUtil.m22637a((InjectorLike) this));
    }
}
