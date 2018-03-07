package com.facebook.search.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLPlaceType;

/* compiled from: extra_simple_picker_launcher_settings */
public class GraphSearchQueryPlaceModifier implements Parcelable {
    public static final Creator<GraphSearchQueryPlaceModifier> CREATOR = new C10991();
    private final GraphQLPlaceType f15478a;
    public final String f15479b;

    /* compiled from: extra_simple_picker_launcher_settings */
    final class C10991 implements Creator<GraphSearchQueryPlaceModifier> {
        C10991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphSearchQueryPlaceModifier(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphSearchQueryPlaceModifier[0];
        }
    }

    /* compiled from: extra_simple_picker_launcher_settings */
    public class Builder {
        public GraphQLPlaceType f15476a;
        public String f15477b;

        public final GraphSearchQueryPlaceModifier m23107a() {
            return new GraphSearchQueryPlaceModifier(this);
        }
    }

    public GraphSearchQueryPlaceModifier(Parcel parcel) {
        this.f15478a = (GraphQLPlaceType) parcel.readSerializable();
        this.f15479b = parcel.readString();
    }

    public GraphSearchQueryPlaceModifier(Builder builder) {
        this.f15478a = builder.f15476a;
        this.f15479b = builder.f15477b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f15478a);
        parcel.writeString(this.f15479b);
    }
}
