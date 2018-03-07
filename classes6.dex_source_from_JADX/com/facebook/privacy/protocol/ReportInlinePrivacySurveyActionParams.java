package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: sticker_disk_cache_size */
public class ReportInlinePrivacySurveyActionParams implements Parcelable {
    public static final Creator<ReportInlinePrivacySurveyActionParams> CREATOR = new C02391();
    public final String f4152a;
    public final long f4153b;
    public final String f4154c;
    public final String f4155d;
    public final String f4156e;

    /* compiled from: sticker_disk_cache_size */
    final class C02391 implements Creator<ReportInlinePrivacySurveyActionParams> {
        C02391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReportInlinePrivacySurveyActionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReportInlinePrivacySurveyActionParams[i];
        }
    }

    /* compiled from: sticker_disk_cache_size */
    public enum InlinePrivacySurveyEvent {
        EXPOSED("exposed"),
        CHOSE_FIRST_OPTION("chose_first_option"),
        CHOSE_SECOND_OPTION("chose_second_option"),
        CHOSE_OTHER_OPTION("chose_other_option"),
        MORE_OPTIONS("more_options"),
        DISMISSED("dismissed");
        
        private final String eventName;

        private InlinePrivacySurveyEvent(String str) {
            this.eventName = str;
        }

        public final String toString() {
            return this.eventName;
        }
    }

    public ReportInlinePrivacySurveyActionParams(InlinePrivacySurveyEvent inlinePrivacySurveyEvent, long j, String str, String str2, String str3) {
        this.f4152a = inlinePrivacySurveyEvent.toString();
        this.f4153b = j;
        this.f4154c = str;
        this.f4155d = str2;
        this.f4156e = str3;
    }

    public ReportInlinePrivacySurveyActionParams(Parcel parcel) {
        this.f4152a = parcel.readString();
        this.f4153b = parcel.readLong();
        this.f4154c = parcel.readString();
        this.f4155d = parcel.readString();
        this.f4156e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4152a);
        parcel.writeLong(this.f4153b);
        parcel.writeString(this.f4154c);
        parcel.writeString(this.f4155d);
        parcel.writeString(this.f4156e);
    }
}
