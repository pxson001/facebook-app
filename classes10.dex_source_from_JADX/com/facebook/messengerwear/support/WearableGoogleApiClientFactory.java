package com.facebook.messengerwear.support;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.wearable.Wearable;
import javax.inject.Singleton;

@Singleton
/* compiled from: phoneid_update */
public class WearableGoogleApiClientFactory {
    private static volatile WearableGoogleApiClientFactory f5104b;
    @Inject
    public Context f5105a;

    public static com.facebook.messengerwear.support.WearableGoogleApiClientFactory m4583a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5104b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messengerwear.support.WearableGoogleApiClientFactory.class;
        monitor-enter(r1);
        r0 = f5104b;	 Catch:{ all -> 0x003a }
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
        r0 = m4584b(r0);	 Catch:{ all -> 0x0035 }
        f5104b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5104b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messengerwear.support.WearableGoogleApiClientFactory.a(com.facebook.inject.InjectorLike):com.facebook.messengerwear.support.WearableGoogleApiClientFactory");
    }

    private static WearableGoogleApiClientFactory m4584b(InjectorLike injectorLike) {
        WearableGoogleApiClientFactory wearableGoogleApiClientFactory = new WearableGoogleApiClientFactory((Context) injectorLike.getInstance(Context.class));
        wearableGoogleApiClientFactory.f5105a = (Context) injectorLike.getInstance(Context.class);
        return wearableGoogleApiClientFactory;
    }

    @Inject
    private WearableGoogleApiClientFactory(Context context) {
        this.f5105a = context;
    }

    public final GoogleApiClient m4585a() {
        return new Builder(this.f5105a).a(Wearable.f13169m).b();
    }
}
