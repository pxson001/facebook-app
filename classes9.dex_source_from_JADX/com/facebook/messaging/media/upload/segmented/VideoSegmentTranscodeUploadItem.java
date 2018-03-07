package com.facebook.messaging.media.upload.segmented;

import com.facebook.media.transcode.SegmentedMediaTranscodeResult;
import com.facebook.media.transcode.SegmentedTranscodeItemInfo;
import com.google.common.base.Preconditions;

/* compiled from: last_sync_timestamp */
public class VideoSegmentTranscodeUploadItem {
    public SegmentedTranscodeItemInfo f12100a;
    public SegmentedMediaTranscodeResult f12101b;
    public boolean f12102c;
    public long f12103d;

    public VideoSegmentTranscodeUploadItem(SegmentedTranscodeItemInfo segmentedTranscodeItemInfo) {
        Preconditions.checkArgument(segmentedTranscodeItemInfo != null);
        this.f12100a = segmentedTranscodeItemInfo;
    }

    public final SegmentedTranscodeItemInfo m12622a() {
        return this.f12100a;
    }

    public final void m12624a(SegmentedMediaTranscodeResult segmentedMediaTranscodeResult) {
        this.f12101b = segmentedMediaTranscodeResult;
    }

    public final SegmentedMediaTranscodeResult m12626b() {
        return this.f12101b;
    }

    public final void m12625a(boolean z) {
        this.f12102c = z;
    }

    public final boolean m12627c() {
        return this.f12102c;
    }

    public final void m12623a(long j) {
        this.f12103d = j;
    }

    public final long m12628d() {
        return this.f12103d;
    }
}
