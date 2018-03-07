package com.facebook.fbservice.results;

import android.os.Parcel;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;

@AutoGenJsonDeserializer
/* compiled from: saved_button_nux_imp */
public class BaseResult {
    @JsonProperty("clientTimeMs")
    public final long clientTimeMs;
    @JsonProperty("freshness")
    public final DataFreshnessResult freshness;

    private BaseResult() {
        this(null, 0);
    }

    protected BaseResult(DataFreshnessResult dataFreshnessResult, long j) {
        this.freshness = dataFreshnessResult;
        this.clientTimeMs = j;
    }

    protected BaseResult(Parcel parcel) {
        this.freshness = (DataFreshnessResult) parcel.readSerializable();
        this.clientTimeMs = parcel.readLong();
    }

    public final DataFreshnessResult m10404a() {
        return this.freshness;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.freshness);
        parcel.writeLong(this.clientTimeMs);
    }

    public final long m10405b() {
        return this.clientTimeMs;
    }
}
