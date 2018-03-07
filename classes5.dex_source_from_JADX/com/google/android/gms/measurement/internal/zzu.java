package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzl.zza;

public class zzu extends zza {
    public final zzt f7114a;
    private final boolean f7115b;

    public zzu(zzt com_google_android_gms_measurement_internal_zzt) {
        zzx.a(com_google_android_gms_measurement_internal_zzt);
        this.f7114a = com_google_android_gms_measurement_internal_zzt;
        this.f7115b = false;
    }

    public zzu(zzt com_google_android_gms_measurement_internal_zzt, boolean z) {
        zzx.a(com_google_android_gms_measurement_internal_zzt);
        this.f7114a = com_google_android_gms_measurement_internal_zzt;
        this.f7115b = z;
    }

    private void m13097b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f7114a.f().b().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            m13098c(str);
        } catch (SecurityException e) {
            this.f7114a.f().b().a("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    private void m13098c(String str) {
        int myUid = this.f7115b ? Process.myUid() : Binder.getCallingUid();
        if (!GooglePlayServicesUtil.a(this.f7114a.c, myUid, str)) {
            if (!GooglePlayServicesUtil.a(this.f7114a.c, myUid) || null != null) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }

    public final void mo848a(final AppMetadata appMetadata) {
        zzx.a(appMetadata);
        m13097b(appMetadata.f7035b);
        this.f7114a.g().a(new Runnable(this) {
            final /* synthetic */ zzu f7113b;

            public void run() {
                this.f7113b.m13103a(appMetadata.f7041h);
                this.f7113b.f7114a.b(appMetadata);
            }
        });
    }

    public final void mo849a(final EventParcel eventParcel, final AppMetadata appMetadata) {
        zzx.a(eventParcel);
        zzx.a(appMetadata);
        m13097b(appMetadata.f7035b);
        this.f7114a.g().a(new Runnable(this) {
            final /* synthetic */ zzu f7101c;

            public void run() {
                this.f7101c.m13103a(appMetadata.f7041h);
                this.f7101c.f7114a.a(eventParcel, appMetadata);
            }
        });
    }

    public final void mo850a(final EventParcel eventParcel, final String str, final String str2) {
        zzx.a(eventParcel);
        zzx.a(str);
        m13097b(str);
        this.f7114a.g().a(new Runnable(this) {
            final /* synthetic */ zzu f7105d;

            public void run() {
                this.f7105d.m13103a(str2);
                this.f7105d.f7114a.a(eventParcel, str);
            }
        });
    }

    public final void mo851a(final UserAttributeParcel userAttributeParcel, final AppMetadata appMetadata) {
        zzx.a(userAttributeParcel);
        zzx.a(appMetadata);
        m13097b(appMetadata.f7035b);
        if (userAttributeParcel.m13068a() == null) {
            this.f7114a.g().a(new Runnable(this) {
                final /* synthetic */ zzu f7108c;

                public void run() {
                    this.f7108c.m13103a(appMetadata.f7041h);
                    this.f7108c.f7114a.b(userAttributeParcel, appMetadata);
                }
            });
        } else {
            this.f7114a.g().a(new Runnable(this) {
                final /* synthetic */ zzu f7111c;

                public void run() {
                    this.f7111c.m13103a(appMetadata.f7041h);
                    this.f7111c.f7114a.a(userAttributeParcel, appMetadata);
                }
            });
        }
    }

    final void m13103a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.f7114a.e().b.a(split[1], longValue);
                    } else {
                        this.f7114a.f().o().a("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.f7114a.f().o().a("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    public final void mo852b(final AppMetadata appMetadata) {
        zzx.a(appMetadata);
        m13097b(appMetadata.f7035b);
        this.f7114a.g().a(new Runnable(this) {
            final /* synthetic */ zzu f7098b;

            public void run() {
                this.f7098b.m13103a(appMetadata.f7041h);
                this.f7098b.f7114a.a(appMetadata);
            }
        });
    }
}
