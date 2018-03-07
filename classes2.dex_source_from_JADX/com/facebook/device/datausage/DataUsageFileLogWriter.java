package com.facebook.device.datausage;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.Handler;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(9)
/* compiled from: notifications_view */
public class DataUsageFileLogWriter {
    private static final Class<?> f12077a = DataUsageFileLogWriter.class;
    private static volatile DataUsageFileLogWriter f12078e;
    private final FbSharedPreferences f12079b;
    private final Handler f12080c;
    public File f12081d;

    public static com.facebook.device.datausage.DataUsageFileLogWriter m17789a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12078e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.datausage.DataUsageFileLogWriter.class;
        monitor-enter(r1);
        r0 = f12078e;	 Catch:{ all -> 0x003a }
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
        r0 = m17790b(r0);	 Catch:{ all -> 0x0035 }
        f12078e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12078e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.datausage.DataUsageFileLogWriter.a(com.facebook.inject.InjectorLike):com.facebook.device.datausage.DataUsageFileLogWriter");
    }

    private static DataUsageFileLogWriter m17790b(InjectorLike injectorLike) {
        return new DataUsageFileLogWriter(Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public DataUsageFileLogWriter(Handler handler, FbSharedPreferences fbSharedPreferences) {
        this.f12080c = handler;
        this.f12079b = fbSharedPreferences;
    }

    public final void m17792a(String str) {
        if (this.f12079b.mo286a(DataUsagePreferenceConstants.f17619b, false)) {
            if (this.f12081d == null) {
                this.f12081d = new File(Environment.getExternalStorageDirectory(), "dsm_employee_logging.txt");
                m17791b("--- cold start ---");
            }
            m17791b(str);
        }
    }

    private void m17791b(String str) {
        HandlerDetour.a(this.f12080c, new 1(this, str), -192726246);
    }
}
