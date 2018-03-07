package com.facebook.video.server;

import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.Range;

/* compiled from: page_likers */
public class VideoServerRequestIdentifier {
    public final int f5475a;
    public final long f5476b;
    public Range f5477c;
    private FileMetadata f5478d;

    public VideoServerRequestIdentifier(int i, long j) {
        this.f5475a = i;
        this.f5476b = j;
    }

    public final Range m5930a() {
        return this.f5477c;
    }

    public final void m5932a(Range range) {
        this.f5477c = range;
    }

    public final long m5933b() {
        return this.f5478d.f5544a;
    }

    public final void m5931a(FileMetadata fileMetadata) {
        this.f5478d = fileMetadata;
    }
}
