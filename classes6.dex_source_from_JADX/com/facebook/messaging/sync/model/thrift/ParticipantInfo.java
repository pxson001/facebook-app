package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TMap;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: upload_queue_size */
public class ParticipantInfo implements TBase, Serializable, Cloneable {
    public static boolean f2783a = true;
    private static final TStruct f2784b = new TStruct("ParticipantInfo");
    private static final TField f2785c = new TField("userFbId", (byte) 10, (short) 1);
    private static final TField f2786d = new TField("firstName", (byte) 11, (short) 2);
    private static final TField f2787e = new TField("fullName", (byte) 11, (short) 3);
    private static final TField f2788f = new TField("isMessengerUser", (byte) 2, (short) 4);
    private static final TField f2789g = new TField("profPicURIMap", (byte) 13, (short) 5);
    public final String firstName;
    public final String fullName;
    public final Boolean isMessengerUser;
    public final Map<Integer, String> profPicURIMap;
    public final Long userFbId;

    private ParticipantInfo(Long l, String str, String str2, Boolean bool, Map<Integer, String> map) {
        this.userFbId = l;
        this.firstName = str;
        this.fullName = str2;
        this.isMessengerUser = bool;
        this.profPicURIMap = map;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ParticipantInfo)) {
            return m3928a((ParticipantInfo) obj);
        }
        return false;
    }

    public final boolean m3928a(ParticipantInfo participantInfo) {
        if (participantInfo == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.userFbId != null;
        if (participantInfo.userFbId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.userFbId.equals(participantInfo.userFbId))) {
            return false;
        }
        if (this.firstName != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (participantInfo.firstName != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.firstName.equals(participantInfo.firstName))) {
            return false;
        }
        if (this.fullName != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (participantInfo.fullName != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.fullName.equals(participantInfo.fullName))) {
            return false;
        }
        if (this.isMessengerUser != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (participantInfo.isMessengerUser != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.isMessengerUser.equals(participantInfo.isMessengerUser))) {
            return false;
        }
        if (this.profPicURIMap != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (participantInfo.profPicURIMap != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.profPicURIMap.equals(participantInfo.profPicURIMap))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static ParticipantInfo m3925b(TProtocol tProtocol) {
        Map map = null;
        tProtocol.r();
        Boolean bool = null;
        String str = null;
        String str2 = null;
        Long l = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 13) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TMap g = tProtocol.g();
                        map = new HashMap(Math.max(0, g.f5052c * 2));
                        int i = 0;
                        while (true) {
                            if (g.f5052c >= 0) {
                                if (i >= g.f5052c) {
                                    break;
                                }
                            } else if (!TProtocol.s()) {
                                break;
                            }
                            map.put(Integer.valueOf(tProtocol.m()), tProtocol.p());
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new ParticipantInfo(l, str2, str, bool, map);
        }
    }

    public final void m3927a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.userFbId == null || this.userFbId == null)) {
            tProtocol.a(f2785c);
            tProtocol.a(this.userFbId.longValue());
        }
        if (!(this.firstName == null || this.firstName == null)) {
            tProtocol.a(f2786d);
            tProtocol.a(this.firstName);
        }
        if (!(this.fullName == null || this.fullName == null)) {
            tProtocol.a(f2787e);
            tProtocol.a(this.fullName);
        }
        if (!(this.isMessengerUser == null || this.isMessengerUser == null)) {
            tProtocol.a(f2788f);
            tProtocol.a(this.isMessengerUser.booleanValue());
        }
        if (!(this.profPicURIMap == null || this.profPicURIMap == null)) {
            tProtocol.a(f2789g);
            tProtocol.a(new TMap((byte) 8, (byte) 11, this.profPicURIMap.size()));
            for (Entry entry : this.profPicURIMap.entrySet()) {
                tProtocol.a(((Integer) entry.getKey()).intValue());
                tProtocol.a((String) entry.getValue());
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3926a(1, f2783a);
    }

    public final String m3926a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ParticipantInfo");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.userFbId != null) {
            stringBuilder.append(a);
            stringBuilder.append("userFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.userFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.userFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.firstName != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("firstName");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.firstName == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.firstName, i + 1, z));
            }
            obj2 = null;
        }
        if (this.fullName != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("fullName");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fullName == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.fullName, i + 1, z));
            }
            obj2 = null;
        }
        if (this.isMessengerUser != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("isMessengerUser");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.isMessengerUser == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.isMessengerUser, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.profPicURIMap != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("profPicURIMap");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.profPicURIMap == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.profPicURIMap, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
