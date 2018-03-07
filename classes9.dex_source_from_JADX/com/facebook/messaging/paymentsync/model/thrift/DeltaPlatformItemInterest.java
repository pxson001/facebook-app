package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: draw done */
public class DeltaPlatformItemInterest implements TBase, Serializable, Cloneable {
    public static boolean f15946a = true;
    private static final TStruct f15947b = new TStruct("DeltaPlatformItemInterest");
    private static final TField f15948c = new TField("platformItemFbId", (byte) 10, (short) 1);
    private static final TField f15949d = new TField("sellerFbId", (byte) 10, (short) 2);
    private static final TField f15950e = new TField("buyerFbId", (byte) 10, (short) 3);
    private static final TField f15951f = new TField("shouldShowToSeller", (byte) 2, (short) 4);
    private static final TField f15952g = new TField("shouldShowToBuyer", (byte) 2, (short) 5);
    private static final TField f15953h = new TField("timestampMs", (byte) 10, (short) 6);
    private static final TField f15954i = new TField("name", (byte) 11, (short) 7);
    private static final TField f15955j = new TField("currency", (byte) 11, (short) 8);
    private static final TField f15956k = new TField("priceAmount", (byte) 10, (short) 9);
    private static final TField f15957l = new TField("priceAmountOffset", (byte) 8, (short) 10);
    private static final TField f15958m = new TField("availability", (byte) 8, (short) 11);
    private static final TField f15959n = new TField("referenceURL", (byte) 11, (short) 12);
    private static final TField f15960o = new TField("photoFbIds", (byte) 15, (short) 13);
    private static final TField f15961p = new TField("platformContextFbId", (byte) 10, (short) 14);
    private static final TField f15962q = new TField("shouldShowPayOption", (byte) 2, (short) 15);
    private static final TField f15963r = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Integer availability;
    public final Long buyerFbId;
    public final String currency;
    public final Long irisSeqId;
    public final String name;
    public final List<Long> photoFbIds;
    public final Long platformContextFbId;
    public final Long platformItemFbId;
    public final Long priceAmount;
    public final Integer priceAmountOffset;
    public final String referenceURL;
    public final Long sellerFbId;
    public final Boolean shouldShowPayOption;
    public final Boolean shouldShowToBuyer;
    public final Boolean shouldShowToSeller;
    public final Long timestampMs;

    private DeltaPlatformItemInterest(Long l, Long l2, Long l3, Boolean bool, Boolean bool2, Long l4, String str, String str2, Long l5, Integer num, Integer num2, String str3, List<Long> list, Long l6, Boolean bool3, Long l7) {
        this.platformItemFbId = l;
        this.sellerFbId = l2;
        this.buyerFbId = l3;
        this.shouldShowToSeller = bool;
        this.shouldShowToBuyer = bool2;
        this.timestampMs = l4;
        this.name = str;
        this.currency = str2;
        this.priceAmount = l5;
        this.priceAmountOffset = num;
        this.availability = num2;
        this.referenceURL = str3;
        this.photoFbIds = list;
        this.platformContextFbId = l6;
        this.shouldShowPayOption = bool3;
        this.irisSeqId = l7;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPlatformItemInterest)) {
            return false;
        }
        DeltaPlatformItemInterest deltaPlatformItemInterest = (DeltaPlatformItemInterest) obj;
        boolean z = false;
        if (deltaPlatformItemInterest != null) {
            Object obj2;
            Object obj3 = this.platformItemFbId != null ? 1 : null;
            if (deltaPlatformItemInterest.platformItemFbId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.platformItemFbId.equals(deltaPlatformItemInterest.platformItemFbId))) {
                if (this.sellerFbId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPlatformItemInterest.sellerFbId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.sellerFbId.equals(deltaPlatformItemInterest.sellerFbId))) {
                    if (this.buyerFbId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaPlatformItemInterest.buyerFbId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.buyerFbId.equals(deltaPlatformItemInterest.buyerFbId))) {
                        if (this.shouldShowToSeller != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaPlatformItemInterest.shouldShowToSeller != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.shouldShowToSeller.equals(deltaPlatformItemInterest.shouldShowToSeller))) {
                            if (this.shouldShowToBuyer != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (deltaPlatformItemInterest.shouldShowToBuyer != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.shouldShowToBuyer.equals(deltaPlatformItemInterest.shouldShowToBuyer))) {
                                if (this.timestampMs != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (deltaPlatformItemInterest.timestampMs != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.timestampMs.equals(deltaPlatformItemInterest.timestampMs))) {
                                    if (this.name != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (deltaPlatformItemInterest.name != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.name.equals(deltaPlatformItemInterest.name))) {
                                        if (this.currency != null) {
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        if (deltaPlatformItemInterest.currency != null) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.currency.equals(deltaPlatformItemInterest.currency))) {
                                            if (this.priceAmount != null) {
                                                obj3 = 1;
                                            } else {
                                                obj3 = null;
                                            }
                                            if (deltaPlatformItemInterest.priceAmount != null) {
                                                obj2 = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.priceAmount.equals(deltaPlatformItemInterest.priceAmount))) {
                                                if (this.priceAmountOffset != null) {
                                                    obj3 = 1;
                                                } else {
                                                    obj3 = null;
                                                }
                                                if (deltaPlatformItemInterest.priceAmountOffset != null) {
                                                    obj2 = 1;
                                                } else {
                                                    obj2 = null;
                                                }
                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.priceAmountOffset.equals(deltaPlatformItemInterest.priceAmountOffset))) {
                                                    if (this.availability != null) {
                                                        obj3 = 1;
                                                    } else {
                                                        obj3 = null;
                                                    }
                                                    if (deltaPlatformItemInterest.availability != null) {
                                                        obj2 = 1;
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.availability.equals(deltaPlatformItemInterest.availability))) {
                                                        if (this.referenceURL != null) {
                                                            obj3 = 1;
                                                        } else {
                                                            obj3 = null;
                                                        }
                                                        if (deltaPlatformItemInterest.referenceURL != null) {
                                                            obj2 = 1;
                                                        } else {
                                                            obj2 = null;
                                                        }
                                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.referenceURL.equals(deltaPlatformItemInterest.referenceURL))) {
                                                            if (this.photoFbIds != null) {
                                                                obj3 = 1;
                                                            } else {
                                                                obj3 = null;
                                                            }
                                                            if (deltaPlatformItemInterest.photoFbIds != null) {
                                                                obj2 = 1;
                                                            } else {
                                                                obj2 = null;
                                                            }
                                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.photoFbIds.equals(deltaPlatformItemInterest.photoFbIds))) {
                                                                if (this.platformContextFbId != null) {
                                                                    obj3 = 1;
                                                                } else {
                                                                    obj3 = null;
                                                                }
                                                                if (deltaPlatformItemInterest.platformContextFbId != null) {
                                                                    obj2 = 1;
                                                                } else {
                                                                    obj2 = null;
                                                                }
                                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.platformContextFbId.equals(deltaPlatformItemInterest.platformContextFbId))) {
                                                                    if (this.shouldShowPayOption != null) {
                                                                        obj3 = 1;
                                                                    } else {
                                                                        obj3 = null;
                                                                    }
                                                                    if (deltaPlatformItemInterest.shouldShowPayOption != null) {
                                                                        obj2 = 1;
                                                                    } else {
                                                                        obj2 = null;
                                                                    }
                                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.shouldShowPayOption.equals(deltaPlatformItemInterest.shouldShowPayOption))) {
                                                                        if (this.irisSeqId != null) {
                                                                            obj3 = 1;
                                                                        } else {
                                                                            obj3 = null;
                                                                        }
                                                                        if (deltaPlatformItemInterest.irisSeqId != null) {
                                                                            obj2 = 1;
                                                                        } else {
                                                                            obj2 = null;
                                                                        }
                                                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaPlatformItemInterest.irisSeqId))) {
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
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaPlatformItemInterest m16102b(TProtocol tProtocol) {
        Long l = null;
        Long l2 = null;
        Long l3 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        Long l4 = null;
        String str = null;
        String str2 = null;
        Long l5 = null;
        Integer num = null;
        Integer num2 = null;
        String str3 = null;
        List list = null;
        Long l6 = null;
        Boolean bool3 = null;
        Long l7 = null;
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
                        if (f.b != (byte) 2) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bool2 = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 6:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l4 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 7:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 8:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 9:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l5 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 10:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 11:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 12:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str3 = tProtocol.p();
                        break;
                    case (short) 13:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.a(tProtocol, f.b);
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
                            list.add(Long.valueOf(tProtocol.n()));
                            i++;
                        }
                    case (short) 14:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l6 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 15:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bool3 = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 1000:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l7 = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaPlatformItemInterest deltaPlatformItemInterest = new DeltaPlatformItemInterest(l, l2, l3, bool, bool2, l4, str, str2, l5, num, num2, str3, list, l6, bool3, l7);
            deltaPlatformItemInterest.m16101a();
            return deltaPlatformItemInterest;
        }
    }

    public final void m16104a(TProtocol tProtocol) {
        m16101a();
        tProtocol.a();
        if (this.platformItemFbId != null) {
            tProtocol.a(f15948c);
            tProtocol.a(this.platformItemFbId.longValue());
        }
        if (this.sellerFbId != null) {
            tProtocol.a(f15949d);
            tProtocol.a(this.sellerFbId.longValue());
        }
        if (this.buyerFbId != null) {
            tProtocol.a(f15950e);
            tProtocol.a(this.buyerFbId.longValue());
        }
        if (this.shouldShowToSeller != null) {
            tProtocol.a(f15951f);
            tProtocol.a(this.shouldShowToSeller.booleanValue());
        }
        if (this.shouldShowToBuyer != null) {
            tProtocol.a(f15952g);
            tProtocol.a(this.shouldShowToBuyer.booleanValue());
        }
        if (this.timestampMs != null) {
            tProtocol.a(f15953h);
            tProtocol.a(this.timestampMs.longValue());
        }
        if (!(this.name == null || this.name == null)) {
            tProtocol.a(f15954i);
            tProtocol.a(this.name);
        }
        if (!(this.currency == null || this.currency == null)) {
            tProtocol.a(f15955j);
            tProtocol.a(this.currency);
        }
        if (!(this.priceAmount == null || this.priceAmount == null)) {
            tProtocol.a(f15956k);
            tProtocol.a(this.priceAmount.longValue());
        }
        if (!(this.priceAmountOffset == null || this.priceAmountOffset == null)) {
            tProtocol.a(f15957l);
            tProtocol.a(this.priceAmountOffset.intValue());
        }
        if (!(this.availability == null || this.availability == null)) {
            tProtocol.a(f15958m);
            tProtocol.a(this.availability.intValue());
        }
        if (!(this.referenceURL == null || this.referenceURL == null)) {
            tProtocol.a(f15959n);
            tProtocol.a(this.referenceURL);
        }
        if (!(this.photoFbIds == null || this.photoFbIds == null)) {
            tProtocol.a(f15960o);
            tProtocol.a(new TList((byte) 10, this.photoFbIds.size()));
            for (Long longValue : this.photoFbIds) {
                tProtocol.a(longValue.longValue());
            }
        }
        if (!(this.platformContextFbId == null || this.platformContextFbId == null)) {
            tProtocol.a(f15961p);
            tProtocol.a(this.platformContextFbId.longValue());
        }
        if (!(this.shouldShowPayOption == null || this.shouldShowPayOption == null)) {
            tProtocol.a(f15962q);
            tProtocol.a(this.shouldShowPayOption.booleanValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15963r);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16103a(1, f15946a);
    }

    public final String m16103a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPlatformItemInterest");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("platformItemFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.platformItemFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.platformItemFbId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("sellerFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.sellerFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.sellerFbId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("buyerFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.buyerFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.buyerFbId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("shouldShowToSeller");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.shouldShowToSeller == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.shouldShowToSeller, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("shouldShowToBuyer");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.shouldShowToBuyer == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.shouldShowToBuyer, i + 1, z));
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
        if (this.name != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("name");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.name == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.name, i + 1, z));
            }
        }
        if (this.currency != null) {
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
        }
        if (this.priceAmount != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("priceAmount");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.priceAmount == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.priceAmount, i + 1, z));
            }
        }
        if (this.priceAmountOffset != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("priceAmountOffset");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.priceAmountOffset == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.priceAmountOffset, i + 1, z));
            }
        }
        if (this.availability != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("availability");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.availability == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) ProductAvailability.f15985b.get(this.availability);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.availability);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        if (this.referenceURL != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("referenceURL");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.referenceURL == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.referenceURL, i + 1, z));
            }
        }
        if (this.photoFbIds != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("photoFbIds");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.photoFbIds == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.photoFbIds, i + 1, z));
            }
        }
        if (this.platformContextFbId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("platformContextFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.platformContextFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.platformContextFbId, i + 1, z));
            }
        }
        if (this.shouldShowPayOption != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("shouldShowPayOption");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.shouldShowPayOption == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.shouldShowPayOption, i + 1, z));
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

    private void m16101a() {
        if (this.platformItemFbId == null) {
            throw new TProtocolException(6, "Required field 'platformItemFbId' was not present! Struct: " + toString());
        } else if (this.sellerFbId == null) {
            throw new TProtocolException(6, "Required field 'sellerFbId' was not present! Struct: " + toString());
        } else if (this.buyerFbId == null) {
            throw new TProtocolException(6, "Required field 'buyerFbId' was not present! Struct: " + toString());
        } else if (this.shouldShowToSeller == null) {
            throw new TProtocolException(6, "Required field 'shouldShowToSeller' was not present! Struct: " + toString());
        } else if (this.shouldShowToBuyer == null) {
            throw new TProtocolException(6, "Required field 'shouldShowToBuyer' was not present! Struct: " + toString());
        } else if (this.timestampMs == null) {
            throw new TProtocolException(6, "Required field 'timestampMs' was not present! Struct: " + toString());
        } else if (this.availability != null && !ProductAvailability.f15984a.contains(this.availability)) {
            throw new TProtocolException("The field 'availability' has been assigned the invalid value " + this.availability);
        }
    }
}
