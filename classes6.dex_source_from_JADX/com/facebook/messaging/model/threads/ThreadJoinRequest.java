package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.UserKey;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: updateInfoMethod */
public class ThreadJoinRequest implements Parcelable {
    public static final Creator<ThreadJoinRequest> CREATOR = new C01231();
    public final UserKey f2275a;
    public final long f2276b;

    /* compiled from: updateInfoMethod */
    final class C01231 implements Creator<ThreadJoinRequest> {
        C01231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadJoinRequest(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadJoinRequest[i];
        }
    }

    public ThreadJoinRequest(UserKey userKey, long j) {
        this.f2275a = userKey;
        this.f2276b = j;
    }

    public ThreadJoinRequest(Parcel parcel) {
        this.f2275a = (UserKey) parcel.readParcelable(UserKey.class.getClassLoader());
        this.f2276b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2275a, i);
        parcel.writeLong(this.f2276b);
    }
}
