package com.facebook.api.feedcache.memory;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.enums.GraphQLObjectType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: approximate_position */
public class ToggleSaveParams implements Parcelable {
    public static final Creator<ToggleSaveParams> CREATOR = new C09581();
    public final String f8819a;
    public final String f8820b;
    public final String f8821c;
    public final String f8822d;
    public final boolean f8823e;
    public final CurationSurface f8824f;
    public final CurationMechanism f8825g;
    public final GraphQLObjectType f8826h;

    /* compiled from: approximate_position */
    final class C09581 implements Creator<ToggleSaveParams> {
        C09581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ToggleSaveParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ToggleSaveParams[i];
        }
    }

    /* compiled from: approximate_position */
    public class Builder {
        public String f8811a;
        public String f8812b;
        public CurationSurface f8813c;
        public CurationMechanism f8814d;
        public boolean f8815e;
        public GraphQLObjectType f8816f;
        public String f8817g;
        public String f8818h;

        private Builder(String str, String str2, CurationSurface curationSurface, CurationMechanism curationMechanism, boolean z, GraphQLObjectType graphQLObjectType) {
            this.f8817g = null;
            this.f8818h = null;
            this.f8811a = str;
            this.f8812b = str2;
            this.f8814d = curationMechanism;
            this.f8813c = curationSurface;
            this.f8815e = z;
            this.f8816f = graphQLObjectType;
        }
    }

    public ToggleSaveParams(Builder builder) {
        this.f8819a = builder.f8817g;
        this.f8820b = builder.f8811a;
        this.f8821c = builder.f8818h;
        this.f8822d = builder.f8812b;
        this.f8823e = builder.f8815e;
        this.f8824f = builder.f8813c;
        this.f8825g = builder.f8814d;
        this.f8826h = builder.f8816f;
    }

    public ToggleSaveParams(Parcel parcel) {
        this.f8819a = parcel.readString();
        this.f8820b = parcel.readString();
        this.f8821c = parcel.readString();
        this.f8822d = parcel.readString();
        this.f8823e = ParcelUtil.m3827a(parcel);
        this.f8824f = (CurationSurface) parcel.readSerializable();
        this.f8825g = (CurationMechanism) parcel.readSerializable();
        this.f8826h = (GraphQLObjectType) parcel.readParcelable(GraphQLObjectType.class.getClassLoader());
    }

    public static Builder m14705a(String str, String str2, CurationSurface curationSurface, CurationMechanism curationMechanism, boolean z, GraphQLObjectType graphQLObjectType) {
        return new Builder(str, str2, curationSurface, curationMechanism, z, graphQLObjectType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8819a);
        parcel.writeString(this.f8820b);
        parcel.writeString(this.f8821c);
        parcel.writeString(this.f8822d);
        ParcelUtil.m3826a(parcel, this.f8823e);
        parcel.writeSerializable(this.f8824f);
        parcel.writeSerializable(this.f8825g);
        parcel.writeParcelable(this.f8826h, i);
    }
}
