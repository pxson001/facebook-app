package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.infer.annotation.Assertions;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: updateImage */
public class ThreadParticipant implements Parcelable {
    public static final Creator<ThreadParticipant> CREATOR = new C01241();
    public final ParticipantInfo f2277a;
    public final long f2278b;
    @Nullable
    public final String f2279c;
    public final long f2280d;
    public final boolean f2281e;

    /* compiled from: updateImage */
    final class C01241 implements Creator<ThreadParticipant> {
        C01241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadParticipant(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadParticipant[i];
        }
    }

    ThreadParticipant(ThreadParticipantBuilder threadParticipantBuilder) {
        this.f2277a = (ParticipantInfo) Assertions.b(threadParticipantBuilder.f2282a);
        this.f2278b = threadParticipantBuilder.f2283b;
        this.f2279c = threadParticipantBuilder.f2284c;
        this.f2280d = threadParticipantBuilder.f2285d;
        this.f2281e = threadParticipantBuilder.f2286e;
    }

    public ThreadParticipant(Parcel parcel) {
        this.f2277a = (ParticipantInfo) parcel.readParcelable(ParticipantInfo.class.getClassLoader());
        this.f2278b = parcel.readLong();
        this.f2279c = parcel.readString();
        this.f2280d = parcel.readLong();
        this.f2281e = ParcelUtil.a(parcel);
    }

    public final UserKey m3549b() {
        return this.f2277a.f2119b;
    }

    public final String m3550c() {
        return this.f2277a.f2121d;
    }

    public final String m3551d() {
        return this.f2277a.f2122e;
    }

    public final String m3552e() {
        return this.f2277a.f2120c;
    }

    public final boolean m3553f() {
        return this.f2277a.f2123f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2277a, i);
        parcel.writeLong(this.f2278b);
        parcel.writeString(this.f2279c);
        parcel.writeLong(this.f2280d);
        ParcelUtil.a(parcel, this.f2281e);
    }

    public String toString() {
        return Objects.toStringHelper(ThreadParticipant.class).add("participantInfo", this.f2277a).add("lastReadReceiptTimestampMs", this.f2278b).add("lastDeliveredReceiptMsgId", this.f2279c).add("lastDeliveredReceiptTimestampMs", this.f2280d).add("isAdmin", this.f2281e).toString();
    }
}
