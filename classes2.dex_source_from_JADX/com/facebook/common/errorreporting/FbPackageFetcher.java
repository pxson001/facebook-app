package com.facebook.common.errorreporting;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.common.fbpackage.FbAppPackageNames;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: ttlb */
public class FbPackageFetcher {
    private final PackageManager f2205a;
    private final String f2206b;

    @Inject
    public FbPackageFetcher(PackageManager packageManager, String str) {
        this.f2205a = packageManager;
        this.f2206b = str;
    }

    public final List<PackageInfo> m4352a() {
        return m4351a(FbAppPackageNames.a, ImmutableSet.of(this.f2206b));
    }

    private List<PackageInfo> m4351a(Set<String> set, Set<String> set2) {
        List<PackageInfo> a = Lists.m1296a();
        try {
            for (String str : set) {
                if (!set2.contains(str)) {
                    try {
                        a.add(this.f2205a.getPackageInfo(str, 0));
                    } catch (NameNotFoundException e) {
                    }
                }
            }
            return a;
        } catch (Throwable e2) {
            throw new DeadPackageManagerException(e2);
        }
    }
}
