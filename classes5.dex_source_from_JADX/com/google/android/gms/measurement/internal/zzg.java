package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

public class zzg {
    final String f7074a;
    final String f7075b;
    final String f7076c;
    final long f7077d;
    final long f7078e;
    final EventParams f7079f;

    zzg(zzt com_google_android_gms_measurement_internal_zzt, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzx.a(str2);
        zzx.a(str3);
        this.f7074a = str2;
        this.f7075b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f7076c = str;
        this.f7077d = j;
        this.f7078e = j2;
        if (this.f7078e != 0 && this.f7078e > this.f7077d) {
            com_google_android_gms_measurement_internal_zzt.f().h.a("Event created with reverse previous/current timestamps");
        }
        this.f7079f = m13077a(com_google_android_gms_measurement_internal_zzt, bundle);
    }

    private zzg(zzt com_google_android_gms_measurement_internal_zzt, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        zzx.a(str2);
        zzx.a(str3);
        zzx.a(eventParams);
        this.f7074a = str2;
        this.f7075b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f7076c = str;
        this.f7077d = j;
        this.f7078e = j2;
        if (this.f7078e != 0 && this.f7078e > this.f7077d) {
            com_google_android_gms_measurement_internal_zzt.f().h.a("Event created with reverse previous/current timestamps");
        }
        this.f7079f = eventParams;
    }

    private static EventParams m13077a(zzt com_google_android_gms_measurement_internal_zzt, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                it.remove();
            } else {
                zzae i = com_google_android_gms_measurement_internal_zzt.i();
                Object obj = bundle2.get(str);
                int i2 = (TextUtils.isEmpty(str) || !str.startsWith("_")) ? 36 : 256;
                Object a = zzae.a(i2, obj, false);
                if (a == null) {
                    it.remove();
                } else {
                    com_google_android_gms_measurement_internal_zzt.i().a(bundle2, str, a);
                }
            }
        }
        return new EventParams(bundle2);
    }

    final zzg m13078a(zzt com_google_android_gms_measurement_internal_zzt, long j) {
        return new zzg(com_google_android_gms_measurement_internal_zzt, this.f7076c, this.f7074a, this.f7075b, this.f7077d, j, this.f7079f);
    }

    public String toString() {
        return "Event{appId='" + this.f7074a + '\'' + ", name='" + this.f7075b + '\'' + ", params=" + this.f7079f + '}';
    }
}
