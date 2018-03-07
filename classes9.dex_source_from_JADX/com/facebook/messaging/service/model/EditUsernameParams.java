package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: create_local_admin_message */
public class EditUsernameParams implements Parcelable {
    public static final Creator<EditUsernameParams> CREATOR = new C20021();
    public static String f17042a = "editUsernameParams";
    public final String f17043b;

    /* compiled from: create_local_admin_message */
    final class C20021 implements Creator<EditUsernameParams> {
        C20021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditUsernameParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditUsernameParams[i];
        }
    }

    public EditUsernameParams(String str) {
        this.f17043b = str;
    }

    public EditUsernameParams(Parcel parcel) {
        this.f17043b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17043b);
    }
}
