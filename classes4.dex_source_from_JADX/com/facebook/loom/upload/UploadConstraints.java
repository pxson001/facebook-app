package com.facebook.loom.upload;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.TriState;
import com.facebook.loom.config.SystemControlConfiguration;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.bridge.constants.DextrConstants;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: getMetaClass */
public class UploadConstraints {
    private final FbSharedPreferences f11126a;
    private final Context f11127b;
    private SystemControlConfiguration f11128c = new SystemControlConfiguration();
    private final Provider<TriState> f11129d;

    @Inject
    public UploadConstraints(Context context, FbSharedPreferences fbSharedPreferences, Provider<TriState> provider) {
        this.f11127b = context;
        this.f11126a = fbSharedPreferences;
        this.f11129d = provider;
    }

    public final boolean m11597a() {
        m11588b();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f11127b.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        if (this.f11129d.get() == TriState.YES) {
            return true;
        }
        if (activeNetworkInfo.getType() != 1 || m11590c() < 0) {
            return false;
        }
        return true;
    }

    public final void m11595a(long j) {
        m11589b(-j);
    }

    private void m11588b() {
        m11589b(0);
    }

    private synchronized void m11589b(long j) {
        long e = m11594e() - m11592d();
        if (e >= this.f11128c.c() || j != 0) {
            e /= this.f11128c.c();
            m11591c((m11590c() + (this.f11128c.b() * e)) + j);
            m11593d((e * this.f11128c.c()) + m11592d());
        }
    }

    private long m11590c() {
        return this.f11126a.a(DextrConstants.a, 0);
    }

    private void m11591c(long j) {
        this.f11126a.edit().a(DextrConstants.a, Math.min(j, this.f11128c.a())).commit();
    }

    private long m11592d() {
        return this.f11126a.a(DextrConstants.b, m11594e());
    }

    private void m11593d(long j) {
        this.f11126a.edit().a(DextrConstants.b, j).commit();
    }

    private static long m11594e() {
        return TimeUnit.MILLISECONDS.toSeconds(SystemClock.a.a());
    }

    public final void m11596a(SystemControlConfiguration systemControlConfiguration) {
        this.f11128c = systemControlConfiguration;
        m11591c(m11590c());
    }
}
