package com.facebook.search.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;

/* compiled from: TOGGLE_TV_AIRING_REMINDER */
public class ReactionSearchData implements Parcelable {
    public static final Creator<ReactionSearchData> CREATOR = new C23701();
    public final String f22246a;
    public final String f22247b;
    public final String f22248c;
    public final String f22249d;
    public final Surface f22250e;

    /* compiled from: TOGGLE_TV_AIRING_REMINDER */
    final class C23701 implements Creator<ReactionSearchData> {
        C23701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReactionSearchData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Surface) parcel.readSerializable());
        }

        public final Object[] newArray(int i) {
            return new ReactionSearchData[0];
        }
    }

    public static ReactionSearchData m25723a(Bundle bundle) {
        return new ReactionSearchData(bundle.getString("place_id"), bundle.getString("ranking_data"), bundle.getString("semantic"), bundle.getString("reaction_session_id"), (Surface) bundle.get("reaction_surface"));
    }

    public ReactionSearchData(String str, String str2, String str3, String str4, Surface surface) {
        this.f22246a = str;
        this.f22247b = str2;
        this.f22248c = str3;
        this.f22249d = str4;
        this.f22250e = surface;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22246a);
        parcel.writeString(this.f22247b);
        parcel.writeString(this.f22248c);
        parcel.writeString(this.f22249d);
        parcel.writeSerializable(this.f22250e);
    }
}
