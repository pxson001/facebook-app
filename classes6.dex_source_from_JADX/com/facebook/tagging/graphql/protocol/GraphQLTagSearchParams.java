package com.facebook.tagging.graphql.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: delta_sync */
public class GraphQLTagSearchParams implements Parcelable {
    public static final Creator<GraphQLTagSearchParams> CREATOR = new C12741();
    public final String f17487a;
    public final String f17488b;

    /* compiled from: delta_sync */
    final class C12741 implements Creator<GraphQLTagSearchParams> {
        C12741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTagSearchParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTagSearchParams[i];
        }
    }

    public GraphQLTagSearchParams(Parcel parcel) {
        this.f17487a = parcel.readString();
        this.f17488b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17487a);
        parcel.writeString(this.f17488b);
    }
}
