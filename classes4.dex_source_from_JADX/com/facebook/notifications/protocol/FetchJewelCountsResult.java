package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Map;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FetchJewelCountsResultDeserializer.class)
@JsonIgnoreProperties(b = true)
/* compiled from: lastMqttDisconnect */
public class FetchJewelCountsResult implements Parcelable {
    public static final Creator<FetchJewelCountsResult> CREATOR = new C04341();
    @JsonProperty("messages")
    private final Map<String, Long> mMessagesCounts;
    @JsonProperty("notification_counts")
    private final Map<String, Long> mNotificationsCounts;
    @JsonProperty("friend_requests_counts")
    private final Map<String, Long> mRequestsCounts;

    /* compiled from: lastMqttDisconnect */
    final class C04341 implements Creator<FetchJewelCountsResult> {
        C04341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchJewelCountsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchJewelCountsResult[i];
        }
    }

    public FetchJewelCountsResult() {
        this.mMessagesCounts = RegularImmutableBiMap.a;
        this.mNotificationsCounts = RegularImmutableBiMap.a;
        this.mRequestsCounts = RegularImmutableBiMap.a;
    }

    public FetchJewelCountsResult(Parcel parcel) {
        this.mMessagesCounts = parcel.readHashMap(getClass().getClassLoader());
        this.mNotificationsCounts = parcel.readHashMap(getClass().getClassLoader());
        this.mRequestsCounts = parcel.readHashMap(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.mMessagesCounts);
        parcel.writeMap(this.mNotificationsCounts);
        parcel.writeMap(this.mRequestsCounts);
    }

    public final int m9999a() {
        return ((Long) m9998a(this.mRequestsCounts, "unseen", Long.valueOf(0))).intValue();
    }

    public final int m10000b() {
        return ((Long) m9998a(this.mMessagesCounts, "unseen", Long.valueOf(0))).intValue();
    }

    public final int m10001c() {
        return ((Long) m9998a(this.mMessagesCounts, "unread", Long.valueOf(0))).intValue();
    }

    public final int m10002d() {
        return ((Long) m9998a(this.mMessagesCounts, "recent_unread", Long.valueOf(0))).intValue();
    }

    private static <K, V> V m9998a(Map<K, V> map, K k, V v) {
        V v2 = map.get(k);
        if (v2 != null) {
            return v2;
        }
        return v;
    }
}
