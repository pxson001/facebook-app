package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.environment.entity.CanLogEntityNavigation;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.entity.SearchResultsUserInterfaces.SearchResultsUser;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QUERY_AWESOMIZER_DISCOVER_TOPIC_TASK_ID */
public class SearchResultsUserPartDefinition<E extends HasContext & HasPositionInformation & HasPersistentState & CanLogEntityNavigation> extends MultiRowSinglePartDefinition<SearchResultsProps<SearchResultsUser>, Void, E, FigListItem> {
    private static SearchResultsUserPartDefinition f24263b;
    private static final Object f24264c = new Object();
    private final SearchResultsVerifiedNamePartDefinition f24265a;

    private static SearchResultsUserPartDefinition m27794b(InjectorLike injectorLike) {
        return new SearchResultsUserPartDefinition(SearchResultsVerifiedNamePartDefinition.m27798a(injectorLike));
    }

    public final Object m27796a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24265a, (SearchResultsProps) obj);
        return null;
    }

    @Inject
    public SearchResultsUserPartDefinition(SearchResultsVerifiedNamePartDefinition searchResultsVerifiedNamePartDefinition) {
        this.f24265a = searchResultsVerifiedNamePartDefinition;
    }

    public final ViewType<FigListItem> m27795a() {
        return SearchResultsEntityRowFigPartDefinition.f24209a;
    }

    public final boolean m27797a(Object obj) {
        return true;
    }

    public static SearchResultsUserPartDefinition m27793a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsUserPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24264c) {
                SearchResultsUserPartDefinition searchResultsUserPartDefinition;
                if (a2 != null) {
                    searchResultsUserPartDefinition = (SearchResultsUserPartDefinition) a2.a(f24264c);
                } else {
                    searchResultsUserPartDefinition = f24263b;
                }
                if (searchResultsUserPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27794b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24264c, b3);
                        } else {
                            f24263b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsUserPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
