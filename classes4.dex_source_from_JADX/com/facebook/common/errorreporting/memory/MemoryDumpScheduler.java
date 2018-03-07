package com.facebook.common.errorreporting.memory;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.fileupload.FileUploadUtils;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mention */
public class MemoryDumpScheduler implements INeedInit {
    @VisibleForTesting
    static final PrefKey f8130a;
    private static final PrefKey f8131b;
    private static volatile MemoryDumpScheduler f8132m;
    private final Context f8133c;
    private final SecureContextHelper f8134d;
    private final MemoryDumpingGatekeepers f8135e;
    private final MemoryDumpCleaner f8136f;
    private final FileUploadUtils f8137g;
    private final ScheduledExecutorService f8138h;
    public final MemoryDumper f8139i;
    private final HprofRunnable f8140j = new HprofRunnable(this);
    public final Clock f8141k;
    private final FbSharedPreferences f8142l;

    @VisibleForTesting
    /* compiled from: mention */
    class HprofRunnable implements Runnable {
        final /* synthetic */ MemoryDumpScheduler f8145a;

        HprofRunnable(MemoryDumpScheduler memoryDumpScheduler) {
            this.f8145a = memoryDumpScheduler;
        }

        public void run() {
            Runtime.getRuntime().gc();
            this.f8145a.f8139i.a("daily");
            MemoryDumpScheduler.m8411a(this.f8145a, this.f8145a.f8141k.a() + 86400000);
        }
    }

    public static com.facebook.common.errorreporting.memory.MemoryDumpScheduler m8409a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8132m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.errorreporting.memory.MemoryDumpScheduler.class;
        monitor-enter(r1);
        r0 = f8132m;	 Catch:{ all -> 0x003a }
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
        r0 = m8412b(r0);	 Catch:{ all -> 0x0035 }
        f8132m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8132m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.errorreporting.memory.MemoryDumpScheduler.a(com.facebook.inject.InjectorLike):com.facebook.common.errorreporting.memory.MemoryDumpScheduler");
    }

    private static MemoryDumpScheduler m8412b(InjectorLike injectorLike) {
        return new MemoryDumpScheduler((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), MemoryDumpingGatekeepers.a(injectorLike), new MemoryDumpCleaner(FileUploadUtils.a(injectorLike)), FileUploadUtils.a(injectorLike), MemoryDumper.a(injectorLike), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("hprof/");
        f8131b = prefKey;
        f8130a = (PrefKey) prefKey.a("next/");
    }

    @Inject
    public MemoryDumpScheduler(Context context, SecureContextHelper secureContextHelper, MemoryDumpingGatekeepers memoryDumpingGatekeepers, MemoryDumpCleaner memoryDumpCleaner, FileUploadUtils fileUploadUtils, MemoryDumper memoryDumper, ScheduledExecutorService scheduledExecutorService, Clock clock, FbSharedPreferences fbSharedPreferences) {
        this.f8139i = memoryDumper;
        this.f8138h = scheduledExecutorService;
        this.f8141k = clock;
        this.f8142l = fbSharedPreferences;
        this.f8133c = context;
        this.f8134d = secureContextHelper;
        this.f8135e = memoryDumpingGatekeepers;
        this.f8136f = memoryDumpCleaner;
        this.f8137g = fileUploadUtils;
    }

    public void init() {
        if (this.f8135e.a.a(92, false)) {
            m8410a();
        }
        if (this.f8135e.c()) {
            this.f8134d.c(new Intent(this.f8133c, MemoryDumpUploadService.class), this.f8133c);
            return;
        }
        MemoryDumpCleaner memoryDumpCleaner = this.f8136f;
        File[] a = memoryDumpCleaner.f8144b.a(FileUploadUtils.b(), MemoryDumpConstants.f9939a);
        if (a != null && a.length > 3) {
            Arrays.sort(a);
            for (int i = 0; i < a.length - 3; i++) {
                a[i].delete();
            }
        }
    }

    private void m8410a() {
        long a = this.f8141k.a();
        long max = Math.max(60000, this.f8142l.a(f8130a, a + 86400000) - a);
        this.f8138h.scheduleWithFixedDelay(this.f8140j, max, 86400000, TimeUnit.MILLISECONDS);
        m8411a(this, a + max);
    }

    public static void m8411a(MemoryDumpScheduler memoryDumpScheduler, long j) {
        Editor edit = memoryDumpScheduler.f8142l.edit();
        edit.a(f8130a, j);
        edit.commit();
    }
}
