package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLObjectType;

/* compiled from: attachment_properties */
public class SetVideoFirstViewParams implements Parcelable {
    public static final Creator<SetVideoFirstViewParams> CREATOR = new C09511();
    public final String f8743a;
    public final GraphQLObjectType f8744b;
    public final boolean f8745c;

    /* compiled from: attachment_properties */
    final class C09511 implements Creator<SetVideoFirstViewParams> {
        C09511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetVideoFirstViewParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetVideoFirstViewParams[i];
        }
    }

    public SetVideoFirstViewParams(Parcel parcel) {
        this.f8743a = parcel.readString();
        this.f8744b = (GraphQLObjectType) parcel.readParcelable(GraphQLObjectType.class.getClassLoader());
        this.f8745c = parcel.readInt() != 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8743a);
        parcel.writeParcelable(this.f8744b, i);
        parcel.writeInt(this.f8745c ? 1 : 0);
    }
}
