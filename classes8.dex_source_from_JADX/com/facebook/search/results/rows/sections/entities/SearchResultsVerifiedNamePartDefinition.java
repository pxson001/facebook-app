package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.FigListItemTitlePartDefinition;
import com.facebook.multirow.parts.FigListItemTitlePartDefinition.Props;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.entity.SearchResultsVerifiedNameInterfaces.SearchResultsVerifiedName;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QUERY_AWESOMIZER_DISCOVER_TASK_ID */
public class SearchResultsVerifiedNamePartDefinition extends BaseSinglePartDefinition<SearchResultsProps<? extends SearchResultsVerifiedName>, Void, AnyEnvironment, FigListItem> {
    private static SearchResultsVerifiedNamePartDefinition f24266c;
    private static final Object f24267d = new Object();
    private final FigListItemTitlePartDefinition f24268a;
    private final Lazy<TypeaheadRowTitleFormatter> f24269b;

    private static SearchResultsVerifiedNamePartDefinition m27799b(InjectorLike injectorLike) {
        return new SearchResultsVerifiedNamePartDefinition(FigListItemTitlePartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10943));
    }

    public final Object m27800a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsVerifiedName searchResultsVerifiedName = (SearchResultsVerifiedName) ((SearchResultsProps) obj).f23388a;
        subParts.a(this.f24268a, new Props(SearchResultsEntityUtils.m27763a(searchResultsVerifiedName.mo562j(), searchResultsVerifiedName.mo563k(), this.f24269b)));
        return null;
    }

    @Inject
    public SearchResultsVerifiedNamePartDefinition(FigListItemTitlePartDefinition figListItemTitlePartDefinition, Lazy<TypeaheadRowTitleFormatter> lazy) {
        this.f24268a = figListItemTitlePartDefinition;
        this.f24269b = lazy;
    }

    public static SearchResultsVerifiedNamePartDefinition m27798a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVerifiedNamePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24267d) {
                SearchResultsVerifiedNamePartDefinition searchResultsVerifiedNamePartDefinition;
                if (a2 != null) {
                    searchResultsVerifiedNamePartDefinition = (SearchResultsVerifiedNamePartDefinition) a2.a(f24267d);
                } else {
                    searchResultsVerifiedNamePartDefinition = f24266c;
                }
                if (searchResultsVerifiedNamePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27799b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24267d, b3);
                        } else {
                            f24266c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVerifiedNamePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
