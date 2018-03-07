package com.facebook.catalyst.modules.media;

import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: privacy_options_client_sticky_no_privacy_json */
public class MediaPlayerUtils {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.AssetFileDescriptor m10497a(android.content.Context r6, int r7) {
        /*
        r1 = 0;
        r0 = r6.getResources();	 Catch:{ IOException -> 0x0049 }
        r3 = r0.openRawResource(r7);	 Catch:{ IOException -> 0x0049 }
        r4 = new java.util.zip.ZipInputStream;	 Catch:{ Throwable -> 0x003b, all -> 0x0051 }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x003b, all -> 0x0051 }
        r0 = r4.getNextEntry();	 Catch:{ Throwable -> 0x002f, all -> 0x0061 }
        if (r0 != 0) goto L_0x0025;
    L_0x0014:
        r0 = r6.getResources();	 Catch:{ Throwable -> 0x002f, all -> 0x0061 }
        r0 = r0.openRawResourceFd(r7);	 Catch:{ Throwable -> 0x002f, all -> 0x0061 }
        r4.close();	 Catch:{  }
        if (r3 == 0) goto L_0x0024;
    L_0x0021:
        r3.close();	 Catch:{  }
    L_0x0024:
        return r0;
    L_0x0025:
        r4.close();	 Catch:{  }
        if (r3 == 0) goto L_0x002d;
    L_0x002a:
        r3.close();	 Catch:{  }
    L_0x002d:
        r0 = r1;
        goto L_0x0024;
    L_0x002f:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0031 }
    L_0x0031:
        r2 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
    L_0x0035:
        if (r2 == 0) goto L_0x0054;
    L_0x0037:
        r4.close();	 Catch:{ Throwable -> 0x004c, all -> 0x0051 }
    L_0x003a:
        throw r0;	 Catch:{  }
    L_0x003b:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x003d }
    L_0x003d:
        r2 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
    L_0x0041:
        if (r3 == 0) goto L_0x0048;
    L_0x0043:
        if (r2 == 0) goto L_0x005d;
    L_0x0045:
        r3.close();	 Catch:{ Throwable -> 0x0058 }
    L_0x0048:
        throw r0;	 Catch:{  }
    L_0x0049:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0024;
    L_0x004c:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x003a;
    L_0x0051:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0041;
    L_0x0054:
        r4.close();	 Catch:{  }
        goto L_0x003a;
    L_0x0058:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0048;
    L_0x005d:
        r3.close();	 Catch:{  }
        goto L_0x0048;
    L_0x0061:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.catalyst.modules.media.MediaPlayerUtils.a(android.content.Context, int):android.content.res.AssetFileDescriptor");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.FileDescriptor m10499b(android.content.Context r9, int r10) {
        /*
        r1 = 0;
        r0 = r9.getResources();	 Catch:{ IOException -> 0x0072 }
        r3 = r0.openRawResource(r10);	 Catch:{ IOException -> 0x0072 }
        r4 = new java.util.zip.ZipInputStream;	 Catch:{ Throwable -> 0x0086, all -> 0x00c6 }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x0086, all -> 0x00c6 }
        r4.getNextEntry();	 Catch:{ Throwable -> 0x007a, all -> 0x0098 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x007a, all -> 0x0098 }
        r2 = "sound_";
        r0.<init>(r2);	 Catch:{ Throwable -> 0x007a, all -> 0x0098 }
        r0 = r0.append(r10);	 Catch:{ Throwable -> 0x007a, all -> 0x0098 }
        r5 = r0.toString();	 Catch:{ Throwable -> 0x007a, all -> 0x0098 }
        r6 = r9.getFileStreamPath(r5);	 Catch:{ Throwable -> 0x007a, all -> 0x0098 }
        r0 = r6.exists();	 Catch:{ Throwable -> 0x007a, all -> 0x0098 }
        if (r0 == 0) goto L_0x004c;
    L_0x002a:
        r7 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0048 }
        r7.<init>(r6);	 Catch:{ IOException -> 0x0048 }
        r0 = r7.getFD();	 Catch:{ Throwable -> 0x003f, all -> 0x00dc }
        r7.close();	 Catch:{  }
        r4.close();	 Catch:{  }
        if (r3 == 0) goto L_0x003e;
    L_0x003b:
        r3.close();	 Catch:{  }
    L_0x003e:
        return r0;
    L_0x003f:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0041 }
    L_0x0041:
        r0 = move-exception;
    L_0x0042:
        if (r2 == 0) goto L_0x0094;
    L_0x0044:
        r7.close();	 Catch:{ Throwable -> 0x0075, all -> 0x0098 }
    L_0x0047:
        throw r0;	 Catch:{  }
    L_0x0048:
        r0 = move-exception;
        r6.delete();	 Catch:{  }
    L_0x004c:
        r0 = 0;
        r6 = r9.openFileOutput(r5, r0);	 Catch:{  }
        m10498a(r4, r6);	 Catch:{ Throwable -> 0x009b, all -> 0x00d9 }
        if (r6 == 0) goto L_0x0059;
    L_0x0056:
        r6.close();	 Catch:{  }
    L_0x0059:
        r6 = new java.io.FileInputStream;	 Catch:{  }
        r0 = r9.getFileStreamPath(r5);	 Catch:{  }
        r6.<init>(r0);	 Catch:{  }
        r0 = r6.getFD();	 Catch:{ Throwable -> 0x00af, all -> 0x00d6 }
        r6.close();	 Catch:{  }
        r4.close();	 Catch:{  }
        if (r3 == 0) goto L_0x003e;
    L_0x006e:
        r3.close();	 Catch:{  }
        goto L_0x003e;
    L_0x0072:
        r0 = move-exception;
        r0 = r1;
        goto L_0x003e;
    L_0x0075:
        r7 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r7);	 Catch:{  }
        goto L_0x0047;
    L_0x007a:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x007c }
    L_0x007c:
        r2 = move-exception;
        r8 = r2;
        r2 = r0;
        r0 = r8;
    L_0x0080:
        if (r2 == 0) goto L_0x00c9;
    L_0x0082:
        r4.close();	 Catch:{ Throwable -> 0x00c1, all -> 0x00c6 }
    L_0x0085:
        throw r0;	 Catch:{  }
    L_0x0086:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0088 }
    L_0x0088:
        r2 = move-exception;
        r8 = r2;
        r2 = r0;
        r0 = r8;
    L_0x008c:
        if (r3 == 0) goto L_0x0093;
    L_0x008e:
        if (r2 == 0) goto L_0x00d2;
    L_0x0090:
        r3.close();	 Catch:{ Throwable -> 0x00cd }
    L_0x0093:
        throw r0;	 Catch:{  }
    L_0x0094:
        r7.close();	 Catch:{  }
        goto L_0x0047;
    L_0x0098:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0080;
    L_0x009b:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x009d }
    L_0x009d:
        r0 = move-exception;
    L_0x009e:
        if (r6 == 0) goto L_0x00a5;
    L_0x00a0:
        if (r2 == 0) goto L_0x00ab;
    L_0x00a2:
        r6.close();	 Catch:{ Throwable -> 0x00a6, all -> 0x0098 }
    L_0x00a5:
        throw r0;	 Catch:{  }
    L_0x00a6:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r5);	 Catch:{  }
        goto L_0x00a5;
    L_0x00ab:
        r6.close();	 Catch:{  }
        goto L_0x00a5;
    L_0x00af:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x00b1 }
    L_0x00b1:
        r0 = move-exception;
    L_0x00b2:
        if (r2 == 0) goto L_0x00bd;
    L_0x00b4:
        r6.close();	 Catch:{ Throwable -> 0x00b8, all -> 0x0098 }
    L_0x00b7:
        throw r0;	 Catch:{  }
    L_0x00b8:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r5);	 Catch:{  }
        goto L_0x00b7;
    L_0x00bd:
        r6.close();	 Catch:{  }
        goto L_0x00b7;
    L_0x00c1:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0085;
    L_0x00c6:
        r0 = move-exception;
        r2 = r1;
        goto L_0x008c;
    L_0x00c9:
        r4.close();	 Catch:{  }
        goto L_0x0085;
    L_0x00cd:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r3);	 Catch:{  }
        goto L_0x0093;
    L_0x00d2:
        r3.close();	 Catch:{  }
        goto L_0x0093;
    L_0x00d6:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00b2;
    L_0x00d9:
        r0 = move-exception;
        r2 = r1;
        goto L_0x009e;
    L_0x00dc:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.catalyst.modules.media.MediaPlayerUtils.b(android.content.Context, int):java.io.FileDescriptor");
    }

    private static void m10498a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
