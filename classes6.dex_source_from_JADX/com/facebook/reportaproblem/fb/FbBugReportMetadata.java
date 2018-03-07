package com.facebook.reportaproblem.fb;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.NetworkInfo.DetailedState;
import com.facebook.acra.ErrorReporter;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.hardware.NetworkConnectionChanged;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: setPlatformConfiguration */
public class FbBugReportMetadata {
    private final StatFsHelper f4605a;
    private final PackageManager f4606b;
    private final FbNetworkManager f4607c;

    @Inject
    public FbBugReportMetadata(StatFsHelper statFsHelper, PackageManager packageManager, FbNetworkManager fbNetworkManager) {
        this.f4605a = statFsHelper;
        this.f4606b = packageManager;
        this.f4607c = fbNetworkManager;
    }

    public final Map<String, String> m7117a() {
        Builder builder = ImmutableMap.builder();
        try {
            builder.b("image_cache_size_bytes", String.valueOf(Long.parseLong(ErrorReporter.getInstance().getCustomData("image_file_bytes"))));
        } catch (NumberFormatException e) {
        }
        builder.b("free_internal_storage_bytes", String.valueOf(this.f4605a.a(StorageType.INTERNAL)));
        PackageInfo b = m7116b();
        builder.b("first_install_time", String.valueOf(b.firstInstallTime));
        builder.b("last_upgrade_time", String.valueOf(b.lastUpdateTime));
        NetworkConnectionChanged q = this.f4607c.q();
        if (q != null) {
            int b2 = q.b();
            if (b2 >= 0 && b2 <= 100) {
                builder.b("inet_cond", String.valueOf(b2));
            }
            DetailedState c = q.c();
            if (c != null) {
                builder.b("connection_state", c.toString());
            }
        }
        return builder.b();
    }

    private PackageInfo m7116b() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f4606b.getPackageInfo(BuildConstants.n(), 0);
        } catch (NameNotFoundException e) {
        } catch (RuntimeException e2) {
        }
        return packageInfo;
    }
}
