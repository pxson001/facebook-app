package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/* compiled from: close_friends */
public class VersionUtil {
    private static final Pattern f5968a = Pattern.compile("[-_./;:]");
    public final Version f5969b;

    protected VersionUtil() {
        Version version = null;
        try {
            version = m10779a(getClass());
        } catch (Exception e) {
            System.err.println("ERROR: Failed to load Version information for bundle (via " + getClass().getName() + ").");
        }
        if (version == null) {
            version = Version.a();
        }
        this.f5969b = version;
    }

    public final Version m10783a() {
        return this.f5969b;
    }

    public static Version m10779a(Class<?> cls) {
        Version b = m10781b(cls);
        if (b != null) {
            return b;
        }
        InputStream resourceAsStream = cls.getResourceAsStream("VERSION.txt");
        if (resourceAsStream == null) {
            return Version.a();
        }
        try {
            Reader inputStreamReader = new InputStreamReader(resourceAsStream, "UTF-8");
            try {
                b = m10778a(inputStreamReader);
                return b;
            } finally {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                }
            }
        } catch (UnsupportedEncodingException e2) {
            b = Version.a();
            return b;
        } finally {
            try {
                resourceAsStream.close();
            } catch (Throwable e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    private static Version m10781b(Class<?> cls) {
        try {
            Class cls2 = Class.forName(new StringBuilder(cls.getPackage().getName()).append(".PackageVersion").toString(), true, cls.getClassLoader());
            if (cls2 == null) {
                return null;
            }
            try {
                Object newInstance = cls2.newInstance();
                if (newInstance instanceof Versioned) {
                    return ((Versioned) newInstance).version();
                }
                throw new IllegalArgumentException("Bad version class " + cls2.getName() + ": does not implement " + Versioned.class.getName());
            } catch (RuntimeException e) {
                throw e;
            } catch (Throwable e2) {
                throw new IllegalArgumentException("Failed to instantiate " + cls2.getName() + " to find version information, problem: " + e2.getMessage(), e2);
            }
        } catch (Exception e3) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.fasterxml.jackson.core.Version m10778a(java.io.Reader r6) {
        /*
        r1 = 0;
        r3 = new java.io.BufferedReader;
        r3.<init>(r6);
        r2 = r3.readLine();	 Catch:{ IOException -> 0x0032, all -> 0x0041 }
        if (r2 == 0) goto L_0x004d;
    L_0x000c:
        r0 = r3.readLine();	 Catch:{ IOException -> 0x0048, all -> 0x0041 }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r1 = r3.readLine();	 Catch:{ IOException -> 0x004b, all -> 0x0041 }
    L_0x0016:
        r3.close();	 Catch:{ IOException -> 0x002d }
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x001c:
        if (r1 == 0) goto L_0x0022;
    L_0x001e:
        r1 = r1.trim();
    L_0x0022:
        if (r0 == 0) goto L_0x0028;
    L_0x0024:
        r0 = r0.trim();
    L_0x0028:
        r0 = m10780a(r2, r1, r0);
        return r0;
    L_0x002d:
        r3 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x001c;
    L_0x0032:
        r0 = move-exception;
        r0 = r1;
        r2 = r1;
    L_0x0035:
        r3.close();	 Catch:{ IOException -> 0x003c }
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x001c;
    L_0x003c:
        r3 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x001c;
    L_0x0041:
        r0 = move-exception;
        r3.close();	 Catch:{ IOException -> 0x0046 }
    L_0x0045:
        throw r0;
    L_0x0046:
        r1 = move-exception;
        goto L_0x0045;
    L_0x0048:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0035;
    L_0x004b:
        r4 = move-exception;
        goto L_0x0035;
    L_0x004d:
        r0 = r1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.VersionUtil.a(java.io.Reader):com.fasterxml.jackson.core.Version");
    }

    public static Version m10780a(String str, String str2, String str3) {
        String str4 = null;
        if (str == null) {
            return null;
        }
        CharSequence trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        int a;
        int a2;
        String[] split = f5968a.split(trim);
        int a3 = m10777a(split[0]);
        if (split.length > 1) {
            a = m10777a(split[1]);
        } else {
            a = 0;
        }
        if (split.length > 2) {
            a2 = m10777a(split[2]);
        } else {
            a2 = 0;
        }
        if (split.length > 3) {
            str4 = split[3];
        }
        return new Version(a3, a, a2, str4, str2, str3);
    }

    private static int m10777a(String str) {
        int i = 0;
        String str2 = str.toString();
        int length = str2.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str2.charAt(i);
            if (charAt > '9' || charAt < '0') {
                break;
            }
            i2 = (i2 * 10) + (charAt - 48);
            i++;
        }
        return i2;
    }

    public static final void m10782b() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }
}
