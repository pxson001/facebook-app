package com.facebook.messaging.attachments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import com.facebook.common.random.SecureRandomFix;
import com.facebook.common.time.SystemClock;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.Entity;
import com.facebook.crypto.module.FacebookConceal;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import javax.inject.Inject;

/* compiled from: login_first_factor */
public class CryptoHandler {
    private static final Class<?> f8851a = CryptoHandler.class;
    private static final Entity f8852e = Entity.a("");
    private final Context f8853b;
    private final FacebookConceal f8854c;
    private final SecureRandom f8855d = new SecureRandom();

    public static CryptoHandler m9220b(InjectorLike injectorLike) {
        return new CryptoHandler((Context) injectorLike.getInstance(Context.class), FacebookConceal.a(injectorLike), SecureRandomFix.a(injectorLike));
    }

    public static CryptoHandler m9216a(InjectorLike injectorLike) {
        return m9220b(injectorLike);
    }

    @Inject
    @SuppressLint({"TrulyRandom"})
    public CryptoHandler(Context context, FacebookConceal facebookConceal, SecureRandomFix secureRandomFix) {
        this.f8853b = context;
        this.f8854c = facebookConceal;
        secureRandomFix.a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    @javax.annotation.Nullable
    public final android.net.Uri m9222a(android.net.Uri r8, java.lang.String r9) {
        /*
        r7 = this;
        r0 = 0;
        r1 = r7.m9215a(r9);
        r2 = r1.a();
        if (r2 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r2 = r7.m9217a();
        r3 = m9221b(r8);
        r4 = m9218a(r2);	 Catch:{ Throwable -> 0x0052, all -> 0x0071 }
        r5 = f8852e;	 Catch:{ Throwable -> 0x0044, all -> 0x0065 }
        r5 = r1.a(r4, r5);	 Catch:{ Throwable -> 0x0044, all -> 0x0065 }
        m9219a(r3, r5);	 Catch:{ Throwable -> 0x0036, all -> 0x0083 }
        r1 = android.net.Uri.fromFile(r2);	 Catch:{ Throwable -> 0x0036, all -> 0x0083 }
        if (r5 == 0) goto L_0x002a;
    L_0x0027:
        r5.close();	 Catch:{  }
    L_0x002a:
        if (r4 == 0) goto L_0x002f;
    L_0x002c:
        r4.close();	 Catch:{  }
    L_0x002f:
        if (r3 == 0) goto L_0x0034;
    L_0x0031:
        r3.close();
    L_0x0034:
        r0 = r1;
        goto L_0x000b;
    L_0x0036:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0038 }
    L_0x0038:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x003c:
        if (r5 == 0) goto L_0x0043;
    L_0x003e:
        if (r2 == 0) goto L_0x0068;
    L_0x0040:
        r5.close();	 Catch:{ Throwable -> 0x0060, all -> 0x0065 }
    L_0x0043:
        throw r1;	 Catch:{  }
    L_0x0044:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0046 }
    L_0x0046:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x004a:
        if (r4 == 0) goto L_0x0051;
    L_0x004c:
        if (r2 == 0) goto L_0x0076;
    L_0x004e:
        r4.close();	 Catch:{ Throwable -> 0x006c, all -> 0x0071 }
    L_0x0051:
        throw r1;	 Catch:{  }
    L_0x0052:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0054 }
    L_0x0054:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0058:
        if (r3 == 0) goto L_0x005f;
    L_0x005a:
        if (r1 == 0) goto L_0x007f;
    L_0x005c:
        r3.close();	 Catch:{ Throwable -> 0x007a }
    L_0x005f:
        throw r0;
    L_0x0060:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r5);	 Catch:{  }
        goto L_0x0043;
    L_0x0065:
        r1 = move-exception;
        r2 = r0;
        goto L_0x004a;
    L_0x0068:
        r5.close();	 Catch:{  }
        goto L_0x0043;
    L_0x006c:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0051;
    L_0x0071:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0058;
    L_0x0076:
        r4.close();	 Catch:{  }
        goto L_0x0051;
    L_0x007a:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);
        goto L_0x005f;
    L_0x007f:
        r3.close();
        goto L_0x005f;
    L_0x0083:
        r1 = move-exception;
        r2 = r0;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.attachments.CryptoHandler.a(android.net.Uri, java.lang.String):android.net.Uri");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    @javax.annotation.Nullable
    public final byte[] m9223b(android.net.Uri r8, java.lang.String r9) {
        /*
        r7 = this;
        r0 = 0;
        r1 = r7.m9215a(r9);
        r2 = r1.a();
        if (r2 != 0) goto L_0x0013;
    L_0x000b:
        r1 = f8851a;
        r2 = "Crypto is not available";
        com.facebook.debug.log.BLog.b(r1, r2);
    L_0x0012:
        return r0;
    L_0x0013:
        r3 = new java.io.ByteArrayOutputStream;
        r2 = m9214a(r8);
        r3.<init>(r2);
        r4 = m9221b(r8);	 Catch:{ Throwable -> 0x0058, all -> 0x0075 }
        r2 = f8852e;	 Catch:{ Throwable -> 0x004a, all -> 0x0069 }
        r5 = r1.a(r4, r2);	 Catch:{ Throwable -> 0x004a, all -> 0x0069 }
        m9219a(r5, r3);	 Catch:{ Throwable -> 0x003c, all -> 0x0087 }
        r1 = r3.toByteArray();	 Catch:{ Throwable -> 0x003c, all -> 0x0087 }
        if (r5 == 0) goto L_0x0032;
    L_0x002f:
        r5.close();	 Catch:{  }
    L_0x0032:
        if (r4 == 0) goto L_0x0037;
    L_0x0034:
        r4.close();	 Catch:{  }
    L_0x0037:
        r3.close();
        r0 = r1;
        goto L_0x0012;
    L_0x003c:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x003e }
    L_0x003e:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0042:
        if (r5 == 0) goto L_0x0049;
    L_0x0044:
        if (r2 == 0) goto L_0x006c;
    L_0x0046:
        r5.close();	 Catch:{ Throwable -> 0x0064, all -> 0x0069 }
    L_0x0049:
        throw r1;	 Catch:{  }
    L_0x004a:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x004c }
    L_0x004c:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0050:
        if (r4 == 0) goto L_0x0057;
    L_0x0052:
        if (r2 == 0) goto L_0x007a;
    L_0x0054:
        r4.close();	 Catch:{ Throwable -> 0x0070, all -> 0x0075 }
    L_0x0057:
        throw r1;	 Catch:{  }
    L_0x0058:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x005a }
    L_0x005a:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x005e:
        if (r1 == 0) goto L_0x0083;
    L_0x0060:
        r3.close();	 Catch:{ Throwable -> 0x007e }
    L_0x0063:
        throw r0;
    L_0x0064:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r5);	 Catch:{  }
        goto L_0x0049;
    L_0x0069:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0050;
    L_0x006c:
        r5.close();	 Catch:{  }
        goto L_0x0049;
    L_0x0070:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r4);	 Catch:{  }
        goto L_0x0057;
    L_0x0075:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x005e;
    L_0x007a:
        r4.close();	 Catch:{  }
        goto L_0x0057;
    L_0x007e:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);
        goto L_0x0063;
    L_0x0083:
        r3.close();
        goto L_0x0063;
    L_0x0087:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.attachments.CryptoHandler.b(android.net.Uri, java.lang.String):byte[]");
    }

    private Crypto m9215a(String str) {
        return this.f8854c.c(new AttachmentKeyChain(CryptoConfig.KEY_256, this.f8855d, Base64.decode(str, 0)));
    }

    private static int m9214a(Uri uri) {
        long length = new File(uri.getPath()).length();
        Preconditions.checkState(length <= 2147483647L);
        return (int) length;
    }

    private static InputStream m9221b(Uri uri) {
        return new FileInputStream(uri.getPath());
    }

    private static OutputStream m9218a(File file) {
        return new BufferedOutputStream(new FileOutputStream(file));
    }

    private static void m9219a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[131072];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private File m9217a() {
        return new File(this.f8853b.getFilesDir(), "attachement" + SystemClock.a.a());
    }
}
