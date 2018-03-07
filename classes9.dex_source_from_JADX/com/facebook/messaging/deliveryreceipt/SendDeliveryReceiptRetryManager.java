package com.facebook.messaging.deliveryreceipt;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.deliveryreceipt.model.thrift.DeliveryReceipt;
import com.facebook.messaging.deliveryreceipt.model.thrift.DeliveryReceiptBatch;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: markFolderSeen */
public class SendDeliveryReceiptRetryManager implements IHaveUserData {
    private static final Class<?> f10871a = SendDeliveryReceiptRetryManager.class;
    private static final Object f10872e = new Object();
    private final UniqueIdGenerator f10873b;
    private final DeliveryReceiptUtil f10874c;
    private BatchWithFailureInfo f10875d;

    private static SendDeliveryReceiptRetryManager m11299b(InjectorLike injectorLike) {
        return new SendDeliveryReceiptRetryManager(UniqueIdGenerator.a(injectorLike), DeliveryReceiptUtil.m11283a(injectorLike));
    }

    @Inject
    public SendDeliveryReceiptRetryManager(UniqueIdGenerator uniqueIdGenerator, DeliveryReceiptUtil deliveryReceiptUtil) {
        this.f10873b = uniqueIdGenerator;
        this.f10874c = deliveryReceiptUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptRetryManager m11298a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f10872e;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m11299b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10872e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptRetryManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptRetryManager) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f10872e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptRetryManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptRetryManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptRetryManager");
    }

    public final synchronized void m11301a(BatchWithFailureInfo batchWithFailureInfo) {
        Builder builder = ImmutableList.builder();
        builder.b(batchWithFailureInfo.f10832b).c(batchWithFailureInfo.f10831a.batchId);
        this.f10875d = m11297a(this.f10875d, new BatchWithFailureInfo(batchWithFailureInfo.f10831a, builder.b()));
    }

    public final synchronized BatchWithFailureInfo m11300a(@Nullable DeliveryReceiptBatch deliveryReceiptBatch) {
        BatchWithFailureInfo batchWithFailureInfo = null;
        synchronized (this) {
            if (deliveryReceiptBatch != null) {
                batchWithFailureInfo = new BatchWithFailureInfo(deliveryReceiptBatch, ImmutableList.of());
            }
            batchWithFailureInfo = m11297a(this.f10875d, batchWithFailureInfo);
            this.f10875d = null;
        }
        return batchWithFailureInfo;
    }

    @Nullable
    private BatchWithFailureInfo m11297a(@Nullable BatchWithFailureInfo batchWithFailureInfo, @Nullable BatchWithFailureInfo batchWithFailureInfo2) {
        if (batchWithFailureInfo2 == null) {
            return batchWithFailureInfo;
        }
        if (batchWithFailureInfo == null) {
            return batchWithFailureInfo2;
        }
        DeliveryReceiptBatch deliveryReceiptBatch = batchWithFailureInfo2.f10831a;
        Map a = this.f10874c.m11286a(batchWithFailureInfo.f10831a.deliveryReceipts);
        for (DeliveryReceipt deliveryReceipt : deliveryReceiptBatch.deliveryReceipts) {
            DeliveryReceipt deliveryReceipt2;
            ThreadKey a2 = DeliveryReceiptUtil.m11285a(deliveryReceipt2);
            DeliveryReceipt deliveryReceipt3 = (DeliveryReceipt) a.get(a2);
            if (deliveryReceipt3 == null) {
                a.put(a2, deliveryReceipt2);
            } else {
                List list;
                if (deliveryReceipt3.watermarkTimestamp.longValue() < deliveryReceipt2.watermarkTimestamp.longValue()) {
                    list = deliveryReceipt3.messageIds;
                } else {
                    DeliveryReceipt deliveryReceipt4 = deliveryReceipt3;
                    list = deliveryReceipt2.messageIds;
                    deliveryReceipt2 = deliveryReceipt4;
                }
                a.put(a2, DeliveryReceiptUtil.m11284a(list, deliveryReceipt2));
            }
        }
        deliveryReceiptBatch = new DeliveryReceiptBatch(ImmutableList.copyOf(a.values()), Long.valueOf(this.f10873b.a()));
        Builder builder = ImmutableList.builder();
        builder.b(batchWithFailureInfo.f10832b);
        builder.b(batchWithFailureInfo2.f10832b);
        return new BatchWithFailureInfo(deliveryReceiptBatch, builder.b());
    }

    public void clearUserData() {
        this.f10875d = null;
    }
}
