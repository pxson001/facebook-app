package com.facebook.resources.impl;

import android.app.Activity;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.IFbResourcesNotRequired;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: structured_survey/last_invitation_impression_ts */
public class StringResourcesActivityListener {
    private static volatile StringResourcesActivityListener f3948c;
    public final SecureContextHelper f3949a;
    private final StringResourcesDelegate f3950b;

    public static com.facebook.resources.impl.StringResourcesActivityListener m6547a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3948c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.StringResourcesActivityListener.class;
        monitor-enter(r1);
        r0 = f3948c;	 Catch:{ all -> 0x003a }
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
        r0 = m6548b(r0);	 Catch:{ all -> 0x0035 }
        f3948c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3948c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.StringResourcesActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.StringResourcesActivityListener");
    }

    private static StringResourcesActivityListener m6548b(InjectorLike injectorLike) {
        return new StringResourcesActivityListener(DefaultSecureContextHelper.m4636a(injectorLike), StringResourcesDelegate.m2562a(injectorLike));
    }

    @Inject
    public StringResourcesActivityListener(SecureContextHelper secureContextHelper, StringResourcesDelegate stringResourcesDelegate) {
        this.f3949a = secureContextHelper;
        this.f3950b = stringResourcesDelegate;
    }

    public final void m6549a(Activity activity) {
        if (activity.getResources() instanceof DownloadedFbResources) {
            this.f3950b.m2582f();
            if (!this.f3950b.m2581e()) {
                Object obj;
                if (activity == null || !IFbResourcesNotRequired.class.isAssignableFrom(activity.getClass())) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    Intent intent = new Intent(activity, WaitingForStringsActivity.class);
                    intent.putExtra("return_intent", activity.getIntent());
                    this.f3949a.mo662a(intent, activity);
                    activity.finish();
                }
            }
        }
    }
}
