package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLObjectType;

/* compiled from: profilePicture50 */
public class MarkImpressionsLoggedParams implements Parcelable {
    public static final Creator<MarkImpressionsLoggedParams> CREATOR = new C01981();
    public final String f4143a;
    public final GraphQLObjectType f4144b;
    public final int f4145c;

    /* compiled from: profilePicture50 */
    final class C01981 implements Creator<MarkImpressionsLoggedParams> {
        C01981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MarkImpressionsLoggedParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MarkImpressionsLoggedParams[i];
        }
    }

    /* compiled from: profilePicture50 */
    public class Builder {
        public String f4146a;
        public GraphQLObjectType f4147b;
        public int f4148c;
    }

    public MarkImpressionsLoggedParams(String str, GraphQLObjectType graphQLObjectType, int i) {
        this.f4143a = str;
        this.f4144b = graphQLObjectType;
        this.f4145c = i;
    }

    public MarkImpressionsLoggedParams(Parcel parcel) {
        this.f4143a = parcel.readString();
        this.f4144b = (GraphQLObjectType) parcel.readParcelable(GraphQLObjectType.class.getClassLoader());
        this.f4145c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4143a);
        parcel.writeParcelable(this.f4144b, i);
        parcel.writeInt(this.f4145c);
    }
}
