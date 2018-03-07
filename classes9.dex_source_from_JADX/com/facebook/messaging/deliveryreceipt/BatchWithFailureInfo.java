package com.facebook.messaging.deliveryreceipt;

import com.facebook.messaging.deliveryreceipt.model.thrift.DeliveryReceiptBatch;
import com.google.common.collect.ImmutableList;

/* compiled from: maxRecipients */
public class BatchWithFailureInfo {
    public DeliveryReceiptBatch f10831a;
    public ImmutableList<Long> f10832b;

    public BatchWithFailureInfo(DeliveryReceiptBatch deliveryReceiptBatch, ImmutableList<Long> immutableList) {
        this.f10831a = deliveryReceiptBatch;
        this.f10832b = immutableList;
    }
}
