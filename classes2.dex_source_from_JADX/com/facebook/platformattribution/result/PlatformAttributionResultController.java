package com.facebook.platformattribution.result;

import android.content.Context;
import android.content.Intent;
import com.facebook.composer.shareintent.ImplicitShareIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: platform_last_time_reply_dialog_seen */
public class PlatformAttributionResultController extends BaseController implements ActivityResultCallback {
    private static volatile PlatformAttributionResultController f9666d;
    private final Context f9667a;
    public final SecureContextHelper f9668b;
    public final Class f9669c;

    public static com.facebook.platformattribution.result.PlatformAttributionResultController m14671a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9666d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platformattribution.result.PlatformAttributionResultController.class;
        monitor-enter(r1);
        r0 = f9666d;	 Catch:{ all -> 0x003a }
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
        r0 = m14672b(r0);	 Catch:{ all -> 0x0035 }
        f9666d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9666d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platformattribution.result.PlatformAttributionResultController.a(com.facebook.inject.InjectorLike):com.facebook.platformattribution.result.PlatformAttributionResultController");
    }

    private static PlatformAttributionResultController m14672b(InjectorLike injectorLike) {
        return new PlatformAttributionResultController((Context) injectorLike.getInstance(Context.class), DefaultSecureContextHelper.m4636a(injectorLike), ImplicitShareIntentHandler.class);
    }

    @Inject
    public PlatformAttributionResultController(Context context, SecureContextHelper secureContextHelper, Class cls) {
        this.f9667a = context;
        this.f9668b = secureContextHelper;
        this.f9669c = cls;
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (i == 1004 && i2 == -1) {
            Context context = this.f9667a;
            if (!(intent == null || intent.getData() == null)) {
                Intent intent2 = new Intent(intent);
                intent2.setClass(context, this.f9669c);
                intent2.setAction("android.intent.action.SEND");
                intent2.putExtra("android.intent.extra.STREAM", intent.getData());
                intent2.setFlags(268435456);
                this.f9668b.mo662a(intent2, context);
            }
        }
    }
}
