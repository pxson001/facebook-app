package com.facebook.vault.protocol;

import android.os.Build;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: thread_id IN (SELECT thread_id FROM #thread_list_ids WHERE sync_change_type!='deleted') */
public class VaultDevicePostParams {
    public final String f1849a;
    public final String f1850b = m1933f();
    public final Boolean f1851c;
    public final String f1852d;
    public final Boolean f1853e;

    public VaultDevicePostParams(String str, boolean z, String str2, boolean z2) {
        this.f1849a = str;
        this.f1851c = Boolean.valueOf(z);
        this.f1852d = str2;
        this.f1853e = Boolean.valueOf(z2);
    }

    public VaultDevicePostParams(String str) {
        this.f1849a = str;
        this.f1851c = null;
        this.f1852d = null;
        this.f1853e = null;
    }

    private static String m1933f() {
        String str = Build.MANUFACTURER;
        if (str == null || str.length() == 0) {
            return Build.MODEL;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1) + " " + Build.MODEL;
    }
}
