package com.facebook.common.errorreporting;

import android.content.Context;
import com.facebook.acra.CustomReportDataSupplier;
import com.facebook.acra.ErrorReporter;
import com.facebook.acra.ErrorReporter.CrashReportType;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.Systrace.EventScope;
import com.facebook.systrace.TraceConfig;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.net.Proxy;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: video_download */
public class FbErrorReporterImpl extends AbstractFbErrorReporter {
    public static final Provider<ErrorReporter> f1212a = new ErrorReporterProvider();
    public static final String f1213b = FbErrorReporterImpl.class.getSimpleName();
    public static boolean f1214j = false;
    private static volatile FbErrorReporterImpl f1215k;
    private final Provider<TriState> f1216c;
    private final Provider<Boolean> f1217d;
    public final ExecutorService f1218e;
    private final Random f1219f;
    public final Provider<ErrorReporter> f1220g;
    public final boolean f1221h;
    private Context f1222i;

    /* compiled from: video_download */
    class ErrorReporterProvider implements Provider<ErrorReporter> {
        public Object get() {
            return ErrorReporter.getInstance();
        }
    }

    public static com.facebook.common.errorreporting.FbErrorReporterImpl m2317a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1215k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.errorreporting.FbErrorReporterImpl.class;
        monitor-enter(r1);
        r0 = f1215k;	 Catch:{ all -> 0x003a }
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
        r0 = m2319b(r0);	 Catch:{ all -> 0x0035 }
        f1215k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1215k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.errorreporting.FbErrorReporterImpl.a(com.facebook.inject.InjectorLike):com.facebook.common.errorreporting.FbErrorReporterImpl");
    }

    private static FbErrorReporterImpl m2319b(InjectorLike injectorLike) {
        return new FbErrorReporterImpl(IdBasedProvider.m1811a(injectorLike, 640), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3922), C0078x79d43729.m2356a(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public static String m2322d(FbErrorReporterImpl fbErrorReporterImpl, SoftError softError) {
        return m2318a(fbErrorReporterImpl, softError.a, softError.e, softError.f);
    }

    private FbErrorReporterImpl(Provider<TriState> provider, Provider<Boolean> provider2, ExecutorService executorService, Random random, Context context) {
        this(provider, provider2, executorService, random, f1212a, false);
        this.f1222i = context;
    }

    private FbErrorReporterImpl(Provider<TriState> provider, Provider<Boolean> provider2, ExecutorService executorService, Random random, Provider<ErrorReporter> provider3, boolean z) {
        this.f1216c = provider;
        this.f1217d = provider2;
        this.f1218e = executorService;
        this.f1219f = random;
        this.f1220g = provider3;
        this.f1221h = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m2330a(boolean r7) {
        /*
        r6 = this;
        r1 = 1;
        r0 = 0;
        r2 = r6.f1222i;
        if (r2 != 0) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        r2 = 0;
        r3 = r6.f1222i;	 Catch:{ IOException -> 0x0020, all -> 0x002a }
        r4 = "soft_errors_pref";
        r5 = 0;
        r2 = r3.openFileOutput(r4, r5);	 Catch:{ IOException -> 0x0020, all -> 0x002a }
        if (r7 == 0) goto L_0x001e;
    L_0x0013:
        r3 = r1;
    L_0x0014:
        r2.write(r3);	 Catch:{ IOException -> 0x0035, all -> 0x002a }
        if (r2 == 0) goto L_0x001c;
    L_0x0019:
        r2.close();	 Catch:{ IOException -> 0x0031 }
    L_0x001c:
        r0 = r1;
        goto L_0x0006;
    L_0x001e:
        r3 = r0;
        goto L_0x0014;
    L_0x0020:
        r1 = move-exception;
        r1 = r2;
    L_0x0022:
        if (r1 == 0) goto L_0x0006;
    L_0x0024:
        r1.close();	 Catch:{ IOException -> 0x0028 }
        goto L_0x0006;
    L_0x0028:
        r1 = move-exception;
        goto L_0x0006;
    L_0x002a:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.close();	 Catch:{ IOException -> 0x0033 }
    L_0x0030:
        throw r0;
    L_0x0031:
        r0 = move-exception;
        goto L_0x001c;
    L_0x0033:
        r1 = move-exception;
        goto L_0x0030;
    L_0x0035:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.errorreporting.FbErrorReporterImpl.a(boolean):boolean");
    }

    public final void mo336a(SoftError softError) {
        String b = m2320b(softError);
        if (b != null) {
            String str = softError.b;
            ExecutorDetour.a(this.f1218e, new 1(this, softError, str, new SoftErrorException(b + " | " + str, softError.c)), -871598467);
        }
    }

    private String m2320b(SoftError softError) {
        if (f1214j) {
            return null;
        }
        Object obj = (this.f1216c.get() == TriState.YES || ((Boolean) this.f1217d.get()).booleanValue()) ? 1 : null;
        if (!softError.d || obj == null) {
            if (TraceConfig.a(256)) {
                Systrace.a(256, "softReport category: " + softError.a + " message: " + softError.b, EventScope.THREAD);
            }
            return softError.a;
        }
        ErrorReporter errorReporter = (ErrorReporter) this.f1220g.get();
        errorReporter.putCustomData("soft_error_message", softError.b);
        BLog.b(f1213b, "category: %s message: %s", new Object[]{softError.a, softError.b});
        errorReporter.uncaughtException(Thread.currentThread(), new RuntimeException("Soft error FAILING HARDER: " + softError.a + ", " + softError.b, softError.c));
        return null;
    }

    public final void mo339a(String str, String str2, String str3) {
        if (!f1214j) {
            if (TraceConfig.a(256)) {
                Systrace.a(256, "StrictModeReport category: " + str + " message: " + str2, EventScope.THREAD);
            }
            ExecutorDetour.a(this.f1218e, new 3(this, str, str2, str3), -1368703998);
        }
    }

    public final void mo340a(String str, String str2, Map<String, String> map) {
        if (!f1214j) {
            if (TraceConfig.a(256)) {
                Systrace.a(256, "runtimeLinterReport category: " + str + " message: " + str2, EventScope.THREAD);
            }
            ExecutorDetour.a(this.f1218e, new 4(this, str, 1, map, str2), -1008594003);
        }
    }

    public final void mo341a(Proxy proxy) {
        ((ErrorReporter) this.f1220g.get()).setReportProxy(proxy);
    }

    public final void mo345c(String str, @Nullable String str2) {
        ((ErrorReporter) this.f1220g.get()).putCustomData(str, str2);
    }

    public final void mo337a(String str) {
        ((ErrorReporter) this.f1220g.get()).removeCustomData(str);
    }

    public final void mo338a(String str, final FbCustomReportDataSupplier fbCustomReportDataSupplier) {
        ((ErrorReporter) this.f1220g.get()).putLazyCustomData(str, new CustomReportDataSupplier(this) {
            final /* synthetic */ FbErrorReporterImpl f2073b;

            public String getCustomData(Throwable th) {
                return fbCustomReportDataSupplier.mo633a(th);
            }
        });
    }

    public final void mo343b(String str) {
        ((ErrorReporter) this.f1220g.get()).removeLazyCustomData(str);
    }

    public final void mo346d(String str) {
        ((ErrorReporter) this.f1220g.get()).registerActivity(str);
    }

    public final void mo344c(String str) {
        ((ErrorReporter) this.f1220g.get()).setUserId(str);
    }

    public final void mo335a() {
        ((ErrorReporter) this.f1220g.get()).checkReportsOfType(new CrashReportType[]{CrashReportType.ANR_REPORT});
    }

    public final void mo342b() {
        ((ErrorReporter) this.f1220g.get()).checkReportsOfType(new CrashReportType[]{CrashReportType.CPUSPIN_REPORT});
    }

    public static String m2318a(FbErrorReporterImpl fbErrorReporterImpl, String str, int i, boolean z) {
        Object obj = (((Boolean) fbErrorReporterImpl.f1217d.get()).booleanValue() || fbErrorReporterImpl.f1216c.get() == TriState.YES) ? 1 : null;
        if (obj != null && !fbErrorReporterImpl.m2321c()) {
            return str;
        }
        if (z) {
            return null;
        }
        if (fbErrorReporterImpl.f1219f.nextInt() % i != 0) {
            return null;
        }
        if (i != 1) {
            return str + " [freq=" + i + "]";
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2321c() {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = r5.f1222i;
        if (r2 != 0) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r2 = 0;
        r3 = r5.f1222i;	 Catch:{ IOException -> 0x001f, all -> 0x0029 }
        r4 = "soft_errors_pref";
        r2 = r3.openFileInput(r4);	 Catch:{ IOException -> 0x001f, all -> 0x0029 }
        r3 = r2.read();	 Catch:{ IOException -> 0x0034, all -> 0x0029 }
        if (r3 != r0) goto L_0x001d;
    L_0x0016:
        if (r2 == 0) goto L_0x001b;
    L_0x0018:
        r2.close();	 Catch:{ IOException -> 0x0030 }
    L_0x001b:
        r1 = r0;
        goto L_0x0006;
    L_0x001d:
        r0 = r1;
        goto L_0x0016;
    L_0x001f:
        r0 = move-exception;
        r0 = r2;
    L_0x0021:
        if (r0 == 0) goto L_0x0006;
    L_0x0023:
        r0.close();	 Catch:{ IOException -> 0x0027 }
        goto L_0x0006;
    L_0x0027:
        r0 = move-exception;
        goto L_0x0006;
    L_0x0029:
        r0 = move-exception;
        if (r2 == 0) goto L_0x002f;
    L_0x002c:
        r2.close();	 Catch:{ IOException -> 0x0032 }
    L_0x002f:
        throw r0;
    L_0x0030:
        r1 = move-exception;
        goto L_0x001b;
    L_0x0032:
        r1 = move-exception;
        goto L_0x002f;
    L_0x0034:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.errorreporting.FbErrorReporterImpl.c():boolean");
    }
}
