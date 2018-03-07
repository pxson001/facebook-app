package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* compiled from: TOPIC_SPORTS_RECREATION */
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    private static Method f13746b;
    private final boolean f13747c;

    public GingerbreadPurgeableDecoder(boolean z) {
        this.f13747c = z;
    }

    protected final Bitmap m23098a(CloseableReference<PooledByteBuffer> closeableReference, Options options) {
        return m23093a(closeableReference, ((NativePooledByteBuffer) closeableReference.a()).a(), null, options);
    }

    protected final Bitmap m23097a(CloseableReference<PooledByteBuffer> closeableReference, int i, Options options) {
        return m23093a(closeableReference, i, DalvikPurgeableDecoder.a(closeableReference, i) ? null : DalvikPurgeableDecoder.a, options);
    }

    private static MemoryFile m23094a(CloseableReference<PooledByteBuffer> closeableReference, int i, @Nullable byte[] bArr) {
        InputStream limitedInputStream;
        Closeable outputStream;
        Throwable th;
        InputStream inputStream = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) closeableReference.a());
            try {
                limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream, i);
                try {
                    outputStream = memoryFile.getOutputStream();
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                    inputStream = limitedInputStream;
                    limitedInputStream = pooledByteBufferInputStream;
                    CloseableReference.c(closeableReference);
                    Closeables.a(limitedInputStream);
                    Closeables.a(inputStream);
                    Closeables.a(outputStream, true);
                    throw th;
                }
                try {
                    ByteStreams.a(limitedInputStream, outputStream);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    CloseableReference.c(closeableReference);
                    Closeables.a(pooledByteBufferInputStream);
                    Closeables.a(limitedInputStream);
                    Closeables.a(outputStream, true);
                    return memoryFile;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = limitedInputStream;
                    limitedInputStream = pooledByteBufferInputStream;
                    CloseableReference.c(closeableReference);
                    Closeables.a(limitedInputStream);
                    Closeables.a(inputStream);
                    Closeables.a(outputStream, true);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream = null;
                limitedInputStream = pooledByteBufferInputStream;
                CloseableReference.c(closeableReference);
                Closeables.a(limitedInputStream);
                Closeables.a(inputStream);
                Closeables.a(outputStream, true);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
            limitedInputStream = null;
            CloseableReference.c(closeableReference);
            Closeables.a(limitedInputStream);
            Closeables.a(inputStream);
            Closeables.a(outputStream, true);
            throw th;
        }
    }

    private synchronized Method m23096a() {
        if (f13746b == null) {
            try {
                f13746b = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Throwable e) {
                throw Throwables.b(e);
            }
        }
        return f13746b;
    }

    private FileDescriptor m23095a(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) m23096a().invoke(memoryFile, new Object[0]);
        } catch (Throwable e) {
            throw Throwables.b(e);
        }
    }

    private Bitmap m23093a(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr, Options options) {
        MemoryFile memoryFile = null;
        try {
            Object a;
            memoryFile = m23094a((CloseableReference) closeableReference, i, bArr);
            FileDescriptor a2 = m23095a(memoryFile);
            if (this.f13747c) {
                a = WebpSupportStatus.d.a(a2, null, options);
            } else {
                a = BitmapFactory.decodeFileDescriptor(a2, null, options);
            }
            Bitmap bitmap = (Bitmap) Preconditions.a(a, "BitmapFactory returned null");
            if (memoryFile != null) {
                memoryFile.close();
            }
            return bitmap;
        } catch (Throwable e) {
            throw Throwables.b(e);
        } catch (Throwable th) {
            if (memoryFile != null) {
                memoryFile.close();
            }
        }
    }
}
