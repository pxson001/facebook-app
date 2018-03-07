package com.facebook.messaging.deliveryreceipt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: map_fragment */
public class DeliveryReceiptBatch implements TBase, Serializable, Cloneable {
    public static boolean f10884a = true;
    private static final TStruct f10885b = new TStruct("DeliveryReceiptBatch");
    private static final TField f10886c = new TField("deliveryReceipts", (byte) 15, (short) 1);
    private static final TField f10887d = new TField("batchId", (byte) 10, (short) 2);
    public final Long batchId;
    public final List<DeliveryReceipt> deliveryReceipts;

    public DeliveryReceiptBatch(List<DeliveryReceipt> list, Long l) {
        this.deliveryReceipts = list;
        this.batchId = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeliveryReceiptBatch)) {
            return false;
        }
        DeliveryReceiptBatch deliveryReceiptBatch = (DeliveryReceiptBatch) obj;
        boolean z = false;
        if (deliveryReceiptBatch != null) {
            Object obj2;
            Object obj3 = this.deliveryReceipts != null ? 1 : null;
            if (deliveryReceiptBatch.deliveryReceipts != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.deliveryReceipts.equals(deliveryReceiptBatch.deliveryReceipts))) {
                if (this.batchId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deliveryReceiptBatch.batchId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.batchId.equals(deliveryReceiptBatch.batchId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m11305a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.deliveryReceipts == null || this.deliveryReceipts == null)) {
            tProtocol.a(f10886c);
            tProtocol.a(new TList((byte) 12, this.deliveryReceipts.size()));
            for (DeliveryReceipt a : this.deliveryReceipts) {
                a.m11303a(tProtocol);
            }
        }
        if (!(this.batchId == null || this.batchId == null)) {
            tProtocol.a(f10887d);
            tProtocol.a(this.batchId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m11304a(1, f10884a);
    }

    public final String m11304a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeliveryReceiptBatch");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.deliveryReceipts != null) {
            stringBuilder.append(a);
            stringBuilder.append("deliveryReceipts");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.deliveryReceipts == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.deliveryReceipts, i + 1, z));
            }
            obj = null;
        }
        if (this.batchId != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("batchId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.batchId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.batchId, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
