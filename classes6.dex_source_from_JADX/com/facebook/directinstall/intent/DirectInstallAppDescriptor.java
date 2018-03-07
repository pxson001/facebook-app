package com.facebook.directinstall.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: old_screen */
public class DirectInstallAppDescriptor implements Parcelable {
    public static final Creator<DirectInstallAppDescriptor> CREATOR = new C05821();
    public String f8773a;
    private int f8774b;
    private String f8775c;
    private ImmutableList<String> f8776d;
    public final String f8777e;

    /* compiled from: old_screen */
    final class C05821 implements Creator<DirectInstallAppDescriptor> {
        C05821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DirectInstallAppDescriptor(parcel);
        }

        public final Object[] newArray(int i) {
            return new DirectInstallAppDescriptor[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8773a);
        parcel.writeInt(this.f8774b);
        parcel.writeString(this.f8775c);
        parcel.writeStringList(this.f8776d);
        parcel.writeString(this.f8777e);
    }

    public DirectInstallAppDescriptor(Parcel parcel) {
        this.f8773a = parcel.readString();
        this.f8774b = parcel.readInt();
        this.f8775c = parcel.readString();
        Collection arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f8776d = ImmutableList.copyOf(arrayList);
        this.f8777e = parcel.readString();
    }

    public DirectInstallAppDescriptor(String str, int i, String str2, ImmutableList<String> immutableList, String str3) {
        this.f8773a = str;
        this.f8774b = i;
        this.f8775c = str2;
        this.f8776d = immutableList;
        this.f8777e = str3;
    }

    public final String m12538a() {
        return this.f8773a;
    }

    public final int m12539b() {
        return this.f8774b;
    }

    public final String m12540c() {
        return this.f8775c;
    }

    public final ImmutableList<String> m12541d() {
        return this.f8776d;
    }

    public final String m12542e() {
        return this.f8777e;
    }
}
