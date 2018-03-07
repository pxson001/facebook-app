package com.facebook.search.suggestions.nullstate;

import android.content.Context;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ForegroundExecutorService;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.typeahead.rows.SearchTypeaheadRootGroupPartDefinition;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

@ContextScoped
/* compiled from: webview_destroy_exception */
public class NullStatePartDefinitionInitializer {
    private static NullStatePartDefinitionInitializer f187f;
    private static final Object f188g = new Object();
    @Inject
    @Lazy
    @ForegroundExecutorService
    public com.facebook.inject.Lazy<ExecutorService> f189a = UltralightRuntime.b;
    @Inject
    @Lazy
    @BackgroundExecutorService
    public com.facebook.inject.Lazy<ExecutorService> f190b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchTypeaheadRootGroupPartDefinition> f191c = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GatekeeperStore> f192d = UltralightRuntime.b;
    private final AtomicBoolean f193e = new AtomicBoolean(false);

    /* compiled from: webview_destroy_exception */
    class C00251 implements Runnable {
        final /* synthetic */ NullStatePartDefinitionInitializer f186a;

        C00251(NullStatePartDefinitionInitializer nullStatePartDefinitionInitializer) {
            this.f186a = nullStatePartDefinitionInitializer;
        }

        public void run() {
            ((SearchTypeaheadRootGroupPartDefinition) this.f186a.f191c.get()).getClass();
        }
    }

    private static NullStatePartDefinitionInitializer m324b(InjectorLike injectorLike) {
        NullStatePartDefinitionInitializer nullStatePartDefinitionInitializer = new NullStatePartDefinitionInitializer();
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 3841);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 3832);
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 10920);
        com.facebook.inject.Lazy b3 = IdBasedSingletonScopeProvider.b(injectorLike, 2128);
        nullStatePartDefinitionInitializer.f189a = b;
        nullStatePartDefinitionInitializer.f190b = b2;
        nullStatePartDefinitionInitializer.f191c = a;
        nullStatePartDefinitionInitializer.f192d = b3;
        return nullStatePartDefinitionInitializer;
    }

    public final void m326a() {
        if (!this.f193e.getAndSet(true)) {
            if (((GatekeeperStoreImpl) this.f192d.get()).a(SearchAbTestGatekeepers.J, false)) {
                ExecutorDetour.a((ExecutorService) this.f189a.get(), m325b(), -682413479);
            } else {
                ExecutorDetour.a((ExecutorService) this.f190b.get(), m325b(), 1908583792);
            }
        }
    }

    private Runnable m325b() {
        return new C00251(this);
    }

    public static NullStatePartDefinitionInitializer m323a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStatePartDefinitionInitializer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f188g) {
                NullStatePartDefinitionInitializer nullStatePartDefinitionInitializer;
                if (a2 != null) {
                    nullStatePartDefinitionInitializer = (NullStatePartDefinitionInitializer) a2.a(f188g);
                } else {
                    nullStatePartDefinitionInitializer = f187f;
                }
                if (nullStatePartDefinitionInitializer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m324b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f188g, b3);
                        } else {
                            f187f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStatePartDefinitionInitializer;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
