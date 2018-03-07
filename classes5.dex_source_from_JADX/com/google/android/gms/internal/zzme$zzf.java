package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.internal.zzme.zzi;
import java.util.ArrayList;
import java.util.Iterator;

class zzme$zzf extends zzi {
    final /* synthetic */ zzme f6875a;
    private final ArrayList<zzb> f6876c;

    public zzme$zzf(zzme com_google_android_gms_internal_zzme, ArrayList<zzb> arrayList) {
        this.f6875a = com_google_android_gms_internal_zzme;
        super(com_google_android_gms_internal_zzme);
        this.f6876c = arrayList;
    }

    public final void m12836a() {
        if (this.f6875a.a.g.d.isEmpty()) {
            this.f6875a.a.g.d = zzme.l(this.f6875a);
        }
        Iterator it = this.f6876c.iterator();
        while (it.hasNext()) {
            ((zzb) it.next()).a(this.f6875a.p, this.f6875a.a.g.d);
        }
    }
}
