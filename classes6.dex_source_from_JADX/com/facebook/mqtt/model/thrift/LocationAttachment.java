package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: titanOriginatedThreadId */
public class LocationAttachment implements TBase, Serializable, Cloneable {
    public static boolean f2901a = true;
    private static final TStruct f2902b = new TStruct("LocationAttachment");
    private static final TField f2903c = new TField("coordinates", (byte) 12, (short) 1);
    private static final TField f2904d = new TField("isCurrentLocation", (byte) 2, (short) 2);
    private static final TField f2905e = new TField("placeId", (byte) 10, (short) 3);
    public final Coordinates coordinates;
    public final Boolean isCurrentLocation;
    public final Long placeId;

    public LocationAttachment(Coordinates coordinates, Boolean bool, Long l) {
        this.coordinates = coordinates;
        this.isCurrentLocation = bool;
        this.placeId = l;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof LocationAttachment)) {
            return m3983a((LocationAttachment) obj);
        }
        return false;
    }

    public final boolean m3983a(LocationAttachment locationAttachment) {
        if (locationAttachment == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.coordinates != null;
        if (locationAttachment.coordinates != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.coordinates.m3975a(locationAttachment.coordinates))) {
            return false;
        }
        if (this.isCurrentLocation != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (locationAttachment.isCurrentLocation != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.isCurrentLocation.equals(locationAttachment.isCurrentLocation))) {
            return false;
        }
        if (this.placeId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (locationAttachment.placeId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.placeId.equals(locationAttachment.placeId))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3982a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.coordinates == null || this.coordinates == null)) {
            tProtocol.a(f2903c);
            this.coordinates.m3974a(tProtocol);
        }
        if (!(this.isCurrentLocation == null || this.isCurrentLocation == null)) {
            tProtocol.a(f2904d);
            tProtocol.a(this.isCurrentLocation.booleanValue());
        }
        if (!(this.placeId == null || this.placeId == null)) {
            tProtocol.a(f2905e);
            tProtocol.a(this.placeId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3981a(1, f2901a);
    }

    public final String m3981a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("LocationAttachment");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.coordinates != null) {
            stringBuilder.append(a);
            stringBuilder.append("coordinates");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.coordinates == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.coordinates, i + 1, z));
            }
            obj2 = null;
        }
        if (this.isCurrentLocation != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("isCurrentLocation");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.isCurrentLocation == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.isCurrentLocation, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.placeId != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("placeId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.placeId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.placeId, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
