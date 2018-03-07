package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.TUnion;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: transcodeSuccessCount */
public class GenericMapMutation extends TUnion {
    public static boolean f2733a = true;
    private static final TStruct f2734b = new TStruct("GenericMapMutation");
    private static final TField f2735c = new TField("keyMutations", (byte) 15, (short) 1);
    private static final TField f2736d = new TField("mapOverwrite", (byte) 12, (short) 2);

    public final Object mo155a(TProtocol tProtocol, TField tField) {
        int i = 0;
        switch (tField.c) {
            case (short) 1:
                if (tField.b == f2735c.b) {
                    TList h = tProtocol.h();
                    List arrayList = new ArrayList(Math.max(0, h.b));
                    while (true) {
                        if (h.b < 0) {
                            if (!TProtocol.t()) {
                                return arrayList;
                            }
                        } else if (i >= h.b) {
                            return arrayList;
                        }
                        arrayList.add(GenericMapKeyMutation.m3885b(tProtocol));
                        i++;
                    }
                } else {
                    TProtocolUtil.m7816a(tProtocol, tField.b);
                    return null;
                }
            case (short) 2:
                if (tField.b == f2736d.b) {
                    return GenericMap.m3881b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            default:
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
        }
    }

    private List<GenericMapKeyMutation> m3889c() {
        if (this.setField_ == 1) {
            return (List) this.value_;
        }
        throw new RuntimeException("Cannot get field 'keyMutations' because union is currently set to " + mo154a(this.setField_).a);
    }

    private GenericMap m3890d() {
        if (this.setField_ == 2) {
            return (GenericMap) this.value_;
        }
        throw new RuntimeException("Cannot get field 'mapOverwrite' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final boolean m3895a(GenericMapMutation genericMapMutation) {
        return this.setField_ == genericMapMutation.setField_ && ((this.value_ instanceof byte[]) ? Arrays.equals((byte[]) this.value_, (byte[]) genericMapMutation.value_) : this.value_.equals(genericMapMutation.value_));
    }

    protected final void mo156a(TProtocol tProtocol, short s) {
        switch (s) {
            case (short) 1:
                List<GenericMapKeyMutation> list = (List) this.value_;
                tProtocol.a(new TList((byte) 12, list.size()));
                for (GenericMapKeyMutation a : list) {
                    a.m3887a(tProtocol);
                }
                return;
            case (short) 2:
                ((GenericMap) this.value_).m3883a(tProtocol);
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + s);
        }
    }

    protected final TField mo154a(int i) {
        switch (i) {
            case 1:
                return f2735c;
            case 2:
                return f2736d;
            default:
                throw new IllegalArgumentException("Unknown field id " + i);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof GenericMapMutation) {
            return m3895a((GenericMapMutation) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public static GenericMapMutation m3888b(TProtocol tProtocol) {
        GenericMapMutation genericMapMutation = new GenericMapMutation();
        TUnion genericMapMutation2 = new GenericMapMutation();
        genericMapMutation2.setField_ = 0;
        genericMapMutation2.value_ = null;
        tProtocol.r();
        TField f = tProtocol.f();
        genericMapMutation2.value_ = genericMapMutation2.mo155a(tProtocol, f);
        if (genericMapMutation2.value_ != null) {
            genericMapMutation2.setField_ = f.c;
        }
        tProtocol.f();
        tProtocol.e();
        return genericMapMutation2;
    }

    public String toString() {
        return m3893a(1, f2733a);
    }

    public final String m3893a(int i, boolean z) {
        Object obj = 1;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("GenericMapMutation");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.setField_ == 1) {
            stringBuilder.append(a);
            stringBuilder.append("keyMutations");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3889c() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3889c(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 2) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("mapOverwrite");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3890d() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3890d(), i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
