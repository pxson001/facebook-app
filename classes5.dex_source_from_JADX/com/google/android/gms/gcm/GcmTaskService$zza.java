package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

class GcmTaskService$zza extends Thread {
    final /* synthetic */ GcmTaskService f6797a;
    private final String f6798b;
    private final zzc f6799c;
    private final Bundle f6800d;

    GcmTaskService$zza(GcmTaskService gcmTaskService, String str, IBinder iBinder, Bundle bundle) {
        zzc com_google_android_gms_gcm_zzc;
        this.f6797a = gcmTaskService;
        this.f6798b = str;
        if (iBinder == null) {
            com_google_android_gms_gcm_zzc = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
            com_google_android_gms_gcm_zzc = (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new zzc$zza$zza(iBinder) : (zzc) queryLocalInterface;
        }
        this.f6799c = com_google_android_gms_gcm_zzc;
        this.f6800d = bundle;
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            this.f6799c.mo810a(this.f6797a.a(new TaskParams(this.f6798b, this.f6800d)));
        } catch (RemoteException e) {
            Log.e("GcmTaskService", "Error reporting result of operation to scheduler for " + this.f6798b);
        } finally {
            GcmTaskService.a(this.f6797a, this.f6798b);
        }
    }
}
