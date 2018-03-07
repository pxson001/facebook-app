package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.webp.WebpSupportStatus;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: latency */
public class ImageFormatChecker {
    public static final byte[] f17772a = new byte[]{(byte) -1, (byte) -40, (byte) -1};
    public static final byte[] f17773b = new byte[]{(byte) -119, (byte) 80, (byte) 78, (byte) 71, (byte) 13, (byte) 10, (byte) 26, (byte) 10};
    public static final byte[] f17774c = m24999b("GIF87a");
    public static final byte[] f17775d = m24999b("GIF89a");
    public static final byte[] f17776e = m24999b("BM");
    private static final int f17777f;

    private ImageFormatChecker() {
    }

    private static int m24994a(InputStream inputStream, byte[] bArr) {
        Preconditions.a(inputStream);
        Preconditions.a(bArr);
        Preconditions.a(bArr.length >= f17777f);
        if (!inputStream.markSupported()) {
            return ByteStreams.m3907a(inputStream, bArr, 0, f17777f);
        }
        try {
            inputStream.mark(f17777f);
            int a = ByteStreams.m3907a(inputStream, bArr, 0, f17777f);
            return a;
        } finally {
            inputStream.reset();
        }
    }

    public static ImageFormat m24995a(InputStream inputStream) {
        ImageFormat imageFormat;
        Preconditions.a(inputStream);
        byte[] bArr = new byte[f17777f];
        int a = m24994a(inputStream, bArr);
        Preconditions.a(bArr);
        if (WebpSupportStatus.m25008c(bArr, 0, a)) {
            ImageFormat imageFormat2;
            Preconditions.a(WebpSupportStatus.m25008c(bArr, 0, a));
            if (WebpSupportStatus.m25005b(bArr, 0)) {
                imageFormat2 = ImageFormat.WEBP_SIMPLE;
            } else if (WebpSupportStatus.m25007c(bArr, 0)) {
                imageFormat2 = ImageFormat.WEBP_LOSSLESS;
            } else if (!WebpSupportStatus.m25006b(bArr, 0, a)) {
                imageFormat2 = ImageFormat.UNKNOWN;
            } else if (WebpSupportStatus.m25001a(bArr, 0)) {
                imageFormat2 = ImageFormat.WEBP_ANIMATED;
            } else {
                Object obj = 1;
                boolean a2 = WebpSupportStatus.m25003a(bArr, 0 + 12, WebpSupportStatus.f17787j);
                Object obj2 = (bArr[0 + 20] & 16) == 16 ? 1 : null;
                if (!a2 || obj2 == null) {
                    obj = null;
                }
                if (obj != null) {
                    imageFormat2 = ImageFormat.WEBP_EXTENDED_WITH_ALPHA;
                } else {
                    imageFormat2 = ImageFormat.WEBP_EXTENDED;
                }
            }
            imageFormat = imageFormat2;
        } else {
            int i = 0;
            if (a >= f17772a.length && m24997a(bArr, 0, f17772a)) {
                i = 1;
            }
            if (i != 0) {
                imageFormat = ImageFormat.JPEG;
            } else {
                i = 0;
                if (a >= f17773b.length && m24997a(bArr, 0, f17773b)) {
                    i = 1;
                }
                if (i != 0) {
                    imageFormat = ImageFormat.PNG;
                } else {
                    i = 0;
                    if (a >= 6 && (m24997a(bArr, 0, f17774c) || m24997a(bArr, 0, f17775d))) {
                        i = 1;
                    }
                    if (i != 0) {
                        imageFormat = ImageFormat.GIF;
                    } else {
                        i = 0;
                        if (a >= f17776e.length) {
                            i = m24997a(bArr, 0, f17776e);
                        }
                        if (i != 0) {
                            imageFormat = ImageFormat.BMP;
                        } else {
                            imageFormat = ImageFormat.UNKNOWN;
                        }
                    }
                }
            }
        }
        return imageFormat;
    }

    public static ImageFormat m24998b(InputStream inputStream) {
        try {
            return m24995a(inputStream);
        } catch (Throwable e) {
            throw Throwables.m15700b(e);
        }
    }

    public static ImageFormat m24996a(String str) {
        InputStream fileInputStream;
        ImageFormat a;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                a = m24995a(fileInputStream);
                Closeables.a(fileInputStream);
            } catch (IOException e) {
                try {
                    a = ImageFormat.UNKNOWN;
                    Closeables.a(fileInputStream);
                    return a;
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.a(fileInputStream);
                    throw th;
                }
            }
        } catch (IOException e2) {
            fileInputStream = null;
            a = ImageFormat.UNKNOWN;
            Closeables.a(fileInputStream);
            return a;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = null;
            th = th4;
            Closeables.a(fileInputStream);
            throw th;
        }
        return a;
    }

    public static boolean m24997a(byte[] bArr, int i, byte[] bArr2) {
        Preconditions.a(bArr);
        Preconditions.a(bArr2);
        Preconditions.a(i >= 0);
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] m24999b(String str) {
        Preconditions.a(str);
        try {
            return str.getBytes("ASCII");
        } catch (Throwable e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    static {
        boolean z;
        int[] iArr = new int[]{21, 20, f17772a.length, f17773b.length, 6, f17776e.length};
        int i = 1;
        if (iArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        int i2 = iArr[0];
        while (i < iArr.length) {
            if (iArr[i] > i2) {
                i2 = iArr[i];
            }
            i++;
        }
        f17777f = i2;
    }
}
