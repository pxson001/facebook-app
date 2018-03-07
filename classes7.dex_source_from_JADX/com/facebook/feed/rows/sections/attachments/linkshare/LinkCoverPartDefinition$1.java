package com.facebook.feed.rows.sections.attachments.linkshare;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.model.GraphQLInstantArticle;
import com.facebook.richdocument.linkcovers.AttachmentCoverLayoutSpec;
import com.facebook.richdocument.linkcovers.LinkCoverFetchCallback;

/* compiled from: VideoSubtitles */
public class LinkCoverPartDefinition$1 extends LinkCoverFetchCallback {
    final /* synthetic */ LinkCoverPartDefinition$State f20986a;
    final /* synthetic */ GraphQLInstantArticle f20987b;
    final /* synthetic */ LinkCoverPartDefinition$Props f20988c;
    final /* synthetic */ LinkCoverPartDefinition f20989d;

    public LinkCoverPartDefinition$1(LinkCoverPartDefinition linkCoverPartDefinition, LinkCoverPartDefinition$State linkCoverPartDefinition$State, GraphQLInstantArticle graphQLInstantArticle, LinkCoverPartDefinition$Props linkCoverPartDefinition$Props) {
        this.f20989d = linkCoverPartDefinition;
        this.f20986a = linkCoverPartDefinition$State;
        this.f20987b = graphQLInstantArticle;
        this.f20988c = linkCoverPartDefinition$Props;
    }

    public final void mo1497a(AttachmentCoverLayoutSpec attachmentCoverLayoutSpec) {
        this.f20986a.f20994b = this.f20987b.m();
        this.f20986a.f20993a = attachmentCoverLayoutSpec;
        this.f20986a.f20993a.t = -1;
    }

    public final void mo1496a() {
        this.f20989d.a.a(this.f20988c.f20990a, StringFormatUtil.a("Unable to load IA %s", new Object[]{this.f20987b.m()}));
    }
}
