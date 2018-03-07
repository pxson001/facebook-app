package com.facebook.common.pagesprotocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;

/* compiled from: invitedMembers */
public class DeletePageReviewParams implements Parcelable {
    public static final Creator<DeletePageReviewParams> CREATOR = new C11371();
    public final String f10683a;
    public final CurationMechanism f10684b;
    public final CurationSurface f10685c;

    /* compiled from: invitedMembers */
    final class C11371 implements Creator<DeletePageReviewParams> {
        C11371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeletePageReviewParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeletePageReviewParams[i];
        }
    }

    public DeletePageReviewParams(String str, CurationMechanism curationMechanism, CurationSurface curationSurface) {
        this.f10683a = str;
        this.f10684b = curationMechanism;
        this.f10685c = curationSurface;
    }

    public DeletePageReviewParams(Parcel parcel) {
        this.f10683a = parcel.readString();
        this.f10684b = (CurationMechanism) parcel.readSerializable();
        this.f10685c = (CurationSurface) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10683a);
        parcel.writeSerializable(this.f10684b);
        parcel.writeSerializable(this.f10685c);
    }
}
