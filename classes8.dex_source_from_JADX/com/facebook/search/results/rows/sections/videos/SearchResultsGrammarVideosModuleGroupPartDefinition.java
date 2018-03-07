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
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.abtest.VideoSearchExperimentHelper;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryModels.SearchResultsSeeMoreQueryModel;
import com.facebook.search.results.protocol.video.SearchResultsGrammarVideosModuleInterfaces.SearchResultsGrammarVideosModule;
import com.facebook.search.results.rows.sections.header.SearchResultsTitlePartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsTitlePartDefinition.Props;
import com.facebook.search.results.rows.sections.seemore.SearchResultsSeeMoreQueryPartDefinition;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: POG_SECTION */
public class SearchResultsGrammarVideosModuleGroupPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasFeedListType & HasFeedMenuHelper & HasPositionInformation & HasPrefetcher & HasRowKey & HasSearchResultPosition & HasSearchResultsContext & HasSearchResultsVideoStoryPersistentState> extends BaseMultiRowGroupPartDefinition<SearchResultsProps<SearchResultsGrammarVideosModule>, Void, E> {
    private static SearchResultsGrammarVideosModuleGroupPartDefinition f25121e;
    private static final Object f25122f = new Object();
    private final VideoSearchExperimentHelper f25123a;
    private final SearchResultsTitlePartDefinition f25124b;
    private final SearchResultsVideosHScrollPartDefinition<E> f25125c;
    private final SearchResultsSeeMoreQueryPartDefinition<E> f25126d;

    private static SearchResultsGrammarVideosModuleGroupPartDefinition m28418b(InjectorLike injectorLike) {
        return new SearchResultsGrammarVideosModuleGroupPartDefinition(VideoSearchExperimentHelper.b(injectorLike), SearchResultsTitlePartDefinition.m27890a(injectorLike), SearchResultsVideosHScrollPartDefinition.m28498a(injectorLike), SearchResultsSeeMoreQueryPartDefinition.m28331a(injectorLike));
    }

    public final Object m28419a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        SearchResultsEdgeModel searchResultsEdgeModel = searchResultsProps.f23390c;
        baseMultiRowSubParts.a(this.f25124b, new Props(SearchResultsEdgeUtil.m9802d(searchResultsEdgeModel), SearchResultsEdgeUtil.m9799a(searchResultsEdgeModel), SearchResultsEdgeUtil.m9801c(searchResultsEdgeModel)));
        baseMultiRowSubParts.a(this.f25125c, SearchResultsVideosModuleUtil.m28507a(searchResultsProps));
        SearchResultsSeeMoreQueryModel aj = ((NodeModel) searchResultsProps.f23388a).aj();
        if (aj != null) {
            baseMultiRowSubParts.a(this.f25126d, searchResultsProps.m27104a(aj));
        }
        return null;
    }

    public final boolean m28420a(Object obj) {
        if (SearchResultsEdgeUtil.m9804f(((SearchResultsProps) obj).f23390c) > 1) {
            VideoSearchExperimentHelper videoSearchExperimentHelper = this.f25123a;
            boolean z = true;
            int a = videoSearchExperimentHelper.a.a(ExperimentsForSearchAbTestModule.G, -1);
            if (a == -1) {
                z = videoSearchExperimentHelper.b.a(SearchAbTestGatekeepers.G, false);
            } else if (a != 1) {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Inject
    public SearchResultsGrammarVideosModuleGroupPartDefinition(VideoSearchExperimentHelper videoSearchExperimentHelper, SearchResultsTitlePartDefinition searchResultsTitlePartDefinition, SearchResultsVideosHScrollPartDefinition searchResultsVideosHScrollPartDefinition, SearchResultsSeeMoreQueryPartDefinition searchResultsSeeMoreQueryPartDefinition) {
        this.f25123a = videoSearchExperimentHelper;
        this.f25124b = searchResultsTitlePartDefinition;
        this.f25125c = searchResultsVideosHScrollPartDefinition;
        this.f25126d = searchResultsSeeMoreQueryPartDefinition;
    }

    public static SearchResultsGrammarVideosModuleGroupPartDefinition m28417a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsGrammarVideosModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25122f) {
                SearchResultsGrammarVideosModuleGroupPartDefinition searchResultsGrammarVideosModuleGroupPartDefinition;
                if (a2 != null) {
                    searchResultsGrammarVideosModuleGroupPartDefinition = (SearchResultsGrammarVideosModuleGroupPartDefinition) a2.a(f25122f);
                } else {
                    searchResultsGrammarVideosModuleGroupPartDefinition = f25121e;
                }
                if (searchResultsGrammarVideosModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28418b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25122f, b3);
                        } else {
                            f25121e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsGrammarVideosModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
