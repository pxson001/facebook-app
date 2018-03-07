package com.facebook.search.suggestions.systems;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.util.GraphSearchConfig;
import javax.inject.Inject;

/* compiled from: viewer() { peer_to_peer_payments { peer_to_peer_payment_methods { %s } } } */
public class SearchTypeaheadSystemFactory {
    public final Lazy<SimpleSearchTypeaheadSystem> f321a;
    public final Lazy<FlipOnceKeywordSearchTypeaheadSystem> f322b;
    public final Lazy<KeywordsOnTopSearchTypeaheadSystem> f323c;
    public final Lazy<ScopedSearchTypeaheadSystem> f324d;
    public final Lazy<SingleStateSearchTypeaheadSystem> f325e;
    public final Lazy<NeueSingleStateSearchTypeaheadSystem> f326f;
    public final Lazy<SearchKeywordsOnlyTypeaheadSystem> f327g;
    public final Lazy<SearchKeywordsEntitiesTypeaheadSystem> f328h;
    public final GraphSearchConfig f329i;
    public final QeAccessor f330j;
    public GatekeeperStoreImpl f331k;

    public static SearchTypeaheadSystemFactory m474b(InjectorLike injectorLike) {
        return new SearchTypeaheadSystemFactory(IdBasedLazy.a(injectorLike, 10881), IdBasedLazy.a(injectorLike, 10873), IdBasedLazy.a(injectorLike, 10874), IdBasedLazy.a(injectorLike, 10877), IdBasedLazy.a(injectorLike, 10882), IdBasedLazy.a(injectorLike, 10875), IdBasedLazy.a(injectorLike, 10879), IdBasedLazy.a(injectorLike, 10878), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphSearchConfig.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SearchTypeaheadSystemFactory(Lazy<SimpleSearchTypeaheadSystem> lazy, Lazy<FlipOnceKeywordSearchTypeaheadSystem> lazy2, Lazy<KeywordsOnTopSearchTypeaheadSystem> lazy3, Lazy<ScopedSearchTypeaheadSystem> lazy4, Lazy<SingleStateSearchTypeaheadSystem> lazy5, Lazy<NeueSingleStateSearchTypeaheadSystem> lazy6, Lazy<SearchKeywordsOnlyTypeaheadSystem> lazy7, Lazy<SearchKeywordsEntitiesTypeaheadSystem> lazy8, GatekeeperStore gatekeeperStore, GraphSearchConfig graphSearchConfig, QeAccessor qeAccessor) {
        this.f321a = lazy;
        this.f322b = lazy2;
        this.f324d = lazy4;
        this.f325e = lazy5;
        this.f326f = lazy6;
        this.f327g = lazy7;
        this.f328h = lazy8;
        this.f329i = graphSearchConfig;
        this.f323c = lazy3;
        this.f331k = gatekeeperStore;
        this.f330j = qeAccessor;
    }
}
