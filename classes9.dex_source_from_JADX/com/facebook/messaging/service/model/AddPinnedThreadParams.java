package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: create_thread_retry_attempt */
public class AddPinnedThreadParams implements Parcelable {
    public static final Creator<AddPinnedThreadParams> CREATOR = new C19921();
    @Nullable
    public final ThreadKey f17013a;
    @Nullable
    public final String f17014b;

    /* compiled from: create_thread_retry_attempt */
    final class C19921 implements Creator<AddPinnedThreadParams> {
        C19921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddPinnedThreadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddPinnedThreadParams[i];
        }
    }

    public AddPinnedThreadParams(@Nullable ThreadKey threadKey, @Nullable String str) {
        boolean z = (threadKey == null && str == null) ? false : true;
        Preconditions.checkState(z, "thread key/idRefQuery must be specified");
        this.f17013a = threadKey;
        this.f17014b = str;
    }

    public AddPinnedThreadParams(Parcel parcel) {
        this.f17013a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17014b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17013a, i);
        parcel.writeString(this.f17014b);
    }
}
