package com.facebook.interstitial.logging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TOPIC_FEEDS */
public class LogInterstitialParams implements Parcelable {
    public static final Creator<LogInterstitialParams> CREATOR = new C13201();
    public final String f13863a;
    public final LogInterstitialEvent f13864b;
    public final ImmutableMap<String, String> f13865c;

    /* compiled from: TOPIC_FEEDS */
    final class C13201 implements Creator<LogInterstitialParams> {
        C13201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LogInterstitialParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LogInterstitialParams[i];
        }
    }

    /* compiled from: TOPIC_FEEDS */
    public enum ActionType {
        PRIMARY,
        SECONDARY
    }

    /* compiled from: TOPIC_FEEDS */
    public enum LogInterstitialEvent {
        IMPRESSION,
        ACTION,
        DISMISSAL,
        RESET_VIEW_STATE
    }

    public LogInterstitialParams(String str, LogInterstitialEvent logInterstitialEvent, ImmutableMap<String, String> immutableMap) {
        this.f13863a = str;
        this.f13864b = logInterstitialEvent;
        this.f13865c = immutableMap;
    }

    public LogInterstitialParams(Parcel parcel) {
        this.f13863a = parcel.readString();
        this.f13864b = LogInterstitialEvent.valueOf(parcel.readString());
        this.f13865c = ImmutableMap.copyOf(parcel.readHashMap(String.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13863a);
        parcel.writeString(this.f13864b.name());
        parcel.writeMap(this.f13865c);
    }
}
