package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzh {
    public static void m3406a(SignInConfiguration signInConfiguration, List<zze> list, Map<zze, List<String>> map) {
        List linkedList;
        Iterator it;
        zzx.a(signInConfiguration);
        zzx.a(list);
        zzx.a(map);
        GoogleSignInOptions googleSignInOptions = signInConfiguration.e;
        if (googleSignInOptions != null) {
            list.add(zze.zzVJ);
            linkedList = new LinkedList();
            it = googleSignInOptions.a().iterator();
            while (it.hasNext()) {
                linkedList.add(((Scope) it.next()).b);
            }
            map.put(zze.zzVJ, linkedList);
        }
        FacebookSignInOptions facebookSignInOptions = signInConfiguration.f;
        if (facebookSignInOptions != null) {
            list.add(zze.zzVK);
            linkedList = new LinkedList();
            it = facebookSignInOptions.b().iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            map.put(zze.zzVK, linkedList);
        }
    }
}
