package com.facebook.reaction.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;

/* compiled from: bootstrap_load_error */
public class ReactionAnalyticsParams implements Parcelable {
    public static final Creator<ReactionAnalyticsParams> CREATOR = new C20771();
    public String f18809a;
    public String f18810b;
    public String f18811c;
    public String f18812d;
    @Nullable
    public Bundle f18813e;

    /* compiled from: bootstrap_load_error */
    final class C20771 implements Creator<ReactionAnalyticsParams> {
        C20771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReactionAnalyticsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReactionAnalyticsParams[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18809a);
        parcel.writeString(this.f18810b);
        parcel.writeString(this.f18811c);
        parcel.writeString(this.f18812d);
        parcel.writeBundle(this.f18813e);
    }

    public ReactionAnalyticsParams(String str, String str2, String str3, String str4, @Nullable Bundle bundle) {
        this.f18809a = str;
        this.f18810b = str2;
        this.f18811c = str3;
        this.f18812d = str4;
        this.f18813e = bundle;
    }

    public ReactionAnalyticsParams(@Nullable ReactionAnalyticsParams reactionAnalyticsParams, String str, String str2, @Nullable Bundle bundle) {
        this.f18809a = reactionAnalyticsParams == null ? "unknown" : reactionAnalyticsParams.f18811c;
        this.f18810b = reactionAnalyticsParams == null ? "unknown" : reactionAnalyticsParams.f18812d;
        this.f18811c = str;
        this.f18812d = str2;
        this.f18813e = bundle;
    }

    public ReactionAnalyticsParams(Parcel parcel) {
        this.f18809a = parcel.readString();
        this.f18810b = parcel.readString();
        this.f18811c = parcel.readString();
        this.f18812d = parcel.readString();
        this.f18813e = parcel.readBundle();
    }
}
