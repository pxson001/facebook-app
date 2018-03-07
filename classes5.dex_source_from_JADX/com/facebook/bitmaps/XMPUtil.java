package com.facebook.bitmaps;

import com.facebook.debug.log.BLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* compiled from: android.support.actionExtras */
public class XMPUtil {

    /* compiled from: android.support.actionExtras */
    class Section {
        public int f10400a;
        public int f10401b;
        public byte[] f10402c;
    }

    public static byte[] m18498a(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bArr = m18497a((InputStream) fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    BLog.b("XMPUtil", e, "Could not read file: %s", new Object[]{str});
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileInputStream = bArr;
            BLog.b("XMPUtil", e, "Could not read file: %s", new Object[]{str});
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return bArr;
        } catch (Throwable e7) {
            fileInputStream = bArr;
            th = e7;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return bArr;
    }

    private static byte[] m18497a(InputStream inputStream) {
        List<Section> a = m18495a(inputStream, true);
        if (a == null) {
            return null;
        }
        for (Section section : a) {
            if (m18496a(section.f10402c)) {
                byte[] bArr = section.f10402c;
                int length = bArr.length - 1;
                while (length > 0) {
                    if (bArr[length] == (byte) 62 && bArr[length - 1] != (byte) 63) {
                        length++;
                        break;
                    }
                    length--;
                }
                length = bArr.length;
                Object obj = new byte[(length - 29)];
                System.arraycopy(section.f10402c, 29, obj, 0, obj.length);
                return obj;
            }
        }
        return null;
    }

    private static boolean m18496a(byte[] bArr) {
        if (bArr.length < 29) {
            return false;
        }
        try {
            Object obj = new byte[29];
            System.arraycopy(bArr, 0, obj, 0, 29);
            if (new String(obj, "UTF-8").equals("http://ns.adobe.com/xap/1.0/\u0000")) {
                return true;
            }
            return false;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.facebook.bitmaps.XMPUtil.Section> m18495a(java.io.InputStream r8, boolean r9) {
        /*
        r7 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r0 = 0;
        r6 = -1;
        r1 = r8.read();	 Catch:{ IOException -> 0x00a3, all -> 0x00b6 }
        if (r1 != r7) goto L_0x0012;
    L_0x000a:
        r1 = r8.read();	 Catch:{ IOException -> 0x00a3, all -> 0x00b6 }
        r2 = 216; // 0xd8 float:3.03E-43 double:1.067E-321;
        if (r1 == r2) goto L_0x0018;
    L_0x0012:
        if (r8 == 0) goto L_0x0017;
    L_0x0014:
        r8.close();	 Catch:{ IOException -> 0x00c5 }
    L_0x0017:
        return r0;
    L_0x0018:
        r1 = new java.util.ArrayList;	 Catch:{  }
        r1.<init>();	 Catch:{  }
    L_0x001d:
        r2 = r8.read();	 Catch:{  }
        if (r2 == r6) goto L_0x00bd;
    L_0x0023:
        if (r2 == r7) goto L_0x002d;
    L_0x0025:
        if (r8 == 0) goto L_0x0017;
    L_0x0027:
        r8.close();	 Catch:{ IOException -> 0x002b }
        goto L_0x0017;
    L_0x002b:
        r1 = move-exception;
        goto L_0x0017;
    L_0x002d:
        r2 = r8.read();	 Catch:{  }
        if (r2 == r7) goto L_0x002d;
    L_0x0033:
        if (r2 != r6) goto L_0x003d;
    L_0x0035:
        if (r8 == 0) goto L_0x0017;
    L_0x0037:
        r8.close();	 Catch:{ IOException -> 0x003b }
        goto L_0x0017;
    L_0x003b:
        r1 = move-exception;
        goto L_0x0017;
    L_0x003d:
        r3 = 218; // 0xda float:3.05E-43 double:1.077E-321;
        if (r2 != r3) goto L_0x0069;
    L_0x0041:
        if (r9 != 0) goto L_0x0062;
    L_0x0043:
        r3 = new com.facebook.bitmaps.XMPUtil$Section;	 Catch:{  }
        r4 = 0;
        r3.<init>();	 Catch:{  }
        r3.f10400a = r2;	 Catch:{  }
        r2 = -1;
        r3.f10401b = r2;	 Catch:{  }
        r2 = r8.available();	 Catch:{  }
        r2 = new byte[r2];	 Catch:{  }
        r3.f10402c = r2;	 Catch:{  }
        r2 = r3.f10402c;	 Catch:{  }
        r4 = 0;
        r5 = r3.f10402c;	 Catch:{  }
        r5 = r5.length;	 Catch:{  }
        r8.read(r2, r4, r5);	 Catch:{  }
        r1.add(r3);	 Catch:{  }
    L_0x0062:
        if (r8 == 0) goto L_0x0067;
    L_0x0064:
        r8.close();	 Catch:{ IOException -> 0x00c8 }
    L_0x0067:
        r0 = r1;
        goto L_0x0017;
    L_0x0069:
        r3 = r8.read();	 Catch:{  }
        r4 = r8.read();	 Catch:{  }
        if (r3 == r6) goto L_0x0075;
    L_0x0073:
        if (r4 != r6) goto L_0x007d;
    L_0x0075:
        if (r8 == 0) goto L_0x0017;
    L_0x0077:
        r8.close();	 Catch:{ IOException -> 0x007b }
        goto L_0x0017;
    L_0x007b:
        r1 = move-exception;
        goto L_0x0017;
    L_0x007d:
        r3 = r3 << 8;
        r3 = r3 | r4;
        if (r9 == 0) goto L_0x0086;
    L_0x0082:
        r4 = 225; // 0xe1 float:3.15E-43 double:1.11E-321;
        if (r2 != r4) goto L_0x00ae;
    L_0x0086:
        r4 = new com.facebook.bitmaps.XMPUtil$Section;	 Catch:{  }
        r5 = 0;
        r4.<init>();	 Catch:{  }
        r4.f10400a = r2;	 Catch:{  }
        r4.f10401b = r3;	 Catch:{  }
        r2 = r3 + -2;
        r2 = new byte[r2];	 Catch:{  }
        r4.f10402c = r2;	 Catch:{  }
        r2 = r4.f10402c;	 Catch:{  }
        r5 = 0;
        r3 = r3 + -2;
        r8.read(r2, r5, r3);	 Catch:{  }
        r1.add(r4);	 Catch:{  }
        goto L_0x001d;
    L_0x00a3:
        r1 = move-exception;
        if (r8 == 0) goto L_0x0017;
    L_0x00a6:
        r8.close();	 Catch:{ IOException -> 0x00ab }
        goto L_0x0017;
    L_0x00ab:
        r1 = move-exception;
        goto L_0x0017;
    L_0x00ae:
        r2 = r3 + -2;
        r2 = (long) r2;
        r8.skip(r2);	 Catch:{  }
        goto L_0x001d;
    L_0x00b6:
        r0 = move-exception;
        if (r8 == 0) goto L_0x00bc;
    L_0x00b9:
        r8.close();	 Catch:{ IOException -> 0x00cc }
    L_0x00bc:
        throw r0;
    L_0x00bd:
        if (r8 == 0) goto L_0x00c2;
    L_0x00bf:
        r8.close();	 Catch:{ IOException -> 0x00ca }
    L_0x00c2:
        r0 = r1;
        goto L_0x0017;
    L_0x00c5:
        r1 = move-exception;
        goto L_0x0017;
    L_0x00c8:
        r0 = move-exception;
        goto L_0x0067;
    L_0x00ca:
        r0 = move-exception;
        goto L_0x00c2;
    L_0x00cc:
        r1 = move-exception;
        goto L_0x00bc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bitmaps.XMPUtil.a(java.io.InputStream, boolean):java.util.List<com.facebook.bitmaps.XMPUtil$Section>");
    }

    private XMPUtil() {
    }
}
