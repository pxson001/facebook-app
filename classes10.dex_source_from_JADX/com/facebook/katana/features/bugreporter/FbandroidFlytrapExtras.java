package com.facebook.katana.features.bugreporter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.NetworkInfo.DetailedState;
import com.facebook.acra.ErrorReporter;
import com.facebook.analytics.activityidentifier.ActivityNameFormatter;
import com.facebook.bugreporter.extras.FlytrapExtras;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.hardware.NetworkConnectionChanged;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: update_available */
public class FbandroidFlytrapExtras implements FlytrapExtras {
    private static volatile FbandroidFlytrapExtras f928f;
    private final StatFsHelper f929a;
    private final PackageManager f930b;
    private final ActivityNameFormatter f931c;
    private final FbNetworkManager f932d;
    private final FeedPerfLogger f933e;

    public static com.facebook.katana.features.bugreporter.FbandroidFlytrapExtras m978a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f928f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.features.bugreporter.FbandroidFlytrapExtras.class;
        monitor-enter(r1);
        r0 = f928f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m979b(r0);	 Catch:{ all -> 0x0035 }
        f928f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f928f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.features.bugreporter.FbandroidFlytrapExtras.a(com.facebook.inject.InjectorLike):com.facebook.katana.features.bugreporter.FbandroidFlytrapExtras");
    }

    private static FbandroidFlytrapExtras m979b(InjectorLike injectorLike) {
        return new FbandroidFlytrapExtras(StatFsHelperMethodAutoProvider.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), ActivityNameFormatter.a(injectorLike), FbNetworkManager.a(injectorLike), FeedPerfLogger.a(injectorLike));
    }

    @Inject
    public FbandroidFlytrapExtras(StatFsHelper statFsHelper, PackageManager packageManager, ActivityNameFormatter activityNameFormatter, FbNetworkManager fbNetworkManager, FeedPerfLogger feedPerfLogger) {
        this.f929a = statFsHelper;
        this.f930b = packageManager;
        this.f931c = activityNameFormatter;
        this.f932d = fbNetworkManager;
        this.f933e = feedPerfLogger;
    }

    public final Map<String, String> m980a(Context context) {
        Builder builder = ImmutableMap.builder();
        try {
            builder.b("image_cache_size_bytes", String.valueOf(Long.parseLong(ErrorReporter.getInstance().getCustomData("image_file_bytes"))));
        } catch (NumberFormatException e) {
        }
        long v = this.f933e.v() / 1000;
        builder.b("seconds_since_cold_start", Long.toString(this.f933e.w() / 1000));
        builder.b("seconds_since_warm_start", Long.toString(v));
        if (context instanceof Activity) {
            builder.b("current_activity", ActivityNameFormatter.a((Activity) context));
        }
        builder.b("free_internal_storage_bytes", String.valueOf(this.f929a.a(StorageType.INTERNAL)));
        PackageInfo a = m977a();
        builder.b("first_install_time", String.valueOf(a.firstInstallTime));
        builder.b("last_upgrade_time", String.valueOf(a.lastUpdateTime));
        NetworkConnectionChanged q = this.f932d.q();
        if (q != null) {
            int b = q.b();
            if (b >= 0 && b <= 100) {
                builder.b("inet_cond", String.valueOf(b));
            }
            DetailedState c = q.c();
            if (c != null) {
                builder.b("connection_state", c.toString());
            }
        }
        return builder.b();
    }

    private PackageInfo m977a() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f930b.getPackageInfo(BuildConstants.n(), 0);
        } catch (NameNotFoundException e) {
        } catch (RuntimeException e2) {
        }
        return packageInfo;
    }
}
