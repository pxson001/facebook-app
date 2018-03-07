package com.facebook.search.suggestions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.bootstrap.db.data.BootstrapDbCacheWarmer;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader;
import com.facebook.search.bootstrap.sync.BootstrapKeywordsLoader;
import com.facebook.search.events.FriendshipEventSubscriber;
import com.facebook.search.suggestions.simplesearch.RemoteTypeaheadFetcher;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

@ContextScoped
/* compiled from: 😱 */
public class SearchSuggestionsInitializer {
    private static SearchSuggestionsInitializer f0m;
    private static final Object f1n = new Object();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BootstrapEntitiesLoader> f2a = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BootstrapKeywordsLoader> f3b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<BootstrapDbCacheWarmer> f4c = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FriendshipEventSubscriber> f5d = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RemoteTypeaheadFetcher> f6e = UltralightRuntime.b;
    private boolean f7f;
    public final boolean f8g;
    public final boolean f9h;
    private final boolean f10i;
    public final boolean f11j;
    private final boolean f12k;
    private final boolean f13l;

    private static SearchSuggestionsInitializer m31b(InjectorLike injectorLike) {
        SearchSuggestionsInitializer searchSuggestionsInitializer = new SearchSuggestionsInitializer((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
        searchSuggestionsInitializer.m30a(IdBasedSingletonScopeProvider.b(injectorLike, 10475), IdBasedSingletonScopeProvider.b(injectorLike, 10476), IdBasedLazy.a(injectorLike, 10463), IdBasedLazy.a(injectorLike, 10478), IdBasedLazy.a(injectorLike, 10868));
        return searchSuggestionsInitializer;
    }

    @Inject
    private SearchSuggestionsInitializer(QeAccessor qeAccessor) {
        this.f8g = qeAccessor.a(ExperimentsForSearchAbTestModule.S, false);
        this.f9h = qeAccessor.a(ExperimentsForSearchAbTestModule.Q, false);
        this.f10i = qeAccessor.a(ExperimentsForSearchAbTestModule.P, false);
        this.f11j = qeAccessor.a(ExperimentsForSearchAbTestModule.R, false);
        this.f12k = qeAccessor.a(ExperimentsForSearchAbTestModule.bq, true);
        this.f13l = qeAccessor.a(ExperimentsForSearchAbTestModule.br, true);
    }

    public static SearchSuggestionsInitializer m29a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchSuggestionsInitializer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1n) {
                SearchSuggestionsInitializer searchSuggestionsInitializer;
                if (a2 != null) {
                    searchSuggestionsInitializer = (SearchSuggestionsInitializer) a2.a(f1n);
                } else {
                    searchSuggestionsInitializer = f0m;
                }
                if (searchSuggestionsInitializer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m31b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1n, b3);
                        } else {
                            f0m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchSuggestionsInitializer;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m33a() {
        if (!this.f7f) {
            if (this.f10i) {
                m32f();
            }
            if (this.f11j) {
                ((FriendshipEventSubscriber) this.f5d.get()).a();
            }
            if (this.f9h) {
                ((BootstrapDbCacheWarmer) this.f4c.get()).a();
            }
            if (this.f8g) {
                ((RemoteTypeaheadFetcher) this.f6e.get()).m400g();
            }
            this.f7f = true;
        }
    }

    public final void m34c() {
        if (!this.f10i) {
            m32f();
        }
    }

    private void m30a(com.facebook.inject.Lazy<BootstrapEntitiesLoader> lazy, com.facebook.inject.Lazy<BootstrapKeywordsLoader> lazy2, com.facebook.inject.Lazy<BootstrapDbCacheWarmer> lazy3, com.facebook.inject.Lazy<FriendshipEventSubscriber> lazy4, com.facebook.inject.Lazy<RemoteTypeaheadFetcher> lazy5) {
        this.f2a = lazy;
        this.f3b = lazy2;
        this.f4c = lazy3;
        this.f5d = lazy4;
        this.f6e = lazy5;
    }

    private void m32f() {
        if (this.f12k) {
            ((BootstrapEntitiesLoader) this.f2a.get()).a();
        }
        if (this.f13l) {
            ((BootstrapKeywordsLoader) this.f3b.get()).a();
        }
    }
}
