package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.widget.TextView;
import com.facebook.attachments.videos.ui.InlineVideoPlayerDelegate;
import com.facebook.gif.AnimatedImagePlayButtonView;
import com.facebook.gif.AnimatedImagePlayButtonView.State;
import com.facebook.video.player.InlineVideoPlayer;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: User-Agent */
public class TranscodedAnimatedImageShareAttachmentView extends CustomLinearLayout implements RecyclerViewKeepAttached {
    private final AnimatedImagePlayButtonView f21104a;
    public InlineVideoPlayer f21105b;
    public InlineVideoPlayerDelegate f21106c;
    public final TextView f21107d;

    public TranscodedAnimatedImageShareAttachmentView(Context context) {
        this(context, 2130907532);
    }

    private TranscodedAnimatedImageShareAttachmentView(Context context, int i) {
        super(context);
        setContentView(i);
        setOrientation(1);
        this.f21104a = (AnimatedImagePlayButtonView) a(2131568094);
        this.f21107d = (TextView) a(2131563058);
        this.f21105b = (InlineVideoPlayer) a(2131568093);
        this.f21106c = new InlineVideoPlayerDelegate(this.f21105b);
    }

    @VisibleForTesting
    public TextView getBottomTextView() {
        return this.f21107d;
    }

    public void setPlayButtonState(State state) {
        this.f21104a.setState(state);
    }

    public InlineVideoPlayer getInlineVideoPlayer() {
        return this.f21105b;
    }

    public InlineVideoPlayerDelegate getDelegate() {
        return this.f21106c;
    }

    public final boolean gK_() {
        return true;
    }
}
