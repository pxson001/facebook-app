package com.facebook.interstitial.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.ipc.model.NuxStep;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = InterstitialNUXFetchResultDeserializer.class)
@Immutable
/* compiled from: TOPIC_HOME_DECOR */
public class InterstitialNUXFetchResult implements Parcelable {
    public static final Creator<InterstitialNUXFetchResult> CREATOR = new C13191();
    @JsonProperty("extra_data")
    public final Map<String, String> extraData;
    @JsonProperty("steps")
    public final List<NuxStep> steps;

    /* compiled from: TOPIC_HOME_DECOR */
    final class C13191 implements Creator<InterstitialNUXFetchResult> {
        C13191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new InterstitialNUXFetchResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new InterstitialNUXFetchResult[i];
        }
    }

    public InterstitialNUXFetchResult() {
        this.steps = null;
        this.extraData = null;
    }

    public InterstitialNUXFetchResult(Parcel parcel) {
        this.steps = ImmutableList.copyOf(parcel.readArrayList(NuxStep.class.getClassLoader()));
        this.extraData = Maps.c();
        parcel.readMap(this.extraData, Map.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.steps);
        parcel.writeMap(this.extraData);
    }
}
