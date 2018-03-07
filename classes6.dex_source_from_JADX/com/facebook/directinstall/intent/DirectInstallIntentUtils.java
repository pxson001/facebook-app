package com.facebook.directinstall.intent;

import android.content.Intent;
import android.os.Bundle;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: old_player */
public class DirectInstallIntentUtils {
    public static void m12553a(Intent intent, DirectInstallAppData directInstallAppData) {
        intent.putExtra("app_data", directInstallAppData);
    }

    @Nullable
    public static DirectInstallAppData m12552a(@Nullable Bundle bundle) {
        return bundle != null ? (DirectInstallAppData) bundle.getParcelable("app_data") : null;
    }

    public static void m12554a(Intent intent, ImmutableMap<String, Object> immutableMap) {
        Bundle bundle = new Bundle();
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            bundle.putString((String) entry.getKey(), entry.getValue().toString());
        }
        intent.putExtra("analytics", bundle);
    }

    public static ImmutableMap<String, Object> m12556b(Bundle bundle) {
        Builder builder = ImmutableMap.builder();
        Bundle bundle2 = bundle.getBundle("analytics");
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                builder.b(str, bundle2.get(str));
            }
        }
        return builder.b();
    }

    public static void m12555a(Intent intent, String str) {
        intent.putExtra("install_surface", str);
    }

    @Nullable
    public static String m12557c(Bundle bundle) {
        return bundle.getString("install_surface");
    }
}
