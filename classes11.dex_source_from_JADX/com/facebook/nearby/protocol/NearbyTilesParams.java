package com.facebook.nearby.protocol;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: total_rss_kb_before_fb4a_at_same_priority */
public class NearbyTilesParams implements Parcelable {
    public static final Creator<NearbyTilesParams> CREATOR = new C00821();
    public List<Long> f624a;
    public ImmutableList<String> f625b;
    public float f626c;
    public final GraphQLGeoRectangle f627d;
    public final float f628e;
    public final Location f629f;
    public final float f630g;
    public final int f631h;
    public final float f632i;
    public final float f633j;
    public final float f634k;
    public final float f635l;

    /* compiled from: total_rss_kb_before_fb4a_at_same_priority */
    final class C00821 implements Creator<NearbyTilesParams> {
        C00821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyTilesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyTilesParams[i];
        }
    }

    /* compiled from: total_rss_kb_before_fb4a_at_same_priority */
    public class Builder {
        public GraphQLGeoRectangle f613a;
        public float f614b;
        public Location f615c;
        public int f616d = 0;
        public float f617e;
        public float f618f = 0.0f;
        public float f619g;
        public float f620h = 0.0f;
        public List<Long> f621i = RegularImmutableList.a;
        public ImmutableList<String> f622j = RegularImmutableList.a;
        public float f623k;

        public Builder(float f) {
            this.f614b = f;
        }
    }

    public NearbyTilesParams(Builder builder) {
        this.f627d = builder.f613a;
        this.f628e = builder.f614b;
        this.f629f = builder.f615c;
        this.f632i = builder.f617e;
        this.f634k = builder.f619g;
        this.f626c = builder.f623k;
        this.f624a = builder.f621i;
        this.f631h = builder.f616d;
        this.f633j = builder.f618f;
        this.f635l = builder.f620h;
        this.f625b = builder.f622j;
        if (builder.f615c != null) {
            this.f630g = builder.f615c.getAccuracy();
        } else {
            this.f630g = 0.0f;
        }
    }

    public NearbyTilesParams(Parcel parcel) {
        this.f627d = (GraphQLGeoRectangle) FlatBufferModelHelper.a(parcel);
        this.f628e = parcel.readFloat();
        this.f629f = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f630g = parcel.readFloat();
        this.f631h = parcel.readInt();
        this.f632i = parcel.readFloat();
        this.f633j = parcel.readFloat();
        this.f634k = parcel.readFloat();
        this.f635l = parcel.readFloat();
        this.f624a = ImmutableListHelper.a(parcel.readArrayList(Long.class.getClassLoader()));
        this.f625b = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f626c = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f627d);
        parcel.writeFloat(this.f628e);
        parcel.writeParcelable(this.f629f, i);
        parcel.writeFloat(this.f630g);
        parcel.writeInt(this.f631h);
        parcel.writeFloat(this.f632i);
        parcel.writeFloat(this.f633j);
        parcel.writeFloat(this.f634k);
        parcel.writeFloat(this.f635l);
        parcel.writeList(this.f624a);
        parcel.writeList(this.f625b);
        parcel.writeFloat(this.f626c);
    }

    public final GraphQLGeoRectangle m885a() {
        return this.f627d;
    }

    public final float m886b() {
        return this.f628e;
    }

    public final List<Long> m887j() {
        return this.f624a;
    }

    public final List<String> m888k() {
        return this.f625b;
    }
}
