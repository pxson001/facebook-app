package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
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
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityRowFigPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityRowPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityWithFacepileRowFigPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityWithFacepileRowPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REPEAT_SINGLE */
public class SearchResultsNodesItemPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLNode, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsNodesItemPartDefinition f23808e;
    private static final Object f23809f = new Object();
    private final SearchResultsEntityRowFigPartDefinition<SearchResultsFeedEnvironment> f23810a;
    private final SearchResultsEntityRowPartDefinition<SearchResultsFeedEnvironment> f23811b;
    private final SearchResultsEntityWithFacepileRowPartDefinition<SearchResultsFeedEnvironment> f23812c;
    private final SearchResultsEntityWithFacepileRowFigPartDefinition<SearchResultsFeedEnvironment> f23813d;

    private static SearchResultsNodesItemPartDefinition m27434b(InjectorLike injectorLike) {
        return new SearchResultsNodesItemPartDefinition(SearchResultsEntityRowFigPartDefinition.m27740a(injectorLike), SearchResultsEntityRowPartDefinition.m27747a(injectorLike), SearchResultsEntityWithFacepileRowPartDefinition.m27784a(injectorLike), SearchResultsEntityWithFacepileRowFigPartDefinition.m27779a(injectorLike));
    }

    public final Object m27435a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f23813d, graphQLNode).a(this.f23812c, graphQLNode).a(this.f23810a, graphQLNode).a(this.f23811b, graphQLNode);
        return null;
    }

    @Inject
    public SearchResultsNodesItemPartDefinition(SearchResultsEntityRowFigPartDefinition searchResultsEntityRowFigPartDefinition, SearchResultsEntityRowPartDefinition searchResultsEntityRowPartDefinition, SearchResultsEntityWithFacepileRowPartDefinition searchResultsEntityWithFacepileRowPartDefinition, SearchResultsEntityWithFacepileRowFigPartDefinition searchResultsEntityWithFacepileRowFigPartDefinition) {
        this.f23810a = searchResultsEntityRowFigPartDefinition;
        this.f23811b = searchResultsEntityRowPartDefinition;
        this.f23812c = searchResultsEntityWithFacepileRowPartDefinition;
        this.f23813d = searchResultsEntityWithFacepileRowFigPartDefinition;
    }

    public static boolean m27433a() {
        return true;
    }

    public static SearchResultsNodesItemPartDefinition m27432a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNodesItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23809f) {
                SearchResultsNodesItemPartDefinition searchResultsNodesItemPartDefinition;
                if (a2 != null) {
                    searchResultsNodesItemPartDefinition = (SearchResultsNodesItemPartDefinition) a2.a(f23809f);
                } else {
                    searchResultsNodesItemPartDefinition = f23808e;
                }
                if (searchResultsNodesItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27434b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23809f, b3);
                        } else {
                            f23808e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNodesItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
