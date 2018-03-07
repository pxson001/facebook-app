package com.facebook.orca.threadview;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.debug.log.BLog;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo.Builder;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.player.FullScreenParams;
import com.facebook.video.player.FullScreenVideoPlayer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;

/* compiled from: me/commerce_cart_items */
public class ThreadViewVideoActivity extends FbFragmentActivity implements AnalyticsActivity {
    private static final Class<?> f8054p = ThreadViewVideoActivity.class;
    private FullScreenVideoPlayer f8055q;

    /* compiled from: me/commerce_cart_items */
    class C12111 implements OnCompletionListener {
        final /* synthetic */ ThreadViewVideoActivity f8053a;

        C12111(ThreadViewVideoActivity threadViewVideoActivity) {
            this.f8053a = threadViewVideoActivity;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f8053a.finish();
        }
    }

    private static <T extends Context> void m7951a(Class<T> cls, T t) {
        FbInjector.get(t);
    }

    private static void m7952a(Object obj, Context context) {
        FbInjector.get(context);
    }

    protected final void m7953a(Bundle bundle) {
        super.a(bundle);
        Class cls = ThreadViewVideoActivity.class;
        FbInjector.get(this);
    }

    public final void m7954b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130905894);
        this.f8055q = (FullScreenVideoPlayer) a(2131565235);
        if (getIntent() != null && getIntent().hasExtra("video_attachment") && getIntent().hasExtra("player_origin") && getIntent().hasExtra("thread_key")) {
            VideoAttachmentData videoAttachmentData = (VideoAttachmentData) getIntent().getParcelableExtra("video_attachment");
            PlayerOrigin valueOf = PlayerOrigin.valueOf(getIntent().getStringExtra("player_origin"));
            this.f8055q.au = new C12111(this);
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            if (BLog.b(2)) {
                String str = videoAttachmentData.i;
            }
            ImmutableList copyOf = ImmutableList.copyOf(videoAttachmentData.f);
            int i = videoAttachmentData.d;
            VideoAnalyticsRequiredInfo a = new Builder(videoAttachmentData.i).a();
            VideoFeedStoryInfo.Builder builder = new VideoFeedStoryInfo.Builder(arrayNode);
            builder.b = EventTriggerType.BY_USER;
            VideoFeedStoryInfo.Builder builder2 = builder;
            builder2.d = false;
            FullScreenParams fullScreenParams = new FullScreenParams(copyOf, i, a, builder2.a(), ImageRequest.a(videoAttachmentData.g));
            fullScreenParams.e = (float) videoAttachmentData.c;
            fullScreenParams.a(valueOf);
            fullScreenParams.g = videoAttachmentData.k;
            fullScreenParams.h = videoAttachmentData.l;
            this.f8055q.a(fullScreenParams);
            return;
        }
        throw new IllegalArgumentException("ThreadViewVideoActivity must have a video attachment, thread key and player origin set");
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 2069377389);
        super.onStart();
        this.f8055q.o();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1523877271, a);
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 975064480);
        super.onResume();
        this.f8055q.q();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1739632252, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1060748147);
        super.onPause();
        this.f8055q.r();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1019028005, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -330563144);
        super.onStop();
        this.f8055q.p();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1411857899, a);
    }

    protected final void m7955i() {
        finish();
    }

    public final String am_() {
        return "thread_video_view";
    }
}
