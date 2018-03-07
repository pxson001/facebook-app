package com.facebook.analytics.useractions.filters;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.useractions.ProxyEventListener;
import com.facebook.analytics.useractions.utils.ListenerGetter;
import com.facebook.analytics.useractions.utils.UserActionEventLog;
import com.facebook.analytics.useractions.utils.UserActionType;
import com.facebook.analytics.useractions.utils.ViewHierarchyMap;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ticket_redemption_note */
public class OnClickProxyEventListener extends ProxyEventListener implements OnClickListener {
    private static volatile OnClickProxyEventListener f1922f;
    private final ListenerGetter f1923a;
    private final UserActionEventLog f1924b;
    private final ViewHierarchyMap f1925c;
    private final SparseArray<OnClickListener> f1926d = new SparseArray();
    private final Set<View> f1927e = Sets.a();

    public static com.facebook.analytics.useractions.filters.OnClickProxyEventListener m2604a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1922f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.useractions.filters.OnClickProxyEventListener.class;
        monitor-enter(r1);
        r0 = f1922f;	 Catch:{ all -> 0x003a }
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
        r0 = m2605b(r0);	 Catch:{ all -> 0x0035 }
        f1922f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1922f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.useractions.filters.OnClickProxyEventListener.a(com.facebook.inject.InjectorLike):com.facebook.analytics.useractions.filters.OnClickProxyEventListener");
    }

    private static OnClickProxyEventListener m2605b(InjectorLike injectorLike) {
        return new OnClickProxyEventListener(UserActionEventLog.m2609a(injectorLike), ListenerGetter.m2607a(injectorLike), ViewHierarchyMap.m2616a(injectorLike));
    }

    @Inject
    public OnClickProxyEventListener(UserActionEventLog userActionEventLog, ListenerGetter listenerGetter, ViewHierarchyMap viewHierarchyMap) {
        this.f1923a = listenerGetter;
        this.f1924b = userActionEventLog;
        this.f1925c = viewHierarchyMap;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 823001328);
        String str = (String) this.f1925c.f1937b.get(view);
        Integer.valueOf(view.hashCode());
        OnClickListener onClickListener = (OnClickListener) this.f1926d.get(view.hashCode());
        if (onClickListener != null) {
            onClickListener.onClick(view);
        } else {
            Integer.valueOf(view.getId());
        }
        this.f1924b.m2614a(UserActionType.BUTTON_CLICK, str);
        LogUtils.a(-1181526787, a);
    }
}
