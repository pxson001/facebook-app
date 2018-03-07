package com.facebook.mqtt.model.thrift;

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

/* compiled from: to_privacy */
public class CallabilityResponse implements TBase, Serializable, Cloneable {
    public static boolean f2875a = true;
    private static final TStruct f2876b = new TStruct("CallabilityResponse");
    private static final TField f2877c = new TField("results", (byte) 15, (short) 1);
    public final List<Callability> results;

    private CallabilityResponse(List<Callability> list) {
        this.results = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CallabilityResponse)) {
            return false;
        }
        CallabilityResponse callabilityResponse = (CallabilityResponse) obj;
        boolean z = false;
        if (callabilityResponse != null) {
            Object obj2 = this.results != null ? 1 : null;
            Object obj3;
            if (callabilityResponse.results != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.results.equals(callabilityResponse.results))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static CallabilityResponse m3968b(TProtocol tProtocol) {
        List list = null;
        tProtocol.r();
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
                        List arrayList = new ArrayList(Math.max(0, h.b));
                        int i = 0;
                        while (true) {
                            if (h.b < 0) {
                                if (!TProtocol.t()) {
                                    list = arrayList;
                                    break;
                                }
                            } else if (i >= h.b) {
                                list = arrayList;
                            }
                            Integer num = null;
                            tProtocol.r();
                            Boolean bool = null;
                            Boolean bool2 = null;
                            Boolean bool3 = null;
                            Long l = null;
                            while (true) {
                                TField f2 = tProtocol.f();
                                if (f2.b != (byte) 0) {
                                    switch (f2.c) {
                                        case (short) 1:
                                            if (f2.b != (byte) 10) {
                                                TProtocolUtil.m7816a(tProtocol, f2.b);
                                                break;
                                            }
                                            l = Long.valueOf(tProtocol.n());
                                            break;
                                        case (short) 2:
                                            if (f2.b != (byte) 2) {
                                                TProtocolUtil.m7816a(tProtocol, f2.b);
                                                break;
                                            }
                                            bool3 = Boolean.valueOf(tProtocol.j());
                                            break;
                                        case (short) 3:
                                            if (f2.b != (byte) 2) {
                                                TProtocolUtil.m7816a(tProtocol, f2.b);
                                                break;
                                            }
                                            bool2 = Boolean.valueOf(tProtocol.j());
                                            break;
                                        case (short) 4:
                                            if (f2.b != (byte) 2) {
                                                TProtocolUtil.m7816a(tProtocol, f2.b);
                                                break;
                                            }
                                            bool = Boolean.valueOf(tProtocol.j());
                                            break;
                                        case (short) 5:
                                            if (f2.b != (byte) 8) {
                                                TProtocolUtil.m7816a(tProtocol, f2.b);
                                                break;
                                            }
                                            num = Integer.valueOf(tProtocol.m());
                                            break;
                                        default:
                                            TProtocolUtil.m7816a(tProtocol, f2.b);
                                            break;
                                    }
                                }
                                tProtocol.e();
                                arrayList.add(new Callability(l, bool3, bool2, bool, num));
                                i++;
                            }
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new CallabilityResponse(list);
        }
    }

    public final void m3970a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.results != null) {
            tProtocol.a(f2877c);
            tProtocol.a(new TList((byte) 12, this.results.size()));
            for (Callability a : this.results) {
                a.m3965a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3969a(1, f2875a);
    }

    public final String m3969a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("CallabilityResponse");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("results");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.results == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.results, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
