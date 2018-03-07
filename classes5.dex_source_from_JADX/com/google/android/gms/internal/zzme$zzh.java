package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.internal.zzme.zzi;
import java.util.ArrayList;
import java.util.Iterator;

public class zzme$zzh extends zzi {
    final /* synthetic */ zzme f6878a;
    private final ArrayList<zzb> f6879c;

    public zzme$zzh(zzme com_google_android_gms_internal_zzme, ArrayList<zzb> arrayList) {
        this.f6878a = com_google_android_gms_internal_zzme;
        super(com_google_android_gms_internal_zzme);
        this.f6879c = arrayList;
    }

    public final void m12840a() {
        Iterator it = this.f6879c.iterator();
        while (it.hasNext()) {
            ((zzb) it.next()).a(this.f6878a.p);
        }
    }
}
