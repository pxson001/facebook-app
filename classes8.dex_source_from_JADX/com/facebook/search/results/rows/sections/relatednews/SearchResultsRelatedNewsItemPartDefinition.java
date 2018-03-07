package com.facebook.search.results.rows.sections.relatednews;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.search.results.rows.sections.newscontext.SearchResultsNewsTitlePartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRE_INSTALLED_FONT_SANS_SERIF */
public class SearchResultsRelatedNewsItemPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLNode, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsRelatedNewsItemPartDefinition f24957c;
    private static final Object f24958d = new Object();
    private final SearchResultsRelatedNewsTrendingPartDefinition f24959a;
    private final SearchResultsRelatedNewsContentPartDefinition f24960b;

    private static SearchResultsRelatedNewsItemPartDefinition m28304b(InjectorLike injectorLike) {
        return new SearchResultsRelatedNewsItemPartDefinition(SearchResultsRelatedNewsContentPartDefinition.m28298a(injectorLike), SearchResultsRelatedNewsTrendingPartDefinition.m28308a(injectorLike));
    }

    public final Object m28305a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        baseMultiRowSubParts.a(this.f24960b, graphQLNode);
        baseMultiRowSubParts.a(this.f24959a, graphQLNode);
        return null;
    }

    @Inject
    public SearchResultsRelatedNewsItemPartDefinition(SearchResultsRelatedNewsContentPartDefinition searchResultsRelatedNewsContentPartDefinition, SearchResultsRelatedNewsTrendingPartDefinition searchResultsRelatedNewsTrendingPartDefinition) {
        this.f24959a = searchResultsRelatedNewsTrendingPartDefinition;
        this.f24960b = searchResultsRelatedNewsContentPartDefinition;
    }

    public final boolean m28306a(GraphQLNode graphQLNode) {
        return SearchResultsNewsTitlePartDefinition.m28091a(graphQLNode);
    }

    public static SearchResultsRelatedNewsItemPartDefinition m28303a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsRelatedNewsItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24958d) {
                SearchResultsRelatedNewsItemPartDefinition searchResultsRelatedNewsItemPartDefinition;
                if (a2 != null) {
                    searchResultsRelatedNewsItemPartDefinition = (SearchResultsRelatedNewsItemPartDefinition) a2.a(f24958d);
                } else {
                    searchResultsRelatedNewsItemPartDefinition = f24957c;
                }
                if (searchResultsRelatedNewsItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28304b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24958d, b3);
                        } else {
                            f24957c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsRelatedNewsItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
