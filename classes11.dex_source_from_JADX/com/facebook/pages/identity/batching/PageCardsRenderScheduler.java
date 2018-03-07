package com.facebook.pages.identity.batching;

import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: privacy_photo_checkup */
public class PageCardsRenderScheduler {
    private final boolean f3164a;
    private final Provider<GatekeeperStore> f3165b;
    private final PageCardType f3166c;
    public final SettableFuture<Boolean> f3167d = SettableFuture.f();
    private final SettableFuture<GraphQLResult<?>> f3168e = SettableFuture.f();
    private List<Runnable> f3169f;

    /* compiled from: privacy_photo_checkup */
    class C04301 implements FutureCallback<List<GraphQLResult<?>>> {
        final /* synthetic */ PageCardsRenderScheduler f3163a;

        C04301(PageCardsRenderScheduler pageCardsRenderScheduler) {
            this.f3163a = pageCardsRenderScheduler;
        }

        public void onSuccess(@Nullable Object obj) {
            FutureDetour.a(this.f3163a.f3167d, Boolean.valueOf(true), -1422323456);
        }

        public void onFailure(Throwable th) {
            this.f3163a.f3167d.a(th);
        }
    }

    @Inject
    public PageCardsRenderScheduler(@Assisted PageCardType pageCardType, @Assisted Boolean bool, Provider<GatekeeperStore> provider) {
        this.f3166c = pageCardType;
        this.f3164a = bool.booleanValue();
        this.f3165b = provider;
    }

    public final SettableFuture<Boolean> m4242a(Builder<ListenableFuture<? extends GraphQLResult<?>>> builder) {
        if (m4241b()) {
            builder.c(this.f3168e);
        }
        Futures.a(Futures.a(builder.b()), new C04301(this));
        return this.f3167d;
    }

    public final void m4244a(PageCardType pageCardType, Runnable runnable) {
        if (!m4241b() || pageCardType == this.f3166c || this.f3168e.isDone()) {
            runnable.run();
            return;
        }
        if (this.f3169f == null) {
            this.f3169f = new ArrayList();
        }
        this.f3169f.add(runnable);
    }

    public final void m4243a() {
        if (m4241b()) {
            if (this.f3169f != null) {
                for (Runnable run : this.f3169f) {
                    run.run();
                }
                this.f3169f.clear();
            }
            FutureDetour.a(this.f3168e, new GraphQLResult.Builder().a(), 228636391);
        }
    }

    private boolean m4241b() {
        return ((GatekeeperStoreImpl) this.f3165b.get()).a(PagesFb4aAbTestGatekeepers.d, false) && !this.f3164a;
    }
}
