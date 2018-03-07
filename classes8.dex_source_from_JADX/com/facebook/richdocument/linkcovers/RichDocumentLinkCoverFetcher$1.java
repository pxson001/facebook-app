package com.facebook.richdocument.linkcovers;

import com.facebook.fbservice.service.ServiceException;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.OverlayImageType;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel;

/* compiled from: place_tips_feed_unit */
class RichDocumentLinkCoverFetcher$1 extends LinkCoverFetchGraphQLCallback {
    final /* synthetic */ LinkCoverFetchParams f5418a;
    final /* synthetic */ LinkCoverFetchCallback f5419b;
    final /* synthetic */ RichDocumentLinkCoverFetcher f5420c;

    RichDocumentLinkCoverFetcher$1(RichDocumentLinkCoverFetcher richDocumentLinkCoverFetcher, LinkCoverFetchParams linkCoverFetchParams, LinkCoverFetchCallback linkCoverFetchCallback) {
        this.f5420c = richDocumentLinkCoverFetcher;
        this.f5418a = linkCoverFetchParams;
        this.f5419b = linkCoverFetchCallback;
    }

    public final void mo268a(InstantArticleLinkCoverConfigFragmentModel instantArticleLinkCoverConfigFragmentModel) {
        AttachmentCoverLayoutSpec attachmentCoverLayoutSpec = new AttachmentCoverLayoutSpec(instantArticleLinkCoverConfigFragmentModel.m6632j().m6626a(), new LinkCoverMetrics(this.f5420c.f), true, 0, OverlayImageType.OVERLAY_NONE);
        this.f5420c.e.a.a(this.f5418a.f5406a, attachmentCoverLayoutSpec);
        this.f5419b.a(attachmentCoverLayoutSpec);
    }

    public final void mo269b(ServiceException serviceException) {
        this.f5419b.a();
    }
}
