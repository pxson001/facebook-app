package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzmt<T> {
    private static final Object f188c = new Object();
    public static zza f189d = null;
    public static int f190e = 0;
    private static String f191f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String f192a;
    protected final T f193b;
    private T f194g = null;

    public final class C00001 extends zzmt<Boolean> {
        public C00001(String str, Boolean bool) {
            super(str, bool);
        }

        protected final Object mo25a(String str) {
            return zzmt.f189d.a();
        }
    }

    final class C00015 extends zzmt<String> {
        C00015(String str, String str2) {
            super(str, str2);
        }

        protected final Object mo25a(String str) {
            return zzmt.f189d.d();
        }
    }

    final class C00022 extends zzmt<Long> {
        C00022(String str, Long l) {
            super(str, l);
        }

        protected final Object mo25a(String str) {
            return zzmt.f189d.b();
        }
    }

    final class C00033 extends zzmt<Integer> {
        C00033(String str, Integer num) {
            super(str, num);
        }

        protected final Object mo25a(String str) {
            return zzmt.f189d.c();
        }
    }

    protected zzmt(String str, T t) {
        this.f192a = str;
        this.f193b = t;
    }

    public static zzmt<Integer> m316a(String str, Integer num) {
        return new C00033(str, num);
    }

    public static zzmt<Long> m317a(String str, Long l) {
        return new C00022(str, l);
    }

    public static zzmt<String> m318a(String str, String str2) {
        return new C00015(str, str2);
    }

    public static boolean m319b() {
        return f189d != null;
    }

    protected abstract T mo25a(String str);

    public final T m321c() {
        return this.f194g != null ? this.f194g : mo25a(this.f192a);
    }

    public final T m322d() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            T c = m321c();
            return c;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
