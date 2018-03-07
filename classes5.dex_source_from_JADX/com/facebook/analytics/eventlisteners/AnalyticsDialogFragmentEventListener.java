package com.facebook.analytics.eventlisteners;

import android.view.MotionEvent;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.dialogs.AbstractDialogFragmentEventListener;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timeline_friends_list */
public class AnalyticsDialogFragmentEventListener extends AbstractDialogFragmentEventListener {
    private static volatile AnalyticsDialogFragmentEventListener f1892c;
    private final InteractionEventListenerDispatcher f1893a;
    private final AnalyticsNavigationListenerDispatcher f1894b;

    public static com.facebook.analytics.eventlisteners.AnalyticsDialogFragmentEventListener m2568a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1892c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.eventlisteners.AnalyticsDialogFragmentEventListener.class;
        monitor-enter(r1);
        r0 = f1892c;	 Catch:{ all -> 0x003a }
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
        r0 = m2569b(r0);	 Catch:{ all -> 0x0035 }
        f1892c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1892c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.eventlisteners.AnalyticsDialogFragmentEventListener.a(com.facebook.inject.InjectorLike):com.facebook.analytics.eventlisteners.AnalyticsDialogFragmentEventListener");
    }

    private static AnalyticsDialogFragmentEventListener m2569b(InjectorLike injectorLike) {
        return new AnalyticsDialogFragmentEventListener(InteractionEventListenerDispatcher.a(injectorLike), AnalyticsNavigationListenerDispatcher.m2573a(injectorLike));
    }

    @Inject
    public AnalyticsDialogFragmentEventListener(InteractionEventListenerDispatcher interactionEventListenerDispatcher, AnalyticsNavigationListenerDispatcher analyticsNavigationListenerDispatcher) {
        this.f1894b = analyticsNavigationListenerDispatcher;
        this.f1893a = interactionEventListenerDispatcher;
    }

    public final void mo483a(MotionEvent motionEvent) {
        InteractionEventListenerDispatcher interactionEventListenerDispatcher = this.f1893a;
        long a = interactionEventListenerDispatcher.b.a();
        for (AnalyticsEventListener a2 : (Set) interactionEventListenerDispatcher.a.get()) {
            a2.a(a);
        }
    }

    public final void mo484a(FbDialogFragment fbDialogFragment) {
        String str = "dialog";
        Map c = Maps.c();
        c.put("dest_module_class", fbDialogFragment.getClass().getSimpleName());
        if (fbDialogFragment instanceof AnalyticsFragment) {
            str = ((AnalyticsFragment) fbDialogFragment).am_();
            if (fbDialogFragment instanceof AnalyticsFragmentWithExtraData) {
                c.putAll(((AnalyticsFragmentWithExtraData) fbDialogFragment).c());
            }
        }
        for (NavigationLogger a : (Set) this.f1894b.f1896a.get()) {
            a.a(str, true, c);
        }
    }

    public final void mo485b(FbDialogFragment fbDialogFragment) {
        String str = "dialog";
        Map c = Maps.c();
        c.put("source_module_class", fbDialogFragment.getClass().getSimpleName());
        if (fbDialogFragment instanceof AnalyticsFragment) {
            str = ((AnalyticsFragment) fbDialogFragment).am_();
            if (fbDialogFragment instanceof AnalyticsFragmentWithExtraData) {
                c.putAll(((AnalyticsFragmentWithExtraData) fbDialogFragment).c());
            }
        }
        for (NavigationLogger a : (Set) this.f1894b.f1896a.get()) {
            a.a(str, c);
        }
    }
}
