package com.facebook.messaging.customthreads;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: media_hash */
public class CustomThreadsLogger {
    private static volatile CustomThreadsLogger f10264b;
    public final AnalyticsLogger f10265a;

    public static com.facebook.messaging.customthreads.CustomThreadsLogger m10867a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10264b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.customthreads.CustomThreadsLogger.class;
        monitor-enter(r1);
        r0 = f10264b;	 Catch:{ all -> 0x003a }
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
        r0 = m10868b(r0);	 Catch:{ all -> 0x0035 }
        f10264b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10264b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.customthreads.CustomThreadsLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.customthreads.CustomThreadsLogger");
    }

    private static CustomThreadsLogger m10868b(InjectorLike injectorLike) {
        return new CustomThreadsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CustomThreadsLogger(AnalyticsLogger analyticsLogger) {
        this.f10265a = analyticsLogger;
    }

    public final void m10871a(ThreadKey threadKey, boolean z) {
        HoneyClientEventFast a = this.f10265a.a("messenger_customthreads_promo_check", false);
        if (a.a()) {
            a.a("thread_promo_status", z ? "all_promos" : "no_promos");
            a.a("thread_key", threadKey.h());
            a.b();
        }
    }

    public final void m10870a(ThreadKey threadKey, String str) {
        m10869b(threadKey, str, "chat_colors_picker");
    }

    public final void m10872b(ThreadKey threadKey, String str) {
        m10869b(threadKey, str, "like_sticker_picker");
    }

    public final void m10873c(ThreadKey threadKey, String str) {
        m10869b(threadKey, str, "nickname_editor");
    }

    private void m10869b(ThreadKey threadKey, String str, String str2) {
        HoneyClientEventFast a = this.f10265a.a("messenger_customthreads_picker_open", false);
        if (a.a()) {
            a.a("picker_type", str2);
            a.a("nav_source", str);
            a.a("thread_key", threadKey.h());
            a.b();
        }
    }
}
