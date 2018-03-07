package com.facebook.reaction.ui.datafetcher;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionRecyclableAttachmentHandler;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreDataFetcher.FetcherListener;

/* compiled from: Unrecognized listener! */
public class ReactionShowMoreAttachmentsDataFetcherProvider extends AbstractAssistedProvider<ReactionShowMoreAttachmentsDataFetcher> {
    public final <VH extends ViewHolder> ReactionShowMoreAttachmentsDataFetcher<VH> m24726a(ReactionRecyclableAttachmentHandler<VH> reactionRecyclableAttachmentHandler, String str, FetcherListener fetcherListener, String str2, Surface surface) {
        return new ReactionShowMoreAttachmentsDataFetcher(reactionRecyclableAttachmentHandler, str, fetcherListener, str2, surface, DefaultAndroidThreadUtil.b(this), ReactionAnalyticsLogger.m22814a((InjectorLike) this), ReactionUtil.m22637a((InjectorLike) this));
    }
}
