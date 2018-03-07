package com.facebook.search.results.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.sections.common.EmptyPartDefinition;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.search.results.environment.SearchResultsEnvironment;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge.Node;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityLargeRowPartDefinition;
import com.facebook.search.results.rows.sections.unsupported.SearchResultsUnsupportedResultPartDefinition;
import com.facebook.search.results.rows.sections.unsupported.SearchResultsUnsupportedResultPartDefinition.Props;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideoPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsWebVideoPartDefinition;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ReactURI */
public class SearchResultsRowSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<SearchResultsProps<Node>, Void, SearchResultsEnvironment> {
    private static SearchResultsRowSelectorPartDefinition f23582d;
    private static final Object f23583e = new Object();
    private final Map<GraphQLGraphSearchResultsDisplayStyle, Lazy<? extends MultiRowPartWithIsNeeded<? extends SearchResultsProps<? super Node>, ? super SearchResultsEnvironment>>> f23584a = new HashMap();
    private final Lazy<EmptyPartDefinition> f23585b;
    private final Lazy<SearchResultsUnsupportedResultPartDefinition> f23586c;

    private static SearchResultsRowSelectorPartDefinition m27247b(InjectorLike injectorLike) {
        return new SearchResultsRowSelectorPartDefinition(IdBasedLazy.a(injectorLike, 6019), IdBasedLazy.a(injectorLike, 10691), IdBasedLazy.a(injectorLike, 10818), IdBasedLazy.a(injectorLike, 10823), IdBasedLazy.a(injectorLike, 10803));
    }

    public final Object m27248a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        GraphQLGraphSearchResultsDisplayStyle e = searchResultsProps.m27107e();
        if (this.f23584a.containsKey(e)) {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) ((Lazy) this.f23584a.get(e)).get(), searchResultsProps);
        } else {
            SubPartsSelector.a(baseMultiRowSubParts, this.f23586c, new Props(searchResultsProps.m27106d(), e)).a(this.f23585b, searchResultsProps);
        }
        return null;
    }

    public static SearchResultsRowSelectorPartDefinition m27246a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsRowSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23583e) {
                SearchResultsRowSelectorPartDefinition searchResultsRowSelectorPartDefinition;
                if (a2 != null) {
                    searchResultsRowSelectorPartDefinition = (SearchResultsRowSelectorPartDefinition) a2.a(f23583e);
                } else {
                    searchResultsRowSelectorPartDefinition = f23582d;
                }
                if (searchResultsRowSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27247b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23583e, b3);
                        } else {
                            f23582d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsRowSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsRowSelectorPartDefinition(Lazy<EmptyPartDefinition> lazy, Lazy<SearchResultsEntityLargeRowPartDefinition> lazy2, Lazy<SearchResultsVideoPartDefinition> lazy3, Lazy<SearchResultsWebVideoPartDefinition> lazy4, Lazy<SearchResultsUnsupportedResultPartDefinition> lazy5) {
        this.f23584a.put(GraphQLGraphSearchResultsDisplayStyle.USERS, lazy2);
        this.f23584a.put(GraphQLGraphSearchResultsDisplayStyle.VIDEOS, lazy3);
        this.f23584a.put(GraphQLGraphSearchResultsDisplayStyle.WEB, lazy4);
        this.f23585b = lazy;
        this.f23586c = lazy5;
    }

    public final boolean m27249a(Object obj) {
        return true;
    }
}
