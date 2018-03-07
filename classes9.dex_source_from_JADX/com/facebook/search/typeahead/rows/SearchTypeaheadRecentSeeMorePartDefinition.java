package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.model.NullStateSeeMoreTypeaheadUnit;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.suggestions.viewbinder.RecentSearchSeeMoreView;

@ContextScoped
/* compiled from: vault_image_upload_api missing id */
public class SearchTypeaheadRecentSeeMorePartDefinition extends MultiRowSinglePartDefinition<NullStateSeeMoreTypeaheadUnit, Void, SearchSuggestionsEnvironment, RecentSearchSeeMoreView> {
    public static final ViewType f601a = new C00551();
    private static SearchTypeaheadRecentSeeMorePartDefinition f602b;
    private static final Object f603c = new Object();

    /* compiled from: vault_image_upload_api missing id */
    final class C00551 extends ViewType {
        C00551() {
        }

        public final View m693a(Context context) {
            return LayoutInflater.from(context).inflate(2130906977, null);
        }
    }

    private static SearchTypeaheadRecentSeeMorePartDefinition m695c() {
        return new SearchTypeaheadRecentSeeMorePartDefinition();
    }

    public final ViewType m696a() {
        return f601a;
    }

    public final boolean m697a(Object obj) {
        return true;
    }

    public static SearchTypeaheadRecentSeeMorePartDefinition m694a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadRecentSeeMorePartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f603c) {
                SearchTypeaheadRecentSeeMorePartDefinition searchTypeaheadRecentSeeMorePartDefinition;
                if (a2 != null) {
                    searchTypeaheadRecentSeeMorePartDefinition = (SearchTypeaheadRecentSeeMorePartDefinition) a2.a(f603c);
                } else {
                    searchTypeaheadRecentSeeMorePartDefinition = f602b;
                }
                if (searchTypeaheadRecentSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m695c();
                        if (a2 != null) {
                            a2.a(f603c, c);
                        } else {
                            f602b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = searchTypeaheadRecentSeeMorePartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
