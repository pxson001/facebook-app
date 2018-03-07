package com.facebook.fbuploader;

import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: new_high_score */
public final class Content {
    private final File f10047a;
    private final String f10048b;
    private final long f10049c;
    public final long f10050d;
    public final String f10051e;
    public final String f10052f;

    private static String m15739a(String str, long j, String str2, long j2) {
        try {
            return m15738a(str + str2) + "-" + j2 + "-" + j;
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    private static String m15738a(String str) {
        byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : digest) {
            stringBuffer.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        return stringBuffer.toString();
    }

    public Content(File file, String str) {
        this.f10047a = file;
        this.f10048b = this.f10047a.getAbsolutePath();
        this.f10049c = 0;
        this.f10050d = this.f10047a.length();
        this.f10051e = str;
        this.f10052f = m15739a(this.f10048b, this.f10050d, this.f10051e, this.f10049c);
    }

    public Content(File file, long j, long j2, String str) {
        this.f10047a = file;
        this.f10048b = this.f10047a.getAbsolutePath();
        this.f10049c = j;
        this.f10050d = j2;
        this.f10051e = str;
        this.f10052f = m15739a(this.f10048b, this.f10050d, this.f10051e, this.f10049c);
    }

    public final File m15740a() {
        return this.f10047a;
    }

    public final long m15741b() {
        return this.f10049c;
    }

    public final long m15742c() {
        return this.f10050d;
    }

    public final String m15743e() {
        return this.f10052f;
    }
}
