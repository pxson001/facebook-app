package com.facebook.search.results.factory.graphsearch;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.results.factory.SearchResultsAttributeKey;
import com.facebook.search.results.factory.SearchResultsFeedUnitFactory;
import com.facebook.search.results.model.SearchResultsBridge;
import com.facebook.search.results.model.specification.SearchResultsSpecification;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.facebook.search.results.model.specification.matchers.DisplayStyleMatcher;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: STARTED */
public class GraphSearchResultsBridgeMetaFactory implements SearchResultsFeedUnitFactory<KeywordSearchModuleFragment, SearchResultsBridge> {
    private static GraphSearchResultsBridgeMetaFactory f22754c;
    private static final Object f22755d = new Object();
    private final Multimap<GraphQLGraphSearchResultRole, DisplayStyleMatcher> f22756a = ArrayListMultimap.t();
    private final Map<SearchResultsAttributeKey, Lazy<? extends GraphSearchResultsBridgeFactory>> f22757b = new HashMap();

    private static GraphSearchResultsBridgeMetaFactory m26365b(InjectorLike injectorLike) {
        return new GraphSearchResultsBridgeMetaFactory(IdBasedLazy.a(injectorLike, 10559));
    }

    public final ImmutableList mo1260a(Object obj) {
        KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel = (KeywordSearchModuleFragmentModel) obj;
        if (keywordSearchModuleFragmentModel.jx_() == null) {
            return RegularImmutableList.a;
        }
        return m26362a(keywordSearchModuleFragmentModel.jx_(), GraphSearchModulesUtil.m26327a(keywordSearchModuleFragmentModel)).m26282b(keywordSearchModuleFragmentModel);
    }

    @Inject
    public GraphSearchResultsBridgeMetaFactory(Lazy<GraphSearchVideosModuleFactory> lazy) {
        m26364a(SearchResultsSupportDeclaration.f23423c, (Lazy) lazy);
        m26364a(SearchResultsSupportDeclaration.f23424d, (Lazy) lazy);
    }

    private void m26364a(SearchResultsSpecification<SearchResultsBridge> searchResultsSpecification, Lazy<? extends GraphSearchResultsBridgeFactory> lazy) {
        Iterator it = searchResultsSpecification.f23403b.iterator();
        while (it.hasNext()) {
            GraphQLGraphSearchResultRole graphQLGraphSearchResultRole = (GraphQLGraphSearchResultRole) it.next();
            this.f22756a.a(graphQLGraphSearchResultRole, searchResultsSpecification.f23404c);
            this.f22757b.put(new SearchResultsAttributeKey(graphQLGraphSearchResultRole, searchResultsSpecification.f23404c), lazy);
        }
    }

    public static GraphSearchResultsBridgeMetaFactory m26363a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphSearchResultsBridgeMetaFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22755d) {
                GraphSearchResultsBridgeMetaFactory graphSearchResultsBridgeMetaFactory;
                if (a2 != null) {
                    graphSearchResultsBridgeMetaFactory = (GraphSearchResultsBridgeMetaFactory) a2.a(f22755d);
                } else {
                    graphSearchResultsBridgeMetaFactory = f22754c;
                }
                if (graphSearchResultsBridgeMetaFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26365b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22755d, b3);
                        } else {
                            f22754c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = graphSearchResultsBridgeMetaFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private GraphSearchResultsBridgeFactory m26362a(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        for (Predicate predicate : this.f22756a.c(graphQLGraphSearchResultRole)) {
            if (predicate.apply(graphQLGraphSearchResultsDisplayStyle)) {
                return (GraphSearchResultsBridgeFactory) ((Lazy) this.f22757b.get(new SearchResultsAttributeKey(graphQLGraphSearchResultRole, predicate))).get();
            }
        }
        throw new IllegalStateException("Bridge factory not found for role: " + graphQLGraphSearchResultRole + ". You must register all bridge factories in the bridge meta factory.");
    }
}
