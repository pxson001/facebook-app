package com.facebook.feed.ui.fullscreenvideoplayer.castactivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.SecurePendingIntent;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullScreenCastPlugin;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.chromecast.VideoCastManager;
import com.facebook.video.chromecast.callbacks.VideoCastConsumerAdapter;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.player.plugins.ClickToPlayAnimationPlugin;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TimelineRenderLowResHeader */
public class FullScreenCastActivity extends FbFragmentActivity {
    @Inject
    public VideoCastManager f21968p;
    private RichVideoPlayer f21969q;
    public String f21970r;
    private FullScreenConsumer f21971s;

    /* compiled from: TimelineRenderLowResHeader */
    class C18641 implements RichVideoPlayerCallbackListener {
        final /* synthetic */ FullScreenCastActivity f21966a;

        C18641(FullScreenCastActivity fullScreenCastActivity) {
            this.f21966a = fullScreenCastActivity;
        }

        public final void m24560a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
            this.f21966a.finish();
        }

        public final void m24558a() {
        }

        public final void m24559a(RVPErrorEvent rVPErrorEvent) {
        }
    }

    /* compiled from: TimelineRenderLowResHeader */
    class FullScreenConsumer extends VideoCastConsumerAdapter {
        final /* synthetic */ FullScreenCastActivity f21967a;

        public FullScreenConsumer(FullScreenCastActivity fullScreenCastActivity) {
            this.f21967a = fullScreenCastActivity;
        }

        public final void mo1537c() {
            this.f21967a.finish();
        }

        public final void mo1538f() {
            this.f21967a.finish();
        }

        public final void mo1536a() {
            if (this.f21967a.f21970r == null || !this.f21967a.f21968p.a(this.f21967a.f21970r)) {
                this.f21967a.finish();
            }
        }
    }

    private static <T extends Context> void m24576a(Class<T> cls, T t) {
        m24577a((Object) t, (Context) t);
    }

    public static void m24577a(Object obj, Context context) {
        ((FullScreenCastActivity) obj).f21968p = VideoCastManager.a(FbInjector.get(context));
    }

    private void m24575a(VideoCastManager videoCastManager) {
        this.f21968p = videoCastManager;
    }

    public static PendingIntent m24573a(Context context, VideoPlayerParams videoPlayerParams, Uri uri, double d) {
        Intent intent = new Intent(context, FullScreenCastActivity.class);
        intent.putExtra("videoParams", videoPlayerParams);
        intent.putExtra("videoURI", uri);
        intent.putExtra("videoAspectRation", d);
        intent.setFlags(268468224);
        return SecurePendingIntent.a(context, 0, intent, 134217728);
    }

    protected final void m24583b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = FullScreenCastActivity.class;
        m24577a((Object) this, (Context) this);
        this.f21969q = new RichVideoPlayer(this);
        this.f21969q.setPlayerType(PlayerType.FULL_SCREEN_PLAYER);
        this.f21969q.v = new C18641(this);
        m24582l();
        setContentView(this.f21969q);
        m24579i();
        m24581k();
        m24580j();
        this.f21971s = new FullScreenConsumer(this);
        this.f21968p.a(this.f21971s);
    }

    private void m24579i() {
        if (VERSION.SDK_INT >= 16) {
            this.f21969q.setBackground(new ColorDrawable(-16777216));
        } else {
            this.f21969q.setBackgroundDrawable(new ColorDrawable(-16777216));
        }
    }

    private void m24580j() {
        VideoPlayerParams videoPlayerParams = (VideoPlayerParams) getIntent().getParcelableExtra("videoParams");
        Uri uri = (Uri) getIntent().getParcelableExtra("videoURI");
        if (!m24578a(videoPlayerParams)) {
            finish();
        }
        this.f21970r = videoPlayerParams.b;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        ImmutableMap b = new Builder().b("VideoAspectRatioKey", Double.valueOf(getIntent().getDoubleExtra("videoAspectRation", ((double) displayMetrics.widthPixels) / ((double) displayMetrics.heightPixels)))).b("CoverImageParamsKey", ImageRequest.a(uri)).b();
        RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
        builder.a = videoPlayerParams;
        this.f21969q.a(builder.a(b).b());
    }

    private static boolean m24578a(VideoPlayerParams videoPlayerParams) {
        return (videoPlayerParams == null || videoPlayerParams.b == null || videoPlayerParams.b.isEmpty()) ? false : true;
    }

    private void m24581k() {
        this.f21969q.a(new ClickToPlayAnimationPlugin(this));
        this.f21969q.a(new FullScreenCastPlugin(this));
        this.f21969q.setInnerResource(2131560814);
    }

    private void m24582l() {
        getWindow().setFlags(1024, 1024);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1506492950);
        super.onPause();
        this.f21968p.b(this.f21971s);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1362462840, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 847155351);
        super.onResume();
        this.f21968p.a(this.f21971s);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1509192933, a);
    }

    public void finish() {
        super.finish();
        this.f21968p.b(this.f21971s);
    }
}
