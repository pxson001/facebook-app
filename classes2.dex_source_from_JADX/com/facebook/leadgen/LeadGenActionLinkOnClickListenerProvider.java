package com.facebook.leadgen;

import android.content.Context;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.util.LeadGenSharedStatusHelper;

/* compiled from: fetch_start */
public class LeadGenActionLinkOnClickListenerProvider extends AbstractAssistedProvider<LeadGenActionLinkOnClickListener> {
    public final <E extends HasInvalidate> LeadGenActionLinkOnClickListener<E> m32319a(FeedProps<GraphQLStoryAttachment> feedProps, Context context, E e) {
        return new LeadGenActionLinkOnClickListener(feedProps, context, e, (LeadGenLinkHandlerProvider) getOnDemandAssistedProviderForStaticDi(LeadGenLinkHandlerProvider.class), LeadGenLogger.a(this), FbErrorReporterImpl.m2317a((InjectorLike) this), LeadGenUtil.m32381a((InjectorLike) this), InlineCommentComposerCache.m14459a(this), LeadGenSharedStatusHelper.a(this));
    }
}
