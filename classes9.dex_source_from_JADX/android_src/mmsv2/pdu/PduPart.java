package android_src.mmsv2.pdu;

import android.net.Uri;
import android.util.SparseArray;
import java.io.File;

/* compiled from: service_intro_header */
public class PduPart {
    static final byte[] f3856a = "from-data".getBytes();
    static final byte[] f3857b = "attachment".getBytes();
    static final byte[] f3858c = "inline".getBytes();
    public SparseArray<Object> f3859d;
    public Uri f3860e;
    public byte[] f3861f;

    public PduPart() {
        this.f3859d = null;
        this.f3860e = null;
        this.f3861f = null;
        this.f3859d = new SparseArray();
    }

    public final void m3682a(byte[] bArr) {
        this.f3861f = bArr;
    }

    public final byte[] m3683a() {
        return this.f3861f;
    }

    public final void m3681a(Uri uri) {
        this.f3860e = uri;
    }

    public final Uri m3684b() {
        return this.f3860e;
    }

    public final void m3685b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Content-Id may not be null or empty.");
        } else if (bArr.length > 1 && ((char) bArr[0]) == '<' && ((char) bArr[bArr.length - 1]) == '>') {
            this.f3859d.put(192, bArr);
        } else {
            Object obj = new byte[(bArr.length + 2)];
            obj[0] = 60;
            obj[obj.length - 1] = 62;
            System.arraycopy(bArr, 0, obj, 1, bArr.length);
            this.f3859d.put(192, obj);
        }
    }

    public final byte[] m3687c() {
        return (byte[]) this.f3859d.get(192);
    }

    public final void m3680a(int i) {
        this.f3859d.put(129, Integer.valueOf(i));
    }

    public final int m3688d() {
        Integer num = (Integer) this.f3859d.get(129);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void m3686c(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-location");
        }
        this.f3859d.put(142, bArr);
    }

    public final byte[] m3691e() {
        return (byte[]) this.f3859d.get(142);
    }

    public final void m3689d(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-disposition");
        }
        this.f3859d.put(197, bArr);
    }

    public final void m3690e(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-type");
        }
        this.f3859d.put(145, bArr);
    }

    public final byte[] m3694g() {
        return (byte[]) this.f3859d.get(145);
    }

    public final void m3692f(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-transfer-encoding");
        }
        this.f3859d.put(200, bArr);
    }

    public final void m3693g(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-id");
        }
        this.f3859d.put(151, bArr);
    }

    public final byte[] m3696i() {
        return (byte[]) this.f3859d.get(151);
    }

    public final void m3695h(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("null content-id");
        }
        this.f3859d.put(152, bArr);
    }

    public final byte[] m3697j() {
        return (byte[]) this.f3859d.get(152);
    }

    public final int m3698k() {
        if (this.f3861f != null) {
            return this.f3861f.length;
        }
        if (this.f3860e != null) {
            return (int) new File(this.f3860e.getPath()).length();
        }
        return 0;
    }
}
