package com.facebook.feedplugins.multishare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.videos.ui.HasChannelFeedLauncherInfo;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feed.ui.inlinevideoplayer.plugins.InlineCallToActionEndscreenPlugin;
import com.facebook.video.player.FbVideoView;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.plugins.FullCoverImagePlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: delta */
public class MultiShareInlineVideoView extends FbVideoView implements HasChannelFeedLauncherInfo {
    private InlineCallToActionEndscreenPlugin f14000i;
    private SinglePlayIconPlugin f14001j;

    public MultiShareInlineVideoView(Context context) {
        this(context, null);
    }

    public MultiShareInlineVideoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiShareInlineVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final ImmutableList<? extends RichVideoPlayerPlugin> mo1005a(Context context) {
        this.f14001j = new SinglePlayIconPlugin(context);
        this.f14000i = new InlineCallToActionEndscreenPlugin(context);
        return ImmutableList.of(new FullCoverImagePlugin(context), this.f14001j, this.f14000i);
    }

    public final void m14795a(OnClickListener onClickListener, View view) {
        this.f14000i.f14134o = new 1(this, onClickListener, view);
    }

    public int getSeekPosition() {
        return getCurrentPositionMs();
    }

    public VideoTransitionNode getTransitionNode() {
        return null;
    }

    @Nullable
    public VideoStoryPersistentState getVideoStoryPersistentState() {
        return null;
    }
}
