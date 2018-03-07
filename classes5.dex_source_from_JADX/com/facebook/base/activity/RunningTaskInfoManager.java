package com.facebook.base.activity;

import android.app.Activity;
import android.util.SparseArray;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: suggest_intent_action */
public class RunningTaskInfoManager {
    private static final String f2422a = RunningTaskInfoManager.class.getSimpleName();
    private static volatile RunningTaskInfoManager f2423d;
    private final AbstractFbErrorReporter f2424b;
    private final SparseArray<List<Object>> f2425c = new SparseArray();

    public static com.facebook.base.activity.RunningTaskInfoManager m3515a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2423d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.base.activity.RunningTaskInfoManager.class;
        monitor-enter(r1);
        r0 = f2423d;	 Catch:{ all -> 0x003a }
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
        r0 = m3517b(r0);	 Catch:{ all -> 0x0035 }
        f2423d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2423d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.base.activity.RunningTaskInfoManager.a(com.facebook.inject.InjectorLike):com.facebook.base.activity.RunningTaskInfoManager");
    }

    private static RunningTaskInfoManager m3517b(InjectorLike injectorLike) {
        return new RunningTaskInfoManager((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public RunningTaskInfoManager(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f2424b = abstractFbErrorReporter;
    }

    public final synchronized void m3519a(Activity activity, Object obj) {
        int taskId = activity.getTaskId();
        if (taskId == -1) {
            m3516a(activity);
        } else {
            List list = (List) this.f2425c.get(taskId);
            if (list == null) {
                list = Lists.a();
            }
            if (!list.contains(obj)) {
                list.add(obj);
            }
            this.f2425c.put(taskId, list);
        }
    }

    public final synchronized boolean m3520b(Activity activity, Object obj) {
        boolean z;
        List list = (List) this.f2425c.get(activity.getTaskId());
        if (list == null) {
            z = false;
        } else {
            z = list.contains(obj);
        }
        return z;
    }

    public final synchronized void m3518a(Activity activity, int i, Object obj) {
        int taskId = activity.getTaskId();
        if (taskId != -1) {
            i = taskId;
        }
        if (i == -1) {
            m3516a(activity);
        } else {
            List list = (List) this.f2425c.get(i);
            if (list != null) {
                list.remove(obj);
                if (list.isEmpty()) {
                    this.f2425c.remove(i);
                }
            }
        }
    }

    private void m3516a(Activity activity) {
        this.f2424b.a(SoftError.b(f2422a, StringFormatUtil.formatStrLocaleSafe("Calling Activity (%s) does not belong to a Task", activity.getLocalClassName())));
    }
}
