package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLObjectType;

/* compiled from: attachment_param */
public class SetVideoMuteParams implements Parcelable {
    public static final Creator<SetVideoMuteParams> CREATOR = new C09521();
    public final String f8746a;
    public final GraphQLObjectType f8747b;
    public final boolean f8748c;

    /* compiled from: attachment_param */
    final class C09521 implements Creator<SetVideoMuteParams> {
        C09521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetVideoMuteParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetVideoMuteParams[i];
        }
    }

    public SetVideoMuteParams(Parcel parcel) {
        this.f8746a = parcel.readString();
        this.f8747b = (GraphQLObjectType) parcel.readParcelable(GraphQLObjectType.class.getClassLoader());
        this.f8748c = parcel.readInt() != 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8746a);
        parcel.writeParcelable(this.f8747b, i);
        parcel.writeInt(this.f8748c ? 1 : 0);
    }
}
