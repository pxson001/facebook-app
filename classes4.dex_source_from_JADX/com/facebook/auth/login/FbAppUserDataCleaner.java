package com.facebook.auth.login;

import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.privacy.STATICDI_MULTIBIND_PROVIDER$IHaveUserData;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: system brightness mode is unknown */
public class FbAppUserDataCleaner extends AbstractAuthComponent {
    private static volatile FbAppUserDataCleaner f1383e;
    private final Class<?> f1384a = FbAppUserDataCleaner.class;
    private final DefaultAndroidThreadUtil f1385b;
    private final Set<IHaveUserData> f1386c;
    private final AbstractFbErrorReporter f1387d;

    public static com.facebook.auth.login.FbAppUserDataCleaner m1623a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1383e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.auth.login.FbAppUserDataCleaner.class;
        monitor-enter(r1);
        r0 = f1383e;	 Catch:{ all -> 0x003a }
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
        r0 = m1625b(r0);	 Catch:{ all -> 0x0035 }
        f1383e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1383e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.login.FbAppUserDataCleaner.a(com.facebook.inject.InjectorLike):com.facebook.auth.login.FbAppUserDataCleaner");
    }

    private static FbAppUserDataCleaner m1625b(InjectorLike injectorLike) {
        return new FbAppUserDataCleaner(DefaultAndroidThreadUtil.b(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$IHaveUserData(injectorLike)), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public FbAppUserDataCleaner(AndroidThreadUtil androidThreadUtil, Set<IHaveUserData> set, FbErrorReporter fbErrorReporter) {
        this.f1385b = androidThreadUtil;
        this.f1386c = set;
        this.f1387d = fbErrorReporter;
    }

    public final void m1626f() {
        this.f1385b.b();
        RuntimeException runtimeException = null;
        for (IHaveUserData iHaveUserData : this.f1386c) {
            try {
                m1624a(iHaveUserData.getClass().getName(), new 1(this, iHaveUserData));
            } catch (RuntimeException e) {
                RuntimeException e2 = e;
                if (runtimeException != null) {
                    e2 = runtimeException;
                }
                runtimeException = e2;
            }
        }
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    private void m1624a(String str, 1 1) {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder();
        RuntimeException runtimeException = null;
        int i = 0;
        while (i <= 2) {
            try {
                1.a();
                obj = 1;
                break;
            } catch (RuntimeException e) {
                stringBuilder.append(e.toString());
                Writer stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                stringBuilder.append(stringWriter.toString());
                if (runtimeException == null) {
                    runtimeException = e;
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e2) {
                }
                i++;
            }
        }
        if (obj != null && stringBuilder.length() == 0) {
            return;
        }
        if (obj != null) {
            String str2 = "clearInternal-recovered-" + str;
            String str3 = "Hit exceptions before successfully clearing: " + stringBuilder.toString();
            this.f1387d.a(str2, str3);
            BLog.b(str2, str3);
            return;
        }
        str2 = "clearInternal-failed-" + str;
        String str4 = "All retries failed for clearing: " + stringBuilder.toString();
        this.f1387d.a(str2, str4);
        BLog.b(str2, str4);
        throw runtimeException;
    }
}
