package com.facebook.video.server;

import com.facebook.debug.log.BLog;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.PartialFileStorage;
import com.facebook.ui.media.cache.PartialFileStorage.PartialFile;
import com.facebook.video.server.FileResource.SimpleReader;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: commerce_destination */
public class ReadableCacheWriter {
    public static final String f19502a = ReadableCacheWriter.class.getName();
    private final PartialFileStorage<VideoCacheKey> f19503b;
    private final VideoCacheKey f19504c;
    private final long f19505d;
    private final GenericByteArrayPool f19506e;
    private PartialFile<VideoCacheKey> f19507f;
    private boolean f19508g;
    private OutputStream f19509h;
    private InputStream f19510i;
    private OutputStream f19511j;
    private InputStream f19512k;
    private ReadingInputStream f19513l;
    private SimpleReader f19514m;
    private int f19515n;
    public long f19516o;
    public long f19517p;
    private long f19518q;
    private boolean f19519r;
    private boolean f19520s;

    /* compiled from: commerce_destination */
    class ReadingInputStream extends InputStream {
        final /* synthetic */ ReadableCacheWriter f19500a;

        public int read(byte[] bArr, int i, int i2) {
            String str = ReadableCacheWriter.f19502a;
            Long.valueOf(this.f19500a.f19517p);
            Long.valueOf(this.f19500a.f19516o);
            Integer.valueOf(i2);
            return ReadableCacheWriter.m28245b(this.f19500a, bArr, i, Math.min(i2, 32768));
        }

        public ReadingInputStream(ReadableCacheWriter readableCacheWriter) {
            this.f19500a = readableCacheWriter;
        }

        public int read() {
            throw new UnsupportedOperationException();
        }

        public void close() {
            ReadableCacheWriter.m28247e(this.f19500a);
        }
    }

    /* compiled from: commerce_destination */
    class WritingOutputStream extends OutputStream {
        final /* synthetic */ ReadableCacheWriter f19501a;

        public WritingOutputStream(ReadableCacheWriter readableCacheWriter) {
            this.f19501a = readableCacheWriter;
        }

        public void write(byte[] bArr, int i, int i2) {
            while (i2 > 0) {
                int min = Math.min(i2, 32768);
                ReadableCacheWriter.m28243a(this.f19501a, bArr, i, min);
                i += min;
                i2 -= min;
            }
        }

        public void write(int i) {
            throw new UnsupportedOperationException();
        }

        public void close() {
            ReadableCacheWriter.m28248f(this.f19501a);
        }
    }

    public ReadableCacheWriter(PartialFileStorage<VideoCacheKey> partialFileStorage, VideoCacheKey videoCacheKey, PartialFile<VideoCacheKey> partialFile, long j, @Nullable ByteArrayPool byteArrayPool) {
        this.f19503b = partialFileStorage;
        this.f19504c = videoCacheKey;
        this.f19507f = partialFile;
        this.f19505d = j;
        this.f19506e = byteArrayPool;
    }

    public final OutputStream m28250a(FileMetadata fileMetadata) {
        try {
            if (this.f19507f == null) {
                this.f19507f = this.f19503b.a(this.f19504c, fileMetadata);
            }
            this.f19511j = this.f19507f.a(this.f19505d);
            if (this.f19506e != null) {
                MemoryPipe memoryPipe = new MemoryPipe((byte[]) this.f19506e.a(204800), this.f19506e);
                this.f19510i = memoryPipe.f19483b;
                this.f19509h = memoryPipe.f19482a;
            } else {
                this.f19510i = new PipedInputStream(204800);
                this.f19509h = new PipedOutputStream((PipedInputStream) this.f19510i);
            }
            this.f19518q = this.f19505d;
            this.f19516o = this.f19505d;
            this.f19517p = -1;
            this.f19515n = 0;
            this.f19513l = new ReadingInputStream(this);
            this.f19514m = new SimpleReader(fileMetadata, this.f19513l);
            return new WritingOutputStream(this);
        } catch (IOException e) {
            m28244a(this.f19511j);
            m28244a(this.f19510i);
            m28244a(this.f19509h);
            throw e;
        }
    }

    public static void m28243a(ReadableCacheWriter readableCacheWriter, byte[] bArr, int i, int i2) {
        boolean z = true;
        if (i2 > 32768) {
            z = false;
        }
        Preconditions.checkArgument(z);
        synchronized (readableCacheWriter) {
            if (readableCacheWriter.f19508g) {
                throw new AsyncWriter$CancelledException("Fetch cancelled", null);
            }
            if (((int) (readableCacheWriter.f19518q - readableCacheWriter.f19516o)) + i2 > 204800) {
                if (readableCacheWriter.f19517p < 0) {
                    if (readableCacheWriter.f19519r) {
                        readableCacheWriter.f19520s = true;
                    } else {
                        readableCacheWriter.m28246d();
                    }
                }
                if (readableCacheWriter.f19517p >= 0) {
                    readableCacheWriter.f19510i.skip((long) i2);
                    readableCacheWriter.f19516o += (long) i2;
                }
            }
        }
        readableCacheWriter.f19509h.write(bArr, i, i2);
        readableCacheWriter.f19511j.write(bArr, i, i2);
        synchronized (readableCacheWriter) {
            readableCacheWriter.f19518q += (long) i2;
        }
    }

    @GuardedBy("this")
    private void m28246d() {
        Preconditions.checkArgument(this.f19517p < 0);
        this.f19517p = this.f19516o;
        this.f19512k = this.f19507f.b(this.f19517p);
        this.f19515n++;
    }

    public static int m28245b(ReadableCacheWriter readableCacheWriter, byte[] bArr, int i, int i2) {
        InputStream inputStream;
        boolean z = true;
        if (i2 > 32768) {
            z = false;
        }
        Preconditions.checkArgument(z);
        synchronized (readableCacheWriter) {
            if (readableCacheWriter.f19517p < 0) {
                readableCacheWriter.f19519r = true;
                inputStream = readableCacheWriter.f19510i;
            } else {
                inputStream = readableCacheWriter.f19512k;
                i2 = Math.min(i2, (int) (readableCacheWriter.f19518q - readableCacheWriter.f19517p));
            }
        }
        int read = inputStream.read(bArr, i, i2);
        synchronized (readableCacheWriter) {
            readableCacheWriter.f19519r = false;
            if (readableCacheWriter.f19520s) {
                readableCacheWriter.f19520s = false;
                readableCacheWriter.m28246d();
            } else if (readableCacheWriter.f19517p >= 0) {
                readableCacheWriter.f19517p += (long) read;
                long j = readableCacheWriter.f19517p - readableCacheWriter.f19516o;
                if (readableCacheWriter.f19518q - readableCacheWriter.f19517p < 32768 && j >= 0) {
                    m28244a(readableCacheWriter.f19512k);
                    readableCacheWriter.f19512k = null;
                    readableCacheWriter.f19517p = -1;
                    readableCacheWriter.f19510i.skip(j);
                    readableCacheWriter.f19516o += j;
                    readableCacheWriter.f19515n++;
                }
            } else {
                readableCacheWriter.f19516o += (long) read;
            }
        }
        return read;
    }

    public static synchronized void m28247e(ReadableCacheWriter readableCacheWriter) {
        synchronized (readableCacheWriter) {
            readableCacheWriter.f19508g = true;
            m28244a(readableCacheWriter.f19510i);
            m28244a(readableCacheWriter.f19512k);
            readableCacheWriter.f19510i = null;
            readableCacheWriter.f19512k = null;
        }
    }

    public static synchronized void m28248f(ReadableCacheWriter readableCacheWriter) {
        synchronized (readableCacheWriter) {
            m28244a(readableCacheWriter.f19509h);
            m28244a(readableCacheWriter.f19511j);
        }
    }

    private static void m28244a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                BLog.a(f19502a, e, "Could not close %s", new Object[]{closeable});
            }
        }
    }

    public final SimpleReader m28249a() {
        return this.f19514m;
    }

    public final PartialFile<VideoCacheKey> m28251b() {
        return this.f19507f;
    }
}
