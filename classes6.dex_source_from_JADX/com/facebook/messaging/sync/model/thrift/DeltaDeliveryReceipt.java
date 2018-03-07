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

/* compiled from: uTexOffset */
public class DeltaDeliveryReceipt implements TBase, Serializable, Cloneable {
    public static boolean f2517a = true;
    private static final TStruct f2518b = new TStruct("DeltaDeliveryReceipt");
    private static final TField f2519c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2520d = new TField("actorFbId", (byte) 10, (short) 2);
    private static final TField f2521e = new TField("deviceId", (byte) 11, (short) 3);
    private static final TField f2522f = new TField("appId", (byte) 10, (short) 4);
    private static final TField f2523g = new TField("timestampMs", (byte) 10, (short) 5);
    private static final TField f2524h = new TField("messageIds", (byte) 15, (short) 6);
    private static final TField f2525i = new TField("deliveredWatermarkTimestampMs", (byte) 10, (short) 7);
    public final Long actorFbId;
    public final Long appId;
    public final Long deliveredWatermarkTimestampMs;
    public final String deviceId;
    public final List<String> messageIds;
    public final ThreadKey threadKey;
    public final Long timestampMs;

    private DeltaDeliveryReceipt(ThreadKey threadKey, Long l, String str, Long l2, Long l3, List<String> list, Long l4) {
        this.threadKey = threadKey;
        this.actorFbId = l;
        this.deviceId = str;
        this.appId = l2;
        this.timestampMs = l3;
        this.messageIds = list;
        this.deliveredWatermarkTimestampMs = l4;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaDeliveryReceipt)) {
            return false;
        }
        DeltaDeliveryReceipt deltaDeliveryReceipt = (DeltaDeliveryReceipt) obj;
        boolean z = false;
        if (deltaDeliveryReceipt != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaDeliveryReceipt.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaDeliveryReceipt.threadKey))) {
                if (this.actorFbId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaDeliveryReceipt.actorFbId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.actorFbId.equals(deltaDeliveryReceipt.actorFbId))) {
                    if (this.deviceId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaDeliveryReceipt.deviceId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.deviceId.equals(deltaDeliveryReceipt.deviceId))) {
                        if (this.appId != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaDeliveryReceipt.appId != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.appId.equals(deltaDeliveryReceipt.appId))) {
                            if (this.timestampMs != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (deltaDeliveryReceipt.timestampMs != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.timestampMs.equals(deltaDeliveryReceipt.timestampMs))) {
                                if (this.messageIds != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (deltaDeliveryReceipt.messageIds != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageIds.equals(deltaDeliveryReceipt.messageIds))) {
                                    if (this.deliveredWatermarkTimestampMs != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (deltaDeliveryReceipt.deliveredWatermarkTimestampMs != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.deliveredWatermarkTimestampMs.equals(deltaDeliveryReceipt.deliveredWatermarkTimestampMs))) {
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

    public static DeltaDeliveryReceipt m3707b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        List list = null;
        Long l2 = null;
        Long l3 = null;
        String str = null;
        Long l4 = null;
        ThreadKey threadKey = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        threadKey = ThreadKey.m3936b(tProtocol);
                        break;
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l4 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l3 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 6:
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
                            list.add(tProtocol.p());
                            i++;
                        }
                    case (short) 7:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new DeltaDeliveryReceipt(threadKey, l4, str, l3, l2, list, l);
        }
    }

    public final void m3709a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2519c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.actorFbId == null || this.actorFbId == null)) {
            tProtocol.a(f2520d);
            tProtocol.a(this.actorFbId.longValue());
        }
        if (!(this.deviceId == null || this.deviceId == null)) {
            tProtocol.a(f2521e);
            tProtocol.a(this.deviceId);
        }
        if (!(this.appId == null || this.appId == null)) {
            tProtocol.a(f2522f);
            tProtocol.a(this.appId.longValue());
        }
        if (!(this.timestampMs == null || this.timestampMs == null)) {
            tProtocol.a(f2523g);
            tProtocol.a(this.timestampMs.longValue());
        }
        if (!(this.messageIds == null || this.messageIds == null)) {
            tProtocol.a(f2524h);
            tProtocol.a(new TList((byte) 11, this.messageIds.size()));
            for (String a : this.messageIds) {
                tProtocol.a(a);
            }
        }
        if (!(this.deliveredWatermarkTimestampMs == null || this.deliveredWatermarkTimestampMs == null)) {
            tProtocol.a(f2525i);
            tProtocol.a(this.deliveredWatermarkTimestampMs.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3708a(1, f2517a);
    }

    public final String m3708a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaDeliveryReceipt");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.threadKey != null) {
            stringBuilder.append(a);
            stringBuilder.append("threadKey");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadKey == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadKey, i + 1, z));
            }
            obj2 = null;
        }
        if (this.actorFbId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("actorFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.actorFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.actorFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.deviceId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deviceId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.deviceId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.deviceId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.appId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("appId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.appId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.appId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.timestampMs != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("timestampMs");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.timestampMs == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.timestampMs, i + 1, z));
            }
            obj2 = null;
        }
        if (this.messageIds != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("messageIds");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.messageIds == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.messageIds, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.deliveredWatermarkTimestampMs != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deliveredWatermarkTimestampMs");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.deliveredWatermarkTimestampMs == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.deliveredWatermarkTimestampMs, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
