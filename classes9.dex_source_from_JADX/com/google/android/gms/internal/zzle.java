package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zzle implements zzld {
    protected final Activity f3679a;
    public final Set<String> f3680b;
    public String f3681c;
    public String f3682d;
    public zza f3683e;

    protected zzle(Activity activity, List<String> list, List<String> list2) {
        this.f3679a = (Activity) zzx.a(activity);
        Set hashSet = new HashSet((Collection) zzx.a(list));
        hashSet.addAll((Collection) zzx.a(list2));
        this.f3680b = Collections.unmodifiableSet(hashSet);
    }

    public final Intent m3413a(IdpTokenType idpTokenType, String str, String str2) {
        zzx.a(idpTokenType);
        zzx.a(str);
        Intent intent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent.putExtra("idpTokenType", idpTokenType);
        intent.putExtra("idpToken", str);
        intent.putExtra("pendingToken", str2);
        zze a = mo101a();
        if (a != null) {
            intent.putExtra("idProvider", a.zzmC());
        }
        return intent;
    }

    protected final void m3414b(zza com_google_android_gms_internal_zzld_zza) {
        this.f3683e = (zza) zzx.a(com_google_android_gms_internal_zzld_zza);
    }

    protected final void m3415b(String str, String str2, zza com_google_android_gms_internal_zzld_zza) {
        this.f3681c = str;
        this.f3682d = str2;
        m3414b(com_google_android_gms_internal_zzld_zza);
    }
}
