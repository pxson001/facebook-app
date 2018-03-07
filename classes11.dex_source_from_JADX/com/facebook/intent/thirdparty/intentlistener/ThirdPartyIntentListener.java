package com.facebook.intent.thirdparty.intentlistener;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.uri.UriIntentListener;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: VideoPlaylistFragment */
public class ThirdPartyIntentListener implements UriIntentListener {
    private static volatile ThirdPartyIntentListener f10390c;
    private final ApplicationPollerHelper f10391a;
    private final AppInstallHelper f10392b;

    public static com.facebook.intent.thirdparty.intentlistener.ThirdPartyIntentListener m10785a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10390c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.intent.thirdparty.intentlistener.ThirdPartyIntentListener.class;
        monitor-enter(r1);
        r0 = f10390c;	 Catch:{ all -> 0x003a }
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
        r0 = m10786b(r0);	 Catch:{ all -> 0x0035 }
        f10390c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10390c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.intent.thirdparty.intentlistener.ThirdPartyIntentListener.a(com.facebook.inject.InjectorLike):com.facebook.intent.thirdparty.intentlistener.ThirdPartyIntentListener");
    }

    private static ThirdPartyIntentListener m10786b(InjectorLike injectorLike) {
        return new ThirdPartyIntentListener(ApplicationPollerHelper.m10782a(injectorLike), AppInstallHelper.m10779a(injectorLike));
    }

    @Inject
    public ThirdPartyIntentListener(ApplicationPollerHelper applicationPollerHelper, AppInstallHelper appInstallHelper) {
        this.f10391a = applicationPollerHelper;
        this.f10392b = appInstallHelper;
    }

    public final void m10787a(Context context, String str, Intent intent, @Nullable Map<String, Object> map) {
        NativeThirdPartyUriHelper.a(context, intent, map);
        if (this.f10391a != null) {
            this.f10391a.m10784a(intent, map);
        }
        if (this.f10392b != null) {
            this.f10392b.m10781a(intent, map);
        }
    }
}
