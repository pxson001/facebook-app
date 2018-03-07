package com.facebook.bugreporter;

import com.facebook.bugreporter.activity.categorylist.CategoryInfo;
import com.facebook.bugreporter.activity.chooser.ChooserOption;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;
import javax.inject.Singleton;

@Singleton
@Immutable
/* compiled from: android.media.metadata.DURATION */
public class DefaultBugReporterConfig implements BugReporterConfig {
    private static volatile DefaultBugReporterConfig f10642a;

    public static com.facebook.bugreporter.DefaultBugReporterConfig m18666a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10642a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.bugreporter.DefaultBugReporterConfig.class;
        monitor-enter(r1);
        r0 = f10642a;	 Catch:{ all -> 0x0039 }
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
        r0 = m18668d();	 Catch:{ all -> 0x0034 }
        f10642a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10642a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bugreporter.DefaultBugReporterConfig.a(com.facebook.inject.InjectorLike):com.facebook.bugreporter.DefaultBugReporterConfig");
    }

    private static DefaultBugReporterConfig m18668d() {
        return new DefaultBugReporterConfig();
    }

    public final ImmutableList<CategoryInfo> mo1120a() {
        m18667c();
        return null;
    }

    public final ImmutableList<ChooserOption> mo1121b() {
        m18667c();
        return null;
    }

    private static void m18667c() {
        throw new RuntimeException("You need to bind a " + BugReporterConfig.class.getSimpleName());
    }
}
