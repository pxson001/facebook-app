package com.facebook.search.results.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowPartWithIsNeededUtil;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.sections.common.EmptyPartDefinition;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
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
import com.facebook.search.results.model.SearchResult;
import com.facebook.search.results.model.SearchResultUnit;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge.Node;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.search.results.rows.sections.SearchResultsTopModuleSelectorPartDefinition;
import com.facebook.search.results.rows.sections.central.SearchResultsCentralEntityWikiConvertedGroupPartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsSectionHeaderModulePartDefinition;
import com.facebook.search.results.rows.sections.livevideos.SearchResultsLiveVideosModuleGroupPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseContextConvertedGroupPartDefinition;
import com.facebook.search.results.rows.sections.unsupported.SearchResultsUnsupportedResultPartDefinition;
import com.facebook.search.results.rows.sections.unsupported.SearchResultsUnsupportedResultPartDefinition.Props;
import com.facebook.search.results.rows.sections.videos.SearchResultsFeedVideosModuleGroupPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsTopVideosModuleGroupPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideoPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsWebVideosModuleGroupPartDefinition;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ReactionAction */
public class SearchResultsRootPartDefinition extends BaseMultiRowGroupPartDefinition<SearchResult, Void, SearchResultsEnvironment> {
    private static SearchResultsRootPartDefinition f23575f;
    private static final Object f23576g = new Object();
    private final SearchResultsUnsupportedResultPartDefinition f23577a;
    private final EmptyPartDefinition f23578b;
    private final Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> f23579c;
    private final Map<GraphQLGraphSearchResultRole, Lazy<? extends MultiRowPartWithIsNeeded<? extends SearchResultsProps<? super Node>, ? super SearchResultsEnvironment>>> f23580d = new HashMap();
    private final Map<GraphQLGraphSearchResultRole, Lazy<? extends MultiRowPartWithIsNeeded<? extends SearchResultsProps<? extends Node>, ? super SearchResultsEnvironment>>> f23581e;

    private static SearchResultsRootPartDefinition m27243b(InjectorLike injectorLike) {
        return new SearchResultsRootPartDefinition(SearchResultsUnsupportedResultPartDefinition.m28396a(injectorLike), EmptyPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 6023), IdBasedLazy.a(injectorLike, 10741), IdBasedLazy.a(injectorLike, 10807), IdBasedLazy.a(injectorLike, 10812), IdBasedLazy.a(injectorLike, 10824), IdBasedLazy.a(injectorLike, 10613), IdBasedLazy.a(injectorLike, 10718), IdBasedLazy.a(injectorLike, 10818), IdBasedLazy.a(injectorLike, 10766), IdBasedLazy.a(injectorLike, 10626), IdBasedLazy.a(injectorLike, 10617));
    }

    public final Object m27244a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultUnit searchResultUnit = (SearchResultUnit) obj;
        if (searchResultUnit instanceof SearchResultUnit) {
            searchResultUnit = searchResultUnit;
            SearchResultsEdgeModel searchResultsEdgeModel = searchResultUnit.f23325a;
            GraphQLGraphSearchResultRole b = SearchResultsEdgeUtil.m9800b(searchResultUnit.f23325a);
            if (!this.f23580d.containsKey(b) || searchResultsEdgeModel == null) {
                b = searchResultUnit.f23325a.m9773d();
                if (!this.f23581e.containsKey(b) || searchResultsEdgeModel == null) {
                    SubPartsSelector.a(baseMultiRowSubParts, this.f23577a, new Props(searchResultUnit.f23326b)).a(this.f23578b, searchResultUnit);
                } else {
                    SubPartsSelector.a(baseMultiRowSubParts, (Lazy) this.f23581e.get(b), SearchResultsProps.m27103a(searchResultsEdgeModel.m9770a(), searchResultsEdgeModel)).a(this.f23578b, searchResultsEdgeModel);
                }
            } else {
                SubPartsSelector.a(baseMultiRowSubParts, (Lazy) this.f23580d.get(b), SearchResultsProps.m27103a(searchResultsEdgeModel.m9770a(), searchResultsEdgeModel)).a(this.f23578b, searchResultsEdgeModel);
            }
        } else {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f23579c.get(), searchResultUnit);
        }
        return null;
    }

    public static SearchResultsRootPartDefinition m27242a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23576g) {
                SearchResultsRootPartDefinition searchResultsRootPartDefinition;
                if (a2 != null) {
                    searchResultsRootPartDefinition = (SearchResultsRootPartDefinition) a2.a(f23576g);
                } else {
                    searchResultsRootPartDefinition = f23575f;
                }
                if (searchResultsRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27243b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23576g, b3);
                        } else {
                            f23575f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsRootPartDefinition(SearchResultsUnsupportedResultPartDefinition searchResultsUnsupportedResultPartDefinition, EmptyPartDefinition emptyPartDefinition, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy, Lazy<SearchResultsLiveVideosModuleGroupPartDefinition> lazy2, Lazy<SearchResultsFeedVideosModuleGroupPartDefinition> lazy3, Lazy<SearchResultsTopVideosModuleGroupPartDefinition> lazy4, Lazy<SearchResultsWebVideosModuleGroupPartDefinition> lazy5, Lazy<SearchResultsRowSelectorPartDefinition> lazy6, Lazy<SearchResultsSectionHeaderModulePartDefinition> lazy7, Lazy<SearchResultsVideoPartDefinition> lazy8, Lazy<PulseContextConvertedGroupPartDefinition> lazy9, Lazy<SearchResultsCentralEntityWikiConvertedGroupPartDefinition> lazy10, Lazy<SearchResultsTopModuleSelectorPartDefinition> lazy11) {
        this.f23577a = searchResultsUnsupportedResultPartDefinition;
        this.f23578b = emptyPartDefinition;
        this.f23579c = lazy;
        this.f23580d.put(GraphQLGraphSearchResultRole.VIDEOS_LIVE, MultiRowPartWithIsNeededUtil.a(lazy2));
        this.f23580d.put(GraphQLGraphSearchResultRole.FEED_VIDEOS, MultiRowPartWithIsNeededUtil.a(lazy3));
        this.f23580d.put(GraphQLGraphSearchResultRole.TOP_VIDEOS, MultiRowPartWithIsNeededUtil.a(lazy4));
        this.f23580d.put(GraphQLGraphSearchResultRole.VIDEOS_WEB, MultiRowPartWithIsNeededUtil.a(lazy5));
        this.f23580d.put(GraphQLGraphSearchResultRole.SECTION_HEADER, MultiRowPartWithIsNeededUtil.a(lazy7));
        this.f23580d.put(GraphQLGraphSearchResultRole.GLOBAL_SHARE_METADATA, MultiRowPartWithIsNeededUtil.a(lazy9));
        this.f23580d.put(GraphQLGraphSearchResultRole.WIKIPEDIA_CARD, MultiRowPartWithIsNeededUtil.a(lazy10));
        this.f23580d.put(GraphQLGraphSearchResultRole.GRAMMAR, MultiRowPartWithIsNeededUtil.a(lazy11));
        this.f23580d.put(GraphQLGraphSearchResultRole.NONE, MultiRowPartWithIsNeededUtil.a(lazy11));
        this.f23581e = new HashMap();
        this.f23581e.put(GraphQLGraphSearchResultRole.VIDEOS, MultiRowPartWithIsNeededUtil.a(lazy8));
        this.f23581e.put(GraphQLGraphSearchResultRole.NONE, MultiRowPartWithIsNeededUtil.a(lazy6));
        this.f23581e.put(GraphQLGraphSearchResultRole.GRAMMAR, MultiRowPartWithIsNeededUtil.a(lazy6));
    }

    public final boolean m27245a(Object obj) {
        return true;
    }
}
