package com.facebook.feedplugins.saved.rows.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.FbVideoView;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.facebook.video.player.plugins.SoundWavePlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/* compiled from: bundle_collection_top */
public class SavedCollectionInlineVideoView extends FbVideoView {
    private String f9339i;

    public SavedCollectionInlineVideoView(Context context) {
        this(context, null);
    }

    public SavedCollectionInlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SavedCollectionInlineVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9339i = null;
        setShouldCropToFit(true);
        setPlayerOrigin(PlayerOrigin.SAVED_REMINDER);
        setPlayerType(PlayerType.INLINE_PLAYER);
    }

    protected final ImmutableList<? extends RichVideoPlayerPlugin> m9950a(Context context) {
        return ImmutableList.of(new CoverImagePlugin(context), new SinglePlayIconPlugin(context), new LoadingSpinnerPlugin(context), new SoundWavePlugin(context));
    }

    public final void m9951a(VideoPlayerParams videoPlayerParams, ImmutableMap<String, ? extends Object> immutableMap) {
        if (!(this.f9339i == null || videoPlayerParams.b.equals(this.f9339i))) {
            g();
            this.f9339i = null;
        }
        this.f9339i = videoPlayerParams.b;
        Builder builder = new Builder();
        builder.a = videoPlayerParams;
        a(builder.a(immutableMap).b());
    }
}
