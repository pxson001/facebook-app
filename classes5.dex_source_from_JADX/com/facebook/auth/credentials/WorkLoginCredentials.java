package com.facebook.auth.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Optional;

/* compiled from: taggable_activity_icon */
public class WorkLoginCredentials extends PasswordCredentials {
    public static final Creator<WorkLoginCredentials> CREATOR = new C01391();
    private Optional<String> f2260a;
    private Optional<String> f2261b;

    /* compiled from: taggable_activity_icon */
    final class C01391 implements Creator<WorkLoginCredentials> {
        C01391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new WorkLoginCredentials(parcel);
        }

        public final Object[] newArray(int i) {
            return new WorkLoginCredentials[i];
        }
    }

    public WorkLoginCredentials(Parcel parcel) {
        super(parcel);
        this.f2260a = Optional.fromNullable(parcel.readString());
        this.f2261b = Optional.fromNullable(parcel.readString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString((String) this.f2260a.get());
        parcel.writeString((String) this.f2261b.get());
    }
}
