package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzp {
    private static final String f6578a = zzp.class.getSimpleName();
    private static final long f6579b = TimeUnit.SECONDS.toMillis(1);
    private static zzp f6580c;
    public final Context f6581d;
    private final Handler f6582e;
    private final Runnable f6583f;
    public final Object f6584g;
    public ArrayList<String> f6585h;
    public ArrayList<String> f6586i;

    class zza implements Runnable {
        final /* synthetic */ zzp f6577a;

        public zza(zzp com_google_android_gms_location_places_internal_zzp) {
            this.f6577a = com_google_android_gms_location_places_internal_zzp;
        }

        public void run() {
            synchronized (this.f6577a.f6584g) {
                Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
                intent.setPackage("com.google.android.gms");
                intent.putStringArrayListExtra("PLACE_IDS", this.f6577a.f6585h);
                intent.putStringArrayListExtra("METHOD_NAMES", this.f6577a.f6586i);
                intent.putExtra("PACKAGE_NAME", this.f6577a.f6581d.getPackageName());
                intent.putExtra("CLIENT_VERSION", GoogleApiAvailability.a);
                this.f6577a.f6581d.sendBroadcast(intent);
                this.f6577a.f6585h = null;
                this.f6577a.f6586i = null;
            }
        }
    }

    private zzp(Context context) {
        this((Context) zzx.a(context), new Handler(Looper.getMainLooper()));
    }

    private zzp(Context context, Handler handler) {
        this.f6583f = new zza(this);
        this.f6584g = new Object();
        this.f6585h = null;
        this.f6586i = null;
        this.f6581d = context;
        this.f6582e = handler;
    }

    public static synchronized zzp m9102a(Context context) {
        zzp com_google_android_gms_location_places_internal_zzp;
        synchronized (zzp.class) {
            zzx.a(context);
            if (VERSION.SDK_INT < 14) {
                com_google_android_gms_location_places_internal_zzp = null;
            } else {
                if (f6580c == null) {
                    f6580c = new zzp(context.getApplicationContext());
                }
                com_google_android_gms_location_places_internal_zzp = f6580c;
            }
        }
        return com_google_android_gms_location_places_internal_zzp;
    }

    public final void m9105a(String str, String str2) {
        synchronized (this.f6584g) {
            if (this.f6585h == null) {
                this.f6585h = new ArrayList();
                this.f6586i = new ArrayList();
                HandlerDetour.b(this.f6582e, this.f6583f, f6579b, -2076034542);
            }
            this.f6585h.add(str);
            this.f6586i.add(str2);
            if (this.f6585h.size() >= 10000) {
                if (Log.isLoggable(f6578a, 5)) {
                    Log.w(f6578a, "Event buffer full, flushing");
                }
                this.f6583f.run();
                HandlerDetour.a(this.f6582e, this.f6583f);
                return;
            }
        }
    }
}
