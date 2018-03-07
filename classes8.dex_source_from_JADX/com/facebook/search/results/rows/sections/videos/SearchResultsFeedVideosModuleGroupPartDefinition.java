package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
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
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryModels.SearchResultsSeeMoreQueryModel;
import com.facebook.search.results.protocol.video.SearchResultsFeedVideosModuleInterfaces.SearchResultsFeedVideosModule;
import com.facebook.search.results.rows.sections.header.SearchResultsVideosHeaderPartDefinition;
import com.facebook.search.results.rows.sections.seemore.SearchResultsSeeMoreQueryPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: POLAROID_V1 */
public class SearchResultsFeedVideosModuleGroupPartDefinition<E extends HasContext & HasFeedListType & HasIsAsync & HasPersistentState & HasPositionInformation & HasRowKey & HasSearchResultsContext & HasSearchResultPosition & HasSearchResultsVideoStoryPersistentState & HasPrefetcher> extends BaseMultiRowGroupPartDefinition<SearchResultsProps<SearchResultsFeedVideosModule>, Void, E> {
    private static SearchResultsFeedVideosModuleGroupPartDefinition f25116d;
    private static final Object f25117e = new Object();
    private final SearchResultsVideosHeaderPartDefinition<E> f25118a;
    private final SearchResultsVideosModuleGroupPartDefinition<E> f25119b;
    private final Lazy<SearchResultsSeeMoreQueryPartDefinition<E>> f25120c;

    private static SearchResultsFeedVideosModuleGroupPartDefinition m28414b(InjectorLike injectorLike) {
        return new SearchResultsFeedVideosModuleGroupPartDefinition(SearchResultsVideosHeaderPartDefinition.m27896a(injectorLike), SearchResultsVideosModuleGroupPartDefinition.m28503a(injectorLike), IdBasedLazy.a(injectorLike, 10793));
    }

    public final Object m28415a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        baseMultiRowSubParts.a(this.f25118a, searchResultsProps.f23390c);
        baseMultiRowSubParts.a(this.f25119b, searchResultsProps);
        SearchResultsSeeMoreQueryModel aj = ((NodeModel) searchResultsProps.f23388a).aj();
        if (aj != null) {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f25120c.get(), searchResultsProps.m27104a(aj));
        }
        return null;
    }

    public final boolean m28416a(Object obj) {
        return SearchResultsPropsHelper.m27109b((SearchResultsProps) obj);
    }

    @Inject
    public SearchResultsFeedVideosModuleGroupPartDefinition(SearchResultsVideosHeaderPartDefinition searchResultsVideosHeaderPartDefinition, SearchResultsVideosModuleGroupPartDefinition searchResultsVideosModuleGroupPartDefinition, Lazy<SearchResultsSeeMoreQueryPartDefinition> lazy) {
        this.f25118a = searchResultsVideosHeaderPartDefinition;
        this.f25119b = searchResultsVideosModuleGroupPartDefinition;
        this.f25120c = lazy;
    }

    public static SearchResultsFeedVideosModuleGroupPartDefinition m28413a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsFeedVideosModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25117e) {
                SearchResultsFeedVideosModuleGroupPartDefinition searchResultsFeedVideosModuleGroupPartDefinition;
                if (a2 != null) {
                    searchResultsFeedVideosModuleGroupPartDefinition = (SearchResultsFeedVideosModuleGroupPartDefinition) a2.a(f25117e);
                } else {
                    searchResultsFeedVideosModuleGroupPartDefinition = f25116d;
                }
                if (searchResultsFeedVideosModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28414b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25117e, b3);
                        } else {
                            f25116d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsFeedVideosModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
