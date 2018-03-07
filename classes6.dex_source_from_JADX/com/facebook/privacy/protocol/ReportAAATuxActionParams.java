package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: sticker_keyboard */
public final class ReportAAATuxActionParams implements Parcelable {
    public static final Creator<ReportAAATuxActionParams> CREATOR = new C02381();
    public final String f4149a;
    public final Long f4150b;
    public final String f4151c;

    /* compiled from: sticker_keyboard */
    final class C02381 implements Creator<ReportAAATuxActionParams> {
        C02381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReportAAATuxActionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReportAAATuxActionParams[i];
        }
    }

    /* compiled from: sticker_keyboard */
    public enum AudienceAlignmentTuxEvent {
        EXPOSED("exposed"),
        DISMISSED("dismissal"),
        LEARN_MORE("learn_more"),
        PUBLIC_PRIVACY("public_sticky"),
        FRIENDS_PRIVACY("friends_sticky"),
        MORE_OPTIONS("selector"),
        NAVIGATED_BACK("back");
        
        private final String eventName;

        private AudienceAlignmentTuxEvent(String str) {
            this.eventName = str;
        }

        public final String toString() {
            return this.eventName;
        }
    }

    public ReportAAATuxActionParams(AudienceAlignmentTuxEvent audienceAlignmentTuxEvent, long j, String str) {
        this.f4149a = audienceAlignmentTuxEvent.toString();
        this.f4150b = Long.valueOf(j);
        this.f4151c = str;
    }

    public ReportAAATuxActionParams(Parcel parcel) {
        this.f4149a = parcel.readString();
        this.f4150b = Long.valueOf(parcel.readLong());
        this.f4151c = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4149a);
        parcel.writeLong(this.f4150b.longValue());
        parcel.writeString(this.f4151c);
    }

    public final String toString() {
        return Objects.toStringHelper(ReportAAATuxActionParams.class).add("event", this.f4149a).add("eventTime", this.f4150b).add("source", this.f4151c).toString();
    }
}
