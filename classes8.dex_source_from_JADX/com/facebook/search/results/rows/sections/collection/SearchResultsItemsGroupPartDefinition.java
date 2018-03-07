package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.GraphQLNode;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.rows.sections.local.SearchResultsPlacePartDefinition;
import com.facebook.search.results.rows.sections.local.SearchResultsPlacesMapPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseRelatedLinksItemPartDefinition;
import com.facebook.search.results.rows.sections.pulsetopic.PulseTopicRelatedTopicsPartDefinition;
import com.facebook.search.results.rows.sections.relatednews.SearchResultsRelatedNewsItemPartDefinition;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REPORT_PLACE */
public class SearchResultsItemsGroupPartDefinition extends BaseMultiRowGroupPartDefinition<SearchResultsCollectionUnit<?>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsItemsGroupPartDefinition f23755k;
    private static final Object f23756l = new Object();
    private final QeAccessor f23757a;
    private final SearchResultsRelatedNewsItemPartDefinition f23758b;
    private final SearchResultsArticlesItemPartDefinition f23759c;
    private final SearchResultsNodesItemPartDefinition f23760d;
    private final PulseRelatedLinksItemPartDefinition<SearchResultsFeedEnvironment> f23761e;
    private final GraphSearchErrorReporter f23762f;
    private final PulseTopicRelatedTopicsPartDefinition f23763g;
    private final SearchResultsPostsContentsPartDefinition f23764h;
    private final Lazy<SearchResultsPlacesMapPartDefinition> f23765i;
    private final Lazy<SearchResultsPlacePartDefinition> f23766j;

    private static SearchResultsItemsGroupPartDefinition m27401b(InjectorLike injectorLike) {
        return new SearchResultsItemsGroupPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SearchResultsRelatedNewsItemPartDefinition.m28303a(injectorLike), SearchResultsArticlesItemPartDefinition.m27368a(injectorLike), SearchResultsNodesItemPartDefinition.m27432a(injectorLike), PulseRelatedLinksItemPartDefinition.m28243a(injectorLike), GraphSearchErrorReporter.a(injectorLike), PulseTopicRelatedTopicsPartDefinition.m28287a(injectorLike), SearchResultsPostsContentsPartDefinition.m27437a(injectorLike), IdBasedLazy.a(injectorLike, 10744), IdBasedLazy.a(injectorLike, 10743));
    }

    public final Object m27408a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) obj;
        boolean d = m27404d(searchResultsCollectionUnit);
        boolean b = m27402b(searchResultsCollectionUnit);
        boolean c = m27403c(searchResultsCollectionUnit);
        boolean e = m27405e(searchResultsCollectionUnit);
        boolean f = m27406f(searchResultsCollectionUnit);
        boolean g = m27407g(searchResultsCollectionUnit);
        if (g && this.f23757a.a(ExperimentsForSearchAbTestModule.Y, false)) {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f23765i.get(), searchResultsCollectionUnit);
        }
        for (int i = 0; i < searchResultsCollectionUnit.f23463d.size(); i++) {
            GraphQLNode graphQLNode = (GraphQLNode) searchResultsCollectionUnit.m27157s().get(i);
            if (d) {
                baseMultiRowSubParts.a(this.f23761e, graphQLNode);
            } else if (b) {
                baseMultiRowSubParts.a(this.f23758b, graphQLNode);
            } else if (c) {
                baseMultiRowSubParts.a(this.f23759c, graphQLNode);
            } else if (e) {
                baseMultiRowSubParts.a(this.f23763g, graphQLNode);
            } else if (f) {
                baseMultiRowSubParts.a(this.f23764h, graphQLNode);
            } else if (g && this.f23757a.a(ExperimentsForSearchAbTestModule.aa, false)) {
                baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f23766j.get(), graphQLNode);
            } else {
                baseMultiRowSubParts.a(this.f23760d, graphQLNode);
            }
        }
        return null;
    }

    @Inject
    public SearchResultsItemsGroupPartDefinition(QeAccessor qeAccessor, SearchResultsRelatedNewsItemPartDefinition searchResultsRelatedNewsItemPartDefinition, SearchResultsArticlesItemPartDefinition searchResultsArticlesItemPartDefinition, SearchResultsNodesItemPartDefinition searchResultsNodesItemPartDefinition, PulseRelatedLinksItemPartDefinition pulseRelatedLinksItemPartDefinition, GraphSearchErrorReporter graphSearchErrorReporter, PulseTopicRelatedTopicsPartDefinition pulseTopicRelatedTopicsPartDefinition, SearchResultsPostsContentsPartDefinition searchResultsPostsContentsPartDefinition, Lazy<SearchResultsPlacesMapPartDefinition> lazy, Lazy<SearchResultsPlacePartDefinition> lazy2) {
        this.f23757a = qeAccessor;
        this.f23758b = searchResultsRelatedNewsItemPartDefinition;
        this.f23759c = searchResultsArticlesItemPartDefinition;
        this.f23760d = searchResultsNodesItemPartDefinition;
        this.f23761e = pulseRelatedLinksItemPartDefinition;
        this.f23762f = graphSearchErrorReporter;
        this.f23763g = pulseTopicRelatedTopicsPartDefinition;
        this.f23764h = searchResultsPostsContentsPartDefinition;
        this.f23765i = lazy;
        this.f23766j = lazy2;
    }

    public static SearchResultsItemsGroupPartDefinition m27400a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsItemsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23756l) {
                SearchResultsItemsGroupPartDefinition searchResultsItemsGroupPartDefinition;
                if (a2 != null) {
                    searchResultsItemsGroupPartDefinition = (SearchResultsItemsGroupPartDefinition) a2.a(f23756l);
                } else {
                    searchResultsItemsGroupPartDefinition = f23755k;
                }
                if (searchResultsItemsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27401b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23756l, b3);
                        } else {
                            f23755k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsItemsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27409a(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        boolean d = m27404d(searchResultsCollectionUnit);
        boolean b = m27402b((SearchResultsCollectionUnit) searchResultsCollectionUnit);
        boolean c = m27403c(searchResultsCollectionUnit);
        boolean e = m27405e(searchResultsCollectionUnit);
        boolean f = m27406f(searchResultsCollectionUnit);
        boolean g = m27407g(searchResultsCollectionUnit);
        if (!searchResultsCollectionUnit.m27154o().equals(Optional.of(GraphQLNode.class))) {
            return false;
        }
        ImmutableList immutableList = searchResultsCollectionUnit.f23463d;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLNode graphQLNode = (GraphQLNode) immutableList.get(i);
            if (d) {
                if (PulseRelatedLinksItemPartDefinition.m28244a(graphQLNode)) {
                    return true;
                }
            } else if (b) {
                if (this.f23758b.m28306a(graphQLNode)) {
                    return true;
                }
            } else if (c) {
                if (SearchResultsArticlesItemPartDefinition.m27369a(graphQLNode)) {
                    return true;
                }
            } else if (e) {
                if (PulseTopicRelatedTopicsPartDefinition.m28289b()) {
                    return true;
                }
            } else if (f) {
                if (SearchResultsPostsContentsPartDefinition.m27438a(graphQLNode)) {
                    return true;
                }
            } else if (g) {
                this.f23766j.get();
                if (SearchResultsPlacePartDefinition.m28029b()) {
                    return true;
                }
            } else if (SearchResultsNodesItemPartDefinition.m27433a()) {
                return true;
            }
        }
        if (searchResultsCollectionUnit.m27157s().size() > 0) {
            String graphQLGraphSearchResultsDisplayStyle = ((GraphQLGraphSearchResultsDisplayStyle) searchResultsCollectionUnit.m27156q().or(GraphQLGraphSearchResultsDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)).toString();
            this.f23762f.a(GraphSearchError.MISSING_RESULT_DATA, "Display Style: " + graphQLGraphSearchResultsDisplayStyle + " Role: " + searchResultsCollectionUnit.mo1321k().toString());
        }
        return false;
    }

    private static boolean m27402b(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.NEWS_MODULE;
    }

    private static boolean m27403c(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.NEWS_PUBLISHERS || searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.SPORT_LINKS;
    }

    private static boolean m27404d(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.RELATED_SHARES;
    }

    private static boolean m27405e(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.RELATED_TOPICS;
    }

    private static boolean m27406f(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.POSTS_CONTENTS;
    }

    private static boolean m27407g(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return searchResultsCollectionUnit.mo1321k() == GraphQLGraphSearchResultRole.GRAMMAR && searchResultsCollectionUnit.f23460a.get() == GraphQLGraphSearchResultsDisplayStyle.PLACES;
    }
}
