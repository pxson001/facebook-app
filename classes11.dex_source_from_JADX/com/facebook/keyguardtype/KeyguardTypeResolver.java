package com.facebook.keyguardtype;

import android.app.KeyguardManager;
import com.facebook.common.android.KeyguardManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Unknown view type */
public class KeyguardTypeResolver {
    private static final Class<?> f10418a = KeyguardTypeResolver.class;
    private static volatile KeyguardTypeResolver f10419g;
    private final KeyguardManager f10420b;
    private final PatternKeyguardTypeResolver f10421c;
    private final SecureSettingsKeyguardTypeResolver f10422d;
    private final LockSettingsServiceKeyguardTypeResolver f10423e;
    private final AbstractFbErrorReporter f10424f;

    public static com.facebook.keyguardtype.KeyguardTypeResolver m10823a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10419g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.keyguardtype.KeyguardTypeResolver.class;
        monitor-enter(r1);
        r0 = f10419g;	 Catch:{ all -> 0x003a }
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
        r0 = m10824b(r0);	 Catch:{ all -> 0x0035 }
        f10419g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10419g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.keyguardtype.KeyguardTypeResolver.a(com.facebook.inject.InjectorLike):com.facebook.keyguardtype.KeyguardTypeResolver");
    }

    private static KeyguardTypeResolver m10824b(InjectorLike injectorLike) {
        return new KeyguardTypeResolver(KeyguardManagerMethodAutoProvider.b(injectorLike), PatternKeyguardTypeResolver.m10827a(injectorLike), SecureSettingsKeyguardTypeResolver.m10829a(injectorLike), LockSettingsServiceKeyguardTypeResolver.m10825a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public KeyguardTypeResolver(KeyguardManager keyguardManager, PatternKeyguardTypeResolver patternKeyguardTypeResolver, SecureSettingsKeyguardTypeResolver secureSettingsKeyguardTypeResolver, LockSettingsServiceKeyguardTypeResolver lockSettingsServiceKeyguardTypeResolver, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10420b = keyguardManager;
        this.f10421c = patternKeyguardTypeResolver;
        this.f10422d = secureSettingsKeyguardTypeResolver;
        this.f10423e = lockSettingsServiceKeyguardTypeResolver;
        this.f10424f = abstractFbErrorReporter;
    }
}
