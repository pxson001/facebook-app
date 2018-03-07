package com.facebook.crypto.module;

import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sync_snap_to_first_sync_time */
public class LoggedInUserCrypto$AuthListener extends AbstractAuthComponent {
    private static final String f1412a = LoggedInUserCrypto$AuthListener.class.getName();
    private static volatile LoggedInUserCrypto$AuthListener f1413e;
    private final LoggedInUserCrypto f1414b;
    private final AbstractFbErrorReporter f1415c;
    private final LocalStatsLoggerImpl f1416d;

    public static com.facebook.crypto.module.LoggedInUserCrypto$AuthListener m1653a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1413e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crypto.module.LoggedInUserCrypto$AuthListener.class;
        monitor-enter(r1);
        r0 = f1413e;	 Catch:{ all -> 0x003a }
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
        r0 = m1654b(r0);	 Catch:{ all -> 0x0035 }
        f1413e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1413e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crypto.module.LoggedInUserCrypto$AuthListener.a(com.facebook.inject.InjectorLike):com.facebook.crypto.module.LoggedInUserCrypto$AuthListener");
    }

    private static LoggedInUserCrypto$AuthListener m1654b(InjectorLike injectorLike) {
        return new LoggedInUserCrypto$AuthListener(LoggedInUserCryptoMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LoggedInUserCrypto$AuthListener(LoggedInUserCrypto loggedInUserCrypto, AbstractFbErrorReporter abstractFbErrorReporter, LocalStatsLoggerImpl localStatsLoggerImpl) {
        this.f1414b = loggedInUserCrypto;
        this.f1415c = abstractFbErrorReporter;
        this.f1416d = localStatsLoggerImpl;
    }

    public final void m1655a(@Nullable AuthenticationResult authenticationResult) {
        if (authenticationResult == null) {
            this.f1415c.a(f1412a, "AuthenticationResult is null");
            this.f1416d.a(10027017);
            LoggedInUserCrypto.b(this.f1414b);
            return;
        }
        LoggedInUserCrypto.a(this.f1414b, authenticationResult);
    }

    public final void m1656g() {
        this.f1416d.a(10027010);
        LoggedInUserCrypto.b(this.f1414b);
    }
}
