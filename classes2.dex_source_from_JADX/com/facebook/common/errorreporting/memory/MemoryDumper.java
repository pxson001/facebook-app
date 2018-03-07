package com.facebook.common.errorreporting.memory;

import android.os.Debug;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.fileupload.FileUploadUtils;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Throwables;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: video_home_force_prefetch */
public class MemoryDumper {
    private static volatile MemoryDumper f1186i;
    private final MemoryDumpingGatekeepers f1187a;
    public final VMMemoryInfo f1188b;
    public final StatFsHelper f1189c;
    private final Clock f1190d;
    private final AbstractFbErrorReporter f1191e;
    public final FileUploadUtils f1192f;
    private final MemoryDumpMetadataHandler f1193g;
    private final AppStateManager f1194h;

    public static com.facebook.common.errorreporting.memory.MemoryDumper m2294a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1186i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.errorreporting.memory.MemoryDumper.class;
        monitor-enter(r1);
        r0 = f1186i;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m2296b(r0);	 Catch:{ all -> 0x0035 }
        f1186i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1186i;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.errorreporting.memory.MemoryDumper.a(com.facebook.inject.InjectorLike):com.facebook.common.errorreporting.memory.MemoryDumper");
    }

    private static MemoryDumper m2296b(InjectorLike injectorLike) {
        return new MemoryDumper(MemoryDumpingGatekeepers.m2290a(injectorLike), VMMemoryInfoMethodAutoProvider.m2302a(injectorLike), StatFsHelperMethodAutoProvider.m2307a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FileUploadUtils.m2358a(injectorLike), MemoryDumpMetadataHandler.m2366a(injectorLike), AppStateManager.m2245a(injectorLike));
    }

    @Inject
    public MemoryDumper(MemoryDumpingGatekeepers memoryDumpingGatekeepers, VMMemoryInfo vMMemoryInfo, StatFsHelper statFsHelper, Clock clock, AbstractFbErrorReporter abstractFbErrorReporter, FileUploadUtils fileUploadUtils, MemoryDumpMetadataHandler memoryDumpMetadataHandler, AppStateManager appStateManager) {
        this.f1189c = statFsHelper;
        this.f1187a = memoryDumpingGatekeepers;
        this.f1188b = vMMemoryInfo;
        this.f1190d = clock;
        this.f1191e = abstractFbErrorReporter;
        this.f1192f = fileUploadUtils;
        this.f1193g = memoryDumpMetadataHandler;
        this.f1194h = appStateManager;
    }

    public final void m2300a(String str) {
        try {
            m2297b(str);
        } catch (Throwable th) {
            BLog.a("MemoryDumper", "Error writing Hprof dump", th);
            this.f1191e.mo345c("hprof", "Failed - " + th.getMessage());
        }
    }

    public final void m2301a(Throwable th) {
        try {
            String name = Throwables.getRootCause(th).getClass().getName();
            if (this.f1187a.m2293c()) {
                m2297b(name);
            } else if (this.f1187a.m2292a()) {
                m2298c(name);
            }
        } catch (Throwable th2) {
            BLog.a("MemoryDumper", "Error writing Hprof dump", th2);
            this.f1191e.mo345c("hprof", "Failed - " + th2.getMessage());
        }
    }

    @VisibleForTesting
    private void m2297b(String str) {
        Object obj;
        File[] a = this.f1192f.m2364a(this.f1192f.m2362a(), MemoryDumpConstants.a);
        if (a == null || a.length <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            if (this.f1189c.m2314a(StorageType.INTERNAL) > this.f1188b.f1199e * 3) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                this.f1191e.mo345c("hprof", "Failed - not enough free space");
            } else {
                m2295a(str, this.f1192f.m2362a());
            }
        }
    }

    private void m2298c(String str) {
        m2295a(str, FileUploadUtils.m2361b());
    }

    @VisibleForTesting
    private void m2295a(String str, String str2) {
        try {
            this.f1191e.mo345c("hprof", "Started");
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s_%d", SafeUUIDGenerator.m2795a(), Long.valueOf(this.f1190d.mo211a()));
            String formatStrLocaleSafe2 = StringFormatUtil.formatStrLocaleSafe("%s/dump_%s.hprof", str2, formatStrLocaleSafe);
            this.f1193g.m2371a(formatStrLocaleSafe, str, this.f1194h.m2262j(), this.f1194h.m2265m());
            m2299d(formatStrLocaleSafe2);
            this.f1191e.mo345c("hprof", "Success");
            this.f1191e.mo345c("hprof_id", formatStrLocaleSafe);
        } catch (Throwable e) {
            BLog.a("MemoryDumper", "IOException trying to write Hprof dump", e);
            this.f1191e.mo345c("hprof", "IOException - " + e.getMessage());
        }
    }

    @VisibleForTesting
    private static void m2299d(String str) {
        Debug.dumpHprofData(str);
    }
}
