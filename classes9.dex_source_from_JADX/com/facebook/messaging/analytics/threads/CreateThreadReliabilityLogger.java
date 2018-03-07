package com.facebook.messaging.analytics.threads;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: p2p_edit_cards */
public class CreateThreadReliabilityLogger {
    private static volatile CreateThreadReliabilityLogger f7671b;
    @Inject
    public AnalyticsLogger f7672a;

    /* compiled from: p2p_edit_cards */
    enum CreateThreadAction {
        START,
        RETRY,
        SUCCEEDED,
        FAILED
    }

    /* compiled from: p2p_edit_cards */
    public enum CreateThreadSource {
        ONE_TO_ONE,
        MULTIPICKER,
        OMNIPICKER,
        GROUP_PINNED,
        GROUP_PHOTO_REMINDER_NOTIF
    }

    public static com.facebook.messaging.analytics.threads.CreateThreadReliabilityLogger m7971a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7671b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.analytics.threads.CreateThreadReliabilityLogger.class;
        monitor-enter(r1);
        r0 = f7671b;	 Catch:{ all -> 0x003a }
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
        r0 = m7973b(r0);	 Catch:{ all -> 0x0035 }
        f7671b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7671b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.analytics.threads.CreateThreadReliabilityLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.analytics.threads.CreateThreadReliabilityLogger");
    }

    private static CreateThreadReliabilityLogger m7973b(InjectorLike injectorLike) {
        CreateThreadReliabilityLogger createThreadReliabilityLogger = new CreateThreadReliabilityLogger();
        createThreadReliabilityLogger.f7672a = AnalyticsLoggerMethodAutoProvider.a(injectorLike);
        return createThreadReliabilityLogger;
    }

    public final void m7976a(@Nullable ThreadKey threadKey, long j, CreateThreadSource createThreadSource, boolean z, int i) {
        m7972a(CreateThreadAction.START, threadKey, j, createThreadSource, z, i, 0);
    }

    public final void m7974a(ThreadKey threadKey, long j, CreateThreadSource createThreadSource) {
        m7972a(CreateThreadAction.SUCCEEDED, threadKey, j, createThreadSource, false, -1, 0);
    }

    public final void m7975a(@Nullable ThreadKey threadKey, long j, CreateThreadSource createThreadSource, boolean z) {
        m7972a(CreateThreadAction.FAILED, threadKey, j, createThreadSource, z, -1, 0);
    }

    private void m7972a(CreateThreadAction createThreadAction, @Nullable ThreadKey threadKey, long j, CreateThreadSource createThreadSource, boolean z, int i, int i2) {
        boolean z2 = threadKey != null || j > 0;
        Preconditions.checkArgument(z2);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("create_thread_step");
        honeyClientEvent.b("create_thread_action", createThreadAction.name()).a("create_thread_key", threadKey).a("create_thread_offline_id", j).a("create_thread_source", createThreadSource).a("create_thread_waiting_for_media_uploads", z);
        if (i > 0) {
            honeyClientEvent.a("create_thread_participant_count", i);
        }
        if (i2 > 0) {
            honeyClientEvent.a("create_thread_retry_attempt", i2);
        }
        this.f7672a.a(honeyClientEvent);
    }
}
