package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.TUnion;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.util.Arrays;

/* compiled from: drop_type */
public class DeltaPaymentWrapper extends TUnion {
    public static boolean f15928a = true;
    private static final TStruct f15929b = new TStruct("DeltaPaymentWrapper");
    private static final TField f15930c = new TField("deltaNewTransfer", (byte) 12, (short) 1);
    private static final TField f15931d = new TField("deltaTransferStatus", (byte) 12, (short) 2);
    private static final TField f15932e = new TField("deltaPaymentMethodUpdated", (byte) 12, (short) 3);
    private static final TField f15933f = new TField("deltaPaymentMethodRemoved", (byte) 12, (short) 4);
    private static final TField f15934g = new TField("deltaPaymentMethodPrimary", (byte) 12, (short) 5);
    private static final TField f15935h = new TField("deltaPinCode", (byte) 12, (short) 6);
    private static final TField f15936i = new TField("deltaPaymentNoOp", (byte) 12, (short) 7);
    private static final TField f15937j = new TField("deltaPaymentForcedFetch", (byte) 12, (short) 8);
    private static final TField f15938k = new TField("deltaPaymentEnable", (byte) 12, (short) 9);
    private static final TField f15939l = new TField("deltaNewPaymentRequest", (byte) 12, (short) 10);
    private static final TField f15940m = new TField("deltaPaymentRequestStatus", (byte) 12, (short) 11);
    private static final TField f15941n = new TField("deltaPlatformItemInterest", (byte) 12, (short) 12);

    private DeltaPaymentMethodUpdated m16083j() {
        if (this.setField_ == 3) {
            return (DeltaPaymentMethodUpdated) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPaymentMethodUpdated' because union is currently set to " + m16088a(this.setField_).a);
    }

    private DeltaPaymentMethodRemoved m16084k() {
        if (this.setField_ == 4) {
            return (DeltaPaymentMethodRemoved) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPaymentMethodRemoved' because union is currently set to " + m16088a(this.setField_).a);
    }

    private DeltaPaymentMethodPrimary m16085l() {
        if (this.setField_ == 5) {
            return (DeltaPaymentMethodPrimary) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPaymentMethodPrimary' because union is currently set to " + m16088a(this.setField_).a);
    }

    private DeltaPaymentNoOp m16086m() {
        if (this.setField_ == 7) {
            return (DeltaPaymentNoOp) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPaymentNoOp' because union is currently set to " + m16088a(this.setField_).a);
    }

    private DeltaPlatformItemInterest m16087n() {
        if (this.setField_ == 12) {
            return (DeltaPlatformItemInterest) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPlatformItemInterest' because union is currently set to " + m16088a(this.setField_).a);
    }

    public final DeltaNewTransfer m16092c() {
        if (this.setField_ == 1) {
            return (DeltaNewTransfer) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaNewTransfer' because union is currently set to " + m16088a(this.setField_).a);
    }

    public final DeltaTransferStatus m16093d() {
        if (this.setField_ == 2) {
            return (DeltaTransferStatus) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaTransferStatus' because union is currently set to " + m16088a(this.setField_).a);
    }

    public final DeltaPinCode m16094e() {
        if (this.setField_ == 6) {
            return (DeltaPinCode) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPinCode' because union is currently set to " + m16088a(this.setField_).a);
    }

    public final DeltaPaymentForcedFetch m16095f() {
        if (this.setField_ == 8) {
            return (DeltaPaymentForcedFetch) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPaymentForcedFetch' because union is currently set to " + m16088a(this.setField_).a);
    }

    public final DeltaPaymentEnable m16096g() {
        if (this.setField_ == 9) {
            return (DeltaPaymentEnable) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPaymentEnable' because union is currently set to " + m16088a(this.setField_).a);
    }

    public final DeltaNewPaymentRequest m16097h() {
        if (this.setField_ == 10) {
            return (DeltaNewPaymentRequest) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaNewPaymentRequest' because union is currently set to " + m16088a(this.setField_).a);
    }

    public final DeltaPaymentRequestStatus m16098i() {
        if (this.setField_ == 11) {
            return (DeltaPaymentRequestStatus) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPaymentRequestStatus' because union is currently set to " + m16088a(this.setField_).a);
    }

    public final Object m16089a(TProtocol tProtocol, TField tField) {
        Long l;
        Long l2;
        TField f;
        switch (tField.c) {
            case (short) 1:
                if (tField.b == f15930c.b) {
                    return DeltaNewTransfer.m16062b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 2:
                if (tField.b == f15931d.b) {
                    return DeltaTransferStatus.m16106b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 3:
                if (tField.b == f15932e.b) {
                    l = null;
                    tProtocol.r();
                    l2 = null;
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 1:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l2 = Long.valueOf(tProtocol.n());
                                    break;
                                case (short) 1000:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l = Long.valueOf(tProtocol.n());
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new DeltaPaymentMethodUpdated(l2, l);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 4:
                if (tField.b == f15933f.b) {
                    l = null;
                    tProtocol.r();
                    l2 = null;
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 1:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l2 = Long.valueOf(tProtocol.n());
                                    break;
                                case (short) 1000:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l = Long.valueOf(tProtocol.n());
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new DeltaPaymentMethodRemoved(l2, l);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 5:
                if (tField.b == f15934g.b) {
                    l = null;
                    tProtocol.r();
                    l2 = null;
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 1:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l2 = Long.valueOf(tProtocol.n());
                                    break;
                                case (short) 1000:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l = Long.valueOf(tProtocol.n());
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new DeltaPaymentMethodPrimary(l2, l);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 6:
                if (tField.b == f15935h.b) {
                    l = null;
                    tProtocol.r();
                    l2 = null;
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 1:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l2 = Long.valueOf(tProtocol.n());
                                    break;
                                case (short) 1000:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l = Long.valueOf(tProtocol.n());
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new DeltaPinCode(l2, l);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 7:
                if (tField.b == f15936i.b) {
                    l = null;
                    tProtocol.r();
                    Integer num = null;
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 1:
                                    if (f.b != (byte) 8) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    num = Integer.valueOf(tProtocol.m());
                                    break;
                                case (short) 1000:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l = Long.valueOf(tProtocol.n());
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new DeltaPaymentNoOp(num, l);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 8:
                if (tField.b == f15937j.b) {
                    return DeltaPaymentForcedFetch.m16067b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 9:
                if (tField.b == f15938k.b) {
                    l = null;
                    tProtocol.r();
                    Boolean bool = null;
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 1:
                                    if (f.b != (byte) 2) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    bool = Boolean.valueOf(tProtocol.j());
                                    break;
                                case (short) 1000:
                                    if (f.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    l = Long.valueOf(tProtocol.n());
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new DeltaPaymentEnable(bool, l);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 10:
                if (tField.b == f15939l.b) {
                    return DeltaNewPaymentRequest.m16058b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 11:
                if (tField.b == f15940m.b) {
                    return DeltaPaymentRequestStatus.m16079b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 12:
                if (tField.b == f15941n.b) {
                    return DeltaPlatformItemInterest.m16102b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            default:
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
        }
    }

    protected final void m16091a(TProtocol tProtocol, short s) {
        switch (s) {
            case (short) 1:
                ((DeltaNewTransfer) this.value_).m16064a(tProtocol);
                return;
            case (short) 2:
                ((DeltaTransferStatus) this.value_).m16108a(tProtocol);
                return;
            case (short) 3:
                ((DeltaPaymentMethodUpdated) this.value_).m16075a(tProtocol);
                return;
            case (short) 4:
                ((DeltaPaymentMethodRemoved) this.value_).m16073a(tProtocol);
                return;
            case (short) 5:
                ((DeltaPaymentMethodPrimary) this.value_).m16071a(tProtocol);
                return;
            case (short) 6:
                ((DeltaPinCode) this.value_).m16100a(tProtocol);
                return;
            case (short) 7:
                ((DeltaPaymentNoOp) this.value_).m16077a(tProtocol);
                return;
            case (short) 8:
                ((DeltaPaymentForcedFetch) this.value_).m16069a(tProtocol);
                return;
            case (short) 9:
                ((DeltaPaymentEnable) this.value_).m16066a(tProtocol);
                return;
            case (short) 10:
                ((DeltaNewPaymentRequest) this.value_).m16060a(tProtocol);
                return;
            case (short) 11:
                ((DeltaPaymentRequestStatus) this.value_).m16081a(tProtocol);
                return;
            case (short) 12:
                ((DeltaPlatformItemInterest) this.value_).m16104a(tProtocol);
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + s);
        }
    }

    protected final TField m16088a(int i) {
        switch (i) {
            case 1:
                return f15930c;
            case 2:
                return f15931d;
            case 3:
                return f15932e;
            case 4:
                return f15933f;
            case 5:
                return f15934g;
            case 6:
                return f15935h;
            case 7:
                return f15936i;
            case 8:
                return f15937j;
            case 9:
                return f15938k;
            case 10:
                return f15939l;
            case 11:
                return f15940m;
            case 12:
                return f15941n;
            default:
                throw new IllegalArgumentException("Unknown field id " + i);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DeltaPaymentWrapper)) {
            return false;
        }
        boolean z;
        DeltaPaymentWrapper deltaPaymentWrapper = (DeltaPaymentWrapper) obj;
        if (this.setField_ != deltaPaymentWrapper.setField_ || ((this.value_ instanceof byte[]) ? Arrays.equals((byte[]) this.value_, (byte[]) deltaPaymentWrapper.value_) : this.value_.equals(deltaPaymentWrapper.value_))) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaPaymentWrapper m16082b(TProtocol tProtocol) {
        DeltaPaymentWrapper deltaPaymentWrapper = new DeltaPaymentWrapper();
        DeltaPaymentWrapper deltaPaymentWrapper2 = new DeltaPaymentWrapper();
        deltaPaymentWrapper2.setField_ = 0;
        deltaPaymentWrapper2.value_ = null;
        tProtocol.r();
        TField f = tProtocol.f();
        deltaPaymentWrapper2.value_ = deltaPaymentWrapper2.m16089a(tProtocol, f);
        if (deltaPaymentWrapper2.value_ != null) {
            deltaPaymentWrapper2.setField_ = f.c;
        }
        tProtocol.f();
        tProtocol.e();
        return deltaPaymentWrapper2;
    }

    public String toString() {
        return m16090a(1, f15928a);
    }

    public final String m16090a(int i, boolean z) {
        Object obj = 1;
        Object obj2 = null;
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPaymentWrapper");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.setField_ == 1) {
            stringBuilder.append(a);
            stringBuilder.append("deltaNewTransfer");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16092c() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16092c(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 2) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaTransferStatus");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16093d() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16093d(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 3) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPaymentMethodUpdated");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16083j() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16083j(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 4) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPaymentMethodRemoved");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16084k() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16084k(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 5) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPaymentMethodPrimary");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16085l() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16085l(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 6) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPinCode");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16094e() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16094e(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 7) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPaymentNoOp");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16086m() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16086m(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 8) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPaymentForcedFetch");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16095f() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16095f(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 9) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPaymentEnable");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16096g() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16096g(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 10) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaNewPaymentRequest");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16097h() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16097h(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 11) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPaymentRequestStatus");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16098i() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16098i(), i + 1, z));
            }
        } else {
            obj2 = obj;
        }
        if (this.setField_ == 12) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPlatformItemInterest");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m16087n() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m16087n(), i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
