package com.facebook.messaging.linkhandling;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onChange */
public class LinkHandlingHelper {
    private static volatile LinkHandlingHelper f7840d;
    private final SecureContextHelper f7841a;
    private final Lazy<Toaster> f7842b;
    private final Lazy<FbErrorReporter> f7843c;

    public static com.facebook.messaging.linkhandling.LinkHandlingHelper m9456a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7840d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.linkhandling.LinkHandlingHelper.class;
        monitor-enter(r1);
        r0 = f7840d;	 Catch:{ all -> 0x003a }
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
        r0 = m9457b(r0);	 Catch:{ all -> 0x0035 }
        f7840d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7840d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.linkhandling.LinkHandlingHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.linkhandling.LinkHandlingHelper");
    }

    private static LinkHandlingHelper m9457b(InjectorLike injectorLike) {
        return new LinkHandlingHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public LinkHandlingHelper(SecureContextHelper secureContextHelper, Lazy<Toaster> lazy, Lazy<FbErrorReporter> lazy2) {
        this.f7841a = secureContextHelper;
        this.f7842b = lazy;
        this.f7843c = lazy2;
    }

    public final void m9458a(Context context, Uri uri) {
        Intent intent = null;
        if (NativeThirdPartyUriHelper.a(uri)) {
            intent = NativeThirdPartyUriHelper.d(context, uri);
            if (intent == null) {
                intent = NativeThirdPartyUriHelper.e(context, uri);
            }
        }
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
        }
        Intent intent2 = intent;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || intent2.resolveActivity(packageManager) == null) {
            ((Toaster) this.f7842b.get()).a(new ToastBuilder(2131238119));
            ((AbstractFbErrorReporter) this.f7843c.get()).a("ActivityNotFoundForLink", intent2.toString());
            return;
        }
        this.f7841a.b(intent2, context);
    }
}
