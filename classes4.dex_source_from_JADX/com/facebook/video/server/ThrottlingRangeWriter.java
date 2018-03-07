package com.facebook.video.server;

import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.Range;
import java.io.InterruptedIOException;
import java.io.OutputStream;

/* compiled from: package_removed_for_fbns/ */
public class ThrottlingRangeWriter implements RangeWriter {
    private static final String f5528a = ThrottlingRangeWriter.class.getName();
    private final RangeWriter f5529b;
    private final VideoServerRequestIdentifier f5530c;
    private final ThrottlingPolicy f5531d;
    private final int f5532e = 20;

    public ThrottlingRangeWriter(RangeWriter rangeWriter, VideoServerRequestIdentifier videoServerRequestIdentifier, ThrottlingPolicy throttlingPolicy) {
        this.f5529b = rangeWriter;
        this.f5530c = videoServerRequestIdentifier;
        this.f5531d = throttlingPolicy;
    }

    private static Range m5959a(Range range, long j) {
        if (range.a() > j) {
            return new Range(range.a, range.a + j);
        }
        return range;
    }

    public final long mo525a(Range range, OutputStream outputStream) {
        Object obj = null;
        while (true) {
            long a = this.f5531d.mo529a(this.f5530c, range.a);
            if (a == -2) {
                a = range.a();
            } else if (a == -1) {
                Integer.valueOf(hashCode());
                throw new ThrottlingStopException("Throttling policy asks to stop");
            }
            if (a > 0) {
                Range a2 = m5959a(range, a);
                Integer.valueOf(hashCode());
                return this.f5529b.mo525a(a2, outputStream);
            }
            if (obj == null) {
                Integer.valueOf(hashCode());
                obj = 1;
            }
            try {
                Thread.sleep(20);
            } catch (Throwable e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("Throttling interrupted!");
                interruptedIOException.initCause(e);
                throw interruptedIOException;
            }
        }
    }

    public final FileMetadata mo526a() {
        return this.f5529b.mo526a();
    }
}
