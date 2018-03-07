package com.facebook.directinstall.feed;

import android.app.Activity;
import android.content.Context;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.uri.NativeAppDetails;
import com.facebook.directinstall.appdetails.DirectInstaller;
import com.facebook.directinstall.intent.DirectInstallAppData;
import com.facebook.directinstall.logging.DirectInstallLogger;
import com.facebook.directinstall.util.DirectInstallApplicationUtils;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: on the fly sticker asset download failed. */
public class DirectInstallHandler implements DirectInstaller {
    public static final String f8751a = DirectInstallHandler.class.getSimpleName();
    private static volatile DirectInstallHandler f8752f;
    private final DirectInstallExperiments f8753b;
    private final DirectInstallLogger f8754c;
    private final NavigationLogger f8755d;
    private Context f8756e;

    public static com.facebook.directinstall.feed.DirectInstallHandler m12523a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8752f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.directinstall.feed.DirectInstallHandler.class;
        monitor-enter(r1);
        r0 = f8752f;	 Catch:{ all -> 0x003a }
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
        r0 = m12524b(r0);	 Catch:{ all -> 0x0035 }
        f8752f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8752f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.directinstall.feed.DirectInstallHandler.a(com.facebook.inject.InjectorLike):com.facebook.directinstall.feed.DirectInstallHandler");
    }

    private static DirectInstallHandler m12524b(InjectorLike injectorLike) {
        return new DirectInstallHandler(new DirectInstallExperiments(IdBasedProvider.a(injectorLike, 665), IdBasedProvider.a(injectorLike, 666)), DirectInstallLogger.m12558a(injectorLike), NavigationLogger.a(injectorLike));
    }

    @Inject
    public DirectInstallHandler(DirectInstallExperiments directInstallExperiments, DirectInstallLogger directInstallLogger, NavigationLogger navigationLogger) {
        this.f8753b = directInstallExperiments;
        this.f8754c = directInstallLogger;
        this.f8755d = navigationLogger;
    }

    public final boolean mo961a(Context context, DirectInstallAppData directInstallAppData, Map<String, Object> map) {
        this.f8755d.a(this.f8756e instanceof Activity ? (Activity) this.f8756e : null, null, "neko_di_dialog", null, null);
        NativeAppDetails a = DirectInstallApplicationUtils.a(directInstallAppData, map);
        if (!(a == null || !a.a() || a.i == null)) {
            this.f8756e = context;
            if (this.f8756e instanceof InstallDialogActivity) {
                ((InstallDialogActivity) this.f8756e).finish();
            }
        }
        return false;
    }
}
