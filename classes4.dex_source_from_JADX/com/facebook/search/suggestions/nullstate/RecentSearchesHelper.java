package com.facebook.search.suggestions.nullstate;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.model.CachedSuggestionList;
import com.facebook.search.model.HorizontalRecentSearchesUnit;
import com.facebook.search.model.NullStateSeeMoreTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.SuggestionGroup;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.SuggestionsListRowItemFactory;
import com.facebook.search.suggestions.nullstate.mutator.RecentSearchCacheMutator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: load ranking map failed */
public class RecentSearchesHelper {
    private static RecentSearchesHelper f9251e;
    private static final Object f9252f = new Object();
    private final Resources f9253a;
    private final QeAccessor f9254b;
    private final SuggestionsListRowItemFactory f9255c;
    private final Lazy<RecentSearchCacheMutator> f9256d;

    private static RecentSearchesHelper m9613b(InjectorLike injectorLike) {
        return new RecentSearchesHelper(ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SuggestionsListRowItemFactory.m9618a(injectorLike), IdBasedLazy.a(injectorLike, 10862));
    }

    @Inject
    public RecentSearchesHelper(Resources resources, QeAccessor qeAccessor, SuggestionsListRowItemFactory suggestionsListRowItemFactory, Lazy<RecentSearchCacheMutator> lazy) {
        this.f9253a = resources;
        this.f9254b = qeAccessor;
        this.f9255c = suggestionsListRowItemFactory;
        this.f9256d = lazy;
    }

    public final ImmutableList<TypeaheadUnit> m9615a(Type type, CachedSuggestionList cachedSuggestionList, boolean z, int i) {
        Builder builder = new Builder();
        builder.b(cachedSuggestionList.f11766a.subList(0, i));
        if (!z && cachedSuggestionList.f11766a.size() > i) {
            builder.c(new NullStateSeeMoreTypeaheadUnit(type));
        }
        SuggestionGroup.Builder builder2 = new SuggestionGroup.Builder();
        builder2.a = type;
        builder2 = builder2;
        builder2.c = this.f9253a.getString(2131237426);
        builder2 = builder2;
        builder2.d = this.f9253a.getString(2131230734);
        builder2 = builder2;
        builder2.e = 2130840577;
        builder2 = builder2;
        builder2.f = true;
        builder2 = builder2;
        builder2.b = builder.b();
        return SuggestionsListRowItemFactory.m9621b(ImmutableList.of(builder2.a()));
    }

    public static RecentSearchesHelper m9612a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RecentSearchesHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9252f) {
                RecentSearchesHelper recentSearchesHelper;
                if (a2 != null) {
                    recentSearchesHelper = (RecentSearchesHelper) a2.a(f9252f);
                } else {
                    recentSearchesHelper = f9251e;
                }
                if (recentSearchesHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9613b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9252f, b3);
                        } else {
                            f9251e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = recentSearchesHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ImmutableList<TypeaheadUnit> m9614a(Type type, CachedSuggestionList cachedSuggestionList) {
        SuggestionGroup.Builder builder = new SuggestionGroup.Builder();
        builder.a = type;
        builder = builder;
        builder.c = this.f9253a.getString(2131237426);
        builder = builder;
        builder.d = this.f9253a.getString(2131230734);
        builder = builder;
        builder.e = 2130840577;
        builder = builder;
        builder.f = true;
        builder = builder;
        builder.b = ImmutableList.of(new HorizontalRecentSearchesUnit(cachedSuggestionList.f11766a));
        return SuggestionsListRowItemFactory.m9621b(ImmutableList.of(builder.a()));
    }

    public final ImmutableList<TypeaheadUnit> m9616a(String str, NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit, CachedSuggestionList cachedSuggestionList) {
        Builder builder = new Builder();
        builder.c(nullStateSuggestionTypeaheadUnit);
        if (cachedSuggestionList != null && cachedSuggestionList.f11766a != null) {
            int i = 1;
            ImmutableList immutableList = cachedSuggestionList.f11766a;
            int size = immutableList.size();
            int i2 = 0;
            while (i2 < size) {
                TypeaheadUnit typeaheadUnit = (TypeaheadUnit) immutableList.get(i2);
                if (i == 15) {
                    break;
                }
                int i3;
                if (typeaheadUnit.equals(nullStateSuggestionTypeaheadUnit)) {
                    i3 = i;
                } else {
                    builder.c(typeaheadUnit);
                    i3 = i + 1;
                }
                i2++;
                i = i3;
            }
        }
        ((RecentSearchCacheMutator) this.f9256d.get()).a(str, nullStateSuggestionTypeaheadUnit, 15);
        return builder.b();
    }
}
