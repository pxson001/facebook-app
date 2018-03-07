package com.facebook.common.callercontexttagger;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewParent;
import com.facebook.common.callercontext.CallerContext;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: retry_button */
public class AnalyticsTagger {
    private static volatile AnalyticsTagger f6735a;

    public static com.facebook.common.callercontexttagger.AnalyticsTagger m11473a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6735a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.common.callercontexttagger.AnalyticsTagger.class;
        monitor-enter(r1);
        r0 = f6735a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m11472a();	 Catch:{ all -> 0x0034 }
        f6735a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6735a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.callercontexttagger.AnalyticsTagger.a(com.facebook.inject.InjectorLike):com.facebook.common.callercontexttagger.AnalyticsTagger");
    }

    private static AnalyticsTagger m11472a() {
        return new AnalyticsTagger();
    }

    public final void m11477a(View view, String str, Fragment fragment) {
        m11478a(view, str, fragment.getClass());
    }

    public final void m11478a(View view, String str, Class<?> cls) {
        m11475a(view, CallerContext.m9062a(cls, str, str.toString()));
    }

    public static void m11475a(View view, CallerContext callerContext) {
        view.setTag(2131558561, callerContext);
    }

    public static void m11474a(View view) {
        view.setTag(2131558561, null);
    }

    @Nullable
    public static CallerContext m11476b(View view) {
        CallerContext callerContext = (CallerContext) view.getTag(2131558561);
        if (callerContext != null) {
            return callerContext;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            callerContext = (CallerContext) ((View) parent).getTag(2131558561);
            if (callerContext != null) {
                return callerContext;
            }
        }
        return null;
    }
}
