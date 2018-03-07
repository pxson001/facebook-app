package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.model.SearchResultsPropsHelper;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.video.SearchResultsVideosModuleInterfaces.SearchResultsVideosModule;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACES_SAVE_INTRO */
public class SearchResultsVideosModuleGroupPartDefinition<E extends HasContext & HasPositionInformation & HasSearchResultsContext & HasSearchResultPosition & HasSearchResultsVideoStoryPersistentState & HasPrefetcher & HasFeedListType & HasRowKey> extends BaseMultiRowGroupPartDefinition<SearchResultsProps<? extends SearchResultsVideosModule>, Void, E> {
    private static SearchResultsVideosModuleGroupPartDefinition f25252b;
    private static final Object f25253c = new Object();
    private final SearchResultsVideoPartDefinition<E> f25254a;

    private static SearchResultsVideosModuleGroupPartDefinition m28504b(InjectorLike injectorLike) {
        return new SearchResultsVideosModuleGroupPartDefinition(SearchResultsVideoPartDefinition.m28474a(injectorLike));
    }

    public final Object m28505a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        int i = 0;
        ImmutableList a = ((ModuleResultsModel) Preconditions.checkNotNull(((NodeModel) searchResultsProps.f23388a).bd())).m9710a();
        int size = a.size();
        int i2 = 0;
        while (i < size) {
            baseMultiRowSubParts.a(this.f25254a, searchResultsProps.m27105a(((EdgesModel) a.get(i)).m9703l(), i2));
            i2++;
            i++;
        }
        return null;
    }

    public final boolean m28506a(Object obj) {
        return SearchResultsPropsHelper.m27109b((SearchResultsProps) obj);
    }

    @Inject
    public SearchResultsVideosModuleGroupPartDefinition(SearchResultsVideoPartDefinition searchResultsVideoPartDefinition) {
        this.f25254a = searchResultsVideoPartDefinition;
    }

    public static SearchResultsVideosModuleGroupPartDefinition m28503a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideosModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25253c) {
                SearchResultsVideosModuleGroupPartDefinition searchResultsVideosModuleGroupPartDefinition;
                if (a2 != null) {
                    searchResultsVideosModuleGroupPartDefinition = (SearchResultsVideosModuleGroupPartDefinition) a2.a(f25253c);
                } else {
                    searchResultsVideosModuleGroupPartDefinition = f25252b;
                }
                if (searchResultsVideosModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28504b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25253c, b3);
                        } else {
                            f25252b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideosModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
