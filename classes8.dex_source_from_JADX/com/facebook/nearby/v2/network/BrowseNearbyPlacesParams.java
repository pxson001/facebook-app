package com.facebook.nearby.v2.network;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: dev_mode */
public class BrowseNearbyPlacesParams implements Parcelable {
    public static final Creator<BrowseNearbyPlacesParams> CREATOR = new C16801();
    public ImmutableList<Long> f15694a;
    public final float f15695b;
    public final GraphQLGeoRectangle f15696c;
    public final float f15697d;
    public final Location f15698e;
    public final float f15699f;
    public final int f15700g;
    public final float f15701h;
    public final float f15702i;
    public final float f15703j;
    private final float f15704k;

    /* compiled from: dev_mode */
    final class C16801 implements Creator<BrowseNearbyPlacesParams> {
        C16801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BrowseNearbyPlacesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new BrowseNearbyPlacesParams[i];
        }
    }

    /* compiled from: dev_mode */
    public class Builder {
        public GraphQLGeoRectangle f15684a;
        public float f15685b;
        public Location f15686c;
        public int f15687d = 0;
        public float f15688e;
        public float f15689f = 0.0f;
        public float f15690g;
        public float f15691h = 0.0f;
        public ImmutableList<Long> f15692i = RegularImmutableList.a;
        public float f15693j;
    }

    public BrowseNearbyPlacesParams(Builder builder) {
        this.f15696c = builder.f15684a;
        this.f15697d = builder.f15685b;
        this.f15698e = builder.f15686c;
        this.f15700g = builder.f15687d;
        this.f15701h = builder.f15688e;
        this.f15702i = builder.f15689f;
        this.f15703j = builder.f15690g;
        this.f15704k = builder.f15691h;
        this.f15694a = builder.f15692i;
        this.f15695b = builder.f15693j;
        if (builder.f15686c != null) {
            this.f15699f = builder.f15686c.getAccuracy();
        } else {
            this.f15699f = 0.0f;
        }
    }

    public BrowseNearbyPlacesParams(Parcel parcel) {
        this.f15696c = (GraphQLGeoRectangle) FlatBufferModelHelper.a(parcel);
        this.f15697d = parcel.readFloat();
        this.f15698e = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f15699f = parcel.readFloat();
        this.f15700g = parcel.readInt();
        this.f15701h = parcel.readFloat();
        this.f15702i = parcel.readFloat();
        this.f15703j = parcel.readFloat();
        this.f15704k = parcel.readFloat();
        if (parcel.readByte() == (byte) 0) {
            this.f15694a = null;
        } else {
            Collection arrayList = new ArrayList();
            parcel.readList(arrayList, Long.class.getClassLoader());
            this.f15694a = ImmutableListHelper.a(arrayList);
        }
        this.f15695b = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f15696c);
        parcel.writeFloat(this.f15697d);
        parcel.writeParcelable(this.f15698e, i);
        parcel.writeFloat(this.f15699f);
        parcel.writeInt(this.f15700g);
        parcel.writeFloat(this.f15701h);
        parcel.writeFloat(this.f15702i);
        parcel.writeFloat(this.f15703j);
        parcel.writeFloat(this.f15704k);
        if (this.f15694a == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.f15694a);
        }
        parcel.writeFloat(this.f15695b);
    }

    public final ImmutableList<Long> m18412i() {
        return ImmutableList.copyOf(this.f15694a);
    }
}
