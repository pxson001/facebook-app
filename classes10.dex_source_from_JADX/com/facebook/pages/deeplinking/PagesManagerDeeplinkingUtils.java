package com.facebook.pages.deeplinking;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.config.versioninfo.VersionStringComparator;
import com.facebook.config.versioninfo.module.VersionStringComparatorMethodAutoProvider;
import com.facebook.content.AppInfo;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.PagesManagerLoggedInUserUtils;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mErrorData */
public class PagesManagerDeeplinkingUtils {
    public static final Config f8370a = new Config(false, false);
    private static volatile PagesManagerDeeplinkingUtils f8371g;
    public final AppInfo f8372b;
    public final Provider<String> f8373c;
    public final PagesManagerLoggedInUserUtils f8374d;
    public final AnalyticsLogger f8375e;
    public final VersionStringComparator f8376f;

    @Immutable
    /* compiled from: mErrorData */
    public class Config {
        public final boolean f8368a;
        public final boolean f8369b;

        public Config(boolean z, boolean z2) {
            this.f8368a = z;
            this.f8369b = z2;
        }
    }

    public static com.facebook.pages.deeplinking.PagesManagerDeeplinkingUtils m8330a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8371g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.deeplinking.PagesManagerDeeplinkingUtils.class;
        monitor-enter(r1);
        r0 = f8371g;	 Catch:{ all -> 0x003a }
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
        r0 = m8331b(r0);	 Catch:{ all -> 0x0035 }
        f8371g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8371g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.deeplinking.PagesManagerDeeplinkingUtils.a(com.facebook.inject.InjectorLike):com.facebook.pages.deeplinking.PagesManagerDeeplinkingUtils");
    }

    private static PagesManagerDeeplinkingUtils m8331b(InjectorLike injectorLike) {
        return new PagesManagerDeeplinkingUtils(AppInfo.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), PagesManagerLoggedInUserUtils.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), VersionStringComparatorMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PagesManagerDeeplinkingUtils(AppInfo appInfo, Provider<String> provider, PagesManagerLoggedInUserUtils pagesManagerLoggedInUserUtils, AnalyticsLogger analyticsLogger, VersionStringComparator versionStringComparator) {
        this.f8372b = appInfo;
        this.f8373c = provider;
        this.f8374d = pagesManagerLoggedInUserUtils;
        this.f8375e = analyticsLogger;
        this.f8376f = versionStringComparator;
    }
}
