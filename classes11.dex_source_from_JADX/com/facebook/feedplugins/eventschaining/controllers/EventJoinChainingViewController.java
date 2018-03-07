package com.facebook.feedplugins.eventschaining.controllers;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.controller.mutation.util.AttachmentMutator;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.events.widget.eventcard.EventActionButtonView;
import com.facebook.events.widget.eventcard.EventAttachmentUtil;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.events.widget.eventcard.EventsRsvpActionListener;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.chaining.HScrollChainingUtil;
import com.facebook.feed.ui.chaining.HScrollChainingViewController;
import com.facebook.feed.ui.chaining.HScrollChainingViewController.ItemListRecyclablePagerAdapter;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.eventschaining.view.EventsChainingFeedUnitItemView;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.LinkExtractorConverter;
import com.facebook.graphql.model.GraphQLEventCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLEventCollectionToItemConnection;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.NodeHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: draft_others */
public class EventJoinChainingViewController extends HScrollChainingViewController {
    private static final CallerContext f7560e = CallerContext.a(EventJoinChainingViewController.class, "native_newsfeed");
    private static final PagerViewType f7561f = new C09631();
    private static EventJoinChainingViewController f7562t;
    private static final Object f7563u = new Object();
    private final FeedImageLoader f7564g;
    private final DefaultFeedUnitRenderer f7565h;
    private final int f7566i = m8805f();
    private final int f7567j = m8804e();
    private final FbDraweeControllerBuilder f7568k;
    private final FeedbackGraphQLGenerator f7569l;
    public final TasksManager f7570m;
    public final AttachmentMutator f7571n;
    public final PrivateEventsRsvpMutator f7572o;
    public final PublicEventsRsvpMutator f7573p;
    private final EventActionButtonStateSelectorProvider f7574q;
    private final GraphQLLinkExtractor f7575r;
    private final CommonEventsBuilder f7576s;

    /* compiled from: draft_others */
    final class C09631 implements PagerViewType {
        C09631() {
        }

        public final Class m8782a() {
            return EventsChainingFeedUnitItemView.class;
        }

        public final View m8781a(Context context) {
            return new EventsChainingFeedUnitItemView(context);
        }
    }

    private static EventJoinChainingViewController m8794b(InjectorLike injectorLike) {
        return new EventJoinChainingViewController((Context) injectorLike.getInstance(Context.class), FeedImageLoader.a(injectorLike), ScreenUtil.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike), FeedRenderUtils.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), FeedbackGraphQLGenerator.a(injectorLike), TasksManager.b(injectorLike), AttachmentMutator.b(injectorLike), PrivateEventsRsvpMutator.b(injectorLike), PublicEventsRsvpMutator.b(injectorLike), (EventActionButtonStateSelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class), GraphQLLinkExtractor.a(injectorLike), CommonEventsBuilder.b(injectorLike));
    }

    public static EventJoinChainingViewController m8791a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventJoinChainingViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7563u) {
                EventJoinChainingViewController eventJoinChainingViewController;
                if (a2 != null) {
                    eventJoinChainingViewController = (EventJoinChainingViewController) a2.a(f7563u);
                } else {
                    eventJoinChainingViewController = f7562t;
                }
                if (eventJoinChainingViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8794b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7563u, b3);
                        } else {
                            f7562t = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventJoinChainingViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m8792a(View view, FeedProps<GraphQLStoryAttachment> feedProps) {
        String a = this.f7575r.a(LinkExtractorConverter.a(((GraphQLStoryAttachment) feedProps.a).z()));
        FeedProps feedProps2 = feedProps.b;
        view.setOnClickListener(this.f7565h.a(feedProps, this.f7576s.a(a, false, feedProps2 != null ? TrackableFeedProps.b(feedProps2) : null, "native_newsfeed"), a));
    }

    protected final void m8800a(FeedProps<ScrollableItemListFeedUnit> feedProps, TextView textView) {
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) feedProps.a;
        if (scrollableItemListFeedUnit.m() == null || StringUtil.c(scrollableItemListFeedUnit.m().a())) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(scrollableItemListFeedUnit.m().a());
        textView.setVisibility(0);
    }

    @Inject
    public EventJoinChainingViewController(Context context, FeedImageLoader feedImageLoader, ScreenUtil screenUtil, DefaultFeedUnitRenderer defaultFeedUnitRenderer, FeedRenderUtils feedRenderUtils, FbDraweeControllerBuilder fbDraweeControllerBuilder, FeedbackGraphQLGenerator feedbackGraphQLGenerator, TasksManager tasksManager, AttachmentMutator attachmentMutator, PrivateEventsRsvpMutator privateEventsRsvpMutator, PublicEventsRsvpMutator publicEventsRsvpMutator, EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider, GraphQLLinkExtractor graphQLLinkExtractor, CommonEventsBuilder commonEventsBuilder) {
        super(context, screenUtil, feedRenderUtils);
        this.f7564g = feedImageLoader;
        this.f7565h = defaultFeedUnitRenderer;
        this.f7568k = fbDraweeControllerBuilder;
        this.f7569l = feedbackGraphQLGenerator;
        this.f7570m = tasksManager;
        this.f7571n = attachmentMutator;
        this.f7572o = privateEventsRsvpMutator;
        this.f7573p = publicEventsRsvpMutator;
        this.f7574q = eventActionButtonStateSelectorProvider;
        this.f7575r = graphQLLinkExtractor;
        this.f7576s = commonEventsBuilder;
    }

    protected final int m8803d() {
        return this.a.getResources().getDimensionPixelSize(2131430238);
    }

    protected final int m8804e() {
        return HScrollChainingUtil.a(m8805f()) + this.a.getResources().getDimensionPixelSize(2131430235);
    }

    protected final int m8805f() {
        return Math.min(this.a.getResources().getDimensionPixelSize(2131430234), HScrollChainingUtil.a(this.b, m8803d(), m8806g()));
    }

    protected final int m8806g() {
        return this.a.getResources().getDimensionPixelSize(2131430236);
    }

    protected final Class<? extends ScrollableItemListFeedUnit> m8802c() {
        return GraphQLEventCollectionFeedUnit.class;
    }

    public final void m8799a(View view, Object obj, Position position, FeedListItemUserActionListener feedListItemUserActionListener, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        FeedProps a = FeedProps.c(scrollableItemListFeedUnit).a(graphQLStoryAttachment);
        EventsChainingFeedUnitItemView eventsChainingFeedUnitItemView = (EventsChainingFeedUnitItemView) view;
        int i = this.f7566i;
        int i2 = this.f7567j;
        LayoutParams layoutParams = eventsChainingFeedUnitItemView.c.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        eventsChainingFeedUnitItemView.c.setLayoutParams(layoutParams);
        a(view, position);
        EventsCardView eventsCardView = eventsChainingFeedUnitItemView.c;
        eventsCardView.d();
        eventsCardView.e();
        eventsCardView.setCoverPhotoAspectRatio(1.9318181f);
        eventsCardView.setCoverPhotoController(m8789a(graphQLStoryAttachment));
        GraphQLNode z = graphQLStoryAttachment.z();
        if (z != null) {
            eventsCardView.setCalendarFormatStartDate(EventsDateUtil.c(z.hK()));
            eventsCardView.setTitleText(Strings.nullToEmpty(graphQLStoryAttachment.A()));
            GraphQLPlace cl = z.cl();
            eventsCardView.a(EventAttachmentUtil.a(cl), EventAttachmentUtil.b(cl));
            eventsCardView.setSocialContextText(EventAttachmentUtil.a(z));
        }
        m8792a((View) eventsChainingFeedUnitItemView.c, a);
        m8793a(eventsChainingFeedUnitItemView, graphQLStoryAttachment, scrollableItemListFeedUnit, feedListItemUserActionListener);
    }

    protected final void m8798a(View view) {
        ((EventsChainingFeedUnitItemView) view).c.b();
    }

    private DraweeController m8789a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment.z() == null || !NodeHelper.b(graphQLStoryAttachment.z())) {
            return null;
        }
        return ((FbDraweeControllerBuilder) this.f7568k.a(f7560e).c(FeedImageLoader.a(NodeHelper.a(graphQLStoryAttachment.z())))).s();
    }

    public final void m8801a(ItemListRecyclablePagerAdapter itemListRecyclablePagerAdapter, ViewPager viewPager, View view, Object obj, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        String str;
        if (itemListRecyclablePagerAdapter.c == null) {
            str = null;
        } else {
            str = itemListRecyclablePagerAdapter.c.g();
        }
        String str2 = str;
        if (str2 != null) {
            this.f7569l.a(str2, scrollableItemListFeedUnit);
        }
        itemListRecyclablePagerAdapter.a(scrollableItemListFeedUnit.v());
    }

    public final PagerViewType m8796a() {
        return f7561f;
    }

    public final ArrayNode m8797a(FeedProps<ScrollableItemListFeedUnit> feedProps) {
        return TrackableFeedProps.b(feedProps);
    }

    private void m8793a(EventsChainingFeedUnitItemView eventsChainingFeedUnitItemView, GraphQLStoryAttachment graphQLStoryAttachment, ScrollableItemListFeedUnit scrollableItemListFeedUnit, FeedListItemUserActionListener feedListItemUserActionListener) {
        GraphQLNode z = graphQLStoryAttachment.z();
        EventActionButtonView eventActionView = eventsChainingFeedUnitItemView.getEventActionView();
        if (z == null || Strings.isNullOrEmpty(z.dp())) {
            eventActionView.setVisibility(8);
            return;
        }
        eventActionView.setVisibility(0);
        eventsChainingFeedUnitItemView.b = z.dp();
        eventsChainingFeedUnitItemView.getEventActionView().a(this.f7574q.a(m8790a(z.dp(), eventsChainingFeedUnitItemView, graphQLStoryAttachment, scrollableItemListFeedUnit, feedListItemUserActionListener)).a(z.bn(), z.je(), z.jq()));
    }

    private EventsRsvpActionListener m8790a(String str, EventsChainingFeedUnitItemView eventsChainingFeedUnitItemView, GraphQLStoryAttachment graphQLStoryAttachment, ScrollableItemListFeedUnit scrollableItemListFeedUnit, FeedListItemUserActionListener feedListItemUserActionListener) {
        final String str2 = str;
        final FeedListItemUserActionListener feedListItemUserActionListener2 = feedListItemUserActionListener;
        final EventsChainingFeedUnitItemView eventsChainingFeedUnitItemView2 = eventsChainingFeedUnitItemView;
        final GraphQLStoryAttachment graphQLStoryAttachment2 = graphQLStoryAttachment;
        final ScrollableItemListFeedUnit scrollableItemListFeedUnit2 = scrollableItemListFeedUnit;
        return new EventsRsvpActionListener(this) {
            final /* synthetic */ EventJoinChainingViewController f7559f;

            /* compiled from: draft_others */
            class C09641 extends AbstractDisposableFutureCallback {
                final /* synthetic */ C09662 f7552a;

                C09641(C09662 c09662) {
                    this.f7552a = c09662;
                }

                protected final void m8783a(Object obj) {
                }

                protected final void m8784a(Throwable th) {
                    feedListItemUserActionListener2.a(eventsChainingFeedUnitItemView2, graphQLStoryAttachment2, scrollableItemListFeedUnit2);
                }
            }

            /* compiled from: draft_others */
            class C09652 extends AbstractDisposableFutureCallback {
                final /* synthetic */ C09662 f7553a;

                C09652(C09662 c09662) {
                    this.f7553a = c09662;
                }

                protected final void m8785a(Object obj) {
                }

                protected final void m8786a(Throwable th) {
                    feedListItemUserActionListener2.a(eventsChainingFeedUnitItemView2, graphQLStoryAttachment2, scrollableItemListFeedUnit2);
                }
            }

            public final void m8787a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
                this.f7559f.f7570m.a(this, this.f7559f.f7572o.a(str2, graphQLEventGuestStatus2, "unknown", "native_newsfeed", ActionMechanism.EVENT_CHAINING, null), new C09641(this));
                AttachmentMutator attachmentMutator = this.f7559f.f7571n;
                GraphQLStoryAttachment a = AttachmentMutator.a(graphQLStoryAttachment2, graphQLEventGuestStatus2);
                feedListItemUserActionListener2.a(eventsChainingFeedUnitItemView2, a, EventJoinChainingViewController.m8795b(scrollableItemListFeedUnit2, a));
            }

            public final void m8788a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
                this.f7559f.f7570m.a(this, this.f7559f.f7573p.a(str2, graphQLEventWatchStatus2, "unknown", "native_newsfeed", ActionMechanism.EVENT_CHAINING), new C09652(this));
                AttachmentMutator attachmentMutator = this.f7559f.f7571n;
                GraphQLStoryAttachment a = AttachmentMutator.a(graphQLStoryAttachment2, graphQLEventWatchStatus2);
                feedListItemUserActionListener2.a(eventsChainingFeedUnitItemView2, a, EventJoinChainingViewController.m8795b(scrollableItemListFeedUnit2, a));
            }
        };
    }

    public static GraphQLEventCollectionFeedUnit m8795b(ScrollableItemListFeedUnit scrollableItemListFeedUnit, GraphQLStoryAttachment graphQLStoryAttachment) {
        int i = 0;
        GraphQLEventCollectionFeedUnit graphQLEventCollectionFeedUnit = (GraphQLEventCollectionFeedUnit) scrollableItemListFeedUnit;
        if (graphQLStoryAttachment.z() == null) {
            Object obj = null;
        } else {
            String dp = graphQLStoryAttachment.z().dp();
        }
        ImmutableList l = graphQLEventCollectionFeedUnit.l();
        int size = l.size();
        Builder builder = new Builder();
        int i2 = 0;
        while (i < size) {
            int i3;
            GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) l.get(i);
            if (graphQLStoryAttachment2.z() == null || !Objects.equal(graphQLStoryAttachment2.z().dp(), r1)) {
                builder.c(graphQLStoryAttachment2);
                i3 = i2;
            } else {
                builder.c(graphQLStoryAttachment);
                i3 = i;
            }
            i++;
            i2 = i3;
        }
        GraphQLEventCollectionToItemConnection q = graphQLEventCollectionFeedUnit.q();
        GraphQLEventCollectionToItemConnection.Builder builder2 = new GraphQLEventCollectionToItemConnection.Builder();
        q.h();
        builder2.d = q.a();
        BaseModel.Builder.a(builder2, q);
        GraphQLEventCollectionToItemConnection.Builder builder3 = builder2;
        builder3.d = builder.b();
        q = new GraphQLEventCollectionToItemConnection(builder3);
        GraphQLEventCollectionFeedUnit.Builder builder4 = new GraphQLEventCollectionFeedUnit.Builder();
        graphQLEventCollectionFeedUnit.h();
        builder4.d = graphQLEventCollectionFeedUnit.g();
        builder4.e = graphQLEventCollectionFeedUnit.S_();
        builder4.f = graphQLEventCollectionFeedUnit.o();
        builder4.g = graphQLEventCollectionFeedUnit.T_();
        builder4.h = graphQLEventCollectionFeedUnit.p();
        builder4.i = graphQLEventCollectionFeedUnit.q();
        builder4.j = graphQLEventCollectionFeedUnit.r();
        builder4.k = graphQLEventCollectionFeedUnit.k();
        BaseModel.Builder.a(builder4, graphQLEventCollectionFeedUnit);
        builder4.l = (com.facebook.graphql.model.PropertyBag) graphQLEventCollectionFeedUnit.U_().clone();
        GraphQLEventCollectionFeedUnit.Builder builder5 = builder4;
        builder5.i = q;
        ScrollableItemListFeedUnit graphQLEventCollectionFeedUnit2 = new GraphQLEventCollectionFeedUnit(builder5);
        VisibleItemHelper.a(graphQLEventCollectionFeedUnit2, i2);
        return graphQLEventCollectionFeedUnit2;
    }
}
