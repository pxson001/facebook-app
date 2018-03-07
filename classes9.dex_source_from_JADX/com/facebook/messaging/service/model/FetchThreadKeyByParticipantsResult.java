package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: count must be at least 1 */
public class FetchThreadKeyByParticipantsResult implements Parcelable {
    public static final Creator<FetchThreadKeyByParticipantsResult> CREATOR = new C20261();
    @Nullable
    public final ThreadKey f17116a;

    /* compiled from: count must be at least 1 */
    final class C20261 implements Creator<FetchThreadKeyByParticipantsResult> {
        C20261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchThreadKeyByParticipantsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchThreadKeyByParticipantsResult[i];
        }
    }

    public FetchThreadKeyByParticipantsResult(@Nullable ThreadKey threadKey) {
        this.f17116a = threadKey;
    }

    public FetchThreadKeyByParticipantsResult(Parcel parcel) {
        this.f17116a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17116a, i);
    }
}
