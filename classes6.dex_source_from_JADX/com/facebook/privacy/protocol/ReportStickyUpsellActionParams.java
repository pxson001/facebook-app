package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: stereoMode */
public final class ReportStickyUpsellActionParams implements Parcelable {
    public static final Creator<ReportStickyUpsellActionParams> CREATOR = new C02441();
    public final String f4184a;
    public final Long f4185b;
    public final String f4186c;
    public final String f4187d;
    public final String f4188e;

    /* compiled from: stereoMode */
    final class C02441 implements Creator<ReportStickyUpsellActionParams> {
        C02441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReportStickyUpsellActionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReportStickyUpsellActionParams[i];
        }
    }

    /* compiled from: stereoMode */
    public enum StickyUpsellEvent {
        EXPOSED("client_suggested"),
        ACCEPTED("moved"),
        DECLINED("declined"),
        CLOSED("closed"),
        DISMISSED("dismissed"),
        HOLDOUT("holdout");
        
        private final String eventName;

        private StickyUpsellEvent(String str) {
            this.eventName = str;
        }

        public final String toString() {
            return this.eventName;
        }
    }

    /* compiled from: stereoMode */
    public enum StickyUpsellSurface {
        NEWSFEED("fb4a_feed"),
        TIMELINE("fb4a_timeline"),
        PERMALINK("fb4a_permalink");
        
        private final String name;

        private StickyUpsellSurface(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public ReportStickyUpsellActionParams(StickyUpsellEvent stickyUpsellEvent, Long l, String str, String str2, StickyUpsellSurface stickyUpsellSurface) {
        this.f4184a = stickyUpsellEvent.toString();
        this.f4185b = l;
        this.f4186c = str;
        this.f4187d = str2;
        this.f4188e = stickyUpsellSurface.toString();
    }

    public ReportStickyUpsellActionParams(Parcel parcel) {
        this.f4184a = parcel.readString();
        this.f4185b = Long.valueOf(parcel.readLong());
        this.f4186c = parcel.readString();
        this.f4187d = parcel.readString();
        this.f4188e = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4184a);
        parcel.writeLong(this.f4185b.longValue());
        parcel.writeString(this.f4186c);
        parcel.writeString(this.f4187d);
        parcel.writeString(this.f4188e);
    }

    public final String toString() {
        return Objects.toStringHelper(ReportStickyUpsellActionParams.class).add("event", this.f4184a).add("eventTime", this.f4185b).add("currentPrivacyJson", this.f4186c).add("suggestedPrivacyJson", this.f4187d).add("surface", this.f4188e).toString();
    }
}
