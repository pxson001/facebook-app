package com.facebook.video.server;

import com.facebook.common.iolite.BoundedInputStream;
import com.facebook.common.iolite.Streams;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.PartialFileStorage;
import com.facebook.ui.media.cache.PartialFileStorage.PartialFile;
import com.facebook.ui.media.cache.Range;
import com.google.common.io.ByteStreams;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: package_names */
public class CachingThroughRangeWriter implements RangeWriter {
    private static final Class<?> f5535a = CachingThroughRangeWriter.class;
    private final PartialFileStorage<VideoCacheKey> f5536b;
    private final VideoCacheKey f5537c;
    private final RangeWriter f5538d;
    private final long f5539e;
    private PartialFile<VideoCacheKey> f5540f;
    private FileMetadata f5541g;

    public CachingThroughRangeWriter(PartialFileStorage<VideoCacheKey> partialFileStorage, VideoCacheKey videoCacheKey, RangeWriter rangeWriter, long j) {
        this.f5536b = partialFileStorage;
        this.f5537c = videoCacheKey;
        this.f5538d = rangeWriter;
        this.f5539e = j;
    }

    public final long mo525a(Range range, OutputStream outputStream) {
        Long.valueOf(range.a);
        Long.valueOf(range.b);
        if (m5966b() == null) {
            return this.f5538d.mo525a(range, outputStream);
        }
        long j = range.a;
        Iterable iterable = null;
        while (range.a(j)) {
            long j2;
            Range range2 = new Range(j, range.b);
            if (iterable == null) {
                iterable = range2.a(m5966b().f());
            } else {
                iterable = range2.a(iterable);
            }
            if (iterable.isEmpty()) {
                j2 = range2.b;
                j += m5964a(outputStream, range2);
            } else {
                Range range3 = (Range) iterable.get(0);
                if (range3.a(j)) {
                    j2 = range3.b;
                    j += m5965b(outputStream, new Range(j, range3.b));
                } else {
                    j2 = range3.a;
                    j += m5964a(outputStream, new Range(j, j2));
                }
            }
            if (j2 != j) {
                iterable = null;
            }
        }
        return j - range.a;
    }

    public final FileMetadata mo526a() {
        m5966b();
        return this.f5541g;
    }

    private long m5964a(OutputStream outputStream, Range range) {
        Long.valueOf(range.a);
        PartialFile b = m5966b();
        long j = range.a;
        InputStream b2 = b.b(j);
        try {
            j = ByteStreams.m11949a(new BoundedInputStream(b2, range.a(), true), outputStream);
            return j;
        } finally {
            b2.close();
        }
    }

    private long m5965b(OutputStream outputStream, Range range) {
        OutputStream a = m5966b().a(range.a);
        OutputStream teedOutputStream = new TeedOutputStream(Streams.m5987a(outputStream), a);
        long j = range.b;
        if (this.f5539e > 0 && range.a() <= this.f5539e) {
            j = Math.min(range.a + this.f5539e, mo526a().f5544a);
        }
        Range range2 = new Range(range.a, j);
        Long.valueOf(range2.a);
        Long.valueOf(range2.b);
        Long.valueOf(range2.a());
        Long.valueOf(range2.a() - range.a());
        try {
            j = this.f5538d.mo525a(range2, teedOutputStream);
            return j;
        } finally {
            teedOutputStream.close();
        }
    }

    private PartialFile m5966b() {
        if (this.f5540f == null) {
            this.f5540f = this.f5536b.b(this.f5537c);
            if (this.f5540f == null) {
                Object obj;
                int i;
                if (this.f5541g == null) {
                    this.f5541g = this.f5538d.mo526a();
                }
                FileMetadata fileMetadata = this.f5541g;
                String str = "Cache-Control";
                if (fileMetadata.f5546c == null) {
                    obj = null;
                } else {
                    obj = fileMetadata.f5546c.get(str);
                }
                str = (String) obj;
                if (str == null) {
                    i = 1;
                } else {
                    String[] split = str.replaceAll("\\s", "").split(",");
                    String[] strArr = new String[]{"no-cache", "no-store", "max-age=0"};
                    loop0:
                    for (int i2 = 0; i2 < 3; i2++) {
                        String str2 = strArr[i2];
                        for (String equalsIgnoreCase : split) {
                            if (equalsIgnoreCase.equalsIgnoreCase(str2)) {
                                i = 0;
                                break loop0;
                            }
                        }
                    }
                    i = 1;
                }
                if (i != 0) {
                    this.f5540f = this.f5536b.a(this.f5537c, this.f5541g);
                }
            } else {
                this.f5541g = this.f5540f.a();
            }
        }
        return this.f5540f;
    }
}
