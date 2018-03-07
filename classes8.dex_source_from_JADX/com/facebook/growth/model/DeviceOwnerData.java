package com.facebook.growth.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: element_descriptor */
public class DeviceOwnerData implements Parcelable {
    public static final Creator<DeviceOwnerData> CREATOR = new C16151();
    private Birthday f14891a;
    private Set<String> f14892b;
    private Set<FullName> f14893c;
    private Set<String> f14894d;
    private String f14895e;

    /* compiled from: element_descriptor */
    final class C16151 implements Creator<DeviceOwnerData> {
        C16151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeviceOwnerData(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeviceOwnerData[i];
        }
    }

    public DeviceOwnerData() {
        this.f14891a = null;
        this.f14892b = new LinkedHashSet();
        this.f14893c = new LinkedHashSet();
        this.f14894d = new LinkedHashSet();
        this.f14895e = "";
    }

    public DeviceOwnerData(Parcel parcel) {
        this.f14891a = (Birthday) parcel.readParcelable(Birthday.class.getClassLoader());
        Collection arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f14892b = new LinkedHashSet(arrayList);
        arrayList = new ArrayList();
        parcel.readTypedList(arrayList, FullName.CREATOR);
        this.f14893c = new LinkedHashSet(arrayList);
        arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f14894d = new LinkedHashSet(arrayList);
        this.f14895e = parcel.readString();
    }

    public final synchronized void m17351a(DeviceOwnerData deviceOwnerData) {
        if (deviceOwnerData != null) {
            if (this.f14891a == null) {
                this.f14891a = deviceOwnerData.f14891a;
            }
            for (String add : deviceOwnerData.f14892b) {
                this.f14892b.add(add);
            }
            for (FullName add2 : deviceOwnerData.f14893c) {
                this.f14893c.add(add2);
            }
            for (String add3 : deviceOwnerData.f14894d) {
                this.f14894d.add(add3);
            }
            if (StringUtil.c(this.f14895e)) {
                this.f14895e = deviceOwnerData.f14895e;
            }
        }
    }

    public final synchronized void m17350a(Birthday birthday) {
        this.f14891a = birthday;
    }

    public final synchronized Birthday m17349a() {
        return this.f14891a;
    }

    public final synchronized void m17352a(FullName fullName) {
        this.f14893c.add(fullName);
    }

    public final synchronized ImmutableList<FullName> m17354b() {
        return ImmutableList.copyOf(this.f14893c);
    }

    public final synchronized void m17353a(String str) {
        this.f14892b.add(str);
    }

    public final synchronized void m17355b(String str) {
        this.f14894d.add(str);
    }

    public final synchronized void m17357c(String str) {
        this.f14895e = str;
    }

    public final synchronized ImmutableList<String> m17356c() {
        return ImmutableList.copyOf(this.f14892b);
    }

    public final synchronized ImmutableList<String> m17358d() {
        return ImmutableList.copyOf(this.f14894d);
    }

    public final synchronized String m17359e() {
        return this.f14895e;
    }

    public final synchronized boolean m17360f() {
        return !this.f14892b.isEmpty();
    }

    public final synchronized boolean m17361g() {
        return !this.f14894d.isEmpty();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14891a, i);
        parcel.writeStringArray((String[]) this.f14892b.toArray(new String[0]));
        parcel.writeTypedArray((Parcelable[]) this.f14893c.toArray(new FullName[0]), i);
        parcel.writeStringArray((String[]) this.f14894d.toArray(new String[0]));
        parcel.writeString(this.f14895e);
    }
}
