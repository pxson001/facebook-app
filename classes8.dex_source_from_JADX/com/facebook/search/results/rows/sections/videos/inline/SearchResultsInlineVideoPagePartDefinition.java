package com.facebook.search.results.rows.sections.videos.inline;

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
/* compiled from: PIXEL */
public class SearchResultsInlineVideoPagePartDefinition<E extends HasContext & HasFeedListType & HasFeedMenuHelper & HasSearchResultPosition & HasSearchResultsContext & HasSearchResultsVideoStoryPersistentState> extends MultiRowSinglePartDefinition<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>, Void, E, SearchResultsInlineVideoContainer> {
    public static final ViewType<SearchResultsInlineVideoContainer> f25286a = new C26531();
    private static SearchResultsInlineVideoPagePartDefinition f25287d;
    private static final Object f25288e = new Object();
    private final SearchResultsInlineVideoPartDefinition<E> f25289b;
    private final ExpandingFixedAspectRatioFrameLayoutPartDefinition f25290c;

    /* compiled from: PIXEL */
    final class C26531 extends ViewType<SearchResultsInlineVideoContainer> {
        C26531() {
        }

        public final View m28526a(Context context) {
            return new SearchResultsInlineVideoContainer(context);
        }
    }

    private static SearchResultsInlineVideoPagePartDefinition m28528b(InjectorLike injectorLike) {
        return new SearchResultsInlineVideoPagePartDefinition(SearchResultsInlineVideoPartDefinition.m28533a(injectorLike), ExpandingFixedAspectRatioFrameLayoutPartDefinition.a(injectorLike));
    }

    public final Object m28530a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f25289b, (SearchResultsProps) obj);
        subParts.a(2131563199, this.f25290c, Double.valueOf(1.7777777910232544d));
        return null;
    }

    @Inject
    public SearchResultsInlineVideoPagePartDefinition(SearchResultsInlineVideoPartDefinition searchResultsInlineVideoPartDefinition, ExpandingFixedAspectRatioFrameLayoutPartDefinition expandingFixedAspectRatioFrameLayoutPartDefinition) {
        this.f25289b = searchResultsInlineVideoPartDefinition;
        this.f25290c = expandingFixedAspectRatioFrameLayoutPartDefinition;
    }

    public static SearchResultsInlineVideoPagePartDefinition m28527a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsInlineVideoPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25288e) {
                SearchResultsInlineVideoPagePartDefinition searchResultsInlineVideoPagePartDefinition;
                if (a2 != null) {
                    searchResultsInlineVideoPagePartDefinition = (SearchResultsInlineVideoPagePartDefinition) a2.a(f25288e);
                } else {
                    searchResultsInlineVideoPagePartDefinition = f25287d;
                }
                if (searchResultsInlineVideoPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28528b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25288e, b3);
                        } else {
                            f25287d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsInlineVideoPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<SearchResultsInlineVideoContainer> m28529a() {
        return f25286a;
    }

    public final boolean m28531a(Object obj) {
        return true;
    }
}
