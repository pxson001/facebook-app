package com.facebook.common.webp;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Base64;
import com.facebook.webpsupport.WebpBitmapFactoryImpl;

/* compiled from: last_wall */
public class WebpSupportStatus {
    public static final boolean f17778a = (VERSION.SDK_INT <= 17);
    public static final boolean f17779b;
    public static final boolean f17780c = m25000a();
    public static WebpBitmapFactoryImpl f17781d;
    public static boolean f17782e;
    private static final byte[] f17783f = m25004a("RIFF");
    private static final byte[] f17784g = m25004a("WEBP");
    private static final byte[] f17785h = m25004a("VP8 ");
    private static final byte[] f17786i = m25004a("VP8L");
    public static final byte[] f17787j = m25004a("VP8X");

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f17779b = z;
        f17781d = null;
        f17782e = false;
        try {
            f17781d = (WebpBitmapFactoryImpl) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
            f17782e = true;
        } catch (Throwable th) {
            f17782e = false;
        }
    }

    private static byte[] m25004a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (Throwable e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean m25000a() {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (VERSION.SDK_INT == 17) {
            byte[] decode = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (!(options.outHeight == 1 && options.outWidth == 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean m25002a(byte[] bArr, int i, int i2) {
        if (m25005b(bArr, i)) {
            return f17779b;
        }
        if (m25007c(bArr, i)) {
            return f17780c;
        }
        if (!m25006b(bArr, i, i2) || m25001a(bArr, i)) {
            return false;
        }
        return f17780c;
    }

    public static boolean m25001a(byte[] bArr, int i) {
        boolean a = m25003a(bArr, i + 12, f17787j);
        boolean z;
        if ((bArr[i + 20] & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        if (a && r2) {
            return true;
        }
        return false;
    }

    public static boolean m25005b(byte[] bArr, int i) {
        return m25003a(bArr, i + 12, f17785h);
    }

    public static boolean m25007c(byte[] bArr, int i) {
        return m25003a(bArr, i + 12, f17786i);
    }

    public static boolean m25006b(byte[] bArr, int i, int i2) {
        return i2 >= 21 && m25003a(bArr, i + 12, f17787j);
    }

    public static boolean m25008c(byte[] bArr, int i, int i2) {
        return i2 >= 20 && m25003a(bArr, i, f17783f) && m25003a(bArr, i + 8, f17784g);
    }

    public static boolean m25003a(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
