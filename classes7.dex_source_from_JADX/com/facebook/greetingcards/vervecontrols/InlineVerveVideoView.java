package com.facebook.greetingcards.vervecontrols;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.greetingcards.verve.render.VerveVideoContainer;
import com.facebook.greetingcards.verve.render.VerveVideoContainer.VerveVideoContainerListener;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.FbVideoView;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.facebook.video.player.plugins.SoundWavePlugin;
import com.google.common.collect.ImmutableList;

/* compiled from: QUICK_INVITE */
public class InlineVerveVideoView extends FbVideoView implements VerveVideoContainer {
    public String f24237i;

    public InlineVerveVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setShouldCropToFit(true);
        setPlayerOrigin(PlayerOrigin.VERVE);
        setPlayerType(PlayerType.INLINE_PLAYER);
    }

    protected ImmutableList<? extends RichVideoPlayerPlugin> mo1601a(Context context) {
        return ImmutableList.of(new CoverImagePlugin(context), new SinglePlayIconPlugin(context), new LoadingSpinnerPlugin(context), new SoundWavePlugin(context));
    }

    public final void iE_() {
        a(EventTriggerType.BY_AUTOPLAY);
    }

    public void setVideoListener(VerveVideoContainerListener verveVideoContainerListener) {
        this.v = new 1(this, verveVideoContainerListener);
    }
}
