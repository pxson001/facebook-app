package com.facebook.imagepipeline.image;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page/%s/services_list */
public class EncodedImage implements Closeable {
    @Nullable
    private final CloseableReference<PooledByteBuffer> f10561a;
    @Nullable
    private final Supplier<FileInputStream> f10562b;
    public ImageFormat f10563c;
    public int f10564d;
    public int f10565e;
    public int f10566f;
    public int f10567g;
    private int f10568h;

    public EncodedImage(CloseableReference<PooledByteBuffer> closeableReference) {
        this.f10563c = ImageFormat.UNKNOWN;
        this.f10564d = -1;
        this.f10565e = -1;
        this.f10566f = -1;
        this.f10567g = 1;
        this.f10568h = -1;
        Preconditions.a(CloseableReference.m15679a((CloseableReference) closeableReference));
        this.f10561a = closeableReference.m15683b();
        this.f10562b = null;
    }

    private EncodedImage(Supplier<FileInputStream> supplier) {
        this.f10563c = ImageFormat.UNKNOWN;
        this.f10564d = -1;
        this.f10565e = -1;
        this.f10566f = -1;
        this.f10567g = 1;
        this.f10568h = -1;
        Preconditions.a(supplier);
        this.f10561a = null;
        this.f10562b = supplier;
    }

    public EncodedImage(Supplier<FileInputStream> supplier, int i) {
        this((Supplier) supplier);
        this.f10568h = i;
    }

    public static EncodedImage m15702a(EncodedImage encodedImage) {
        return encodedImage != null ? encodedImage.m15706j() : null;
    }

    private EncodedImage m15706j() {
        EncodedImage encodedImage;
        if (this.f10562b != null) {
            encodedImage = new EncodedImage(this.f10562b, this.f10568h);
        } else {
            CloseableReference b = CloseableReference.m15680b(this.f10561a);
            if (b == null) {
                encodedImage = null;
            } else {
                try {
                    encodedImage = new EncodedImage(b);
                } catch (Throwable th) {
                    CloseableReference.m15681c(b);
                }
            }
            CloseableReference.m15681c(b);
        }
        if (encodedImage != null) {
            encodedImage.m15713b(this);
        }
        return encodedImage;
    }

    public void close() {
        CloseableReference.m15681c(this.f10561a);
    }

    private synchronized boolean m15707k() {
        boolean z;
        z = CloseableReference.m15679a(this.f10561a) || this.f10562b != null;
        return z;
    }

    public final CloseableReference<PooledByteBuffer> m15708a() {
        return CloseableReference.m15680b(this.f10561a);
    }

    public final InputStream m15711b() {
        if (this.f10562b != null) {
            return (InputStream) this.f10562b.mo2058a();
        }
        CloseableReference b = CloseableReference.m15680b(this.f10561a);
        if (b == null) {
            return null;
        }
        try {
            InputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) b.m15682a());
            return pooledByteBufferInputStream;
        } finally {
            CloseableReference.m15681c(b);
        }
    }

    public final void m15710a(ImageFormat imageFormat) {
        this.f10563c = imageFormat;
    }

    public final void m15709a(int i) {
        this.f10566f = i;
    }

    public final void m15712b(int i) {
        this.f10565e = i;
    }

    public final void m15714c(int i) {
        this.f10564d = i;
    }

    public final void m15713b(EncodedImage encodedImage) {
        this.f10563c = encodedImage.f10563c;
        this.f10565e = encodedImage.f10565e;
        this.f10566f = encodedImage.f10566f;
        this.f10564d = encodedImage.f10564d;
        this.f10567g = encodedImage.f10567g;
        this.f10568h = encodedImage.m15718h();
    }

    public final int m15715d() {
        return this.f10564d;
    }

    public final int m15717g() {
        return this.f10567g;
    }

    public final boolean m15716e(int i) {
        if (this.f10563c != ImageFormat.JPEG) {
            return true;
        }
        if (this.f10562b != null) {
            return true;
        }
        Preconditions.a(this.f10561a);
        NativePooledByteBuffer nativePooledByteBuffer = (NativePooledByteBuffer) this.f10561a.m15682a();
        return nativePooledByteBuffer.m15688a(i + -2) == (byte) -1 && nativePooledByteBuffer.m15688a(i - 1) == (byte) -39;
    }

    public final int m15718h() {
        if (this.f10561a == null || this.f10561a.m15682a() == null) {
            return this.f10568h;
        }
        return ((NativePooledByteBuffer) this.f10561a.m15682a()).m15689a();
    }

    public final void m15719i() {
        ImageFormat b = ImageFormatChecker.m24998b(m15711b());
        this.f10563c = b;
        if (!ImageFormat.isWebpFormat(b)) {
            Pair a = BitmapUtil.m25069a(m15711b());
            if (a != null) {
                this.f10565e = ((Integer) a.first).intValue();
                this.f10566f = ((Integer) a.second).intValue();
                if (b != ImageFormat.JPEG) {
                    this.f10564d = 0;
                } else if (this.f10564d == -1) {
                    this.f10564d = TiffUtil.m25078a(JfifUtil.m25070a(m15711b()));
                }
            }
        }
    }

    public static boolean m15703c(EncodedImage encodedImage) {
        return encodedImage.f10564d >= 0 && encodedImage.f10565e >= 0 && encodedImage.f10566f >= 0;
    }

    public static void m15704d(@Nullable EncodedImage encodedImage) {
        if (encodedImage != null) {
            encodedImage.close();
        }
    }

    public static boolean m15705e(@Nullable EncodedImage encodedImage) {
        return encodedImage != null && encodedImage.m15707k();
    }
}
