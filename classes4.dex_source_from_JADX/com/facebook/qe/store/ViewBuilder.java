package com.facebook.qe.store;

import com.facebook.common.preconditions.Preconditions;
import com.facebook.debug.log.BLog;
import com.facebook.qe.api.manager.Authority;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: updateContactsCoefficientInDatabase (%d contacts) */
public class ViewBuilder {
    public static final Class<ViewBuilder> f524a = ViewBuilder.class;
    private final int[] f525b;
    private final int[] f526c;
    public ByteBuffer f527d;

    /* compiled from: updateContactsCoefficientInDatabase (%d contacts) */
    /* synthetic */ class C00701 {
        static final /* synthetic */ int[] f1129a = new int[Authority.values().length];

        static {
            try {
                f1129a[Authority.ASSIGNED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1129a[Authority.OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public ViewBuilder(int i) {
        this.f525b = new int[i];
        this.f526c = new int[i];
        Arrays.fill(this.f525b, -1);
        Arrays.fill(this.f526c, -1);
        int i2 = (i * 12) + 20;
        this.f527d = ByteBuffer.allocate(i2);
        this.f527d.position(0);
        this.f527d.putInt(-87109619);
        this.f527d.position(4);
        this.f527d.putInt(538251284);
        this.f527d.position(12);
        this.f527d.putInt(i);
        this.f527d.position(i2);
    }

    public final void m823a(Authority authority, int i, String str) {
        byte[] bytes = str.getBytes(Constants.a);
        m813a(bytes.length + 4, authority, i);
        this.f527d.putInt(bytes.length);
        this.f527d.put(bytes);
    }

    public final void m821a(Authority authority, int i, int i2) {
        m813a(4, authority, i);
        this.f527d.putInt(i2);
    }

    public final void m822a(Authority authority, int i, long j) {
        m813a(8, authority, i);
        this.f527d.putLong(j);
    }

    public final void m820a(Authority authority, int i, float f) {
        m813a(4, authority, i);
        this.f527d.putFloat(f);
    }

    public final void m824a(Authority authority, int i, boolean z) {
        int i2 = 1;
        m813a(1, authority, i);
        ByteBuffer byteBuffer = this.f527d;
        if (!z) {
            i2 = 0;
        }
        byteBuffer.put((byte) i2);
    }

    public final void m818a(int i) {
        m816b(Authority.OVERRIDE, i);
        m815a(Authority.OVERRIDE)[i] = -2;
    }

    public final void m819a(Authority authority, int i) {
        m815a(authority)[i] = -1;
    }

    public final void m825a(Authority authority, String str, String str2, int i, int i2, String str3) {
        switch (i2) {
            case 100:
                m823a(authority, i, str3);
                return;
            case 101:
                m824a(authority, i, m814a(str3));
                return;
            case 102:
                m821a(authority, i, Integer.parseInt(str3));
                return;
            case 103:
                m822a(authority, i, Long.parseLong(str3));
                return;
            case 104:
                m820a(authority, i, Float.parseFloat(str3));
                return;
            case 105:
                m823a(authority, i, str3);
                return;
            default:
                try {
                    throw new RuntimeException("Illegal type: " + i2);
                } catch (Throwable e) {
                    BLog.b(f524a, e, "Could not coerce %s to type %d for %s.%s", new Object[]{str3, Integer.valueOf(i2), str, str2});
                    return;
                }
        }
    }

    public final ByteBuffer m817a() {
        int i;
        int i2 = 0;
        int position = this.f527d.position();
        this.f527d.position(20);
        int length = this.f525b.length;
        for (i = 0; i < length; i++) {
            if (this.f526c[i] == -1) {
                this.f527d.putInt(this.f525b[i]);
            } else {
                this.f527d.putInt(this.f526c[i]);
            }
        }
        i = 1;
        for (int i3 : this.f525b) {
            if (i3 >= 0) {
                i = 0;
            }
            this.f527d.putInt(i3);
        }
        for (int putInt : this.f526c) {
            this.f527d.putInt(putInt);
        }
        this.f527d.position(0);
        length = this.f527d.remaining();
        this.f527d.position(8);
        this.f527d.putInt(length);
        this.f527d.position(16);
        ByteBuffer byteBuffer = this.f527d;
        if (i != 0) {
            i2 = 1;
        }
        byteBuffer.putInt(i2);
        this.f527d.position(position);
        return this.f527d;
    }

    private int[] m815a(Authority authority) {
        switch (C00701.f1129a[authority.ordinal()]) {
            case 1:
                return this.f525b;
            case 2:
                return this.f526c;
            default:
                throw new IllegalArgumentException("Illegal authority: " + authority);
        }
    }

    private static boolean m814a(String str) {
        String toLowerCase = str.toLowerCase(Locale.US);
        if ("true".equals(toLowerCase) || "1".equals(toLowerCase) || "yes".equals(toLowerCase)) {
            return true;
        }
        if ("false".equals(toLowerCase) || "0".equals(toLowerCase) || "no".equals(toLowerCase)) {
            return false;
        }
        throw new NumberFormatException();
    }

    private void m816b(Authority authority, int i) {
        boolean z;
        boolean z2 = true;
        if (m815a(authority)[i] == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        if (authority == Authority.EFFECTIVE) {
            z2 = false;
        }
        Preconditions.a(z2);
    }

    private void m813a(int i, Authority authority, int i2) {
        m816b(authority, i2);
        int position = this.f527d.position() % 4;
        while (this.f527d.position() + (position + i) > this.f527d.capacity()) {
            int position2 = this.f527d.position();
            ByteBuffer allocate = ByteBuffer.allocate(this.f527d.capacity() * 2);
            this.f527d.position(0);
            allocate.put(this.f527d);
            this.f527d = allocate;
            this.f527d.position(position2);
        }
        this.f527d.position(position + this.f527d.position());
        m815a(authority)[i2] = this.f527d.position();
    }
}
