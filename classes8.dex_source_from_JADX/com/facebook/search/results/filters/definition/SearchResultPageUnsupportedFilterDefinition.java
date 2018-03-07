package com.facebook.search.results.filters.definition;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinition.FilterPillData;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinition.ViewSpec;
import com.facebook.search.results.filters.ui.SearchResultFilterExpandableListAdapter.C24401;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment.C24411;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel.MainFilterModel;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: SLIDE_RIGHT */
public class SearchResultPageUnsupportedFilterDefinition implements SearchResultPageFilterDefinition<BetterTextView, BetterTextView> {
    private static final ViewSpec<BetterTextView> f22844a = new C24281();
    private static final ViewSpec<BetterTextView> f22845b = new C24292();
    private static SearchResultPageUnsupportedFilterDefinition f22846c;
    private static final Object f22847d = new Object();

    /* compiled from: SLIDE_RIGHT */
    final class C24281 implements ViewSpec<BetterTextView> {
        C24281() {
        }

        public final View mo1272a(Context context) {
            return new BetterTextView(context);
        }
    }

    /* compiled from: SLIDE_RIGHT */
    final class C24292 implements ViewSpec<BetterTextView> {
        C24292() {
        }

        public final View mo1272a(Context context) {
            return new BetterTextView(context);
        }
    }

    private static SearchResultPageUnsupportedFilterDefinition m26498c() {
        return new SearchResultPageUnsupportedFilterDefinition();
    }

    public final void mo1276a(MainFilterModel mainFilterModel, View view, FilterPersistentState filterPersistentState) {
        ((BetterTextView) view).setText(mainFilterModel.jo_());
    }

    public final void mo1277a(MainFilterModel mainFilterModel, View view, FilterPersistentState filterPersistentState, C24411 c24411, C24401 c24401) {
        ((BetterTextView) view).setText("Unsupported");
    }

    public final ViewSpec<BetterTextView> mo1275a() {
        return f22844a;
    }

    public final ViewSpec<BetterTextView> mo1278b() {
        return f22845b;
    }

    public static SearchResultPageUnsupportedFilterDefinition m26497a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultPageUnsupportedFilterDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22847d) {
                SearchResultPageUnsupportedFilterDefinition searchResultPageUnsupportedFilterDefinition;
                if (a2 != null) {
                    searchResultPageUnsupportedFilterDefinition = (SearchResultPageUnsupportedFilterDefinition) a2.a(f22847d);
                } else {
                    searchResultPageUnsupportedFilterDefinition = f22846c;
                }
                if (searchResultPageUnsupportedFilterDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m26498c();
                        if (a2 != null) {
                            a2.a(f22847d, c);
                        } else {
                            f22846c = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = searchResultPageUnsupportedFilterDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }

    public final FilterPillData mo1274a(FilterPersistentState filterPersistentState) {
        return new FilterPillData("Unsupported", null, null);
    }

    @Nullable
    public final FilterPersistentState mo1273a(String str, FilterValuesModel filterValuesModel) {
        return null;
    }
}
