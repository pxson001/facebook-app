package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: stickerContext */
public final class ReportStickyGuardrailActionParams implements Parcelable {
    public static final Creator<ReportStickyGuardrailActionParams> CREATOR = new C02431();
    public final String f4179a;
    public final Long f4180b;
    public final Long f4181c;
    public final String f4182d;
    public final String f4183e;

    /* compiled from: stickerContext */
    final class C02431 implements Creator<ReportStickyGuardrailActionParams> {
        C02431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReportStickyGuardrailActionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReportStickyGuardrailActionParams[i];
        }
    }

    /* compiled from: stickerContext */
    public enum StickyGuardrailEvent {
        EXPOSED("client_seen"),
        ACCEPTED("converted"),
        DECLINED("declined"),
        CLOSED("closed"),
        DISMISSED("dismissed");
        
        private final String eventName;

        private StickyGuardrailEvent(String str) {
            this.eventName = str;
        }

        public final String toString() {
            return this.eventName;
        }
    }

    public ReportStickyGuardrailActionParams(StickyGuardrailEvent stickyGuardrailEvent, Long l, Long l2, String str, String str2) {
        this.f4179a = stickyGuardrailEvent.toString();
        this.f4180b = l;
        this.f4181c = l2;
        this.f4182d = str;
        this.f4183e = str2;
    }

    public ReportStickyGuardrailActionParams(Parcel parcel) {
        this.f4179a = parcel.readString();
        this.f4180b = Long.valueOf(parcel.readLong());
        this.f4181c = Long.valueOf(parcel.readLong());
        this.f4182d = parcel.readString();
        this.f4183e = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4179a);
        parcel.writeLong(this.f4180b.longValue());
        parcel.writeLong(this.f4181c.longValue());
        parcel.writeString(this.f4182d);
        parcel.writeString(this.f4183e);
    }

    public final String toString() {
        return Objects.toStringHelper(ReportStickyGuardrailActionParams.class).add("event", this.f4179a).add("eventTime", this.f4180b).add("suggestionTime", this.f4181c).add("currentPrivacyJson", this.f4182d).add("suggestedPrivacyJson", this.f4183e).toString();
    }
}
