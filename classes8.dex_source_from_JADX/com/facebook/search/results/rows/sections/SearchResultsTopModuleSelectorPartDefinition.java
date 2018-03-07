package com.facebook.search.results.rows.sections;

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
import com.facebook.search.results.rows.sections.unsupported.SearchResultsUnsupportedResultPartDefinition;
import com.facebook.search.results.rows.sections.unsupported.SearchResultsUnsupportedResultPartDefinition.Props;
import com.facebook.search.results.rows.sections.videos.SearchResultsGrammarVideosModuleGroupPartDefinition;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RIGHT_OF */
public class SearchResultsTopModuleSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<SearchResultsProps<Node>, Void, SearchResultsEnvironment> {
    private static SearchResultsTopModuleSelectorPartDefinition f23600d;
    private static final Object f23601e = new Object();
    private final Map<GraphQLGraphSearchResultsDisplayStyle, Lazy<? extends MultiRowPartWithIsNeeded<? extends SearchResultsProps<? super Node>, ? super SearchResultsEnvironment>>> f23602a = new HashMap();
    private final Lazy<EmptyPartDefinition> f23603b;
    private final Lazy<SearchResultsUnsupportedResultPartDefinition> f23604c;

    private static SearchResultsTopModuleSelectorPartDefinition m27265b(InjectorLike injectorLike) {
        return new SearchResultsTopModuleSelectorPartDefinition(IdBasedLazy.a(injectorLike, 6019), IdBasedLazy.a(injectorLike, 10803), IdBasedLazy.a(injectorLike, 10808));
    }

    public final Object m27266a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        GraphQLGraphSearchResultsDisplayStyle e = searchResultsProps.m27107e();
        if (this.f23602a.containsKey(e)) {
            SubPartsSelector.a(baseMultiRowSubParts, (Lazy) this.f23602a.get(e), searchResultsProps).a(this.f23603b, searchResultsProps);
        } else {
            SubPartsSelector.a(baseMultiRowSubParts, this.f23604c, new Props(searchResultsProps.m27106d(), e)).a(this.f23603b, searchResultsProps);
        }
        return null;
    }

    @Inject
    public SearchResultsTopModuleSelectorPartDefinition(Lazy<EmptyPartDefinition> lazy, Lazy<SearchResultsUnsupportedResultPartDefinition> lazy2, Lazy<SearchResultsGrammarVideosModuleGroupPartDefinition> lazy3) {
        this.f23602a.put(GraphQLGraphSearchResultsDisplayStyle.VIDEOS, lazy3);
        this.f23603b = lazy;
        this.f23604c = lazy2;
    }

    public static SearchResultsTopModuleSelectorPartDefinition m27264a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsTopModuleSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23601e) {
                SearchResultsTopModuleSelectorPartDefinition searchResultsTopModuleSelectorPartDefinition;
                if (a2 != null) {
                    searchResultsTopModuleSelectorPartDefinition = (SearchResultsTopModuleSelectorPartDefinition) a2.a(f23601e);
                } else {
                    searchResultsTopModuleSelectorPartDefinition = f23600d;
                }
                if (searchResultsTopModuleSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27265b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23601e, b3);
                        } else {
                            f23600d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsTopModuleSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27267a(Object obj) {
        return true;
    }
}
