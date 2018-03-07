package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlf;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzj {
    public final Map<zze, zzld> f3678a;

    public zzj(Activity activity, List<zze> list, Map<zze, List<String>> map) {
        zzx.a(activity);
        zzx.a(list);
        zzx.a(map);
        Map hashMap = new HashMap();
        for (zze com_google_android_gms_auth_api_signin_zze : list) {
            List list2 = (List) map.get(com_google_android_gms_auth_api_signin_zze);
            if (list2 == null) {
                list2 = Collections.emptyList();
            }
            zzlf com_google_android_gms_internal_zzlf = zze.zzVK.equals(com_google_android_gms_auth_api_signin_zze) ? new zzlf(activity, list2) : null;
            if (com_google_android_gms_internal_zzlf != null) {
                hashMap.put(com_google_android_gms_auth_api_signin_zze, com_google_android_gms_internal_zzlf);
            }
        }
        this.f3678a = Collections.unmodifiableMap(hashMap);
    }

    public final zzld m3407a(zze com_google_android_gms_auth_api_signin_zze) {
        zzx.a(com_google_android_gms_auth_api_signin_zze);
        return (zzld) this.f3678a.get(com_google_android_gms_auth_api_signin_zze);
    }
}
