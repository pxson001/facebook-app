package com.facebook.appirater.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.time.SystemClock;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FetchISRConfigResultDeserializer.class)
/* compiled from: cta_click */
public class FetchISRConfigResult implements Parcelable {
    public static final Creator<FetchISRConfigResult> CREATOR = new C13001();
    @JsonProperty("delay_asking_millisecs")
    public final long delayAskingMillis;
    @JsonProperty("delay_till_next_ping_millisecs")
    public final long delayTillNextPingMillis;
    @JsonProperty("max_stars_for_feedback")
    public final int maxStarsForFeedback;
    @JsonProperty("min_stars_for_store")
    public final int minStarsForStore;
    @JsonProperty("result_recieved_at_millis")
    public final long resultRecievedAtMillis;
    @JsonProperty("should_ask_user")
    public final boolean shouldAskUser;

    /* compiled from: cta_click */
    final class C13001 implements Creator<FetchISRConfigResult> {
        C13001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchISRConfigResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchISRConfigResult[i];
        }
    }

    public final boolean m20545a(long j) {
        return SystemClock.a.a() + j > this.resultRecievedAtMillis + this.delayTillNextPingMillis;
    }

    public final boolean m20546b() {
        return SystemClock.a.a() > this.resultRecievedAtMillis + this.delayTillNextPingMillis;
    }

    protected FetchISRConfigResult() {
        this.shouldAskUser = false;
        this.delayAskingMillis = -1;
        this.delayTillNextPingMillis = -2;
        this.maxStarsForFeedback = -1;
        this.minStarsForStore = -1;
        this.resultRecievedAtMillis = SystemClock.a.a();
    }

    protected FetchISRConfigResult(Parcel parcel) {
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.shouldAskUser = z;
        this.delayAskingMillis = parcel.readLong();
        this.delayTillNextPingMillis = parcel.readLong();
        this.maxStarsForFeedback = parcel.readInt();
        this.minStarsForStore = parcel.readInt();
        this.resultRecievedAtMillis = parcel.readLong();
    }

    public final boolean m20544a() {
        if (this.delayTillNextPingMillis < -1) {
            return false;
        }
        if (!this.shouldAskUser) {
            return true;
        }
        if (this.delayAskingMillis < 0 || this.maxStarsForFeedback < 0 || this.minStarsForStore < 0) {
            return false;
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.shouldAskUser ? 1 : 0);
        parcel.writeLong(this.delayAskingMillis);
        parcel.writeLong(this.delayTillNextPingMillis);
        parcel.writeInt(this.maxStarsForFeedback);
        parcel.writeInt(this.minStarsForStore);
        parcel.writeLong(this.resultRecievedAtMillis);
    }

    public String toString() {
        return "FetchISRConfigResult:\nShould Ask User: " + this.shouldAskUser + "\nDelay Asking: " + this.delayAskingMillis + "\nDelay till next ping: " + this.delayTillNextPingMillis + "\nMax stars for feedback: " + this.maxStarsForFeedback + "\nMin stars for store: " + this.minStarsForStore + "\nResult recieved at: " + this.resultRecievedAtMillis;
    }
}
