package com.facebook.richdocument.linkcovers;

import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel;

/* compiled from: place_tips_settings_update */
public abstract class LinkCoverFetchGraphQLCallback extends ResultFutureCallback<GraphQLResult<InstantArticleLinkCoverConfigFragmentModel>> {
    public abstract void mo268a(InstantArticleLinkCoverConfigFragmentModel instantArticleLinkCoverConfigFragmentModel);

    public abstract void mo269b(ServiceException serviceException);

    protected final void m5317a(Object obj) {
        mo268a((InstantArticleLinkCoverConfigFragmentModel) ((GraphQLResult) obj).e);
    }

    protected final void m5315a(ServiceException serviceException) {
        mo269b(serviceException);
    }
}
