package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzlt implements com.google.android.gms.clearcut.zzb {
    private static final Object f6817a = new Object();
    private static final zze f6818b = new zze();
    private static final long f6819c = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    public final zznl f6820d;
    private final zza f6821e;
    public final Object f6822f;
    public long f6823g;
    private final long f6824h;
    private ScheduledFuture<?> f6825i;
    public GoogleApiClient f6826j;
    private final Runnable f6827k;

    class C07871 implements Runnable {
        final /* synthetic */ zzlt f6815a;

        C07871(zzlt com_google_android_gms_internal_zzlt) {
            this.f6815a = com_google_android_gms_internal_zzlt;
        }

        public void run() {
            synchronized (this.f6815a.f6822f) {
                if (this.f6815a.f6823g <= this.f6815a.f6820d.b() && this.f6815a.f6826j != null) {
                    Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                    this.f6815a.f6826j.e();
                    this.f6815a.f6826j = null;
                }
            }
        }
    }

    public interface zza {
    }

    public class zzb implements zza {
    }

    final class zze {
        private int f6816a = 0;
    }

    public zzlt() {
        this(new zzno(), f6819c, new zzb());
    }

    private zzlt(zznl com_google_android_gms_internal_zznl, long j, zza com_google_android_gms_internal_zzlt_zza) {
        this.f6822f = new Object();
        this.f6823g = 0;
        this.f6825i = null;
        this.f6826j = null;
        this.f6827k = new C07871(this);
        this.f6820d = com_google_android_gms_internal_zznl;
        this.f6824h = j;
        this.f6821e = com_google_android_gms_internal_zzlt_zza;
    }
}
