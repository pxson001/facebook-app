package com.facebook.resources.impl.model;

import com.google.common.base.Throwables;
import java.io.InputStream;

/* compiled from: textlink_promote_instagram_friend_count_75 */
public class StringResourcesUtil {
    public static String m5072a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }

    public static void m5073a(InputStream inputStream, byte[] bArr, String str) {
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != bArr.length) {
            throw new StringResourceBlobReadException(str, bArr.length, read);
        }
    }
}
