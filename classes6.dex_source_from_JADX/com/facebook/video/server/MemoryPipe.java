package com.facebook.video.server;

import com.facebook.common.references.ResourceReleaser;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;

/* compiled from: commerce_merchant_deactivate */
public class MemoryPipe {
    private static final ResourceReleaser<byte[]> f19481c = new C14531();
    public final OutputStream f19482a = new C14542(this);
    public final InputStream f19483b = new C14553(this);
    private final ResourceReleaser<byte[]> f19484d;
    public byte[] f19485e;
    public int f19486f = 0;
    public int f19487g = 0;
    public boolean f19488h;
    public boolean f19489i;
    public final Object f19490j = new Object();

    /* compiled from: commerce_merchant_deactivate */
    final class C14531 implements ResourceReleaser<byte[]> {
        C14531() {
        }

        public final /* bridge */ /* synthetic */ void m28232a(Object obj) {
        }
    }

    /* compiled from: commerce_merchant_deactivate */
    class C14542 extends OutputStream {
        final /* synthetic */ MemoryPipe f19479a;

        C14542(MemoryPipe memoryPipe) {
            this.f19479a = memoryPipe;
        }

        public void write(int i) {
            throw new UnsupportedOperationException();
        }

        public void write(byte[] bArr, int i, int i2) {
            while (i2 > 0) {
                int a = m28233a(bArr, i, i2);
                i2 -= a;
                i += a;
            }
        }

        private int m28233a(byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            synchronized (this.f19479a.f19490j) {
                while (!this.f19479a.f19488h && this.f19479a.f19487g == this.f19479a.f19485e.length) {
                    try {
                        ObjectDetour.a(this.f19479a.f19490j, -307494619);
                    } catch (Throwable e) {
                        throw ((InterruptedIOException) new InterruptedIOException().initCause(e));
                    }
                }
                if (this.f19479a.f19488h) {
                    throw new BrokenPipeException();
                }
                i3 = this.f19479a.f19486f;
                i4 = this.f19479a.f19487g;
            }
            int min = Math.min(i2, this.f19479a.f19485e.length - i4);
            i3 = (i3 + i4) % this.f19479a.f19485e.length;
            i4 = Math.min(min, this.f19479a.f19485e.length - i3);
            System.arraycopy(bArr, i, this.f19479a.f19485e, i3, i4);
            if (i4 < min) {
                System.arraycopy(bArr, i + i4, this.f19479a.f19485e, 0, min - i4);
            }
            synchronized (this.f19479a.f19490j) {
                MemoryPipe.m28234a(this.f19479a, min);
                ObjectDetour.c(this.f19479a.f19490j, -723918306);
            }
            return min;
        }

        public void close() {
            synchronized (this.f19479a.f19490j) {
                this.f19479a.f19489i = true;
                ObjectDetour.c(this.f19479a.f19490j, 1977431193);
                MemoryPipe.m28235a(this.f19479a);
            }
        }
    }

    /* compiled from: commerce_merchant_deactivate */
    class C14553 extends InputStream {
        final /* synthetic */ MemoryPipe f19480a;

        C14553(MemoryPipe memoryPipe) {
            this.f19480a = memoryPipe;
        }

        public int read(byte[] bArr, int i, int i2) {
            int i3;
            synchronized (this.f19480a.f19490j) {
                while (this.f19480a.f19487g == 0) {
                    if (this.f19480a.f19489i) {
                        i3 = -1;
                        break;
                    }
                    try {
                        ObjectDetour.a(this.f19480a.f19490j, 443681559);
                    } catch (Throwable e) {
                        throw ((InterruptedIOException) new InterruptedIOException().initCause(e));
                    }
                }
                int i4 = this.f19480a.f19486f;
                i3 = this.f19480a.f19487g;
                i3 = Math.min(i2, i3);
                int min = Math.min(i3, this.f19480a.f19485e.length - i4);
                System.arraycopy(this.f19480a.f19485e, i4, bArr, i, min);
                if (min < i3) {
                    System.arraycopy(this.f19480a.f19485e, 0, bArr, i + min, i3 - min);
                }
                min = (i4 + i3) % this.f19480a.f19485e.length;
                synchronized (this.f19480a.f19490j) {
                    this.f19480a.f19486f = min;
                    MemoryPipe.m28239c(this.f19480a, i3);
                    ObjectDetour.c(this.f19480a.f19490j, 1535689687);
                }
            }
            return i3;
        }

        public int read() {
            throw new UnsupportedOperationException();
        }

        public void close() {
            synchronized (this.f19480a.f19490j) {
                this.f19480a.f19488h = true;
                ObjectDetour.c(this.f19480a.f19490j, 1738597778);
                MemoryPipe.m28235a(this.f19480a);
            }
        }
    }

    /* compiled from: commerce_merchant_deactivate */
    public class BrokenPipeException extends IOException {
    }

    static /* synthetic */ int m28234a(MemoryPipe memoryPipe, int i) {
        int i2 = memoryPipe.f19487g + i;
        memoryPipe.f19487g = i2;
        return i2;
    }

    static /* synthetic */ int m28239c(MemoryPipe memoryPipe, int i) {
        int i2 = memoryPipe.f19487g - i;
        memoryPipe.f19487g = i2;
        return i2;
    }

    public MemoryPipe(byte[] bArr, ResourceReleaser<byte[]> resourceReleaser) {
        this.f19485e = bArr;
        this.f19484d = resourceReleaser;
        this.f19486f = 0;
        this.f19487g = 0;
        this.f19488h = false;
        this.f19489i = false;
    }

    public static void m28235a(MemoryPipe memoryPipe) {
        if (memoryPipe.f19488h && memoryPipe.f19489i && memoryPipe.f19485e != null) {
            memoryPipe.f19484d.a(memoryPipe.f19485e);
            memoryPipe.f19485e = null;
        }
    }
}
