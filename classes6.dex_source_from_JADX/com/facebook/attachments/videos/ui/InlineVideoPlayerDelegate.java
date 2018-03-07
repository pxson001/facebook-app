package com.facebook.attachments.videos.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.BaseInlineVideoPlayer;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

/* compiled from: profile_intro_card_photos_set */
public class InlineVideoPlayerDelegate implements VideoPlayerAttachment {
    public BaseInlineVideoPlayer f7363a;
    private FbDraweeView f7364b = this.f7363a.getCoverImage();
    private VideoPlayerParams f7365c;

    public InlineVideoPlayerDelegate(BaseInlineVideoPlayer baseInlineVideoPlayer) {
        this.f7363a = baseInlineVideoPlayer;
    }

    public final void m10468a(PlayerOrigin playerOrigin, boolean z, VideoPlayerParams videoPlayerParams, ImmutableMap<String, ? extends Object> immutableMap) {
        TracerDetour.a("InlineVideoPlayerDelegate.configurePlayer", 14064926);
        try {
            this.f7363a.setIsVideoCompleted(false);
            this.f7363a.setPauseMediaPlayerOnVideoPause(false);
            this.f7363a.setPlayerOrigin(playerOrigin);
            TracerDetour.a("BaseInlineVideoPlayer.setVideoData", -1840963351);
            try {
                int i = this.f7363a;
                i.mo1454a(videoPlayerParams, (ImmutableMap) immutableMap);
                TracerDetour.a(i);
                m10464a(z);
                this.f7365c = videoPlayerParams;
            } finally {
                TracerDetour.a(1931857249);
            }
        } finally {
            TracerDetour.a(-249944770);
        }
    }

    private void m10464a(boolean z) {
        this.f7363a.mo1456a(true, EventTriggerType.BY_PLAYER);
        this.f7363a.setAlwaysPlayVideoUnmuted(z);
    }

    public void setCoverController(DraweeController draweeController) {
        if (this.f7364b != null) {
            this.f7364b.setController(draweeController);
        }
    }

    public DraweeController getCoverController() {
        return this.f7364b != null ? this.f7364b.getController() : null;
    }

    public void setBackgroundResource(int i) {
        this.f7363a.setBackgroundResource(i);
    }

    public final void m10466a(int i, int i2) {
        LayoutParams layoutParams = this.f7363a.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f7363a.setLayoutParams(layoutParams);
        if (this.f7364b != null) {
            layoutParams = this.f7364b.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.f7364b.setLayoutParams(layoutParams);
        }
    }

    public final void m10471b(int i, int i2) {
        this.f7363a.mo1451a(i, i2);
    }

    public final int m10465a(int i) {
        return this.f7363a.mo1458b() ? this.f7363a.getLastStartPosition() : i;
    }

    public final void m10469a(VideoFeedStoryInfo videoFeedStoryInfo) {
        if (videoFeedStoryInfo != null) {
            this.f7363a.setOriginalPlayReason(videoFeedStoryInfo.b);
            this.f7363a.setChannelEligibility(videoFeedStoryInfo.c);
        }
    }

    public final void m10467a(@Nullable final OnClickListener onClickListener, final View view) {
        if (onClickListener == null) {
            this.f7363a.setOnClickPlayerListener(onClickListener);
        } else {
            this.f7363a.setOnClickPlayerListener(new OnClickListener(this) {
                final /* synthetic */ InlineVideoPlayerDelegate f7362c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1163228175);
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1286086652, a);
                }
            });
        }
    }

    public final void m10470b() {
        m10467a(null, null);
    }
}
