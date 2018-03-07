package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Objects;

/* compiled from: stickerUri */
public final class ReportNASActionParams implements Parcelable {
    public static final Creator<ReportNASActionParams> CREATOR = new C02401();
    public final String f4157a;
    public final Long f4158b;
    public final boolean f4159c;
    public final String f4160d;
    public final String f4161e;

    /* compiled from: stickerUri */
    final class C02401 implements Creator<ReportNASActionParams> {
        C02401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReportNASActionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReportNASActionParams[i];
        }
    }

    /* compiled from: stickerUri */
    public enum NewcomerAudienceSelectorEvent {
        EXPOSED("exposure"),
        HOLDOUT("holdout"),
        SKIPPED("dismiss"),
        LEARN_MORE("learn_more"),
        WIDEST_PRIVACY("set_widest"),
        OTHER_PRIVACY("set_other_privacy"),
        FRIENDS_PRIVACY("friends"),
        MORE_OPTIONS("more_options"),
        NAVIGATED_BACK("dismiss_back");
        
        private final String eventName;

        private NewcomerAudienceSelectorEvent(String str) {
            this.eventName = str;
        }

        public final String toString() {
            return this.eventName;
        }
    }

    public ReportNASActionParams(NewcomerAudienceSelectorEvent newcomerAudienceSelectorEvent, long j, boolean z, String str, String str2) {
        this.f4157a = newcomerAudienceSelectorEvent.toString();
        this.f4158b = Long.valueOf(j);
        this.f4159c = z;
        this.f4160d = str;
        this.f4161e = str2;
    }

    public ReportNASActionParams(Parcel parcel) {
        this.f4157a = parcel.readString();
        this.f4158b = Long.valueOf(parcel.readLong());
        this.f4159c = ParcelUtil.a(parcel);
        this.f4160d = parcel.readString();
        this.f4161e = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4157a);
        parcel.writeLong(this.f4158b.longValue());
        ParcelUtil.a(parcel, this.f4159c);
        parcel.writeString(this.f4160d);
        parcel.writeString(this.f4161e);
    }

    public final String toString() {
        return Objects.toStringHelper(ReportNASActionParams.class).add("event", this.f4157a).add("eventTime", this.f4158b).add("isDefault", this.f4159c).add("privacyJson", this.f4160d).add("source", this.f4161e).toString();
    }
}
