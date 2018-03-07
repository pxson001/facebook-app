package com.facebook.messaging.messagerequests.snippet;

import android.content.Intent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.messagerequests.snippet.graphql.MessageRequestsSnippetQuery.MessageRequestsSnippetString;
import com.facebook.messaging.messagerequests.snippet.graphql.MessageRequestsSnippetQueryModels.MessageRequestsSnippetModel;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

@UserScoped
/* compiled from: saved_dash_items_scroll_perf */
public class MessageRequestsSnippetFetcher {
    private static final Object f3262h = new Object();
    private final FbLocalBroadcastManager f3263a;
    private final GraphQLQueryExecutor f3264b;
    private final GraphQLCacheManager f3265c;
    public final MessageRequestsSnippetParser f3266d;
    private final GatekeeperStoreImpl f3267e;
    private long f3268f;
    @GuardedBy("this")
    private FutureAndCallbackHolder<MessageRequestsSnippet> f3269g = null;

    /* compiled from: saved_dash_items_scroll_perf */
    class C05262 extends AbstractDisposableFutureCallback<MessageRequestsSnippet> {
        final /* synthetic */ MessageRequestsSnippetFetcher f3260a;

        C05262(MessageRequestsSnippetFetcher messageRequestsSnippetFetcher) {
            this.f3260a = messageRequestsSnippetFetcher;
        }

        public final void m3172a(Throwable th) {
            synchronized (this.f3260a) {
                this.f3260a.f3269g = null;
            }
        }
    }

    /* compiled from: saved_dash_items_scroll_perf */
    class C05273 implements Function<GraphQLResult<MessageRequestsSnippetModel>, MessageRequestsSnippet> {
        final /* synthetic */ MessageRequestsSnippetFetcher f3261a;

        C05273(MessageRequestsSnippetFetcher messageRequestsSnippetFetcher) {
            this.f3261a = messageRequestsSnippetFetcher;
        }

        @Nullable
        public Object apply(Object obj) {
            MessageRequestsSnippet messageRequestsSnippet;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Preconditions.checkNotNull(graphQLResult);
            MessageRequestsSnippetParser messageRequestsSnippetParser = this.f3261a.f3266d;
            if (graphQLResult == null) {
                ((AbstractFbErrorReporter) messageRequestsSnippetParser.f3270a.get()).a("message_requests_count_query_result", "Graphql MessageRequestsSnipperQuery result is null");
                messageRequestsSnippet = null;
            } else {
                Preconditions.checkNotNull(((MessageRequestsSnippetModel) graphQLResult.e).m3195a());
                int j = ((MessageRequestsSnippetModel) graphQLResult.e).m3195a().m3191j();
                Preconditions.checkNotNull(((MessageRequestsSnippetModel) graphQLResult.e).m3195a());
                messageRequestsSnippet = new MessageRequestsSnippet(j, ((MessageRequestsSnippetModel) graphQLResult.e).m3195a().m3189a());
            }
            return messageRequestsSnippet;
        }
    }

    private static MessageRequestsSnippetFetcher m3175b(InjectorLike injectorLike) {
        return new MessageRequestsSnippetFetcher(GraphQLQueryExecutor.a(injectorLike), GraphQLCacheManager.a(injectorLike), FbLocalBroadcastManagerMethodAutoProvider.a(injectorLike), new MessageRequestsSnippetParser(IdBasedSingletonScopeProvider.b(injectorLike, 494)), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    private static GraphQLRequest<MessageRequestsSnippetModel> m3178f() {
        GraphQlQueryString messageRequestsSnippetString = new MessageRequestsSnippetString();
        messageRequestsSnippetString.a("max_names_count", Integer.valueOf(3));
        return GraphQLRequest.a(messageRequestsSnippetString);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippetFetcher m3174a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f3262h;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m3175b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3262h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippetFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippetFetcher) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f3262h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippetFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippetFetcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippetFetcher");
    }

    @Inject
    public MessageRequestsSnippetFetcher(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager, FbLocalBroadcastManager fbLocalBroadcastManager, MessageRequestsSnippetParser messageRequestsSnippetParser, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f3263a = fbLocalBroadcastManager;
        this.f3264b = graphQLQueryExecutor;
        this.f3265c = graphQLCacheManager;
        this.f3266d = messageRequestsSnippetParser;
        this.f3267e = gatekeeperStoreImpl;
        this.f3268f = this.f3267e.a(245, false) ? 43200 : 3600;
    }

    public final synchronized MessageRequestsSnippet m3180a() {
        MessageRequestsSnippet messageRequestsSnippet;
        if (m3176d()) {
            try {
                ListenableFuture a = this.f3269g.a();
                messageRequestsSnippet = a.isDone() ? (MessageRequestsSnippet) FutureDetour.a(a, -1429094459) : null;
            } catch (CancellationException e) {
                messageRequestsSnippet = null;
                return messageRequestsSnippet;
            } catch (InterruptedException e2) {
                messageRequestsSnippet = null;
                return messageRequestsSnippet;
            } catch (ExecutionException e3) {
                messageRequestsSnippet = null;
                return messageRequestsSnippet;
            }
        }
        messageRequestsSnippet = null;
        return messageRequestsSnippet;
    }

    public final synchronized ListenableFuture<MessageRequestsSnippet> m3181b() {
        ListenableFuture<MessageRequestsSnippet> b;
        if (m3176d()) {
            b = Futures.b(this.f3269g.a());
        } else {
            ListenableFuture e = m3177e();
            C05262 c05262 = new C05262(this);
            this.f3269g = FutureAndCallbackHolder.a(e, c05262);
            Futures.a(e, c05262);
            b = Futures.b(e);
        }
        return b;
    }

    @GuardedBy("this")
    private boolean m3176d() {
        return this.f3269g != null;
    }

    private ListenableFuture<MessageRequestsSnippet> m3177e() {
        GraphQLRequest f = m3178f();
        f.a(GraphQLCachePolicy.a);
        f.a(this.f3268f);
        return Futures.a(this.f3264b.a(f), new C05273(this));
    }

    public final void m3182c() {
        synchronized (this) {
            if (this.f3269g != null) {
                this.f3269g.a(false);
                this.f3269g = null;
            }
        }
        this.f3265c.a(m3178f());
        m3179g();
    }

    private final void m3179g() {
        this.f3263a.a(new Intent(MessagesBroadcastIntents.t));
    }
}
