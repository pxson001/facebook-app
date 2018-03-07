package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: times_contacted */
public class ProxygenInfo implements TBase, Serializable, Cloneable {
    public static boolean f2938a = true;
    private static final TStruct f2939b = new TStruct("ProxygenInfo");
    private static final TField f2940c = new TField("ipAddr", (byte) 11, (short) 1);
    private static final TField f2941d = new TField("hostName", (byte) 11, (short) 2);
    private static final TField f2942e = new TField("vipAddr", (byte) 11, (short) 3);
    public final String hostName;
    public final String ipAddr;
    public final String vipAddr;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProxygenInfo)) {
            return false;
        }
        ProxygenInfo proxygenInfo = (ProxygenInfo) obj;
        boolean z = false;
        if (proxygenInfo != null) {
            Object obj2;
            Object obj3 = this.ipAddr != null ? 1 : null;
            if (proxygenInfo.ipAddr != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.ipAddr.equals(proxygenInfo.ipAddr))) {
                if (this.hostName != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (proxygenInfo.hostName != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.hostName.equals(proxygenInfo.hostName))) {
                    if (this.vipAddr != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (proxygenInfo.vipAddr != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.vipAddr.equals(proxygenInfo.vipAddr))) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3996a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.ipAddr != null) {
            tProtocol.a(f2940c);
            tProtocol.a(this.ipAddr);
        }
        if (this.hostName != null) {
            tProtocol.a(f2941d);
            tProtocol.a(this.hostName);
        }
        if (this.vipAddr != null) {
            tProtocol.a(f2942e);
            tProtocol.a(this.vipAddr);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3995a(1, f2938a);
    }

    public final String m3995a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ProxygenInfo");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("ipAddr");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.ipAddr == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.ipAddr, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("hostName");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.hostName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.hostName, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("vipAddr");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.vipAddr == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.vipAddr, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
