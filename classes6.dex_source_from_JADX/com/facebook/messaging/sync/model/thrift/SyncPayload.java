package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: total_order_price */
public class SyncPayload implements TBase, Serializable, Cloneable {
    public static boolean f2794a = true;
    private static final TStruct f2795b = new TStruct("SyncPayload");
    private static final TField f2796c = new TField("deltas", (byte) 15, (short) 1);
    private static final TField f2797d = new TField("firstDeltaSeqId", (byte) 10, (short) 2);
    private static final TField f2798e = new TField("lastIssuedSeqId", (byte) 10, (short) 3);
    private static final TField f2799f = new TField("queueEntityId", (byte) 10, (short) 4);
    private static final TField f2800g = new TField("failedSend", (byte) 12, (short) 10);
    private static final TField f2801h = new TField("syncToken", (byte) 11, (short) 11);
    private static final TField f2802i = new TField("errorCode", (byte) 11, (short) 12);
    public final List<DeltaWrapper> deltas;
    public final String errorCode;
    public final FailedSend failedSend;
    public final Long firstDeltaSeqId;
    public final Long lastIssuedSeqId;
    public final Long queueEntityId;
    public final String syncToken;

    private SyncPayload(List<DeltaWrapper> list, Long l, Long l2, Long l3, FailedSend failedSend, String str, String str2) {
        this.deltas = list;
        this.firstDeltaSeqId = l;
        this.lastIssuedSeqId = l2;
        this.queueEntityId = l3;
        this.failedSend = failedSend;
        this.syncToken = str;
        this.errorCode = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SyncPayload)) {
            return false;
        }
        SyncPayload syncPayload = (SyncPayload) obj;
        boolean z = false;
        if (syncPayload != null) {
            Object obj2;
            Object obj3 = this.deltas != null ? 1 : null;
            if (syncPayload.deltas != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.deltas.equals(syncPayload.deltas))) {
                if (this.firstDeltaSeqId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (syncPayload.firstDeltaSeqId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.firstDeltaSeqId.equals(syncPayload.firstDeltaSeqId))) {
                    if (this.lastIssuedSeqId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (syncPayload.lastIssuedSeqId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.lastIssuedSeqId.equals(syncPayload.lastIssuedSeqId))) {
                        if (this.queueEntityId != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (syncPayload.queueEntityId != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.queueEntityId.equals(syncPayload.queueEntityId))) {
                            if (this.failedSend != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (syncPayload.failedSend != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.failedSend.m3880a(syncPayload.failedSend))) {
                                if (this.syncToken != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (syncPayload.syncToken != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.syncToken.equals(syncPayload.syncToken))) {
                                    if (this.errorCode != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (syncPayload.errorCode != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.errorCode.equals(syncPayload.errorCode))) {
                                        z = true;
                                    }
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

    public static SyncPayload m3929b(TProtocol tProtocol) {
        String str = null;
        tProtocol.r();
        String str2 = null;
        FailedSend failedSend = null;
        Long l = null;
        Long l2 = null;
        Long l3 = null;
        List list = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TList h = tProtocol.h();
                        list = new ArrayList(Math.max(0, h.b));
                        int i = 0;
                        while (true) {
                            if (h.b >= 0) {
                                if (i >= h.b) {
                                    break;
                                }
                            } else if (!TProtocol.t()) {
                                break;
                            }
                            list.add(DeltaWrapper.m3838b(tProtocol));
                            i++;
                        }
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l3 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 10:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        failedSend = FailedSend.m3877b(tProtocol);
                        break;
                    case (short) 11:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 12:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new SyncPayload(list, l3, l2, l, failedSend, str2, str);
        }
    }

    public final void m3931a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.deltas == null || this.deltas == null)) {
            tProtocol.a(f2796c);
            tProtocol.a(new TList((byte) 12, this.deltas.size()));
            for (DeltaWrapper a : this.deltas) {
                a.m3828a(tProtocol);
            }
        }
        if (!(this.firstDeltaSeqId == null || this.firstDeltaSeqId == null)) {
            tProtocol.a(f2797d);
            tProtocol.a(this.firstDeltaSeqId.longValue());
        }
        if (!(this.lastIssuedSeqId == null || this.lastIssuedSeqId == null)) {
            tProtocol.a(f2798e);
            tProtocol.a(this.lastIssuedSeqId.longValue());
        }
        if (!(this.queueEntityId == null || this.queueEntityId == null)) {
            tProtocol.a(f2799f);
            tProtocol.a(this.queueEntityId.longValue());
        }
        if (!(this.failedSend == null || this.failedSend == null)) {
            tProtocol.a(f2800g);
            this.failedSend.m3879a(tProtocol);
        }
        if (!(this.syncToken == null || this.syncToken == null)) {
            tProtocol.a(f2801h);
            tProtocol.a(this.syncToken);
        }
        if (!(this.errorCode == null || this.errorCode == null)) {
            tProtocol.a(f2802i);
            tProtocol.a(this.errorCode);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3930a(1, f2794a);
    }

    public final String m3930a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("SyncPayload");
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
                stringBuilder.append(TBaseHelper.m7783a(this.deltas, i + 1, z));
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
                stringBuilder.append(TBaseHelper.m7783a(this.firstDeltaSeqId, i + 1, z));
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
                stringBuilder.append(TBaseHelper.m7783a(this.lastIssuedSeqId, i + 1, z));
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
                stringBuilder.append(TBaseHelper.m7783a(this.queueEntityId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.failedSend != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("failedSend");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.failedSend == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.failedSend, i + 1, z));
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
                stringBuilder.append(TBaseHelper.m7783a(this.syncToken, i + 1, z));
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
                stringBuilder.append(TBaseHelper.m7783a(this.errorCode, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
