package com.facebook.messaging.sharedimage;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.messaging.photos.service.MediaMessageItem;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.InlineVideoView;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: query_string_save_state_key */
public class VideoMessageView extends CustomRelativeLayout {
    public static final CallerContext f4026c = CallerContext.a(VideoMessageView.class, "video_cover");
    @Inject
    public AnalyticsTagger f4027a;
    @Inject
    public ZeroDialogController f4028b;
    public FragmentManager f4029d;
    public FbDraweeView f4030e;
    public MediaMessageItem f4031f;
    public InlineVideoView f4032g;
    public ImageView f4033h;
    public ProgressBar f4034i;
    public boolean f4035j;

    /* compiled from: query_string_save_state_key */
    public class C06041 implements Listener {
        final /* synthetic */ VideoMessageView f4023a;

        public C06041(VideoMessageView videoMessageView) {
            this.f4023a = videoMessageView;
        }

        public final void m3736a(Object obj) {
            VideoMessageView videoMessageView = this.f4023a;
            MediaResource e = this.f4023a.f4031f.e();
            VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
            videoDataSourceBuilder.a = e.c;
            videoDataSourceBuilder = videoDataSourceBuilder;
            videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
            videoMessageView.f4032g.setVideoData(new VideoPlayerParamsBuilder().a(videoDataSourceBuilder.i()).m());
            videoMessageView.f4032g.f();
            this.f4023a.f4035j = true;
            this.f4023a.m3739b();
        }

        public final void m3735a() {
        }
    }

    /* compiled from: query_string_save_state_key */
    /* synthetic */ class C06052 {
        static final /* synthetic */ int[] f4024a = new int[PlayerState.values().length];

        static {
            try {
                f4024a[PlayerState.STATE_PREPARING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4024a[PlayerState.STATE_PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4024a[PlayerState.STATE_PLAYING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4024a[PlayerState.STATE_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4024a[PlayerState.STATE_PLAYBACK_COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: query_string_save_state_key */
    public class VideoPlayerListener extends AbstractVideoPlayerListener {
        final /* synthetic */ VideoMessageView f4025a;

        public VideoPlayerListener(VideoMessageView videoMessageView) {
            this.f4025a = videoMessageView;
        }

        public final void m3737a(PlayerState playerState) {
            switch (C06052.f4024a[playerState.ordinal()]) {
                case 1:
                    this.f4025a.f4034i.setVisibility(0);
                    this.f4025a.f4033h.setVisibility(4);
                    return;
                case 2:
                    this.f4025a.f4034i.setVisibility(4);
                    this.f4025a.f4033h.setVisibility(0);
                    return;
                case 3:
                    this.f4025a.f4033h.setVisibility(4);
                    this.f4025a.f4030e.setVisibility(4);
                    this.f4025a.f4032g.setVisibility(0);
                    return;
                case 4:
                    this.f4025a.f4033h.setVisibility(0);
                    return;
                case 5:
                    this.f4025a.f4032g.setVisibility(4);
                    this.f4025a.f4030e.setVisibility(0);
                    this.f4025a.f4033h.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public static void m3738a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VideoMessageView videoMessageView = (VideoMessageView) obj;
        AnalyticsTagger a = AnalyticsTagger.a(fbInjector);
        ZeroDialogController zeroDialogController = (ZeroDialogController) FbZeroDialogController.b(fbInjector);
        videoMessageView.f4027a = a;
        videoMessageView.f4028b = zeroDialogController;
    }

    public VideoMessageView(Context context) {
        super(context);
        Class cls = VideoMessageView.class;
        m3738a(this, getContext());
        setContentView(2130905921);
        this.f4032g = (InlineVideoView) a(2131565270);
        this.f4032g.s = new VideoPlayerListener(this);
        this.f4030e = (FbDraweeView) a(2131565269);
        this.f4033h = (ImageView) a(2131561882);
        this.f4033h.setEnabled(false);
        this.f4033h.setClickable(false);
        this.f4034i = (ProgressBar) a(2131562398);
        AnalyticsTagger.a(this, f4026c);
    }

    public final void m3739b() {
        this.f4032g.b(EventTriggerType.BY_USER);
    }

    public final void m3740c() {
        this.f4032g.d(EventTriggerType.BY_USER);
    }
}
