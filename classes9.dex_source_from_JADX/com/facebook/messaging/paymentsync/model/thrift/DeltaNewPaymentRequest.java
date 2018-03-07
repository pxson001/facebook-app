package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: ecdbc1bc926006774ddccf5754df7615 */
public class DeltaNewPaymentRequest implements TBase, Serializable, Cloneable {
    public static boolean f15857a = true;
    private static final TStruct f15858b = new TStruct("DeltaNewPaymentRequest");
    private static final TField f15859c = new TField("requestFbId", (byte) 10, (short) 1);
    private static final TField f15860d = new TField("requesterFbId", (byte) 10, (short) 2);
    private static final TField f15861e = new TField("requesteeFbId", (byte) 10, (short) 3);
    private static final TField f15862f = new TField("timestampMs", (byte) 10, (short) 4);
    private static final TField f15863g = new TField("initialStatus", (byte) 8, (short) 5);
    private static final TField f15864h = new TField("currency", (byte) 11, (short) 6);
    private static final TField f15865i = new TField("amount", (byte) 10, (short) 7);
    private static final TField f15866j = new TField("amountOffset", (byte) 8, (short) 8);
    private static final TField f15867k = new TField("offlineThreadingId", (byte) 10, (short) 9);
    private static final TField f15868l = new TField("memoText", (byte) 11, (short) 10);
    private static final TField f15869m = new TField("hasMemoMultimedia", (byte) 2, (short) 11);
    private static final TField f15870n = new TField("themeId", (byte) 10, (short) 12);
    private static final TField f15871o = new TField("groupThreadFbId", (byte) 10, (short) 13);
    private static final TField f15872p = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Long amount;
    public final Integer amountOffset;
    public final String currency;
    public final Long groupThreadFbId;
    public final Boolean hasMemoMultimedia;
    public final Integer initialStatus;
    public final Long irisSeqId;
    public final String memoText;
    public final Long offlineThreadingId;
    public final Long requestFbId;
    public final Long requesteeFbId;
    public final Long requesterFbId;
    public final Long themeId;
    public final Long timestampMs;

    private DeltaNewPaymentRequest(Long l, Long l2, Long l3, Long l4, Integer num, String str, Long l5, Integer num2, Long l6, String str2, Boolean bool, Long l7, Long l8, Long l9) {
        this.requestFbId = l;
        this.requesterFbId = l2;
        this.requesteeFbId = l3;
        this.timestampMs = l4;
        this.initialStatus = num;
        this.currency = str;
        this.amount = l5;
        this.amountOffset = num2;
        this.offlineThreadingId = l6;
        this.memoText = str2;
        this.hasMemoMultimedia = bool;
        this.themeId = l7;
        this.groupThreadFbId = l8;
        this.irisSeqId = l9;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaNewPaymentRequest)) {
            return false;
        }
        DeltaNewPaymentRequest deltaNewPaymentRequest = (DeltaNewPaymentRequest) obj;
        boolean z = false;
        if (deltaNewPaymentRequest != null) {
            Object obj2;
            Object obj3 = this.requestFbId != null ? 1 : null;
            if (deltaNewPaymentRequest.requestFbId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.requestFbId.equals(deltaNewPaymentRequest.requestFbId))) {
                if (this.requesterFbId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaNewPaymentRequest.requesterFbId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.requesterFbId.equals(deltaNewPaymentRequest.requesterFbId))) {
                    if (this.requesteeFbId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaNewPaymentRequest.requesteeFbId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.requesteeFbId.equals(deltaNewPaymentRequest.requesteeFbId))) {
                        if (this.timestampMs != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaNewPaymentRequest.timestampMs != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.timestampMs.equals(deltaNewPaymentRequest.timestampMs))) {
                            if (this.initialStatus != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (deltaNewPaymentRequest.initialStatus != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.initialStatus.equals(deltaNewPaymentRequest.initialStatus))) {
                                if (this.currency != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (deltaNewPaymentRequest.currency != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.currency.equals(deltaNewPaymentRequest.currency))) {
                                    if (this.amount != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (deltaNewPaymentRequest.amount != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.amount.equals(deltaNewPaymentRequest.amount))) {
                                        if (this.amountOffset != null) {
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        if (deltaNewPaymentRequest.amountOffset != null) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.amountOffset.equals(deltaNewPaymentRequest.amountOffset))) {
                                            if (this.offlineThreadingId != null) {
                                                obj3 = 1;
                                            } else {
                                                obj3 = null;
                                            }
                                            if (deltaNewPaymentRequest.offlineThreadingId != null) {
                                                obj2 = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.offlineThreadingId.equals(deltaNewPaymentRequest.offlineThreadingId))) {
                                                if (this.memoText != null) {
                                                    obj3 = 1;
                                                } else {
                                                    obj3 = null;
                                                }
                                                if (deltaNewPaymentRequest.memoText != null) {
                                                    obj2 = 1;
                                                } else {
                                                    obj2 = null;
                                                }
                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.memoText.equals(deltaNewPaymentRequest.memoText))) {
                                                    if (this.hasMemoMultimedia != null) {
                                                        obj3 = 1;
                                                    } else {
                                                        obj3 = null;
                                                    }
                                                    if (deltaNewPaymentRequest.hasMemoMultimedia != null) {
                                                        obj2 = 1;
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.hasMemoMultimedia.equals(deltaNewPaymentRequest.hasMemoMultimedia))) {
                                                        if (this.themeId != null) {
                                                            obj3 = 1;
                                                        } else {
                                                            obj3 = null;
                                                        }
                                                        if (deltaNewPaymentRequest.themeId != null) {
                                                            obj2 = 1;
                                                        } else {
                                                            obj2 = null;
                                                        }
                                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.themeId.equals(deltaNewPaymentRequest.themeId))) {
                                                            if (this.groupThreadFbId != null) {
                                                                obj3 = 1;
                                                            } else {
                                                                obj3 = null;
                                                            }
                                                            if (deltaNewPaymentRequest.groupThreadFbId != null) {
                                                                obj2 = 1;
                                                            } else {
                                                                obj2 = null;
                                                            }
                                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.groupThreadFbId.equals(deltaNewPaymentRequest.groupThreadFbId))) {
                                                                if (this.irisSeqId != null) {
                                                                    obj3 = 1;
                                                                } else {
                                                                    obj3 = null;
                                                                }
                                                                if (deltaNewPaymentRequest.irisSeqId != null) {
                                                                    obj2 = 1;
                                                                } else {
                                                                    obj2 = null;
                                                                }
                                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaNewPaymentRequest.irisSeqId))) {
                                                                    z = true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    public static DeltaNewPaymentRequest m16058b(TProtocol tProtocol) {
        Long l = null;
        Long l2 = null;
        Long l3 = null;
        Long l4 = null;
        Integer num = null;
        String str = null;
        Long l5 = null;
        Integer num2 = null;
        Long l6 = null;
        String str2 = null;
        Boolean bool = null;
        Long l7 = null;
        Long l8 = null;
        Long l9 = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l3 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l4 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 6:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 7:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l5 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 8:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 9:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l6 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 10:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 11:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 12:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l7 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 13:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l8 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 1000:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l9 = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaNewPaymentRequest deltaNewPaymentRequest = new DeltaNewPaymentRequest(l, l2, l3, l4, num, str, l5, num2, l6, str2, bool, l7, l8, l9);
            deltaNewPaymentRequest.m16057a();
            return deltaNewPaymentRequest;
        }
    }

    public final void m16060a(TProtocol tProtocol) {
        m16057a();
        tProtocol.a();
        if (this.requestFbId != null) {
            tProtocol.a(f15859c);
            tProtocol.a(this.requestFbId.longValue());
        }
        if (this.requesterFbId != null) {
            tProtocol.a(f15860d);
            tProtocol.a(this.requesterFbId.longValue());
        }
        if (this.requesteeFbId != null) {
            tProtocol.a(f15861e);
            tProtocol.a(this.requesteeFbId.longValue());
        }
        if (this.timestampMs != null) {
            tProtocol.a(f15862f);
            tProtocol.a(this.timestampMs.longValue());
        }
        if (this.initialStatus != null) {
            tProtocol.a(f15863g);
            tProtocol.a(this.initialStatus.intValue());
        }
        if (this.currency != null) {
            tProtocol.a(f15864h);
            tProtocol.a(this.currency);
        }
        if (this.amount != null) {
            tProtocol.a(f15865i);
            tProtocol.a(this.amount.longValue());
        }
        if (this.amountOffset != null) {
            tProtocol.a(f15866j);
            tProtocol.a(this.amountOffset.intValue());
        }
        if (!(this.offlineThreadingId == null || this.offlineThreadingId == null)) {
            tProtocol.a(f15867k);
            tProtocol.a(this.offlineThreadingId.longValue());
        }
        if (!(this.memoText == null || this.memoText == null)) {
            tProtocol.a(f15868l);
            tProtocol.a(this.memoText);
        }
        if (!(this.hasMemoMultimedia == null || this.hasMemoMultimedia == null)) {
            tProtocol.a(f15869m);
            tProtocol.a(this.hasMemoMultimedia.booleanValue());
        }
        if (!(this.themeId == null || this.themeId == null)) {
            tProtocol.a(f15870n);
            tProtocol.a(this.themeId.longValue());
        }
        if (!(this.groupThreadFbId == null || this.groupThreadFbId == null)) {
            tProtocol.a(f15871o);
            tProtocol.a(this.groupThreadFbId.longValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15872p);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16059a(1, f15857a);
    }

    public final String m16059a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaNewPaymentRequest");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("requestFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.requestFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.requestFbId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("requesterFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.requesterFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.requesterFbId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("requesteeFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.requesteeFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.requesteeFbId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("timestampMs");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.timestampMs == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.timestampMs, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("initialStatus");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.initialStatus == null) {
            stringBuilder.append("null");
        } else {
            String str3 = (String) PaymentRequestStatus.f15973b.get(this.initialStatus);
            if (str3 != null) {
                stringBuilder.append(str3);
                stringBuilder.append(" (");
            }
            stringBuilder.append(this.initialStatus);
            if (str3 != null) {
                stringBuilder.append(")");
            }
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("currency");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.currency == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.currency, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("amount");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.amount == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.amount, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("amountOffset");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.amountOffset == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.amountOffset, i + 1, z));
        }
        if (this.offlineThreadingId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("offlineThreadingId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.offlineThreadingId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.offlineThreadingId, i + 1, z));
            }
        }
        if (this.memoText != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("memoText");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.memoText == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.memoText, i + 1, z));
            }
        }
        if (this.hasMemoMultimedia != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("hasMemoMultimedia");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.hasMemoMultimedia == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.hasMemoMultimedia, i + 1, z));
            }
        }
        if (this.themeId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("themeId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.themeId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.themeId, i + 1, z));
            }
        }
        if (this.groupThreadFbId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("groupThreadFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.groupThreadFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.groupThreadFbId, i + 1, z));
            }
        }
        if (this.irisSeqId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("irisSeqId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.irisSeqId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.irisSeqId, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m16057a() {
        if (this.requestFbId == null) {
            throw new TProtocolException(6, "Required field 'requestFbId' was not present! Struct: " + toString());
        } else if (this.requesterFbId == null) {
            throw new TProtocolException(6, "Required field 'requesterFbId' was not present! Struct: " + toString());
        } else if (this.requesteeFbId == null) {
            throw new TProtocolException(6, "Required field 'requesteeFbId' was not present! Struct: " + toString());
        } else if (this.timestampMs == null) {
            throw new TProtocolException(6, "Required field 'timestampMs' was not present! Struct: " + toString());
        } else if (this.initialStatus == null) {
            throw new TProtocolException(6, "Required field 'initialStatus' was not present! Struct: " + toString());
        } else if (this.currency == null) {
            throw new TProtocolException(6, "Required field 'currency' was not present! Struct: " + toString());
        } else if (this.amount == null) {
            throw new TProtocolException(6, "Required field 'amount' was not present! Struct: " + toString());
        } else if (this.amountOffset == null) {
            throw new TProtocolException(6, "Required field 'amountOffset' was not present! Struct: " + toString());
        } else if (this.initialStatus != null && !PaymentRequestStatus.f15972a.contains(this.initialStatus)) {
            throw new TProtocolException("The field 'initialStatus' has been assigned the invalid value " + this.initialStatus);
        }
    }
}
