package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.auth.annotations.ViewerContextUserId;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.facecastdisplay.LiveEventsLogger;
import com.facebook.facecastdisplay.LiveScribeMutator;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData.Surface;
import com.facebook.graphql.calls.VideoChannelUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsHelper;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: portrait */
public class VideoLiveScribeButtonPlugin extends BaseInlineButtonPlugin {
    public static final PrefKey f4417w = ((PrefKey) SharedPrefKeys.h.a("video_broadcast_is_live_scribe_tool_tip_shown"));
    @Nullable
    public String f4418A;
    @Nullable
    public String f4419B;
    public String f4420C;
    public Handler f4421D;
    public Tooltip f4422E;
    public long f4423F;
    @Inject
    public LiveScribeMutator f4424n;
    @Inject
    GlyphColorizer f4425o;
    @Inject
    public FbSharedPreferences f4426p;
    @Inject
    public Clock f4427q;
    @Inject
    @ViewerContextUserId
    String f4428r;
    @Inject
    LiveEventsLogger f4429s;
    @Inject
    public QeAccessor f4430t;
    @Inject
    public VideoChannelMutationsHelper f4431u;
    @Inject
    Product f4432v;
    public final Runnable f4433x;
    private UserTileView f4434y;
    public boolean f4435z;

    /* compiled from: portrait */
    class C02051 implements Runnable {
        final /* synthetic */ VideoLiveScribeButtonPlugin f4442a;

        C02051(VideoLiveScribeButtonPlugin videoLiveScribeButtonPlugin) {
            this.f4442a = videoLiveScribeButtonPlugin;
        }

        public void run() {
            BaseInlineButtonPlugin baseInlineButtonPlugin = this.f4442a;
            if (!baseInlineButtonPlugin.f4426p.a(VideoLiveScribeButtonPlugin.f4417w, false) && !baseInlineButtonPlugin.f4435z && baseInlineButtonPlugin.f4420C != null) {
                baseInlineButtonPlugin.f4422E = new Tooltip(baseInlineButtonPlugin.getContext(), 2);
                baseInlineButtonPlugin.f4422E.m6259b(baseInlineButtonPlugin.getResources().getString(2131232833, new Object[]{baseInlineButtonPlugin.f4420C}));
                baseInlineButtonPlugin.f4422E.m6287c(baseInlineButtonPlugin.f4436b);
                baseInlineButtonPlugin.f4422E.mo540a(Position.BELOW);
                baseInlineButtonPlugin.f4422E.f5789H = new C02543(baseInlineButtonPlugin);
                baseInlineButtonPlugin.f4423F = baseInlineButtonPlugin.f4427q.a();
                baseInlineButtonPlugin.f4422E.mo541d();
            }
        }
    }

    /* compiled from: portrait */
    class StateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VideoLiveScribeButtonPlugin f4452a;

        public final void m4952b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (!this.f4452a.f4426p.a(VideoLiveScribeButtonPlugin.f4417w, false) && !this.f4452a.f4435z && this.f4452a.f14153c) {
                HandlerDetour.a(this.f4452a.f4421D, this.f4452a.f4433x);
                if (rVPPlayerStateChangedEvent.f14079b == State.PLAYING) {
                    HandlerDetour.b(this.f4452a.f4421D, this.f4452a.f4433x, 3000, 1964560897);
                }
            }
        }

        public StateChangedEventSubscriber(VideoLiveScribeButtonPlugin videoLiveScribeButtonPlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
            this.f4452a = videoLiveScribeButtonPlugin;
            super(richVideoPlayerPlugin);
        }

        public final Class<RVPPlayerStateChangedEvent> m4951a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: portrait */
    class C02482 implements OnClickListener {
        final /* synthetic */ VideoLiveScribeButtonPlugin f5759a;

        C02482(VideoLiveScribeButtonPlugin videoLiveScribeButtonPlugin) {
            this.f5759a = videoLiveScribeButtonPlugin;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -526803055);
            VideoLiveScribeButtonPlugin videoLiveScribeButtonPlugin = this.f5759a;
            if (this.f5759a.f4435z) {
                z = false;
            } else {
                z = true;
            }
            videoLiveScribeButtonPlugin.f4435z = z;
            BaseInlineButtonPlugin baseInlineButtonPlugin = this.f5759a;
            boolean z2 = this.f5759a.f4435z;
            baseInlineButtonPlugin.m4943k();
            baseInlineButtonPlugin.m4937a(z2);
            if (!baseInlineButtonPlugin.f4430t.a(ExperimentsForVideoHomeAbTestModule.p, false)) {
                baseInlineButtonPlugin.f4424n.m4946a(baseInlineButtonPlugin.f4418A, baseInlineButtonPlugin.f4419B, z2, "video_overlay");
            } else if (z2) {
                baseInlineButtonPlugin.f4431u.a(baseInlineButtonPlugin.f4419B, Surface.UNKNOWN);
            } else {
                baseInlineButtonPlugin.f4431u.a(baseInlineButtonPlugin.f4419B, VideoChannelUnsubscribeInputData.Surface.UNKNOWN);
            }
            LogUtils.a(-1516995195, a);
        }
    }

    /* compiled from: portrait */
    public class C02543 implements OnDismissListener {
        final /* synthetic */ VideoLiveScribeButtonPlugin f5845a;

        public C02543(VideoLiveScribeButtonPlugin videoLiveScribeButtonPlugin) {
            this.f5845a = videoLiveScribeButtonPlugin;
        }

        public final boolean m6336a(PopoverWindow popoverWindow) {
            if (this.f5845a.f4427q.a() - this.f5845a.f4423F <= 1000) {
                return false;
            }
            this.f5845a.f4426p.edit().putBoolean(VideoLiveScribeButtonPlugin.f4417w, true).commit();
            return true;
        }
    }

    public static void m4932a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoLiveScribeButtonPlugin) obj).m4931a(LiveScribeMutator.m4945b(fbInjector), GlyphColorizer.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), String_ViewerContextUserIdMethodAutoProvider.b(fbInjector), LiveEventsLogger.m4947b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), VideoChannelMutationsHelper.a(fbInjector), ProductMethodAutoProvider.b(fbInjector));
    }

    private void m4931a(LiveScribeMutator liveScribeMutator, GlyphColorizer glyphColorizer, FbSharedPreferences fbSharedPreferences, Clock clock, String str, LiveEventsLogger liveEventsLogger, QeAccessor qeAccessor, VideoChannelMutationsHelper videoChannelMutationsHelper, Product product) {
        this.f4424n = liveScribeMutator;
        this.f4425o = glyphColorizer;
        this.f4426p = fbSharedPreferences;
        this.f4427q = clock;
        this.f4428r = str;
        this.f4429s = liveEventsLogger;
        this.f4430t = qeAccessor;
        this.f4431u = videoChannelMutationsHelper;
        this.f4432v = product;
    }

    public VideoLiveScribeButtonPlugin(Context context) {
        this(context, null);
    }

    private VideoLiveScribeButtonPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VideoLiveScribeButtonPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4433x = new C02051(this);
        Class cls = VideoLiveScribeButtonPlugin.class;
        m4932a((Object) this, getContext());
        this.f4421D = new Handler(Looper.getMainLooper());
        this.f14094f.add(new StateChangedEventSubscriber(this, this));
    }

    protected void setupViews(View view) {
        super.setupViews(view);
        this.f4434y = (UserTileView) view.findViewById(2131563183);
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
        this.f4438d.setImageDrawable(this.f4425o.a(2130839774, -1));
        this.f4437c.setText(2131232684);
    }

    protected final void mo388c(boolean z) {
        int i;
        int i2 = 0;
        UserTileView userTileView = this.f4434y;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        userTileView.setVisibility(i);
        ImageView imageView = this.f4438d;
        if (!z) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }

    protected final int mo387b(boolean z) {
        boolean a = this.f4430t.a(ExperimentsForVideoHomeAbTestModule.p, false);
        int i = a ? 2131235665 : 2131232688;
        int i2 = a ? 2131235666 : 2131232688;
        if (z) {
            return i2;
        }
        return i;
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        GraphQLStory graphQLStory;
        boolean z2 = true;
        FeedProps g = RichVideoPlayerParamsUtil.m5432g(richVideoPlayerParams);
        if (g == null) {
            graphQLStory = null;
        } else {
            graphQLStory = (GraphQLStory) g.a;
            Object obj = 1;
            if (graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).r() == null || !StoryAttachmentHelper.o(graphQLStory).r().aq() || StoryAttachmentHelper.o(graphQLStory).r().al() || StoryAttachmentHelper.o(graphQLStory).r().aF() == null || StoryAttachmentHelper.o(graphQLStory).r().aF().V() == null) {
                obj = null;
            }
            if (obj == null || !StoryAttachmentHelper.o(graphQLStory).r().aY()) {
                graphQLStory = null;
            }
        }
        GraphQLStory graphQLStory2 = graphQLStory;
        if (this.f4432v != Product.FB4A || graphQLStory2 == null || this.f4428r.equals(StoryAttachmentHelper.r(graphQLStory2).H())) {
            this.m = false;
            m14906g();
            return;
        }
        this.m = true;
        if (m14963d()) {
            GraphQLActor b = StoryActorHelper.b(graphQLStory2);
            GraphQLMedia r = StoryAttachmentHelper.o(graphQLStory2).r();
            if (r.aF().V() != GraphQLLiveVideoSubscriptionStatus.ALL) {
                z2 = false;
            }
            if (z) {
                this.f4435z = z2;
                this.f4418A = r.b();
                this.f4419B = r.aF().H();
                this.f4420C = b.aa();
                m4937a(this.f4435z);
                this.f4434y.setParams(UserTileViewParams.m6209a(UserKey.b(b.H())));
                this.f4436b.setVisibility(0);
                this.f4437c.setVisibility(0);
                this.f4436b.setOnClickListener(new C02482(this));
                this.f4429s.m4950a(this.f4418A, this.f4419B, "video_overlay", r.al());
            }
        }
    }

    public final void mo378c() {
        super.mo378c();
        HandlerDetour.a(this.f4421D, this.f4433x);
        if (this.f4422E != null) {
            this.f4422E.mo542l();
        }
    }
}
