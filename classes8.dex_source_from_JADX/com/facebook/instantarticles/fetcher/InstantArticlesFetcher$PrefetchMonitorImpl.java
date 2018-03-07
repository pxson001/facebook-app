package com.facebook.instantarticles.fetcher;

import com.facebook.datasource.DataSource;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentVideo;
import com.facebook.richdocument.utils.PrefetchUtils;

/* compiled from: url_segue */
public class InstantArticlesFetcher$PrefetchMonitorImpl implements InstantArticlesFetcher$PrefetchMonitor {
    final /* synthetic */ InstantArticlesFetcher f824a;
    public RichDocumentVideo f825b;
    public DataSource f826c;
    private String f827d;

    public InstantArticlesFetcher$PrefetchMonitorImpl(InstantArticlesFetcher instantArticlesFetcher, String str) {
        this.f824a = instantArticlesFetcher;
        this.f827d = str;
    }

    public final void mo22a() {
        if (this.f825b != null) {
            PrefetchUtils prefetchUtils = this.f824a.c;
            RichDocumentVideo richDocumentVideo = this.f825b;
            String m = richDocumentVideo.ig_().mo326m();
            String n = richDocumentVideo.ig_().mo327n();
            prefetchUtils.c(m);
            prefetchUtils.c(n);
        }
        if (this.f826c != null) {
            this.f826c.g();
        }
        this.f824a.h.a(this.f827d);
    }
}
