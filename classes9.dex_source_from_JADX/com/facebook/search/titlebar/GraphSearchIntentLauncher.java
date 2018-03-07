package com.facebook.search.titlebar;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.logging.perf.SearchPerfLogger;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.search.suggestions.nullstate.SearchNullStateListSupplier;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: video_home_live_hscroll_perf */
public class GraphSearchIntentLauncher {
    private static final CallerContext f387a = CallerContext.a(GraphSearchIntentLauncher.class, "search");
    private static GraphSearchIntentLauncher f388g;
    private static final Object f389h = new Object();
    private final Context f390b;
    private final SecureContextHelper f391c;
    private final Provider<ComponentName> f392d;
    private final Provider<SearchNullStateListSupplier> f393e;
    private final Provider<SearchPerfLogger> f394f;

    private static GraphSearchIntentLauncher m510b(InjectorLike injectorLike) {
        return new GraphSearchIntentLauncher((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 12), IdBasedSingletonScopeProvider.a(injectorLike, 3399), IdBasedProvider.a(injectorLike, 10496));
    }

    @Inject
    public GraphSearchIntentLauncher(Context context, SecureContextHelper secureContextHelper, @FragmentChromeActivity Provider<ComponentName> provider, Provider<SearchNullStateListSupplier> provider2, Provider<SearchPerfLogger> provider3) {
        this.f390b = context;
        this.f391c = secureContextHelper;
        this.f392d = provider;
        this.f393e = provider2;
        this.f394f = provider3;
    }

    public final void m511a(GraphSearchQuery graphSearchQuery) {
        m512a(graphSearchQuery, null);
    }

    public final void m512a(GraphSearchQuery graphSearchQuery, Bundle bundle) {
        Intent putExtra = new Intent().setComponent((ComponentName) this.f392d.get()).putExtra("target_fragment", ContentFragmentType.SEARCH_FRAGMENT.ordinal());
        if (bundle != null) {
            putExtra.putExtras(bundle);
        }
        m509a(graphSearchQuery, putExtra);
    }

    public static GraphSearchIntentLauncher m508a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphSearchIntentLauncher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f389h) {
                GraphSearchIntentLauncher graphSearchIntentLauncher;
                if (a2 != null) {
                    graphSearchIntentLauncher = (GraphSearchIntentLauncher) a2.a(f389h);
                } else {
                    graphSearchIntentLauncher = f388g;
                }
                if (graphSearchIntentLauncher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m510b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f389h, b3);
                        } else {
                            f388g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = graphSearchIntentLauncher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m513b(GraphSearchQuery graphSearchQuery) {
        m509a(graphSearchQuery, new Intent().setComponent((ComponentName) this.f392d.get()).setFlags(268435456).putExtra("target_fragment", ContentFragmentType.SEARCH_FRAGMENT.ordinal()));
    }

    private void m509a(GraphSearchQuery graphSearchQuery, Intent intent) {
        if (graphSearchQuery != null) {
            intent.putExtra("initial_typeahead_query", graphSearchQuery);
        }
        ((SearchPerfLogger) this.f394f.get()).b();
        ((SearchNullStateListSupplier) this.f393e.get()).a(f387a, RefreshPolicy.MEMORY);
        this.f391c.a(intent, this.f390b);
    }
}
