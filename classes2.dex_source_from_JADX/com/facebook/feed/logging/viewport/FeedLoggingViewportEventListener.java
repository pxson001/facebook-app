package com.facebook.feed.logging.viewport;

import android.support.v4.util.SimpleArrayMap;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableMap;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo_reminder_open_picker */
public class FeedLoggingViewportEventListener extends BaseViewportEventListener {
    private static volatile FeedLoggingViewportEventListener f10037c;
    @Nullable
    private FeedLoggingHandler[] f10038a;
    private Lazy<Set<FeedLoggingHandler>> f10039b;

    public static com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener m15105a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10037c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener.class;
        monitor-enter(r1);
        r0 = f10037c;	 Catch:{ all -> 0x003a }
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
        r0 = m15107b(r0);	 Catch:{ all -> 0x0035 }
        f10037c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10037c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener");
    }

    private static FeedLoggingViewportEventListener m15107b(InjectorLike injectorLike) {
        return new FeedLoggingViewportEventListener(ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$FeedLoggingHandler(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public FeedLoggingViewportEventListener(Lazy<Set<FeedLoggingHandler>> lazy) {
        this.f10039b = lazy;
    }

    private FeedLoggingHandler[] m15106a() {
        if (this.f10038a == null) {
            TracerDetour.a("FeedLoggingViewportEventListener#getLoggingHandlers", 1669113960);
            try {
                Set set = (Set) this.f10039b.get();
                this.f10038a = (FeedLoggingHandler[]) set.toArray(new FeedLoggingHandler[set.size()]);
                this.f10039b = null;
            } finally {
                TracerDetour.a(-1578078057);
            }
        }
        return this.f10038a;
    }

    public final boolean m15115a(FeedUnit feedUnit) {
        for (FeedLoggingHandler a : m15106a()) {
            if (a.mo1919a((Object) feedUnit)) {
                return true;
            }
        }
        return false;
    }

    public final void m15114a(String str) {
        for (FeedLoggingHandler a : m15106a()) {
            a.mo1918a(str);
        }
    }

    public final void m15112a(ImmutableMap<String, String> immutableMap) {
        for (FeedLoggingHandler a : m15106a()) {
            a.mo1917a((ImmutableMap) immutableMap);
        }
    }

    public final void mo1969a(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i, int i2) {
        for (FeedLoggingHandler a : m15106a()) {
            a.mo1915a(scrollingViewProxy, i, i2);
        }
    }

    public final void mo1970a(Object obj) {
        for (FeedLoggingHandler b : m15106a()) {
            b.mo1921b(obj);
        }
    }

    public final void mo1973b(Object obj) {
        for (FeedLoggingHandler c : m15106a()) {
            c.mo1922c(obj);
        }
    }

    public final void mo1968a(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        if (FeedUnitHelper.m21141a(obj) != null && scrollingViewProxy.mo2381e() > 0 && scrollingViewProxy.mo2386f(i) != null) {
            for (FeedLoggingHandler feedLoggingHandler : m15106a()) {
                if (feedLoggingHandler.mo1923d(obj)) {
                    feedLoggingHandler.mo1916a(scrollingViewProxy, obj, i);
                }
            }
        }
    }

    public final void m15109a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, int i) {
        int i2 = 0;
        for (FeedLoggingHandler a : m15106a()) {
            a.mo1914a(scrollableItemListFeedUnit, i);
        }
        VisibleItemHelper.m26979a(scrollableItemListFeedUnit, i);
        FeedLoggingHandler[] a2 = m15106a();
        int length = a2.length;
        while (i2 < length) {
            a2[i2].mo1920b(scrollableItemListFeedUnit, i);
            i2++;
        }
    }

    public final void mo1966a(SimpleArrayMap<Object, Object> simpleArrayMap) {
        for (FeedLoggingHandler a : m15106a()) {
            a.mo1913a((SimpleArrayMap) simpleArrayMap);
        }
    }
}
