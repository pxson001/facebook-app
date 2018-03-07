package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zza extends com.google.android.gms.common.internal.zzp.zza {
    int f6560a;
    private Account f6561b;
    private Context f6562c;

    public static Account m12263a(zzp com_google_android_gms_common_internal_zzp) {
        Account account = null;
        if (com_google_android_gms_common_internal_zzp != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = com_google_android_gms_common_internal_zzp.mo741a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public final Account mo741a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.f6560a) {
            return this.f6561b;
        }
        if (GooglePlayServicesUtil.a(this.f6562c, callingUid)) {
            this.f6560a = callingUid;
            return this.f6561b;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof zza) ? false : this.f6561b.equals(((zza) obj).f6561b);
    }
}
