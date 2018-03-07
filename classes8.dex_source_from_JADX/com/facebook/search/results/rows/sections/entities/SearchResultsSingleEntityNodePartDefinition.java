package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.model.unit.SearchResultsEntityUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QUERY_AWESOMIZER_REFOLLOWING_TASK_ID */
public class SearchResultsSingleEntityNodePartDefinition<E extends HasContext & HasPositionInformation & HasPersistentState & OldCanLogEntityNavigation & OldCanApplyEntityInlineAction> extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsEntityUnit>, Void, E> {
    private static SearchResultsSingleEntityNodePartDefinition f24259c;
    private static final Object f24260d = new Object();
    private final SearchResultsEntityRowFigPartDefinition<E> f24261a;
    private final SearchResultsEntityRowPartDefinition<E> f24262b;

    private static SearchResultsSingleEntityNodePartDefinition m27790b(InjectorLike injectorLike) {
        return new SearchResultsSingleEntityNodePartDefinition(SearchResultsEntityRowFigPartDefinition.m27740a(injectorLike), SearchResultsEntityRowPartDefinition.m27747a(injectorLike));
    }

    public final Object m27791a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = ((SearchResultsEntityUnit) ((FeedProps) obj).a).f23487a;
        SubPartsSelector.a(baseMultiRowSubParts, this.f24261a, graphQLNode).a(this.f24262b, graphQLNode);
        return null;
    }

    @Inject
    public SearchResultsSingleEntityNodePartDefinition(SearchResultsEntityRowFigPartDefinition searchResultsEntityRowFigPartDefinition, SearchResultsEntityRowPartDefinition searchResultsEntityRowPartDefinition) {
        this.f24261a = searchResultsEntityRowFigPartDefinition;
        this.f24262b = searchResultsEntityRowPartDefinition;
    }

    public final boolean m27792a(Object obj) {
        return true;
    }

    public static SearchResultsSingleEntityNodePartDefinition m27789a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSingleEntityNodePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24260d) {
                SearchResultsSingleEntityNodePartDefinition searchResultsSingleEntityNodePartDefinition;
                if (a2 != null) {
                    searchResultsSingleEntityNodePartDefinition = (SearchResultsSingleEntityNodePartDefinition) a2.a(f24260d);
                } else {
                    searchResultsSingleEntityNodePartDefinition = f24259c;
                }
                if (searchResultsSingleEntityNodePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27790b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24260d, b3);
                        } else {
                            f24259c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSingleEntityNodePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
