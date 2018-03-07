package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zza;
import com.google.android.gms.internal.zzav;
import java.io.IOException;

public class AdvertisingIdClient {
    private static boolean f11799h = false;
    zza f11800a;
    zzav f11801b;
    boolean f11802c;
    Object f11803d = new Object();
    zza f11804e;
    final long f11805f;
    private final Context f11806g;

    private AdvertisingIdClient(Context context, long j) {
        zzx.a(context);
        this.f11806g = context;
        this.f11802c = false;
        this.f11805f = j;
    }

    public static Info m12400a(Context context) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.m12405b(false);
            Info c = advertisingIdClient.m12406c();
            return c;
        } finally {
            advertisingIdClient.m12407a();
        }
    }

    private static zzav m12401a(zza com_google_android_gms_common_zza) {
        try {
            return zzav.zza.a(com_google_android_gms_common_zza.a());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    public static void m12402a(boolean z) {
        f11799h = z;
    }

    private static zza m12403b(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            if (f11799h) {
                Log.d("Ads", "Skipping gmscore version check");
                GoogleApiAvailability.a();
                switch (GoogleApiAvailability.a(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                GooglePlayServicesUtil.b(context);
            } catch (GooglePlayServicesNotAvailableException e) {
                throw new IOException(e);
            }
            zza com_google_android_gms_common_zza = new zza();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (zzb.a().a(context, intent, com_google_android_gms_common_zza, 1)) {
                    return com_google_android_gms_common_zza;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                IOException iOException = new IOException(th);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    private void m12404b() {
        synchronized (this.f11803d) {
            if (this.f11804e != null) {
                this.f11804e.a();
                try {
                    this.f11804e.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.f11805f > 0) {
                this.f11804e = new zza(this, this.f11805f);
            }
        }
    }

    private void m12405b(boolean z) {
        zzx.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f11802c) {
                m12407a();
            }
            this.f11800a = m12403b(this.f11806g);
            this.f11801b = m12401a(this.f11800a);
            this.f11802c = true;
            if (z) {
                m12404b();
            }
        }
    }

    private Info m12406c() {
        Info info;
        zzx.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f11802c) {
                synchronized (this.f11803d) {
                    if (this.f11804e == null || !this.f11804e.b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    m12405b(false);
                    if (!this.f11802c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            zzx.a(this.f11800a);
            zzx.a(this.f11801b);
            try {
                info = new Info(this.f11801b.a(), this.f11801b.a(true));
            } catch (Throwable e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        m12404b();
        return info;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m12407a() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.zzx.c(r0);
        monitor-enter(r3);
        r0 = r3.f11806g;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.f11800a;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.f11802c;	 Catch:{ IllegalArgumentException -> 0x002d }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.stats.zzb.a();	 Catch:{ IllegalArgumentException -> 0x002d }
        r1 = r3.f11806g;	 Catch:{ IllegalArgumentException -> 0x002d }
        r2 = r3.f11800a;	 Catch:{ IllegalArgumentException -> 0x002d }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d }
    L_0x001f:
        r0 = 0;
        r3.f11802c = r0;	 Catch:{  }
        r0 = 0;
        r3.f11801b = r0;	 Catch:{  }
        r0 = 0;
        r3.f11800a = r0;	 Catch:{  }
        monitor-exit(r3);	 Catch:{  }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{  }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{  }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.a():void");
    }

    protected void finalize() {
        m12407a();
        super.finalize();
    }
}
