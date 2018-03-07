package com.facebook.livephotos.player;

import android.content.Context;
import android.os.Handler;
import com.facebook.livephotos.exoplayer.SampleSource;

/* compiled from: onTouchStartCapture */
public class PrerollTrackRenderer extends UnknownDurationTrackRenderer {
    public PrerollTrackRenderer(Context context, SampleSource sampleSource, Handler handler, VideoCompositionRenderer videoCompositionRenderer) {
        super(context, sampleSource, handler, videoCompositionRenderer);
    }

    protected final void mo376a(long j, long j2, boolean z) {
        super.mo376a(j >= 250000 ? j - 250000 : 0, j2, z);
    }
}
