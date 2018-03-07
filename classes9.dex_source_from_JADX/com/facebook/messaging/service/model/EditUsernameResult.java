package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: create_group */
public class EditUsernameResult implements Parcelable {
    public static final Creator<EditUsernameResult> CREATOR = new C20031();
    public final String f17044a;

    /* compiled from: create_group */
    final class C20031 implements Creator<EditUsernameResult> {
        C20031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditUsernameResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditUsernameResult[i];
        }
    }

    public EditUsernameResult(String str) {
        this.f17044a = str;
    }

    public EditUsernameResult(Parcel parcel) {
        this.f17044a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17044a);
    }
}
