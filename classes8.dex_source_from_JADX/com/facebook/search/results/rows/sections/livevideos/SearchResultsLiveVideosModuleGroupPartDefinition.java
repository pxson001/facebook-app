package com.facebook.search.results.rows.sections.livevideos;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
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
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.model.SearchResultsPropsHelper;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryModels.SearchResultsSeeMoreQueryModel;
import com.facebook.search.results.protocol.video.SearchResultsLiveVideosModuleInterfaces.SearchResultsLiveVideosModule;
import com.facebook.search.results.rows.sections.header.SearchResultsVideosHeaderPartDefinition;
import com.facebook.search.results.rows.sections.seemore.SearchResultsSeeMoreQueryPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideosHScrollPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideosModuleGroupPartDefinition;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideosModuleUtil;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PaginatedGysjFeedUnitTTI */
public class SearchResultsLiveVideosModuleGroupPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasFeedListType & HasFeedMenuHelper & HasPositionInformation & HasPrefetcher & HasRowKey & HasSearchResultPosition & HasSearchResultsContext & HasSearchResultsVideoStoryPersistentState> extends BaseMultiRowGroupPartDefinition<SearchResultsProps<SearchResultsLiveVideosModule>, Void, E> {
    private static SearchResultsLiveVideosModuleGroupPartDefinition f24559f;
    private static final Object f24560g = new Object();
    private final SearchResultsVideosHeaderPartDefinition<E> f24561a;
    private final Lazy<SearchResultsVideosHScrollPartDefinition<E>> f24562b;
    private final Lazy<SearchResultsVideosModuleGroupPartDefinition<E>> f24563c;
    private final SearchResultsSeeMoreQueryPartDefinition<E> f24564d;
    private final EmptyPartDefinition f24565e;

    private static SearchResultsLiveVideosModuleGroupPartDefinition m28011b(InjectorLike injectorLike) {
        return new SearchResultsLiveVideosModuleGroupPartDefinition(SearchResultsVideosHeaderPartDefinition.m27896a(injectorLike), IdBasedLazy.a(injectorLike, 10821), IdBasedLazy.a(injectorLike, 10822), SearchResultsSeeMoreQueryPartDefinition.m28331a(injectorLike), EmptyPartDefinition.a(injectorLike));
    }

    public final Object m28012a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        GraphQLGraphSearchResultsDisplayStyle l = ((HasSearchResultsContext) ((HasContext) anyEnvironment)).mo1248s().m27098l();
        int f = SearchResultsEdgeUtil.m9804f(searchResultsProps.f23390c);
        if (l != GraphQLGraphSearchResultsDisplayStyle.BLENDED || f > 2) {
            baseMultiRowSubParts.a(this.f24561a, searchResultsProps.f23390c);
            if (f > 2) {
                baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f24562b.get(), SearchResultsVideosModuleUtil.m28507a(searchResultsProps));
            } else {
                baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f24563c.get(), searchResultsProps);
            }
            SearchResultsSeeMoreQueryModel aj = ((NodeModel) searchResultsProps.f23388a).aj();
            if (aj != null) {
                baseMultiRowSubParts.a(this.f24564d, searchResultsProps.m27104a(aj));
            }
        } else {
            baseMultiRowSubParts.a(this.f24565e, null);
        }
        return null;
    }

    public final boolean m28013a(Object obj) {
        return SearchResultsPropsHelper.m27109b((SearchResultsProps) obj);
    }

    public static SearchResultsLiveVideosModuleGroupPartDefinition m28010a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsLiveVideosModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24560g) {
                SearchResultsLiveVideosModuleGroupPartDefinition searchResultsLiveVideosModuleGroupPartDefinition;
                if (a2 != null) {
                    searchResultsLiveVideosModuleGroupPartDefinition = (SearchResultsLiveVideosModuleGroupPartDefinition) a2.a(f24560g);
                } else {
                    searchResultsLiveVideosModuleGroupPartDefinition = f24559f;
                }
                if (searchResultsLiveVideosModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28011b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24560g, b3);
                        } else {
                            f24559f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsLiveVideosModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsLiveVideosModuleGroupPartDefinition(SearchResultsVideosHeaderPartDefinition searchResultsVideosHeaderPartDefinition, Lazy<SearchResultsVideosHScrollPartDefinition> lazy, Lazy<SearchResultsVideosModuleGroupPartDefinition> lazy2, SearchResultsSeeMoreQueryPartDefinition searchResultsSeeMoreQueryPartDefinition, EmptyPartDefinition emptyPartDefinition) {
        this.f24561a = searchResultsVideosHeaderPartDefinition;
        this.f24562b = lazy;
        this.f24563c = lazy2;
        this.f24564d = searchResultsSeeMoreQueryPartDefinition;
        this.f24565e = emptyPartDefinition;
    }
}
