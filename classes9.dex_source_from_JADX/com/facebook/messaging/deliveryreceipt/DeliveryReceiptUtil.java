package com.facebook.messaging.deliveryreceipt;

import com.facebook.messaging.deliveryreceipt.model.thrift.DeliveryReceipt;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: markThreadsRead */
public class DeliveryReceiptUtil {
    private static volatile DeliveryReceiptUtil f10857a;

    public static com.facebook.messaging.deliveryreceipt.DeliveryReceiptUtil m11283a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10857a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.deliveryreceipt.DeliveryReceiptUtil.class;
        monitor-enter(r1);
        r0 = f10857a;	 Catch:{ all -> 0x0039 }
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
        r0 = m11282a();	 Catch:{ all -> 0x0034 }
        f10857a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10857a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.deliveryreceipt.DeliveryReceiptUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.deliveryreceipt.DeliveryReceiptUtil");
    }

    private static DeliveryReceiptUtil m11282a() {
        return new DeliveryReceiptUtil();
    }

    public static ThreadKey m11285a(DeliveryReceipt deliveryReceipt) {
        if (deliveryReceipt.isGroupThread.booleanValue()) {
            return ThreadKey.a(deliveryReceipt.threadFbid.longValue());
        }
        return ThreadKey.a(deliveryReceipt.messageSenderFbid.longValue(), deliveryReceipt.messageRecipientFbid.longValue());
    }

    static DeliveryReceipt m11284a(List<String> list, DeliveryReceipt deliveryReceipt) {
        Collection c = Sets.c();
        c.addAll(list);
        c.addAll(deliveryReceipt.messageIds);
        return new DeliveryReceipt(deliveryReceipt.messageSenderFbid, deliveryReceipt.watermarkTimestamp, deliveryReceipt.threadFbid, ImmutableList.copyOf(c), deliveryReceipt.messageRecipientFbid, deliveryReceipt.isGroupThread);
    }

    final Map<ThreadKey, DeliveryReceipt> m11286a(List<DeliveryReceipt> list) {
        Map<ThreadKey, DeliveryReceipt> c = Maps.c();
        for (DeliveryReceipt deliveryReceipt : list) {
            c.put(m11285a(deliveryReceipt), deliveryReceipt);
        }
        return c;
    }
}
