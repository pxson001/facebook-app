package com.facebook.video.server;

import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.Range;
import com.google.common.base.Preconditions;
import java.io.OutputStream;

/* compiled from: page_access_token */
public class ChunkedRangeWriter implements RangeWriter {
    private final RangeWriter f5503a;
    private final long f5504b;

    public ChunkedRangeWriter(RangeWriter rangeWriter, long j) {
        Preconditions.checkArgument(j > 0);
        this.f5503a = (RangeWriter) Preconditions.checkNotNull(rangeWriter);
        this.f5504b = j;
    }

    public final long mo525a(Range range, OutputStream outputStream) {
        long j = range.a;
        while (j < range.b) {
            j += this.f5503a.mo525a(new Range(j, Math.min(this.f5504b + j, range.b)), outputStream);
        }
        return range.a();
    }

    public final FileMetadata mo526a() {
        return this.f5503a.mo526a();
    }
}
