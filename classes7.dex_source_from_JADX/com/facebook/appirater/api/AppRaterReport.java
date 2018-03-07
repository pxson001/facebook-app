package com.facebook.appirater.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AppRaterReportDeserializer.class)
/* compiled from: cta_lead_gen_confirmation_vpv */
public class AppRaterReport implements Parcelable {
    public static final Creator<AppRaterReport> CREATOR = new C12991();
    @JsonProperty("build_number")
    public final long buildNumber;
    @JsonProperty("last_event")
    public final String lastEvent;
    @JsonProperty("last_event_completed_at_millis")
    public final long lastEventCompletedAtMillis;
    @JsonProperty("review_text")
    public final String reviewText;
    @JsonProperty("star_rating")
    public final int starRating;

    /* compiled from: cta_lead_gen_confirmation_vpv */
    final class C12991 implements Creator<AppRaterReport> {
        C12991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AppRaterReport(parcel);
        }

        public final Object[] newArray(int i) {
            return new AppRaterReport[i];
        }
    }

    /* compiled from: cta_lead_gen_confirmation_vpv */
    public class Builder {
        public int f16474a;
        public String f16475b;
        public String f16476c;
        public long f16477d;
        public long f16478e;

        public final Builder m20537a(LastEvent lastEvent) {
            this.f16476c = lastEvent.toString();
            return this;
        }
    }

    /* compiled from: cta_lead_gen_confirmation_vpv */
    public enum LastEvent {
        STARS_BACKGROUND,
        STARS_DISMISS,
        STARS_STARCHOSEN,
        STARS_HIGHRATING_NOTHANKS,
        STARS_HIGHRATING_GOTOSTORE,
        STARS_LOWRATING_CANCEL,
        STARS_LOWRATING_SUBMIT
    }

    protected AppRaterReport() {
        this.starRating = -1;
        this.reviewText = null;
        this.lastEvent = null;
        this.buildNumber = -1;
        this.lastEventCompletedAtMillis = -1;
    }

    public AppRaterReport(Builder builder) {
        this.starRating = builder.f16474a;
        this.reviewText = builder.f16475b;
        this.lastEvent = builder.f16476c;
        this.buildNumber = builder.f16477d;
        this.lastEventCompletedAtMillis = builder.f16478e;
    }

    protected AppRaterReport(Parcel parcel) {
        this.starRating = parcel.readInt();
        this.reviewText = parcel.readString();
        this.lastEvent = parcel.readString();
        this.buildNumber = parcel.readLong();
        this.lastEventCompletedAtMillis = parcel.readLong();
    }

    public final boolean m20538a() {
        return this.starRating >= 0 && this.lastEventCompletedAtMillis > 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.starRating);
        parcel.writeString(this.reviewText);
        parcel.writeString(this.lastEvent);
        parcel.writeLong(this.buildNumber);
        parcel.writeLong(this.lastEventCompletedAtMillis);
    }

    public String toString() {
        return "AppRaterReport:\nStar Rating: " + this.starRating + "\nReview Text: " + this.reviewText + "\nLast Event: " + this.lastEvent + "\nBuild Number: " + this.buildNumber + "\nLast Event Completed At: " + this.lastEventCompletedAtMillis;
    }
}
