package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: sticker_pack */
public final class ReportAAAOnlyMeActionParams implements Parcelable {
    public static final Creator<ReportAAAOnlyMeActionParams> CREATOR = new C02371();
    public final String f4146a;
    public final Long f4147b;
    public final String f4148c;

    /* compiled from: sticker_pack */
    final class C02371 implements Creator<ReportAAAOnlyMeActionParams> {
        C02371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReportAAAOnlyMeActionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReportAAAOnlyMeActionParams[i];
        }
    }

    /* compiled from: sticker_pack */
    public enum AudienceAlignmentOnlyMeEvent {
        EXPOSED("exposed"),
        DISMISSED("dismissal"),
        LEARN_MORE("learn_more"),
        FRIENDS_PRIVACY("friends_sticky"),
        ONLY_ME_PRIVACY("only_me_sticky"),
        MORE_OPTIONS("selector"),
        NAVIGATED_BACK("back"),
        POSTED("posted"),
        CUSTOM_SELECTION("custom_selection"),
        HOLDOUT("holdout");
        
        private final String eventName;

        private AudienceAlignmentOnlyMeEvent(String str) {
            this.eventName = str;
        }

        public final String toString() {
            return this.eventName;
        }
    }

    public ReportAAAOnlyMeActionParams(AudienceAlignmentOnlyMeEvent audienceAlignmentOnlyMeEvent, long j, String str) {
        this.f4146a = audienceAlignmentOnlyMeEvent.toString();
        this.f4147b = Long.valueOf(j);
        this.f4148c = str;
    }

    public ReportAAAOnlyMeActionParams(Parcel parcel) {
        this.f4146a = parcel.readString();
        this.f4147b = Long.valueOf(parcel.readLong());
        this.f4148c = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4146a);
        parcel.writeLong(this.f4147b.longValue());
        parcel.writeString(this.f4148c);
    }

    public final String toString() {
        return Objects.toStringHelper(ReportAAAOnlyMeActionParams.class).add("event", this.f4146a).add("eventTime", this.f4147b).add("eventSource", this.f4148c).toString();
    }
}
