package com.facebook.resources.impl;

import com.facebook.common.locale.SupportedLanguages;
import com.facebook.common.locale.SupportedLanguages.Type;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.languages.Fb4aSupportedLanguages;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: threshold_duration_for_feed_discovery */
public class TranslationsPolicyProvider {
    private static volatile TranslationsPolicyProvider f3005c;
    private final SupportedLanguages f3006a;
    public final AtomicReference<Boolean> f3007b = new AtomicReference(Boolean.valueOf(false));

    public static com.facebook.resources.impl.TranslationsPolicyProvider m4956a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3005c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.TranslationsPolicyProvider.class;
        monitor-enter(r1);
        r0 = f3005c;	 Catch:{ all -> 0x003a }
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
        r0 = m4958b(r0);	 Catch:{ all -> 0x0035 }
        f3005c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3005c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.TranslationsPolicyProvider.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.TranslationsPolicyProvider");
    }

    private static TranslationsPolicyProvider m4958b(InjectorLike injectorLike) {
        return new TranslationsPolicyProvider(Fb4aSupportedLanguages.m2617a(injectorLike));
    }

    @Inject
    public TranslationsPolicyProvider(SupportedLanguages supportedLanguages) {
        this.f3006a = supportedLanguages;
    }

    public final boolean m4959a(Locale locale) {
        return m4957a(Type.ASSET, locale);
    }

    public final boolean m4960b(Locale locale) {
        return m4957a(Type.DOWNLOAD, locale) && !((Boolean) this.f3007b.get()).booleanValue();
    }

    private boolean m4957a(Type type, Locale locale) {
        return this.f3006a.mo365a(type).contains(locale.toString());
    }
}
