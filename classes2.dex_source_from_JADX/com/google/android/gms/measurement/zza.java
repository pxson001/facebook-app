package com.google.android.gms.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

public final class zza {
    private static volatile zza f318d;
    private final String f319a;
    private final Status f320b;
    private final boolean f321c;

    private zza(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(2131233792);
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resourcePackageName);
        if (identifier != 0 && resources.getInteger(identifier) == 0) {
            z = false;
        }
        this.f321c = z;
        int identifier2 = resources.getIdentifier("google_app_id", "string", resourcePackageName);
        if (identifier2 == 0) {
            if (this.f321c) {
                this.f320b = new Status(10, "Missing an expected resource: 'R.string.google_app_id' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.");
            } else {
                this.f320b = Status.f369a;
            }
            this.f319a = null;
            return;
        }
        String string = resources.getString(identifier2);
        if (TextUtils.isEmpty(string)) {
            if (this.f321c) {
                this.f320b = new Status(10, "The resource 'R.string.google_app_id' is invalid, expected an app  identifier and found: '" + string + "'.");
            } else {
                this.f320b = Status.f369a;
            }
            this.f319a = null;
            return;
        }
        this.f319a = string;
        this.f320b = Status.f369a;
    }

    public static Status m639a(Context context) {
        zzx.m105a((Object) context, (Object) "Context must not be null.");
        if (f318d == null) {
            synchronized (zza.class) {
                if (f318d == null) {
                    f318d = new zza(context);
                }
            }
        }
        return f318d.f320b;
    }

    public static String m640a() {
        if (f318d == null) {
            synchronized (zza.class) {
                if (f318d == null) {
                    throw new IllegalStateException("Initialize must be called before getGoogleAppId.");
                }
            }
        }
        return f318d.m642c();
    }

    public static boolean m641b() {
        if (f318d == null) {
            synchronized (zza.class) {
                if (f318d == null) {
                    throw new IllegalStateException("Initialize must be called before isMeasurementEnabled.");
                }
            }
        }
        return f318d.m643d();
    }

    private String m642c() {
        if (this.f320b.m734e()) {
            return this.f319a;
        }
        throw new IllegalStateException("Initialize must be successful before calling getGoogleAppId.  The result of the previous call to initialize was: '" + this.f320b + "'.");
    }

    private boolean m643d() {
        if (this.f320b.m734e()) {
            return this.f321c;
        }
        throw new IllegalStateException("Initialize must be successful before calling isMeasurementEnabledInternal.  The result of the previous call to initialize was: '" + this.f320b + "'.");
    }
}
