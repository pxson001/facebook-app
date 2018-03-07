package com.facebook.notifications.util;

import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.InjectorLike;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.ui.touchlistener.HighlightViewUtil;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: exponential_backoff_base */
public class NotificationsFragmentTouchUtil {
    private static volatile NotificationsFragmentTouchUtil f12556b;
    private TodayExperimentController f12557a;

    public static com.facebook.notifications.util.NotificationsFragmentTouchUtil m13327a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12556b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationsFragmentTouchUtil.class;
        monitor-enter(r1);
        r0 = f12556b;	 Catch:{ all -> 0x003a }
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
        r0 = m13329b(r0);	 Catch:{ all -> 0x0035 }
        f12556b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12556b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationsFragmentTouchUtil.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationsFragmentTouchUtil");
    }

    private static NotificationsFragmentTouchUtil m13329b(InjectorLike injectorLike) {
        return new NotificationsFragmentTouchUtil(TodayExperimentController.a(injectorLike));
    }

    static /* synthetic */ boolean m13328a(NotificationsFragmentTouchUtil notificationsFragmentTouchUtil, MotionEvent motionEvent, ScrollingViewProxy scrollingViewProxy) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            for (int i = 0; i < scrollingViewProxy.p(); i++) {
                View findViewById = scrollingViewProxy.f(i).findViewById(2131567802);
                if (findViewById != null) {
                    findViewById.onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Inject
    public NotificationsFragmentTouchUtil(TodayExperimentController todayExperimentController) {
        this.f12557a = todayExperimentController;
    }

    public final void m13331a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (!this.f12557a.z()) {
            return;
        }
        if (i == 1 || i == 2) {
            for (int i2 = 0; i2 < scrollingViewProxy.p(); i2++) {
                View findViewById = scrollingViewProxy.f(i2).findViewById(2131567802);
                if (findViewById instanceof ViewGroup) {
                    HighlightViewUtil.a((ViewGroup) findViewById, 3);
                }
                if (findViewById instanceof ImageBlockLayout) {
                    HighlightViewUtil.a((ImageBlockLayout) findViewById, 3);
                }
            }
        }
    }

    public final void m13330a(ScrollingViewProxy scrollingViewProxy) {
        if (this.f12557a.z()) {
            if (scrollingViewProxy instanceof ListViewProxy) {
                scrollingViewProxy.a(new StateListDrawable());
            }
            scrollingViewProxy.a(new 1(this, scrollingViewProxy));
        }
    }

    public final void m13332a(ScrollingViewProxy scrollingViewProxy, RecyclerView recyclerView) {
        if (this.f12557a.z()) {
            recyclerView.a(new 2(this, scrollingViewProxy));
        }
    }
}
