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
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.videohome.partdefinitions.VideoHomeViewAspectRatioPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLAY */
public class SearchResultsLiveVideoSinglePartDefinition<E extends HasContext & HasFeedListType & HasFeedMenuHelper & HasSearchResultPosition & HasSearchResultsContext & HasSearchResultsVideoStoryPersistentState> extends MultiRowSinglePartDefinition<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>, Void, E, View> {
    private static SearchResultsLiveVideoSinglePartDefinition f25146c;
    private static final Object f25147d = new Object();
    private final SearchResultsLiveVideoPartDefinition<E> f25148a;
    private final VideoHomeViewAspectRatioPartDefinition f25149b;

    private static SearchResultsLiveVideoSinglePartDefinition m28438b(InjectorLike injectorLike) {
        return new SearchResultsLiveVideoSinglePartDefinition(SearchResultsLiveVideoPartDefinition.m28431a(injectorLike), VideoHomeViewAspectRatioPartDefinition.a(injectorLike));
    }

    public final Object m28440a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f25148a, (SearchResultsProps) obj);
        subParts.a(2131568378, this.f25149b, Float.valueOf(1.0f));
        return null;
    }

    @Inject
    public SearchResultsLiveVideoSinglePartDefinition(SearchResultsLiveVideoPartDefinition searchResultsLiveVideoPartDefinition, VideoHomeViewAspectRatioPartDefinition videoHomeViewAspectRatioPartDefinition) {
        this.f25148a = searchResultsLiveVideoPartDefinition;
        this.f25149b = videoHomeViewAspectRatioPartDefinition;
    }

    public final ViewType<View> m28439a() {
        return SearchResultsLiveVideoPartDefinition.f25137a;
    }

    public final boolean m28441a(Object obj) {
        return true;
    }

    public static SearchResultsLiveVideoSinglePartDefinition m28437a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsLiveVideoSinglePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25147d) {
                SearchResultsLiveVideoSinglePartDefinition searchResultsLiveVideoSinglePartDefinition;
                if (a2 != null) {
                    searchResultsLiveVideoSinglePartDefinition = (SearchResultsLiveVideoSinglePartDefinition) a2.a(f25147d);
                } else {
                    searchResultsLiveVideoSinglePartDefinition = f25146c;
                }
                if (searchResultsLiveVideoSinglePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28438b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25147d, b3);
                        } else {
                            f25146c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsLiveVideoSinglePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
