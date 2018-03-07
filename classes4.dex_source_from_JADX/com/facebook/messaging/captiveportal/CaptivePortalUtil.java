package com.facebook.messaging.captiveportal;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.locale.Locales;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_most_recent */
public class CaptivePortalUtil {
    private static volatile CaptivePortalUtil f9951d;
    private final FbAppType f9952a;
    private final Locales f9953b;
    private final Provider<Boolean> f9954c;

    public static com.facebook.messaging.captiveportal.CaptivePortalUtil m10328a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9951d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.captiveportal.CaptivePortalUtil.class;
        monitor-enter(r1);
        r0 = f9951d;	 Catch:{ all -> 0x003a }
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
        r0 = m10329b(r0);	 Catch:{ all -> 0x0035 }
        f9951d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9951d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.captiveportal.CaptivePortalUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.captiveportal.CaptivePortalUtil");
    }

    private static CaptivePortalUtil m10329b(InjectorLike injectorLike) {
        return new CaptivePortalUtil((FbAppType) injectorLike.getInstance(FbAppType.class), Locales.a(injectorLike), IdBasedProvider.a(injectorLike, 4122));
    }

    @Inject
    public CaptivePortalUtil(FbAppType fbAppType, Locales locales, Provider<Boolean> provider) {
        this.f9952a = fbAppType;
        this.f9953b = locales;
        this.f9954c = provider;
    }

    public final Uri m10330a() {
        Builder buildUpon = Uri.parse(((Boolean) this.f9954c.get()).booleanValue() ? "http://h.fb.com/" : "http://m.facebook.com/").buildUpon();
        buildUpon.appendQueryParameter("cid", this.f9952a.c());
        buildUpon.appendQueryParameter("locale", this.f9953b.c());
        return buildUpon.build();
    }
}
