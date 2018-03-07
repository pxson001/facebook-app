package com.facebook.messaging.tincan.messenger;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.tincan.omnistore.TincanMessage;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: click_sign_up_button */
public class TincanIncomingDispatcher {
    private static volatile TincanIncomingDispatcher f18035b;
    private final DefaultBlueServiceOperationFactory f18036a;

    public static com.facebook.messaging.tincan.messenger.TincanIncomingDispatcher m18022a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18035b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.messenger.TincanIncomingDispatcher.class;
        monitor-enter(r1);
        r0 = f18035b;	 Catch:{ all -> 0x003a }
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
        r0 = m18023b(r0);	 Catch:{ all -> 0x0035 }
        f18035b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18035b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.TincanIncomingDispatcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.TincanIncomingDispatcher");
    }

    private static TincanIncomingDispatcher m18023b(InjectorLike injectorLike) {
        return new TincanIncomingDispatcher(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public TincanIncomingDispatcher(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f18036a = defaultBlueServiceOperationFactory;
    }

    public final synchronized void m18025a(TincanMessage tincanMessage) {
        BlueServiceOperationFactoryDetour.a(this.f18036a, "TincanNewConnection", m18024c(tincanMessage), ErrorPropagation.BY_EXCEPTION, CallerContext.a(TincanIncomingDispatcher.class), -103704722).a();
    }

    public final synchronized void m18026a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("packet_key", str);
        BlueServiceOperationFactoryDetour.a(this.f18036a, "TincanSignalingPacketDelete", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(TincanIncomingDispatcher.class), 1221751993).a();
    }

    public final synchronized void m18027b(TincanMessage tincanMessage) {
        BlueServiceOperationFactoryDetour.a(this.f18036a, "TincanNewMessage", m18024c(tincanMessage), ErrorPropagation.BY_EXCEPTION, CallerContext.a(TincanIncomingDispatcher.class), 701224100).a();
    }

    private static Bundle m18024c(TincanMessage tincanMessage) {
        Bundle bundle = new Bundle();
        bundle.putString("packet_key", tincanMessage.f18074a);
        bundle.putByteArray("message_data", tincanMessage.f18075b.array());
        return bundle;
    }
}
