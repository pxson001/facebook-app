package com.facebook.friends;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: me/privacy_education */
public class FriendingCacheHandler {
    private static final ImmutableSet<String> f10532a = ImmutableSet.of("REQUESTS_TAB_REQUESTS_QUERY_TAG");
    public static final ImmutableSet<String> f10533b = ImmutableSet.of("REQUESTS_TAB_PYMK_QUERY_TAG");
    private static final ImmutableSet<String> f10534c = ImmutableSet.of("REQUESTS_TAB_FRIENDS_QUERY_TAG", "REQUESTS_TAB_REQUESTS_QUERY_TAG", "REQUESTS_TAB_PYMK_QUERY_TAG");
    public final GraphQLCacheManager f10535d;
    public final TasksManager f10536e;

    /* compiled from: me/privacy_education */
    public class C06331 implements Callable<ListenableFuture<Void>> {
        final /* synthetic */ FriendingCacheHandler f10523a;

        public C06331(FriendingCacheHandler friendingCacheHandler) {
            this.f10523a = friendingCacheHandler;
        }

        public Object call() {
            return this.f10523a.f10535d.a(FriendingCacheHandler.f10533b);
        }
    }

    /* compiled from: me/privacy_education */
    public class C06342 extends AbstractDisposableFutureCallback<Void> {
        final /* synthetic */ FutureCallback f10524a;
        final /* synthetic */ FriendingCacheHandler f10525b;

        public C06342(FriendingCacheHandler friendingCacheHandler, FutureCallback futureCallback) {
            this.f10525b = friendingCacheHandler;
            this.f10524a = futureCallback;
        }

        protected final void m16700a(@Nullable Object obj) {
            this.f10524a.onSuccess((Void) obj);
        }

        protected final void m16701a(Throwable th) {
            this.f10524a.onFailure(th);
        }
    }

    /* compiled from: me/privacy_education */
    class C06353 implements Callable<ListenableFuture<Void>> {
        final /* synthetic */ FriendingCacheHandler f10526a;

        C06353(FriendingCacheHandler friendingCacheHandler) {
            this.f10526a = friendingCacheHandler;
        }

        public Object call() {
            return this.f10526a.m16706b();
        }
    }

    /* compiled from: me/privacy_education */
    class C06375 implements Callable<ListenableFuture<Void>> {
        final /* synthetic */ FriendingCacheHandler f10529a;

        C06375(FriendingCacheHandler friendingCacheHandler) {
            this.f10529a = friendingCacheHandler;
        }

        public Object call() {
            return this.f10529a.m16708c();
        }
    }

    @Inject
    public FriendingCacheHandler(GraphQLCacheManager graphQLCacheManager, @Assisted TasksManager tasksManager) {
        this.f10535d = graphQLCacheManager;
        this.f10536e = tasksManager;
    }

    public final ListenableFuture<Void> m16706b() {
        return this.f10535d.a(f10532a);
    }

    public final void m16707b(final FutureCallback futureCallback) {
        this.f10536e.a("CLEAR_FRIEND_REQUEST_CACHE_TASK", new C06353(this), new AbstractDisposableFutureCallback<Void>(this) {
            final /* synthetic */ FriendingCacheHandler f10528b;

            protected final void m16702a(@Nullable Object obj) {
                futureCallback.onSuccess((Void) obj);
            }

            protected final void m16703a(Throwable th) {
                futureCallback.onFailure(th);
            }
        });
    }

    public final ListenableFuture<Void> m16708c() {
        return this.f10535d.a(f10534c);
    }

    public final void m16709c(final FutureCallback futureCallback) {
        this.f10536e.a("CLEAR_GRAPH_QL_CACHE_TASK", new C06375(this), new AbstractDisposableFutureCallback<Void>(this) {
            final /* synthetic */ FriendingCacheHandler f10531b;

            protected final void m16704a(@Nullable Object obj) {
                futureCallback.onSuccess((Void) obj);
            }

            protected final void m16705a(Throwable th) {
                futureCallback.onFailure(th);
            }
        });
    }
}
