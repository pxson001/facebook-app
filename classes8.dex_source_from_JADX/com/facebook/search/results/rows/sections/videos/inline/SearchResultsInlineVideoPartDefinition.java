package com.facebook.search.results.rows.sections.videos.inline;

import android.content.Context;
import android.view.LayoutInflater;
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
import com.facebook.search.results.rows.sections.videos.SearchResultsVideoPlayerPartDefinition;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PICKER_SELECT */
public class SearchResultsInlineVideoPartDefinition<E extends HasContext & HasFeedListType & HasFeedMenuHelper & HasSearchResultPosition & HasSearchResultsContext & HasSearchResultsVideoStoryPersistentState> extends MultiRowSinglePartDefinition<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>, Void, E, View> {
    public static final ViewType<View> f25291a = new C26541();
    private static SearchResultsInlineVideoPartDefinition f25292d;
    private static final Object f25293e = new Object();
    private final SearchResultsVideoPlayerPartDefinition<E> f25294b;
    private final SearchResultsInlineVideoInfoPartDefinition f25295c;

    /* compiled from: PICKER_SELECT */
    final class C26541 extends ViewType<View> {
        C26541() {
        }

        public final View m28532a(Context context) {
            return LayoutInflater.from(context).inflate(2130907008, null, false);
        }
    }

    private static SearchResultsInlineVideoPartDefinition m28534b(InjectorLike injectorLike) {
        return new SearchResultsInlineVideoPartDefinition(SearchResultsVideoPlayerPartDefinition.m28489a(injectorLike), SearchResultsInlineVideoInfoPartDefinition.m28521a(injectorLike));
    }

    public final Object m28536a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        subParts.a(2131568378, this.f25294b, searchResultsProps);
        subParts.a(2131563187, this.f25295c, searchResultsProps);
        return null;
    }

    @Inject
    public SearchResultsInlineVideoPartDefinition(SearchResultsVideoPlayerPartDefinition searchResultsVideoPlayerPartDefinition, SearchResultsInlineVideoInfoPartDefinition searchResultsInlineVideoInfoPartDefinition) {
        this.f25294b = searchResultsVideoPlayerPartDefinition;
        this.f25295c = searchResultsInlineVideoInfoPartDefinition;
    }

    public static SearchResultsInlineVideoPartDefinition m28533a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsInlineVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25293e) {
                SearchResultsInlineVideoPartDefinition searchResultsInlineVideoPartDefinition;
                if (a2 != null) {
                    searchResultsInlineVideoPartDefinition = (SearchResultsInlineVideoPartDefinition) a2.a(f25293e);
                } else {
                    searchResultsInlineVideoPartDefinition = f25292d;
                }
                if (searchResultsInlineVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28534b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25293e, b3);
                        } else {
                            f25292d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsInlineVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<View> m28535a() {
        return f25291a;
    }

    public final boolean m28537a(Object obj) {
        return true;
    }
}
