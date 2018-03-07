package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Locale;

public class zzl {
    public static boolean f10175b = false;
    protected final String f10176a;
    private final boolean f10177c;
    private boolean f10178d;
    public boolean f10179e;
    public String f10180f;

    public zzl(String str) {
        this(str, f10175b);
    }

    private zzl(String str, boolean z) {
        zzx.a(str, "The log tag cannot be null or empty.");
        this.f10176a = str;
        this.f10177c = str.length() <= 23;
        this.f10178d = z;
        this.f10179e = false;
    }

    private boolean m11952a() {
        return this.f10178d || (this.f10177c && Log.isLoggable(this.f10176a, 3));
    }

    private String m11953e(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        return !TextUtils.isEmpty(this.f10180f) ? this.f10180f + str : str;
    }

    public final void m11954a(String str, Object... objArr) {
        if (this.f10179e) {
            Log.v(this.f10176a, m11953e(str, objArr));
        }
    }

    public final void m11955a(Throwable th, String str, Object... objArr) {
        if (m11952a() || f10175b) {
            Log.d(this.f10176a, m11953e(str, objArr), th);
        }
    }

    public final void m11956b(String str, Object... objArr) {
        if (m11952a() || f10175b) {
            Log.d(this.f10176a, m11953e(str, objArr));
        }
    }

    public final void m11957c(String str, Object... objArr) {
        Log.i(this.f10176a, m11953e(str, objArr));
    }

    public final void m11958d(String str, Object... objArr) {
        Log.w(this.f10176a, m11953e(str, objArr));
    }
}
