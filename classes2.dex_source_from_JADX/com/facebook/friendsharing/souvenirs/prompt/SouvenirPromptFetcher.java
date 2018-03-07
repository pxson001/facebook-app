package com.facebook.friendsharing.souvenirs.prompt;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.friendsharing.souvenirs.abtest.ExperimentsForSouvenirAbtestModule;
import com.facebook.friendsharing.souvenirs.manager.SouvenirManager;
import com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager;
import com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager.1;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.inject.Lazy;
import com.facebook.ipc.productionprompts.fetcher.PromptFetcher;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: network_info_dns_resolution_time */
public class SouvenirPromptFetcher implements PromptFetcher {
    private final Lazy<SouvenirManager> f12634a;
    public final Lazy<SouvenirPromptManager> f12635b;
    public final Lazy<SouvenirPromptModelFilter> f12636c;
    public final QeAccessor f12637d;
    public final Clock f12638e;
    private final ExecutorService f12639f;
    private final Executor f12640g;
    public final QuickPerformanceLogger f12641h;
    @Nullable
    public ImmutableList<PromptObject> f12642i;
    private final AbstractDisposableFutureCallback<ImmutableList<PromptObject>> f12643j = new C05221(this);
    private final Function<List<Serializable>, ImmutableList<PromptObject>> f12644k = new C05232(this);

    /* compiled from: network_info_dns_resolution_time */
    class C05221 extends AbstractDisposableFutureCallback<ImmutableList<PromptObject>> {
        final /* synthetic */ SouvenirPromptFetcher f12645a;

        C05221(SouvenirPromptFetcher souvenirPromptFetcher) {
            this.f12645a = souvenirPromptFetcher;
        }

        protected final void mo347a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            this.f12645a.f12642i = (ImmutableList) Preconditions.checkNotNull(immutableList);
            this.f12645a.f12641h.mo456a(9633793, (short) 13, "fetcher", SouvenirPromptFetcher.class.getSimpleName());
        }

        protected final void mo348a(Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* compiled from: network_info_dns_resolution_time */
    class C05232 implements Function<List<Serializable>, ImmutableList<PromptObject>> {
        final /* synthetic */ SouvenirPromptFetcher f12646a;

        C05232(SouvenirPromptFetcher souvenirPromptFetcher) {
            this.f12646a = souvenirPromptFetcher;
        }

        public Object apply(Object obj) {
            List list = (List) obj;
            int i = 0;
            Preconditions.checkState(list.size() == 2);
            ImmutableList immutableList = (ImmutableList) list.get(0);
            ImmutableMap immutableMap = (ImmutableMap) list.get(1);
            ImmutableSet keySet = immutableMap.keySet();
            ImmutableCollection values = immutableMap.values();
            long a = this.f12646a.f12638e.mo211a();
            Optional b = ((SouvenirPromptManager) this.f12646a.f12635b.get()).m19629b();
            if (b.isPresent() && a - ((Long) b.get()).longValue() <= TimeUnit.HOURS.toMillis((long) this.f12646a.f12637d.mo572a(ExperimentsForSouvenirAbtestModule.f12674v, 24))) {
                return RegularImmutableList.f535a;
            }
            if (!values.isEmpty() && a - ((Long) Ordering.m30180d().mo3246b(immutableMap.values())).longValue() <= TimeUnit.HOURS.toMillis((long) this.f12646a.f12637d.mo572a(ExperimentsForSouvenirAbtestModule.f12678z, 6))) {
                return ImmutableList.of();
            }
            int size = immutableList.size();
            while (i < size) {
                SouvenirModel a2 = ((SouvenirPromptModelFilter) this.f12646a.f12636c.get()).a((SouvenirModel) immutableList.get(i), a);
                if (a2 != null) {
                    SouvenirPromptObject souvenirPromptObject = new SouvenirPromptObject(a2);
                    if (!keySet.contains(souvenirPromptObject.mo2493b())) {
                        return ImmutableList.of(souvenirPromptObject);
                    }
                }
                i++;
            }
            return ImmutableList.of();
        }
    }

    @Inject
    public SouvenirPromptFetcher(Lazy<SouvenirManager> lazy, Lazy<SouvenirPromptManager> lazy2, Lazy<SouvenirPromptModelFilter> lazy3, QeAccessor qeAccessor, Clock clock, ExecutorService executorService, Executor executor, QuickPerformanceLogger quickPerformanceLogger) {
        this.f12634a = lazy;
        this.f12635b = lazy2;
        this.f12636c = lazy3;
        this.f12637d = qeAccessor;
        this.f12638e = clock;
        this.f12639f = executorService;
        this.f12640g = executor;
        this.f12641h = quickPerformanceLogger;
    }

    public final boolean mo2490a() {
        return this.f12637d.mo596a(ExperimentsForSouvenirAbtestModule.f12675w, false);
    }

    public final Class<? extends PromptObject> mo2491b() {
        return SouvenirPromptObject.class;
    }

    public final ListenableFuture<ImmutableList<PromptObject>> mo2492c() {
        if (this.f12642i != null) {
            this.f12641h.mo456a(9633793, (short) 25, "fetcher", SouvenirPromptFetcher.class.getSimpleName());
            return Futures.m2452a(this.f12642i);
        }
        ListenableFuture a;
        SouvenirManager souvenirManager = (SouvenirManager) this.f12634a.get();
        if (souvenirManager.n == null) {
            a = Futures.m2452a(souvenirManager.a());
        } else {
            a = souvenirManager.n;
        }
        ListenableFuture listenableFuture = a;
        SouvenirPromptManager souvenirPromptManager = (SouvenirPromptManager) this.f12635b.get();
        ListenableFuture a2 = souvenirPromptManager.f13322a.mo271a(new 1(souvenirPromptManager));
        a2 = Futures.m2450a(Futures.m2454a(listenableFuture, a2), this.f12644k, this.f12639f);
        Futures.m2458a(a2, this.f12643j, this.f12640g);
        return a2;
    }

    public final void mo2488a(Class<? extends PromptObject> cls) {
        if (cls.equals(SouvenirPromptObject.class)) {
            this.f12642i = null;
        }
    }

    public final void mo2489a(Class<? extends PromptObject> cls, String str, boolean z) {
    }
}
