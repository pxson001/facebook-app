package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.view.widget.media.MediaView;
import com.facebook.richdocument.view.widget.media.MediaViewDelegate;
import com.facebook.richdocument.view.widget.media.plugins.DefaultAspectRatioVideoPlugin;
import com.facebook.richdocument.view.widget.video.VideoPlayingAudioPolicy;
import com.facebook.richdocument.view.widget.video.VideoPlayingAudioPolicy.AudioPolicyResult;
import com.facebook.richdocument.view.widget.video.VideoPlayingAudioPolicy.AudioPolicyType;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.FbVideoView;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: page_like_tapped */
public class RichDocumentVideoPlayer extends FbVideoView implements MediaView {
    private MediaViewDelegate f7360i;
    private boolean f7361j;
    public VideoCoverImageListener f7362k;
    public boolean f7363l;
    public VideoPlayingAudioPolicy f7364m;
    public boolean f7365n;

    /* compiled from: page_like_tapped */
    public interface VideoCoverImageListener {
        void mo398F();
    }

    /* compiled from: page_like_tapped */
    /* synthetic */ class C08411 {
        static final /* synthetic */ int[] f7357a = new int[State.values().length];

        static {
            try {
                f7357a[State.ATTEMPT_TO_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7357a[State.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7357a[State.PLAYBACK_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: page_like_tapped */
    public class WrappedPlayOnClickListener implements OnClickListener {
        final /* synthetic */ RichDocumentVideoPlayer f7358a;
        private final OnClickListener f7359b;

        public WrappedPlayOnClickListener(RichDocumentVideoPlayer richDocumentVideoPlayer, OnClickListener onClickListener) {
            this.f7358a = richDocumentVideoPlayer;
            this.f7359b = onClickListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1692131138);
            if (this.f7359b != null) {
                this.f7359b.onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1318371799, a);
        }
    }

    public RichDocumentVideoPlayer(Context context) {
        this(context, null);
    }

    public RichDocumentVideoPlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RichDocumentVideoPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7363l = false;
        this.f7365n = false;
        m7615t();
    }

    public void m7615t() {
        this.f7360i = new MediaViewDelegate(this);
    }

    public final void m7616u() {
        this.f7361j = false;
    }

    public final void m7612a(int i, int i2) {
        this.f7360i.f7604b = ((float) i) / ((float) i2);
    }

    protected ImmutableList<? extends RichVideoPlayerPlugin> m7611a(Context context) {
        Builder builder = ImmutableList.builder();
        i();
        builder.c(new RichDocumentCoverImagePlugin(getContext(), this));
        builder.c(new DefaultAspectRatioVideoPlugin(context));
        return builder.b();
    }

    protected PlayerType getDefaultPlayerType() {
        return PlayerType.RICH_DOCUMENT;
    }

    protected PlayerOrigin getDefaultPlayerOrigin() {
        return PlayerOrigin.INSTANT_ARTICLES;
    }

    protected void onMeasure(int i, int i2) {
        Rect a = this.f7360i.m7853a();
        super.onMeasure(MeasureSpec.makeMeasureSpec(a.width(), 1073741824), MeasureSpec.makeMeasureSpec(a.height(), 1073741824));
    }

    public float getMediaAspectRatio() {
        return this.f7360i.f7604b;
    }

    public View getView() {
        return this;
    }

    public final boolean ja_() {
        return this.f7361j;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        if (this.f7365n) {
            super.setOnClickListener(onClickListener);
        } else {
            super.setOnClickListener(new WrappedPlayOnClickListener(this, onClickListener));
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void setCoverImageListener(VideoCoverImageListener videoCoverImageListener) {
        this.f7362k = videoCoverImageListener;
    }

    public void setCoverImageLoaded(boolean z) {
        this.f7361j = z;
        if (this.f7362k != null && z) {
            this.f7362k.mo398F();
        }
    }

    public void setVideoControlsEnabled(boolean z) {
        this.f7365n = z;
    }

    public final boolean m7617v() {
        return this.f7363l;
    }

    public void setAudioPolicy(VideoPlayingAudioPolicy videoPlayingAudioPolicy) {
        this.f7364m = videoPlayingAudioPolicy;
    }

    public VideoPlayingAudioPolicy getAudioPolicy() {
        return this.f7364m;
    }

    public final void m7614a(boolean z, EventTriggerType eventTriggerType) {
        super.a(z, eventTriggerType);
        this.f7363l = z;
    }

    public final boolean m7618w() {
        if (getPlayerState() == null) {
            return false;
        }
        switch (C08411.f7357a[getPlayerState().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public final void m7613a(AudioPolicyResult audioPolicyResult) {
        if (audioPolicyResult != null) {
            Object obj;
            if (audioPolicyResult.f7754a == AudioPolicyType.MUTE) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a(true, EventTriggerType.BY_AUTOPLAY);
                return;
            }
            if (audioPolicyResult.f7754a == AudioPolicyType.UNMUTE) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a(false, EventTriggerType.BY_AUTOPLAY);
                return;
            }
            if ((audioPolicyResult.f7754a == AudioPolicyType.USE_EXISTING_MUTE_STATE ? 1 : null) != null) {
                a(this.f7363l, EventTriggerType.BY_AUTOPLAY);
            }
        }
    }
}
