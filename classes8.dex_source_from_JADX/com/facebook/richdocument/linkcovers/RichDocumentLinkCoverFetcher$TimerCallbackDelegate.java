package com.facebook.richdocument.linkcovers;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel;

/* compiled from: place_tips_feed_unit */
public class RichDocumentLinkCoverFetcher$TimerCallbackDelegate extends ResultFutureCallback<GraphQLResult<InstantArticleLinkCoverConfigFragmentModel>> {
    private final AbstractFbErrorReporter f5421a;
    private final String f5422b;
    private final LinkCoverFetchGraphQLCallback f5423c;

    protected final void m5328a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (this.f5423c != null) {
            this.f5423c.onSuccess(graphQLResult);
        }
    }

    public RichDocumentLinkCoverFetcher$TimerCallbackDelegate(AbstractFbErrorReporter abstractFbErrorReporter, String str, LinkCoverFetchGraphQLCallback linkCoverFetchGraphQLCallback) {
        this.f5421a = abstractFbErrorReporter;
        this.f5422b = str;
        this.f5423c = linkCoverFetchGraphQLCallback;
    }

    protected final void m5327a(ServiceException serviceException) {
        if (this.f5423c != null) {
            this.f5421a.a(RichDocumentLinkCoverFetcher.a, StringFormatUtil.a("Error fetching link cover for article %s", new Object[]{this.f5422b}));
            this.f5423c.mo269b(serviceException);
        }
    }
}
