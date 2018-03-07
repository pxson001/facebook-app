package com.facebook.push.mqtt.external;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.GlobalFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: server_tier */
public class PushStateBroadcaster {
    private static final Class<?> f5523a = PushStateBroadcaster.class;
    private static volatile PushStateBroadcaster f5524d;
    private final BaseFbBroadcastManager f5525b;
    private final BaseFbBroadcastManager f5526c;

    public static com.facebook.push.mqtt.external.PushStateBroadcaster m9409a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5524d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.external.PushStateBroadcaster.class;
        monitor-enter(r1);
        r0 = f5524d;	 Catch:{ all -> 0x003a }
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
        r0 = m9410b(r0);	 Catch:{ all -> 0x0035 }
        f5524d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5524d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.external.PushStateBroadcaster.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.external.PushStateBroadcaster");
    }

    private static PushStateBroadcaster m9410b(InjectorLike injectorLike) {
        return new PushStateBroadcaster(LocalFbBroadcastManager.m2946a(injectorLike), GlobalFbBroadcastManager.m4507a(injectorLike));
    }

    @Inject
    public PushStateBroadcaster(BaseFbBroadcastManager baseFbBroadcastManager, BaseFbBroadcastManager baseFbBroadcastManager2) {
        this.f5525b = baseFbBroadcastManager;
        this.f5526c = baseFbBroadcastManager2;
    }

    public final void m9412a(PushStateEvent pushStateEvent) {
        Intent intent = new Intent("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED");
        intent.putExtra("event", pushStateEvent.toValue());
        intent.putExtra("clock_skew_detected", pushStateEvent.isClockSkewDetected());
        this.f5525b.mo406a(intent);
    }

    public final void m9411a(PublishedPayloadDescriptor publishedPayloadDescriptor, boolean z) {
        Intent intent = new Intent("com.facebook.push.mqtt.ACTION_MQTT_PUBLISH_ARRIVED");
        Bundle bundle = new Bundle();
        bundle.putString("topic_name", publishedPayloadDescriptor.a);
        bundle.putByteArray("payload", publishedPayloadDescriptor.b);
        bundle.putLong("received_time_ms", publishedPayloadDescriptor.c);
        bundle.putLong("before_ipc_time_ms", publishedPayloadDescriptor.d);
        bundle.putLong("before_broadcast_time_ms", publishedPayloadDescriptor.e);
        intent.putExtras(bundle);
        intent.putExtra("fast_path", z);
        this.f5525b.mo406a(intent);
    }
}
