package com.facebook.events.create.ui;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: confirmation_header_text */
public class EventCoverPhotoModel implements Parcelable {
    public static final Creator<EventCoverPhotoModel> CREATOR = new C22801();
    public String f16327a;
    public String f16328b;
    public Uri f16329c;
    public Uri f16330d;

    /* compiled from: confirmation_header_text */
    final class C22801 implements Creator<EventCoverPhotoModel> {
        C22801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventCoverPhotoModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventCoverPhotoModel[i];
        }
    }

    public final void m16806a() {
        this.f16327a = null;
        this.f16328b = null;
        this.f16329c = null;
        this.f16330d = null;
    }

    public final boolean m16807d() {
        return this.f16328b != null;
    }

    public final String m16808f() {
        return this.f16329c == null ? null : this.f16329c.toString();
    }

    public final boolean m16809g() {
        return this.f16329c != null;
    }

    public final boolean m16810j() {
        return (this.f16327a == null || this.f16329c == null) ? false : true;
    }

    public final boolean m16811k() {
        return this.f16327a == null && this.f16328b == null && this.f16329c != null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16327a);
        parcel.writeString(this.f16328b);
        parcel.writeParcelable(this.f16329c, i);
        parcel.writeParcelable(this.f16330d, i);
    }

    public EventCoverPhotoModel(Parcel parcel) {
        this.f16327a = parcel.readString();
        this.f16328b = parcel.readString();
        this.f16329c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f16330d = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}
