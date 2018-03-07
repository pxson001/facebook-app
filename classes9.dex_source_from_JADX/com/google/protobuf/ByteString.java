package com.google.protobuf;

import java.io.InputStream;
import java.util.Iterator;

/* compiled from: android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED */
public abstract class ByteString implements Iterable<Byte> {
    public static final ByteString f20600a = new LiteralByteString(new byte[0]);
    static final /* synthetic */ boolean f20601b;

    /* compiled from: android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED */
    public interface ByteIterator extends Iterator<Byte> {
        byte mo908a();
    }

    /* compiled from: android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED */
    final class CodedBuilder {
        private final CodedOutputStream f20598a = CodedOutputStream.m20228a(this.f20599b);
        private final byte[] f20599b;

        public CodedBuilder(int i) {
            this.f20599b = new byte[i];
        }

        public final ByteString m20171a() {
            this.f20598a.m20284h();
            return new LiteralByteString(this.f20599b);
        }

        public final CodedOutputStream m20172b() {
            return this.f20598a;
        }
    }

    public abstract byte mo909a(int i);

    protected abstract int mo910a(int i, int i2, int i3);

    public abstract ByteIterator mo911a();

    public abstract int mo912b();

    protected abstract int mo913b(int i, int i2, int i3);

    public abstract String mo914b(String str);

    protected abstract void mo915b(byte[] bArr, int i, int i2, int i3);

    public abstract boolean mo916f();

    public abstract InputStream mo917g();

    public abstract CodedInputStream mo918h();

    protected abstract int mo919i();

    static {
        boolean z;
        if (ByteString.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f20601b = z;
    }

    public /* synthetic */ Iterator iterator() {
        return mo911a();
    }

    ByteString() {
    }

    public static ByteString m20175a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new LiteralByteString(obj);
    }

    public static ByteString m20174a(byte[] bArr) {
        return m20175a(bArr, 0, bArr.length);
    }

    public static ByteString m20173a(String str) {
        try {
            return new LiteralByteString(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public final void m20180a(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Source offset < 0: " + i);
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Target offset < 0: " + i2);
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("Length < 0: " + i3);
        } else if (i + i3 > mo912b()) {
            throw new IndexOutOfBoundsException("Source end offset < 0: " + (i + i3));
        } else if (i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException("Target end offset < 0: " + (i2 + i3));
        } else if (i3 > 0) {
            mo915b(bArr, i, i2, i3);
        }
    }

    public final byte[] m20185d() {
        int b = mo912b();
        byte[] bArr = new byte[b];
        mo915b(bArr, 0, 0, b);
        return bArr;
    }

    public final String m20186e() {
        try {
            return mo914b("UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    static CodedBuilder m20176b(int i) {
        return new CodedBuilder(i);
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(mo912b())});
    }
}
