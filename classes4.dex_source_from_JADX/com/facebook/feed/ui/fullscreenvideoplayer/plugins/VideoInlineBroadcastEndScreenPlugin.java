package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.StubbableRichVideoPlayerPlugin;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.video.videohome.logging.VideoHomeStoryLoggingData.Builder;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: pre_reg_push */
public class VideoInlineBroadcastEndScreenPlugin extends StubbableRichVideoPlayerPlugin {
    private static final CallerContext f4335l = CallerContext.a(VideoInlineBroadcastEndScreenPlugin.class, "video_cover");
    @Inject
    public FbDraweeControllerBuilder f4336b;
    @Inject
    public VideoHomeLoggingUtils f4337c;
    @Inject
    public VideoHomeSessionManager f4338d;
    private FbDraweeView f4339m;
    private View f4340n;
    private View f4341o;
    private View f4342p;
    private TextView f4343q;
    private View f4344r;
    private TextView f4345s;
    private View f4346t;
    private boolean f4347u;
    private FeedProps<GraphQLStory> f4348v;

    /* compiled from: pre_reg_push */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VideoInlineBroadcastEndScreenPlugin f4360a;

        public PlayerStateChangedEventSubscriber(VideoInlineBroadcastEndScreenPlugin videoInlineBroadcastEndScreenPlugin) {
            this.f4360a = videoInlineBroadcastEndScreenPlugin;
        }

        public final void m4893b(FbEvent fbEvent) {
            if (((RVPPlayerStateChangedEvent) fbEvent).f14079b == State.PLAYBACK_COMPLETE) {
                this.f4360a.m4875f();
                VideoInlineBroadcastEndScreenPlugin.m4868a(this.f4360a, false, null, -1);
                VideoInlineBroadcastEndScreenPlugin.m4871l(this.f4360a);
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m4892a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m4869a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        VideoInlineBroadcastEndScreenPlugin videoInlineBroadcastEndScreenPlugin = (VideoInlineBroadcastEndScreenPlugin) obj;
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(injectorLike);
        VideoHomeLoggingUtils a = VideoHomeLoggingUtils.a(injectorLike);
        VideoHomeSessionManager a2 = VideoHomeSessionManager.m4877a(injectorLike);
        videoInlineBroadcastEndScreenPlugin.f4336b = b;
        videoInlineBroadcastEndScreenPlugin.f4337c = a;
        videoInlineBroadcastEndScreenPlugin.f4338d = a2;
    }

    @DoNotStrip
    public VideoInlineBroadcastEndScreenPlugin(Context context) {
        this(context, null);
    }

    private VideoInlineBroadcastEndScreenPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VideoInlineBroadcastEndScreenPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = VideoInlineBroadcastEndScreenPlugin.class;
        m4869a((Object) this, getContext());
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
    }

    private void m4870k() {
        if (this.f14153c) {
            this.f4340n.setVisibility(8);
        }
    }

    protected final boolean mo380j() {
        return true;
    }

    protected final boolean mo377a(RichVideoPlayerParams richVideoPlayerParams) {
        return true;
    }

    protected int getLayoutToInflate() {
        return 2130907682;
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
        ImageRequest imageRequest;
        int i;
        int i2 = 8;
        GraphQLMedia a = RichVideoPlayerParamsUtil.m5428a(richVideoPlayerParams);
        if (a == null || a.S() == null) {
            imageRequest = null;
        } else {
            imageRequest = ImageRequest.a(a.S().b());
        }
        ImageRequest imageRequest2 = imageRequest;
        if (imageRequest2 != null) {
            this.f4339m.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f4336b.a(f4335l).c(imageRequest2)).b(this.f4339m.getController())).s());
            this.f4339m.setVisibility(0);
        } else {
            this.f4339m.setVisibility(8);
        }
        boolean equals = Boolean.TRUE.equals(richVideoPlayerParams.f4963b.get("IsSmallVideoKey"));
        View view = this.f4341o;
        if (equals) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        View view2 = this.f4342p;
        if (equals) {
            i2 = 0;
        }
        view2.setVisibility(i2);
        if (this.f14096h != null && this.f14096h.f5120q == PlayerType.CHANNEL_PLAYER) {
            this.f4341o.setPadding(this.f4341o.getPaddingLeft(), this.f4341o.getPaddingTop(), this.f4341o.getPaddingRight(), 0);
        }
    }

    protected void setupViews(View view) {
        this.f4340n = view.findViewById(2131568295);
        this.f4339m = (FbDraweeView) view.findViewById(2131560814);
        this.f4341o = view.findViewById(2131560065);
        this.f4342p = view.findViewById(2131568342);
        this.f4343q = (TextView) view.findViewById(2131568340);
        this.f4344r = view.findViewById(2131568341);
        this.f4345s = (TextView) view.findViewById(2131568343);
        this.f4346t = view.findViewById(2131568344);
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.mo376a(richVideoPlayerParams, z);
        m4870k();
        if (richVideoPlayerParams.f4963b != null && richVideoPlayerParams.f4963b.containsKey("GraphQLStoryProps") && (richVideoPlayerParams.f4963b.get("GraphQLStoryProps") instanceof FeedProps)) {
            GraphQLMedia a = RichVideoPlayerParamsUtil.m5428a(richVideoPlayerParams);
            this.f4348v = (FeedProps) richVideoPlayerParams.f4963b.get("GraphQLStoryProps");
            if (a == null || !VideoUtils.m5398a(a.aq(), a.br())) {
                this.f4347u = true;
                return;
            }
            String str;
            Object obj;
            int i;
            if (richVideoPlayerParams.f4963b == null || !richVideoPlayerParams.f4963b.containsKey("UnitComponentTokenKey")) {
                str = null;
            } else {
                obj = richVideoPlayerParams.f4963b.get("UnitComponentTokenKey");
                Preconditions.checkArgument(obj instanceof String);
                str = (String) obj;
            }
            String str2 = str;
            this.f4347u = a.br() != GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            m4875f();
            if (richVideoPlayerParams.f4963b == null || !richVideoPlayerParams.f4963b.containsKey("UnitPositionKey")) {
                i = -1;
            } else {
                obj = richVideoPlayerParams.f4963b.get("UnitPositionKey");
                Preconditions.checkArgument(obj instanceof Integer);
                i = ((Integer) obj).intValue();
            }
            m4868a(this, true, str2, i);
            m4871l(this);
        }
    }

    protected final void mo378c() {
        m4870k();
        super.mo378c();
    }

    public final void m4875f() {
        boolean z = false;
        if (m14963d()) {
            this.f4340n.setVisibility(0);
            View view = this.f4340n;
            if (!this.f4347u) {
                z = true;
            }
            view.setClickable(z);
        }
    }

    public static void m4871l(VideoInlineBroadcastEndScreenPlugin videoInlineBroadcastEndScreenPlugin) {
        int i = videoInlineBroadcastEndScreenPlugin.f4347u ? 2131232802 : 2131232803;
        int i2 = videoInlineBroadcastEndScreenPlugin.f4347u ? 0 : 8;
        videoInlineBroadcastEndScreenPlugin.f4343q.setText(i);
        videoInlineBroadcastEndScreenPlugin.f4345s.setText(i);
        videoInlineBroadcastEndScreenPlugin.f4344r.setVisibility(i2);
        videoInlineBroadcastEndScreenPlugin.f4346t.setVisibility(i2);
    }

    public static void m4868a(VideoInlineBroadcastEndScreenPlugin videoInlineBroadcastEndScreenPlugin, boolean z, String str, int i) {
        if (videoInlineBroadcastEndScreenPlugin.f4338d.m4886g() && videoInlineBroadcastEndScreenPlugin.f4348v.a != null) {
            VideoHomeLoggingUtils videoHomeLoggingUtils = videoInlineBroadcastEndScreenPlugin.f4337c;
            Builder builder = new Builder();
            builder.a = ((GraphQLStory) videoInlineBroadcastEndScreenPlugin.f4348v.a).c();
            Builder builder2 = builder;
            builder2.b = TrackableFeedProps.a(videoInlineBroadcastEndScreenPlugin.f4348v);
            builder2 = builder2;
            builder2.d = i;
            builder2 = builder2;
            builder2.c = str;
            videoHomeLoggingUtils.a(builder2.a(), z);
        }
    }
}
