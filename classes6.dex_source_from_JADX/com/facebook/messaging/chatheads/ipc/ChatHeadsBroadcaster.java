package com.facebook.messaging.chatheads.ipc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.build.SignatureType;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: video_items_removed */
public class ChatHeadsBroadcaster {
    private static volatile ChatHeadsBroadcaster f735i;
    public final Context f736a;
    private final Provider<String> f737b;
    public final PackageManager f738c;
    private final DefaultAppChoreographer f739d;
    public final Product f740e;
    public SignatureType f741f;
    public boolean f742g;
    @Nullable
    public ListenableFuture<?> f743h;

    /* compiled from: video_items_removed */
    public class C00742 implements FutureCallback<T> {
        final /* synthetic */ ChatHeadsBroadcaster f734a;

        public C00742(ChatHeadsBroadcaster chatHeadsBroadcaster) {
            this.f734a = chatHeadsBroadcaster;
        }

        public void onSuccess(@Nullable T t) {
            this.f734a.f743h = null;
        }

        public void onFailure(Throwable th) {
        }
    }

    public static com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster m748a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f735i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster.class;
        monitor-enter(r1);
        r0 = f735i;	 Catch:{ all -> 0x003a }
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
        r0 = m751b(r0);	 Catch:{ all -> 0x0035 }
        f735i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f735i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster.a(com.facebook.inject.InjectorLike):com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster");
    }

    private static ChatHeadsBroadcaster m751b(InjectorLike injectorLike) {
        return new ChatHeadsBroadcaster((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4442), SignatureTypeMethodAutoProvider.b(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), DefaultAppChoreographer.a(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ChatHeadsBroadcaster(Context context, Provider<String> provider, SignatureType signatureType, PackageManager packageManager, AppChoreographer appChoreographer, Product product) {
        this.f736a = context;
        this.f737b = provider;
        this.f741f = signatureType;
        this.f738c = packageManager;
        this.f739d = appChoreographer;
        this.f740e = product;
    }

    public final void m752a() {
        m750a(true, null);
    }

    public final void m753a(String str) {
        m750a(false, str);
    }

    public final void m754b() {
        m749a(new Intent(ChatHeadsIntent.j));
    }

    public final void m755c() {
        m749a(new Intent(ChatHeadsIntent.E));
    }

    public final void m756d() {
        m749a(new Intent(ChatHeadsIntent.D));
    }

    private ListenableFuture<?> m749a(final Intent intent) {
        intent.putExtra(ChatHeadsIntent.m, (String) this.f737b.get());
        int i = 0;
        if (!this.f738c.queryBroadcastReceivers(intent, 0).isEmpty()) {
            i = 1;
        }
        if (i == 0) {
            return Futures.a();
        }
        Object obj;
        Object obj2;
        if (this.f740e == Product.MESSENGER) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || (this.f742g && !intent.getAction().equals(ChatHeadsIntent.i))) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            return this.f739d.a("ChatHeadsInitializer initAfterUiIdle", new Runnable(this) {
                final /* synthetic */ ChatHeadsBroadcaster f733b;

                public void run() {
                    this.f733b.f736a.sendOrderedBroadcast(intent, this.f733b.f741f.getPermission());
                    this.f733b.f742g = true;
                }
            }, Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.BACKGROUND);
        }
        this.f736a.sendOrderedBroadcast(intent, this.f741f.getPermission());
        return Futures.a(null);
    }

    private void m750a(boolean z, @Nullable String str) {
        if (this.f743h != null) {
            this.f743h.cancel(false);
            this.f743h = null;
        }
        Intent intent = new Intent(z ? ChatHeadsIntent.k : ChatHeadsIntent.i);
        if (str != null) {
            intent.putExtra(ChatHeadsIntent.o, str);
        }
        ListenableFuture a = m749a(intent);
        if (!a.isDone()) {
            this.f743h = a;
            Futures.a(a, new C00742(this), DirectExecutor.INSTANCE);
        }
    }
}
