package com.facebook.livephotos.player;

import android.content.Context;
import android.os.Handler;
import com.facebook.livephotos.exoplayer.SampleSource;

/* compiled from: onTouchStartCapture */
class PostrollTrackRenderer extends UnknownDurationTrackRenderer {
    public PostrollTrackRenderer(Context context, SampleSource sampleSource, Handler handler, VideoCompositionRenderer videoCompositionRenderer) {
        super(context, sampleSource, handler, videoCompositionRenderer);
    }

    protected final void mo376a(long j, long j2, boolean z) {
        super.mo376a(((long) (0.5f * ((float) mo446x()))) + j, j2, z);
    }
}
