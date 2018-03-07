package com.facebook.media.transcode;

import com.facebook.ipc.media.MediaItem;

/* compiled from: keywords */
public class SegmentedMediaTranscodeResult {
    private final boolean f11841a;
    public final MediaItem f11842b;
    private final SegmentedTranscodeItemInfo f11843c;

    public SegmentedMediaTranscodeResult(boolean z, MediaItem mediaItem, SegmentedTranscodeItemInfo segmentedTranscodeItemInfo) {
        this.f11841a = z;
        this.f11842b = mediaItem;
        this.f11843c = segmentedTranscodeItemInfo;
    }

    public final boolean m18815a() {
        return this.f11841a;
    }

    public final MediaItem m18816b() {
        return this.f11842b;
    }
}
