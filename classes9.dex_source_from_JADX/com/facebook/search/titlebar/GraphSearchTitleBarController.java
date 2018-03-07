package com.facebook.search.titlebar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsEventNames.ContentFragmentType;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQueryProvider;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.logging.perf.SearchPerfLogger;
import com.facebook.search.suggestions.nullstate.SearchNullStateListSupplier;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: video_frame_width */
public class GraphSearchTitleBarController {
    private static GraphSearchTitleBarController f395f;
    private static final Object f396g = new Object();
    private final AnalyticsLogger f397a;
    private final Provider<SearchPerfLogger> f398b;
    private final GatekeeperStoreImpl f399c;
    private final GraphSearchIntentLauncher f400d;
    private final SearchNullStateListSupplier f401e;

    private static GraphSearchTitleBarController m517b(InjectorLike injectorLike) {
        return new GraphSearchTitleBarController(AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 10496), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphSearchIntentLauncher.m508a(injectorLike), SearchNullStateListSupplier.a(injectorLike));
    }

    @Inject
    public GraphSearchTitleBarController(AnalyticsLogger analyticsLogger, Provider<SearchPerfLogger> provider, GatekeeperStore gatekeeperStore, GraphSearchIntentLauncher graphSearchIntentLauncher, SearchNullStateListSupplier searchNullStateListSupplier) {
        this.f397a = analyticsLogger;
        this.f398b = provider;
        this.f399c = gatekeeperStore;
        this.f400d = graphSearchIntentLauncher;
        this.f401e = searchNullStateListSupplier;
    }

    public final void m518a(Fragment fragment, ContentFragmentType contentFragmentType) {
        m519a(fragment, contentFragmentType, null);
    }

    public static GraphSearchTitleBarController m514a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphSearchTitleBarController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f396g) {
                GraphSearchTitleBarController graphSearchTitleBarController;
                if (a2 != null) {
                    graphSearchTitleBarController = (GraphSearchTitleBarController) a2.a(f396g);
                } else {
                    graphSearchTitleBarController = f395f;
                }
                if (graphSearchTitleBarController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m517b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f396g, b3);
                        } else {
                            f395f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = graphSearchTitleBarController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m519a(Fragment fragment, ContentFragmentType contentFragmentType, Bundle bundle) {
        m516a(fragment != null ? fragment.getClass().getSimpleName() : null, contentFragmentType);
        SearchPerfLogger searchPerfLogger = (SearchPerfLogger) this.f398b.get();
        this.f401e.c();
        NullStateStatus nullStateStatus = NullStateStatus.READY;
        searchPerfLogger.a();
        m515a(fragment, bundle);
    }

    private void m516a(@Nullable String str, ContentFragmentType contentFragmentType) {
        if (StringUtil.a(str)) {
            str = "null_content_fragment";
        }
        this.f397a.a(new HoneyClientEvent("titlebar_search_pressed").b("search_origin_activity_type", contentFragmentType.toString()).b("origin_fragment", str));
    }

    private void m515a(Fragment fragment, Bundle bundle) {
        GraphSearchQuery graphSearchQuery = null;
        if ((fragment instanceof GraphSearchQueryProvider) && this.f399c.a(SearchAbTestGatekeepers.f).asBoolean(false)) {
            graphSearchQuery = ((GraphSearchQueryProvider) fragment).q();
        }
        this.f400d.m512a(graphSearchQuery, bundle);
    }
}
