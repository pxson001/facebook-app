package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.model.SearchResultsPropsHelper;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryModels.SearchResultsSeeMoreQueryModel;
import com.facebook.search.results.protocol.video.SearchResultsWebVideosModuleInterfaces.SearchResultsWebVideosModule;
import com.facebook.search.results.rows.sections.header.SearchResultsVideosHeaderPartDefinition;
import com.facebook.search.results.rows.sections.seemore.SearchResultsSeeMoreQueryPartDefinition;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACEHOLDER_SHOWN */
public class SearchResultsWebVideosModuleGroupPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation & HasSearchResultsContext & HasSearchResultPosition & HasPrefetcher & HasRowKey> extends BaseMultiRowGroupPartDefinition<SearchResultsProps<SearchResultsWebVideosModule>, Void, E> {
    private static SearchResultsWebVideosModuleGroupPartDefinition f25272d;
    private static final Object f25273e = new Object();
    private final SearchResultsVideosHeaderPartDefinition<E> f25274a;
    private final SearchResultsWebVideoPartDefinition<E> f25275b;
    private final Lazy<SearchResultsSeeMoreQueryPartDefinition<E>> f25276c;

    private static SearchResultsWebVideosModuleGroupPartDefinition m28517b(InjectorLike injectorLike) {
        return new SearchResultsWebVideosModuleGroupPartDefinition(SearchResultsVideosHeaderPartDefinition.m27896a(injectorLike), SearchResultsWebVideoPartDefinition.m28508a(injectorLike), IdBasedLazy.a(injectorLike, 10793));
    }

    public final Object m28518a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        int i = 0;
        baseMultiRowSubParts.a(this.f25274a, searchResultsProps.f23390c);
        ImmutableList a = ((ModuleResultsModel) Preconditions.checkNotNull(((NodeModel) searchResultsProps.f23388a).be())).m9710a();
        int size = a.size();
        int i2 = 0;
        while (i < size) {
            baseMultiRowSubParts.a(this.f25275b, searchResultsProps.m27105a(((EdgesModel) a.get(i)).m9704m(), i2));
            i2++;
            i++;
        }
        SearchResultsSeeMoreQueryModel aj = ((NodeModel) searchResultsProps.f23388a).aj();
        if (aj != null) {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f25276c.get(), searchResultsProps.m27104a(aj));
        }
        return null;
    }

    public final boolean m28519a(Object obj) {
        return SearchResultsPropsHelper.m27109b((SearchResultsProps) obj);
    }

    @Inject
    public SearchResultsWebVideosModuleGroupPartDefinition(SearchResultsVideosHeaderPartDefinition searchResultsVideosHeaderPartDefinition, SearchResultsWebVideoPartDefinition searchResultsWebVideoPartDefinition, Lazy<SearchResultsSeeMoreQueryPartDefinition> lazy) {
        this.f25274a = searchResultsVideosHeaderPartDefinition;
        this.f25275b = searchResultsWebVideoPartDefinition;
        this.f25276c = lazy;
    }

    public static SearchResultsWebVideosModuleGroupPartDefinition m28516a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsWebVideosModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25273e) {
                SearchResultsWebVideosModuleGroupPartDefinition searchResultsWebVideosModuleGroupPartDefinition;
                if (a2 != null) {
                    searchResultsWebVideosModuleGroupPartDefinition = (SearchResultsWebVideosModuleGroupPartDefinition) a2.a(f25273e);
                } else {
                    searchResultsWebVideosModuleGroupPartDefinition = f25272d;
                }
                if (searchResultsWebVideosModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28517b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25273e, b3);
                        } else {
                            f25272d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsWebVideosModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
