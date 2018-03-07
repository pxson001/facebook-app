package com.facebook.messaging.model.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import javax.annotation.Nullable;

/* compiled from: upload_queue_size */
public class ParticipantInfo implements Parcelable {
    public static final Creator<ParticipantInfo> CREATOR = new C00992();
    public static final Comparator<ParticipantInfo> f2117a = new C00981();
    public static final Ordering<String> f2118g = Ordering.a(String.CASE_INSENSITIVE_ORDER).c();
    public final UserKey f2119b;
    public final String f2120c;
    public final String f2121d;
    public final String f2122e;
    public final boolean f2123f;

    /* compiled from: upload_queue_size */
    final class C00981 implements Comparator<ParticipantInfo> {
        C00981() {
        }

        public final int compare(Object obj, Object obj2) {
            ParticipantInfo participantInfo = (ParticipantInfo) obj;
            ParticipantInfo participantInfo2 = (ParticipantInfo) obj2;
            int compare = ParticipantInfo.f2118g.compare(participantInfo.f2120c, participantInfo2.f2120c);
            return compare != 0 ? compare : ParticipantInfo.f2118g.compare(participantInfo.f2119b.b(), participantInfo2.f2119b.b());
        }
    }

    /* compiled from: upload_queue_size */
    final class C00992 implements Creator<ParticipantInfo> {
        C00992() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ParticipantInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new ParticipantInfo[i];
        }
    }

    public ParticipantInfo(UserKey userKey, @Nullable String str) {
        this(userKey, str, null, null, false);
    }

    public ParticipantInfo(UserKey userKey, @Nullable String str, @Nullable String str2) {
        this(userKey, str, str2, null, false);
    }

    public ParticipantInfo(UserKey userKey, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z) {
        this.f2119b = userKey;
        this.f2120c = str;
        this.f2121d = str2;
        this.f2122e = str3;
        this.f2123f = z;
    }

    public ParticipantInfo(Parcel parcel) {
        this.f2121d = parcel.readString();
        this.f2122e = parcel.readString();
        this.f2120c = parcel.readString();
        this.f2119b = UserKey.a(parcel.readString());
        this.f2123f = ParcelUtil.a(parcel);
    }

    public final boolean m3452a() {
        return this.f2119b.a() == Type.FACEBOOK;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2121d);
        parcel.writeString(this.f2122e);
        parcel.writeString(this.f2120c);
        parcel.writeString(this.f2119b.c());
        ParcelUtil.a(parcel, this.f2123f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParticipantInfo participantInfo = (ParticipantInfo) obj;
        if (Objects.equal(this.f2121d, participantInfo.f2121d) && Objects.equal(this.f2122e, participantInfo.f2122e) && Objects.equal(this.f2120c, participantInfo.f2120c) && Objects.equal(this.f2119b, participantInfo.f2119b) && this.f2123f == participantInfo.f2123f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f2119b != null ? this.f2119b.hashCode() : 0;
    }

    public String toString() {
        return Objects.toStringHelper(ParticipantInfo.class).add("userKey", this.f2119b.c()).add("name", this.f2120c).add("emailAddress", this.f2121d).add("phoneNumber", this.f2122e).add("isCommerce", this.f2123f).toString();
    }
}
