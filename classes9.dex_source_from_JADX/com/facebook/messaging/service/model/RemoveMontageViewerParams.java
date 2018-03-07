package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: contact_upload_session_create_and_maybe_batch_upload */
public class RemoveMontageViewerParams implements Parcelable {
    public static final Creator<RemoveMontageViewerParams> CREATOR = new C20491();
    public final String f17279a;
    @Nullable
    public final User f17280b;

    /* compiled from: contact_upload_session_create_and_maybe_batch_upload */
    final class C20491 implements Creator<RemoveMontageViewerParams> {
        C20491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RemoveMontageViewerParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new RemoveMontageViewerParams[i];
        }
    }

    public RemoveMontageViewerParams(String str, @Nullable User user) {
        Preconditions.checkNotNull(str);
        if (user != null) {
            Preconditions.checkArgument(str.equals(user.a));
        }
        this.f17279a = str;
        this.f17280b = user;
    }

    public RemoveMontageViewerParams(Parcel parcel) {
        this.f17279a = parcel.readString();
        this.f17280b = (User) parcel.readParcelable(User.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17279a);
        parcel.writeParcelable(this.f17280b, i);
    }
}
