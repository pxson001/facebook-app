package com.facebook.fbui.runtimelinter.rules;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.runtimelinter.RuntimeLinterRule;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: YOUR_POSTS_UNSOLD_NOTIFICATION */
public final class MaximumViewCountRule implements RuntimeLinterRule {
    private static volatile MaximumViewCountRule f12200b;

    public static com.facebook.fbui.runtimelinter.rules.MaximumViewCountRule m20209a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12200b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.fbui.runtimelinter.rules.MaximumViewCountRule.class;
        monitor-enter(r1);
        r0 = f12200b;	 Catch:{ all -> 0x0039 }
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
        r0 = m20210c();	 Catch:{ all -> 0x0034 }
        f12200b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12200b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.runtimelinter.rules.MaximumViewCountRule.a(com.facebook.inject.InjectorLike):com.facebook.fbui.runtimelinter.rules.MaximumViewCountRule");
    }

    private static MaximumViewCountRule m20210c() {
        return new MaximumViewCountRule();
    }

    public final boolean mo1223a(ViewGroup viewGroup, Map<String, String> map) {
        int a = m20208a((View) viewGroup);
        if (a <= 500) {
            return false;
        }
        map.put("num_non_gone_views", String.valueOf(a));
        return true;
    }

    public final String mo1222a() {
        return "Reduce the number of views in use by flattening view hierarchies.";
    }

    public final String mo1224b() {
        return "Too many views in view hierarchy";
    }

    private int m20208a(View view) {
        int i = 0;
        if (view.getVisibility() == 8) {
            return 0;
        }
        int i2 = 1;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            while (i < viewGroup.getChildCount()) {
                i2 += m20208a(viewGroup.getChildAt(i));
                i++;
            }
        }
        return i2;
    }
}
