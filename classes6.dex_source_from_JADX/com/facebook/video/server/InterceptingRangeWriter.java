package com.facebook.video.server;

import com.facebook.common.iolite.BoundedInputStream;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.Range;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.io.CountingOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: commerce_merchant_settings */
public class InterceptingRangeWriter implements RangeWriter {
    private static final String f19476a = InterceptingRangeWriter.class.getName();
    private final RangeWriter f19477b;
    private InterceptedReader f19478c;

    public InterceptingRangeWriter(InterceptedReader interceptedReader, RangeWriter rangeWriter) {
        this.f19477b = (RangeWriter) Preconditions.checkNotNull(rangeWriter);
        this.f19478c = interceptedReader;
    }

    public final FileMetadata m28231a() {
        if (this.f19478c == null) {
            return this.f19477b.a();
        }
        return this.f19478c.f19475b.f19472a;
    }

    public final long m28230a(Range range, OutputStream outputStream) {
        CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
        while (true) {
            try {
                long a = countingOutputStream.a() + range.a;
                if (a >= range.b) {
                    break;
                } else if (this.f19478c == null) {
                    Range range2 = new Range(a, range.b);
                    this.f19477b.a(new Range(a, range.b), countingOutputStream);
                } else if (a < this.f19478c.f19474a.a) {
                    this.f19477b.a(new Range(a, Math.min(range.b, this.f19478c.f19474a.a)), countingOutputStream);
                } else {
                    boolean a2 = this.f19478c.f19474a.a(a);
                    Boolean.valueOf(a2);
                    if (a2) {
                        InputStream boundedInputStream;
                        InputStream b = this.f19478c.f19475b.m28229b();
                        ByteStreams.b(b, a - this.f19478c.f19474a.a);
                        if (range.b < this.f19478c.f19474a.b) {
                            boundedInputStream = new BoundedInputStream(b, range.b - a, false);
                        } else {
                            boundedInputStream = b;
                        }
                        ByteStreams.a(boundedInputStream, countingOutputStream);
                    }
                    this.f19478c.f19475b.m28229b().close();
                    this.f19478c = null;
                }
            } finally {
                if (this.f19478c != null) {
                    this.f19478c.f19475b.m28229b().close();
                    this.f19478c = null;
                }
            }
        }
        long a3 = countingOutputStream.a();
        return a3;
    }
}
