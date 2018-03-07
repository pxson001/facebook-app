package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.util.HScrollUnitCacheUtils;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor;
import com.facebook.feedplugins.storyset.funnel.StorySetFunnelLogger;
import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: battery scale is unavailable */
public class StorySetAttachmentStyleHScrollPartDefinition extends MultiRowSinglePartDefinition<FeedUnitAndChangePageListener<GraphQLStorySet>, Void, FeedEnvironment, HScrollRecyclerView> {
    private static StorySetAttachmentStyleHScrollPartDefinition f9599m;
    private static final Object f9600n = new Object();
    private final BackgroundPartDefinition f9601a;
    private final Context f9602b;
    public final StorySetFunnelLogger f9603c;
    public final FeedLoggingViewportEventListener f9604d;
    private final FeedRenderUtils f9605e;
    public final HScrollUnitCacheUtils f9606f;
    private final PageStyleFactory f9607g;
    private final PersistentRecyclerPartDefinition<Object, FeedEnvironment> f9608h;
    public final VideoSetsQeAccessor f9609i;
    public final VideoSetsPageItemWithSimpleBlingbarPartDefinition<FeedEnvironment> f9610j;
    public final VideoSetsPageItemWithFooterPartDefinition<FeedEnvironment> f9611k;
    public final VideoSetsPageItemWithSocialContextPartDefinition<FeedEnvironment> f9612l;

    private static StorySetAttachmentStyleHScrollPartDefinition m10114b(InjectorLike injectorLike) {
        return new StorySetAttachmentStyleHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class), StorySetFunnelLogger.b(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), FeedRenderUtils.a(injectorLike), HScrollUnitCacheUtils.b(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), VideoSetsQeAccessor.a(injectorLike), VideoSetsPageItemWithSimpleBlingbarPartDefinition.a(injectorLike), VideoSetsPageItemWithFooterPartDefinition.a(injectorLike), VideoSetsPageItemWithSocialContextPartDefinition.a(injectorLike));
    }

    public final Object m10116a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedUnitAndChangePageListener feedUnitAndChangePageListener = (FeedUnitAndChangePageListener) obj;
        GraphQLStorySet graphQLStorySet = (GraphQLStorySet) feedUnitAndChangePageListener.a.a;
        subParts.a(this.f9601a, new StylingData(feedUnitAndChangePageListener.a, PageStyle.a, Position.MIDDLE));
        subParts.a(this.f9608h, new Props(m10112b(), graphQLStorySet.ac_(), m10113b(feedUnitAndChangePageListener), graphQLStorySet.g(), graphQLStorySet));
        return null;
    }

    public final boolean m10118a(Object obj) {
        return StorySetHelper.d((GraphQLStorySet) ((FeedUnitAndChangePageListener) obj).a.a);
    }

    public static StorySetAttachmentStyleHScrollPartDefinition m10110a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetAttachmentStyleHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9600n) {
                StorySetAttachmentStyleHScrollPartDefinition storySetAttachmentStyleHScrollPartDefinition;
                if (a2 != null) {
                    storySetAttachmentStyleHScrollPartDefinition = (StorySetAttachmentStyleHScrollPartDefinition) a2.a(f9600n);
                } else {
                    storySetAttachmentStyleHScrollPartDefinition = f9599m;
                }
                if (storySetAttachmentStyleHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10114b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9600n, b3);
                        } else {
                            f9599m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetAttachmentStyleHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public StorySetAttachmentStyleHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, Context context, StorySetFunnelLogger storySetFunnelLogger, FeedLoggingViewportEventListener feedLoggingViewportEventListener, FeedRenderUtils feedRenderUtils, HScrollUnitCacheUtils hScrollUnitCacheUtils, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, VideoSetsQeAccessor videoSetsQeAccessor, VideoSetsPageItemWithSimpleBlingbarPartDefinition videoSetsPageItemWithSimpleBlingbarPartDefinition, VideoSetsPageItemWithFooterPartDefinition videoSetsPageItemWithFooterPartDefinition, VideoSetsPageItemWithSocialContextPartDefinition videoSetsPageItemWithSocialContextPartDefinition) {
        this.f9601a = backgroundPartDefinition;
        this.f9602b = context;
        this.f9603c = storySetFunnelLogger;
        this.f9604d = feedLoggingViewportEventListener;
        this.f9605e = feedRenderUtils;
        this.f9606f = hScrollUnitCacheUtils;
        this.f9607g = pageStyleFactory;
        this.f9608h = persistentRecyclerPartDefinition;
        this.f9609i = videoSetsQeAccessor;
        this.f9610j = videoSetsPageItemWithSimpleBlingbarPartDefinition;
        this.f9611k = videoSetsPageItemWithFooterPartDefinition;
        this.f9612l = videoSetsPageItemWithSocialContextPartDefinition;
    }

    public final ViewType<HScrollRecyclerView> m10115a() {
        return HScrollRecyclerViewRowType.a;
    }

    private void m10111a(FeedUnitAndChangePageListener<GraphQLStorySet> feedUnitAndChangePageListener, Void voidR, FeedEnvironment feedEnvironment, HScrollRecyclerView hScrollRecyclerView) {
        super.a(feedUnitAndChangePageListener, voidR, feedEnvironment, hScrollRecyclerView);
        hScrollRecyclerView.setItemViewCacheSize(0);
    }

    private PageStyle m10112b() {
        return this.f9607g.a((float) this.f9605e.a(this.f9602b), PageStyle.a, true);
    }

    private SimpleCallbacks<FeedEnvironment> m10113b(final FeedUnitAndChangePageListener<GraphQLStorySet> feedUnitAndChangePageListener) {
        final ImmutableList b = StorySetHelper.b((GraphQLStorySet) feedUnitAndChangePageListener.a.a);
        final int a = SizeUtil.a(this.f9602b, (float) this.f9605e.a(this.f9602b));
        return new SimpleCallbacks<FeedEnvironment>(this) {
            final /* synthetic */ StorySetAttachmentStyleHScrollPartDefinition f9598d;

            public final void m10108a(PageSubParts<FeedEnvironment> pageSubParts) {
                for (int i = 0; i < b.size(); i++) {
                    VideoSetsPageItemWithFooterPartDefinition videoSetsPageItemWithFooterPartDefinition;
                    StorySetAttachmentStyleHScrollPartDefinition storySetAttachmentStyleHScrollPartDefinition = this.f9598d;
                    if (storySetAttachmentStyleHScrollPartDefinition.f9609i.b()) {
                        videoSetsPageItemWithFooterPartDefinition = storySetAttachmentStyleHScrollPartDefinition.f9611k;
                    } else if (storySetAttachmentStyleHScrollPartDefinition.f9609i.c()) {
                        videoSetsPageItemWithFooterPartDefinition = storySetAttachmentStyleHScrollPartDefinition.f9612l;
                    } else {
                        videoSetsPageItemWithFooterPartDefinition = storySetAttachmentStyleHScrollPartDefinition.f9610j;
                    }
                    pageSubParts.a(videoSetsPageItemWithFooterPartDefinition, new StorySetPageProps(feedUnitAndChangePageListener.a, i, a, false));
                }
            }

            public final void m10109c(int i) {
                int i2;
                feedUnitAndChangePageListener.b.a(i, b.size());
                this.f9598d.f9606f.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.a.a, i);
                this.f9598d.f9604d.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener.a.a, i);
                StorySetFunnelLogger storySetFunnelLogger = this.f9598d.f9603c;
                FunnelDefinition funnelDefinition = FunnelRegistry.A;
                GraphQLStorySet graphQLStorySet = (GraphQLStorySet) feedUnitAndChangePageListener.a.a;
                if (b.size() - 1 == i) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                storySetFunnelLogger.a(funnelDefinition, graphQLStorySet, i2, "position:" + i);
            }
        };
    }
}
