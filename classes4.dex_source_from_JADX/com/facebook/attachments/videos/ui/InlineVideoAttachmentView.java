package com.facebook.attachments.videos.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.video.player.InlineVideoPlayer2;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;

@Deprecated
/* compiled from: password_accounts */
public class InlineVideoAttachmentView extends CustomRelativeLayout implements CanShowLiveCommentDialogFragment, HasChannelFeedLauncherInfo, RecyclerViewKeepAttached {
    public InlineVideoPlayer2 f5331a;
    public InlineVideoPlayerDelegate f5332b;
    public float f5333c;
    private boolean f5334d;

    public InlineVideoAttachmentView(Context context) {
        this(context, null, 0);
    }

    public InlineVideoAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InlineVideoAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5333c = 0.0f;
        setContentView(2130904920);
        this.f5331a = (InlineVideoPlayer2) m14861a(2131563180);
        this.f5332b = new InlineVideoPlayerDelegate(this.f5331a);
    }

    public final boolean gK_() {
        return true;
    }

    public void setVideoAspectRatio(float f) {
        this.f5333c = f;
    }

    public float getVideoAspectRatio() {
        return this.f5333c;
    }

    public void setShowLiveCommentDialogFragment(boolean z) {
        this.f5334d = z;
    }

    public boolean getAndClearShowLiveCommentDialogFragment() {
        boolean z = this.f5334d;
        this.f5334d = false;
        return z;
    }

    public InlineVideoPlayer2 getInlineVideoPlayer() {
        return this.f5331a;
    }

    public int getLastStartPosition() {
        return this.f5331a.getLastStartPosition();
    }

    public int getSeekPosition() {
        return this.f5331a.getCurrentPosition();
    }

    public VideoTransitionNode getTransitionNode() {
        return this.f5331a;
    }

    public InlineVideoPlayerDelegate getDelegate() {
        return this.f5332b;
    }

    public VideoStoryPersistentState getVideoStoryPersistentState() {
        return null;
    }
}
