package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ExpandingFixedAspectRatioFrameLayoutPartDefinition;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLAYING */
public class SearchResultsLiveVideoPagePartDefinition<E extends HasContext & HasFeedListType & HasFeedMenuHelper & HasSearchResultPosition & HasSearchResultsContext & HasSearchResultsVideoStoryPersistentState> extends MultiRowSinglePartDefinition<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>, Void, E, SearchResultsLiveVideoContainer> {
    public static final ViewType<SearchResultsLiveVideoContainer> f25128a = new C26401();
    private static SearchResultsLiveVideoPagePartDefinition f25129d;
    private static final Object f25130e = new Object();
    private final SearchResultsLiveVideoPartDefinition<E> f25131b;
    private final ExpandingFixedAspectRatioFrameLayoutPartDefinition f25132c;

    /* compiled from: PLAYING */
    final class C26401 extends ViewType<SearchResultsLiveVideoContainer> {
        C26401() {
        }

        public final View m28422a(Context context) {
            return new SearchResultsLiveVideoContainer(context);
        }
    }

    private static SearchResultsLiveVideoPagePartDefinition m28424b(InjectorLike injectorLike) {
        return new SearchResultsLiveVideoPagePartDefinition(SearchResultsLiveVideoPartDefinition.m28431a(injectorLike), ExpandingFixedAspectRatioFrameLayoutPartDefinition.a(injectorLike));
    }

    public final Object m28426a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f25131b, (SearchResultsProps) obj);
        subParts.a(2131563199, this.f25132c, Double.valueOf(1.0d));
        return null;
    }

    @Inject
    public SearchResultsLiveVideoPagePartDefinition(SearchResultsLiveVideoPartDefinition searchResultsLiveVideoPartDefinition, ExpandingFixedAspectRatioFrameLayoutPartDefinition expandingFixedAspectRatioFrameLayoutPartDefinition) {
        this.f25131b = searchResultsLiveVideoPartDefinition;
        this.f25132c = expandingFixedAspectRatioFrameLayoutPartDefinition;
    }

    public static SearchResultsLiveVideoPagePartDefinition m28423a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsLiveVideoPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25130e) {
                SearchResultsLiveVideoPagePartDefinition searchResultsLiveVideoPagePartDefinition;
                if (a2 != null) {
                    searchResultsLiveVideoPagePartDefinition = (SearchResultsLiveVideoPagePartDefinition) a2.a(f25130e);
                } else {
                    searchResultsLiveVideoPagePartDefinition = f25129d;
                }
                if (searchResultsLiveVideoPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28424b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25130e, b3);
                        } else {
                            f25129d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsLiveVideoPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<SearchResultsLiveVideoContainer> m28425a() {
        return f25128a;
    }

    public final boolean m28427a(Object obj) {
        return true;
    }
}
