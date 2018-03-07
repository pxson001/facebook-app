package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_photo_menu_photo_upload */
public class AddContactParams implements Parcelable {
    public static final Creator<AddContactParams> CREATOR = new C05321();
    public final String f8425a;
    public final String f8426b;

    /* compiled from: page_photo_menu_photo_upload */
    final class C05321 implements Creator<AddContactParams> {
        C05321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddContactParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddContactParams[i];
        }
    }

    public AddContactParams(@Nullable String str, @Nullable String str2) {
        int i;
        int i2 = 1;
        if (str == null) {
            i = 1;
        } else {
            i = 0;
        }
        if (str2 != null) {
            i2 = 0;
        }
        Preconditions.checkArgument(i2 ^ i);
        this.f8425a = str;
        this.f8426b = str2;
    }

    public AddContactParams(Parcel parcel) {
        this.f8425a = parcel.readString();
        this.f8426b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8425a);
        parcel.writeString(this.f8426b);
    }
}
