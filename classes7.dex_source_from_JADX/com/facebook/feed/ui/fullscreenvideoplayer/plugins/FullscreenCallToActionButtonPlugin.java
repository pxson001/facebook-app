package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.data.FeedStorySubscriber.OnStoryChangeListener;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.leadgen.LeadGenActionLinkOnClickListenerProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.event.UfiEvents.PageLikeClickedEvent;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPAfterVideoPlayedEvent;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: TimelineEarlyFetchHeadStart */
public class FullscreenCallToActionButtonPlugin extends RichVideoPlayerPlugin {
    @Inject
    public DefaultFeedUnitRenderer f22105a;
    @Inject
    public FeedEventBus f22106b;
    @Inject
    public LeadGenActionLinkOnClickListenerProvider f22107c;
    @Inject
    public FeedStorySubscriber f22108d;
    public View f22109l;
    public ImageView f22110m;
    public FbTextView f22111n;

    /* compiled from: TimelineEarlyFetchHeadStart */
    class C18841 implements OnStoryChangeListener {
        final /* synthetic */ FullscreenCallToActionButtonPlugin f22096a;

        C18841(FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin) {
            this.f22096a = fullscreenCallToActionButtonPlugin;
        }

        public final void mo1522a(GraphQLStory graphQLStory) {
            FeedProps i = StoryProps.i(FeedProps.c(graphQLStory));
            if (i != null) {
                FullscreenCallToActionButtonPlugin.setupCallToActionButton(this.f22096a, i);
            } else {
                this.f22096a.g();
            }
        }
    }

    /* compiled from: TimelineEarlyFetchHeadStart */
    class AfterVideoPlayedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPAfterVideoPlayedEvent> {
        final /* synthetic */ FullscreenCallToActionButtonPlugin f22103a;

        public AfterVideoPlayedEventSubscriber(FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
            this.f22103a = fullscreenCallToActionButtonPlugin;
            super(richVideoPlayerPlugin);
        }

        public final void m24725b(FbEvent fbEvent) {
            FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin = this.f22103a;
            if (fullscreenCallToActionButtonPlugin.f22109l.getVisibility() != 0) {
                fullscreenCallToActionButtonPlugin.f22109l.setVisibility(0);
            }
        }

        public final Class<RVPAfterVideoPlayedEvent> m24724a() {
            return RVPAfterVideoPlayedEvent.class;
        }
    }

    /* compiled from: TimelineEarlyFetchHeadStart */
    class StreamCompleteEventSubscriber extends RichVideoPlayerEventSubscriber<RVPStreamCompleteEvent> {
        final /* synthetic */ FullscreenCallToActionButtonPlugin f22104a;

        public StreamCompleteEventSubscriber(FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
            this.f22104a = fullscreenCallToActionButtonPlugin;
            super(richVideoPlayerPlugin);
        }

        public final void m24727b(FbEvent fbEvent) {
            FullscreenCallToActionButtonPlugin.m24732e(this.f22104a);
        }

        public final Class<RVPStreamCompleteEvent> m24726a() {
            return RVPStreamCompleteEvent.class;
        }
    }

    public static void m24730a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin = (FullscreenCallToActionButtonPlugin) obj;
        DefaultFeedUnitRenderer a = DefaultFeedUnitRenderer.a(fbInjector);
        FeedEventBus a2 = FeedEventBus.a(fbInjector);
        LeadGenActionLinkOnClickListenerProvider leadGenActionLinkOnClickListenerProvider = (LeadGenActionLinkOnClickListenerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(LeadGenActionLinkOnClickListenerProvider.class);
        FeedStorySubscriber b = FeedStorySubscriber.m22696b(fbInjector);
        fullscreenCallToActionButtonPlugin.f22105a = a;
        fullscreenCallToActionButtonPlugin.f22106b = a2;
        fullscreenCallToActionButtonPlugin.f22107c = leadGenActionLinkOnClickListenerProvider;
        fullscreenCallToActionButtonPlugin.f22108d = b;
    }

    @DoNotStrip
    public FullscreenCallToActionButtonPlugin(Context context) {
        this(context, null);
    }

    private FullscreenCallToActionButtonPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FullscreenCallToActionButtonPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FullscreenCallToActionButtonPlugin.class;
        m24730a((Object) this, getContext());
        setContentView(2130904550);
        this.f.add(new StreamCompleteEventSubscriber(this, this));
        this.f.add(new AfterVideoPlayedEventSubscriber(this, this));
        this.f22109l = a(2131562426);
        this.f22110m = (ImageView) a(2131562427);
        this.f22111n = (FbTextView) a(2131562428);
        TrackingNodes.a(this.f22109l, TrackingNode.GENERIC_CALL_TO_ACTION_BUTTON);
        this.f22109l.setTag(2131558543, "video_cta_full_screen_click");
    }

    protected final void m24733a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (z) {
            m24732e(this);
        }
        if (richVideoPlayerParams.b == null || !(richVideoPlayerParams.b.containsKey("GraphQLStoryProps") || m24731a(richVideoPlayerParams))) {
            g();
            return;
        }
        FeedProps feedProps = null;
        if (richVideoPlayerParams.b.containsKey("GraphQLStoryProps")) {
            feedProps = (FeedProps) richVideoPlayerParams.b.get("GraphQLStoryProps");
            feedProps = feedProps.a(StoryAttachmentHelper.o((GraphQLStory) feedProps.a));
        } else if (m24731a(richVideoPlayerParams)) {
            Object obj = richVideoPlayerParams.b.get("MultiShareGraphQLSubStoryPropsKey");
            Object obj2 = richVideoPlayerParams.b.get("MultiShareGraphQLSubStoryIndexKey");
            Preconditions.a(obj instanceof FeedProps);
            Preconditions.a(((FeedProps) obj).a instanceof GraphQLStory);
            Preconditions.a(obj2 instanceof Integer);
            FeedProps feedProps2 = (FeedProps) obj;
            GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) feedProps2.a);
            feedProps = feedProps2.a(o).a((Flattenable) o.x().get(((Integer) obj2).intValue()));
        }
        if (feedProps != null) {
            GraphQLStory c = AttachmentProps.c(feedProps);
            if (c.c() != null) {
                this.f22108d.m22698a(c);
                this.f22108d.f19187d = new C18841(this);
            }
            setupCallToActionButton(this, feedProps);
            return;
        }
        g();
    }

    public static void setupCallToActionButton(FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin, final FeedProps feedProps) {
        Object obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (ActionLinkHelper.a(graphQLStoryAttachment, -508788748) == null || !(CallToActionUtil.l(graphQLStoryAttachment) || CallToActionUtil.f(graphQLStoryAttachment))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, -508788748);
            fullscreenCallToActionButtonPlugin.f22109l.setOnClickListener(fullscreenCallToActionButtonPlugin.f22105a.a(feedProps, a));
            fullscreenCallToActionButtonPlugin.f22109l.setBackgroundResource(2130843888);
            fullscreenCallToActionButtonPlugin.f22110m.setVisibility(8);
            fullscreenCallToActionButtonPlugin.f22111n.setAllCaps(true);
            fullscreenCallToActionButtonPlugin.f22111n.setText(a.aB());
            return;
        }
        if (ActionLinkHelper.a(graphQLStoryAttachment, 1185006756) != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, 1185006756);
            final OnClickListener a2 = fullscreenCallToActionButtonPlugin.f22107c.a(feedProps, fullscreenCallToActionButtonPlugin.getContext(), null);
            fullscreenCallToActionButtonPlugin.f22109l.setOnClickListener(new OnClickListener(fullscreenCallToActionButtonPlugin) {
                final /* synthetic */ FullscreenCallToActionButtonPlugin f22098b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 590354393);
                    this.f22098b.g.a(new RVPRequestPausingEvent(EventTriggerType.BY_USER));
                    a2.onClick(view);
                    Logger.a(2, EntryType.UI_INPUT_END, -1320436859, a);
                }
            });
            fullscreenCallToActionButtonPlugin.f22109l.setBackgroundResource(2130843888);
            fullscreenCallToActionButtonPlugin.f22110m.setVisibility(8);
            fullscreenCallToActionButtonPlugin.f22111n.setAllCaps(true);
            fullscreenCallToActionButtonPlugin.f22111n.setText(a.aB());
        } else if (CallToActionUtil.h(graphQLStoryAttachment)) {
            final GraphQLPage ab = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, -581184810).ab();
            fullscreenCallToActionButtonPlugin.f22109l.setOnClickListener(new OnClickListener(fullscreenCallToActionButtonPlugin) {
                final /* synthetic */ FullscreenCallToActionButtonPlugin f22101c;
                private boolean f22102d = ab.O();

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1489216420);
                    FullscreenCallToActionButtonPlugin.m24728a(this.f22101c, ab, feedProps);
                    this.f22102d = !this.f22102d;
                    FullscreenCallToActionButtonPlugin.m24729a(this.f22101c, this.f22102d);
                    LogUtils.a(-1200732241, a);
                }
            });
            fullscreenCallToActionButtonPlugin.f22109l.setBackgroundResource(2130842482);
            fullscreenCallToActionButtonPlugin.f22110m.setVisibility(0);
            fullscreenCallToActionButtonPlugin.f22111n.setAllCaps(false);
            m24729a(fullscreenCallToActionButtonPlugin, ab.O());
        } else {
            fullscreenCallToActionButtonPlugin.g();
        }
    }

    protected final void m24734c() {
        this.f22108d.m22697a();
    }

    public static void m24728a(FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin, GraphQLPage graphQLPage, FeedProps feedProps) {
        GraphQLStory c = AttachmentProps.c(feedProps);
        if (c != null) {
            String j;
            FeedProps feedProps2 = null;
            for (FeedProps feedProps3 = feedProps; feedProps3 != null; feedProps3 = feedProps3.b) {
                Flattenable flattenable = feedProps3.a;
                if ((flattenable instanceof GraphQLStory) || (flattenable instanceof GraphQLStorySet)) {
                    feedProps2 = feedProps3;
                }
            }
            FeedProps feedProps4 = feedProps2;
            if (c.l() != null) {
                j = c.l().j();
            } else {
                j = null;
            }
            fullscreenCallToActionButtonPlugin.f22106b.a(new PageLikeClickedEvent(feedProps4, graphQLPage.ae(), j, null, null));
        }
    }

    public static void m24729a(FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin, boolean z) {
        if (z) {
            fullscreenCallToActionButtonPlugin.f22110m.setImageResource(2130843906);
            fullscreenCallToActionButtonPlugin.f22111n.setText(2131235369);
            return;
        }
        fullscreenCallToActionButtonPlugin.f22110m.setImageResource(2130843905);
        fullscreenCallToActionButtonPlugin.f22111n.setText(2131233426);
    }

    public static void m24732e(FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin) {
        fullscreenCallToActionButtonPlugin.f22109l.setVisibility(8);
    }

    private static boolean m24731a(RichVideoPlayerParams richVideoPlayerParams) {
        return richVideoPlayerParams.b.containsKey("MultiShareGraphQLSubStoryPropsKey") && richVideoPlayerParams.b.containsKey("MultiShareGraphQLSubStoryIndexKey");
    }
}
