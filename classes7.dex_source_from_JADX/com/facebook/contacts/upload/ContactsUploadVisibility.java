package com.facebook.contacts.upload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: tapped_deeplink_action */
public enum ContactsUploadVisibility implements Parcelable {
    SHOW,
    HIDE;
    
    public static final Creator<ContactsUploadVisibility> CREATOR = null;

    /* compiled from: tapped_deeplink_action */
    final class C02251 implements Creator<ContactsUploadVisibility> {
        C02251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return ((ContactsUploadVisibility[]) ContactsUploadVisibility.class.getEnumConstants())[parcel.readInt()];
        }

        public final Object[] newArray(int i) {
            return new ContactsUploadVisibility[i];
        }
    }

    static {
        CREATOR = new C02251();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
