package com.facebook.friendsharing.souvenirs.verve;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.friendsharing.souvenirs.ui.SouvenirVideoAutoplayController.VideoAutoPlayView;
import com.facebook.greetingcards.vervecontrols.InlineVerveVideoView;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: Q */
public class SouvenirVerveVideoView extends InlineVerveVideoView implements VideoAutoPlayView {
    @Nullable
    private RichVideoPlayerParams f24238i;

    public SouvenirVerveVideoView(Context context) {
        this(context, null);
    }

    private SouvenirVerveVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SouvenirVerveVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final ImmutableList<? extends RichVideoPlayerPlugin> mo1601a(Context context) {
        return ImmutableList.of(new CoverImagePlugin(context), new SinglePlayIconPlugin(context), new LoadingSpinnerPlugin(context));
    }

    public final void m26474a(RichVideoPlayerParams richVideoPlayerParams) {
        Preconditions.checkNotNull(richVideoPlayerParams);
        if (richVideoPlayerParams.b != null) {
            this.f24238i = richVideoPlayerParams;
        }
        super.a(richVideoPlayerParams);
    }

    public final void mo1602a() {
        super.a((RichVideoPlayerParams) Preconditions.checkNotNull(this.f24238i));
    }

    public void setVideoListener(RichVideoPlayerCallbackListener richVideoPlayerCallbackListener) {
        this.v = richVideoPlayerCallbackListener;
    }
}
