package com.facebook.reaction.ui.recyclerview;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.feed.showmore.ReactionShowMoreComponentsFeedAdapterFactory;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreComponentsDataFetcherProvider;

/* compiled from: Unexpected target type " */
public class ReactionShowMoreComponentsRecyclerViewAdapterProvider extends AbstractAssistedProvider<ReactionShowMoreComponentsRecyclerViewAdapter> {
    public final ReactionShowMoreComponentsRecyclerViewAdapter m24817a(Context context, ReactionCardContainer reactionCardContainer, String str, ReactionSession reactionSession, String str2, String str3, String str4, Delegate delegate) {
        return new ReactionShowMoreComponentsRecyclerViewAdapter(context, reactionCardContainer, str, reactionSession, str2, str3, str4, delegate, ReactionShowMoreComponentsFeedAdapterFactory.m23444b(this), (ReactionShowMoreComponentsDataFetcherProvider) getOnDemandAssistedProviderForStaticDi(ReactionShowMoreComponentsDataFetcherProvider.class));
    }
}
