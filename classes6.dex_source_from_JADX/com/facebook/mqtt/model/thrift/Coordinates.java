package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: 他 */
public class Coordinates implements TBase, Serializable, Cloneable {
    public static boolean f2883a = true;
    private static final TStruct f2884b = new TStruct("Coordinates");
    private static final TField f2885c = new TField("latitude", (byte) 11, (short) 1);
    private static final TField f2886d = new TField("longitude", (byte) 11, (short) 2);
    private static final TField f2887e = new TField("accuracy", (byte) 11, (short) 3);
    public final String accuracy;
    public final String latitude;
    public final String longitude;

    public Coordinates(String str, String str2, String str3) {
        this.latitude = str;
        this.longitude = str2;
        this.accuracy = str3;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Coordinates)) {
            return m3975a((Coordinates) obj);
        }
        return false;
    }

    public final boolean m3975a(Coordinates coordinates) {
        if (coordinates == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.latitude != null;
        if (coordinates.latitude != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.latitude.equals(coordinates.latitude))) {
            return false;
        }
        if (this.longitude != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (coordinates.longitude != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.longitude.equals(coordinates.longitude))) {
            return false;
        }
        if (this.accuracy != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (coordinates.accuracy != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.accuracy.equals(coordinates.accuracy))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3974a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.latitude == null || this.latitude == null)) {
            tProtocol.a(f2885c);
            tProtocol.a(this.latitude);
        }
        if (!(this.longitude == null || this.longitude == null)) {
            tProtocol.a(f2886d);
            tProtocol.a(this.longitude);
        }
        if (!(this.accuracy == null || this.accuracy == null)) {
            tProtocol.a(f2887e);
            tProtocol.a(this.accuracy);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3973a(1, f2883a);
    }

    public final String m3973a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("Coordinates");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.latitude != null) {
            stringBuilder.append(a);
            stringBuilder.append("latitude");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.latitude == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.latitude, i + 1, z));
            }
            obj2 = null;
        }
        if (this.longitude != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("longitude");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.longitude == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.longitude, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.accuracy != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("accuracy");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.accuracy == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.accuracy, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
