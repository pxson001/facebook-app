package com.facebook.messaging.chatheads.ipc;

import android.app.Activity;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.chatheads.ipc.ChatHeadsControlActivity.DisplayPolicy;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: qe_id_hashing */
public class ChatHeadsActivityListener {
    private static volatile ChatHeadsActivityListener f8538e;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ChatHeadsBroadcaster> f8539a = UltralightRuntime.f368b;
    private final Provider<Boolean> f8540b;
    private final Product f8541c;
    private Activity f8542d;

    public static com.facebook.messaging.chatheads.ipc.ChatHeadsActivityListener m13083a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8538e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.chatheads.ipc.ChatHeadsActivityListener.class;
        monitor-enter(r1);
        r0 = f8538e;	 Catch:{ all -> 0x003a }
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
        r0 = m13085b(r0);	 Catch:{ all -> 0x0035 }
        f8538e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8538e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.chatheads.ipc.ChatHeadsActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.messaging.chatheads.ipc.ChatHeadsActivityListener");
    }

    private static ChatHeadsActivityListener m13085b(InjectorLike injectorLike) {
        ChatHeadsActivityListener chatHeadsActivityListener = new ChatHeadsActivityListener(IdBasedProvider.m1811a(injectorLike, 4135), ProductMethodAutoProvider.m4524b(injectorLike));
        chatHeadsActivityListener.f8539a = IdBasedSingletonScopeProvider.m1810b(injectorLike, 7712);
        return chatHeadsActivityListener;
    }

    @Inject
    public ChatHeadsActivityListener(Provider<Boolean> provider, Product product) {
        this.f8540b = provider;
        this.f8541c = product;
    }

    public final void m13086a(Activity activity) {
        Object obj = 1;
        if (activity.getParent() == null) {
            if (!(activity instanceof ChatHeadsControlActivity) || ((ChatHeadsControlActivity) activity).m13088a() != DisplayPolicy.SKIP) {
                Object obj2 = (this.f8541c != Product.MESSENGER || ((Boolean) this.f8540b.get()).booleanValue()) ? null : 1;
                if (activity instanceof ChatHeadsControlActivity) {
                    ChatHeadsControlActivity chatHeadsControlActivity = (ChatHeadsControlActivity) activity;
                    if (chatHeadsControlActivity.m13088a() == DisplayPolicy.HIDE) {
                        if (((Boolean) this.f8540b.get()).booleanValue()) {
                            obj = null;
                        }
                        obj2 = obj;
                    } else if (chatHeadsControlActivity.m13088a() == DisplayPolicy.SHOW) {
                        obj2 = null;
                    }
                    if (obj2 == null && this.f8542d != null) {
                        m13084a();
                    }
                }
                if (obj2 != null) {
                    this.f8542d = activity;
                    ((ChatHeadsBroadcaster) this.f8539a.get()).a("activityResumed");
                }
            }
        }
    }

    public final void m13087b(Activity activity) {
        if (this.f8542d == activity) {
            m13084a();
        }
    }

    private void m13084a() {
        this.f8542d = null;
        ((ChatHeadsBroadcaster) this.f8539a.get()).a();
    }
}
