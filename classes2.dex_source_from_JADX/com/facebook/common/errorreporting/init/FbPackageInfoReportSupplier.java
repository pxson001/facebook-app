package com.facebook.common.errorreporting.init;

import android.content.pm.PackageInfo;
import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.common.errorreporting.FbPackageFetcher;
import com.facebook.common.errorreporting.FbPackageFetcher.DeadPackageManagerException;
import java.util.List;
import javax.inject.Inject;

/* compiled from: tuzi_android_group_purpose_modal */
public class FbPackageInfoReportSupplier implements FbCustomReportDataSupplier {
    private final FbPackageFetcher f2204a;

    @Inject
    public FbPackageInfoReportSupplier(FbPackageFetcher fbPackageFetcher) {
        this.f2204a = fbPackageFetcher;
    }

    public final String mo633a(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return "n/a";
        }
        try {
            List<PackageInfo> a = this.f2204a.m4352a();
            if (a == null || a.isEmpty()) {
                return "none";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (PackageInfo packageInfo : a) {
                stringBuilder.append(packageInfo.packageName).append("={").append(packageInfo.versionCode).append(",").append(packageInfo.versionName).append("}\n");
            }
            return stringBuilder.toString();
        } catch (DeadPackageManagerException e) {
            return "exception";
        }
    }

    public final String mo632a() {
        return null;
    }
}
