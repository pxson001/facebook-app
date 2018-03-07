package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.google.common.base.Preconditions;

/* compiled from: default_comment_ordering */
public abstract class StubbableRichVideoPlayerPlugin extends RichVideoPlayerPlugin {
    protected RichVideoPlayerParams f14151a;
    private final ViewStub f14152b = ((ViewStub) m14861a(2131560480));
    public boolean f14153c;

    protected abstract boolean mo377a(RichVideoPlayerParams richVideoPlayerParams);

    protected abstract int getLayoutToInflate();

    protected abstract void setupPlugin(RichVideoPlayerParams richVideoPlayerParams);

    protected abstract void setupViews(View view);

    public StubbableRichVideoPlayerPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(getStubLayout());
        this.f14152b.setLayoutResource(getLayoutToInflate());
        this.f14153c = false;
    }

    public final void mo393a(PlaybackController playbackController, RichVideoPlayer richVideoPlayer, RichVideoPlayerParams richVideoPlayerParams) {
        this.f14151a = richVideoPlayerParams;
        super.mo393a(playbackController, richVideoPlayer, richVideoPlayerParams);
    }

    protected int getStubLayout() {
        return 2130907290;
    }

    public final boolean m14963d() {
        if (!this.f14153c && mo377a(this.f14151a)) {
            View inflate = this.f14152b.inflate();
            this.f14099k.add(inflate);
            Preconditions.checkNotNull(inflate);
            setupViews(inflate);
            setupPlugin(this.f14151a);
            this.f14153c = true;
        }
        return this.f14153c;
    }
}
