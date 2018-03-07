package com.facebook.checkpoint;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: short_whistle_connect_timeout */
public class CheckpointBroadcaster {
    public static final Class<?> f4932a = CheckpointBroadcaster.class;
    private static volatile CheckpointBroadcaster f4933k;
    public String f4934b;
    public boolean f4935c;
    public boolean f4936d;
    public final Provider<Boolean> f4937e;
    public final Provider<Boolean> f4938f;
    public final BaseFbBroadcastManager f4939g;
    public SelfRegistrableReceiverImpl f4940h = this.f4939g.m2951a().mo506a("com.facebook.http.protocol.CHECKPOINT_API_EXCEPTION", new C02431(this)).mo503a();
    public final ExecutorService f4941i;
    public final Lazy<GraphQLQueryExecutor> f4942j;

    /* compiled from: short_whistle_connect_timeout */
    public class C02431 implements ActionReceiver {
        final /* synthetic */ CheckpointBroadcaster f4943a;

        public C02431(CheckpointBroadcaster checkpointBroadcaster) {
            this.f4943a = checkpointBroadcaster;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -171922614);
            this.f4943a.m8845a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 712084081, a);
        }
    }

    public static com.facebook.checkpoint.CheckpointBroadcaster m8842a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4933k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.checkpoint.CheckpointBroadcaster.class;
        monitor-enter(r1);
        r0 = f4933k;	 Catch:{ all -> 0x003a }
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
        r0 = m8843b(r0);	 Catch:{ all -> 0x0035 }
        f4933k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4933k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.checkpoint.CheckpointBroadcaster.a(com.facebook.inject.InjectorLike):com.facebook.checkpoint.CheckpointBroadcaster");
    }

    private static CheckpointBroadcaster m8843b(InjectorLike injectorLike) {
        return new CheckpointBroadcaster(LocalFbBroadcastManager.m2946a(injectorLike), C0055x2995691a.m1881a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2164), IdBasedProvider.m1811a(injectorLike, 3918), IdBasedProvider.m1811a(injectorLike, 3917));
    }

    @Inject
    public CheckpointBroadcaster(FbBroadcastManager fbBroadcastManager, ExecutorService executorService, Lazy<GraphQLQueryExecutor> lazy, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.f4939g = fbBroadcastManager;
        this.f4941i = executorService;
        this.f4942j = lazy;
        this.f4937e = provider;
        this.f4938f = provider2;
        this.f4940h.m3296b();
    }

    public final void m8845a() {
        if (((Boolean) this.f4938f.get()).booleanValue() && m8844b("is_blocking")) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("arg_is_checkpoint", true);
            bundle.putBoolean("arg_is_blocking_checkpoint", true);
            this.f4939g.mo406a(new Intent().setAction("com.facebook.checkpoint.USER_IN_CHECKPOINT").putExtras(bundle));
            this.f4934b = "is_blocking";
            this.f4936d = true;
        }
    }

    public final void m8846a(String str) {
        if (((Boolean) this.f4937e.get()).booleanValue() && m8844b(str)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("arg_is_checkpoint", true);
            bundle.putBoolean("arg_is_blocking_checkpoint", false);
            this.f4939g.mo406a(new Intent().setAction("com.facebook.checkpoint.USER_IN_CHECKPOINT").putExtras(bundle));
            this.f4934b = str;
        }
    }

    private boolean m8844b(String str) {
        return StringUtil.m3589a(this.f4934b) || (this.f4934b.equals(str) && !this.f4935c);
    }
}
