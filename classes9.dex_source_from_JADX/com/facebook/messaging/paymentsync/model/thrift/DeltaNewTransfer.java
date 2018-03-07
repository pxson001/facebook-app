package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: earlier_source */
public class DeltaNewTransfer implements TBase, Serializable, Cloneable {
    public static boolean f15873a = true;
    private static final TStruct f15874b = new TStruct("DeltaNewTransfer");
    private static final TField f15875c = new TField("transferFbId", (byte) 10, (short) 1);
    private static final TField f15876d = new TField("senderFbId", (byte) 10, (short) 2);
    private static final TField f15877e = new TField("recipientFbId", (byte) 10, (short) 3);
    private static final TField f15878f = new TField("timestampMs", (byte) 10, (short) 4);
    private static final TField f15879g = new TField("initialStatus", (byte) 8, (short) 5);
    private static final TField f15880h = new TField("currency", (byte) 11, (short) 6);
    private static final TField f15881i = new TField("amount", (byte) 10, (short) 7);
    private static final TField f15882j = new TField("amountOffset", (byte) 8, (short) 8);
    private static final TField f15883k = new TField("offlineThreadingId", (byte) 10, (short) 9);
    private static final TField f15884l = new TField("requestFbId", (byte) 10, (short) 10);
    private static final TField f15885m = new TField("senderStatus", (byte) 8, (short) 11);
    private static final TField f15886n = new TField("receiverStatus", (byte) 8, (short) 12);
    private static final TField f15887o = new TField("amountFBDiscount", (byte) 10, (short) 13);
    private static final TField f15888p = new TField("commerceOrderId", (byte) 11, (short) 14);
    private static final TField f15889q = new TField("platformItemId", (byte) 10, (short) 15);
    private static final TField f15890r = new TField("memoText", (byte) 11, (short) 16);
    private static final TField f15891s = new TField("hasMemoMultimedia", (byte) 2, (short) 17);
    private static final TField f15892t = new TField("transferType", (byte) 8, (short) 18);
    private static final TField f15893u = new TField("themeId", (byte) 10, (short) 19);
    private static final TField f15894v = new TField("groupThreadFbId", (byte) 10, (short) 20);
    private static final TField f15895w = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Long amount;
    public final Long amountFBDiscount;
    public final Integer amountOffset;
    public final String commerceOrderId;
    public final String currency;
    public final Long groupThreadFbId;
    public final Boolean hasMemoMultimedia;
    public final Integer initialStatus;
    public final Long irisSeqId;
    public final String memoText;
    public final Long offlineThreadingId;
    public final Long platformItemId;
    public final Integer receiverStatus;
    public final Long recipientFbId;
    public final Long requestFbId;
    public final Long senderFbId;
    public final Integer senderStatus;
    public final Long themeId;
    public final Long timestampMs;
    public final Long transferFbId;
    public final Integer transferType;

    private DeltaNewTransfer(Long l, Long l2, Long l3, Long l4, Integer num, String str, Long l5, Integer num2, Long l6, Long l7, Integer num3, Integer num4, Long l8, String str2, Long l9, String str3, Boolean bool, Integer num5, Long l10, Long l11, Long l12) {
        this.transferFbId = l;
        this.senderFbId = l2;
        this.recipientFbId = l3;
        this.timestampMs = l4;
        this.initialStatus = num;
        this.currency = str;
        this.amount = l5;
        this.amountOffset = num2;
        this.offlineThreadingId = l6;
        this.requestFbId = l7;
        this.senderStatus = num3;
        this.receiverStatus = num4;
        this.amountFBDiscount = l8;
        this.commerceOrderId = str2;
        this.platformItemId = l9;
        this.memoText = str3;
        this.hasMemoMultimedia = bool;
        this.transferType = num5;
        this.themeId = l10;
        this.groupThreadFbId = l11;
        this.irisSeqId = l12;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaNewTransfer)) {
            return false;
        }
        DeltaNewTransfer deltaNewTransfer = (DeltaNewTransfer) obj;
        boolean z = false;
        if (deltaNewTransfer != null) {
            Object obj2;
            Object obj3 = this.transferFbId != null ? 1 : null;
            if (deltaNewTransfer.transferFbId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.transferFbId.equals(deltaNewTransfer.transferFbId))) {
                if (this.senderFbId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaNewTransfer.senderFbId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.senderFbId.equals(deltaNewTransfer.senderFbId))) {
                    if (this.recipientFbId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaNewTransfer.recipientFbId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.recipientFbId.equals(deltaNewTransfer.recipientFbId))) {
                        if (this.timestampMs != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaNewTransfer.timestampMs != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.timestampMs.equals(deltaNewTransfer.timestampMs))) {
                            if (this.initialStatus != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (deltaNewTransfer.initialStatus != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.initialStatus.equals(deltaNewTransfer.initialStatus))) {
                                if (this.currency != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (deltaNewTransfer.currency != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.currency.equals(deltaNewTransfer.currency))) {
                                    if (this.amount != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (deltaNewTransfer.amount != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.amount.equals(deltaNewTransfer.amount))) {
                                        if (this.amountOffset != null) {
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        if (deltaNewTransfer.amountOffset != null) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.amountOffset.equals(deltaNewTransfer.amountOffset))) {
                                            if (this.offlineThreadingId != null) {
                                                obj3 = 1;
                                            } else {
                                                obj3 = null;
                                            }
                                            if (deltaNewTransfer.offlineThreadingId != null) {
                                                obj2 = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.offlineThreadingId.equals(deltaNewTransfer.offlineThreadingId))) {
                                                if (this.requestFbId != null) {
                                                    obj3 = 1;
                                                } else {
                                                    obj3 = null;
                                                }
                                                if (deltaNewTransfer.requestFbId != null) {
                                                    obj2 = 1;
                                                } else {
                                                    obj2 = null;
                                                }
                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.requestFbId.equals(deltaNewTransfer.requestFbId))) {
                                                    if (this.senderStatus != null) {
                                                        obj3 = 1;
                                                    } else {
                                                        obj3 = null;
                                                    }
                                                    if (deltaNewTransfer.senderStatus != null) {
                                                        obj2 = 1;
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.senderStatus.equals(deltaNewTransfer.senderStatus))) {
                                                        if (this.receiverStatus != null) {
                                                            obj3 = 1;
                                                        } else {
                                                            obj3 = null;
                                                        }
                                                        if (deltaNewTransfer.receiverStatus != null) {
                                                            obj2 = 1;
                                                        } else {
                                                            obj2 = null;
                                                        }
                                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.receiverStatus.equals(deltaNewTransfer.receiverStatus))) {
                                                            if (this.amountFBDiscount != null) {
                                                                obj3 = 1;
                                                            } else {
                                                                obj3 = null;
                                                            }
                                                            if (deltaNewTransfer.amountFBDiscount != null) {
                                                                obj2 = 1;
                                                            } else {
                                                                obj2 = null;
                                                            }
                                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.amountFBDiscount.equals(deltaNewTransfer.amountFBDiscount))) {
                                                                if (this.commerceOrderId != null) {
                                                                    obj3 = 1;
                                                                } else {
                                                                    obj3 = null;
                                                                }
                                                                if (deltaNewTransfer.commerceOrderId != null) {
                                                                    obj2 = 1;
                                                                } else {
                                                                    obj2 = null;
                                                                }
                                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.commerceOrderId.equals(deltaNewTransfer.commerceOrderId))) {
                                                                    if (this.platformItemId != null) {
                                                                        obj3 = 1;
                                                                    } else {
                                                                        obj3 = null;
                                                                    }
                                                                    if (deltaNewTransfer.platformItemId != null) {
                                                                        obj2 = 1;
                                                                    } else {
                                                                        obj2 = null;
                                                                    }
                                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.platformItemId.equals(deltaNewTransfer.platformItemId))) {
                                                                        if (this.memoText != null) {
                                                                            obj3 = 1;
                                                                        } else {
                                                                            obj3 = null;
                                                                        }
                                                                        if (deltaNewTransfer.memoText != null) {
                                                                            obj2 = 1;
                                                                        } else {
                                                                            obj2 = null;
                                                                        }
                                                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.memoText.equals(deltaNewTransfer.memoText))) {
                                                                            if (this.hasMemoMultimedia != null) {
                                                                                obj3 = 1;
                                                                            } else {
                                                                                obj3 = null;
                                                                            }
                                                                            if (deltaNewTransfer.hasMemoMultimedia != null) {
                                                                                obj2 = 1;
                                                                            } else {
                                                                                obj2 = null;
                                                                            }
                                                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.hasMemoMultimedia.equals(deltaNewTransfer.hasMemoMultimedia))) {
                                                                                if (this.transferType != null) {
                                                                                    obj3 = 1;
                                                                                } else {
                                                                                    obj3 = null;
                                                                                }
                                                                                if (deltaNewTransfer.transferType != null) {
                                                                                    obj2 = 1;
                                                                                } else {
                                                                                    obj2 = null;
                                                                                }
                                                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.transferType.equals(deltaNewTransfer.transferType))) {
                                                                                    if (this.themeId != null) {
                                                                                        obj3 = 1;
                                                                                    } else {
                                                                                        obj3 = null;
                                                                                    }
                                                                                    if (deltaNewTransfer.themeId != null) {
                                                                                        obj2 = 1;
                                                                                    } else {
                                                                                        obj2 = null;
                                                                                    }
                                                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.themeId.equals(deltaNewTransfer.themeId))) {
                                                                                        if (this.groupThreadFbId != null) {
                                                                                            obj3 = 1;
                                                                                        } else {
                                                                                            obj3 = null;
                                                                                        }
                                                                                        if (deltaNewTransfer.groupThreadFbId != null) {
                                                                                            obj2 = 1;
                                                                                        } else {
                                                                                            obj2 = null;
                                                                                        }
                                                                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.groupThreadFbId.equals(deltaNewTransfer.groupThreadFbId))) {
                                                                                            if (this.irisSeqId != null) {
                                                                                                obj3 = 1;
                                                                                            } else {
                                                                                                obj3 = null;
                                                                                            }
                                                                                            if (deltaNewTransfer.irisSeqId != null) {
                                                                                                obj2 = 1;
                                                                                            } else {
                                                                                                obj2 = null;
                                                                                            }
                                                                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaNewTransfer.irisSeqId))) {
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

    public static DeltaNewTransfer m16062b(TProtocol tProtocol) {
        Long l = null;
        Long l2 = null;
        Long l3 = null;
        Long l4 = null;
        Integer num = null;
        String str = null;
        Long l5 = null;
        Integer num2 = null;
        Long l6 = null;
        Long l7 = null;
        Integer num3 = null;
        Integer num4 = null;
        Long l8 = null;
        String str2 = null;
        Long l9 = null;
        String str3 = null;
        Boolean bool = null;
        Integer num5 = null;
        Long l10 = null;
        Long l11 = null;
        Long l12 = null;
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
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l7 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 11:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num3 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 12:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num4 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 13:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l8 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 14:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 15:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l9 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 16:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str3 = tProtocol.p();
                        break;
                    case (short) 17:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 18:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num5 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 19:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l10 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 20:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l11 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 1000:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l12 = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaNewTransfer deltaNewTransfer = new DeltaNewTransfer(l, l2, l3, l4, num, str, l5, num2, l6, l7, num3, num4, l8, str2, l9, str3, bool, num5, l10, l11, l12);
            deltaNewTransfer.m16061a();
            return deltaNewTransfer;
        }
    }

    public final void m16064a(TProtocol tProtocol) {
        m16061a();
        tProtocol.a();
        if (!(this.transferFbId == null || this.transferFbId == null)) {
            tProtocol.a(f15875c);
            tProtocol.a(this.transferFbId.longValue());
        }
        if (!(this.senderFbId == null || this.senderFbId == null)) {
            tProtocol.a(f15876d);
            tProtocol.a(this.senderFbId.longValue());
        }
        if (!(this.recipientFbId == null || this.recipientFbId == null)) {
            tProtocol.a(f15877e);
            tProtocol.a(this.recipientFbId.longValue());
        }
        if (!(this.timestampMs == null || this.timestampMs == null)) {
            tProtocol.a(f15878f);
            tProtocol.a(this.timestampMs.longValue());
        }
        if (!(this.initialStatus == null || this.initialStatus == null)) {
            tProtocol.a(f15879g);
            tProtocol.a(this.initialStatus.intValue());
        }
        if (!(this.currency == null || this.currency == null)) {
            tProtocol.a(f15880h);
            tProtocol.a(this.currency);
        }
        if (!(this.amount == null || this.amount == null)) {
            tProtocol.a(f15881i);
            tProtocol.a(this.amount.longValue());
        }
        if (!(this.amountOffset == null || this.amountOffset == null)) {
            tProtocol.a(f15882j);
            tProtocol.a(this.amountOffset.intValue());
        }
        if (!(this.offlineThreadingId == null || this.offlineThreadingId == null)) {
            tProtocol.a(f15883k);
            tProtocol.a(this.offlineThreadingId.longValue());
        }
        if (!(this.requestFbId == null || this.requestFbId == null)) {
            tProtocol.a(f15884l);
            tProtocol.a(this.requestFbId.longValue());
        }
        if (!(this.senderStatus == null || this.senderStatus == null)) {
            tProtocol.a(f15885m);
            tProtocol.a(this.senderStatus.intValue());
        }
        if (!(this.receiverStatus == null || this.receiverStatus == null)) {
            tProtocol.a(f15886n);
            tProtocol.a(this.receiverStatus.intValue());
        }
        if (!(this.amountFBDiscount == null || this.amountFBDiscount == null)) {
            tProtocol.a(f15887o);
            tProtocol.a(this.amountFBDiscount.longValue());
        }
        if (!(this.commerceOrderId == null || this.commerceOrderId == null)) {
            tProtocol.a(f15888p);
            tProtocol.a(this.commerceOrderId);
        }
        if (!(this.platformItemId == null || this.platformItemId == null)) {
            tProtocol.a(f15889q);
            tProtocol.a(this.platformItemId.longValue());
        }
        if (!(this.memoText == null || this.memoText == null)) {
            tProtocol.a(f15890r);
            tProtocol.a(this.memoText);
        }
        if (!(this.hasMemoMultimedia == null || this.hasMemoMultimedia == null)) {
            tProtocol.a(f15891s);
            tProtocol.a(this.hasMemoMultimedia.booleanValue());
        }
        if (!(this.transferType == null || this.transferType == null)) {
            tProtocol.a(f15892t);
            tProtocol.a(this.transferType.intValue());
        }
        if (!(this.themeId == null || this.themeId == null)) {
            tProtocol.a(f15893u);
            tProtocol.a(this.themeId.longValue());
        }
        if (!(this.groupThreadFbId == null || this.groupThreadFbId == null)) {
            tProtocol.a(f15894v);
            tProtocol.a(this.groupThreadFbId.longValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15895w);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16063a(1, f15873a);
    }

    public final String m16063a(int i, boolean z) {
        String str;
        Object obj = null;
        String a = z ? TBaseHelper.a(i) : "";
        String str2 = z ? "\n" : "";
        String str3 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaNewTransfer");
        stringBuilder.append(str3);
        stringBuilder.append("(");
        stringBuilder.append(str2);
        Object obj2 = 1;
        if (this.transferFbId != null) {
            stringBuilder.append(a);
            stringBuilder.append("transferFbId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.transferFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.transferFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.senderFbId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("senderFbId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.senderFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.senderFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.recipientFbId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("recipientFbId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.recipientFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.recipientFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.timestampMs != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("timestampMs");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.timestampMs == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.timestampMs, i + 1, z));
            }
            obj2 = null;
        }
        if (this.initialStatus != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("initialStatus");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.initialStatus == null) {
                stringBuilder.append("null");
            } else {
                str = (String) PaymentStatus.f15975b.get(this.initialStatus);
                if (str != null) {
                    stringBuilder.append(str);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.initialStatus);
                if (str != null) {
                    stringBuilder.append(")");
                }
            }
            obj2 = null;
        }
        if (this.currency != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("currency");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.currency == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.currency, i + 1, z));
            }
            obj2 = null;
        }
        if (this.amount != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("amount");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.amount == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.amount, i + 1, z));
            }
            obj2 = null;
        }
        if (this.amountOffset != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("amountOffset");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.amountOffset == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.amountOffset, i + 1, z));
            }
            obj2 = null;
        }
        if (this.offlineThreadingId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("offlineThreadingId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.offlineThreadingId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.offlineThreadingId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.requestFbId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("requestFbId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.requestFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.requestFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.senderStatus != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("senderStatus");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.senderStatus == null) {
                stringBuilder.append("null");
            } else {
                str = (String) SenderStatus.f15989b.get(this.senderStatus);
                if (str != null) {
                    stringBuilder.append(str);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.senderStatus);
                if (str != null) {
                    stringBuilder.append(")");
                }
            }
            obj2 = null;
        }
        if (this.receiverStatus != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("receiverStatus");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.receiverStatus == null) {
                stringBuilder.append("null");
            } else {
                str = (String) ReceiverStatus.f15987b.get(this.receiverStatus);
                if (str != null) {
                    stringBuilder.append(str);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.receiverStatus);
                if (str != null) {
                    stringBuilder.append(")");
                }
            }
            obj2 = null;
        }
        if (this.amountFBDiscount != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("amountFBDiscount");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.amountFBDiscount == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.amountFBDiscount, i + 1, z));
            }
            obj2 = null;
        }
        if (this.commerceOrderId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("commerceOrderId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.commerceOrderId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.commerceOrderId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.platformItemId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("platformItemId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.platformItemId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.platformItemId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.memoText != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("memoText");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.memoText == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.memoText, i + 1, z));
            }
            obj2 = null;
        }
        if (this.hasMemoMultimedia != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("hasMemoMultimedia");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.hasMemoMultimedia == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.hasMemoMultimedia, i + 1, z));
            }
            obj2 = null;
        }
        if (this.transferType != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("transferType");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.transferType == null) {
                stringBuilder.append("null");
            } else {
                str = (String) TransferType.f15991b.get(this.transferType);
                if (str != null) {
                    stringBuilder.append(str);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.transferType);
                if (str != null) {
                    stringBuilder.append(")");
                }
            }
            obj2 = null;
        }
        if (this.themeId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("themeId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.themeId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.themeId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.groupThreadFbId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("groupThreadFbId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.groupThreadFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.groupThreadFbId, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.irisSeqId != null) {
            if (obj == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("irisSeqId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.irisSeqId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.irisSeqId, i + 1, z));
            }
        }
        stringBuilder.append(str2 + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m16061a() {
        if (this.initialStatus != null && !PaymentStatus.f15974a.contains(this.initialStatus)) {
            throw new TProtocolException("The field 'initialStatus' has been assigned the invalid value " + this.initialStatus);
        } else if (this.senderStatus != null && !SenderStatus.f15988a.contains(this.senderStatus)) {
            throw new TProtocolException("The field 'senderStatus' has been assigned the invalid value " + this.senderStatus);
        } else if (this.receiverStatus != null && !ReceiverStatus.f15986a.contains(this.receiverStatus)) {
            throw new TProtocolException("The field 'receiverStatus' has been assigned the invalid value " + this.receiverStatus);
        } else if (this.transferType != null && !TransferType.f15990a.contains(this.transferType)) {
            throw new TProtocolException("The field 'transferType' has been assigned the invalid value " + this.transferType);
        }
    }
}
