package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzmp;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class zzb extends AsyncTaskLoader<Void> implements zzmp {
    private Semaphore f3676f = new Semaphore(0);
    private Set<GoogleApiClient> f3677g;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.f3677g = set;
    }

    public final Object m3404d() {
        int i = 0;
        for (GoogleApiClient a : this.f3677g) {
            i = a.a(this) ? i + 1 : i;
        }
        try {
            this.f3676f.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    protected final void m3405g() {
        this.f3676f.drainPermits();
        a();
    }

    public final void kT_() {
        this.f3676f.release();
    }
}
