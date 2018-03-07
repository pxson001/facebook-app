package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.HScrollEvent;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.util.HScrollUnitCacheUtils;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.storyset.ExperimentsForStorySetModule;
import com.facebook.feedplugins.storyset.fetcher.PaginatedStorySetFetcher;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: badge_mismatch */
public class StorySetHScrollPartDefinition extends MultiRowSinglePartDefinition<FeedUnitAndChangePageListener<GraphQLStorySet>, Void, FeedEnvironment, HScrollRecyclerView> {
    private static StorySetHScrollPartDefinition f9632r;
    private static final Object f9633s = new Object();
    public final PaddingStyle f9634a;
    private final BackgroundPartDefinition f9635b;
    public final FeedLoggingViewportEventListener f9636c;
    private final boolean f9637d;
    public final Provider<TriState> f9638e;
    private final PaginatedStorySetFetcher f9639f;
    private final Context f9640g;
    private final FeedRenderUtils f9641h;
    public final HScrollUnitCacheUtils f9642i;
    public final EventsStream f9643j;
    private final PersistentRecyclerPartDefinition<Object, FeedEnvironment> f9644k;
    public final StorySetVideoPageRootPartDefinition f9645l;
    public final StorySetPhotoPageRootPartDefinition f9646m;
    public final StorySetAppInstallPageRootPartDefinition f9647n;
    public final StorySetAutoPlayPageRootPartDefinition f9648o;
    public final StorySetLoadingPageRootPartDefinition f9649p;
    private final QeAccessor f9650q;

    /* compiled from: badge_mismatch */
    enum PageType {
        APP_INSTALL,
        VIDEO,
        VIDEO_AUTOPLAY,
        LOADING,
        PHOTO
    }

    private static StorySetHScrollPartDefinition m10136b(InjectorLike injectorLike) {
        return new StorySetHScrollPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), FeedRenderUtils.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), HScrollUnitCacheUtils.a(injectorLike), EventsStream.a(injectorLike), IdBasedProvider.a(injectorLike, 681), IdBasedProvider.a(injectorLike, 669), PaginatedStorySetFetcher.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), StorySetVideoPageRootPartDefinition.a(injectorLike), StorySetPhotoPageRootPartDefinition.a(injectorLike), StorySetAppInstallPageRootPartDefinition.a(injectorLike), StorySetAutoPlayPageRootPartDefinition.a(injectorLike), StorySetLoadingPageRootPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m10140a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedUnitAndChangePageListener feedUnitAndChangePageListener = (FeedUnitAndChangePageListener) obj;
        subParts.a(this.f9635b, new StylingData(feedUnitAndChangePageListener.a, this.f9634a, Position.TOP));
        if (this.f9637d && this.f9650q.a(ExperimentsForStorySetModule.i, false) && this.f9639f.a((GraphQLStorySet) feedUnitAndChangePageListener.a.a)) {
            m10134a(this, (GraphQLStorySet) feedUnitAndChangePageListener.a.a, 0);
        }
        subParts.a(this.f9644k, new Props(m10138c(), ((GraphQLStorySet) feedUnitAndChangePageListener.a.a).ac_(), m10131a(feedUnitAndChangePageListener), ((GraphQLStorySet) feedUnitAndChangePageListener.a.a).g(), (CacheableEntity) feedUnitAndChangePageListener.a.a));
        return null;
    }

    public static StorySetHScrollPartDefinition m10133a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9633s) {
                StorySetHScrollPartDefinition storySetHScrollPartDefinition;
                if (a2 != null) {
                    storySetHScrollPartDefinition = (StorySetHScrollPartDefinition) a2.a(f9633s);
                } else {
                    storySetHScrollPartDefinition = f9632r;
                }
                if (storySetHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10136b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9633s, b3);
                        } else {
                            f9632r = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public StorySetHScrollPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, FeedRenderUtils feedRenderUtils, FeedLoggingViewportEventListener feedLoggingViewportEventListener, HScrollUnitCacheUtils hScrollUnitCacheUtils, EventsStream eventsStream, Provider<TriState> provider, Provider<TriState> provider2, PaginatedStorySetFetcher paginatedStorySetFetcher, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, StorySetVideoPageRootPartDefinition storySetVideoPageRootPartDefinition, StorySetPhotoPageRootPartDefinition storySetPhotoPageRootPartDefinition, StorySetAppInstallPageRootPartDefinition storySetAppInstallPageRootPartDefinition, StorySetAutoPlayPageRootPartDefinition storySetAutoPlayPageRootPartDefinition, StorySetLoadingPageRootPartDefinition storySetLoadingPageRootPartDefinition, QeAccessor qeAccessor) {
        this.f9640g = context;
        this.f9635b = backgroundPartDefinition;
        this.f9636c = feedLoggingViewportEventListener;
        this.f9641h = feedRenderUtils;
        this.f9644k = persistentRecyclerPartDefinition;
        this.f9637d = ((TriState) provider.get()).asBoolean(false);
        this.f9638e = provider2;
        this.f9639f = paginatedStorySetFetcher;
        this.f9642i = hScrollUnitCacheUtils;
        this.f9643j = eventsStream;
        this.f9634a = Builder.e().a((-defaultPaddingStyleResolver.c()) - defaultPaddingStyleResolver.d()).i();
        this.f9645l = storySetVideoPageRootPartDefinition;
        this.f9646m = storySetPhotoPageRootPartDefinition;
        this.f9647n = storySetAppInstallPageRootPartDefinition;
        this.f9648o = storySetAutoPlayPageRootPartDefinition;
        this.f9649p = storySetLoadingPageRootPartDefinition;
        this.f9650q = qeAccessor;
    }

    public final ViewType<HScrollRecyclerView> m10139a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m10141a(Object obj) {
        return true;
    }

    private PageStyle m10138c() {
        return PageStyle.a(SizeUtil.c(this.f9640g, (float) this.f9641h.a()), true, true);
    }

    private SimpleCallbacks<FeedEnvironment> m10131a(final FeedUnitAndChangePageListener<GraphQLStorySet> feedUnitAndChangePageListener) {
        final ImmutableList b = StorySetHelper.b((GraphQLStorySet) feedUnitAndChangePageListener.a.a);
        final int a = this.f9641h.a();
        return new SimpleCallbacks<FeedEnvironment>(this) {
            final /* synthetic */ StorySetHScrollPartDefinition f9630d;

            public final /* synthetic */ SinglePartDefinitionWithViewType m10127a(int i) {
                return m10126d(i);
            }

            public final void m10128a(PageSubParts<FeedEnvironment> pageSubParts) {
                int a = StorySetHScrollPartDefinition.m10130a(this.f9630d, b.size(), (GraphQLStorySet) feedUnitAndChangePageListener.a.a);
                for (int i = 0; i < a; i++) {
                    pageSubParts.a(m10126d(i), new StorySetPageProps(feedUnitAndChangePageListener.a, i, a, false));
                }
            }

            private BaseSinglePartDefinitionWithViewType m10126d(int i) {
                PageType a = StorySetHScrollPartDefinition.m10132a(this.f9630d, (GraphQLStorySet) feedUnitAndChangePageListener.a.a, b, i);
                switch (a) {
                    case APP_INSTALL:
                        return this.f9630d.f9647n;
                    case LOADING:
                        return this.f9630d.f9649p;
                    case VIDEO:
                        return this.f9630d.f9645l;
                    case VIDEO_AUTOPLAY:
                        return this.f9630d.f9648o;
                    case PHOTO:
                        return this.f9630d.f9646m;
                    default:
                        throw new IllegalStateException("No case to handle PageType:" + a);
                }
            }

            public final void m10129c(int i) {
                if (((TriState) this.f9630d.f9638e.get()).asBoolean(false)) {
                    this.f9630d.f9643j.a(new HScrollEvent(i));
                }
                feedUnitAndChangePageListener.b.a(i, StorySetHScrollPartDefinition.m10130a(this.f9630d, b.size(), (GraphQLStorySet) feedUnitAndChangePageListener.a.a));
                this.f9630d.f9642i.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.a.a, i);
                this.f9630d.f9636c.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.a.a, i);
                StorySetHScrollPartDefinition.m10134a(this.f9630d, (GraphQLStorySet) feedUnitAndChangePageListener.a.a, i);
            }
        };
    }

    public static PageType m10132a(StorySetHScrollPartDefinition storySetHScrollPartDefinition, GraphQLStorySet graphQLStorySet, ImmutableList immutableList, int i) {
        if (i < immutableList.size()) {
            GraphQLMedia r = StoryAttachmentHelper.o((GraphQLStory) immutableList.get(i)).r();
            if (r == null || !r.an() || r.j() == null || r.j().g() != 82650203) {
                return PageType.PHOTO;
            }
            if (((TriState) storySetHScrollPartDefinition.f9638e.get()).asBoolean(false)) {
                return PageType.VIDEO_AUTOPLAY;
            }
            return PageType.VIDEO;
        } else if (!storySetHScrollPartDefinition.m10135a(graphQLStorySet) || storySetHScrollPartDefinition.m10137b(graphQLStorySet, i)) {
            return PageType.LOADING;
        } else {
            return PageType.APP_INSTALL;
        }
    }

    public static int m10130a(StorySetHScrollPartDefinition storySetHScrollPartDefinition, int i, GraphQLStorySet graphQLStorySet) {
        return storySetHScrollPartDefinition.m10135a(graphQLStorySet) ? i + 1 : i;
    }

    public static void m10134a(StorySetHScrollPartDefinition storySetHScrollPartDefinition, GraphQLStorySet graphQLStorySet, int i) {
        if (storySetHScrollPartDefinition.m10137b(graphQLStorySet, i)) {
            storySetHScrollPartDefinition.f9639f.b(graphQLStorySet);
        }
    }

    private boolean m10137b(GraphQLStorySet graphQLStorySet, int i) {
        if (this.f9637d) {
            PaginatedStorySetFetcher paginatedStorySetFetcher = this.f9639f;
            String g = graphQLStorySet.g();
            int size = graphQLStorySet.x().size();
            Object obj = null;
            if (paginatedStorySetFetcher.j.a(ExperimentsForStorySetModule.g, 8) > 0) {
                int a = paginatedStorySetFetcher.j.a(ExperimentsForStorySetModule.j, 5);
                if (!paginatedStorySetFetcher.a.contains(g) && a + i >= size - 1) {
                    obj = 1;
                }
            }
            if (obj != null && this.f9639f.a(graphQLStorySet)) {
                return true;
            }
        }
        return false;
    }

    private boolean m10135a(GraphQLStorySet graphQLStorySet) {
        return this.f9650q.a(ExperimentsForStorySetModule.b, false) && StorySetHelper.c(graphQLStorySet);
    }
}
