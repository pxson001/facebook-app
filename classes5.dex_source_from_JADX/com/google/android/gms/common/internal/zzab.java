package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

public final class zzab extends zzg<zzu> {
    private static final zzab f6565a = new zzab();

    private zzab() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m12267a(Context context, int i, int i2, Scope[] scopeArr) {
        return f6565a.m12268b(context, i, i2, scopeArr);
    }

    private View m12268b(Context context, int i, int i2, Scope[] scopeArr) {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, scopeArr);
            return (View) zze.m12699a(((zzu) m12265a(context)).mo795a(zze.m12698a((Object) context), signInButtonConfig));
        } catch (Throwable e) {
            throw new zza("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public final Object mo742a(IBinder iBinder) {
        zzu com_google_android_gms_common_internal_zzu;
        if (iBinder == null) {
            com_google_android_gms_common_internal_zzu = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            com_google_android_gms_common_internal_zzu = (queryLocalInterface == null || !(queryLocalInterface instanceof zzu)) ? new zzu$zza$zza(iBinder) : (zzu) queryLocalInterface;
        }
        return com_google_android_gms_common_internal_zzu;
    }
}
