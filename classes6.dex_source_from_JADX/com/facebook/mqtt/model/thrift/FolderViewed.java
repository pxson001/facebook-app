package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: title_extra_image_resource_id */
public class FolderViewed implements TBase, Serializable, Cloneable {
    public static boolean f2888a = true;
    private static final TStruct f2889b = new TStruct("FolderViewed");
    private static final TField f2890c = new TField("folder", (byte) 11, (short) 1);
    private static final TField f2891d = new TField("viewed", (byte) 2, (short) 2);
    public final String folder;
    public final Boolean viewed;

    public FolderViewed(String str, Boolean bool) {
        this.folder = str;
        this.viewed = bool;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FolderViewed)) {
            return false;
        }
        FolderViewed folderViewed = (FolderViewed) obj;
        boolean z = false;
        if (folderViewed != null) {
            Object obj2;
            Object obj3 = this.folder != null ? 1 : null;
            if (folderViewed.folder != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.folder.equals(folderViewed.folder))) {
                if (this.viewed != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (folderViewed.viewed != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.viewed.equals(folderViewed.viewed))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3977a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.folder == null || this.folder == null)) {
            tProtocol.a(f2890c);
            tProtocol.a(this.folder);
        }
        if (!(this.viewed == null || this.viewed == null)) {
            tProtocol.a(f2891d);
            tProtocol.a(this.viewed.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3976a(1, f2888a);
    }

    public final String m3976a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("FolderViewed");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.folder != null) {
            stringBuilder.append(a);
            stringBuilder.append("folder");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.folder == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.folder, i + 1, z));
            }
            obj = null;
        }
        if (this.viewed != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("viewed");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.viewed == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.viewed, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
