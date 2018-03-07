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
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.HScrollUnitCacheUtils;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: birthday_cam_cancel */
public class NetEgoStorySetHScrollPartDefinition<T extends ScrollableItemListFeedUnit> extends MultiRowSinglePartDefinition<FeedUnitAndChangePageListener<T>, Void, FeedEnvironment, HScrollRecyclerView> {
    private static NetEgoStorySetHScrollPartDefinition f9543k;
    private static final Object f9544l = new Object();
    private final BackgroundPartDefinition f9545a;
    public final FeedLoggingViewportEventListener f9546b;
    public final Provider<TriState> f9547c;
    public final Context f9548d;
    public final FeedRenderUtils f9549e;
    public final HScrollUnitCacheUtils f9550f;
    public final EventsStream f9551g;
    private final PersistentRecyclerPartDefinition<Object, FeedEnvironment> f9552h;
    public final NetEgoStorySetPhotoStoryPageRootPartDefinition f9553i;
    public final NetEgoStorySetVideoStoryPageRootPartDefinition f9554j;

    /* compiled from: birthday_cam_cancel */
    public enum PageType {
        NETEGO_PHOTO_STORY,
        NETEGO_VIDEO_STORY
    }

    private static NetEgoStorySetHScrollPartDefinition m10082b(InjectorLike injectorLike) {
        return new NetEgoStorySetHScrollPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), FeedRenderUtils.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), HScrollUnitCacheUtils.b(injectorLike), EventsStream.a(injectorLike), IdBasedProvider.a(injectorLike, 669), PersistentRecyclerPartDefinition.a(injectorLike), NetEgoStorySetPhotoStoryPageRootPartDefinition.m10090a(injectorLike), NetEgoStorySetVideoStoryPageRootPartDefinition.m10099a(injectorLike));
    }

    public final Object m10084a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedUnitAndChangePageListener feedUnitAndChangePageListener = (FeedUnitAndChangePageListener) obj;
        subParts.a(this.f9545a, new StylingData(feedUnitAndChangePageListener.a, PaddingStyle.f));
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) feedUnitAndChangePageListener.a.a;
        subParts.a(this.f9552h, new Props(PageStyle.a((float) this.f9549e.a(this.f9548d), SizeUtil.c(this.f9548d, (float) this.f9549e.a())), scrollableItemListFeedUnit.ac_(), m10080a(feedUnitAndChangePageListener), scrollableItemListFeedUnit.g(), scrollableItemListFeedUnit));
        return null;
    }

    public static NetEgoStorySetHScrollPartDefinition m10081a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NetEgoStorySetHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9544l) {
                NetEgoStorySetHScrollPartDefinition netEgoStorySetHScrollPartDefinition;
                if (a2 != null) {
                    netEgoStorySetHScrollPartDefinition = (NetEgoStorySetHScrollPartDefinition) a2.a(f9544l);
                } else {
                    netEgoStorySetHScrollPartDefinition = f9543k;
                }
                if (netEgoStorySetHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10082b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9544l, b3);
                        } else {
                            f9543k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = netEgoStorySetHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NetEgoStorySetHScrollPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, FeedRenderUtils feedRenderUtils, FeedLoggingViewportEventListener feedLoggingViewportEventListener, HScrollUnitCacheUtils hScrollUnitCacheUtils, EventsStream eventsStream, Provider<TriState> provider, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, NetEgoStorySetPhotoStoryPageRootPartDefinition netEgoStorySetPhotoStoryPageRootPartDefinition, NetEgoStorySetVideoStoryPageRootPartDefinition netEgoStorySetVideoStoryPageRootPartDefinition) {
        this.f9548d = context;
        this.f9545a = backgroundPartDefinition;
        this.f9546b = feedLoggingViewportEventListener;
        this.f9549e = feedRenderUtils;
        this.f9552h = persistentRecyclerPartDefinition;
        this.f9553i = netEgoStorySetPhotoStoryPageRootPartDefinition;
        this.f9554j = netEgoStorySetVideoStoryPageRootPartDefinition;
        this.f9547c = provider;
        this.f9550f = hScrollUnitCacheUtils;
        this.f9551g = eventsStream;
    }

    public final ViewType<HScrollRecyclerView> m10083a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m10085a(Object obj) {
        return true;
    }

    private SimpleCallbacks<FeedEnvironment> m10080a(final FeedUnitAndChangePageListener<T> feedUnitAndChangePageListener) {
        final ImmutableList a = ScrollableItemListFeedUnitImpl.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.a.a);
        final int a2 = this.f9549e.a();
        return new SimpleCallbacks<FeedEnvironment>(this) {
            final /* synthetic */ NetEgoStorySetHScrollPartDefinition f9541d;

            public final /* synthetic */ SinglePartDefinitionWithViewType m10077a(int i) {
                return m10076d(i);
            }

            public final void m10078a(PageSubParts<FeedEnvironment> pageSubParts) {
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(m10076d(i), new NetEgoStorySetPageProps(feedUnitAndChangePageListener.a, i, a2, false));
                }
            }

            private BaseSinglePartDefinitionWithViewType m10076d(int i) {
                PageType pageType;
                NetEgoStorySetHScrollPartDefinition netEgoStorySetHScrollPartDefinition = this.f9541d;
                GraphQLMedia r = StoryAttachmentHelper.o((GraphQLStory) a.get(i)).r();
                if (r == null || !r.an() || r.j() == null || r.j().g() != 82650203) {
                    pageType = PageType.NETEGO_PHOTO_STORY;
                } else {
                    pageType = PageType.NETEGO_VIDEO_STORY;
                }
                PageType pageType2 = pageType;
                switch (pageType2) {
                    case NETEGO_PHOTO_STORY:
                        return this.f9541d.f9553i;
                    case NETEGO_VIDEO_STORY:
                        return this.f9541d.f9554j;
                    default:
                        throw new IllegalStateException("No case to handle PageType:" + pageType2);
                }
            }

            public final void m10079c(int i) {
                if (((TriState) this.f9541d.f9547c.get()).asBoolean(false)) {
                    this.f9541d.f9551g.a(new HScrollEvent(i));
                }
                feedUnitAndChangePageListener.b.a(i, a.size());
                this.f9541d.f9550f.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.a.a, i);
                this.f9541d.f9546b.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.a.a, i);
            }
        };
    }
}
