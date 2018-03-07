package com.facebook.timeline.aboutpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import javax.inject.Singleton;

@Singleton
/* compiled from: NEW_LIKES */
public class CollectionsViewFramer {
    private static volatile CollectionsViewFramer f13020a;

    public static com.facebook.timeline.aboutpage.CollectionsViewFramer m13790a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13020a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.CollectionsViewFramer.class;
        monitor-enter(r1);
        r0 = f13020a;	 Catch:{ all -> 0x0039 }
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
        r0 = m13789a();	 Catch:{ all -> 0x0034 }
        f13020a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13020a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.CollectionsViewFramer.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.CollectionsViewFramer");
    }

    private static CollectionsViewFramer m13789a() {
        return new CollectionsViewFramer();
    }

    public final View m13791a(View view, LayoutInflater layoutInflater) {
        return m13787a(2130903505, view, layoutInflater);
    }

    public final View m13792b(View view, LayoutInflater layoutInflater) {
        return m13787a(2130903507, view, layoutInflater);
    }

    public final View m13793c(View view, LayoutInflater layoutInflater) {
        return m13787a(2130903506, view, layoutInflater);
    }

    public final View m13794d(View view, LayoutInflater layoutInflater) {
        return m13787a(2130903504, view, layoutInflater);
    }

    public static View m13788a(View view) {
        return view.findViewWithTag("collectionsViewFramer_inner_view");
    }

    private static View m13787a(int i, View view, LayoutInflater layoutInflater) {
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(i, null);
        view.setTag("collectionsViewFramer_inner_view");
        viewGroup.addView(view);
        return viewGroup;
    }
}
