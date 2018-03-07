package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: create_thread_source */
public class AddMontageViewerParams implements Parcelable {
    public static final Creator<AddMontageViewerParams> CREATOR = new C19911();
    public final String f17011a;
    @Nullable
    public final User f17012b;

    /* compiled from: create_thread_source */
    final class C19911 implements Creator<AddMontageViewerParams> {
        C19911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddMontageViewerParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddMontageViewerParams[i];
        }
    }

    public AddMontageViewerParams(String str, @Nullable User user) {
        Preconditions.checkNotNull(str);
        if (user != null) {
            Preconditions.checkArgument(str.equals(user.a));
        }
        this.f17011a = str;
        this.f17012b = user;
    }

    public AddMontageViewerParams(Parcel parcel) {
        this.f17011a = parcel.readString();
        this.f17012b = (User) parcel.readParcelable(User.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17011a);
        parcel.writeParcelable(this.f17012b, i);
    }
}
