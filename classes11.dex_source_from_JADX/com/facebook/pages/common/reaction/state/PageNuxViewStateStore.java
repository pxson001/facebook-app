package com.facebook.pages.common.reaction.state;

import com.facebook.pages.common.reaction.ui.PageNuxComponentView;
import com.facebook.pages.common.reaction.ui.PageNuxComponentView.C02761;
import com.facebook.pages.common.reaction.ui.PageNuxComponentView.C02783;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: sections page */
public class PageNuxViewStateStore {
    private static volatile PageNuxViewStateStore f2137b;
    public final Map<String, Map<String, NuxViewState>> f2138a = new HashMap();

    /* compiled from: sections page */
    public class NuxStateKey {
        public final String f2134a;
        public final String f2135b;
        final /* synthetic */ PageNuxViewStateStore f2136c;

        public NuxStateKey(PageNuxViewStateStore pageNuxViewStateStore, String str, String str2) {
            this.f2136c = pageNuxViewStateStore;
            this.f2134a = str2;
            this.f2135b = str;
        }
    }

    /* compiled from: sections page */
    public enum NuxViewState {
        NUX_CAN_SHOW,
        NUX_DISMISSED
    }

    public static com.facebook.pages.common.reaction.state.PageNuxViewStateStore m3160a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f2137b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.pages.common.reaction.state.PageNuxViewStateStore.class;
        monitor-enter(r1);
        r0 = f2137b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m3159a();	 Catch:{ all -> 0x0034 }
        f2137b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2137b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.reaction.state.PageNuxViewStateStore.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.reaction.state.PageNuxViewStateStore");
    }

    private static PageNuxViewStateStore m3159a() {
        return new PageNuxViewStateStore();
    }

    public final NuxViewState m3162a(NuxStateKey nuxStateKey) {
        return (NuxViewState) m3161b(nuxStateKey.f2135b).get(nuxStateKey.f2134a);
    }

    public final void m3163a(NuxStateKey nuxStateKey, NuxViewState nuxViewState, C02761 c02761) {
        m3161b(nuxStateKey.f2135b).put(nuxStateKey.f2134a, nuxViewState);
        PageNuxComponentView pageNuxComponentView = c02761.f2188a;
        int i = 8;
        int i2 = 0;
        switch (C02783.f2192a[nuxViewState.ordinal()]) {
            case 1:
                break;
            case 2:
                i2 = 8;
                i = 0;
                break;
            default:
                i2 = 8;
                break;
        }
        pageNuxComponentView.f2200h.setVisibility(i2);
        pageNuxComponentView.f2199g.setVisibility(i2);
        pageNuxComponentView.f2201i.setVisibility(i2);
        pageNuxComponentView.f2202j.setVisibility(i2);
        pageNuxComponentView.f2203k.setVisibility(i2);
        pageNuxComponentView.f2204l.setVisibility(i2);
        pageNuxComponentView.f2205m.setVisibility(i2);
        pageNuxComponentView.f2206n.setVisibility(i);
    }

    private Map<String, NuxViewState> m3161b(String str) {
        if (!this.f2138a.containsKey(str)) {
            this.f2138a.put(str, new HashMap());
        }
        return (Map) this.f2138a.get(str);
    }
}
