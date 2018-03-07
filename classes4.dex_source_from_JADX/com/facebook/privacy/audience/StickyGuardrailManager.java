package com.facebook.privacy.audience;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.graphql.model.GraphQLComposerPrivacyGuardrailInfo;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.PrivacyPrefKeys;
import com.facebook.privacy.audience.ComposerStickyGuardrailConfig.Builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: received */
public class StickyGuardrailManager {
    private static volatile StickyGuardrailManager f3729k;
    private final FbSharedPreferences f3730a;
    private final ObjectMapper f3731b;
    private final AbstractFbErrorReporter f3732c;
    public final BaseFbBroadcastManager f3733d;
    private final Lazy<PrivacyOperationsClient> f3734e;
    private final Executor f3735f;
    public final Clock f3736g;
    public final ActionReceiver f3737h = new C01741(this);
    public SelfRegistrableReceiverImpl f3738i;
    private ComposerStickyGuardrailConfig f3739j;

    /* compiled from: received */
    class C01741 implements ActionReceiver {
        final /* synthetic */ StickyGuardrailManager f3740a;

        C01741(StickyGuardrailManager stickyGuardrailManager) {
            this.f3740a = stickyGuardrailManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -351978375);
            if (Result.valueOf(intent.getStringExtra("extra_result")) == Result.SUCCESS) {
                this.f3740a.m4167c();
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1671599382, a);
        }
    }

    public static com.facebook.privacy.audience.StickyGuardrailManager m4160a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3729k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.audience.StickyGuardrailManager.class;
        monitor-enter(r1);
        r0 = f3729k;	 Catch:{ all -> 0x003a }
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
        r0 = m4162b(r0);	 Catch:{ all -> 0x0035 }
        f3729k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3729k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.audience.StickyGuardrailManager.a(com.facebook.inject.InjectorLike):com.facebook.privacy.audience.StickyGuardrailManager");
    }

    private static StickyGuardrailManager m4162b(InjectorLike injectorLike) {
        return new StickyGuardrailManager((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9683), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StickyGuardrailManager(FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper, FbErrorReporter fbErrorReporter, FbBroadcastManager fbBroadcastManager, Lazy<PrivacyOperationsClient> lazy, ExecutorService executorService, Clock clock) {
        this.f3730a = fbSharedPreferences;
        this.f3731b = objectMapper;
        this.f3732c = fbErrorReporter;
        this.f3733d = fbBroadcastManager;
        this.f3734e = lazy;
        this.f3735f = executorService;
        this.f3736g = clock;
        this.f3738i = this.f3733d.a().a("com.facebook.STREAM_PUBLISH_COMPLETE", this.f3737h).a();
        this.f3738i.b();
    }

    public final void m4165a(GraphQLViewer graphQLViewer) {
        ComposerStickyGuardrailConfig a;
        GraphQLComposerPrivacyGuardrailInfo a2 = graphQLViewer.l().m2391a();
        Builder builder;
        if (a2 == null || a2.m3925l() == null) {
            builder = new Builder();
            builder.f3741a = false;
            builder = builder;
            builder.f3745e = this.f3736g.a();
            a = builder.m4168a();
        } else {
            Builder builder2 = new Builder();
            builder2.f3741a = a2.m3923j();
            builder2 = builder2;
            builder2.f3742b = a2.m3920a();
            builder2 = builder2;
            builder2.f3743c = a2.m3925l();
            builder2 = builder2;
            builder2.f3744d = a2.m3924k();
            builder = builder2;
            builder.f3745e = this.f3736g.a();
            a = builder.m4168a();
        }
        m4161a(a);
    }

    private void m4161a(ComposerStickyGuardrailConfig composerStickyGuardrailConfig) {
        String a;
        this.f3739j = composerStickyGuardrailConfig;
        try {
            a = this.f3731b.a(this.f3739j);
        } catch (Throwable e) {
            this.f3732c.a("sticky_guardrail_manager_serialize_error", e);
            a = null;
        }
        if (a != null) {
            this.f3730a.edit().a(PrivacyPrefKeys.f2170l, a).commit();
        }
    }

    public final ComposerStickyGuardrailConfig m4164a() {
        if (this.f3739j != null) {
            Object obj;
            if (this.f3736g.a() > this.f3739j.mUpdatedTime + 1209600000) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                m4166b();
            }
            return this.f3739j;
        }
        m4163e();
        return this.f3739j;
    }

    private void m4163e() {
        String a = this.f3730a.a(PrivacyPrefKeys.f2170l, null);
        if (a == null) {
            m4166b();
            return;
        }
        try {
            this.f3739j = (ComposerStickyGuardrailConfig) this.f3731b.a(a, ComposerStickyGuardrailConfig.class);
        } catch (Throwable e) {
            this.f3732c.a("sticky_guardrail_manager_deserialize_error", e);
            m4166b();
        }
    }

    public final void m4166b() {
        Builder builder = new Builder();
        builder.f3741a = false;
        m4161a(builder.m4168a());
    }

    public final void m4167c() {
        Futures.a(((PrivacyOperationsClient) this.f3734e.get()).a(), new 2(this), this.f3735f);
    }
}
