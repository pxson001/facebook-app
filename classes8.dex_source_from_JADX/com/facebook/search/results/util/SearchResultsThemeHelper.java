package com.facebook.search.results.util;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.SearchTheme;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: PHOTO_TAP */
public class SearchResultsThemeHelper {
    private static SearchResultsThemeHelper f25327a;
    private static final Object f25328b = new Object();

    private static SearchResultsThemeHelper m28571a() {
        return new SearchResultsThemeHelper();
    }

    public static ContextThemeWrapper m28569a(Context context, @Nullable Bundle bundle) {
        int i;
        Object obj = m28570a(bundle) == SearchTheme.DARK ? 1 : null;
        Context contextThemeWrapper = new ContextThemeWrapper(context, obj != null ? 2131625889 : 2131625890);
        if (obj != null) {
            i = 2131626192;
        } else {
            i = 2131626191;
        }
        return new ContextThemeWrapper(contextThemeWrapper, i);
    }

    public static SearchTheme m28570a(@Nullable Bundle bundle) {
        if (bundle == null) {
            return SearchTheme.LIGHT;
        }
        SearchTheme searchTheme = (SearchTheme) bundle.getSerializable("search_theme");
        if (searchTheme == null) {
            return ((ScopedEntityType) bundle.getSerializable("graph_search_scoped_entity_type")) == ScopedEntityType.VIDEO ? SearchTheme.DARK : SearchTheme.LIGHT;
        } else {
            return searchTheme;
        }
    }

    public static SearchResultsThemeHelper m28572a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsThemeHelper a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f25328b) {
                SearchResultsThemeHelper searchResultsThemeHelper;
                if (a3 != null) {
                    searchResultsThemeHelper = (SearchResultsThemeHelper) a3.a(f25328b);
                } else {
                    searchResultsThemeHelper = f25327a;
                }
                if (searchResultsThemeHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m28571a();
                        if (a3 != null) {
                            a3.a(f25328b, a2);
                        } else {
                            f25327a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = searchResultsThemeHelper;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
