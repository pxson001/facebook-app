package com.facebook.livephotos.player;

import com.facebook.livephotos.exoplayer.MediaCodecAudioTrackRenderer;
import com.facebook.livephotos.exoplayer.MediaCodecSelector;
import com.facebook.livephotos.exoplayer.SampleSource;

/* compiled from: onTouchStartCapture */
public class PrerollAudioTrackRenderer extends MediaCodecAudioTrackRenderer implements HasUnknownDuration {
    private boolean f7766c;

    public PrerollAudioTrackRenderer(SampleSource sampleSource) {
        super(sampleSource, MediaCodecSelector.f6800a);
    }

    public final boolean mo380e() {
        return this.f7766c || super.mo380e();
    }

    public final void gH_() {
        this.f7766c = true;
    }

    protected final long mo371o() {
        return -1;
    }

    protected final void mo376a(long j, long j2, boolean z) {
        super.mo376a(j >= 250000 ? j - 250000 : 0, j2, z);
    }
}
