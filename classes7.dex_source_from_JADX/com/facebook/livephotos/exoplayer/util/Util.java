package com.facebook.livephotos.exoplayer.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

/* compiled from: only_tag_good_friends */
public final class Util {
    public static final int f7736a;
    public static final String f7737b = Build.DEVICE;
    public static final String f7738c = Build.MANUFACTURER;
    public static final String f7739d = Build.MODEL;
    private static final Pattern f7740e = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
    private static final Pattern f7741f = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern f7742g = Pattern.compile("%([A-Fa-f0-9]{2})");

    /* compiled from: only_tag_good_friends */
    public final class C06271 implements ThreadFactory {
        final /* synthetic */ String f7735a;

        public C06271(String str) {
            this.f7735a = str;
        }

        public final Thread newThread(Runnable runnable) {
            return ThreadInitDetour.a(runnable, this.f7735a, 882543259);
        }
    }

    static {
        int i = (VERSION.SDK_INT == 23 && VERSION.CODENAME.charAt(0) == 'N') ? 24 : VERSION.SDK_INT;
        f7736a = i;
    }

    private Util() {
    }

    public static boolean m9365a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    public static int m9360a(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int m9361a(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else if (!z) {
            binarySearch--;
        }
        return z2 ? Math.max(0, binarySearch) : binarySearch;
    }

    public static int m9366b(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch ^= -1;
        } else if (!z) {
            binarySearch++;
        }
        return z2 ? Math.min(jArr.length - 1, binarySearch) : binarySearch;
    }

    public static long m9362a(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 >= j2 || j2 % j3 != 0) {
            return (long) ((((double) j2) / ((double) j3)) * ((double) j));
        }
        return (j2 / j3) * j;
    }

    public static void m9364a(long[] jArr, long j, long j2) {
        int i = 0;
        long j3;
        if (j2 >= j && j2 % j == 0) {
            j3 = j2 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
        } else if (j2 >= j || j % j2 != 0) {
            double d = ((double) j) / ((double) j2);
            while (i < jArr.length) {
                jArr[i] = (long) (((double) jArr[i]) * d);
                i++;
            }
        } else {
            j3 = j / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j3;
                i++;
            }
        }
    }

    public static void m9363a(HttpURLConnection httpURLConnection, long j) {
        if (f7736a == 19 || f7736a == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    public static int m9368c(String str) {
        boolean z;
        int i = 0;
        int length = str.length();
        if (length <= 4) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m9295a(z);
        int i2 = 0;
        while (i < length) {
            i2 = (i2 << 8) | str.charAt(i);
            i++;
        }
        return i2;
    }

    public static long m9367b(int i, int i2) {
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }
}
