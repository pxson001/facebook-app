package com.facebook.feedplugins.pyml.rows;

import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLPage;

/* compiled from: android_key */
class PageLiker$1 implements MutationCallback<String> {
    final /* synthetic */ GraphQLPage f19703a;
    final /* synthetic */ PageLiker f19704b;

    PageLiker$1(PageLiker pageLiker, GraphQLPage graphQLPage) {
        this.f19704b = pageLiker;
        this.f19703a = graphQLPage;
    }

    public final /* bridge */ /* synthetic */ void m19983a(Object obj) {
    }

    public final /* bridge */ /* synthetic */ void m19985b(Object obj) {
    }

    public final /* bridge */ /* synthetic */ void m19986c(Object obj) {
    }

    public final void m19984a(Object obj, ServiceException serviceException) {
        this.f19704b.b.a(CommonEventsBuilder.a("ego_page_like_fail", this.f19703a.ae(), String.valueOf(this.f19703a.O()), "native_newsfeed"));
    }
}
