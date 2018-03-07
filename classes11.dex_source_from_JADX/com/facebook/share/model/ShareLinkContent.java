package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: open_self_view */
public final class ShareLinkContent extends ShareContent<ShareLinkContent, Object> {
    public static final Creator<ShareLinkContent> CREATOR = new C06201();
    private final String f4591a;
    private final String f4592b;
    private final Uri f4593c;

    /* compiled from: open_self_view */
    final class C06201 implements Creator<ShareLinkContent> {
        C06201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.f4591a = parcel.readString();
        this.f4592b = parcel.readString();
        this.f4593c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f4591a);
        parcel.writeString(this.f4592b);
        parcel.writeParcelable(this.f4593c, 0);
    }
}
