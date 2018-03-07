package com.facebook.pages.messaging.responsiveness;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.pages.messaging.responsiveness.graphql.FetchPageResponsivenessGraphQL.FetchPageResponsivenessQueryString;
import com.facebook.pages.messaging.responsiveness.graphql.FetchPageResponsivenessGraphQLModels.PageResponsivenessContextModel;
import com.facebook.pages.messaging.responsiveness.graphql.FetchPageResponsivenessGraphQLModels.PageResponsivenessContextModel.ResponsivenessContextModel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: ccu_contacts_upload_failed_event */
public class PageResponsivenessHandler {
    private final PageResponsivenessCache f18443a;
    private final Map<String, ListenableFuture<PageResponsivenessContext>> f18444b = Collections.synchronizedMap(new HashMap());
    public final GraphQLQueryExecutor f18445c;
    public final AnalyticsLogger f18446d;

    /* compiled from: ccu_contacts_upload_failed_event */
    public class C21322 implements Function<PageResponsivenessContextModel, PageResponsivenessContext> {
        final /* synthetic */ PageResponsivenessHandler f18442a;

        public C21322(PageResponsivenessHandler pageResponsivenessHandler) {
            this.f18442a = pageResponsivenessHandler;
        }

        @Nullable
        public Object apply(Object obj) {
            Object obj2;
            PageResponsivenessContextModel pageResponsivenessContextModel = (PageResponsivenessContextModel) obj;
            if (pageResponsivenessContextModel == null || pageResponsivenessContextModel.m18446a() == null) {
                obj2 = null;
            } else {
                ResponsivenessContextModel a = pageResponsivenessContextModel.m18446a();
                PageResponsivenessContext pageResponsivenessContext = new PageResponsivenessContext(PageResponseTimespan.fromGraphQL(a.m18438a()), a.m18441b());
            }
            return obj2;
        }
    }

    @Inject
    public PageResponsivenessHandler(PageResponsivenessCache pageResponsivenessCache, GraphQLQueryExecutor graphQLQueryExecutor, AnalyticsLogger analyticsLogger) {
        this.f18443a = pageResponsivenessCache;
        this.f18445c = graphQLQueryExecutor;
        this.f18446d = analyticsLogger;
    }

    public final synchronized boolean m18428a(String str) {
        return this.f18443a.m18422a(str);
    }

    @Nullable
    public final synchronized PageResponsivenessContext m18429b(String str) {
        Preconditions.checkState(this.f18443a.m18422a(str));
        return this.f18443a.m18423b(str);
    }

    @VisibleForTesting
    public final void m18427a(String str, PageResponsivenessContext pageResponsivenessContext) {
        this.f18443a.m18421a(str, pageResponsivenessContext);
    }

    public final ListenableFuture<PageResponsivenessContext> m18430c(String str) {
        if (m18428a(str)) {
            return Futures.a(m18429b(str));
        }
        if (m18431d(str)) {
            return (ListenableFuture) this.f18444b.get(str);
        }
        return m18425e(str);
    }

    public final synchronized boolean m18431d(String str) {
        return this.f18444b.containsKey(str);
    }

    private ListenableFuture<PageResponsivenessContext> m18425e(final String str) {
        Preconditions.checkArgument(!StringUtil.a(str));
        GraphQlQueryString fetchPageResponsivenessQueryString = new FetchPageResponsivenessQueryString();
        fetchPageResponsivenessQueryString.a("page_id", str);
        GraphQLRequest a = GraphQLRequest.a(fetchPageResponsivenessQueryString);
        a.a(RequestPriority.INTERACTIVE);
        ListenableFuture a2 = Futures.a(GraphQLQueryExecutor.a(this.f18445c.a(a)), new C21322(this), MoreExecutors.a());
        m18424a(str, a2);
        Futures.a(a2, new FutureCallback<PageResponsivenessContext>(this) {
            final /* synthetic */ PageResponsivenessHandler f18441b;

            public void onSuccess(@Nullable Object obj) {
                PageResponsivenessContext pageResponsivenessContext = (PageResponsivenessContext) obj;
                this.f18441b.f18446d.a("received_page_responsiveness_value");
                PageResponsivenessHandler.m18426g(this.f18441b, str);
                this.f18441b.m18427a(str, pageResponsivenessContext);
            }

            public void onFailure(Throwable th) {
                PageResponsivenessHandler.m18426g(this.f18441b, str);
            }
        });
        return a2;
    }

    private synchronized void m18424a(String str, ListenableFuture<PageResponsivenessContext> listenableFuture) {
        this.f18444b.put(str, listenableFuture);
    }

    public static synchronized void m18426g(PageResponsivenessHandler pageResponsivenessHandler, String str) {
        synchronized (pageResponsivenessHandler) {
            pageResponsivenessHandler.f18444b.remove(str);
        }
    }
}
