package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface zzmm {

    public interface zza {
        void mo3049a(Bundle bundle);

        void mo3050a(ConnectionResult connectionResult);

        void c_(int i);
    }

    ConnectionResult mo3065a(long j, TimeUnit timeUnit);

    <A extends zzb, R extends Result, T extends com.google.android.gms.internal.zzlx.zza<R, A>> T mo3066a(T t);

    void mo3067a();

    void mo3068a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    boolean mo3069a(zzmp com_google_android_gms_internal_zzmp);

    ConnectionResult mo3070b();

    <A extends zzb, T extends com.google.android.gms.internal.zzlx.zza<? extends Result, A>> T mo3071b(T t);

    void mo3072c();

    boolean mo3073d();

    boolean mo3074e();
}
