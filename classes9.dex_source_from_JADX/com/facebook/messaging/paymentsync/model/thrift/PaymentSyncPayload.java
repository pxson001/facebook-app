package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: draft_flat_buffer */
public class PaymentSyncPayload implements TBase, Serializable, Cloneable {
    public static boolean f15976a = true;
    private static final TStruct f15977b = new TStruct("PaymentSyncPayload");
    private static final TField f15978c = new TField("deltas", (byte) 15, (short) 1);
    private static final TField f15979d = new TField("firstDeltaSeqId", (byte) 10, (short) 2);
    private static final TField f15980e = new TField("lastIssuedSeqId", (byte) 10, (short) 3);
    private static final TField f15981f = new TField("queueEntityId", (byte) 10, (short) 4);
    private static final TField f15982g = new TField("syncToken", (byte) 11, (short) 11);
    private static final TField f15983h = new TField("errorCode", (byte) 11, (short) 12);
    public final List<DeltaPaymentWrapper> deltas;
    public final String errorCode;
    public final Long firstDeltaSeqId;
    public final Long lastIssuedSeqId;
    public final Long queueEntityId;
    public final String syncToken;

    public PaymentSyncPayload(List<DeltaPaymentWrapper> list, Long l, Long l2, Long l3, String str, String str2) {
        this.deltas = list;
        this.firstDeltaSeqId = l;
        this.lastIssuedSeqId = l2;
        this.queueEntityId = l3;
        this.syncToken = str;
        this.errorCode = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PaymentSyncPayload)) {
            return false;
        }
        PaymentSyncPayload paymentSyncPayload = (PaymentSyncPayload) obj;
        boolean z = false;
        if (paymentSyncPayload != null) {
            Object obj2;
            Object obj3 = this.deltas != null ? 1 : null;
            if (paymentSyncPayload.deltas != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.deltas.equals(paymentSyncPayload.deltas))) {
                if (this.firstDeltaSeqId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (paymentSyncPayload.firstDeltaSeqId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.firstDeltaSeqId.equals(paymentSyncPayload.firstDeltaSeqId))) {
                    if (this.lastIssuedSeqId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (paymentSyncPayload.lastIssuedSeqId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.lastIssuedSeqId.equals(paymentSyncPayload.lastIssuedSeqId))) {
                        if (this.queueEntityId != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (paymentSyncPayload.queueEntityId != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.queueEntityId.equals(paymentSyncPayload.queueEntityId))) {
                            if (this.syncToken != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (paymentSyncPayload.syncToken != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.syncToken.equals(paymentSyncPayload.syncToken))) {
                                if (this.errorCode != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (paymentSyncPayload.errorCode != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.errorCode.equals(paymentSyncPayload.errorCode))) {
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m16110a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.deltas == null || this.deltas == null)) {
            tProtocol.a(f15978c);
            tProtocol.a(new TList((byte) 12, this.deltas.size()));
            for (DeltaPaymentWrapper a : this.deltas) {
                a.a(tProtocol);
            }
        }
        if (!(this.firstDeltaSeqId == null || this.firstDeltaSeqId == null)) {
            tProtocol.a(f15979d);
            tProtocol.a(this.firstDeltaSeqId.longValue());
        }
        if (!(this.lastIssuedSeqId == null || this.lastIssuedSeqId == null)) {
            tProtocol.a(f15980e);
            tProtocol.a(this.lastIssuedSeqId.longValue());
        }
        if (!(this.queueEntityId == null || this.queueEntityId == null)) {
            tProtocol.a(f15981f);
            tProtocol.a(this.queueEntityId.longValue());
        }
        if (!(this.syncToken == null || this.syncToken == null)) {
            tProtocol.a(f15982g);
            tProtocol.a(this.syncToken);
        }
        if (!(this.errorCode == null || this.errorCode == null)) {
            tProtocol.a(f15983h);
            tProtocol.a(this.errorCode);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16109a(1, f15976a);
    }

    public final String m16109a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("PaymentSyncPayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.deltas != null) {
            stringBuilder.append(a);
            stringBuilder.append("deltas");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.deltas == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.deltas, i + 1, z));
            }
            obj2 = null;
        }
        if (this.firstDeltaSeqId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("firstDeltaSeqId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.firstDeltaSeqId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.firstDeltaSeqId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.lastIssuedSeqId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("lastIssuedSeqId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.lastIssuedSeqId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.lastIssuedSeqId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.queueEntityId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("queueEntityId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.queueEntityId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.queueEntityId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.syncToken != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("syncToken");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.syncToken == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.syncToken, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.errorCode != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("errorCode");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.errorCode == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.errorCode, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
