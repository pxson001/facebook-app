package com.facebook.messaging.payment.protocol;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.TransferStatus;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: formatted_low_fare */
public class PaymentsBroadcaster {
    private static volatile PaymentsBroadcaster f14574b;
    private final BaseFbBroadcastManager f14575a;

    public static com.facebook.messaging.payment.protocol.PaymentsBroadcaster m15003a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14574b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.protocol.PaymentsBroadcaster.class;
        monitor-enter(r1);
        r0 = f14574b;	 Catch:{ all -> 0x003a }
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
        r0 = m15005b(r0);	 Catch:{ all -> 0x0035 }
        f14574b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14574b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.protocol.PaymentsBroadcaster.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.protocol.PaymentsBroadcaster");
    }

    private static PaymentsBroadcaster m15005b(InjectorLike injectorLike) {
        return new PaymentsBroadcaster((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike));
    }

    @Inject
    public PaymentsBroadcaster(BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f14575a = baseFbBroadcastManager;
    }

    public final void m15006a() {
        Intent intent = new Intent();
        intent.setAction("com.facebook.messaging.payment.ACTION_NEW_TRANSFER");
        m15004a(intent);
    }

    public final void m15010b() {
        Intent intent = new Intent();
        intent.setAction("com.facebook.messaging.payment.ACTION_PRESET_CARD_ADDED");
        m15004a(intent);
    }

    public final void m15011c() {
        Intent intent = new Intent();
        intent.setAction("com.facebook.messaging.payment.ACTION_PAYMENT_CARD_CACHE_UPDATED");
        m15004a(intent);
    }

    public final void m15007a(TransferStatus transferStatus, long j) {
        Intent intent = new Intent();
        intent.putExtra("extra_transfer_status", transferStatus);
        intent.putExtra("extra_transfer_id", j);
        intent.setAction("com.facebook.messaging.payment.ACTION_PAYMENT_TRANSACTION_CACHE_UPDATED");
        m15004a(intent);
    }

    public final void m15012d() {
        Intent intent = new Intent();
        intent.setAction("com.facebook.messaging.payment.ACTION_PAYMENT_CARD_UPDATED");
        m15004a(intent);
    }

    public final void m15013e() {
        Intent intent = new Intent();
        intent.setAction("com.facebook.messaging.payment.ACTION_PIN_UPDATED");
        m15004a(intent);
    }

    public final void m15014f() {
        Intent intent = new Intent();
        intent.setAction("com.facebook.messaging.payment.ACTION_PAYMENT_PLATFORM_CONTEXTS_CACHE_UPDATED");
        m15004a(intent);
    }

    public final void m15015g() {
        Intent intent = new Intent();
        intent.setAction("com.facebook.messaging.payment.ACTION_PAYMENT_REQUEST_CACHE_UPDATED");
        m15004a(intent);
    }

    public final void m15008a(String str) {
        Intent intent = new Intent();
        intent.putExtra("extra_payment_request_id", str);
        intent.setAction("com.facebook.messaging.payment.ACTION_PAYMENT_REQUEST_CACHE_UPDATED");
        m15004a(intent);
    }

    public final void m15009a(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("extra_payment_account_enabled_status", z);
        intent.setAction("com.facebook.messaging.payment.ACTION_PAYMENT_ACCOUNT_ENABLED_STATUS_UPDATED");
        m15004a(intent);
    }

    private void m15004a(Intent intent) {
        this.f14575a.a(intent);
    }
}
