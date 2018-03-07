package com.facebook.common.deviceinfo;

import com.facebook.androidcompat.AndroidCompat;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: story_call_to_action */
public class ThreadInfo {
    public static String m3637a(String str) {
        Throwable th;
        Throwable th2;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[16];
                String str2 = new String(bArr, 0, Math.max(fileInputStream.read(bArr) - 1, 0), "US-ASCII");
                fileInputStream.close();
                return str2;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (th22 != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                fileInputStream.close();
            }
            throw th;
            throw th;
        } catch (IOException e) {
            return null;
        }
    }
}
