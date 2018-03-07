package com.facebook.search.results.factory.graphsearch;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.results.factory.SearchResultsFeedUnitFactory;
import com.facebook.search.results.factory.SearchResultsFeedUnitTypeResolver;
import com.facebook.search.results.factory.SearchResultsFeedUnitTypeResolverProvider;
import com.facebook.search.results.factory.graphsearch.answer.TimeUnitFactory;
import com.facebook.search.results.model.specification.SearchResultsSpecification;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.facebook.search.results.model.unit.SearchResultsUnsupportedFeedUnit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.inject.TypeLiteral;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: STRING PRIMARY KEY */
public class GraphSearchFeedUnitMetaFactory {
    private static final TypeLiteral<SearchResultsUnsupportedFeedUnit> f22737a = new C24161();
    private static GraphSearchFeedUnitMetaFactory f22738e;
    private static final Object f22739f = new Object();
    private final SearchResultsFeedUnitTypeResolver f22740b;
    private final Builder<SearchResultsSpecification> f22741c = new Builder();
    private final Map<TypeLiteral<? extends FeedUnit>, Lazy<? extends SearchResultsFeedUnitFactory<KeywordSearchModuleFragment, ? extends FeedUnit>>> f22742d = new HashMap();

    /* compiled from: STRING PRIMARY KEY */
    final class C24161 extends TypeLiteral<SearchResultsUnsupportedFeedUnit> {
        C24161() {
        }
    }

    private static GraphSearchFeedUnitMetaFactory m26322b(InjectorLike injectorLike) {
        return new GraphSearchFeedUnitMetaFactory((SearchResultsFeedUnitTypeResolverProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchResultsFeedUnitTypeResolverProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 10543), IdBasedSingletonScopeProvider.b(injectorLike, 10556), IdBasedSingletonScopeProvider.b(injectorLike, 10534), IdBasedSingletonScopeProvider.b(injectorLike, 10531), IdBasedSingletonScopeProvider.b(injectorLike, 10537), IdBasedSingletonScopeProvider.b(injectorLike, 10536), IdBasedSingletonScopeProvider.b(injectorLike, 10532), IdBasedSingletonScopeProvider.b(injectorLike, 10535), IdBasedSingletonScopeProvider.b(injectorLike, 10553), IdBasedSingletonScopeProvider.b(injectorLike, 10538), IdBasedSingletonScopeProvider.b(injectorLike, 10542), IdBasedSingletonScopeProvider.b(injectorLike, 10544), IdBasedSingletonScopeProvider.b(injectorLike, 10545), IdBasedSingletonScopeProvider.b(injectorLike, 10546), IdBasedSingletonScopeProvider.b(injectorLike, 10547), IdBasedSingletonScopeProvider.b(injectorLike, 10548), IdBasedLazy.a(injectorLike, 10550), IdBasedLazy.a(injectorLike, 10551), IdBasedSingletonScopeProvider.b(injectorLike, 10555), IdBasedSingletonScopeProvider.b(injectorLike, 10552), IdBasedSingletonScopeProvider.b(injectorLike, 10554), IdBasedSingletonScopeProvider.b(injectorLike, 10558), IdBasedSingletonScopeProvider.b(injectorLike, 10549), IdBasedLazy.a(injectorLike, 10539), IdBasedLazy.a(injectorLike, 10533), IdBasedSingletonScopeProvider.b(injectorLike, 10557), IdBasedSingletonScopeProvider.b(injectorLike, 10541), IdBasedSingletonScopeProvider.b(injectorLike, 10560));
    }

    public static GraphSearchFeedUnitMetaFactory m26320a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphSearchFeedUnitMetaFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22739f) {
                GraphSearchFeedUnitMetaFactory graphSearchFeedUnitMetaFactory;
                if (a2 != null) {
                    graphSearchFeedUnitMetaFactory = (GraphSearchFeedUnitMetaFactory) a2.a(f22739f);
                } else {
                    graphSearchFeedUnitMetaFactory = f22738e;
                }
                if (graphSearchFeedUnitMetaFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26322b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22739f, b3);
                        } else {
                            f22738e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = graphSearchFeedUnitMetaFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GraphSearchFeedUnitMetaFactory(SearchResultsFeedUnitTypeResolverProvider searchResultsFeedUnitTypeResolverProvider, Lazy<GraphSearchNodesCollectionUnitFactory> lazy, Lazy<GraphSearchStoryCollectionUnitFactory> lazy2, Lazy<GraphSearchCommerceCollectionUnitFactory> lazy3, Lazy<GraphSearchAnnotationUnitFactory> lazy4, Lazy<GraphSearchEmptyUnitFactory> lazy5, Lazy<GraphSearchEmptyEntityUnitFactory> lazy6, Lazy<GraphSearchAttachmentCollectionUnitFactory> lazy7, Lazy<GraphSearchComposerUnitFactory> lazy8, Lazy<GraphSearchSportsTeamCollectionUnitFactory> lazy9, Lazy<GraphSearchEntityPivotCollectionUnitFactory> lazy10, Lazy<GraphSearchNewsContextUnitFactory> lazy11, Lazy<GraphSearchPulseContextUnitFactory> lazy12, Lazy<GraphSearchPulsePhrasesCollectionUnitFactory> lazy13, Lazy<GraphSearchPulseQuotesCollectionUnitFactory> lazy14, Lazy<GraphSearchPulseSentimentUnitFactory> lazy15, Lazy<GraphSearchPulseStoriesFactory> lazy16, Lazy<GraphSearchReactionUnitFactory> lazy17, Lazy<GraphSearchResultsBridgeMetaFactory> lazy18, Lazy<GraphSearchStoriesFactory> lazy19, Lazy<GraphSearchSeeMoreUnitFactory> lazy20, Lazy<GraphSearchSportsUnitFactory> lazy21, Lazy<GraphSearchVideoUnitFactory> lazy22, Lazy<GraphSearchPulseTopicMetadataUnitFactory> lazy23, Lazy<GraphSearchEntityUnitFactory> lazy24, Lazy<GraphSearchCentralEntityWikiUnitFactory> lazy25, Lazy<GraphSearchUnsupportedUnitFactory> lazy26, Lazy<GraphSearchForSalePostsFactory> lazy27, Lazy<TimeUnitFactory> lazy28) {
        m26321a(SearchResultsSupportDeclaration.f23421a, lazy4);
        m26321a(SearchResultsSupportDeclaration.f23422b, lazy);
        m26321a(SearchResultsSupportDeclaration.f23423c, lazy18);
        m26321a(SearchResultsSupportDeclaration.f23424d, lazy18);
        m26321a(SearchResultsSupportDeclaration.f23425e, lazy);
        m26321a(SearchResultsSupportDeclaration.f23427g, lazy24);
        m26321a(SearchResultsSupportDeclaration.f23428h, lazy24);
        m26321a(SearchResultsSupportDeclaration.f23426f, lazy25);
        m26321a(SearchResultsSupportDeclaration.f23430j, lazy5);
        m26321a(SearchResultsSupportDeclaration.f23431k, lazy6);
        m26321a(SearchResultsSupportDeclaration.f23419M, lazy);
        m26321a(SearchResultsSupportDeclaration.f23432l, lazy);
        m26321a(SearchResultsSupportDeclaration.f23433m, lazy10);
        m26321a(SearchResultsSupportDeclaration.f23434n, lazy27);
        m26321a(SearchResultsSupportDeclaration.f23435o, lazy8);
        m26321a(SearchResultsSupportDeclaration.f23436p, lazy9);
        m26321a(SearchResultsSupportDeclaration.f23437q, lazy11);
        m26321a(SearchResultsSupportDeclaration.f23438r, lazy7);
        m26321a(SearchResultsSupportDeclaration.f23439s, lazy2);
        m26321a(SearchResultsSupportDeclaration.f23440t, lazy);
        m26321a(SearchResultsSupportDeclaration.f23441u, lazy12);
        m26321a(SearchResultsSupportDeclaration.f23442v, lazy);
        m26321a(SearchResultsSupportDeclaration.f23412F, lazy);
        m26321a(SearchResultsSupportDeclaration.f23443w, lazy13);
        m26321a(SearchResultsSupportDeclaration.f23444x, lazy14);
        m26321a(SearchResultsSupportDeclaration.f23445y, lazy15);
        m26321a(SearchResultsSupportDeclaration.f23446z, lazy16);
        m26321a(SearchResultsSupportDeclaration.f23408B, lazy23);
        m26321a(SearchResultsSupportDeclaration.f23409C, lazy17);
        m26321a(SearchResultsSupportDeclaration.f23410D, lazy);
        m26321a(SearchResultsSupportDeclaration.f23415I, lazy19);
        m26321a(SearchResultsSupportDeclaration.f23411E, lazy20);
        m26321a(SearchResultsSupportDeclaration.f23414H, lazy21);
        m26321a(SearchResultsSupportDeclaration.f23416J, lazy19);
        m26321a(SearchResultsSupportDeclaration.f23418L, lazy);
        m26321a(SearchResultsSupportDeclaration.f23420N, lazy22);
        m26321a(SearchResultsSupportDeclaration.f23413G, lazy22);
        m26321a(SearchResultsSupportDeclaration.f23429i, lazy3);
        m26321a(SearchResultsSupportDeclaration.f23417K, lazy28);
        this.f22742d.put(f22737a, lazy26);
        this.f22740b = SearchResultsFeedUnitTypeResolverProvider.m26279a(this.f22741c.b(), f22737a);
    }

    private <F extends FeedUnit> void m26321a(SearchResultsSpecification<F> searchResultsSpecification, Lazy<? extends SearchResultsFeedUnitFactory<KeywordSearchModuleFragment, F>> lazy) {
        this.f22741c.c(searchResultsSpecification);
        this.f22742d.put(searchResultsSpecification.f23405d, lazy);
    }

    public final ImmutableList<? extends FeedUnit> m26323a(KeywordSearchModuleFragment keywordSearchModuleFragment) {
        if (keywordSearchModuleFragment.jx_() == null) {
            return RegularImmutableList.a;
        }
        Lazy lazy = (Lazy) this.f22742d.get(this.f22740b.m26278a(keywordSearchModuleFragment.jx_(), GraphSearchModulesUtil.m26327a(keywordSearchModuleFragment)));
        if (lazy == null) {
            return RegularImmutableList.a;
        }
        return ((SearchResultsFeedUnitFactory) lazy.get()).mo1260a(keywordSearchModuleFragment);
    }
}
