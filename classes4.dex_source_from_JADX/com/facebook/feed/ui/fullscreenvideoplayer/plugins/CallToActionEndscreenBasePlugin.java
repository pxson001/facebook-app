package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.Preconditions;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.leadgen.LeadGenActionLinkOnClickListenerProvider;
import com.facebook.leadgen.LeadGenUtil;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPChromeBehaviorChangeEvent;
import com.facebook.video.player.events.RVPLoadingSpinnerStateEvent;
import com.facebook.video.player.events.RVPPlayIconStateEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.ChromeBehavior;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.StubbableRichVideoPlayerPlugin;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: oxygen_map_static_map_view_impression */
public abstract class CallToActionEndscreenBasePlugin extends StubbableRichVideoPlayerPlugin {
    public static final CallerContext f14135m = CallerContext.a(CallToActionEndscreenBasePlugin.class, "video_cover");
    protected EndscreenType f14136b;
    @Inject
    public DefaultFeedUnitRenderer f14137c;
    @Inject
    public LeadGenActionLinkOnClickListenerProvider f14138d;
    @Inject
    public VideoLoggingUtils f14139l;
    public View f14140n;
    public View f14141o;
    public View f14142p;
    private TextView f14143q;
    public FbDraweeView f14144r;
    public TextView f14145s;
    public TextView f14146t;
    private State f14147u;
    private boolean f14148v;
    public boolean f14149w;
    private VideoPlayerParams f14150x;

    /* compiled from: oxygen_map_static_map_view_impression */
    public enum EndscreenType {
        ENDSCREEN,
        PAUSESCREEN
    }

    /* compiled from: oxygen_map_static_map_view_impression */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ CallToActionEndscreenBasePlugin f14154a;

        public final void m14965b(FbEvent fbEvent) {
            CallToActionEndscreenBasePlugin.m14948a(this.f14154a, ((RVPPlayerStateChangedEvent) fbEvent).f14079b);
        }

        public PlayerStateChangedEventSubscriber(CallToActionEndscreenBasePlugin callToActionEndscreenBasePlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
            this.f14154a = callToActionEndscreenBasePlugin;
            super(richVideoPlayerPlugin);
        }

        public final Class<RVPPlayerStateChangedEvent> m14964a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: oxygen_map_static_map_view_impression */
    class RequestPausingEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestPausingEvent> {
        final /* synthetic */ CallToActionEndscreenBasePlugin f14155a;

        public final void m14967b(FbEvent fbEvent) {
            boolean z;
            RVPRequestPausingEvent rVPRequestPausingEvent = (RVPRequestPausingEvent) fbEvent;
            CallToActionEndscreenBasePlugin callToActionEndscreenBasePlugin = this.f14155a;
            if (rVPRequestPausingEvent.f14167a == EventTriggerType.BY_SEEKBAR_CONTROLLER) {
                z = true;
            } else {
                z = false;
            }
            callToActionEndscreenBasePlugin.f14149w = z;
        }

        public RequestPausingEventSubscriber(CallToActionEndscreenBasePlugin callToActionEndscreenBasePlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
            this.f14155a = callToActionEndscreenBasePlugin;
            super(richVideoPlayerPlugin);
        }

        public final Class<RVPRequestPausingEvent> m14966a() {
            return RVPRequestPausingEvent.class;
        }
    }

    public static void m14949a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CallToActionEndscreenBasePlugin callToActionEndscreenBasePlugin = (CallToActionEndscreenBasePlugin) obj;
        DefaultFeedUnitRenderer a = DefaultFeedUnitRenderer.a(fbInjector);
        LeadGenActionLinkOnClickListenerProvider leadGenActionLinkOnClickListenerProvider = (LeadGenActionLinkOnClickListenerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(LeadGenActionLinkOnClickListenerProvider.class);
        VideoLoggingUtils a2 = VideoLoggingUtils.a(fbInjector);
        callToActionEndscreenBasePlugin.f14137c = a;
        callToActionEndscreenBasePlugin.f14138d = leadGenActionLinkOnClickListenerProvider;
        callToActionEndscreenBasePlugin.f14139l = a2;
    }

    protected abstract boolean mo1010a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment);

    protected abstract boolean mo1011f();

    protected abstract OnClickListener getCallToActionEndscreenReplayClickListener();

    public CallToActionEndscreenBasePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CallToActionEndscreenBasePlugin.class;
        m14949a((Object) this, getContext());
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this, this));
        this.f14094f.add(new RequestPausingEventSubscriber(this, this));
    }

    protected void setupViews(View view) {
        this.f14140n = view.findViewById(2131560137);
        this.f14141o = view.findViewById(2131560138);
        this.f14143q = (TextView) view.findViewById(2131560140);
        this.f14142p = view.findViewById(2131560141);
        this.f14144r = (FbDraweeView) view.findViewById(2131560142);
        this.f14145s = (TextView) view.findViewById(2131560143);
        this.f14146t = (TextView) view.findViewById(2131560144);
        TrackingNodes.a(this.f14142p, TrackingNode.GENERIC_CALL_TO_ACTION_BUTTON);
        this.f14142p.setTag(2131558543, "video_cta_end_screen_click");
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        this.f14150x = richVideoPlayerParams.f4962a;
        FeedProps b = m14950b(richVideoPlayerParams);
        if (z) {
            boolean z2;
            if (b == null || !(CallToActionUtil.l((GraphQLStoryAttachment) b.a) || CallToActionUtil.d((GraphQLStoryAttachment) b.a))) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f14148v = z2;
            m14954o();
        }
        if (this.f14153c) {
            setupCallToActionEndscreen(b);
        }
        this.f14149w = false;
    }

    protected int getLayoutToInflate() {
        return 2130903481;
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
        setupCallToActionEndscreen(m14950b(richVideoPlayerParams));
    }

    protected final boolean mo377a(RichVideoPlayerParams richVideoPlayerParams) {
        return richVideoPlayerParams.f4963b != null && mo1010a(m14951c(richVideoPlayerParams));
    }

    @Nullable
    private FeedProps<GraphQLStoryAttachment> m14950b(RichVideoPlayerParams richVideoPlayerParams) {
        if (richVideoPlayerParams.f4963b.containsKey("GraphQLStoryProps")) {
            Object obj = richVideoPlayerParams.f4963b.get("GraphQLStoryProps");
            Preconditions.a(obj instanceof FeedProps);
            Preconditions.a(((FeedProps) obj).a instanceof GraphQLStory);
            return StoryProps.i((FeedProps) obj);
        }
        Object obj2;
        if (richVideoPlayerParams.f4963b.containsKey("MultiShareGraphQLSubStoryPropsKey") && richVideoPlayerParams.f4963b.containsKey("MultiShareGraphQLSubStoryIndexKey")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        obj = richVideoPlayerParams.f4963b.get("MultiShareGraphQLSubStoryPropsKey");
        Object obj3 = richVideoPlayerParams.f4963b.get("MultiShareGraphQLSubStoryIndexKey");
        Preconditions.a(obj instanceof FeedProps);
        Preconditions.a(((FeedProps) obj).a instanceof GraphQLStory);
        Preconditions.a(obj3 instanceof Integer);
        FeedProps feedProps = (FeedProps) obj;
        return feedProps.a((Flattenable) StoryAttachmentHelper.o((GraphQLStory) feedProps.a).x().get(((Integer) obj3).intValue()));
    }

    @Nullable
    private GraphQLStoryAttachment m14951c(RichVideoPlayerParams richVideoPlayerParams) {
        FeedProps b = m14950b(richVideoPlayerParams);
        return b != null ? (GraphQLStoryAttachment) b.a : null;
    }

    protected final void mo378c() {
        super.mo378c();
    }

    private void setupCallToActionEndscreen(@Nullable FeedProps<GraphQLStoryAttachment> feedProps) {
        if (feedProps != null) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
            this.f14141o.setOnClickListener(getCallToActionEndscreenReplayClickListener());
            GraphQLStoryActionLink a = LeadGenUtil.a(graphQLStoryAttachment);
            GraphQLStoryActionLink a2 = ActionLinkHelper.a(graphQLStoryAttachment, -508788748);
            String b;
            if (a != null) {
                if (a.X() != null) {
                    b = a.X().b();
                } else {
                    b = null;
                }
                if (Strings.isNullOrEmpty(b)) {
                    this.f14144r.setImageResource(2130841778);
                } else {
                    this.f14144r.a(Uri.parse(b), f14135m);
                }
                this.f14142p.setOnClickListener(this.f14138d.a(feedProps, getContext(), null));
                this.f14145s.setText(a.aB());
                this.f14146t.setText(CallToActionUtil.a(getContext(), a.R()));
            } else if (a2 != null) {
                b = a2.X() != null ? a2.X().b() : null;
                if (Strings.isNullOrEmpty(b)) {
                    this.f14144r.a(null, f14135m);
                } else {
                    this.f14144r.a(Uri.parse(b), f14135m);
                }
                this.f14142p.setOnClickListener(this.f14137c.a(feedProps, a2));
                this.f14145s.setText(a2.aB());
                this.f14146t.setText(CallToActionUtil.a(getContext(), a2.R()));
            } else {
                m14954o();
            }
        }
    }

    public static void m14948a(CallToActionEndscreenBasePlugin callToActionEndscreenBasePlugin, State state) {
        if (state.isPlayingState() || (callToActionEndscreenBasePlugin.f14147u == State.PAUSED && state == State.SEEKING)) {
            callToActionEndscreenBasePlugin.f14149w = false;
            callToActionEndscreenBasePlugin.m14953m();
        } else if (state == State.PLAYBACK_COMPLETE && callToActionEndscreenBasePlugin.mo377a(callToActionEndscreenBasePlugin.f14151a)) {
            callToActionEndscreenBasePlugin.m14952l();
            callToActionEndscreenBasePlugin.f14143q.setText(2131232757);
            callToActionEndscreenBasePlugin.f14136b = EndscreenType.ENDSCREEN;
        } else if (callToActionEndscreenBasePlugin.mo1011f() && state == State.PAUSED && callToActionEndscreenBasePlugin.f14147u != State.SEEKING && callToActionEndscreenBasePlugin.mo377a(callToActionEndscreenBasePlugin.f14151a) && callToActionEndscreenBasePlugin.f14148v) {
            callToActionEndscreenBasePlugin.f14136b = EndscreenType.PAUSESCREEN;
            callToActionEndscreenBasePlugin.m14952l();
            callToActionEndscreenBasePlugin.f14143q.setText(2131232758);
        }
        callToActionEndscreenBasePlugin.f14147u = state;
    }

    private void m14952l() {
        if (!(this.f14136b == EndscreenType.PAUSESCREEN && this.f14149w)) {
            this.f14095g.m14878a(new RVPChromeBehaviorChangeEvent(ChromeBehavior.ALWAYS_HIDDEN));
        }
        this.f14095g.m14878a(new RVPPlayIconStateEvent(RVPPlayIconStateEvent.State.HIDE));
        this.f14095g.m14878a(new RVPLoadingSpinnerStateEvent(RVPLoadingSpinnerStateEvent.State.HIDE));
        if (m14963d()) {
            this.f14140n.setVisibility(0);
            this.f14141o.setVisibility(0);
            this.f14142p.setVisibility(0);
            this.f14140n.bringToFront();
        }
    }

    private void m14953m() {
        this.f14095g.m14878a(new RVPChromeBehaviorChangeEvent(ChromeBehavior.AUTO));
        this.f14095g.m14878a(new RVPPlayIconStateEvent(RVPPlayIconStateEvent.State.DEFAULT));
        this.f14095g.m14878a(new RVPLoadingSpinnerStateEvent(RVPLoadingSpinnerStateEvent.State.DEFAULT));
        m14954o();
    }

    private void m14954o() {
        if (this.f14153c) {
            this.f14140n.setVisibility(8);
            this.f14141o.setVisibility(8);
            this.f14142p.setVisibility(8);
        }
    }

    public final void m14960k() {
        if (this.f14150x != null && this.f14150x.f4836e != null && this.f14150x.f4833b != null && this.f14096h != null) {
            this.f14139l.a(this.f14150x.f4836e, this.f14096h.f5120q.value, this.f14150x.f4833b, this.f14150x.f4837f);
        }
    }
}
