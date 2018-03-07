package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.feed.styling.ReactionHScrollPagerPaddingResolver;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.search.results.rows.sections.videos.inline.SearchResultsInlineVideoPagePartDefinition;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACES_TO_REVIEW */
public class SearchResultsVideosHScrollPartDefinition<E extends HasContext & HasFeedListType & HasFeedMenuHelper & HasPersistentState & HasPositionInformation & HasSearchResultPosition & HasSearchResultsContext & HasSearchResultsVideoStoryPersistentState> extends MultiRowSinglePartDefinition<ImmutableList<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>>, Void, E, HScrollRecyclerView> {
    public static final ViewType<HScrollRecyclerView> f25241a = HScrollRecyclerViewRowType.c;
    private static final StylingData f25242b;
    private static SearchResultsVideosHScrollPartDefinition f25243j;
    private static final Object f25244k = new Object();
    private final ScreenUtil f25245c;
    private final ReactionHScrollPagerPaddingResolver f25246d;
    private final SearchBackgroundPartDefinition<E> f25247e;
    private final PersistentRecyclerPartDefinition<Object, E> f25248f;
    public final Lazy<SearchResultsInlineVideoPagePartDefinition<E>> f25249g;
    public final Lazy<SearchResultsLiveVideoPagePartDefinition<E>> f25250h;
    public final PageStyleFactory f25251i;

    private static SearchResultsVideosHScrollPartDefinition m28499b(InjectorLike injectorLike) {
        return new SearchResultsVideosHScrollPartDefinition(ScreenUtil.a(injectorLike), ReactionHScrollPagerPaddingResolver.m23459a(injectorLike), SearchBackgroundPartDefinition.m27225a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 10826), IdBasedLazy.a(injectorLike, 10809), PageStyleFactory.b(injectorLike));
    }

    public final Object m28501a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ImmutableList immutableList = (ImmutableList) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        SearchResultsProps searchResultsProps = (SearchResultsProps) immutableList.get(0);
        final String str = searchResultsProps.m27106d() + StoryKeyUtil.a((GraphQLStory) ((FeedProps) Preconditions.checkNotNull(((FeedProps) searchResultsProps.f23388a).b)).a);
        subParts.a(this.f25248f, new Props(m28497a(searchResultsProps, hasContext), 0, new SimpleCallbacks<E>(this) {
            final /* synthetic */ SearchResultsVideosHScrollPartDefinition f25240b;

            public final void m28495a(PageSubParts<E> pageSubParts) {
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    SinglePartDefinitionWithViewType singlePartDefinitionWithViewType;
                    SearchResultsProps searchResultsProps = (SearchResultsProps) immutableList.get(i);
                    if (searchResultsProps.m27106d() == GraphQLGraphSearchResultRole.VIDEOS_LIVE) {
                        singlePartDefinitionWithViewType = (MultiRowSinglePartDefinition) this.f25240b.f25250h.get();
                    } else {
                        MultiRowSinglePartDefinition multiRowSinglePartDefinition = (MultiRowSinglePartDefinition) this.f25240b.f25249g.get();
                    }
                    pageSubParts.a(singlePartDefinitionWithViewType, searchResultsProps);
                }
            }

            public final void m28496c(int i) {
            }
        }, str, new CacheableEntity(this) {
            final /* synthetic */ SearchResultsVideosHScrollPartDefinition f25238b;

            public final String m28494g() {
                return str;
            }
        }));
        subParts.a(this.f25247e, f25242b);
        return null;
    }

    public final boolean m28502a(Object obj) {
        return ((ImmutableList) obj).size() > 1;
    }

    public static SearchResultsVideosHScrollPartDefinition m28498a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideosHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25244k) {
                SearchResultsVideosHScrollPartDefinition searchResultsVideosHScrollPartDefinition;
                if (a2 != null) {
                    searchResultsVideosHScrollPartDefinition = (SearchResultsVideosHScrollPartDefinition) a2.a(f25244k);
                } else {
                    searchResultsVideosHScrollPartDefinition = f25243j;
                }
                if (searchResultsVideosHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28499b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25244k, b3);
                        } else {
                            f25243j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideosHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    static {
        Builder a = Builder.a();
        a.c = -6.0f;
        a = a;
        a.d = -4.0f;
        f25242b = new StylingData(a.i());
    }

    @Inject
    public SearchResultsVideosHScrollPartDefinition(ScreenUtil screenUtil, ReactionHScrollPagerPaddingResolver reactionHScrollPagerPaddingResolver, SearchBackgroundPartDefinition searchBackgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, Lazy<SearchResultsInlineVideoPagePartDefinition> lazy, Lazy<SearchResultsLiveVideoPagePartDefinition> lazy2, PageStyleFactory pageStyleFactory) {
        this.f25245c = screenUtil;
        this.f25246d = reactionHScrollPagerPaddingResolver;
        this.f25247e = searchBackgroundPartDefinition;
        this.f25248f = persistentRecyclerPartDefinition;
        this.f25249g = lazy;
        this.f25250h = lazy2;
        this.f25251i = pageStyleFactory;
    }

    public final ViewType<HScrollRecyclerView> m28500a() {
        return f25241a;
    }

    private PageStyle m28497a(SearchResultsProps<?> searchResultsProps, E e) {
        return this.f25251i.a(((float) SizeUtil.c(e.getContext(), searchResultsProps.m27106d() == GraphQLGraphSearchResultRole.VIDEOS_LIVE ? (float) this.f25246d.m23461a(e.getContext(), GraphQLReactionUnitComponentStyle.VIDEO_CHANNEL_FEED_UNIT_SQUARE) : ((float) this.f25245c.c()) * 0.8f)) + 8.0f, PageStyle.a, true);
    }
}
