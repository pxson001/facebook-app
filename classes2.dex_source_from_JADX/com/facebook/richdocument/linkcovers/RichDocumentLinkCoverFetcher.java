package com.facebook.richdocument.linkcovers;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQL.RichDocumentLinkCoverConfigQueryString;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_feed_server_failure */
public class RichDocumentLinkCoverFetcher {
    public static final String f24078a = RichDocumentLinkCoverFetcher.class.getSimpleName();
    private static RichDocumentLinkCoverFetcher f24079g;
    private static final Object f24080h = new Object();
    public final AbstractFbErrorReporter f24081b;
    public final GraphQLQueryExecutor f24082c;
    public final TasksManager f24083d;
    public final LinkCoverCache f24084e;
    public final ScreenUtil f24085f;

    private static RichDocumentLinkCoverFetcher m32485b(InjectorLike injectorLike) {
        return new RichDocumentLinkCoverFetcher(FbErrorReporterImpl.m2317a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), TasksManager.m14550b(injectorLike), LinkCoverCache.m32488a(injectorLike), ScreenUtil.m8695a(injectorLike));
    }

    @Inject
    public RichDocumentLinkCoverFetcher(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, LinkCoverCache linkCoverCache, ScreenUtil screenUtil) {
        this.f24081b = abstractFbErrorReporter;
        this.f24082c = graphQLQueryExecutor;
        this.f24083d = tasksManager;
        this.f24084e = linkCoverCache;
        this.f24085f = screenUtil;
    }

    public final void m32486a(LinkCoverFetchParams linkCoverFetchParams, LinkCoverFetchCallback linkCoverFetchCallback) {
        AttachmentCoverLayoutSpec attachmentCoverLayoutSpec = (AttachmentCoverLayoutSpec) this.f24084e.f24087a.m4432a((Object) linkCoverFetchParams.a);
        if (attachmentCoverLayoutSpec != null) {
            linkCoverFetchCallback.a(attachmentCoverLayoutSpec);
            return;
        }
        1 1 = new 1(this, linkCoverFetchParams, linkCoverFetchCallback);
        this.f24083d.m14553a((Object) linkCoverFetchParams.a, this.f24082c.m10446a(GraphQLRequest.m11587a((RichDocumentLinkCoverConfigQueryString) new RichDocumentLinkCoverConfigQueryString().m11315a("instantArticleId", linkCoverFetchParams.a))), new TimerCallbackDelegate(this.f24081b, linkCoverFetchParams.a, 1));
    }

    public static RichDocumentLinkCoverFetcher m32484a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentLinkCoverFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24080h) {
                RichDocumentLinkCoverFetcher richDocumentLinkCoverFetcher;
                if (a2 != null) {
                    richDocumentLinkCoverFetcher = (RichDocumentLinkCoverFetcher) a2.mo818a(f24080h);
                } else {
                    richDocumentLinkCoverFetcher = f24079g;
                }
                if (richDocumentLinkCoverFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32485b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24080h, b3);
                        } else {
                            f24079g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentLinkCoverFetcher;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
