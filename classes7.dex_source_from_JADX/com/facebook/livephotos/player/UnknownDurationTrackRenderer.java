package com.facebook.livephotos.player;

import android.content.Context;
import android.os.Handler;
import com.facebook.livephotos.exoplayer.MediaCodecSelector;
import com.facebook.livephotos.exoplayer.MediaCodecVideoTrackRenderer;
import com.facebook.livephotos.exoplayer.SampleSource;

/* compiled from: onTouchStartCapture */
public class UnknownDurationTrackRenderer extends MediaCodecVideoTrackRenderer implements HasUnknownDuration {
    private boolean f7765c;

    public UnknownDurationTrackRenderer(Context context, SampleSource sampleSource, Handler handler, VideoCompositionRenderer videoCompositionRenderer) {
        super(context, sampleSource, MediaCodecSelector.f6800a, 2, -1, handler, videoCompositionRenderer, 0);
    }

    public final void gH_() {
        this.f7765c = true;
    }

    public final boolean mo380e() {
        return this.f7765c || super.mo380e();
    }

    protected final long mo371o() {
        return -1;
    }

    protected final long mo446x() {
        return super.mo371o();
    }
}
