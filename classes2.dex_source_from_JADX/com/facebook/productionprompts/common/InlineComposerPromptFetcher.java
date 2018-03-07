package com.facebook.productionprompts.common;

import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.productionprompts.fetcher.PromptFetcher;
import com.facebook.ipc.productionprompts.fetcher.STATICDI_MULTIBIND_PROVIDER$PromptFetcher;
import com.facebook.productionprompts.abtest.ProductionPromptsGatekeepers;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: network_info_ingress_max */
public class InlineComposerPromptFetcher implements PromptFetcher {
    @VisibleForTesting
    final ImmutableMap<Class<? extends PromptObject>, PromptFetcher> f12585a;
    private final GatekeeperStoreImpl f12586b;
    private final QeAccessor f12587c;

    /* compiled from: network_info_ingress_max */
    class C05771 implements Function<PromptFetcher, ListenableFuture<ImmutableList<PromptObject>>> {
        final /* synthetic */ InlineComposerPromptFetcher f13934a;

        C05771(InlineComposerPromptFetcher inlineComposerPromptFetcher) {
            this.f13934a = inlineComposerPromptFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            return ((PromptFetcher) Preconditions.checkNotNull((PromptFetcher) obj)).mo2492c();
        }
    }

    /* compiled from: network_info_ingress_max */
    class C05882 implements Function<List<ImmutableList<PromptObject>>, ImmutableList<PromptObject>> {
        final /* synthetic */ InlineComposerPromptFetcher f14020a;

        C05882(InlineComposerPromptFetcher inlineComposerPromptFetcher) {
            this.f14020a = inlineComposerPromptFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            List list = (List) obj;
            Preconditions.checkNotNull(list);
            return ImmutableList.copyOf(Iterables.m972f(list));
        }
    }

    public static InlineComposerPromptFetcher m18661a(InjectorLike injectorLike) {
        return new InlineComposerPromptFetcher(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PromptFetcher(injectorLike)), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public InlineComposerPromptFetcher(Set<PromptFetcher> set, GatekeeperStore gatekeeperStore, QeAccessor qeAccessor) {
        Builder builder = ImmutableMap.builder();
        for (PromptFetcher promptFetcher : set) {
            if (promptFetcher.mo2490a()) {
                builder.m609b(promptFetcher.mo2491b(), promptFetcher);
            }
        }
        this.f12585a = builder.m610b();
        this.f12586b = gatekeeperStore;
        this.f12587c = qeAccessor;
    }

    public final boolean mo2490a() {
        return (this.f12586b.m2189a(ProductionPromptsGatekeepers.f13528b, false) || this.f12587c.mo596a(ExperimentsForFeedUtilComposerAbtestModule.ae, false)) ? false : true;
    }

    public final Class<? extends PromptObject> mo2491b() {
        return PromptObject.class;
    }

    public final ListenableFuture<ImmutableList<PromptObject>> mo2492c() {
        return Futures.m2450a(Futures.m2451a(Lists.m1303a(this.f12585a.values().asList(), new C05771(this))), new C05882(this), MoreExecutors.m1813a());
    }

    public final void mo2488a(Class<? extends PromptObject> cls) {
        Preconditions.checkArgument(this.f12585a.containsKey(cls));
        ((PromptFetcher) this.f12585a.get(cls)).mo2488a(cls);
    }

    public final void mo2489a(Class<? extends PromptObject> cls, String str, boolean z) {
        Preconditions.checkArgument(this.f12585a.containsKey(cls));
        ((PromptFetcher) this.f12585a.get(cls)).mo2489a(cls, str, z);
    }
}
