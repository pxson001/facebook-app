package com.facebook.ui.dialogs;

import android.content.Intent;
import android.view.MotionEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: commerce_inventory */
public class FbDialogFragmentEventListenerDispatcher {
    private static volatile FbDialogFragmentEventListenerDispatcher f5434c;
    private final Lazy<Set<DialogFragmentEventListener>> f5435a;
    private final Set<DialogFragmentEventListener> f5436b = Sets.c();

    public static com.facebook.ui.dialogs.FbDialogFragmentEventListenerDispatcher m10317a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5434c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.dialogs.FbDialogFragmentEventListenerDispatcher.class;
        monitor-enter(r1);
        r0 = f5434c;	 Catch:{ all -> 0x003a }
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
        r0 = m10318b(r0);	 Catch:{ all -> 0x0035 }
        f5434c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5434c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.dialogs.FbDialogFragmentEventListenerDispatcher.a(com.facebook.inject.InjectorLike):com.facebook.ui.dialogs.FbDialogFragmentEventListenerDispatcher");
    }

    private static FbDialogFragmentEventListenerDispatcher m10318b(InjectorLike injectorLike) {
        return new FbDialogFragmentEventListenerDispatcher(ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$DialogFragmentEventListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public FbDialogFragmentEventListenerDispatcher(Lazy<Set<DialogFragmentEventListener>> lazy) {
        this.f5435a = lazy;
    }

    public final void m10321a(AbstractDialogFragmentEventListener abstractDialogFragmentEventListener) {
        synchronized (this.f5436b) {
            this.f5436b.add(abstractDialogFragmentEventListener);
        }
    }

    public final void m10323b(AbstractDialogFragmentEventListener abstractDialogFragmentEventListener) {
        synchronized (this.f5436b) {
            this.f5436b.remove(abstractDialogFragmentEventListener);
        }
    }

    public final void m10320a(MotionEvent motionEvent) {
        for (AbstractDialogFragmentEventListener a : (Set) this.f5435a.get()) {
            a.mo483a(motionEvent);
        }
        synchronized (this.f5436b) {
            for (AbstractDialogFragmentEventListener a2 : this.f5436b) {
                a2.mo483a(motionEvent);
            }
        }
    }

    public final void m10322a(FbDialogFragment fbDialogFragment) {
        for (AbstractDialogFragmentEventListener a : (Set) this.f5435a.get()) {
            a.mo484a(fbDialogFragment);
        }
        synchronized (this.f5436b) {
            for (AbstractDialogFragmentEventListener a2 : this.f5436b) {
                a2.mo484a(fbDialogFragment);
            }
        }
    }

    public final void m10324b(FbDialogFragment fbDialogFragment) {
        for (AbstractDialogFragmentEventListener b : (Set) this.f5435a.get()) {
            b.mo485b(fbDialogFragment);
        }
        synchronized (this.f5436b) {
            for (AbstractDialogFragmentEventListener b2 : this.f5436b) {
                b2.mo485b(fbDialogFragment);
            }
        }
    }

    public final void m10319a(int i, int i2, Intent intent) {
        for (AbstractDialogFragmentEventListener a : (Set) this.f5435a.get()) {
            a.m2564a(i, i2, intent);
        }
        synchronized (this.f5436b) {
            for (AbstractDialogFragmentEventListener a2 : this.f5436b) {
                a2.m2564a(i, i2, intent);
            }
        }
    }
}
